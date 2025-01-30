package com.input;

import java.util.Scanner;

import com.entity.OilService;
import com.entity.Service;

public class OilInput {
	static Scanner sc  = new Scanner(System.in); 

	public static OilService oilInpute(OilService service) {
		sc.nextLine();
		System.out.println("Enter desc :::");
		service.setDescription(sc.nextLine());
		System.out.println("Enter price ::");
		service.setCost(sc.nextDouble());
		int choice = 0;
		
		/* do{
			System.out.println("0. Maintainance Done ");
			System.out.println("1. Add New Part");
			System.out.println("");
		} while (choice!=0);
		*/
		return service;
	}

}
