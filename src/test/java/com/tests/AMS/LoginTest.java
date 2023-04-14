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
	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteAllLoginTCs() throws Exception {
		// 1. Execute LoginPageAssertionTest
		LoginPageAssertionTest();
		// 2. Execute LoginValidCredTest
		LoginValidCredTest();
		// 3. Execute LoginInValidCredTest
		LoginInValidCredTest();
		// 4. Execute LoginBlankCredTest
		LoginBlankCredTest();
	}

	// Test 1 for Assertion
	public void LoginPageAssertionTest() throws IOException {
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.TestCaseName("LoginPageAssertionTest()");
		AMSlogin.RefreshPage();
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
		// Object of AMSActions
		AMSlogin = new LogInPage(driver);
		AMSComm.TestCaseName("LoginValidCredTest()");
		AMSlogin.RefreshPage();
		// Enter Correct Username & Password
		AMSlogin.EnterUsername(readconfig.getAMSUsername());
		AMSlogin.EnterPassword(readconfig.getAMSPassword());
		AMSlogin.CheckRememberMeCheckBox();
		AMSlogin.ClickOnLoginButton();
		AMSlogin.HandleChangePasswordPopUp();
	}

	// Test 3 for Invalid Credentials
	public void LoginInValidCredTest() throws NumberFormatException, IOException {
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.TestCaseName("LoginInValidCredTest()");
		AMSlogin.RefreshPage();
		// Enter Wrong Username & Password
		AMSlogin.EnterUsername(XLUtils.FetchExcelData("WrongUsername"));
		AMSlogin.EnterPassword(XLUtils.FetchExcelData("WrongPassword"));
		AMSlogin.ClickOnLoginButton();
		// Validate Pop up apears and message displayed is correct
		AMSlogin.ValidateErrorMessageforWrongInput(XLUtils.FetchExcelData("ErrorMessforWrongCredeonLoginPage"));
	}

	// Test 4 for Blank Credentials fields
	public void LoginBlankCredTest() throws NumberFormatException, IOException {
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
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
