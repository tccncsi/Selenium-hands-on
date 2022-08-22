package com.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;

public class hotelClassFilter extends BaseClass {
	
	
	landingClearTripPage obj5;
	modifySearchPage hotel  ;
	
	@Test
	public void hotel() {
		
		landingClearTripPage obj5 = new landingClearTripPage(driver);
		modifySearchPage hotel = new modifySearchPage(driver);
		
		obj5.closePopup();
		obj5.clickontextbox();
		obj5.enter_checkin_checkout_date(obj5);
		obj5.Search_btn();
		hotel.giftcards();
		hotel.guesthouse();
		//hotel.fivestar_hotelcount();
//		hotel.hoteldeals();
		hotel.waitForResult();
		
		
		
		Assert.assertEquals(hotel.guesthouse_getdata(), hotel.hotelDetailsCount());
		
		}

}
