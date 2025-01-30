package com.input;

import java.util.Scanner;

import com.entity.MaintainanceService;
import com.entity.Service;
import com.entity.SparePart;

public class MaintainanceServiceInput {
	static Scanner sc  = new Scanner(System.in); 
	public static MaintainanceService maintainanceServiceInput(MaintainanceService service) {
		sc.nextLine();
		System.out.println("Enter Maintainance Service Description");
		service.setDescription(sc.nextLine());
		System.out.println("Enter Labour Charge :- ");
		service.setLaborCharge(sc.nextDouble());
		int choice;
		do {
			System.out.println("0.Exit");
			System.out.println("1. add new part");
			choice = sc.nextInt();
			if(choice == 1) {
				SparePart sparePart = new SparePart();
				System.out.println("Part name");
				sparePart.setDesc(sc.next());
				System.out.println("Price");
				sparePart.setPrice(sc.nextDouble());
				service.newSparePart(sparePart);
			}
		}while(choice!=0);
		
		
		
		
		return service;
		

	}

		
	
}



