package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Path;

public class PathDao extends AbstractDao {
	
private static PathDao instance = new PathDao();
	
	private PathDao(){
		
	}
	
	public static PathDao getInstance() {
	return instance;	
	}

	public List<Path> findAll() {

		Session session = this.session();
		List<Path> listPath = new ArrayList<Path>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Path.class.getName() + " s";
			Query<Path> query = session.createQuery(sql, Path.class);
			listPath = query.getResultList();	
			session.getTransaction().commit();
   
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listPath;
	}

	public Path getPath(Long idPath) {

		Session session = this.session();
		Path infoPath = new Path();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Path.class.getName() + " s"//
					+ " WHERE s.idPath= :idPath ";
			
			Query<Path> query = session.createQuery(sql, Path.class);
			query.setParameter("idPath", idPath);
			infoPath = query.getSingleResult();    
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoPath;
	}	
	
	public void saveOrUpdatePath(Path path) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(path);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}


}
