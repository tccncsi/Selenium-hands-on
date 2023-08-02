package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class MankindHomePage extends BasePage {

	public MankindHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='responsiveSubMenu_rightSection']//button")
	WebElement countryIcon;

	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement acceptCookiesButton;

	@FindBy(css = ".emailReengagement_close_button")
	WebElement closeSignUpButton;

	@FindBy(css = ".sessionSettings_shippingCountrySelect > option:nth-child(90)")
	WebElement shippingToCountry;

	@FindBy(css = "option.sessionSettings_countrySiteOption:nth-child(2)")
	WebElement RegionLanguage;

	@FindBy(css = "option.sessionSettings_currencyOption:nth-child(15)")
	WebElement currency;

	@FindBy(css = ".sessionSettings_saveButton")
	WebElement countrySaveButton;

	@FindBy(css = ".sessionSettings_notification")
	WebElement verifyMessage;

	@FindBy(css = ".responsiveAccountHeader_openAccountButton")
	WebElement accountIcon;

	/*-----------------------Methods----------------------------*/

	// Method to accept cookies
	public void acceptCookies() throws InterruptedException {
		implicitWait();
		acceptCookiesButton.click();
		Thread.sleep(1000);
	}

	// Method to close signup
	public void closeSignUpModal() throws InterruptedException {
		implicitWait();
		closeSignUpButton.click();
		Thread.sleep(1000);
	}

	// Method to click on country icon
	public void clickOnCountryIcon() throws InterruptedException {
		countryIcon.click();
		Thread.sleep(3000);
	}

	// Method to select shipping country
	public void selectShippingCountry() {
		shippingToCountry.click();
	}

	// Method to select Region and Language
	public void selectLanguage() {
		RegionLanguage.click();
	}

	// Method to select currency
	public void selectCurrency() {
		currency.click();
	}

	// Method to click on language change save button
	public void clickOnLanguageSaveButton() {
		countrySaveButton.click();
	}

	// Method to get verify message after changing country
	public String getVerifyMessage() {
		return verifyMessage.getText();
	}

	// Method to click on account Icon
	public void clickOnAccountIcon() {
		accountIcon.click();
	}

}
