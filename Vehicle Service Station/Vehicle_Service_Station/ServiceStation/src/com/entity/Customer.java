package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Customer implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneno;
	private String address;
	private HashMap<String,Vehicle> vehList;
	private double last_balance;

	public Customer() {
		super();
		this.vehList = new HashMap<>();

	}
	public Customer(String name, String phoneno, String address) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.address = address;
	
	}
	public double getLast_balance() {
		return last_balance;
	}
	public void setLast_bill(double last_balance) {
		this.last_balance = last_balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Collection<Vehicle> getVehList() {
		return  vehList.values();
	}
	public void setVehList(HashMap<String, Vehicle> vehList) {
		this.vehList = vehList;
	}
	@Override
	public String toString() 
	{
		return "Customer [name=" + name + ", phoneno=" + phoneno + ", address=" + address + ", vehList=" + vehList
				+ "]";
	}



	public void newVahicle(Vehicle veh) {
		this.vehList.put(veh.getNumberPlate(),veh);
		
	}



	public Vehicle getVehicle(String input) {
		return this.vehList.get(input);
	}
	public double bill_tobePaid(double paidAmount, Bill bill) {
		
	  double cust_totalBill=bill.finalBill();
	  double balance=cust_totalBill-paidAmount;
	  if(balance>0.0)
	  {
		  this.last_balance=balance;
		  bill.setPaidAmount(paidAmount);		  
	  }
	  else
	  {
		  this.last_balance=0.0;
		  bill.setPaidAmount(cust_totalBill);
	  }
	return balance;
	}
	
	
	
	
}
