package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class TillysHP extends BasePage{

	public TillysHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "li#sale-container > a")
	WebElement nav_Sale;
	
	public void click_nav_Sale() {
		nav_Sale.click();
	}

}
