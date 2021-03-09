package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Comment;
import com.escaladep6.entities.Spot;

public class SpotDao extends AbstractDao {
	
	private static SpotDao instance = new SpotDao();
	
	private SpotDao(){
		
	}
	
	public static SpotDao getInstance() {
	return instance;	
	}

	public List<Spot> findAll() {

		Session session = this.session();
		List<Spot> listSpot = new ArrayList<Spot>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Spot.class.getName() + " s";
			Query<Spot> query = session.createQuery(sql, Spot.class);
			listSpot = query.getResultList();
			session.getTransaction().commit();
			
   
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listSpot;
	}

	public Spot getSpot(int idSpot) {

		Session session = this.session();
		Spot infoSpot = new Spot();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Spot.class.getName() + " s"//
					+ " LEFT JOIN FETCH s.sectors sector"				
					+ " WHERE s.idSpot= :idSpot ";
			String sql2 = "SELECT c FROM " + Comment.class.getName() + " c"
					+ " WHERE c.spot.idSpot= :idSpot ";
			
			Query<Spot> query = session.createQuery(sql, Spot.class);
			query.setParameter("idSpot", idSpot);
			infoSpot = query.getSingleResult();  
			Query<Comment> query2 = session.createQuery(sql2, Comment.class);
			query2.setParameter("idSpot", idSpot);
			List<Comment> listComment = query2.getResultList();
			infoSpot.setComments(listComment);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoSpot;
	}
	
	public List<Spot> findSpots(String region, String difficult, String name) {

		Session session = this.session();
		List<Spot> listSpot = new ArrayList<Spot>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Spot.class.getName() + " s"//
					+ " WHERE 1=1 ";
			Map <String, String> parameters = new HashMap<>();
			
			if (!region.equals("")) {
				 sql = sql + "  AND s.address.region= :region";
				 parameters.put("region", region);
			 }
			
			if (!difficult.equals("")) {
				 sql = sql + "  AND s.difficultLevel= :difficult";
				 parameters.put("difficult", difficult);
			 }
		
			if (!name.equals("")) {
				 sql = sql + "  AND UPPER(s.name) like UPPER(:name)";
				 parameters.put("name", "%"+name+"%");
			 }		
				
			Query<Spot> query = session.createQuery(sql, Spot.class);
			parameters.forEach((k, v) -> query.setParameter(k, v));			
			listSpot = query.getResultList(); 
			session.getTransaction().commit();
		

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listSpot;
	}
	
	public void saveOrUpdateSpot(Spot spot) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(spot);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
