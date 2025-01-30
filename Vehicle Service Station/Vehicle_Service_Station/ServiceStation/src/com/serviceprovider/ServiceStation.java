package com.serviceprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import com.entity.Bill;
import com.entity.Customer;
import com.entity.ServiceRequest;
import com.tester.Tester;

public class ServiceStation 
{
	public static ServiceStation station = new ServiceStation();
	private HashSet<Customer> custList; //method for HashSet
	//create bill list to store total bills per day
	private ArrayList<Bill> billList;
    public static String stationName= "Vehicle Service Station";
    public ServiceStation() 			//parameterless constructor 
    {
    	super();
		custList=new HashSet<>();        //HashSet assign to custList
		this.billList=new ArrayList<>();
    }
	public ServiceStation(HashSet<Customer> custList)  //parameterized
	{
		super();
		this.custList = custList;			//custList
	   
	}
	
	public HashSet<Customer> getCustList() 
	{
		return custList;
	}
	public ArrayList<Bill> getBillList() {
		return billList;
	}
	public void setBillList(ArrayList<Bill> billList) {
		this.billList = billList;
	}
	public void setCustList(HashSet<Customer> custList) 
	{
		this.custList = custList;
	}
	@Override
	public String toString() 
	{
		return "ServiceStation [custList=" + custList + "]";
	}
	public void newCustomer(Customer cust)    //to add cust into custList
	{
		this.custList.add(cust);
	}
	/*
	 * write findCust to serach cust is present  or not
	 if cust is present then return cust if not return null
	 */
	public Customer FindCustomer(String phoneno)	
	{
		for(Customer c1:this.custList)   //Customer=type, c1 fetching element from custList
		{
//			System.out.println(c1.getPhoneno() +" "+ phoneno);
			if(c1.getPhoneno().equalsIgnoreCase(phoneno))
				return c1;
		}
		return null;	
	}
	public ServiceRequest newRequest(String phoneno, String numberPlate) {
		ServiceRequest req = new ServiceRequest(phoneno, numberPlate);
		return req;
	}
	public Bill newBill(ServiceRequest request) {
		Bill bill=new Bill(Tester.getTodayDate(), request);
		this.addBill(bill);
		return bill;
	}
	public void addBill(Bill bill) {
		
		this.billList.add(bill);
	}
	
	public double todaysBuisness(Date todayDate) {
		// match todayDate to bill date if date is match 
		//return paid amount -->  today 
		double totalCollection = 0.0;
		for(Bill bill:billList ) {			
			if (todayDate.equals(bill.getBillDate())) {
			  // add all paid amount for perticular date
				totalCollection +=bill.getPaidAmount();				
			}
		}		
		return totalCollection;		
	}
}
