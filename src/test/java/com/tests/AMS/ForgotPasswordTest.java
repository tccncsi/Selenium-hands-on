package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class ForgotPasswordTest extends BaseClass {

	LogInPage AMSlogin;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteForgotPasswordTests() throws Exception {
		// Objects of required classes
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.Print("Executing Fogot Password Testcases...");

		// Execute ForgotPasswordBackButtonTest
		ForgotPasswordBackButtonTest();
		// Execute LoginPageAssertionTest
		ForgotPasswordSendOTPButtonTest();

		AMSComm.TotalTestCount("7", "2");
	}

	public void ForgotPasswordBackButtonTest() throws NumberFormatException, IOException {
		AMSComm.TestCaseName("ForgotPasswordBackButtonTest");
		AMSlogin.RefreshPage();
		// Click on Forgot Password Link
		AMSlogin.ClickForgotPasswordLink();
		// Enter Username/Email ID
		AMSlogin.EnterEmailOnForgotPasswordPage(XLUtils.FetchExcelData("WrongUsername"));
		// Click Back Button
		AMSlogin.ClickBackButton();
		// Check the User back to the login page
		AMSlogin.AfterReturnToLoginPage(XLUtils.FetchExcelData("LoginPageURL"));
	}

	public void ForgotPasswordSendOTPButtonTest() throws NumberFormatException, IOException {
		AMSComm.TestCaseName("ForgotPasswordSendOTPButtonTest");
		AMSlogin.RefreshPage();
		// Click on Forgot Password Link
		AMSlogin.ClickForgotPasswordLink();
		// Enter Username/Email ID
		AMSlogin.EnterEmailOnForgotPasswordPage(XLUtils.FetchExcelData("WrongUsername"));
		// Click Back Button
		AMSlogin.ClickSendOTPButton();
		// Validate Error Message
		AMSlogin.ValidateErrorMessagebelowEmailIdTxtbox(XLUtils.FetchExcelData("ErrorMessageForgotPasswordPage"));
	}
}
