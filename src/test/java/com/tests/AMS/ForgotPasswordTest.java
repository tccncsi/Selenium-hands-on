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
	public void ExecuteAllFPTCs() throws Exception {
		//1. Execute ForgotPasswordBackButtonTest 
		ForgotPasswordBackButtonTest();
		//1. Execute LoginPageAssertionTest 
		ForgotPasswordSendOTPButtonTest();
	}
	
	public void ForgotPasswordBackButtonTest() throws NumberFormatException, IOException {
		// Object of AMSActions
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		
		AMSComm.TestCaseName("\nForgotPasswordBackButtonTest");
		AMSlogin.RefreshPage();
		// Click on Forgot Password Link
		AMSlogin.ClickForgotPasswordLink();
		// Enter Username/Email ID
		AMSlogin.EnterEmailOnForgotPasswordPage(XLUtils.FetchExcelData("WrongUsername"));
		// Click Back Button
		AMSlogin.ClickBackButton();
		// Check User back to the login page
		AMSlogin.AssertURL(XLUtils.FetchExcelData("LoginPageURL"));
	}

	public void ForgotPasswordSendOTPButtonTest() throws NumberFormatException, IOException {
		// Object of AMSActions
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		
		AMSComm.TestCaseName("\nForgotPasswordSendOTPButtonTest");
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
