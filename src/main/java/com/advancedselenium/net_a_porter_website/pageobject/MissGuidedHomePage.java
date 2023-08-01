package com.advancedselenium.net_a_porter_website.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class MissGuidedHomePage extends BasePage{
	
	public MissGuidedHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//Different Locators 
	
	@FindBy(css="#onetrust-banner-sdk > div > div.ot-sdk-container")
	WebElement cookiePopup;
	
	@FindBy(xpath="//*[@id=\"onetrust-accept-btn-handler\"]")
	WebElement popup_close;
	
	@FindBy(css="#lnkTopLevelMenu_5748297")
	WebElement clothing_tab;
	
	@FindBy(css="#DesktopSortOptions_discountvalue_desc")
	WebElement max_discount_option;
	
	@FindBy(xpath="//*[@id=\"navlist\"]/li[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]")
	WebElement add_to_cart_btn;
	
	@FindBy(css="#ulHsSizes > li:nth-child(1) > a")
	WebElement selecting_size;
	
	@FindBy(css="#addHotspotToBag")
	WebElement add_to_bag_btn;
	
	@FindBy(css="#aViewBag")
	WebElement view_bag_btn;
	
	@FindBy(css="#Lines_0__Quantity")
	WebElement quantity_value;
	
	@FindBy(css="#gvBasketDetails > table > tbody > tr > td.prdQuantity > div > a.BasketQuantBut.s-basket-plus-button")
	WebElement increasing_quantity;
	
	@FindBy(css="#gvBasketDetails > table > tbody > tr > td.itemprice > span.money")
	WebElement price_of_one;
	
	@FindBy(css="#gvBasketDetails > table > tbody > tr > td.itemtotalprice > span.money")
	WebElement total_price;
	
	
	//Handling Cookie Pop ups
	public void handleCookiePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Waiting for up to 10 seconds
			wait.until(ExpectedConditions.visibilityOf(cookiePopup));

			if (cookiePopup.isDisplayed()) {
				popup_close.click();
			}
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
			// The popup was not found, or it did not appear within the given wait time.
			// You can handle this exception as needed or ignore it.
		}

	}
	
	
	public boolean add_to_cart_btn_displayed() {
		waitForFindElementPresent(add_to_cart_btn);
		return add_to_cart_btn.isDisplayed();
	}
	
	public void clicking_on_add_to_cart_btn() throws InterruptedException {
		Thread.sleep(10000);
		waitForFindElementPresent(add_to_cart_btn);
		add_to_cart_btn.click();
	}
	
	public boolean selecting_size_displayed() {
		waitForFindElementPresent(selecting_size);
		return selecting_size.isDisplayed();
	}
	
	public void selecting_suitable_size() {
		waitForFindElementPresent(selecting_size);
		selecting_size.click();
	}
	 
	
	public void clicking_on_add_to_bag() {
		waitForFindElementPresent(add_to_bag_btn);
		add_to_bag_btn.click();
	}
	
	public void clicking_on_clothing_tab() {
		waitForFindElementPresent(clothing_tab);
		clothing_tab.click();
	}
	
	public boolean max_discount_displayed() {
		waitForFindElementPresent(max_discount_option);
		return max_discount_option.isDisplayed();
	}
	
	public void selecting_from_sort_options() {
		waitForFindElementPresent(max_discount_option);
		max_discount_option.click();
	}
	
	public void clicking_on_view_bag_btn() {
		waitForFindElementPresent(view_bag_btn);
		view_bag_btn.click();
	}
	
	public String getting_quantity_value() {
		waitForFindElementPresent(quantity_value);
		String qvalue=quantity_value.getAttribute("value");
		return qvalue;
	}
	
	public void increasing_quantity() {
		
		int index=1;
		while(index!=3) {
			waitForFindElementPresent(increasing_quantity);
			increasing_quantity.click();
			String qntval=getting_quantity_value();
			index=Integer.parseInt(qntval);
			
		}
	}
	
	public boolean calculating_final_price() {
		waitForFindElementPresent(price_of_one);
		String qprice=price_of_one.getText();
		qprice=qprice.substring(1);
		Double price_for_one=Double.parseDouble(qprice);
		Double totalprice=price_for_one*3;
		waitForFindElementPresent(total_price);
		String qtotal=total_price.getText();
		qtotal=qtotal.substring(1);
		Double final_price=Double.parseDouble(qtotal);
		
		 double epsilon = 1e-10; // This value can be adjusted based on your requirements

	        // Compare the two double values using the delta
	        if (Math.abs(final_price - totalprice) < epsilon) {
	            //System.out.println("The values are equal.");
	        	return true;
	        } else {
	            //System.out.println("The values are not equal.");
	        	return false;
	        }
		
	}
	
	public boolean validating_cart() {
		clicking_on_view_bag_btn();
		increasing_quantity();
		boolean result=calculating_final_price();
		return result;
	}
	
	

}
