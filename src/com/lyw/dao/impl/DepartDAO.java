package com.lyw.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lyw.dao.IDepartDAO;
import com.lyw.entity.Depart;

public class DepartDAO extends HibernateDaoSupport implements IDepartDAO {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Depart> queryAll() {
		return super.getHibernateTemplate().find("from Depart");
	}

	@Override
	public List<Depart> query(Depart depart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Depart queryById(int departId) {
		return super.getHibernateTemplate().get(Depart.class, departId);
	}

}
