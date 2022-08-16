package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class invalid_no_location extends BaseClass {
	 
	LandingClearTripPage location;
	
	@Test
	public void searchpage() {
		
		LandingClearTripPage location = new LandingClearTripPage(driver);
		
		location.closePopup();
		
		location.checkin_arrow();
		location.setdate();
		location.Search_btn();
				
	}
}
