package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;


public class enterDestinationTest extends BaseClass {
	landingClearTripPage second;
	
	@Test
	public void searchpageenterloc() {
		landingClearTripPage second = new landingClearTripPage(driver);
		
		
		second.closePopup();
		second.clickontextbox();
		second.enterLocality("Chennai");
		second.clickonlist();
		second.checkin_arrow();
		second.checkinarrow();
		second.checkindate();
		second.checkoutdate();
		second.Search_btn();
		
	}

}
