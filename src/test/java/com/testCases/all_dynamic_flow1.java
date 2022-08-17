package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;
import	com.utilities.XLUtils;
public class all_dynamic_flow1  extends BaseClass{
	
//	String place = "Chennai" ;
	
	LandingClearTripPage obj2;
	
	@Test
	public void searchpage() {
		
		LandingClearTripPage obj2 = new LandingClearTripPage (driver);
		
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
//		obj2.add_room_incradult();
		obj2.Search_btn();
	}
}
