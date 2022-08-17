package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LandingClearTripPage;
import com.utilities.XLUtils;

public class create_user extends BaseClass {

	LandingClearTripPage obj3;

	@Test
	public void searchpage() {

		LandingClearTripPage obj3 = new LandingClearTripPage(driver);

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
