package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.utilities.XLUtils;
public class restPasswordTest   extends BaseClass {
	landingClearTripPage obj1;
	
	@Test
	public void searchpageresetpasslink() {
		landingClearTripPage obj1 = new landingClearTripPage(driver);
		
		obj1.click_on_email();
		obj1.click_on_emailtext_box();
		try {
			obj1.enter_email(XLUtils.fetchExcelData("email"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj1.forget_pass_link();
		obj1.forget_pass_email();
		try {
			obj1.forget_pass_enter_email(XLUtils.fetchExcelData("email"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj1.click_reset_passlink();
	}

}
