package com.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ------------------Locators------------------------------------

	@FindBy(css = "div > span.LocaleSwitch2__language.LocaleSwitch2__language--header.LocaleSwitch2__language--hoverCursor")
	WebElement LanguageSelector;

	
	@FindBy(xpath = "//div[@class='Overlay9__content languageSwitchOverlayContent']//ul/li[2]")
	WebElement SelectLanguage;

	
	@FindBy(xpath = "//div[@class='account-icon-left']//a[@class='Account2__anchor']")
	WebElement AccountIcon;

	
	@FindBy(css = "div.ValidatedField14.ValidatedField14--hasAccount.LoginAndRegistrationForm20__hasAccount > a")
	WebElement CreateAccount;

	
	@FindBy(xpath="//input[@type='email']")
	WebElement RegEmail;
	
	
	@FindBy(xpath="//input[@type='password']")
	WebElement RegPassword;
	
	
	@FindBy(xpath="//div[@role='combobox']")
	WebElement UserTitleDropdown;
	
	
	@FindBy(xpath="//*[@id='loginRegistration']/div[2]//ul/li[1]")
	WebElement SelectUserTitle;

	
	@FindBy(xpath="//input[@id='registration.firstName']")
	WebElement FirstName;
	
	
	@FindBy(xpath="//input[@id='registration.lastName']")
	WebElement LastName;
	

	@FindBy(xpath = "//div[@class='InputGroup14']/input[@name='day']")
	WebElement BirthDay;

	
	@FindBy(xpath = "//div[@class='InputGroup14']/input[@name='month']")
	WebElement BirthMonth;

	
	@FindBy(xpath = "//div[@class='InputGroup14']/input[@name='year']")
	WebElement BirthYear;
	

	@FindBy(css="#loginRegistration > div.ValidatedField14.ValidatedField14--registration\\.dateOfBirthGroup.ValidatedField14--error.RegistrationForm20__dateOfBirthGroup.RegistrationForm20__dateOfBirthGroup--error > div.Notification13.Notification13--field-error.ValidatedField14__error")
	WebElement DOBError;
	
	// Submit Button
	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement CASubmitForm;

	
	@FindBy(css="div.Overlay9__header > button")
	WebElement ImageCloseButton;
	
		
	public void clickLanguageSelector() {
		waitForFindElementPresent(LanguageSelector);
		LanguageSelector.click();
	}

	public void selectLanguage() {
		waitForFindElementPresent(SelectLanguage);
		SelectLanguage.click();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getLanguageText() {
		return LanguageSelector.getText();
	}

	public void clickAccountIcon() {
		AccountIcon.click();
	}

	public void clickCreateAccount() {
		executor.executeScript("arguments[0].scrollIntoView(true);", CreateAccount);
		CreateAccount.click();
	}


	
	// ------------------ New Registration Page --------------------------------
	public void enterRegEmail(String RegistrationEmail) {
		RegEmail.sendKeys(RegistrationEmail);
	}
	
	
	public void enterRegPassword(String RegistrationPassword) {
		RegPassword.sendKeys(RegistrationPassword);
	}
	
	
	public void clickTitleDropdown() {
		UserTitleDropdown.click();
	}
	
	public void selectUserTitle() {
		SelectUserTitle.click();
	}
	
	public void enterFirstName(String userFirstName) {
		FirstName.sendKeys(userFirstName);
	}
	
	public void enterLastName(String userLastName) {
		LastName.sendKeys(userLastName);
	}
	
	public void enterBirthDay(String Bday) {
		BirthDay.sendKeys(Bday);
	}

	public void enterBirthMonth(String Bmonth) {
		BirthMonth.sendKeys(Bmonth);
	}

	public void enterBirthYear(String Byear) {
		
		BirthYear.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE); // Select all text and delete
		if(!Byear.isEmpty()) {
			BirthYear.sendKeys(Byear);
		}
	}
	
	public String getDobErrorMessage() {
		return getText(DOBError);
	}
	
	public void clickCASubmitForm() {
		CASubmitForm.click();
	}
	
	public void clickImageCloseButton() {
		waitForFindElementPresent(ImageCloseButton);
		ImageCloseButton.click();
	}
	
	
}
