package com.entity;

import java.io.Serializable;

public abstract class Service implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String  description;
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(String description) {
		super();
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public abstract double price();
	@Override
	public String toString() {
		return  description + " - " + price();
	}
}
