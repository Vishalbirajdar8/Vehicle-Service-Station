package com.entity;

import java.io.Serializable;

public class SparePart implements Serializable
{
	private static final long serialVersionUID = 1L;
    private String desc;
    private double price;
      
	public SparePart() {
		super();
	}
	public SparePart(String desc, double price) {
		super();
		this.desc = desc;
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return " Part = " + desc + ", Price=" + price;
	}
      
}
