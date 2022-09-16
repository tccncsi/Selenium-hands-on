package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;
import com.pageObjects.paymentPage;
import com.pageObjects.siteForBookingHotel;
import com.pageObjects.viewDetailsPage;

public class addroomResultSearchPageTest extends BaseClass {

	
	landingClearTripPage  details; 
	modifySearchPage	addroom;
	viewDetailsPage  tallyprice;
	siteForBookingHotel book ;
	paymentPage pay ;
	
	String number = "1234567890";
	String email= "aradhanashinde@gmail.com";
	String name = "Apurva";
	String lastname = "Shinde";
	String secondname = "Aparna";
	String secondlastname = "Shinde";
	@Test
	

	
	public void addextraroom() {
		landingClearTripPage  details =  new landingClearTripPage(driver);
		modifySearchPage addroom = new  modifySearchPage(driver);
		viewDetailsPage  tallyprice = new viewDetailsPage(driver);
		siteForBookingHotel book = new siteForBookingHotel(driver);
		paymentPage pay = new paymentPage(driver);
		
		
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
		addroom.modifysrach_btn();
		addroom.clear_all();
		addroom.get_price_turrya();
		addroom.viewdetails_btn();
		tallyprice.waitforHotelName();
		tallyprice.getHotelName();
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
//		tallyprice.hotelnameviewmap();
		tallyprice.click_plussign();
		tallyprice.zoomout();
		tallyprice.zoomout();
		tallyprice.getacktomainframe();
		tallyprice.closemap();
		tallyprice.bookfirsthotelRoom();
		tallyprice.switchtonewtab();
		details.closePopup();
		book.getTotalPrice();
		book.scroll();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.clickoncontinue();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.clickonmobilenumber();
		book.entermobilenumber(number);
		book.clickemail();
		book.enteremailaddress(email);
		book.clickenterafteremail();
		book.clickfirstroomtitle();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		book.clickonthirdtitle();
		book.clickfirstname();
		book.enternameroomone(name);
		book.clicklastname();
		book.enterlastname(lastname);
		book.clicksecondtitle();
		book.clickonthirdtitle();
		book.clicksecondname();
		book.entersecondname(secondname);
		book.clickonlastname();
		book. entersecondlastname(secondlastname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.scrolltillbottom();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.clickoncontinuepay();
		tallyprice.switchtonewtab();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int initialprice=pay.youpayprice();
		pay.clickqrcode();
		int finalpay=pay.getQRcodeprice();
		
		Assert.assertTrue(initialprice >= finalpay);

		
		
		
		
		
	}
}

