package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;


public class Enter_dest_intxt extends BaseClass {
	LandingClearTripPage second;
	
	@Test
	public void searchpage() {
		LandingClearTripPage second = new LandingClearTripPage(driver);
		
		
		second.closePopup();
		second.clickontextbox();
		second.setLocality("Chennai");
		second.clickonlist();
		second.checkin_arrow();
		second.checkinarrow();
		second.checkindate();
//		second.checkout_arrow();
//		second.checkinarrow();
		second.checkoutdate();
		second.Search_btn();
		
	}

}
