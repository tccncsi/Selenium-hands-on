package com.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;


public class Account extends BasePage{
	
	public Account(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="footer.LoginAndRegistrationForm20__footer > div:nth-child(2) > a")
	WebElement create_account;
	
	public void click_create_account() {
		create_account.click();
	}
	
	@FindBy(css="input#logonId")
	WebElement Email;
	
	public void enter_Email(String regEmail) {
		Email.sendKeys(regEmail);
	}
	
	@FindBy(css="input.PasswordInput4__input")
	WebElement Password;
	
	public void enter_Password(String regPassword) {
		Password.sendKeys(regPassword);
	}
	
	@FindBy(css="div.CombinedSelect11__label")
	WebElement Title_drop;
	
	@FindBy(xpath="//li[text()='Mr']")
	WebElement Title_Mr;
	
	public void enter_Title() {
		Title_drop.click();
		waitForFindElementPresent(Title_Mr);
		Title_Mr.click();
	}
	
	@FindBy(xpath="//input[@id='registration.firstName']")
	WebElement Firstname;
	
	public void enter_Firstname(String regFirst) {
		Firstname.sendKeys(regFirst);
	}
	
	@FindBy(xpath="//input[@id='registration.lastName']")
	WebElement Lastname;
	
	public void enter_Lastname(String regLast) {
		Lastname.sendKeys(regLast);
	}
	
	@FindBy(xpath="//input[@name='day']")
	public
	WebElement day;
	
	@FindBy(xpath="//input[@name='month']")
	public WebElement month;

	@FindBy(xpath="//input[@name='year']")
	public WebElement year;
	
	public void enter_Dob(String regDay,String regMonth,String regYear) {
		day.sendKeys(regDay);
		month.sendKeys(regMonth);
		year.sendKeys(regYear);
	}
	
	@FindBy(xpath="//span[contains(text(),'14 years old')]")
	WebElement invalidddob;
	
	public String get_invaliddob() {
		return invalidddob.getText();
	}
	
	@FindBy(xpath="//button[text()='Create Account']")
	WebElement CreateAccountButton;
	
	public void click_CreateAccountButton() {
		CreateAccountButton.click();
	}
	
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closebutton;
	
	public void click_closebutton() {
		waitForFindElementPresent(closebutton);
		closebutton.click();
	}
	
	public void clear_DOB() {
		year.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
	}

}
