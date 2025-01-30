package com.input;
import java.util.Scanner;


import com.entity.Vehicle;

public class VehicleInput 
{
	static Scanner sc=new Scanner(System.in);
	public static Vehicle addVehicle(Vehicle vehicle)
	{
		System.out.println("Enter vehicle details");
		System.out.println("Company Name:-");
	    vehicle.setCompanyName(sc.next());
		System.out.println("Model Name:-");
		vehicle.setModelName(sc.next());
		System.out.println("Number Plate:-");
		vehicle.setNumberPlate(sc.next());
		
		return vehicle;
		
	}

}
