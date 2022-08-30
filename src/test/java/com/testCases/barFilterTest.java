package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;

public class barFilterTest extends BaseClass {

	
	landingClearTripPage bar1;
	 modifySearchPage	first;
	
	 @Test
	 public void barfilter() {
		 
		 
		 landingClearTripPage bar1 = 	 new landingClearTripPage(driver);
		 modifySearchPage first =  new modifySearchPage(driver);
		 

			bar1.closePopup();
			bar1.clickontextbox();
			bar1.enter_checkin_checkout_date(bar1);
			bar1.Search_btn();
			first.clear_all();
			first.scrollupto_bottom();
			first.seemore_amenities();
			first.baar();
			first.waitForResult();
			Assert.assertEquals(first.getdata_bar(), first.hotelDetailsCount());
			
		 
				 
	 }
}
