package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Role;

public class RoleDao extends AbstractDao {
	
	private static RoleDao instance = new RoleDao();

	private RoleDao() {
	}

	public static RoleDao getInstance() {
		return instance;
	}

	public List<Role> findAll() {

		Session session = this.session();
		List<Role> listRole = new ArrayList<Role>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Role.class.getName() + " s";
			Query<Role> query = session.createQuery(sql, Role.class);
			listRole = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listRole;
	}

	public Role getRole(Integer code) {

		Session session = this.session();
		Role infoRole = new Role();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Role.class.getName() + " s"//
					+ " JOIN FETCH s.users user"
					+ " WHERE s.code= :code ";


			Query<Role> query = session.createQuery(sql, Role.class);
			query.setParameter("idRole", code);
			infoRole = query.getSingleResult();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoRole;
	}
	

	public void saveOrUpdateRole(Role role) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(role);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
