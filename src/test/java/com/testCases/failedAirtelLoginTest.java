package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.airtelHomePage;
import com.utilities.XLUtils;

public class failedAirtelLoginTest extends BaseClass {
	
	airtelHomePage login ;

	@Test
	public void insertexceldata() {
		 
		 login = new airtelHomePage(driver);
		 
		 login.loginflow();
//		String filename = "ClearTrip";
//		String sheetname = "Sheet1" ;
		
		try {
			XLUtils.setCellData("ClearTrip", "Sheet1", 13, 1,"C:\\Users\\P1345360\\eclipse-workspace\\ClearTrip\\Screenshots\\insertexceldata");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		 XLUtils.setCellData(image, image, 0, 0, image);
	}

}
