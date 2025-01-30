package com.entity;

import java.io.Serializable;

public class Vehicle implements Serializable{
  private static final long serialVersionUID = 1L;
  private String companyName;
  private String modelName;
  private String numberPlate;
  	
  public Vehicle(String companyName, String modelName, String numberPlate) {
	super();
	this.companyName = companyName;
	this.modelName = modelName;
	this.numberPlate = numberPlate;
}
public Vehicle() {
	super();
	// TODO Auto-generated constructor stub
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public String getNumberPlate() {
	return numberPlate;
}
public void setNumberPlate(String numberPlate) {
	this.numberPlate = numberPlate;
}
@Override
public String toString() {
	return "Vehicle [companyName=" + companyName + ", modelName=" + modelName + ", numberPlate=" + numberPlate + "]";
}
}
