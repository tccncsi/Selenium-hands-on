package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class traveller_fromlist extends BaseClass {
	
	LandingClearTripPage list;
	@Test
	public void searchpage() {
		LandingClearTripPage list = new LandingClearTripPage(driver);
		list.closePopup();
		list.clickontextbox();
		list.clickonlist();

	
		list.checkin_arrow();
		list.checkinarrow();
		list.checkindate();
		list.checkoutdate();
		list.travellerarrow();
		list.travellerarrow();
//		list.travellerlist();
		list. link_travelleR_box();
		
//		list.Search_btn();
		
	}
	

}
