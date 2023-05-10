package com.tests.AMS;

import java.io.IOException;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class LoginTest extends BaseClass {

	LogInPage AMSlogin;
	CommonPage AMSComm;
	public ReadConfig FromConfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteLoginTests() throws Exception {
		// Objects of required classes
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.Print("Executing Login Testcases...");

		// Execute LoginPageAssertionTest
		LoginPageAssertionTest();
		// Execute LoginValidCredTest
		LoginValidCredTest();
		// Execute LoginInValidCredTest
		LoginInValidCredTest();
		// Execute LoginBlankCredTest
		LoginBlankCredTest();

		AMSComm.TotalTestCount("10", "4");
	}

	// Test 1 for Assertion
	public void LoginPageAssertionTest() throws IOException {
		AMSComm.TestCaseName("LoginPageAssertionTest()");
		AMSComm.RefreshPage();
		// Assert elements on screen
		AMSlogin.AssertURL(XLUtils.FetchExcelData("LoginPageURL"));
		AMSlogin.AssertTitle(XLUtils.FetchExcelData("LoginPageTitle"));
		AMSlogin.AssertLoginHeader(XLUtils.FetchExcelData("AMSLoginHeader"));
		AMSlogin.AssertUsernameLabel(XLUtils.FetchExcelData("UsernameLabel"));
		AMSlogin.AssertPasswordLabel(XLUtils.FetchExcelData("PasswordLabel"));
		// AMSlogin.AssertRememberMeCheckboxLabel(XLUtils.FetchExcelData("RememberMeCheckboxLabel"));
		AMSlogin.AssertForgotPasswordLinkText(XLUtils.FetchExcelData("ForgotPasswordLinkText"));
	}

	// Test 2 for Valid Login
	public void LoginValidCredTest() throws NumberFormatException, IOException, InterruptedException {
		AMSComm.TestCaseName("LoginValidCredTest()");
		AMSlogin.RefreshPage();
		// Enter Correct Username & Password
		AMSlogin.EnterUsername(XLUtils.FetchExcelData("ValidUsername"));
		AMSlogin.EnterPassword(XLUtils.FetchExcelData("ValidPassword"));
		AMSlogin.CheckRememberMeCheckBox();
		AMSlogin.ClickOnLoginButton();
		AMSlogin.HandleChangePasswordPopUp();
		AMSlogin.Logout();
	}

	// Test 3 for Invalid Credentials
	public void LoginInValidCredTest() throws NumberFormatException, IOException, InterruptedException {
		AMSComm.TestCaseName("LoginInValidCredTest()");
		AMSlogin.RefreshPage();
		// Enter Wrong Username & Password
		AMSlogin.EnterUsername(XLUtils.FetchExcelData("InvalidUsername"));
		AMSlogin.EnterPassword(XLUtils.FetchExcelData("InvalidPassword"));
		AMSlogin.ClickOnLoginButton();
		// Validate Pop up appears and message displayed is correct
		AMSlogin.ValidateErrorMessageforWrongInput(XLUtils.FetchExcelData("ErrorMessforWrongCredeonLoginPage"));
	}

	// Test 4 for Blank Credentials fields
	public void LoginBlankCredTest() throws NumberFormatException, IOException {
		AMSComm.TestCaseName("LoginBlankCredTest()");
		AMSlogin.RefreshPage();
		// Do not enter Username & Password
		AMSlogin.EnterUsername("");
		AMSlogin.EnterPassword("");
		AMSlogin.ClickOnLoginButton();
		// Validate error message below Username Textbox
		AMSlogin.ValidateErrorMessagebelowUsernameTxtbox(XLUtils.FetchExcelData("ErrorMessageBlankUsernameLoginPage"));
		// Validate error message below Password textbox
		AMSlogin.ValidateErrorMessagebelowPasswordTxtbox(XLUtils.FetchExcelData("ErrorMessageBlankPasswordLoginPage"));
	}
}
