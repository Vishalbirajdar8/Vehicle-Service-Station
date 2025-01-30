package com.entity;

public class OilService  extends Service 
{
	private static final long serialVersionUID = 1L;
	private double cost;
	public OilService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OilService(String description,double cost) {
		super(description);
		this.cost = cost;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public double price() {
		return this.cost;
	}
	@Override
	public String toString() {
//		return "OilService [cost=" + cost + "]" + super.toString();
		return  super.toString();
	}
}
