package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.ReservationInquiry;

public class ReservationInquiryDao extends AbstractDao {
	
	private static ReservationInquiryDao instance = new ReservationInquiryDao();
	
	private ReservationInquiryDao(){
		
	}
	
	public static ReservationInquiryDao getInstance() {
	return instance;	
	}

	public List<ReservationInquiry> findAll() {

		Session session = this.session();
		List<ReservationInquiry> listReservationInquiry = new ArrayList<ReservationInquiry>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + ReservationInquiry.class.getName() + " s";
			Query<ReservationInquiry> query = session.createQuery(sql, ReservationInquiry.class);
			listReservationInquiry = query.getResultList();
			session.getTransaction().commit();
			
   
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listReservationInquiry;
	}

	public ReservationInquiry getReservationInquiryById(Long idInquiry) {

		Session session = this.session();
		ReservationInquiry infoReservationInquiry = new ReservationInquiry();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + ReservationInquiry.class.getName() + " s"//									
					+ " WHERE s.idInquiry= :idInquiry ";
			
			Query<ReservationInquiry> query = session.createQuery(sql, ReservationInquiry.class);
			query.setParameter("idInquiry", idInquiry);
			infoReservationInquiry = query.getSingleResult(); 			
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoReservationInquiry;
	}
	
	public List<ReservationInquiry> findReservationInquiryByIdTopo(Integer idTopo) {

		Session session = this.session();
		List<ReservationInquiry> listReservationInquiry = new ArrayList<ReservationInquiry>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + ReservationInquiry.class.getName() + " s"//
					+ " WHERE s.topo.idTopo= :idTopo ";		
						
			Query<ReservationInquiry> query = session.createQuery(sql, ReservationInquiry.class);
			query.setParameter("idTopo", idTopo);	
			listReservationInquiry = query.getResultList(); 
			session.getTransaction().commit();
		

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listReservationInquiry;
	}
	
	public List<ReservationInquiry> findReservationInquiryByIdUser(Integer idUser) {

		Session session = this.session();
		List<ReservationInquiry> listReservationInquiry = new ArrayList<ReservationInquiry>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + ReservationInquiry.class.getName() + " s"//
					+ " WHERE s.user.idUser= :idUser ";		
						
			Query<ReservationInquiry> query = session.createQuery(sql, ReservationInquiry.class);
			query.setParameter("idUser", idUser);	
			listReservationInquiry = query.getResultList(); 
			session.getTransaction().commit();
		

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return listReservationInquiry;
	}
	
	public void saveOrUpdateReservationInquiry(ReservationInquiry reservationInquiry) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(reservationInquiry);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}

