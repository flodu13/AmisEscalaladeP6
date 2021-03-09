package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Topo;

public class TopoDao extends AbstractDao {
	
	private static TopoDao instance = new TopoDao();

	private TopoDao() {
	}

	public static TopoDao getInstance() {
		return instance;
	}

	public List<Topo> findAll() {

		Session session = this.session();
		List<Topo> listTopo = new ArrayList<Topo>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Topo.class.getName() + " s";
			Query<Topo> query = session.createQuery(sql, Topo.class);
			listTopo = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listTopo;
	}

	public Topo getTopoById(Integer idTopo) {

		Session session = this.session();
		Topo infoTopo = new Topo();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Topo.class.getName() + " s"//
					+ " WHERE s.idTopo= :idTopo ";

			Query<Topo> query = session.createQuery(sql, Topo.class);
			query.setParameter("idTopo", idTopo);
			infoTopo = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoTopo;
	}

	public List<Topo> getTopoByUser(Integer idUser) {

		Session session = this.session();
		List<Topo> infoTopos = new ArrayList<Topo>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Topo.class.getName() + " s"//
					+ " WHERE s.user.idUser= :idUser";

			Query<Topo> query = session.createQuery(sql, Topo.class);
			query.setParameter("idUser", idUser);		
			infoTopos = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoTopos;
	}
	
	public List<Topo> findTopos(String location, String name, Boolean available) {

		Session session = this.session();
		List<Topo> listTopo = new ArrayList<Topo>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Topo.class.getName() + " s"//
					+ " WHERE 1=1 ";
			Map <String, Object> parameters = new HashMap<>();
			
			if (location!= null && !location.equals("")) {
				 sql = sql + "  AND s.location= :location";
				 parameters.put("location", location);
			 }	
			if (available) {
				 sql = sql + "  AND s.available= :available";
				 parameters.put("available", available);
			 }	
			 
			 
			if (name != null && !name.equals("")) {
				 sql = sql + "  AND UPPER(s.name) like UPPER(:name)";
				 parameters.put("name", "%"+name+"%");
			 }		
				
			Query<Topo> query = session.createQuery(sql, Topo.class);
			parameters.forEach((k, v) -> query.setParameter(k, v));			
			listTopo = query.getResultList(); 
			session.getTransaction().commit();
		

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listTopo;
	}

	public void saveOrUpdateTopo(Topo topo) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(topo);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}


}
