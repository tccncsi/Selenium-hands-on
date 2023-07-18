package com.advancedselenium.net_a_porter_website.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class NetAPorterHomePage extends BasePage{
	
	public NetAPorterHomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.LocaleSwitch2__language.LocaleSwitch2__language--header.LocaleSwitch2__language--hoverCursor")
	WebElement language_change_button;
	
	
	
	@FindBy(css="div.Overlay9__content.languageSwitchOverlayContent > ul > li:nth-child(2)")
	WebElement language_change;
	
	@FindBy(css="div.account-icon-left > div > div > div > a")
	WebElement account_tab;
	
	@FindBy(css="div.Panel20__header > h2")
	WebElement account_page_heading;
	
	@FindBy(css="div.ValidatedField14.ValidatedField14--hasAccount.LoginAndRegistrationForm20__hasAccount > a")
	WebElement create_account_button;
	
//	@FindBy(css="div.Panel20__header > h2")
//	WebElement register_page_heading;
	
	
	public void click_on_language_change_dropdown() {
		waitForFindElementPresent(language_change_button);
		language_change_button.click();
	}
	
	public void click_on_language_change_dropdown_on_changing_language() throws InterruptedException {
		waitForFindElementPresent(language_change);
		language_change.click();
		Thread.sleep(3000);
	}		
	public String getUrlOfCurrentPage() {
		return driver.getCurrentUrl();
	}
	
	public void click_on_account_tab() {
		waitForFindElementPresent(account_tab);
		account_tab.click();
	}
	
//	public String get_register_page_heading() {
//		return register_page_heading.getText();
//	}
	
	public String get_account_page_heading() {
		return account_page_heading.getText();
	}
	public NetAPorterAccountPage click_on_create_account_btn() {
		create_account_button.click();
		return new NetAPorterAccountPage(driver);
	}
	
	
	

}
