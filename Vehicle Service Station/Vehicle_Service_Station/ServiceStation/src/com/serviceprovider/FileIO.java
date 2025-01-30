package com.serviceprovider;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.entity.Bill;
import com.entity.Customer;
import com.entity.Vehicle;

public class FileIO 
{
	private String filePath;
	private String bill_filePath;
	//private String filePath = "fileName"
	// string add for store billFile path
	public FileIO()
	{
		this.filePath="Customer_Data.dat";
		this.bill_filePath="Customer_Bill_Data.dat";
	}
	public void writeFile(HashSet<Customer> custList) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath))))
		{
			if (custList!=null) 
			{
				oos.writeObject(custList);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	public void readCustData() 
	{
		File file=new File(filePath);
		if(file.exists())
		{
			try(ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
			{
				ServiceStation.station.setCustList((HashSet<Customer>) ois.readObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void writeBillFile(ArrayList<Bill> billList) 
	{
		try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(bill_filePath))))
		{
			if(billList!=null)
				oos.writeObject(billList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void readBillData() 
	{
		File file=new File(bill_filePath);
		if(file.exists())
		{
			try(ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream((file)))))
			{
				ServiceStation.station.setBillList((ArrayList<Bill>) ois.readObject());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
}
