package com.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.DataGeneratorUtility;
import com.utilities.XLUtils;

public class SignUpFormMain extends BaseClass

{
	 DataGeneratorUtility datageneratorutility;
	
	@Test
	public void SignUp() throws IOException
	{
		datageneratorutility = new DataGeneratorUtility();
		//fetch all column names from test data
		ArrayList<String> al = XLUtils.fetchColumnData();
		//print all column names into data generator
		XLUtils.setColumnName(al);
		
		for(String a:al)
		{
			switch(a) 
			{
			  case "FirstName": 
				
				  datageneratorutility.getFirstName(a);
				  break;
				  
			  case "LastName": 
					
				  datageneratorutility.getLastName(a);
				  break;
				  
			  case "Age":
				  datageneratorutility.getAge(a);
				  break;
				  
			  case "Gender":
				  datageneratorutility.getGenders(a);
				  break;
				  
			  case "Country":
				  datageneratorutility.getCountry(a);
				  break;
				  
			  case "Tshirt Size":
				  datageneratorutility.getTshirtsize(a);
				  break;
				  
			  case "Method of Payment":
				  datageneratorutility.getPayments(a);
				  break;
				  
			  case "Quantity":
				  datageneratorutility.getQuantity(a);
				  break;
				  
			  case "Boolean":
				  datageneratorutility.getBoolean(a);
				  break;
				  
				  
			  case "PostalCode":
				  datageneratorutility.getsPostalCode(a);
				  break;
				
			  case "Address":
				  datageneratorutility.getStreetNames(a);
				  break;
				  
				
			  case "City":
				  datageneratorutility.getCity(a);
				  break;
				
				
			  case "Time":
				  datageneratorutility.getTimeStamp(a);
				  break;
				 
			  case "Date":
				  datageneratorutility.getDateFormat2(a);
				  break;
				  
				 
			  case "Email":
				  datageneratorutility.getEmail(a);
				  break;
				 
			  case "Phone Number" :
				  datageneratorutility.getMobileNo(a);
				  break;
				  
				  
			  case "Description":
				  datageneratorutility.getCustomisedText(a);
				  break;
				  
			  case "Relationship":
				  datageneratorutility.getRelationship(a);
				  break;
				  
			  default:
					System.out.println("incorrect column name is selected. Please try again");
			}
		        
		
		}
	}
	        
}
