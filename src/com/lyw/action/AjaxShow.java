package com.lyw.action;

import org.apache.struts2.json.JSONInterceptor;

import com.lyw.biz.IUserBiz;
import com.lyw.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


public class AjaxShow extends ActionSupport implements ModelDriven<Employee>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String json; 
	
	private Employee user;
	
	private String msg;
	
	private IUserBiz userBiz;
	
	public String showMsg(){
		this.setMsg("Hi,I'm JQuery Ajax");
		return "msg";
	}

	public String queryUser(){
		user=userBiz.queryById(user.getId());
		user.getDepart().setEmployees(null);
//		JSONObject jsonObject = JSONObject.fromObject(user);
//		this.json=jsonObject.toString();
//		System.out.println(json);
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
