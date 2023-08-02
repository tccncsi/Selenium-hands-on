package com.advancedselenium.net_a_porter_website.pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class PetiteStudioHomePage extends BasePage{
	
	public PetiteStudioHomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="ul.site-nav.grid-m-hide.grid-t-12.grid-d-12 > li:nth-child(2) > a > span")
	WebElement shop_all_tab;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(1) > a")
	WebElement new_arrivals;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(2) > a")
	WebElement best_sellers;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(3) > a")
	WebElement dresses;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(4) > a")
	WebElement tops;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(5) > a")
	WebElement bottoms;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(6) > a")
	WebElement knit_wear;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(7) > a")
	WebElement outer_wear;
	
	@FindBy(css="#categories_nav > ul > li:nth-child(8) > a")
	WebElement final_sale;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(1) > a")
	WebElement summer23_collection;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(2) > a")
	WebElement suggly_collection;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(3) > a")
	WebElement spring_collection;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(4) > a")
	WebElement buvette_collection;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(5) > a")
	WebElement bussiness_casual;
	
	@FindBy(css="#shopify-section-header > div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(6) > a")
	WebElement accessories;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(1) > a")
	WebElement contact_us_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(3) > a")
	WebElement return_centre_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(4) > a")
	WebElement shipping_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(6) > a")
	WebElement size_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(7) > a")
	WebElement terms_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(8) > a")
	WebElement track_link;
	
	@FindBy(css="div.link-list.help-list > ul > li:nth-child(9) > a")
	WebElement privacy_link;
	
	@FindBy(css="#categories_nav > ul")
	WebElement shop_all_first_section;
	
	@FindBy(css="div.nav-panel-contain.JS-nav-panel-contain > div:nth-child(1) > div > div:nth-child(2) > ul")
	WebElement shop_all_second_section;
	
	@FindBy(css="header:nth-child(3) > div > div.ps-logo.grid-m-2.grid-t-4.grid-d-4 > a > svg")
	WebElement logo;
	
	@FindBy(css="#shopify-section-footer > footer > div.grid > div.grid-m-4.grid-t-3.grid-d-3.link-list-contain > div.link-list.help-list > ul")
	WebElement footer_section;
	
	@FindBy(css="#PS-65285339 > div > div > div > div.cc-bottom_close > img")
	WebElement pop_up_close_btn;
	
	@FindBy(css="#PS-65285339 > div > div > div > div.cc-spinwheel")
	WebElement pop_up_section;
	
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	
	public void hovering_over_tab() {
		
		Actions action = new Actions(driver);
		waitForFindElementPresent(shop_all_tab);
		action.moveToElement(shop_all_tab).perform();
		
	}
	public List<WebElement> get_dropdown_list(WebElement ele) {
		return ele.findElements(By.tagName("a"));
		
	}
	
	public void hovering_over_logo() {
		Actions ac=new Actions(driver);
		waitForFindElementPresent(logo);
		ac.moveToElement(logo).perform();
	}
	
	public String get_text_for_specific_attribute_value(String attribute,WebElement ele) {
		waitForFindElementPresent(ele);
		action.moveToElement(ele).perform();
		return ele.getAttribute(attribute);
		
	}
	
	public void getting_all_list(WebElement ele) {
		
		List<WebElement> allOptions =get_dropdown_list(ele); 
		//System.out.println(allOptions.size());
		Iterator<WebElement> it = allOptions.iterator();

		while(it.hasNext()){
			//handlePopup();
			url=get_text_for_specific_attribute_value("href",it.next());
//			WebElement link=it.next();
//			waitForFindElementPresent(link);
//			action.moveToElement(link).perform();
//
//		url = link.getAttribute("href");

		//System.out.println(url);
		
		if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
			}
		
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if(respCode >= 400){
			System.out.println(url+" is a broken link");
			}
			else{
			System.out.println(url+" is a valid link");
			}

			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	}
	
	public void validating_left_section_for_shopAlltab() {
		getting_all_list(shop_all_first_section);
		
	}
	
	public void validating_right_section_for_shopAlltab() {
		getting_all_list(shop_all_second_section);
	}
	
	public void validating_all_links_under_help_section() {
		getting_all_list(footer_section);
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	public String get_href_attribute_for_the_specified_link(int index) {
//		Actions action = new Actions(driver);
//		
//		if(index==1) {
//			
//			waitForFindElementPresent(new_arrivals);
//			action.moveToElement(new_arrivals).perform();
//			return new_arrivals.getAttribute("href");
//		}
//		else if(index==2) {
//			
//			waitForFindElementPresent(best_sellers);
//			action.moveToElement(best_sellers).perform();
//			return best_sellers.getAttribute("href");
//		}
//		else if(index==3){
//			
//			waitForFindElementPresent(dresses);
//			action.moveToElement(dresses).perform();
//			return dresses.getAttribute("href");
//		}
//		else if(index==4){
//			
//			waitForFindElementPresent(tops);
//			action.moveToElement(tops).perform();
//			return tops.getAttribute("href");
//		}
//		else if(index==5){
//			
//			waitForFindElementPresent(bottoms);
//			action.moveToElement(bottoms).perform();
//			return bottoms.getAttribute("href");
//		}
//		else if(index==6){
//			
//			waitForFindElementPresent(knit_wear);
//			action.moveToElement(knit_wear).perform();
//			return knit_wear.getAttribute("href");
//		}
//		else if(index==7){
//			
//			waitForFindElementPresent(outer_wear);
//			action.moveToElement(outer_wear).perform();
//			return outer_wear.getAttribute("href");
//		}
//		else if(index==8){
//			
//			waitForFindElementPresent(final_sale);
//			action.moveToElement(final_sale).perform();
//			return final_sale.getAttribute("href");
//		}
//		else {
//		
//			return "No value matches";
//		}
//	}
//	
//	public String get_href_attribute_for_second_section(int index) {
//		Actions action = new Actions(driver);
//		
//		if(index==1) {
//			
//			waitForFindElementPresent(summer23_collection);
//			action.moveToElement(summer23_collection).perform();
//			return summer23_collection.getAttribute("href");
//		}
//		else if(index==2) {
//			
//			waitForFindElementPresent(suggly_collection);
//			action.moveToElement(suggly_collection).perform();
//			return suggly_collection.getAttribute("href");
//		}
//		else if(index==3){
//			
//			waitForFindElementPresent(spring_collection);
//			action.moveToElement(spring_collection).perform();
//			return spring_collection.getAttribute("href");
//		}
//		else if(index==4){
//			
//			waitForFindElementPresent(buvette_collection);
//			action.moveToElement(buvette_collection).perform();
//
//			return buvette_collection.getAttribute("href");
//		}
//		else if(index==5){
//			
//			waitForFindElementPresent(bussiness_casual);
//			action.moveToElement(bussiness_casual).perform();
//			return bussiness_casual.getAttribute("href");
//		}
//		else if(index==6){
//			
//			waitForFindElementPresent(accessories);
//			action.moveToElement(accessories).perform();
//			return accessories.getAttribute("href");
//		}		
//		else {
//		
//			return "No value matches";
//		}
//	}
//	
//	
	public String get_href_attribute_under_help_section(int index) {
		Actions action = new Actions(driver);
		
		if(index==1) {
			
			
			waitForFindElementPresent(contact_us_link);
			action.moveToElement(contact_us_link).perform();
			return contact_us_link.getAttribute("href");
		}
		else if(index==3) {
			
			waitForFindElementPresent(return_centre_link);
			action.moveToElement(return_centre_link).perform();
			return return_centre_link.getAttribute("href");
		}
		else if(index==4){
			
			waitForFindElementPresent(shipping_link);
			action.moveToElement(shipping_link).perform();
			return shipping_link.getAttribute("href");
		}
		else if(index==6){
			
			waitForFindElementPresent(size_link);
			action.moveToElement(size_link).perform();

			return size_link.getAttribute("href");
		}
		else if(index==7){
			
			waitForFindElementPresent(terms_link);
			action.moveToElement(terms_link).perform();
			return terms_link.getAttribute("href");
		}
		else if(index==8){
			
			waitForFindElementPresent(track_link);
			action.moveToElement(track_link).perform();
			return track_link.getAttribute("href");
		}
		else if(index==9){
			
			waitForFindElementPresent(privacy_link);
			action.moveToElement(privacy_link).perform();
			return privacy_link.getAttribute("href");
		}
		else {
		
			return "No value matches";
		}
	}
	
	
	// Step 4: Create a method to handle the popup
    public void handlePopup() {
        // Step 5: Use a try-catch block to handle the exception when the popup is not present
        try {
            // Step 6: Use WebDriverWait to wait for the popup to appear (using ExpectedConditions.visibilityOf)
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
            wait.until(ExpectedConditions.visibilityOf(pop_up_section));

            // Step 7: Check if the popup is present before interacting with it
            if (pop_up_section.isDisplayed()) {
                // Step 8: Click on the close button to dismiss the popup
                pop_up_close_btn.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // The popup was not found, or it did not appear within the given wait time.
            // You can handle this exception as needed or ignore it.
        }

        // Step 9: You can continue with your test or other actions on the page...
    }

   





	
//	
}
