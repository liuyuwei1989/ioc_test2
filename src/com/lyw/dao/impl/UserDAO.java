package com.lyw.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lyw.dao.IUserDAO;
import com.lyw.entity.Employee;
import com.lyw.utils.PagingUtils;

public class UserDAO extends HibernateDaoSupport implements IUserDAO {

	@Override
	public void insert(Employee emp) {
		super.getHibernateTemplate().save(emp);
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
//		Session session = super.getSession();
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		int page = pagingUtils.getPage();
		int rowsPerPage = pagingUtils.getRowsPerPage();
//		int totalRows = (Integer)session.createQuery("select count(*) from Employee").uniqueResult();
		int totalRows = super.getHibernateTemplate().find("from Employee").size();
		pagingUtils.setTotalRows(totalRows);
		pagingUtils.setUserList(super.getHibernateTemplate().findByCriteria(criteria, rowsPerPage*(page-1), rowsPerPage));
//		pagingUtils.setUserList(session.createCriteria(Employee.class).setFirstResult(rowsPerPage*(page-1)).setMaxResults(rowsPerPage).list());
	}

	@Override
	public Employee queryById(int id) {
		return super.getHibernateTemplate().get(Employee.class, id);
	}

}
