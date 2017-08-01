package com.lyw.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lyw.dao.HibernateSessionFactory;
import com.lyw.dao.IUserDAO;
import com.lyw.entity.Employee;
import com.lyw.utils.PagingUtils;

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

	@SuppressWarnings("unchecked")
	@Override
	public void queryByPage(PagingUtils pagingUtils) {
		Session session = HibernateSessionFactory.getSession();
		int page = pagingUtils.getPage();
		int rowsPerPage = pagingUtils.getRowsPerPage();
		int totalRows = (Integer)session.createQuery("select count(*) from Employee").uniqueResult();
		pagingUtils.setTotalRows(totalRows);
		pagingUtils.setUserList(session.createCriteria(Employee.class).setFirstResult(rowsPerPage*(page-1)).setMaxResults(rowsPerPage).list());
	}

}
