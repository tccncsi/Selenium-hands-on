package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class NetAPorterHP extends BasePage {

	public NetAPorterHP(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "section.LocaleSwitch2 > div > div ")
	WebElement country_switch;
	
	@FindBy(css="section.LocaleSwitch2")
	WebElement language_switch;
	
	public void click_language_switch() {
		waitForFindElementPresent(language_switch);
		language_switch.click();
	}
	
	@FindBy(css="ul.LanguageSwitchOverlay2 > li:nth-child(2)")
	WebElement china;
	
	public void click_china() {
		waitForFindElementPresent(china);
		china.click();
	}
	
	@FindBy(css="ul.LanguageSwitchOverlay2 > li:nth-child(2)")
	WebElement english;
	
	public void click_english() {
		waitForFindElementPresent(english);
		english.click();
		implicitWait();
	}
		
	@FindBy(xpath = "//span[text()='Albania']")
	WebElement Albania;
	
	public void click_Albania() {
		waitForFindElementPresent(Albania);
		Albania.click();
	}
	
	@FindBy(xpath = "//span[text()='India']")
	WebElement India;
	
	public void click_India() {
		waitForFindElementPresent(India);
		India.click();
	}
	
	@FindBy(xpath = "//span[text()='Algeria']")
	WebElement Algeria;
	
	public void click_Algeria() {
		waitForFindElementPresent(Algeria);
		Algeria.click();
	}
	
	@FindBy(xpath = "//span[text()='Algeria']")
	WebElement Andorra;
	
	public void click_Andorra() {
		waitForFindElementPresent(Andorra);
		Andorra.click();
	}
	
	@FindBy(xpath = "//span[text()='Algeria']")
	WebElement Anguilla;
	
	public void click_Anguilla() {
		waitForFindElementPresent(Anguilla);
		Anguilla.click();
	}
	
	@FindBy(xpath = "(//a[@class='Account2__anchor'])[1]")
	WebElement Account;
	
	public void click_Account() {
		Account.click();
	}
	
}
