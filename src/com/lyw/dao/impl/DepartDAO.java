package com.lyw.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.lyw.dao.HibernateSessionFactory;
import com.lyw.dao.IDepartDAO;
import com.lyw.entity.Depart;

public class DepartDAO implements IDepartDAO {

	@Override
	public void update(Depart depart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Depart depart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Depart depart) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Depart> queryAll() {
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Depart> list = session.createCriteria(Depart.class).list();
		session.close();
		return list;
	}

	@Override
	public List<Depart> query(Depart depart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Depart queryById(int departId) {
		Session session = HibernateSessionFactory.getSession();
		Depart depart = (Depart)session.createQuery("from Depart where id=?").setInteger(0, departId).uniqueResult();
		session.close();
		return depart;
	}

}
