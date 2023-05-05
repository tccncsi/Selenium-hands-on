package com.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.DataGeneratorUtility;
import com.utilities.XLUtils;

public class EmployeeFormGenerateDataTest extends BaseClass
{
DataGeneratorUtility datageneratorutility;
	
	@Test
	public void setEmployeeData() throws IOException
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
				  
			  
			  case "StreetName":
				  datageneratorutility.getStreetNames(a);
				  break;
				  
				
			  case "City":
				  datageneratorutility.getCity(a);
				  break;
				
			  case "PostalCode":
				  datageneratorutility.getsPostalCode(a);
				  break;
			
				 
			  case "DateofBirth":
				  datageneratorutility.getDateFormat2(a);
				  break;
				  
				 
			  case "Email":
				  datageneratorutility.getEmail(a);
				  break;
				 
			  case "Phone Number" :
				  datageneratorutility.getMobileNo(a);
				  break;
				  
			  case "PositionDivision":
				  datageneratorutility.getPositionDivision(a);
				  break;
				  
			  case "DateofHire":
				  datageneratorutility.getDateFormat2(a);
				  break;
				
			  case "WorkCode":
				  datageneratorutility.getWorkCode(a);
				  break;
				  
			  case "EmergencyFirstName":
				  datageneratorutility.getFirstName(a);
				  break;
				  
			  case "EmergencyLastName":
				  datageneratorutility.getLastName(a);
				  break;
				  
			  case "EmergencyPhoneNo":
				  datageneratorutility.getEmergencyPhoneNo(a);
				  break;
				  
			  case "EmergencyRelationship":
				  datageneratorutility.getRelationship(a);
				  break;
				  
			  case "Language":
				  datageneratorutility.getLanguages(a);
				  break;
				  
			  case "MartialStatus":
				  datageneratorutility.getMartialStatus(a);
				  break;
				  
			  case "Description":
				  datageneratorutility.getCustomisedText(a);
				  break;
				  
			  default:
					System.out.println("incorrect column name is selected. Please try again");
			}
		        
		
		}
	}
}
