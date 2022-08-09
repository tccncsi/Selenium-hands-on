package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class travellers  extends BaseClass{

	
LandingClearTripPage four ;
	
	@Test
	public void searchpage() {

	
		LandingClearTripPage four = new LandingClearTripPage(driver);
//		four.closePopup();
		four.clickontextbox();
		four.clickonlist();

	
		four.checkin_arrow();
		four.checkinarrow();
		four.checkindate();
		four.checkoutdate();
		four.travellerarrow();
		four.travellerlist();
		
		four.Search_btn();
		
}
}