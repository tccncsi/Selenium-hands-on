package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;

public class traveller_fromlist extends BaseClass {
	
	landingClearTripPage list;
	@Test
	public void searchpage() {
		landingClearTripPage list = new landingClearTripPage(driver);
		
		list.closePopup();
		list.clickontextbox();
		list.clickonlist();

	
		list.checkin_arrow();
		list.checkinarrow();
		list.checkindate();
		list.checkoutdate();
		list.travellerarrow();
		list.travellerarrow();		
		list.Search_btn();
		
	}
	

}
