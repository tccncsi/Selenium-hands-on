package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;
import com.pageObjects.viewDetailsPage;

public class addroomResultSearchPageTest extends BaseClass {

	
	landingClearTripPage  details; 
	modifySearchPage	addroom;
	viewDetailsPage  tallyprice;
	@Test
	
	public void addextraroom() {
		landingClearTripPage  details =  new landingClearTripPage(driver);
		modifySearchPage addroom = new  modifySearchPage(driver);
		viewDetailsPage  tallyprice = new viewDetailsPage(driver);
		
		details.closePopup();
		details.clickontextbox();
		details.enter_checkin_checkout_date(details);
		details.Search_btn();
		addroom.clear_all();
		addroom.click_ontravellerbox();
		addroom.quick_select();
		addroom.clickon_addroomlink();
		addroom.addroom_link();
		addroom.plussign_adults();
//		addroom.plussign_adults();
//		addroom.get_price_turrya();
		addroom.modifysrach_btn();
		addroom.clear_all();
//		addroom.number_of_rooms();
		addroom.get_price_turrya();
		addroom.viewdetails_btn();
		tallyprice.waitforHotelName();
		tallyprice.viewdetail_turryaprice();
		tallyprice.scrolluntil_viewmap_visible();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tallyprice.click_view_map();
		tallyprice. switchframe_plussign();
		tallyprice.waituntil_maploads();
		tallyprice.click_plussign();
//		driver.switchTo().defaultContent();
		
		
		
		
	}
}

