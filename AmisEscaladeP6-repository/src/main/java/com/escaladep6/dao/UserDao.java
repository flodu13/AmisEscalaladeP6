package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.ReservationInquiry;
import com.escaladep6.entities.User;

public class UserDao extends AbstractDao {

	private static UserDao instance = new UserDao();

	private UserDao() {
	}

	public static UserDao getInstance() {
		return instance;
	}

	public List<User> findAll() {

		Session session = this.session();
		List<User> listUser = new ArrayList<User>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + User.class.getName() + " s";
			Query<User> query = session.createQuery(sql, User.class);
			listUser = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listUser;
	}

	public User getUser(Integer idUser) {

		Session session = this.session();
		User infoUser = new User();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + User.class.getName() + " s"//
					+ " JOIN FETCH s.topos topo"
					+ " WHERE s.idUser= :idUser ";
			String sql2 = "SELECT c FROM " + ReservationInquiry.class.getName() + " c"
					+ " WHERE c.reservationinquiry.idUser= :idUser ";
			

			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter("idUser", idUser);
			infoUser = query.getSingleResult();
			Query<ReservationInquiry> query2 = session.createQuery(sql2, ReservationInquiry.class);
			query2.setParameter("idUser", idUser);
			List<ReservationInquiry> listReservation = query2.getResultList();
			infoUser.setReservationInquiries(listReservation);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoUser;
	}

	public User getUser(String login) {

		Session session = this.session();
		User infoUser = null;

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + User.class.getName() + " s"//
					+ " WHERE s.login= :login";

			Query<User> query = session.createQuery(sql, User.class);
			query.setParameter("login", login);		
			infoUser = query.getSingleResult();	
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoUser;
	}

	public void saveOrUpdateUser(User user) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
