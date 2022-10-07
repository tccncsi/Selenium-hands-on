package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.addMoneyPage;
import com.pageObjects.airtelHomePage;
import com.pageObjects.airtelPaymentPage;

public class loginAirtelTest extends BaseClass {
	
	airtelHomePage home ; 
	addMoneyPage money ; 
	airtelPaymentPage payment ;

	@Test
	
	public void login() {
		
		home.loginflow();
	}
}
