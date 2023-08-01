package com.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class AmazonTodayDeal extends BasePage{

	public AmazonTodayDeal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//ul[@class='a-nostyle'])[3]//a[@aria-pressed='false']")
	List<WebElement> discountsCategory;
	
	@FindBy(css = "div.Grid-module__gridDisplayGrid_2X7cDTY7pjoTwwvSRQbt9Y > div > div > div > div > span > div:nth-child(1) > div:nth-child(1)")
	List<WebElement> allProduct;
	
	@FindBy(xpath = "//div[@class='a-size-mini oct-deal-badge-element oct-deal-badge-label']")
	List<WebElement> allProductItem;
	
	@FindBy(css = "input#add-to-cart-button")
	WebElement addToBag;
	
	@FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
	WebElement ProductItemPrice;
	
	@FindBy(css = "span#sw-gtc > span > a")
	WebElement goToCart;
	
	@FindBy(css = "span#sc-subtotal-amount-activecart > span")
	WebElement priceCart;
	
	public int getMaxDiscountCategory() {
		ArrayList<String> discounts = fetch_all_text(discountsCategory);
		String max_discount = Collections.max(discounts);
		System.out.println("Clicked on Discount Category : "+max_discount);
		return discounts.indexOf(max_discount)+1;
	}


	public void click_MaxDisc(int indexDisc) {
		driver.findElement(By.xpath("((//ul[@class='a-nostyle'])[3]//a[@aria-pressed='false'])["+indexDisc +"]")).click();
	}


	public int getMaxProduct() {
		implicitWait();
		ArrayList<String> products = fetch_all_text(allProduct);
		String maxProduct = Collections.max(products);
		System.out.println("Clicked on Max Product having Discount : "+maxProduct);
		return products.indexOf(maxProduct)+1;
	}


	public void click_MaxProduct(int indexProduct) {
		driver.findElement(By.xpath("(//div[@class='DealGridItem-module__dealItemContent_1vFddcq1F8pUxM8dd9FW32']/div/a)["+indexProduct+"]")).click();
	}


	public int getMaxProductItem() {
		implicitWait();
		ArrayList<String> items = fetch_all_text(allProductItem);
		String maxProductItem = Collections.max(items);
		System.out.println("Clicked on Max Product Item having Discount : "+maxProductItem);
		return items.indexOf(maxProductItem);
	}


	public void click_MaxProductItem(int indexProductItem) {
		driver.findElement(By.xpath("(//span[@class=\"a-list-item\"]//a[@class='a-link-normal'])["+indexProductItem+"]")).click();	
	}
	
	
	public void click_addToBag() {
		addToBag.click();
	}


	public int getMaxProductItemPrice() {
		int price = Integer.parseInt(getText(ProductItemPrice));
		return price;
	}


	public void click_goToCart() {
		goToCart.click();
	}


	public int getPriceFromCart() {
		double price =  Double.parseDouble(getText(priceCart));
		return (int)price;
	}
	
	
	

}
