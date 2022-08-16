package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class enter_email_in_popup   extends BaseClass {
	LandingClearTripPage obj1;
	
	@Test
	public void searchpage() {
		LandingClearTripPage obj1 = new LandingClearTripPage(driver);
		
		obj1.click_on_email();
		
	}

}
