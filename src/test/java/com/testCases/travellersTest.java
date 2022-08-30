package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;

public class travellersTest  extends BaseClass{

	
landingClearTripPage four ;
	
	@Test
	public void searchpage() {

	
		landingClearTripPage four = new landingClearTripPage(driver);
		four.closePopup();
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