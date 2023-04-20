package com.pageObjects.AMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.base.BasePage;
import com.utilities.ReadConfig;

public class LogInPage extends BasePage {
	public ReadConfig readconfig = new ReadConfig();

	// Functoion to call the driver
	public LogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>WEB-ELEMENT LOCATORS<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

	// NCS Logo
	@FindBy(xpath = "//nav//a[1]")
	WebElement NCSlogoLoc;

	// Login Window Header on Landing page of AMS Application
	@FindBy(xpath = "//h4")
	WebElement LoginHeadingLoc;

	// Username Textbox Label
	@FindBy(xpath = "//label[contains(text(),'Username')]")
	WebElement UsernameLabelLoc;

	// Username Textbox
	@FindBy(xpath = "//input[@formcontrolname='username']")
	WebElement UsernameTextBoxLoc;

	// Passsword Textbox Label
	@FindBy(xpath = "//label[@for=\"password\"]")
	WebElement PasswordLabelLoc;

	// Password Textbox
	@FindBy(xpath = "//input[@placeholder=\"Password\"]")
	WebElement PasswordTextBoxLoc;

	// Show and hide password eye icon - click element
	@FindBy(xpath = "//form//div[2]//i[1]")
	WebElement ShowPasswordEyeIconLoc;

	// Remember me Checkbox
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement RememberMeCheckBoxLoc;

	// Remember me Label
	@FindBy(xpath = "//p")
	WebElement RememberMeLabelLoc;

	// Forget password link
	@FindBy(xpath = "//a[@routerlink='/resetPassword']")
	WebElement ForgetPasswordLinkLoc;

	// Login Button
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Login')]")
	WebElement LoginBtnLoc;

	// Error message below Username textbox login page
	@FindBy(xpath = "(//small[@class='invalid-feedback'])[1]")
	WebElement LoginPageInvalidUsernameLoc;

	// Error message below Password textbox login page
	@FindBy(xpath = "(//small[@class='invalid-feedback'])[2]")
	WebElement LoginPageInvalidPasswordLoc;

	// Email Textbox on Forgot Password page
	@FindBy(xpath = "//input[@type='email']")
	WebElement EmailTxtBoxForgotPassPgeLoc;

	// Send OTP Button
	@FindBy(xpath = "//button[1]")
	WebElement SendOTPBtnLoc;

	// Back Button
	@FindBy(xpath = "//div[2]")
	WebElement BackBtnLoc;

	// Error message on dashboard page below Login ID
	@FindBy(xpath = "//div[2]//span") // "Enter valid email address"
	WebElement EntrValidEmailAdrsMessageLoc;

	// Authentication failed Pop up on login page
	@FindBy(xpath = "//div[@role=\"dialog\"]")
	WebElement AuthenticationFailedPopupLoc;

	// Authentication failed Pop up message login page
	@FindBy(xpath = "//div[@id = \"swal2-content\"]") // alternate option -> "//div[@role="dialog"]/div[2]"
	WebElement AuthenticationFailedPopupMessageLoc;

	// User settings/profile at right top corner contains Logout and Change Password
	@FindBy(xpath = "//nav/div//ul//li//a[@title='user settings']")
	WebElement UserProfileBtnLoc;
	// alternate option -> "//nav/div//ul//li//a[@href='#']"

	// Logout button under user settings
	@FindBy(xpath = "//a[@class='dropdown-item']")
	WebElement LogOutBtnLoc;

	// Change Password button under user settings
	@FindBy(xpath = "//span[contains(text(),'Change Password')]")
	WebElement ChangePasswordBtnLoc;

	// Cancel button update password pop up window
	@FindBy(xpath = "(//button[starts-with(text(),'Cancel')])")
	WebElement CancelBtnUpdatePasswordPopUpLoc;

	// Enter valid email address
	@FindBy(xpath = "//div//span[contains(text(),'Enter valid')]")
	WebElement EntrValidEmailErrMessOnForgotPasswordPgeLoc;

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>METHODS<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

	// Get AMS header on login window
	public String getAMSLoginHeader() {
		waitForFindElementPresent(LoginHeadingLoc);
		return LoginHeadingLoc.getText();
	}

	// Get username label
	public String getUsernameLabel() {
		waitForFindElementPresent(UsernameLabelLoc);
		return UsernameLabelLoc.getText();
	}

	// Get Password label
	public String getPasswordLabel() {
		waitForFindElementPresent(PasswordLabelLoc);
		return PasswordLabelLoc.getText();
	}

