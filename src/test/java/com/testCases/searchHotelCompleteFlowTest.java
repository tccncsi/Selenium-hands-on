package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import	com.utilities.XLUtils;
public class searchHotelCompleteFlowTest  extends BaseClass{
	
	
	landingClearTripPage obj2;
	
	@Test
	public void searchpage() {
		
		landingClearTripPage obj2 = new landingClearTripPage (driver);
		
		obj2.closePopup();
		obj2.clickontextbox();
		
		obj2.enter_checkin_checkout_date(obj2);
		
		obj2.travellerarrow();
		obj2.link_travelleR_box();
		obj2.incrementbtn();
		obj2.incrementbtn();
		obj2.incrementchild();
		obj2.incrementchild();
		obj2.add_room();
		obj2.Search_btn();
	}
}
