package com.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;

public class uiAssertionHotelSearchPage extends BaseClass {
	landingClearTripPage first ;
	String location = "Chennai";
	String heading = "Search for hotels";
	String supportlabel = "Support";
	@Test
	public void searchpage() {

	
		landingClearTripPage first = new landingClearTripPage(driver);

		first.closePopup();		
		Assert.assertEquals(first.GetHeading(), heading);     //assertion for heading.
		Assert.assertEquals(first.GetSupport(), supportlabel);		
		first.clickontextbox();
		first.enterLocality(location);
		first.clickonlist();
	    first.Search_btn();

	}
	
	
}
