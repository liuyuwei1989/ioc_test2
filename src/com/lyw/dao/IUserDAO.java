package com.lyw.dao;

import com.lyw.entity.Employee;
import com.lyw.utils.PagingUtils;

public interface IUserDAO {
	void insert(Employee emp);
	void update(Employee emp);
	void delete(Employee emp);
	void queryByPage(PagingUtils pagingUtils);
}
