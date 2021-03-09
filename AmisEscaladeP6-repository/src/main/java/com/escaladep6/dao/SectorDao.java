package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Sector;

public class SectorDao extends AbstractDao {

	private static SectorDao instance = new SectorDao();

	private SectorDao() {
	}

	public static SectorDao getInstance() {
		return instance;
	}

	public List<Sector> findAll() {

		Session session = this.session();
		List<Sector> listSector = new ArrayList<Sector>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Sector.class.getName() + " s";
			Query<Sector> query = session.createQuery(sql, Sector.class);
			listSector = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listSector;
	}

	public Sector getSector(Long idSector) {

		Session session = this.session();
		Sector infoSector = new Sector();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Sector.class.getName() + " s"//
					+ " LEFT JOIN FETCH s.paths path" + " WHERE s.idSector= :idSector ";
			Query<Sector> query = session.createQuery(sql, Sector.class);
			query.setParameter("idSector", idSector);
			infoSector = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoSector;
	}

	public void saveOrUpdateSector(Sector sector) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(sector);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
