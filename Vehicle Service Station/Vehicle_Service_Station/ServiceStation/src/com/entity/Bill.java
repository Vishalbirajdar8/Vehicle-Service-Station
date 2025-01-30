package com.entity;

import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.serviceprovider.ServiceStation;

public class Bill implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private double lastBalance;
	private double totalAmount;
	private Date billDate;
	private double paidAmount;
	private ServiceRequest request;
	
//	ServiceStation station = new ServiceStation();
	
	public static final double taxPercentage=12.6;

	
	
	public Bill(Date billDate, ServiceRequest request) {
		super();
		Customer c2=ServiceStation.station.FindCustomer(request.getCustomerNo());
//		System.out.println(ServiceStation.station.FindCustomer(request.getCustomerNo()));
		this.lastBalance=c2.getLast_balance();
		this.billDate = billDate;
		this.request = request;
//		System.out.println(request.getCustomerNo());
		
//		System.out.println(c2);
		
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Date getBillDate() {
		return billDate;
	}
	public double computeTax()
	{
		return this.totalAmount*taxPercentage/100;
	}
	public double totalBill()
	{ 
  		totalAmount = 0.0;
		for(Service se:request.getServiceList())
		{
			totalAmount += se.price();
		}
		return this.totalAmount+this.computeTax(); 
		
	}
	public double finalBill()
	{
		// tax 
		return this.lastBalance+this.totalAmount+this.computeTax();
	}

	public void printBill(PrintStream out) {
		// Show Total Bill to end user
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//System.out.println(sdf);
//		out.append("  ")
		out.printf("*****************************%s*****************************\n",ServiceStation.stationName);
		System.out.println("Customer no:- "+request.getCustomerNo());
		System.out.println("Vehicle no:- "+request.getVehicleNO());
		System.out.println("Date:- "+sdf.format(billDate));
		System.out.println("=======================================================");
		for(Service s:request.getServiceList())
		{

//		  out.printf("     - Oiling  %s     Price %.2f", s.getDescription(),s.price());
		 System.out.println(s.getDescription() + " " + s.price());
		if(s instanceof MaintainanceService )  
		  {
			// maintance disc. + labour charge
			  System.out.println("    Labour Charge= "+((MaintainanceService) s).getLaborCharge());
			  // get parts name and price
		//	  ((MaintainanceService) s).getPartList()
			  for(SparePart p:((MaintainanceService) s).getPartList()) {
				  System.out.println(" - "+p);
			  }
		  }
		  
		}
		 System.out.println();

		  System.out.println("=======================================================");
		  System.out.println("Bil Charges:- "+totalAmount);
		 
		  out.printf("Tax:-%.2f \n",computeTax());
		  out.printf("Total Bill:-%.2f \n",totalBill());
		  // check lastBalace if lastbalance > 0  then show in customer bill
		  // lastbalnace == 0 last6balnce = 0 and total bill show  
	
		  if (lastBalance>0)
		  {
			  out.printf("Last balance of previous service:- %.2f \n ",lastBalance);
			 
		  }
		      out.printf("Final service amount:- %.2f \n",finalBill());
		  
		  
		  
	}
	

	
}
