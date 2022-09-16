package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BasePage;

public class paymentPage extends BasePage {
	

	public paymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[@dir=\"ltr\"]//span")
	WebElement youpayprice;
	
	@FindBy(xpath="//button[contains(text(),'Show QR Code')]")
	WebElement showQRcode;
	  
	@FindBy(xpath="(//div[@class=\"flex  flex-center\"])[2]//p")
	WebElement getpriceonQRcode;
	
	
	@FindBy(xpath="//p[@dir=\"ltr\"]//span")
	WebElement youpay;
	
	
	@FindBy(xpath="//input[@placeholder=\"Enter your UPI ID\"]")
	WebElement enterUPI;
	
	@FindBy(xpath="//input[@id='cardNumber']")
	WebElement cardnumber;
	
	@FindBy(xpath="//div[@class='col-5']//p")
	WebElement clickondebitcard;
	
	@FindBy(xpath="//select[@data-testid='select-month']")
	WebElement clickonexpirymonth;
	
	@FindBy(xpath="//select[@data-testid=\"select-year\"]")
	WebElement selectexpyr;
	
	@FindBy(xpath="//input[@placeholder=\"Name as on card\"]")
	WebElement clicknameoncard;
	
	//cvv
	@FindBy(xpath="//input[@placeholder=\"CVV\"]")
	WebElement cvv;
	
	//click on paynow for debit or credit card
	@FindBy(xpath="//button[contains(text(),'Pay now')]")
	WebElement clickonpaynow;
	
	//get price shown in qr code
	public int getQRcodeprice() {
		waitForFindElementPresent(getpriceonQRcode);
		
		String price = getpriceonQRcode.getText();
		String[] price1 = price.split("\n");
		String QRcodeprice;
		if (price1.length > 1) {
			System.out.println(price1[1]);
			QRcodeprice = price1[1].substring(0, 0) + price1[1].substring(0 + 1);
		} else {
			System.out.println(price1[0]);
			QRcodeprice = price1[0].substring(0, 0) + price1[0].substring(0 + 1);
		}
		System.out.println("price on QR code" + QRcodeprice);
		QRcodeprice = QRcodeprice.replaceAll(",", "");
		System.out.println("Final pay amount" + QRcodeprice);
		return Integer.parseInt(QRcodeprice);
//		Assert.assertTrue(oldprice >oldpricee , "Actual Value is not greater than the constant value");
	}
	//click on show QR code button
	public void clickqrcode() {
		waitForFindElementPresent(showQRcode);
		showQRcode.click();
	}
	
	public int youpayprice() {
		waitForFindElementPresent(youpay);
		String payprice = youpay.getText();
		String[] price1 = payprice.split("\n");
		String youpaymodifiedprice;
		if (price1.length > 1) {
			System.out.println(price1[1]);
			youpaymodifiedprice = price1[1].substring(0, 0) + price1[1].substring(0 + 1);
		} else {
			System.out.println(price1[0]);
			youpaymodifiedprice = price1[0].substring(0, 0) + price1[0].substring(0 + 1);
		}
		System.out.println("Price before QR code" + youpaymodifiedprice);
		youpaymodifiedprice = youpaymodifiedprice.replaceAll(",", "");
		System.out.println("Initial price" + youpaymodifiedprice);
		return Integer.parseInt(youpaymodifiedprice);
		}
	
	//Click UPI ID textbox
	public void clickonUPIID() {
		waitForFindElementPresent(enterUPI);
		enterUPI.click();
	}
	
	//enter UPI ID 
	public void enterUPIID( String id) {
		waitForFindElementPresent(enterUPI);
		enterUPI.sendKeys(id);
		
	}
	
	//click on card details text box
	public void clickoncard() {
		waitForFindElementPresent(cardnumber);
		cardnumber.click();
	}
	
	//enter card number
	public void enterccardno(String cardnum) {
		waitForFindElementPresent(cardnumber);
		this.cardnumber.sendKeys(cardnum);
	}
	
	//click on debit card details
	public void clickoncardpayment() {
		waitForFindElementPresent(clickondebitcard);
		clickondebitcard.click();
	}
	
	//click on expiry month dropdown
	public void expirymonth() {
		waitForFindElementPresent(clickonexpirymonth);
		clickonexpirymonth.click();
	}
	
	public void selectexpmonth() {
		Select month = new Select(clickonexpirymonth);
		month.selectByValue("10");
				
	}
	
	public void clickexpiryyr() {
		waitForFindElementPresent(selectexpyr);
		selectexpyr.click();
	}
	
	public void selectexpiryyear() {
		waitForFindElementPresent(selectexpyr);
		Select year = new Select(selectexpyr);
		year.selectByValue("2025");
	}
	
	//click on nameon card text box
	public void clickoncardname() {
		waitForFindElementPresent(clicknameoncard);
		clicknameoncard.click();
	}
	
	//enter name in card name text box
	public void enternameoncard(String cardholdername) {
		waitForFindElementPresent(clicknameoncard);
		clicknameoncard.sendKeys(cardholdername);
		
	}
	
	public void clickoncvv() {
		waitForFindElementPresent(cvv);
		cvv.click();
	}
	
	//enter cvv
	public void entercvv(String cvvnum) {
		waitForFindElementPresent(cvv);
		cvv.sendKeys(cvvnum);
	}
	
	//click on paynow for debit or credit cards
	public void clickonpaynow() {
		waitForFindElementPresent(clickonpaynow);
		clickonpaynow.click();
	}
	
}
