package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class addMoneyPage extends BasePage {

	public addMoneyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	//click on add money
	@FindBy(xpath="//span[contains(text(),'Add Money')]")
	WebElement addmoney;
	
	//click on 500
	@FindBy(xpath="(//button//span)[2]")
	WebElement clickonrpsfivehundred;
	
	//click on add money btn
	@FindBy(xpath="(//span[contains(text(),\"Add Money\")])[2]")
	WebElement addmoneybtn;
	
	public void clickonrps() {
		waitForFindElementPresent(clickonrpsfivehundred);
		clickonrpsfivehundred.click();
		
	}
	
	public void clickonaddmoney() {
		waitForFindElementPresent(addmoney);
		addmoney.click();
	}
	
	public void clickonaddmoneybtn() {
		waitForFindElementPresent(addmoneybtn);
		addmoneybtn.click();
	}

}
