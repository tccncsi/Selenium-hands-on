package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;

public class absoluteSearchHotelFlow extends BaseClass {
	
	landingClearTripPage obj4;
	modifySearchPage room2;
	
	String date1 = "Tue, Nov 8";
	String date2=  "Sun, Jul 9";
	String traveller_modifypage = "2 Rooms, 5 Adults";
	String  traveller_data = "Chennai, Tamil Nadu";
	@Test
	public void searchpage() {

		landingClearTripPage obj4 = new landingClearTripPage(driver);
		modifySearchPage room2 = new modifySearchPage(driver);
		
		if(obj4.popup()) {
			obj4.closepopup();
			obj4.clickontextbox();
			obj4.enter_checkin_checkout_date(obj4);
			obj4.travellerarrow();
			obj4.link_travelleR_box();
			obj4.incrementbtn();
			obj4.incrementbtn();
			obj4.incrementchild();
			obj4.incrementchild();
			obj4.add_room();
			obj4.Search_btn();
		}
		else {
			obj4.clickontextbox();
			obj4.enter_checkin_checkout_date(obj4);
			obj4.travellerarrow();
			obj4.link_travelleR_box();
			obj4.incrementbtn();
			obj4.incrementbtn();
			obj4.incrementchild();
			obj4.incrementchild();
			obj4.add_room();
			obj4.Search_btn();
	   }
//		Assert.assertEquals(room2.traveller_box(), traveller_data);
		Assert.assertEquals(room2.getcheckin_date(), date1);
		Assert.assertEquals(room2.getCheckout_date(), date2);
		Assert.assertEquals(room2.adult_child_data(), traveller_modifypage);
	}
}
