package com.advancedselenium.net_a_porter_website.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.advance_selenium.net_a_porter_website.base.BasePage;

public class HMHomePage extends BasePage {

	public HMHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.__5f_w > ul > li:nth-child(7) > a")
	WebElement sports_tab;

	@FindBy(xpath="(//a[contains(@href, '/en_in/sport/men/view-all.html')])[1]")
	WebElement view_all_men;
	
	@FindBy(css="#onetrust-banner-sdk > div")
	WebElement pop_up_section;
	
	@FindBy(xpath="//*[@id='onetrust-reject-all-handler']")
	WebElement pop_up_close_btn;
	
	@FindBy(css="#page-content > div > div:nth-child(2) > h1")
	WebElement heading_at_men_page;
	
	@FindBy(css="form > fieldset.dropdown-container.dropdown-sortby > button")
	WebElement sort_dropdown_icon;
	
	@FindBy(css="#dropdown-sort > ul > li:nth-child(1) > label")
	WebElement recomended_option;
	
	@FindBy(xpath = "//input[@id='dropdown-sort-bestmatch']")
	WebElement recomended_radio_btn;
	
	@FindBy(css="#dropdown-sort > ul > li:nth-child(3) > label")
	WebElement lowest_price_option;
	
	@FindBy(css="div.products-filter.sticky-on-scroll.sticky > form > div")
	WebElement items;
	
	@FindBy(css="#page-content > div > div:nth-child(4) > ul")
	WebElement recomended_products;
	
	@FindBy(css="#page-content > div > div:nth-child(4) > div.load-more-products > button")
	WebElement load_more_product;
	
	@FindBy(css="#page-content > div > div:nth-child(4) > ul")
	WebElement all_product_list;

	public void hovering_sports_tab() {

		Actions action = new Actions(driver);
		waitForFindElementPresent(sports_tab);
		action.moveToElement(sports_tab).perform();

	}
	
	
	public void selecting_lowest_price_option() {
		waitForFindElementPresent(lowest_price_option);
		lowest_price_option.click();
		
	}
	
	public void selecting_recomended_option() {
		waitForFindElementPresent(recomended_option);
		recomended_option.click();
	}
	
	public boolean is_recomended_selected() {
		waitForFindElementPresent(recomended_radio_btn);
		//return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].checked;", recomended_option);
		return recomended_radio_btn.isSelected();
	}
	public void selecting_sorting_option() {
		waitForFindElementPresent(sort_dropdown_icon);
		sort_dropdown_icon.click();
		
	}
	
	public void clicking_on_view_all_option() throws InterruptedException {
		Actions ac=new Actions(driver);
		Thread.sleep(3000);
		waitForFindElementPresent(view_all_men);
		action.moveToElement(view_all_men);
		System.out.println(view_all_men.getAttribute("href"));
		Thread.sleep(3000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", view_all_men);
//		waitForFindElementPresent(view_all_men);
//		view_all_men.click();
	}
	
	public void handlePopup() {
       try {
            WebDriverWait wait = new WebDriverWait(driver, 10); 
            wait.until(ExpectedConditions.visibilityOf(pop_up_section));

            if (pop_up_section.isDisplayed()) {
                pop_up_close_btn.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // The popup was not found, or it did not appear within the given wait time.
           
        }

        
    }
	
	public boolean heading_at_men_page() {
		waitForFindElementPresent(heading_at_men_page);
		return heading_at_men_page.isDisplayed();
	}
	
	public String get_heading_at_men_page() {
		waitForFindElementPresent(heading_at_men_page);
		return heading_at_men_page.getText();
	}
	
	public void getting_all_product_under_recomended_option() {
		while(load_more_product.isDisplayed()) {
			load_more_product.click();
		}
	}
	
	
	
	

}
