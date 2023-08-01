package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class luisaviaromaHP extends BasePage {
	
	public luisaviaromaHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "strong._1GbjI1tJmF")
	static
	WebElement country_ind;
	
	@FindBy(css="strong._1qGsObzeM6")
	static
	WebElement curr_inr;
	
	@FindBy(xpath = "(//span[@class='_21-M-kuzo7'])[3]")
	WebElement MyArea;
	
	@FindBy(xpath = "(//div[@class='_3xxop2kEZw'])[1]//button")
	WebElement register;

	public static String get_country() {
		return country_ind.getText();
	}
	
	public static String get_curr() {
		return curr_inr.getText();
	}
	
	public void click_MyArea() {
		MyArea.click();
	}
	
	public void click_register() {
		waitForFindElementPresent(register);
		register.click();
	}
}



//luisaHomepage = new luisaviaromaHP(driver);
//
////Checks if the country is India and curr is INR
//if (luisaviaromaHP.get_country()=="INDIA") {
//	  Assert.assertEquals(luisaviaromaHP.get_curr(), "INR");
//}
//
//luisaHomepage.click_MyArea();
//
//luisaHomepage.click_register();



