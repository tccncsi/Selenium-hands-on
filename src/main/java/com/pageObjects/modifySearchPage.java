package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class modifySearchPage extends BasePage {

	
	
public modifySearchPage (WebDriver driver) {
	
	super(driver);
	PageFactory.initElements(driver, this);
}

	@FindBy (xpath="  //input[@name ='search']")
	WebElement Search_txtbox;                                             
	
	@FindBy (xpath="//button[@name='from']//div")
	WebElement Checkin;
	
	@FindBy (id="prefix__up-chevron")
	WebElement Checkout;
	
	@FindBy (xpath = "//button[@name='to']//div")
	WebElement Checkoutdate;
	
	@FindBy (xpath="//button[@name=\"travellers\"]//div")
	WebElement traveller_box;
	
	@FindBy (id="prefix__hotels")
	WebElement Hotel_Logo;
	
	
	
	public String search_txtbox() {					//search textbox assertion
		
		return Search_txtbox.getText();
		
	
	}
	
	public String getcheckin_date() {
		waitForFindElementPresent(Checkin);
		return Checkin.getText();
	}
	
	public String getCheckout_date() {
		return Checkoutdate.getText();
	}
	
	public String adult_child_data() {
		return traveller_box.getText();
	}
}
