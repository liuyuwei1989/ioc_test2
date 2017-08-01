package com.lyw.biz;

import com.lyw.entity.Employee;
import com.lyw.utils.PagingUtils;

public interface IUserBiz {
	void register(Employee emp);

	void queryByPage(PagingUtils pagingUtils);
}
