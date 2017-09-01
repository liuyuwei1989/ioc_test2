package com.lyw.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lyw.dao.HibernateSessionFactory;
import com.lyw.dao.IUserDAO;
import com.lyw.entity.Employee;

public class UserDAO implements IUserDAO {

	@Override
	public void insert(Employee emp) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = session.beginTransaction();
		session.save(emp);
		tr.commit();
		session.close();
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> query(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
