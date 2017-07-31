package com.lyw.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Depart entity. @author MyEclipse Persistence Tools
 */

public class Depart implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Depart() {
	}

	/** full constructor */
	public Depart(String name, Integer count, Set employees) {
		this.name = name;
		this.count = count;
		this.employees = employees;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}