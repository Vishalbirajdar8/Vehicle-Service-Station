package com.input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import com.entity.Customer;

public class CustomerInput 
{
	static Scanner sc=new Scanner(System.in);
	public static Customer addCustomer(Customer customer)
	{
		System.out.println("Enter customer details");
		System.out.println("Name:-");
		customer.setName(sc.next());
		System.out.println("Phone no:-");
		customer.setPhoneno(sc.next());
		System.out.println("Address:-");
		customer.setAddress(sc.next());
		
		return customer;
	}
	

	

}
