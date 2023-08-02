package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;

public class DemoPage extends BasePage {

	// Initialize the page factory

	public DemoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='hamburger']")
	WebElement demoLocator;
	
	

	public String demoMethod() {
		return demoLocator.getText();
	}
	
	
}
