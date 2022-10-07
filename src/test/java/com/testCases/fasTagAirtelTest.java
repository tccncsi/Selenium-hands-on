package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.airtelHomePage;
import com.pageObjects.fasTagAirtelPage;
import com.utilities.XLUtils;

public class fasTagAirtelTest extends BaseClass {
	 
	airtelHomePage home ;
	fasTagAirtelPage car ;
	
	@Test
	public void fastag() {
		 
		home = new airtelHomePage(driver);
		car  = new fasTagAirtelPage(driver);
		
		try {
			
		
		home.loginflow();
		Thread.sleep(5000);
		home.scrolldown();
		Thread.sleep(3000);
		car.clickonFastag();
		Thread.sleep(3000);
		car.clickfirstimg();
		Thread.sleep(3000);
		car.firstimg();
		
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
