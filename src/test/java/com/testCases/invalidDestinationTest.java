package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;

public class invalidDestinationTest extends BaseClass {
	 
	landingClearTripPage location;
	
	@Test
	public void searchpageinvalidloc() {
		
		landingClearTripPage location = new landingClearTripPage(driver);
		
		location.closePopup();
		location.checkin_arrow();
		location.setdate();
		location.Search_btn();
				
	}
}
