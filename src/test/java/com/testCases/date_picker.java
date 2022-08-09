package com.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;

public class date_picker extends BaseClass {
	
LandingClearTripPage third ;
	String date_checkin = "Fri, Sep 9";
	String date_checkout = "Thu, Sep 15";
	@Test
	public void searchpage() {

	
		LandingClearTripPage third = new LandingClearTripPage(driver);
		
//		third.closePopup();
		third.clickontextbox();
		third.clickonlist();

	
		third.checkin_arrow();
		third.checkinarrow();
		third.checkindate();
		Assert.assertEquals(third.checkinbox(),date_checkin);
		
//		third.checkout_arrow();
//		third.checkinarrow();
		third.checkoutdate();
		Assert.assertEquals(third.Checkoutbox(), date_checkout);
		
		
		
		third.Search_btn();
		
	}
	
	

}
