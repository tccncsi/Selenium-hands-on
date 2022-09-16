package com.pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;


public class siteForBookingHotel  extends BasePage{
	
	public siteForBookingHotel  (WebDriver driver) {
	
	super(driver);
	PageFactory.initElements(driver, this);

}
	
	@FindBy (xpath="//div//p[@class=\"fw-700 fs-6 c-neutral-900\"]")
	WebElement getTotalPrice;
	
	@FindBy (xpath="(//div//h2)[2]")
	WebElement addcontdetails;
	
	@FindBy(xpath="(//button[contains(text(),\"Continue\")])[1]")
	WebElement clickcontinue;
	
	@FindBy(xpath="//input[@placeholder=\"Mobile number\"]")
	WebElement mobilenotxtbox;
	
	@FindBy(xpath="//input[@placeholder=\"Email address\"]")
	WebElement clickemailaddress;
	
	@FindBy (xpath="(//button[contains(text(),\"Continue\")])[2]")
	WebElement clickenter;
	
	
	//click on room1 title
	@FindBy(xpath="//span[contains(text(),\"Title\")]")
	WebElement firsttitle;
	
	//click on Ms. title
	@FindBy(xpath="//li[3]")
	WebElement clickonthirdtitle;
	
	//room1 enter first name
	@FindBy(xpath="(//input[contains(@placeholder,'First name')])[1]")
	WebElement firstnameroomfirst;
	
	//room1 enter last name
	@FindBy(xpath="(//input[contains(@placeholder,'Last name')])[1]")
	WebElement lastnameroomfirst;
	
	//room2 title
	@FindBy (xpath="(//div[@class=\"p-relative\"])[7]//button")
	WebElement clickonsecondtitle;
	
	//room2 enter second firstname
	@FindBy (xpath="(//input[contains(@placeholder,'First name')])[2]")
	WebElement enterfirstname;
	
	//room2 last name
	@FindBy(xpath="(//input[contains(@placeholder,'Last name')])[2]")
	WebElement entersecondlastname;
	
	//click on continue to payment
	@FindBy(xpath="//button[contains(text(),'Continue to payment')]")
	WebElement continuepaybtn;
	
	// get the total price
	public void getTotalPrice() {
	String price = driver.findElement(By.xpath("//div//p[@class=\"fw-700 fs-6 c-neutral-900\"]")).getText();
	String[] price1 = price.split("\n");
	String oldprice;
	if (price1.length > 1) {
		System.out.println(price1[1]);
		oldprice = price1[1].substring(0, 0) + price1[1].substring(0 + 1);
	} else {
		System.out.println(price1[0]);
		oldprice = price1[0].substring(0, 0) + price1[0].substring(0 + 1);
	}
	System.out.println("Oldprice" + oldprice);
	oldprice = oldprice.replaceAll(",", "");
	System.out.println("OldPrice without comma and rupees sign" + oldprice);
	}
	// get the total price
	/*
	 * public String getTotalprice() { waitForFindElementPresent(getTotalPrice);
	 * System.out.println(getTotalPrice.getText()); return getTotalPrice.getText();
	 * }
	 */
	//scroll till add contact details
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addcontdetails);
	}
	
	//click on continue button
	public void clickoncontinue() {
		waitForFindElementPresent(clickcontinue);
		clickcontinue.click();
		
	}
	
	public void clickonmobilenumber() {
		waitForFindElementPresent(mobilenotxtbox);
		mobilenotxtbox.click();
	
	}
	
	public void entermobilenumber(String number) {
		waitForFindElementPresent(mobilenotxtbox );
		mobilenotxtbox.sendKeys("1234567890");
	}
	
	public void clickemail() {
		waitForFindElementPresent(clickemailaddress);
		clickemailaddress.click();
	}
	
	public void enteremailaddress(String mail) {
		waitForFindElementPresent(clickemailaddress);
		clickemailaddress.sendKeys("aradhanashinde@gmail.com");
	}
	
	public void clickenterafteremail() {
		waitForFindElementPresent(clickenter);
		clickenter.click();
	}
	
	public void clickfirstroomtitle() {
		waitForFindElementPresent(firsttitle);
		firsttitle.click();
	}
	
	public void clickonthirdtitle() {
		waitForFindElementPresent(clickonthirdtitle);
		clickonthirdtitle.click();
	}
	
	public void clickfirstname() {
		waitForFindElementPresent(firstnameroomfirst);
		firstnameroomfirst.click();
	}
	
	public void enternameroomone(String name) {
		waitForFindElementPresent(firstnameroomfirst);
		firstnameroomfirst.sendKeys(name);
	}
	
	public void clicklastname() {
		waitForFindElementPresent(lastnameroomfirst);
		lastnameroomfirst.click();
	}
	
	public void enterlastname(String lastname) {
		waitForFindElementPresent(lastnameroomfirst);
		lastnameroomfirst.sendKeys(lastname);
	}
	
	public void clicksecondtitle() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForFindElementPresent(clickonsecondtitle);
		clickonsecondtitle.click();
	}
	
	public void clicksecondname() {
		waitForFindElementPresent(enterfirstname);
		enterfirstname.click();
	}
	
	public void entersecondname(String secondname) {
		waitForFindElementPresent(enterfirstname);
		enterfirstname.sendKeys(secondname);
	}
	
	
	//click on last name of room2
	public void clickonlastname() {
		waitForFindElementPresent(entersecondlastname);
		entersecondlastname.click();
	}
	
	//enter data in last name room 2
	public void entersecondlastname(String secondlastname) {
		waitForFindElementPresent(entersecondlastname);
		entersecondlastname.sendKeys(secondlastname);
	}
	
	//click on continue payment button
	public void clickoncontinuepay() {
		waitForFindElementPresent(continuepaybtn);
		continuepaybtn.click();
	}
	
	//scroll down after continue payment button
	public void scrolltillbottom() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
}