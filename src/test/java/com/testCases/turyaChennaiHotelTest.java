package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;

public class turyaChennaiHotelTest extends BaseClass {
	
	landingClearTripPage hotel;
	modifySearchPage first;
	
	
//	String H = "Turyaa Chennai";
	String loc = "Omr Road";
	
	
	@Test (enabled = true)
	public void firsthotel() {
		
		landingClearTripPage hotel = new landingClearTripPage (driver);
		modifySearchPage first  = new modifySearchPage(driver);
		
		hotel.closePopup();
		hotel.clickontextbox();
		hotel.enter_checkin_checkout_date(hotel);
		hotel.Search_btn();
		first.clear_all();
		first.get_turyaachennai();
		first.get_turyaloc();
		first.RemoveCharString();
		first.viewdetailsturyaa();
		first.waitfortext();
		String actuallocation = first.get_turyaachennai();
		String expectedlocation  = first.get_turya_nextpage();
		Assert.assertEquals(actuallocation, expectedlocation);
		first.remove_chennai();
		Assert.assertEquals(first.get_turyaloc(), loc);
	}
	

}
