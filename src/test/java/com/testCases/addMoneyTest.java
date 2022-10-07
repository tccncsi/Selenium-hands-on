package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.addMoneyPage;
import com.pageObjects.airtelHomePage;
import com.pageObjects.airtelPaymentPage;

public class addMoneyTest extends BaseClass {
	
	airtelHomePage money ;
	addMoneyPage add ; 
	airtelPaymentPage pay ;
	
	String paytype = "DebiT card";
	@Test
	
	public void addmoney() {
		airtelHomePage  money = new airtelHomePage(driver);

		money.loginflow();
		money.scrolldown();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addMoneyPage add = new addMoneyPage(driver);
		add.clickonaddmoney();
		
		
		add.clickonrps();
		add.clickonaddmoneybtn();
		
		airtelPaymentPage pay = new airtelPaymentPage(driver);
		pay.paymentflow(paytype);
		

}
}
