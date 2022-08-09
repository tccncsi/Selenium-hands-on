package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Modify_Search_Page {

	WebDriver ldriver;
	
public Modify_Search_Page (WebDriver rdriver) {
	
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}

	@FindBy (xpath= "(//div[@class='p-relative'])[3]")
	WebElement Search_txtbox;                                             
	
	@FindBy (xpath="//button[@name='from']")
	WebElement Checkin;
	
	@FindBy (id="prefix__up-chevron")
	WebElement Checkout;
	
	@FindBy (xpath = "//div[contains(text(),\"Thu, Sep 15\")]")
	WebElement Checkoutdate;
	
	@FindBy (xpath="//div[contains(text(),\"1 Room, 3 Adults, 1 Child\")]")
	WebElement traveller_box;
	
	@FindBy (id="prefix__hotels")
	WebElement Hotel_Logo;
	
	
	
	public String search_txtbox() {					//search textbox assertion
		
		return Search_txtbox.getText();
		
	
	}
	
	public String getcheckin_date() {
		return Checkin.getText();
	}
	
	public String getCheckout_date() {
		return Checkoutdate.getText();
	}
	
	public String adult_child_data() {
		return traveller_box.getText();
	}
}
