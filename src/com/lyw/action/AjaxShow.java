package com.lyw.action;

import com.lyw.biz.IUserBiz;
import com.lyw.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AjaxShow extends ActionSupport implements ModelDriven<Employee>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Employee user;
	
	private String msg;
	
	private IUserBiz userBiz;
	
	public String showMsg(){
		this.setMsg("Hi,I'm JQuery Ajax");
		return "msg";
	}

	public String queryUser(){
		user=userBiz.queryById(user.getId());
		return "user";
	}
	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public Employee getModel() {
		return getUser();
	}

	/**
	 * @return the user
	 */
	public Employee getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Employee user) {
		this.user = user;
	}

	/**
	 * @param userBiz the userBiz to set
	 */
	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
