package com.lyw.dao;

import java.util.List;

import com.lyw.entity.Depart;

public interface IDepartDAO {
	void update(Depart depart);
	void insert(Depart depart);
	void delete(Depart depart);
	List<Depart> query(Depart depart);
	List<Depart> queryAll();
	Depart queryById(int departId); 
}
