package com.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utilities.XLUtils;

public class airtelPaymentPage extends BasePage {

	public airtelPaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// debit card
	@FindBy(xpath = "(//div[@class='mat-list-item-content'])[1]")
	WebElement debitcardclick;

	// name on card
	@FindBy(xpath = "//input[@placeholder='Name on Card']")
	WebElement nameoncard;

	// card num
	@FindBy(xpath = "//input[@placeholder='Card Number']")
	WebElement cardnumber;

	// Expiry date
	@FindBy(xpath = "//input[@placeholder='Expiry Date (MM/YY)']")
	WebElement expirydate;

	// Cvv
	@FindBy(xpath = "//input[@placeholder='CVV']")
	WebElement entercvv;

	// add now
	@FindBy(xpath = "//span[contains(text(),\"Add Now\")]")
	WebElement addnowbtn;
	
	//click on net banking
	@FindBy(xpath = "//div[contains(text(),'Net banking')]")
    WebElement netBankingLink;
	
	//credit card
	@FindBy(xpath="//div[contains(text(),\"Credit Card\")]")
	WebElement clickoncreditcard;
    
	
	//click on icici radio button
    @FindBy(xpath = "//span[text()='ICICI']")
    WebElement iciciBank;
    
    @FindBy(xpath = "//span[text()='ICICI']")
    WebElement iciciBankradiobtn;

	public void paymentflow(String paytype) {

		try {
			switch (paytype.toLowerCase()) {

			case "debit card":

				debitcard();

				break;

			case "credit card":
				creditcard();
				break;

			case "net banking":
				netbanking();
				break;
			
			default :
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// debit card flow
	public void debitcard() throws IOException {
		clickdebit();
		enternameoncrd(XLUtils.fetchExcelData("name"));
		entercardno(XLUtils.fetchExcelData("card"));
		expydate(XLUtils.fetchExcelData("expdate"));
		entercvvnum(XLUtils.fetchExcelData("cvv"));
		clickonaddnow();
	}

	public void creditcard() throws IOException {
		clickoncredit();
		enternameoncrd(XLUtils.fetchExcelData("name"));
		entercardno(XLUtils.fetchExcelData("card"));
		expydate(XLUtils.fetchExcelData("expdate"));
		entercvvnum(XLUtils.fetchExcelData("cvv"));
		clickonaddnow();

	}

	public void clickdebit() {
		waitForFindElementPresent(debitcardclick);
		debitcardclick.click();
	}

	// enter name on card
	public void enternameoncrd(String name) {
		waitForFindElementPresent(nameoncard);
		nameoncard.click();
		nameoncard.sendKeys(name);
	}

	// enter number on card
	public void entercardno(String card) {
		waitForFindElementPresent(cardnumber);
		cardnumber.click();
		cardnumber.sendKeys(card);
	}

	// enter expiry date
	public void expydate(String expdate) {
		waitForFindElementPresent(expirydate);
		expirydate.click();
		expirydate.sendKeys(expdate);
	}

	// enter cvv
	public void entercvvnum(String cvv) {
		waitForFindElementPresent(entercvv);
		entercvv.click();
		entercvv.sendKeys(cvv);
	}

	// click on add now
	public void clickonaddnow() {
		waitForFindElementPresent(addnowbtn);
		addnowbtn.click();
	}
	
	
	//Click on Net Banking Link
    public void clickOnNetBanking()
    {
        waitForFindElementPresent(netBankingLink);
        netBankingLink.click();
    }
    
    // Click on ICICI radio Button
    public void clickOnICICIRadioButton()
    {
        waitForFindElementPresent(iciciBank);
        iciciBank.click();
    }
    
    //netbanking process
    public void netbanking() {
    	clickOnNetBanking();
    	clickOnICICIRadioButton();
    	clickonaddnow();
    }
    
    //click n credit card
    public void clickoncredit() {
    	waitForFindElementPresent(clickoncreditcard);
    	clickoncreditcard.click();
    }

}
