package com.pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BasePage;
import com.utilities.ReadConfig;

public class AmazonBabyPage extends BasePage
{

	public AmazonBabyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement Babylink;
	
	@FindBy(xpath = "(//*[contains(text(),'Diapers & wipes')])[1]")
	WebElement ProductType;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement SearchBar;
	
	@FindBy(xpath = "(//*[contains(text(),'Pampers Premium Care Pants')])[1]")
	WebElement diaperProduct;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement SignIn;
	
	@FindBy(xpath= "(//*[contains(text(),'Sign in')])[1]")
	WebElement SignInButton;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement SignInBtn;
	
	@FindBy(xpath = "(//span[contains(text(),'RESULTS')])[1]")
	WebElement resultHeader;
	
	@FindBy(xpath = "//div[@class='s-suggestion-container']/div")
	WebElement suggestionBox;
	
	@FindBy(xpath = "//label[@for='ap_email']")
	WebElement emailHeader;
	
	public ReadConfig readconfig = new ReadConfig();
	Actions A;
	
	
	public void NavigateToProduct()
	{
		flag++;
		Select s = new Select(Babylink);
		s.selectByVisibleText("Baby");
		Assert.assertEquals(s.getFirstSelectedOption().getText(), "Baby");
		logger.info("Navigated to Baby Section");
	}
	
	public void EnterProductOnSearchBar()
	{
		flag++;
		waitForFindElementPresent(SearchBar);
		SearchBar.click();
		Assert.assertTrue(false);
		//SearchBar.sendKeys(readconfig.getProduct());
		Assert.assertEquals("Pampers premium care large", readconfig.getProduct());
		
	}
	
	public void hitEnter()
	{
		flag++;
		SearchBar.sendKeys(Keys.ENTER);
		Assert.assertEquals(resultHeader.getText(),"RESULTS");
		logger.info("Result of Search bar should be visible");
	}
	
	public void login() throws InterruptedException
	{
		waitForFindElementPresent(SignIn);
		A = new Actions(driver);
		A.moveToElement(SignIn).build().perform();
		Thread.sleep(2000);
		waitForFindElementPresent(SignInButton);
		SignInButton.click();
		
		waitForFindElementPresent(emailID);
		emailID.sendKeys(readconfig.getUsername());
		waitForFindElementPresent(continueBtn);
		continueBtn.click();
		waitForFindElementPresent(password);
		
		waitForFindElementPresent(password);
		password.sendKeys(readconfig.getPassword());
		
		waitForFindElementPresent(SignInBtn);
		//precondition failed step
		//Assert.assertTrue(false);
		SignInBtn.click();
		
	}
	

}
