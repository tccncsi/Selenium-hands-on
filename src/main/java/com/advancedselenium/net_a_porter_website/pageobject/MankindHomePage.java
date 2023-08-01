package com.advancedselenium.net_a_porter_website.pageobject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class MankindHomePage extends BasePage {

	public MankindHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	//Different locators

	@FindBy(css = "#onetrust-banner-sdk > div > div.ot-sdk-container > div")
	WebElement popup;

	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement accept_btn;

	@FindBy(css = ".emailReengagement_container")
	WebElement sign_up_popup;

	@FindBy(css = ".emailReengagement_close_button")
	WebElement sign_up_close_btn;

	@FindBy(css = "li.responsiveFlyoutMenu_levelOneItem-slide:nth-child(5) > a:nth-child(1)")
	WebElement skin_tab;

	@FindBy(xpath = "//span[contains(.,'Face Masks')]")
	WebElement face_mask_option;

	@FindBy(css = "div.responsiveProductListPage_topPagination > nav > ul")
	WebElement pages_at_facemasks_page;
	
	@FindBy(xpath="//*[@id=\"home\"]/div[1]/section/div/section/div[2]/div[1]/aside/div/div/div[2]/div[1]/button")
	WebElement clear_all_filter_btn;

	@FindBy(xpath = "(//nav[@class='responsivePaginationPages'])[1]//button[@title='Next page']")
	WebElement load_more_products_btn;
	
	@FindBy(css = "#mainContent > div.productListProducts > ul")
	WebElement basic_product_list_ul;
	
	@FindBy(css="div.responsiveFacets_content > div > div:nth-child(8) > div.responsiveFacets_sectionContentWrapper > fieldset > label:nth-child(5)")
	WebElement price_range;

	//Declaring lists to store products from different pages
	List<WebElement> initial_productlist = new ArrayList<WebElement>();
	List<WebElement> final_productlist=new ArrayList<WebElement>();
	//List for storing prices for different products
	List<String> price_list=new ArrayList<String>();
	

	//Handling the cookie popup
	public void handleCookiePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(popup));

			if (popup.isDisplayed()) {
				accept_btn.click();
			}
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// The popup was not found, or it did not appear within the given wait time.
			
		}

	}

	//Handling the SignUp popup
	public void handleSignUpPopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(sign_up_popup));

			if (sign_up_popup.isDisplayed()) {
				sign_up_close_btn.click();
			}
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// The popup was not found, or it did not appear within the given wait time.
			
		}

	}
	

	//Generic method to get web element lists for a tagname under a particular web element 
	public List<WebElement> get_dropdown_list(WebElement ele, String tagname) {
		return ele.findElements(By.tagName(tagname));

	}

	
	//Getting product list for the default page
	public int recording_all_products_for_default_page(WebElement ele,List<WebElement> mpl) throws InterruptedException {
		int index=1;
		while(index<=7) {
			Thread.sleep(15000);
			getting_all_list(ele,mpl);
			waitForFindElementPresent(load_more_products_btn);
			if(index!=7) {
			load_more_products_btn.click();
			index++;}
			else {
				break;
			}
			
		}
		return mpl.size();
	}

	
	//Getting prices for different products after selecting price range
	public int recording_all_products_for_price_filter_page(WebElement ele) throws InterruptedException {
		int index=1;
		while(index<=2) {
			Thread.sleep(15000);
			storing_all_prices(ele,price_list);
			waitForFindElementPresent(load_more_products_btn);
			if(index!=2) {
			load_more_products_btn.click();
			index++;}
			else {
				break;
			}
			
		}
		return price_list.size();
	}

	
	//Generic method to get text for a given attribute of a particular web element
	public String get_text_for_specific_attribute_value(String attribute, WebElement ele) {
		waitForFindElementPresent(ele);
		action.moveToElement(ele).perform();
		return ele.getAttribute(attribute);

	}

	//Generic method to get all the products under a particular web element
	public void getting_all_list(WebElement ele,List<WebElement> plist) {

		List<WebElement> allOptions = get_dropdown_list(ele, "li");
		//System.out.println(allOptions.size());
		Iterator<WebElement> it = allOptions.iterator();

		while (it.hasNext()) {
			plist.add(it.next());
		}

	}
	
	

	//Generic method to hover a particular element
	public void hovering_over_tab(WebElement ele) {

		Actions action = new Actions(driver);
		waitForFindElementPresent(ele);
		action.moveToElement(ele).perform();

	}
	
	//method to store prices of different products 
	public void storing_all_prices(WebElement ele,List<String> plist) {
		
		List<WebElement> allOptions = get_dropdown_list(ele, "li");
		//System.out.println(allOptions.size());
		Iterator<WebElement> it = allOptions.iterator();

		while (it.hasNext()) {
			WebElement p=it.next().findElement(By.tagName("div"));
			plist.add(p.getAttribute("data-product-price"));
			//System.out.println(p.getAttribute("data-product-price"));
		}

		
	}
	
	public boolean skin_tab_displayed() {
		waitForFindElementPresent(skin_tab);
		return skin_tab.isDisplayed();
	}

	//Using generic method to hover over different elements
	public void hovering_over_skin_tab() {
		hovering_over_tab(skin_tab);
	}

	public void click_on_facemask() {
		waitForFindElementPresent(face_mask_option);
		face_mask_option.click();
	}
	
	public void price_range_selection() {
		waitForFindElementPresent(price_range);
		price_range.click();
	}
	
	public boolean price_range_option_displayed() {
		waitForFindElementPresent(price_range);
		return price_range.isDisplayed();
	}

	public int storing_all_products_for_originallist() throws InterruptedException {
		int numOfProd=recording_all_products_for_default_page(basic_product_list_ul,initial_productlist);
		return numOfProd;
	}
	
	
	public int storing_all_products_for_price_filter_page() throws InterruptedException {
		int total_price=recording_all_products_for_price_filter_page(basic_product_list_ul);
		return total_price;
	}
	
	public int checking_each_price_value_lies_in_range() {
	    int correct = 0;
	    for (String price : price_list) {
	        if (price != null && !price.isEmpty()) { 
	            try {
	                double value = Double.parseDouble(price); 
	                if (value >= 15.0 && value <= 30.0) {
	                    correct++;
	                }
	            } catch (NumberFormatException e) {
	                // Handle the case where the value cannot be parsed into a double
	                // You can log the error or perform other actions as needed.
	                // For example:
	                // System.err.println("Error parsing value: " + price);
	            }
	        }
	    }
	    return correct;
	}

	
	public void click_on_clear_all_button() {
		waitForFindElementPresent(clear_all_filter_btn);
		clear_all_filter_btn.click();
	}
	
	public boolean clear_all_button_displayed() {
		waitForFindElementPresent(clear_all_filter_btn);
		return clear_all_filter_btn.isDisplayed();
	}
	
	public int storing_all_products_after_removing_filter() throws InterruptedException {
		return recording_all_products_for_default_page(basic_product_list_ul,final_productlist);
	}
	
	public boolean checking_if_displayed_products_are_equal() {
		 boolean areEqual = initial_productlist.equals(final_productlist);
		 return areEqual;
	}
	
	
	
	
	
	
	
	

}
