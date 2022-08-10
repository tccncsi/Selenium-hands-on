package com.testCases;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class invalid_no_location extends BaseClass {
	 
	LandingClearTripPage location;
	

	public void searchpage() {
		
		LandingClearTripPage location = new LandingClearTripPage(driver);
		
		location.closePopup();
		
		location.checkin_arrow();
				
	}
}
