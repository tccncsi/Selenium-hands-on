package com.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.utilities.DataGeneratorUtility;
import com.utilities.XLUtils;

public class DataGeneratorPageTest extends BaseClass
{
	DataGeneratorUtility datageneratorutility;
	
	@Test
	public void GenerateData() throws IOException
	{
		 datageneratorutility = new DataGeneratorUtility();
			
			ArrayList<String> al = XLUtils.fetchColumnData();
			XLUtils.setColumnName(al);
			
			for(String a:al)
			{
				switch(a) 
				{
				  case "Name": 
					
					  datageneratorutility.getNames(a);
					  break;
					
				  case "PostalCode":
					  datageneratorutility.getsPostalCode(a);
					  break;
					
				  case "StreetName":
					  datageneratorutility.getStreetNames(a);
					  break;
					  
					
				  case "City":
					  datageneratorutility.getCity(a);
					  break;
					
				  case "Business": 
					  datageneratorutility.getBusinessNames(a);
					  break;
					
				  case "Date(yyyy.mm.dd)":
					  datageneratorutility.getDateFormat1(a);
					  break;
					 
				  case "Date(dd.mm.yyyy)":
					  datageneratorutility.getDateFormat2(a);
					  break;
					  
				  case "Date(E dd.mm.yyyy)":
					  datageneratorutility.getDateFormat3(a);
					  break;
					 
				  case "EmailAddress":
					  datageneratorutility.generateEmailIds(a);
					  break;
					 
				  case "MobileNo" :
					  datageneratorutility.getMobileNo(a);
					  break;
					  
				  case "NRICNumber":
					  datageneratorutility.getNRIC(a);
					  break;
					  
				  case "TextArea":
					  datageneratorutility.getCustomisedText(a);
					  break;
					  
				  default:
						System.out.println("incorrect column name is selected. Please try again");
				}
			        
			
			}
	}
}
