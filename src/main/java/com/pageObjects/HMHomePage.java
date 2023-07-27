package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import com.base.BasePage;

public class HMHomePage extends BasePage {

	public HMHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#onetrust-accept-btn-handler")
	WebElement AcceptCookiesButton;

	@FindBy(css ="div.__5f_w > ul > li:nth-child(7)")
	WebElement SportMenu;
	
	@FindBy(xpath="//a[@class='CGae mYRh vEfo Q7SQ' and @href='/en_in/sport/men/view-all.html']")
	WebElement SportsMenViewAll;
	
	
	
	//Method to accept cookies
    public void acceptCookiesIfDisplayed() {
    	waitForFindElementClickable(AcceptCookiesButton);
    	AcceptCookiesButton.click();
    }
	
    
	//Method to hover on Sport Menu
	public void hoverOverSportMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(SportMenu).perform();
    }
    
	
    //Method to select View All option -> Men's
	public void selectSportsMensViewAll() throws InterruptedException {
		executor.executeScript("arguments[0].click();", SportsMenViewAll);
		//SportsMenViewAll.click();	
		Thread.sleep(3000);
	}
	

}
