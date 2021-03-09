package com.escaladep6.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.escaladep6.entities.Address;

public class AddressDao extends AbstractDao {

	private static AddressDao instance = new AddressDao();

	private AddressDao() {
	}

	public static AddressDao getInstance() {
		return instance;
	}

	public List<Address> findAll() {

		Session session = this.session();
		List<Address> listAddress = new ArrayList<Address>();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Address.class.getName() + " s";
			Query<Address> query = session.createQuery(sql, Address.class);
			listAddress = query.getResultList();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		return listAddress;
	}

	public Address getAddress(int idAddress) {

		Session session = this.session();
		Address infoAddress = new Address();

		try {
			session.getTransaction().begin();
			String sql = "SELECT s FROM " + Address.class.getName() + " s"//
					+ " WHERE s.idAddress= :idAddress ";

			Query<Address> query = session.createQuery(sql, Address.class);
			query.setParameter("idAddress", idAddress);
			infoAddress = query.getSingleResult();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return infoAddress;
	}

	public void saveOrUpdateUser(Address address) {

		Session session = this.session();

		try {
			session.getTransaction().begin();
			session.saveOrUpdate(address);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

}
