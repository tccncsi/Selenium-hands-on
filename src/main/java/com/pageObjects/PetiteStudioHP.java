package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class PetiteStudioHP extends BasePage{
	
	public PetiteStudioHP(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	}
	
//	NAVBAR ITEMS
	
	@FindBy(xpath="(//a[@href=\"/collections/shop-all\"])[1]")
	WebElement shopall;
	
	public void hover_shopall() {
		action = new Actions(driver);
		action.moveToElement(shopall).perform();
	}
	
	@FindBy(xpath="//a[@title='Petite Studio']")
	WebElement logo;
	
	public void click_logo() {
		waitForFindElementPresent(logo);
		logo.click();
	}
	
//	SUB ITEMS IN NAVBAR
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(1) > a")
	WebElement new_arrivallink;
	
	public void click_new_arrivallink() {
		new_arrivallink.click();
	}
	
	public String getatt_arrivallink() {
		String link = new_arrivallink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(2) > a")
	WebElement best_sellerslink;
	
	public void click_best_sellerslink() {
		waitForFindElementPresent(best_sellerslink);
		best_sellerslink.click();
	}

	public String getatt_best_sellerslink() {
		String link = best_sellerslink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(3) > a")
	WebElement dresseslink;
	
	public void click_dresseslink() {
		dresseslink.click();
	}
	
	public String getatt_dresseslink() {
		String link = dresseslink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(4) > a")
	WebElement topslink;
	
	public void click_topslink() {
		topslink.click();
	}

	public String getatt_topslink() {
		String link = topslink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(5) > a")
	WebElement bottomslink;
	
	public void click_bottomslink() {
		bottomslink.click();
	}
	
	public String getatt_bottomslink() {
		String link = bottomslink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(6) > a")
	WebElement knitwearlink;
	
	public void click_knitwearlink() {
		knitwearlink.click();
	}
	
	public String getatt_knitwearlink() {
		String link = knitwearlink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(7) > a")
	WebElement outerwearlink;
	
	public void click_outerwearlink() {
		outerwearlink.click();
	}
	
	public String getatt_outerwearlink() {
		String link = outerwearlink.getAttribute("href");
		return link;
	}
	
	@FindBy(css="div#categories_nav > ul.sub-nav-list > li:nth-child(8) > a")
	WebElement finalsalelink;
	
	public void click_finalsalelink() {
		finalsalelink.click();
	}
	
	public String getatt_finalsalelink() {
		String link = finalsalelink.getAttribute("href");
		return link;
	}
	
	@FindBy(xpath="(//a[text()='Summer 23 Collection '])[1]")
	WebElement Summer;
	
	public String getatt_Summer() {
		String link = Summer.getAttribute("href");
		return link;	
	}
	
	@FindBy(xpath="(//a[text()='Suggyl x Petite Studio '])[1]")
	WebElement Suggyl;
	
	public String getatt_Suggyl() {
		String link = Suggyl.getAttribute("href");
		return link;	
	}
	
	@FindBy(xpath="(//a[text()='Spring 23 Collection '])[1]")
	WebElement spring;
	
	public String getatt_Spring() {
		String link = spring.getAttribute("href");
		return link;
	}
	
	@FindBy(xpath="(//a[text()='Buvette Pearl Collection '])[1]")
	WebElement buvette;
	
	public String getatt_buvette() {
		String link = buvette.getAttribute("href");
		return link;
	}
	
	@FindBy(xpath="(//a[text()='Business Casual '])[1]")
	WebElement business;
	
	public String getatt_business() {
		String link = business.getAttribute("href");
		return link;
	}
	
	@FindBy(xpath="(//a[text()='Accessories '])[1]")
	WebElement accessories;
	
	public String getatt_accessories() {
		String link = accessories.getAttribute("href");
		return link;
	}
	
	
//	Footer
	
	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(1)")
	WebElement contactus;
	
	public String getatt_contactus() {
		String link = contactus.getAttribute("href");
		return link;
	}
	
	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(2)")
	WebElement returncenter;
	
	public String getatt_returncenter() {
		String link = returncenter.getAttribute("href");
		return link;
	}
	
	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(3)")
	WebElement shipping_return;
	
	public String getatt_shipping_return() {
		String link = shipping_return.getAttribute("href");
		return link;
	}
	
	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(4)")
	WebElement size_chart;
	
	public String getatt_size_chart() {
		String link = size_chart.getAttribute("href");
		return link;
	}
	
	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(5)")
	WebElement terms_service;
	
	public String getatt_terms_service() {
		String link = terms_service.getAttribute("href");
		return link;
	}

	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(5)")
	WebElement track;
	
	public String getatt_track() {
		String link = track.getAttribute("href");
		return link;
	}

	@FindBy(css="footer.site-footer > div > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(5)")
	WebElement privacy;
	
	public String getatt_privacy() {
		String link = privacy.getAttribute("href");
		return link;
	}
	
}
