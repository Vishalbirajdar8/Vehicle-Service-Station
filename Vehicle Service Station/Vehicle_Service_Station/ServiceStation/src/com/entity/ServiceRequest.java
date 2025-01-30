package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String customerNo;
	private String vehicleNO;
	
	ArrayList<Service> serviceList = new ArrayList<>();

	public ServiceRequest() {
		super();
		this.serviceList= new ArrayList<>();
	}

	public ServiceRequest(String customerNo, String vehicleNO) {
		super();
		this.customerNo = customerNo;
		this.vehicleNO = vehicleNO;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getVehicleNO() {
		return vehicleNO;
	}

	public void setVehicleNO(String vehicleNO) {
		this.vehicleNO = vehicleNO;
	}

	public List<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(ArrayList<Service> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public String toString() {
		return "ServiceRequest [customerNo=" + customerNo + ", vehicleNO=" + vehicleNO + ", serviceList=" + serviceList
				+ "]";
	}

	public void newService(Service ser) {
		System.out.println("***********************");
		this.serviceList.add(ser);		
	}
	public  void display() {
		for(Service s: serviceList)
			System.out.println(s);
	}
}
