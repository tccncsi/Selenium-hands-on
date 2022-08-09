package com.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pageObjects.Modify_Search_Page;
import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class addroom extends BaseClass {
	LandingClearTripPage room;
	Modify_Search_Page	room1;
	String label = "Where to?";
	String label2 = "Check-in";
	String label3 = "Check-out";
	String label4 = "Travellers";
	String traveller_data = "1 Room, 3 Adults, 1 Child";
	String Search_textbox = "Chennai, Tamil Nadu";
	String in_date = "Fri, Sep 9";
	String out_date = "Thu, Sep 15";
	String travellers_modifypage= "1 Room, 3 Adults, 1 Child";
	@Test
	public void searchpage() {
	
		LandingClearTripPage room = new LandingClearTripPage(driver);
		Modify_Search_Page room1 = new Modify_Search_Page(driver);
		
//		room.closePopup();
		room.clickontextbox();
	    Assert.assertEquals(room.whereto_label(), label);	
		room.clickonlist();
		Assert.assertEquals(room.checkin_label(), label2);
	
		room.checkin_arrow();
		room.checkinarrow();
		room.checkindate();
		Assert.assertEquals(room.checkout_label(), label3);
		room.checkoutdate();
		room.travellerarrow();
//		room.travellerlist();
		room.link_travelleR_box();
		room.incrementbtn();
		room.incrementbtn();
		room.decrementadult();
		room.incrementchild();
		room.incrementchild();
		room.decrementchild();
//		room.showopt();
//		room.less_than_arr();
		room.add_room();
//		room.add_room_incradult();
		Assert.assertEquals(room.traveller_box(), traveller_data);
		room.Search_btn();
		Assert.assertEquals(room1.search_txtbox(), Search_textbox);
		Assert.assertEquals(room1.getcheckin_date(), in_date);
//		Assert.assertEquals(room1.getCheckout_date(), out_date);
//		Assert.assertEquals(room1.adult_child_data(), travellers_modifypage);
		}

}
