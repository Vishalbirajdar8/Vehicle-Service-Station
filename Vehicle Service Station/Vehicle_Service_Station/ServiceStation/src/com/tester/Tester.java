package com.tester;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import com.entity.Bill;
import com.entity.Customer;
import com.entity.MaintainanceService;
import com.entity.OilService;
import com.entity.Service;
import com.entity.ServiceRequest;
import com.entity.Vehicle;
import com.input.CustomerInput;
import com.input.MaintainanceServiceInput;
import com.input.OilInput;
import com.input.VehicleInput;
import com.serviceprovider.FileIO;
import com.serviceprovider.ServiceStation;
public class Tester 
{
	
	static Scanner sc=new Scanner(System.in);
	public static Date getTodayDate() {
		//util.Calender give us ready made method for getting today's date
		return getDate(Calendar.getInstance());
	}
	private static Date getDate(Calendar instance) {
		Calendar date = new GregorianCalendar(instance.get(Calendar.YEAR), instance.get(Calendar.MONTH), instance.get(Calendar.DAY_OF_MONTH));
		return date.getTime();
	}
	private static Date getDate(int dd, int mm, int yy) {
		Calendar date = new GregorianCalendar(yy, mm-1,dd);
		return getDate(date);
	}
	
	public static void displayVehicleList(Customer c1)
	{
       for(Vehicle v: c1.getVehList())
    	   System.out.println(v);	
	}
	public static int menuList()
	{
		System.out.println("****************Vehicle Station Menu***************");
		System.out.println("0.Exit");
		System.out.println("1.Add new customers");
		System.out.println("2.Service Request");
		System.out.println("3.Today's");
		System.out.println("4.Any date");
		
		return sc.nextInt();
	}
	public static void main(String[] args)
	{
//		ServiceStation station = new ServiceStation();
		Customer customer;
		double payAmount;
		double paidAmount;
		FileIO fo=new FileIO();
		int choice=0;
		ServiceRequest request;
		Bill bill;
		Service service;
		fo.readCustData(); 
		fo.readBillData();
		while((choice=menuList())!=0)
		{
			switch (choice) {
			case 1: // adding new customer
				System.out.println("Add new customer");
				customer = new Customer();//using parameterless customer we are initialise customer 
				Customer cust=CustomerInput.addCustomer(customer);
				ServiceStation.station.newCustomer(cust);
				break;
			case 2: // Service Request
				//check customer is present or not in custList
				// if cust is not present break out.
				System.out.println("Find customer by Phone no: ");
				String phoneno=sc.next();
				Customer c1=ServiceStation.station.FindCustomer(phoneno);
				System.out.println(c1);
				if(c1==null)
				{		
					System.out.println("Customer not  found ");
					System.out.println("To get service first add new customer");
					break;
				}

				Tester.displayVehicleList(c1);
				Vehicle veh = null;
				/* in below code we check vehicle is present or not 
				 * if present we are ready to provide service by using customer number and vehicle
				 * number
				 * if not present we request to customer add your vehicle in our service station
				 * */
		
				do {
					System.out.println("Enter vehicle number or 0 for add new vehicle");
					String input = sc.next();
					if(input.trim().equals("0")) {
						veh = new Vehicle();
						veh = VehicleInput.addVehicle(veh);
						System.out.println(veh);
						c1.newVahicle(veh);
					} else {
						veh = c1.getVehicle(input);
					}
				}while(veh == null); 
				System.out.println("*****************************");
				
				/* we ready to provide service
				 * 
				 * 
				 * 
				 * */
				request = ServiceStation.station.newRequest(c1.getPhoneno(),veh.getNumberPlate());
				int choice1;

				do {
					System.out.println("0. exit 1. oil Servicing 2 Maintenance ");		
					System.out.println("Enter choice");
										
					choice1=sc.nextInt();
					sc.nextLine();
					switch (choice1) {
					case 1:
						System.out.println("oil servicing");
						service = new OilService();
						OilService oilService	=OilInput.oilInpute((OilService) service);	
						request.newService(oilService);
						request.display();
						System.out.println("********************************");
						break;
					case 2:// ready to provide maintaince service
						System.out.println("Maintenance");
						service = new MaintainanceService();
						MaintainanceService maintenanceService	=MaintainanceServiceInput.maintainanceServiceInput((MaintainanceService) service);	
						request.newService(maintenanceService);
						request.display();
						System.out.println("********************************");

						break;
					}
					
				} while (choice1!=0);
				bill=ServiceStation.station.newBill(request);
//				System.out.println(bill);
//				System.out.println(bill.totalBill());
				bill.totalBill();
				bill.printBill(System.out);
				System.out.println("Enter Amount paid by customer");
				paidAmount=sc.nextDouble();
				paidAmount=c1.bill_tobePaid(paidAmount,bill);
				System.out.println();
				if(paidAmount > 0.0) {
					System.out.printf("Balance Amount:- %.2f \n ", paidAmount);
				}
				break;
			case 3:
				// Today's buisness
				double var=ServiceStation.station.todaysBuisness(Tester.getTodayDate());
				System.out.println(Tester.getTodayDate());
				//Tester.getTodayDate();
			System.out.println("Today's buisness:- "+var);
				break;
			case 4: // 	given date buisness
				// provide date
				System.out.println("Enter date (dd-mm-yy)");
				String d=sc.next();
				// 1. string => int dd , int mm, int yyyy ==> write function to convert string to Date type
				//return total cash 
				// Inside Method ---> String split ==> array store --> by using index 0 --> dd
//				
				
					String [] arrOfd = d.split("-");
					int dd=Integer.parseInt(arrOfd[0]);
					int mm=Integer.parseInt(arrOfd[1]);
					int yy=Integer.parseInt(arrOfd[2]);
					System.out.println(Tester.getDate(dd,mm,yy));
					double cash = ServiceStation.station.todaysBuisness(Tester.getDate(dd,mm,yy));
					System.out.println("Cash :: "+cash + "On date "+ dd+"-"+mm+"-"+yy);
				
			break;
			default:
				break;
			}
			fo.writeFile(ServiceStation.station.getCustList());
			fo.writeBillFile(ServiceStation.station.getBillList());	
		}
	
	}
	public static String welcome() {
		ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(outBytes);
		out.printf("Java My Project @ SunBeam Infotech\n\n");
		out.printf("Vehicle Service Station\n\n");
		out.printf("This is simplified version of the case study implementation.\n");
		out.printf("Consider this as base and implement case study of your own.\n");
		out.printf("This implementation should help you to understand requirements better. First read the given documentation of case study.\n\n");
		out.printf("However most of the validations are not implemented. So be careful while trying it.\n");
		out.printf("Note that all string inputs are considered without white space.\n");
		out.printf("Given a dummy customer database as sample and is used in this program.\n");
		out.flush();
		String text = outBytes.toString();
		out.close();
		return text;
	}
	
	
	
	
	
	//


	
	
	

}
