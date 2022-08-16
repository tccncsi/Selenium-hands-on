package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;
import com.utilities.*;

public class dynamic_calender_handler extends BaseClass {

	LandingClearTripPage calender;

//	String month = "November 2022";// "July 2023";
//
//	String date = "Tue Nov 08 2022"; // "Sun Jul 09 2023";
//
//	String checkout_month = "July 2023" ;
//	String	dates = "Sun Jul 09 2023" ;
//	
	@Test
	public void searchpage() {

		LandingClearTripPage calender = new LandingClearTripPage(driver);

		calender.closePopup();
		
		calender.clickontextbox();
		calender.clickonlist();
		calender.checkin_arrow();
		// calender.getmonth();
		/*
		 * try { System.out.println("Month: " + XLUtils.fetchExcelData("month")); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } try { System.out.println("Date: " +
		 * XLUtils.fetchExcelData("date")); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		try {
			calender.calender(XLUtils.fetchExcelData("month"), XLUtils.fetchExcelData("date"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calender.getcheckout_month();
		try {
			calender.checkout_calender(XLUtils.fetchExcelData("checkout_month") ,XLUtils.fetchExcelData("dates"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calender.Search_btn();
	}

}

//C:\\Users\\P1345360\\eclipse-workspace\\ClearTrip\\src\\main\\java\\com\\testData\\Data.xlsx