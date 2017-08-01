package com.lyw.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyw.biz.IDepartBiz;
import com.lyw.biz.IUserBiz;
import com.lyw.entity.Depart;
import com.lyw.entity.Employee;
import com.lyw.utils.PagingUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Employee> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Employee employee = new Employee();
	
	private List<Depart> departList;
	//用于分页及查询操作
	private PagingUtils pagingUtils = new PagingUtils();
	
	private int departId;
	
	private File image;
	
    private String imageFileName; //文件名称
    
    private String imageContentType; //文件类型
	/**
	 * 用于注册的方法
	 * @return
	 */
	public String register(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userBiz=(IUserBiz)context.getBean("userBiz");
//		departBiz=(IDepartBiz)context.getBean("departBiz");
		employee.setDepart(departBiz.queryById(departId));
		Timestamp addTime = new Timestamp(System.currentTimeMillis());
		addTime.setNanos(0);
		employee.setAddTime(addTime);
		String photo = System.currentTimeMillis()+"rd"+Math.random()+imageFileName.substring(imageFileName.lastIndexOf("."));
		String realPath = ServletActionContext.getServletContext().getRealPath("/images");
		employee.setPhoto(photo);
		File dst = new File(realPath+File.separator+photo);
		try{
			userBiz.register(employee);
			FileUtils.copyFile(image, dst);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
		return "register";
	}
	/**
	 * 用于在添加用户的页面上，将部门信息显示出来
	 * @return
	 */
	public String toAddUser(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		departBiz=(IDepartBiz)context.getBean("departBiz");
		departList=departBiz.queryAll();
		return "toAddUser";
	}
	/**
	 * 分页查询
	 * @return
	 */
	public String queryByPage(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userBiz=(IUserBiz) context.getBean("userBiz");
		userBiz.queryByPage(pagingUtils);
		return "queryByPage";
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
		return employee;
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

	/**
	 * @return the image
	 */
	public File getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(File image) {
		this.image = image;
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the imageContentType
	 */
	public String getImageContentType() {
		return imageContentType;
	}

	/**
	 * @param imageContentType the imageContentType to set
	 */
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	/**
	 * @return the departId
	 */
	public int getDepartId() {
		return departId;
	}
	/**
	 * @param departId the departId to set
	 */
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	/**
	 * @return the pagingUtils
	 */
	public PagingUtils getPagingUtils() {
		return pagingUtils;
	}
	/**
	 * @param pagingUtils the pagingUtils to set
	 */
	public void setPagingUtils(PagingUtils pagingUtils) {
		this.pagingUtils = pagingUtils;
	}

	
}
