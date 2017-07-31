package com.lyw.dao;

import java.util.List;

import com.lyw.entity.Employee;

public interface IUserDAO {
	void insert(Employee emp);
	void update(Employee emp);
	void delete(Employee emp);
	List<Employee> query(Employee emp);
}
