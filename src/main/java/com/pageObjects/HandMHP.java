package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;

public class HandMHP extends BasePage {

	public HandMHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[text()='Accept all cookies'])[1]")
	WebElement accept_cookies;

	public void click_accept_cookies() {
		waitForFindElementPresent(accept_cookies);
		accept_cookies.click();
	}

	@FindBy(css = "ul.MLEL > li:nth-child(7) > a")
	WebElement sportMenu;

	public void mouseOversportMenu() {
		action = new Actions(driver);
		action.moveToElement(sportMenu).perform();
	}

	@FindBy(xpath = "(//a[contains(@href, '/en_in/sport/men/view-all.html')])[1]")
	WebElement sport_viewall;

	public void click_sport_viewall() {
		waitForFindElementPresent(sport_viewall);
//		sport_viewall.click();
		executor.executeScript("arguments[0].click();", sport_viewall);
	}

	@FindBy(xpath = ("(//a[contains(@href,'/en_in/sport/men/new-arrivals.html')])[2]"))
	WebElement sport_new_arrival;

	public void click_sport_new_arrival() {
		waitForFindElementPresent(sport_new_arrival);
		sport_new_arrival.click();
//		executor.executeScript("argument[0].click();", sport_new_arrival);
	}

	@FindBy(css = "form.js-product-filter-form > fieldset:nth-child(1) > button")
	WebElement sortby_dropdown;

	public void click_sortby_dropdown() {
		sortby_dropdown.click();
	}

	@FindBy(xpath = "//input[@id='dropdown-sort-bestmatch']")
	WebElement Recommended;

	public boolean check_recommended_selected() {
		return Recommended.isSelected();
	}

	@FindBy(xpath = "(//li[@class='inputwrapper'])[1]")
	WebElement recommendedbutton;

	public void click_recommendedbutton() {
		recommendedbutton.click();
	}

	@FindBy(xpath = "(//li[@class='inputwrapper'])[3]")
	WebElement LowestPrice;

	public void click_LowestPrice() {
		LowestPrice.click();
	}

	@FindBy(xpath = "//ul[@class='products-listing small']/li/article/div/a")
	List<WebElement> All_Items;

	public String[] store_All_Items_href() {
		implicitWait();
		implicitWait();
		return fetch_all_href(All_Items);
	}

	@FindBy(xpath = "//h2[@class='load-more-heading']")
	WebElement Loadmore_message;

	public boolean get_loadmore_message() throws InterruptedException {

		Thread.sleep(2000);
	    String messageText = getText(Loadmore_message);
	    System.out.println(messageText);
	    
	    String[] text = messageText.split(" ");
	    System.out.println(text[1] + " " + text[3]);
	    
	    
	    int value1 = Integer.parseInt(text[1]);
	    int value3 = Integer.parseInt(text[3]);
	    
	    if (value1 == value3) {
	        System.out.println("False msg " + value1);
	        return false;
	    } else {
	        System.out.println("True msg " + value1);
	        return true;
	    }
	}


	public void load_all_items() throws InterruptedException {
		
		while (get_loadmore_message()) {
			System.out.println("About to click");
			Thread.sleep(4000);
			click_loadmorebutton();
			executor.executeScript("window.scrollTo(0, document.body.scrollHeight-1000);");
		}
		
	}

	@FindBy(xpath = "//button[text()='Load more products']")
	WebElement loadmorebutton;

	public void click_loadmorebutton() {
		loadmorebutton.click();
	}

}
