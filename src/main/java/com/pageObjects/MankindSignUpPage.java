package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.base.BasePage;

public class MankindSignUpPage extends BasePage {

	public MankindSignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[text()='Continue']")
	WebElement newCustomerContinue;
	
	@FindBy(xpath="//input[@name='Full Name']")
	WebElement fullName;
	
	@FindBy(xpath="//input[@name='Email address']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[@name='Confirm Email address']")
	WebElement confirmEmailAddress;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Confirm Password']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='Mobile Number']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//*[text()='No Thanks']")
	WebElement noThanks;
	
	@FindBy(xpath="//*[@id='email-address-error']")
	WebElement emailError;
	
	@FindBy(xpath="//*[@id='confirm-password-error']")
	WebElement confirmPasswordError;
	
	@FindBy(xpath="//div[@class='responsiveSettingsCard']//a[@href='accountSettings.account']")
	WebElement accountDetailsCard;
	
	@FindBy(xpath="//*[@id='customerName']")
	WebElement namePersonalDetails;
	
	@FindBy(xpath="//*[@id='customerEmail']")
	WebElement emailPersonalDetails;
	
	@FindBy(xpath="//*[@id='mobileNumber']")
	WebElement mobileNoPersonalDetails;
	
	
	/*----------------------Methods--------------------*/
	
	//Method to click on continue button
	public void clickOnSignUpContinue() throws InterruptedException {
		newCustomerContinue.click();		
	}
	
	//Method to enter fullname
	public void enterFullName(String userName) {
		fullName.sendKeys(userName);
	}
	
	//Method to enter email
	public void enterEmail(String userEmail) {
		emailAddress.sendKeys(userEmail);
	}
	
	//Method to clear email field
	public void clearEmailBox() {
		emailAddress.clear();
	}
	
	//Method to enter confirm email
	public void enterConfirmEmail(String userConfirmEmail) {
		confirmEmailAddress.sendKeys(userConfirmEmail);
	}
	
	//Method to enter password
	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	//Method to enter confirm password
	public void enterConfirmPassword(String userConfirmPassword) {
		confirmPassword.sendKeys(userConfirmPassword);
	}
	
	//Method to enter clear password field
	public void clearPassword() {
		password.clear();
	}
	
	//Method to enter mobile number
	public void enterMobileNumber(String userMobileNumber) {
		mobileNumber.sendKeys(userMobileNumber);
	}
	
	//Method to click on No Thanks
	public void selectNoThanks() {
		executor.executeScript("arguments[0].scrollIntoView(true);", noThanks);
		noThanks.click();
	}
	
	//Method to get Invalid Email error
	public String getEmailError() {
		return emailError.getText();
	}
	
	//Method to get confirm password error
	public String getConfirmPasswordError() {
	    WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for a maximum of 10 seconds
	    wait.until(ExpectedConditions.visibilityOf(confirmPasswordError));
	    return confirmPasswordError.getText();
	}

	//Method to generate new email
	public String createNewEmail(String existingEmail) {
	    int endIndex = existingEmail.lastIndexOf('@');
	    String prefix = existingEmail.substring(0, endIndex);
	    int endNumber = Integer.parseInt(prefix.substring(prefix.length() - 1)) + 1;
	    return prefix.substring(0, prefix.length() - 1) + endNumber + existingEmail.substring(endIndex);
	}

	//Method to click on acccount details card
	public void clikcOnAccountDetailsCard() {
		executor.executeScript("arguments[0].scrollIntoView(true);",accountDetailsCard);
		executor.executeScript("arguments[0].click();", accountDetailsCard);
	}
	
	//Method to get registered full name
	public String getRegisteredName() {
		return namePersonalDetails.getAttribute("value");
	}
	
	//Method to get registered email
	public String getRegisteredEmail() {
		return emailPersonalDetails.getAttribute("value");
	}
	
	//Method to get registered mobile number
	public String getRegisteredMobileNumber() {
		return mobileNoPersonalDetails.getAttribute("value");
	}
	
}
