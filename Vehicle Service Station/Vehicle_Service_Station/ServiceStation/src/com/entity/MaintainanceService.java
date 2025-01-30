package com.entity;

import java.util.ArrayList;

public class MaintainanceService extends Service 
{
	  private static final long serialVersionUID = 1L;
      private double laborCharge ;
      private ArrayList<SparePart> partList;
      
	public MaintainanceService() {
		super();
		this.partList = new ArrayList<>();
	}
	public MaintainanceService(double laborCharge,String description ) {
		super(description);
		this.laborCharge = laborCharge;
		
	}
	public double getLaborCharge() {
		return laborCharge;
	}
	public void setLaborCharge(double laborCharge) {
		this.laborCharge = laborCharge;
	}
	public ArrayList<SparePart> getPartList() {
		return partList;
	}
	public void setPartList(ArrayList<SparePart> partList) {
		this.partList = partList;
	}
	@Override
	public double price() {
		double totalCost;
		totalCost=this.laborCharge;
		
		for(SparePart p:partList )
		{
			totalCost=totalCost+p.getPrice();
		}
		return totalCost;
	}
	@Override
	public String toString() {
		return "MaintainanceService :-"+super.toString();
	}
	public void newSparePart(SparePart sparePart) {
		this.partList.add(sparePart);
		
	}
	
}
