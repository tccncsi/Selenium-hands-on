package com.advancedselenium.net_a_porter_website.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class NetAPorterHomePage extends BasePage{
	
	public NetAPorterHomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

}
