package com.advancedselenium.net_a_porter_website.pageobject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class FreePeopleHomePage extends BasePage{
	
	public FreePeopleHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="#l1-jeans")
	WebElement jeans_tab;
	
	@FindBy(css="div > div.c-pwa-super-nav-dropdown__flex > div.c-pwa-super-nav-dropdown__flex-column.c-pwa-super-nav-dropdown__flex-column--b.c-pwa-super-nav-dropdown__flex-column--2-wide > div > ul:nth-child(1)")
	WebElement jeans_tab_first_section;
	
	@FindBy(css="div > ul:nth-child(2)")
	WebElement jeans_tab_second_section;
	
	@FindBy(css="div.c-pwa-super-nav-dropdown__flex > div:nth-child(2) > div > div > ul")
	WebElement jeans_tab_third_section;
	
	@FindBy(css="div.c-pwa-super-nav-dropdown__flex > div:nth-child(3) > div")
	WebElement jeans_tab_fourth_section;
	
	@FindBy(css="div.c-pwa-super-nav-dropdown__flex > div:nth-child(4) > div")
	WebElement jeans_tab_fifth_section;
	
	String url = "";
	HttpURLConnection huc = null;
	int respCode = 200;
	
	public void hovering_over_tab(WebElement ele) {
			
			Actions action = new Actions(driver);
			waitForFindElementPresent(ele);
			action.moveToElement(ele).perform();
			
		}
	
	public List<WebElement> get_dropdown_list(WebElement ele) {
		return ele.findElements(By.tagName("a"));
		
	}
	
		
	public String get_text_for_specific_attribute_value(String attribute,WebElement ele) {
		hovering_over_tab(ele);
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
			
			assertTrue(respCode==200,url+" is a broken link !!");
			
	  		
//
//			if(respCode >= 400){
//			System.out.println(url+" is a broken link");
//			}
//			else{
//			System.out.println(url+" is a valid link");
//			}

			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	}
	
	public boolean jeans_tab_displayed() {
		return jeans_tab.isDisplayed();
	}
	
	
	public void hovering_over_jeans_tab() {
		hovering_over_tab(jeans_tab);
	}
	
	public void validating_all_links_under_jeans_section() {
		getting_all_list(jeans_tab_first_section);
		getting_all_list(jeans_tab_second_section);
		getting_all_list(jeans_tab_third_section);
		getting_all_list(jeans_tab_fourth_section);
		getting_all_list(jeans_tab_fifth_section);
	}


	

}
