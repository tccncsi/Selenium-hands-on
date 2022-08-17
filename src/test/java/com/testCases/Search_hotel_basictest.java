package com.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class Search_hotel_basictest extends BaseClass {
	LandingClearTripPage first ;
	String location = "Chennai";
	String heading = "Search for hotels";
//	String acutal_title = driver.getTitle();
//	String title = "Cleartrip: #1 Site for Booking Flights Tickets & Hotels Online - Get Best Travel Deals";
	String supportlabel = "Support";
	@Test
	public void searchpage() {

	
		LandingClearTripPage first = new LandingClearTripPage(driver);
//		Assert.assertEquals(title, acutal_title);    // assertion for title.
		first.closePopup();
		
		Assert.assertEquals(first.GetHeading(), heading);     //assertion for heading.
		Assert.assertEquals(first.GetSupport(), supportlabel);
		
		first.clickontextbox();
		first.enterLocality(location);
		first.clickonlist();
	    first.Search_btn();
		
//		if(driver.getTitle().equals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities."))
//		{
//
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
	}
	
	
}
