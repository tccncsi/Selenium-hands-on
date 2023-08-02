package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.base.BasePage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class AmazonPage extends BasePage {

	BasePage basepage;
	public ReadConfig readconfig = new ReadConfig();

	public AmazonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	String TestStepName;

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement SignIn;

	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[1]")
	WebElement SignInButton;

	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement emailID;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement password;

	// @FindBy(xpath="//input[@id='signInSubmit']")
	@FindBy(xpath = "//span[@id='auth-signin-button-announce']")
	WebElement SignInBtn;

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement userHeader;

	@FindBy(xpath = "//label[@for='ap_password']")
	WebElement passHeader;

	@FindBy(xpath = "//label[@for='ap_email']")
	WebElement emailHeader;
	
	@FindBy(xpath = "(//span[contains(text(),'Sign in')])[1]")
	WebElement SignInHover;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement searchIcon;
	
	Actions A;
	static String issueDescription;

	
	//precondition fail steps
			/*
			 * waitForFindElementPresent(searchIcon); searchIcon.submit();
			 * Assert.assertTrue(false);
			 */
	
	
	public void reachSignInPage() throws InterruptedException, IOException 
	{
	
		flag++;
		waitForFindElementPresent(SignIn);
		A = new Actions(driver);
		A.moveToElement(SignIn).build().perform();
		Thread.sleep(2000);
		waitForFindElementPresent(SignInButton);
		SignInButton.click();
		Assert.assertEquals(emailHeader.getText(), "Email or mobile phone number");
		logger.info("Reached Sign In Page");
	}

	public void enterUsername() throws IOException {
		flag++;
		waitForFindElementPresent(emailID);
		emailID.sendKeys(readconfig.getUsername());
		waitForFindElementPresent(continueBtn);
		continueBtn.click();
		waitForFindElementPresent(password);
		Assert.assertEquals(passHeader.getText(), "Password");
		logger.info("Username is entered successfully");
	}

	public void enterPassword() throws IOException {
		flag++;
		waitForFindElementPresent(password);
		SignInBtn.submit();
		Assert.assertTrue(false);
		password.sendKeys(readconfig.getPassword());
		waitForFindElementPresent(SignInBtn);
		Assert.assertEquals(SignInBtn.getText(), "Sign in");
		logger.info("Password is entered successfully");
	}

	public void signIn() throws IOException {
		flag++;
		waitForFindElementPresent(SignInBtn);
		SignInBtn.submit();
		Assert.assertEquals(userHeader.getText(), "Hello, Bhagyashree");
		logger.info("Sign In done successfully");
	}

	
}