	// Enter username inside textbox
	public void EnterUsername(String AMSUsername) {
		waitForFindElementPresent(UsernameTextBoxLoc);
		UsernameTextBoxLoc.click();
		UsernameTextBoxLoc.sendKeys(AMSUsername);
	}

	// Enter password inside textbox
	public void EnterPassword(String AMSPassword) {
		waitForFindElementPresent(PasswordTextBoxLoc);
		PasswordTextBoxLoc.click();
		PasswordTextBoxLoc.sendKeys(AMSPassword);
	}

	// Get username entered by user
	public String getUsernameEntered() {
		waitForFindElementPresent(UsernameTextBoxLoc);
		return UsernameTextBoxLoc.getText();
	}

	// Get password entered by user
	public String getPasswordEntered() {
		waitForFindElementPresent(PasswordTextBoxLoc);
		return PasswordTextBoxLoc.getText();
	}

	// Click on show/hide password eye icon once
	public void ClickShowPasswordEyeIcon() {
		ShowPasswordEyeIconLoc.click();
	}

	// Get Remember me label
	public String getRememberMeLabel() {
		waitForFindElementPresent(RememberMeLabelLoc);
		return RememberMeLabelLoc.getText();
	}

	// Check Remember me checkbox
	public void CheckRememberMeCheckBox() {
		RememberMeCheckBoxLoc.click();
	}

	// Get ForgotPassword link Text
	public String getForgotPasswordLinkText() {
		waitForFindElementPresent(ForgetPasswordLinkLoc);
		return ForgetPasswordLinkLoc.getText();
	}

	// Click on Forgot Password link
	public void ClickForgotPasswordLink() {
		ForgetPasswordLinkLoc.click();
	}

	// Click on Login Button
	public void ClickOnLoginButton() {
		waitForFindElementPresent(LoginBtnLoc);
		waitForFindElementClickable(LoginBtnLoc);
		LoginBtnLoc.click();
	}

	public void HandleChangePasswordPopUp() throws InterruptedException {
		Thread.sleep(1000);
		waitForFindElementPresent(CancelBtnUpdatePasswordPopUpLoc);
		CancelBtnUpdatePasswordPopUpLoc.click();
	}

	public void RefreshPage() {
		driver.navigate().refresh();
	}

	// Login Directly From Here
	public void LoginToAMSApplication() throws InterruptedException {
		RefreshPage();
		EnterUsername(readconfig.getAMSUsername());
		EnterPassword(readconfig.getAMSPassword());
		LoginBtnLoc.click();
		HandleChangePasswordPopUp();
		System.out.println("Sign In completed");
	}

	public void Login(String AMSUsername, String AMSPassword) throws InterruptedException {
		RefreshPage();
		EnterUsername(AMSUsername);
		EnterPassword(AMSPassword);
		ClickOnLoginButton();
		System.out.println("Sign In completed");
	}

	// Click on User Icon
	public void ClickUserProfileIcon() {
		waitForFindElementPresent(UserProfileBtnLoc);
		UserProfileBtnLoc.click();
	}

	// Logout from application
	public void Logout() {
		ClickUserProfileIcon();
		waitForFindElementPresent(LogOutBtnLoc);
		LogOutBtnLoc.click();
		System.out.println("\nSign Out completed");
	}

	// Click Change Password
	public void ClickOnChangePasswordButton() {
		ClickUserProfileIcon();
		waitForFindElementPresent(ChangePasswordBtnLoc);
		ChangePasswordBtnLoc.click();
	}

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>VALIDATION PART<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

	// Validate Login Header
	public void AssertLoginHeader(String Expected) {
		Assert.assertEquals(getAMSLoginHeader(), Expected);
		// Print out the result
		System.out.println("After Assertion " + getAMSLoginHeader() + " = " + Expected + " Matched ");
	}

	// Validate Username Label
	public void AssertUsernameLabel(String Expected) {
		Assert.assertEquals(getUsernameLabel(), Expected);
		// Print out the result
		System.out.println("After Assertion " + getUsernameLabel() + " = " + Expected + " Matched ");
	}

	// Validate Password Label
	public void AssertPasswordLabel(String Expected) {
		Assert.assertEquals(getPasswordLabel(), Expected);
		// Print out the result
		System.out.println("After Assertion " + getPasswordLabel() + " = " + Expected + " Matched ");
	}

