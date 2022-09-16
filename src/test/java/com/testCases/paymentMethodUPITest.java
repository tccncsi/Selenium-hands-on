package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.pageObjects.modifySearchPage;
import com.pageObjects.paymentPage;
import com.pageObjects.siteForBookingHotel;
import com.pageObjects.viewDetailsPage;

public class paymentMethodUPITest extends BaseClass {
	
	landingClearTripPage  detail; 
	modifySearchPage	addrooms;
	viewDetailsPage  hotel;
	siteForBookingHotel booking ;
	paymentPage payment ;
	
	String number = "1234567890";
	String email= "aradhanashinde@gmail.com";
	String name = "Apurva";
	String lastname = "Shinde";
	String secondname = "Aparna";
	String secondlastname = "Shinde";
	String id = "aradhanashinde13-2@okicici" ;
	String cardnum = "4598450023058891";
	String cardholdername = "Aradhana Shinde";
	String cvvnum = "269";
	@Test
	
	public void payusingUPI() {
		landingClearTripPage  detail =  new landingClearTripPage(driver);
		modifySearchPage addrooms = new  modifySearchPage(driver);
		viewDetailsPage  hotel = new viewDetailsPage(driver);
		siteForBookingHotel booking = new siteForBookingHotel(driver);
		paymentPage payment = new paymentPage(driver);
		
		detail.closePopup();
		detail.clickontextbox();
		detail.enter_checkin_checkout_date(detail);
		detail.Search_btn();
		addrooms.clear_all();
		addrooms.click_ontravellerbox();
		addrooms.quick_select();
		addrooms.clickon_addroomlink();
		addrooms.addroom_link();
		addrooms.plussign_adults();
		addrooms.modifysrach_btn();
		addrooms.clear_all();
		addrooms.get_price_turrya();
		addrooms.viewdetails_btn();
		hotel.waitforHotelName();
		hotel.getHotelName();
		hotel.viewdetail_turryaprice();
		hotel.scrolluntil_viewmap_visible();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hotel.click_view_map();
		hotel. switchframe_plussign();
		hotel.waituntil_maploads();
		hotel.click_plussign();
		hotel.zoomout();
		hotel.zoomout();
		hotel.getacktomainframe();
		hotel.closemap();
		hotel.bookfirsthotelRoom();
		hotel.switchtonewtab();
		detail.closePopup();
		booking.getTotalPrice();
		booking.scroll();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.clickoncontinue();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.clickonmobilenumber();
		booking.entermobilenumber(number);
		booking.clickemail();
		booking.enteremailaddress(email);
		booking.clickenterafteremail();
		booking.clickfirstroomtitle();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		booking.clickonthirdtitle();
		booking.clickfirstname();
		booking.enternameroomone(name);
		booking.clicklastname();
		booking.enterlastname(lastname);
		booking.clicksecondtitle();
		booking.clickonthirdtitle();
		booking.clicksecondname();
		booking.entersecondname(secondname);
		booking.clickonlastname();
		booking. entersecondlastname(secondlastname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.scrolltillbottom();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.clickoncontinuepay();
		hotel.switchtonewtab();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		payment.youpayprice();
		payment.clickonUPIID();
		payment.clickoncardpayment();
		payment.clickoncard();
		payment.enterccardno(cardnum);
		payment.expirymonth();
		payment.selectexpmonth();
		payment.clickexpiryyr();
		payment.selectexpiryyear();
		payment.clickoncardname();
		payment.enternameoncard(cardholdername);
		payment.clickoncvv();
		payment.entercvv(cvvnum);
		payment.clickonpaynow();
	}
}
