package com.lyw.biz.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyw.biz.IDepartBiz;
import com.lyw.dao.IDepartDAO;
import com.lyw.entity.Depart;

public class DepartBiz implements IDepartBiz {

	
	//用于反转
	private IDepartDAO departDAO = null; 
	@Override
	public List<Depart> queryAll() {
		return departDAO.queryAll();
	}
	public void setDepartDAO(IDepartDAO departDAO) {
		this.departDAO = departDAO;
	}
	


}
