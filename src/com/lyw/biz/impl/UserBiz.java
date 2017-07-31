package com.lyw.biz.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyw.biz.IUserBiz;
import com.lyw.dao.IUserDAO;
import com.lyw.entity.Employee;

public class UserBiz implements IUserBiz {

	private IUserDAO userDAO = null;
	/**
	 * 用于注册的biz方法
	 */
	@Override
	public void register(Employee emp) {
		userDAO.insert(emp);
	}
	
	
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		userDAO = (IUserDAO)context.getBean("userDAO");
		userDAO.insert(new Employee());
	}
	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
