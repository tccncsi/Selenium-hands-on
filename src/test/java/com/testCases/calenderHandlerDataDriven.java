package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.utilities.*;

public class calenderHandlerDataDriven extends BaseClass {

	landingClearTripPage calender;

	@Test
	public void searchpage() {

		landingClearTripPage calender = new landingClearTripPage(driver);

		calender.closePopup();
		
		calender.clickontextbox();
		calender.clickonlist();
		calender.checkin_arrow();
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
