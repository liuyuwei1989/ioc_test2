package com.lyw.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyw.biz.IDepartBiz;
import com.lyw.biz.IUserBiz;
import com.lyw.entity.Depart;
import com.lyw.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Employee> {

	
	private Employee employee;
	
	private List<Depart> departList;
	/**
	 * 用于注册的方法
	 * @return
	 */
	public String register(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userBiz=(IUserBiz)context.getBean("userBiz");
		userBiz.register(employee);
		return "register";
	}
	
	public String toAddUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		departBiz=(IDepartBiz)context.getBean("departBiz");
		departList=departBiz.queryAll();
		return "toAddUser";
	}
	//用于控制反转赋值。
	private IUserBiz userBiz = null;
	
	private IDepartBiz departBiz= null;
	
	public void setUserBiz(IUserBiz userBiz) {
			this.userBiz = userBiz;
	}


	public void setDepartBiz(IDepartBiz departBiz) {
		this.departBiz = departBiz;
	}
	
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}




	public List<Depart> getDepartList() {
		return departList;
	}




	public void setDepartList(List<Depart> departList) {
		this.departList = departList;
	}

	
}
