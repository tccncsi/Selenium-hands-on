package com.pageObjects.AMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;

public class Random extends BasePage {

	// Function to call the driver
	public Random(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}