	// Validate Forgot Password Link Text
	public void AssertForgotPasswordLinkText(String Expected) {
		Assert.assertEquals(getForgotPasswordLinkText(), Expected);
		// Print out the result
		System.out.println("After Assertion " + getForgotPasswordLinkText() + " = " + Expected + " Matched ");
	}

	// Validate Remember Me Checkbox Label
	public void AssertRememberMeCheckboxLabel(String Expected) {
		Assert.assertEquals(getRememberMeLabel(), Expected);
		// Print out the result
		System.out.println("After Assertion " + getRememberMeLabel() + " = " + Expected + " Matched ");
	}

	// Enter Email ID in Textbox on Forgot password page
	public void EnterEmailOnForgotPasswordPage(String EmailID) {
		waitForFindElementPresent(EmailTxtBoxForgotPassPgeLoc);
		EmailTxtBoxForgotPassPgeLoc.click();
		EmailTxtBoxForgotPassPgeLoc.sendKeys(EmailID);
	}

	// Click on Send OTP Button on forgot password page
	public void ClickSendOTPButton() {
		waitForFindElementPresent(SendOTPBtnLoc);
		SendOTPBtnLoc.click();
	}

	// Click on Back button on Forgot Password page
	public void ClickBackButton() {
		waitForFindElementPresent(BackBtnLoc);
		BackBtnLoc.click();
	}

	// Validate Error message displayed is correct on dashboard page below Email ID
	// textbox
	public void ValidateErrorMessagebelowEmailIdTxtbox(String ExpectedErrorMessage) {
		waitForFindElementPresent(EntrValidEmailAdrsMessageLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = EntrValidEmailAdrsMessageLoc.isDisplayed();
		// To print the value
		System.out.println("Element displayed is :" + Display);

		String ErrMess = EntrValidEmailAdrsMessageLoc.getText();
		// Assert to check that message is corrent
		Assert.assertEquals(ErrMess, ExpectedErrorMessage);
	}

	// Validate Error message displayed is current on login page below username
	// textbox
	public void ValidateErrorMessagebelowUsernameTxtbox(String ExpectedErrorMessage) {
		waitForFindElementPresent(LoginPageInvalidUsernameLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = LoginPageInvalidUsernameLoc.isDisplayed();
		// To print the value
		System.out.println("Element displayed is :" + Display);

		String ErrMess = LoginPageInvalidUsernameLoc.getText();
		// Assert to check that message is corrent
		Assert.assertEquals(ErrMess, ExpectedErrorMessage);

	}

	// Validate Error message displayed is current on login page below username
	// textbox
	public void ValidateErrorMessagebelowPasswordTxtbox(String ExpectedErrorMessage) {
		waitForFindElementPresent(LoginPageInvalidPasswordLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = LoginPageInvalidPasswordLoc.isDisplayed();
		// To print the value
		System.out.println("Element displayed is :" + Display);

		String ErrMess = LoginPageInvalidPasswordLoc.getText();
		// Assert to check that message is corrent
		Assert.assertEquals(ErrMess, ExpectedErrorMessage);
	}

	// Validate Error message displayed on pop pup arises when wrong input provided
	// for login page
	public void ValidateErrorMessageforWrongInput(String ExpectedErrorMessage) {

		waitForFindElementPresent(AuthenticationFailedPopupLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = AuthenticationFailedPopupLoc.isDisplayed();
		// To print the value
		System.out.println("Authentication Failed Popup displayed is :" + Display);

		String ErrMess = AuthenticationFailedPopupMessageLoc.getText();
		// Assert to check that message is corrent

		Assert.assertEquals(ErrMess, ExpectedErrorMessage);

		// Print out the result
		System.out
				.println("Actual Error Message -> " + ErrMess + "\nExpected Error Message -> " + ExpectedErrorMessage);
	}

	// Validate the Title of the page
	public void AssertTitle(String Expected) {
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, Expected);
		Boolean verifyTitle = ActualTitle.equalsIgnoreCase(Expected);
		if (verifyTitle == true) {
			System.out.println("Actual Title(" + ActualTitle + ") And Expected Title(" + Expected + ") Matches");
		}
	}

	// Validate URL of the page
	public void AssertURL(String Expected) {
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, Expected);
		Boolean verifyURL = ActualURL.equalsIgnoreCase(Expected);
		if (verifyURL == true) {
			System.out.println("Actual URL(" + ActualURL + ") And Expected URL(" + Expected + ") Matches");
		}
	}
}
