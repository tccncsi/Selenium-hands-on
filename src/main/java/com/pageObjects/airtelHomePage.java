package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.base.BasePage;
import com.utilities.XLUtils;

public class airtelHomePage extends BasePage {

	public airtelHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// login button
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement loginbtn;

	// Registered mobile number
	@FindBy(xpath = "//input[@placeholder='Registered Mobile Number']")
	WebElement mobilenum;

	// enter password
	@FindBy(xpath = "//input[@placeholder='mPIN (4 digit password)']")
	WebElement password;

	@FindBy(xpath = "//span[contains(text(),'Login Securely')] ")
	WebElement loginsecure;

	// click on electricity bill
	@FindBy(xpath = "//span[contains(text(),'Electricity Bill')]")
	WebElement elecbill;

	// State/UT
	@FindBy(xpath = "//input[@placeholder='State/UT']")
	WebElement state;

	// scroll til this sentence
	@FindBy(xpath = "//span[contains(text(),'Want to grow your business with us?')]")
	WebElement scroll;

	// suggestion of maharashtra in dropdown of state
	@FindBy(xpath = "//span[contains(text(),'Maharashtra')]")
	WebElement selectstate;

	@FindBy(xpath = "//span[contains(text(),'Proceed')]")
	WebElement proceed;

	@FindBy(xpath = "//input[@placeholder='Select Biller']")
	WebElement biller;

	@FindBy(xpath = "//span[contains(text(),'Maharashtra State Electricity Distbn Co Ltd')]")
	WebElement billername;

	@FindBy(xpath = "(//div[@class='mat-form-field-infix'])[3]")
	WebElement consumerno;

	@FindBy(xpath = "//input[@placeholder='Consumer No']")
	WebElement consumerName;

	@FindBy(xpath = "//input[@placeholder='BU']")
	WebElement billingunit;
	
	@FindBy (xpath="//input[@placeholder=\"Enter OTP\"]")
	WebElement enterotp;
	
	@FindBy(xpath="//span[contains(text(),\"Verify\")]")
	WebElement clickonverify;

	// click on login
	public void clickloginbtn() {
		waitForFindElementPresent(loginbtn);
		loginbtn.click();
	}

	// click and enter mobile number
	public void entermobilenum(String mbnum) {
		waitForFindElementPresent(mobilenum);
		mobilenum.click();
		mobilenum.sendKeys(mbnum);
	}

	// click and enter password
	public void enterpass(String passwrd) {
		waitForFindElementPresent(password);
		password.click();
		password.sendKeys(passwrd);
	}

	public void loginsecurely() {
		waitForFindElementPresent(loginsecure);
		loginsecure.click();
	}
	
	

//	 //login flow enter mobileno and password
//	public void loginflow(airtelHomePage money) {
//		// TODO Auto-generated method stub
//		money.clickloginbtn();
//		try {
//			money.entermobilenum(XLUtils.fetchExcelData("mbnum"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			money.enterpass(XLUtils.fetchExcelData("passwrd"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	     loginsecurely();
//	}
//	
	public void electricbill() {
		waitForFindElementPresent(elecbill);
		elecbill.click();
	}

	public void enterState(String State) {
		waitForFindElementPresent(state);
		state.click();
		state.sendKeys(State);

	}

	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
	}

	public void selectState() {
		waitForFindElementPresent(selectstate);
		selectstate.click();

	}

	public void clickonproceed() {
		waitForFindElementPresent(proceed);
		proceed.click();
	}

	public void selectbiller() {
		waitForFindElementPresent(biller);
		biller.click();
	}

	public void selectbillername() {
		waitForFindElementPresent(billername);
		billername.click();
	}

	public void enterconsumerno() {
		waitForFindElementPresent(consumerno);
		consumerno.click();
	}

	public void consumerid(String consumernum) {

		consumerName.sendKeys(consumernum);

	}

	public void clickOnBillUnit() {
		waitForFindElementPresent(billingunit);
		billingunit.click();
	}

	public void enterbillingunit(String billunit) {
		waitForFindElementPresent(billingunit);

		billingunit.sendKeys(billunit);
	}

	public void loginflow() {

		clickloginbtn();
		/*
		 * try { entermobilenum(XLUtils.fetchExcelData("mbnum")); } catch (IOException
		 * e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		waitForFindElementPresent(mobilenum);
		mobilenum.click();
		try {
			mobilenum.sendKeys(XLUtils.fetchExcelData("mbnum"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     enterpass("4321");
		loginsecurely();
		clickonenterotp();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickverify();

	}
	
	//click on enter otp
	public void clickonenterotp() {
		waitForFindElementPresent(enterotp);
		enterotp.click();
	}
	
	//click on verify btn
	public void clickverify() {
		waitForFindElementPresent(clickonverify);
		clickonverify.click();
	}

}
