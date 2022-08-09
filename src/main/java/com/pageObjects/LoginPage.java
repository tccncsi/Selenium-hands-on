package com.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BasePage;

import org.openqa.selenium.Keys;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

  
	private By userName = By.id("username");
	private By password = By.xpath("//*[@formcontrolname='password']");
	private By Loginbtn = By.xpath("//*[contains(text(),'LOGIN')]");
	private By otpText= By.xpath("//*[contains(text(),'Enter One-Time Password (OTP)')]");
	private By otp= By.xpath("//*[@id='debug']");
	private By enterOTP= By.xpath("//*[@id='otp']");
	private By logOut = By.xpath("//*[contains(text(),'Logout')]");
	private By leftPannel = By.id("hamburger");
	private By title = By.xpath("(//*[contains(text(),'iEXAMS2')])[2]");
	
	// Returns Username
	public WebElement getuserName() {
		return getElement(userName);
	}

	// Returns Password
	public WebElement getPassword() {
		return getElement(password);
	}

	// Returns loginbutton
	public WebElement getLoginButton() {
		return getElement(Loginbtn);
	}

	// Returns Page title
	public String getLoginPageTitle() {
		return getPageTitle();
		
	}
	
	public WebElement getOTPText() {
		return getElement(otpText);
	}
	
	public WebElement getOTP() {
		return getElement(otp);
	}
	
	public String getOTPNumber() {
		return getText(otp);
	}
	
	public void waitforOTPNumber() {
		 waitForElementPresent(otp);
	}
	
	public WebElement getEnterOTP() {
		return getElement(enterOTP);
	}
	
	public WebElement getlogOut() {
		return getElement(logOut);
	}
	
	public WebElement geleftPannel() {
		return getElement(leftPannel);
	}
	
	public void waitforTitle() {
		 waitForElementPresent(title);
	}
	
	
	public void Login(String uname, String pword) {
		implicitWait();
		getuserName().sendKeys(uname);
		logger.info("Username is entered");
		getPassword().sendKeys(pword);
		getLoginButton().click();
		
		
		try {
			if(getOTPText().isDisplayed())
				{
				    System.out.println(" OTP Element is found");
					action.sendKeys(Keys.chord("d")).build().perform();
					waitforOTPNumber();
					String OTP=getOTPNumber();
					System.out.println("OTP is "+OTP);
					getEnterOTP().sendKeys(OTP);
					getLoginButton().click();
					
				}
		} catch (Exception e) {
			System.out.println(" OTP Element is not found");
		}

		waitforTitle();
	}
	
	
	
}
