package com.advancedselenium.net_a_porter_website.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class NetAPorterAccountPage extends BasePage{
	
	public NetAPorterAccountPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.Panel20__header > h2")
	WebElement register_page_heading;
	
	@FindBy(css="#logonId")
	WebElement email_field;
	
	@FindBy(css="#registration\\.logonPassword")
	WebElement password_field;
	
	@FindBy(xpath="//div[@role='combobox']")
	WebElement userTitleDropdown;

	@FindBy(xpath="//*[@id='loginRegistration']/div[2]//ul/li[2]")
    WebElement selectUserTitle;
	
	@FindBy(css="#registration\\.firstName")
	WebElement firstname_field;
	
	@FindBy(css="#registration\\.lastName")
	WebElement lastname_field;
	
	@FindBy(css="div.ValidatedField14.ValidatedField14--registration\\.dateOfBirthGroup.RegistrationForm20__dateOfBirthGroup > div > input:nth-child(1)")
	WebElement birthday_date_field;
	
	@FindBy(css="div.ValidatedField14.ValidatedField14--registration\\.dateOfBirthGroup.RegistrationForm20__dateOfBirthGroup > div > input:nth-child(2)")
	WebElement birthday_month_field;
	
	@FindBy(css="div.ValidatedField14.ValidatedField14--registration\\.dateOfBirthGroup.RegistrationForm20__dateOfBirthGroup > div > input:nth-child(3)")
	WebElement birthday_year_field;
	
	@FindBy(css="div.RegistrationForm20__consent.RegistrationForm20__consent--isCheckoutV3 > div > div > div > div")
	WebElement sign_up_check_box;
	
	@FindBy(css="div.SimpleAsyncButton10__asyncButtonWrapper.LoginAndRegistrationForm20__submitContainer > button")
	WebElement create_account_button;
	
	@FindBy(css="#loginRegistration > div.Captcha10")
	WebElement captcha_container;
	
	@FindBy(css="div.Notification13.Notification13--field-error.ValidatedField14__error > div > span")
	WebElement invalid_date_error_msg;
	
	@FindBy(css="div.ValidatedField14.ValidatedField14--logonId.ValidatedField14--error.LoginAndRegistrationForm20__email.LoginAndRegistrationForm20__email--error > div > div > span")
	WebElement email_error_msg;
	
	@FindBy(css="div.Notification13.Notification13--field-error.ValidatedField14__error > div > span")
	WebElement password_error_msg;
	
	
	
	
	public String get_register_page_heading() {
		waitForFindElementPresent(register_page_heading);
		return register_page_heading.getText();
	}
	
	public void enter_email(String regemail) {
		waitForFindElementPresent(email_field);
		email_field.sendKeys(regemail);
	}
	
	public void enter_password(String regpassword) {
		waitForFindElementPresent(password_field);
		password_field.sendKeys(regpassword);
	}
	
	public void enter_firstname(String regfname) {
		waitForFindElementPresent(firstname_field);
		firstname_field.sendKeys(regfname);
	}
	public void enter_lastname(String reglname) {
		waitForFindElementPresent(lastname_field);
		lastname_field.sendKeys(reglname);
	}
	public void enter_birthday_date(String regbdate) {
		waitForFindElementPresent(birthday_date_field);
		birthday_date_field.sendKeys(regbdate);
	}
	public void enter_birthday_month(String regbmonth) {
		waitForFindElementPresent(birthday_month_field);
		if(regbmonth.length()==1) {
			regbmonth="0"+regbmonth;
		}
		birthday_month_field.sendKeys(regbmonth);
	}
	public void enter_birthday_year(String regbyear) {
		waitForFindElementPresent(birthday_year_field);
		birthday_year_field.sendKeys(regbyear);
	}
	public void clicking_on_title_dropdown_menu() {
		waitForFindElementPresent(userTitleDropdown);
		userTitleDropdown.click();
	}
	public void selecting_value_from_dropdown() {
		waitForFindElementPresent(selectUserTitle);
		selectUserTitle.click();
	}
	public void accepting_sign_up_checkbox() {
		waitForFindElementPresent(sign_up_check_box);
		sign_up_check_box.click();
	}
	public void clickingOnCreateAccountButton() {
		waitForFindElementPresent(create_account_button);
		create_account_button.click();
	}
	
	public boolean captcha_is_dispayed() {
		waitForFindElementPresent(captcha_container);
		return captcha_container.isDisplayed();
	}
	
	public String error_msg_for_birthday() {
		waitForFindElementPresent(invalid_date_error_msg);
		return invalid_date_error_msg.getText();
	}
	
	public boolean error_msg_displayed() {
		waitForFindElementPresent(invalid_date_error_msg);
		return invalid_date_error_msg.isDisplayed();
	}
	
	public boolean email_error_displayed() {
		waitForFindElementPresent(email_error_msg);
		return email_error_msg.isDisplayed();
	}
	
	public String email_error_msg() {
		waitForFindElementPresent(email_error_msg);
		return email_error_msg.getText();
	}
	
	public boolean password_error_displayed() {
		waitForFindElementPresent(password_error_msg);
		return password_error_msg.isDisplayed();
	}
	
	public String password_error_msg() {
		waitForFindElementPresent(password_error_msg);
		return password_error_msg.getText();
	}
	
	public void checking_for_invalid_values(String passwordText) {
		
		waitForFindElementPresent(password_field);
		password_field.clear();
		password_field.sendKeys(passwordText);
		password_field.sendKeys(Keys.TAB);
		
		
		
	}

}
