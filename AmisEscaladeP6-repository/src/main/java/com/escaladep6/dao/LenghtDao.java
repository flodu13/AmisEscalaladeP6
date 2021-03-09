package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Lenght;

public class LenghtDao extends AbstractDao {
	
private static LenghtDao instance = new LenghtDao();
	
	private LenghtDao(){
		
	}
	
	public static LenghtDao getInstance() {
	return instance;	
	}

	public List<Lenght> findAll() {

		Session session = this.session();
		List<Lenght> listLenght = new ArrayList<Lenght>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Lenght.class.getName() + " s";
			Query<Lenght> query = session.createQuery(sql, Lenght.class);
			listLenght = query.getResultList();	
			session.getTransaction().commit();
   
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listLenght;
	}

	public Lenght getLenght(Long idLenght) {

		Session session = this.session();
		Lenght infoLenght = new Lenght();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Lenght.class.getName() + " s"//
					+ " WHERE s.idLenght= :idLenght ";
			
			Query<Lenght> query = session.createQuery(sql, Lenght.class);
			query.setParameter("idLenght", idLenght);
			infoLenght = query.getSingleResult();   
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoLenght;
	}	
	
	public void saveOrUpdateLenght(Lenght lenght) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(lenght);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
