package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.landingClearTripPage;
import com.utilities.XLUtils;

public class createUserTest extends BaseClass {

	landingClearTripPage obj3;

	@Test
	public void searchpage() {

		landingClearTripPage obj3 = new landingClearTripPage(driver);

		if (obj3.see_popup()) {
			obj3.click_on_email();
			obj3.click_on_emailtext_box();
			obj3.enter_login_password(obj3);
			obj3.click_login();
		} else {
			obj3.click_on_searchpage();
			obj3.click_on_signup();
			obj3.click_on_email();
			obj3.click_on_emailtext_box();
			obj3.enter_login_password(obj3);

		}

	}

	
}

