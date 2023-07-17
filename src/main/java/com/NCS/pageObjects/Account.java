package com.NCS.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NCS.base.BasePage;

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
	
	public void enter_Email() {
		Email.sendKeys("aditya3010singh@gmail.com");
	}
	
	@FindBy(css="input.PasswordInput4__input")
	WebElement Password;
	
	public void enter_Password() {
		Password.sendKeys("Adityasingh12");
	}
	
	@FindBy(css="div.CombinedSelect11__label")
	WebElement Title_drop;
	
	@FindBy(css="//li[@data-value='Mr']")
	WebElement Title_Mr;
	
	public void enter_Title() {
		Title_drop.click();
		waitForFindElementPresent(Title_Mr);
		Title_Mr.click();
	}

}
