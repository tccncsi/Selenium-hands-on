package com.pageObjects;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class AmericanEagleHP extends BasePage {

	public AmericanEagleHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button#onetrust-accept-btn-handler")
	WebElement acceptcookies;
	
	@FindBy(css = "div.scroll > div > div:nth-child(8) > a")
	WebElement Clearance;
	
	@FindBy(xpath="(//div[@class='column-links'])[18]/a[1]")
	WebElement tops;
	
	@FindBy(xpath="//div[@class='_wrapper_1c1emu']//div[@class='product-sale-price ']")
	List<WebElement> last_chance_all_price;
	
	@FindBy(xpath="(//div[@class='extras-content'])[2]/div[1]/div[1]")
	WebElement sidebar_price;
	
	@FindBy(xpath="//button[@aria-label='increase']")
	WebElement increase_button;
	
	@FindBy(xpath="//span[@class='qty-content _qty-content_gjd6pr']")
	WebElement quantity;
	
	@FindBy(xpath="//button[text()='Add to Bag']")
	WebElement AddToBag;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li/a")
	List<WebElement> All_size; 
	
	@FindBy(xpath="(//ul[@class='dropdown-menu']/li[@class='  '])[1]")
	WebElement available;
	
	@FindBy(css="div.buttons-container > button:nth-child(2)")
	WebElement ViewBag;
	
	@FindBy(css="div.order-subtotal-container > div:nth-child(1) > div:nth-child(2) ")
	WebElement tot_price;
	
	@FindBy(css="div.order-subtotal-container > div:nth-child(2) > div:nth-child(2)")
	WebElement shipping;
	
	@FindBy(xpath="//div[@class='order-subtotal-container']/div[3]/div[2]")
	WebElement TotalPrice;
	
	public void click_acceptcookies() {
		waitForFindElementPresent(acceptcookies);
		acceptcookies.click();
	}
	
	public void hover_Clearance() {
		action = new Actions(driver);
		action.moveToElement(Clearance).perform();
	}
	
	public void click_tops() {
		waitForFindElementPresent(tops);
		tops.click();
	}
	
	public Map<Integer, Double> get_last_chance_all_price() {
	    Map<Integer, Double> priceTextMap = new HashMap<>();
	    Iterator<WebElement> items = last_chance_all_price.iterator();
	    int index = 1; 
	    
	    while (items.hasNext()) {
	        WebElement item = items.next();
	        double price = Double.parseDouble(getText(item).replace("$", ""));
	        priceTextMap.put(index, price);
	        index++;
	    }

	    return priceTextMap;
	}
	

	public Map.Entry<Integer, Double> sort_last_chance_all_price(Map<Integer, Double> values) {
	    List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(values.entrySet());
	    int min_index = -1; 
	    Double min_price = null; 

	    for (Map.Entry<Integer, Double> entry : entryList) {
	        if (min_price == null || entry.getValue() < min_price) {
	            min_price = entry.getValue();
	            min_index = entry.getKey();
	        }
	    }

	    System.out.println(min_index + " " + min_price);
	    return new AbstractMap.SimpleEntry<>(min_index, min_price);
	}

	
	
	public void hover_lowest_item(int index) {
		action = new Actions(driver);
//		String item = "(//div[@class='_wrapper_1c1emu']//div[@class='product-sale-price '])["+index+"]";
		String item = "(//div[@id='ember60']//div[@class='tile-media'])["+index+"]";
		WebElement lowest_item = driver.findElement(By.xpath(item));
		action.moveToElement(lowest_item).perform();	
	}
	
	
	public void click_quick_shop(int index) throws InterruptedException  {
		String locator = "(//a[text()='Quick Shop'])["+index+"]";
		Thread.sleep(3000);
		driver.findElement(By.xpath(locator)).click();
	}
	
	public String validate_price() {
		return getText(sidebar_price).replace("$", "");
	}
	
	public void click_increase_button() {
		increase_button.click();
	}
	
	public void check_quantity(int number) throws InterruptedException {
		String quantityy = getText(quantity);
		int quant = Integer.parseInt(quantityy);
//		System.out.println(quant);
		while(quant<number) {
			click_increase_button();
			Thread.sleep(2000);
			quant++;
		}
	}
	
	public void click_AddTobag() {
		AddToBag.click();
	}
	
//	int counter = 0;
	
	
	public void click_first_available_size() throws InterruptedException {
		available.click();
		
		
//	    Iterator<WebElement> item = All_size.iterator();
//	    
//	    while (All_size.size()>counter) {
//	        counter++;
//	        Thread.sleep(2000);
//		    System.out.println("Iteration ");
//		    try {
//		        String locator="(//a[@role='menuitem'])["+counter+"]//small";
//		        WebElement element = driver.findElement(By.xpath(locator));
//		        System.out.println("Out of Stock " + element.getText());
//	        } catch (NoSuchElementException e) {	
//	        	Thread.sleep(2000);
//	            WebElement element2 = driver.findElement(By.xpath("(//ul[@class='dropdown-menu']/li/a)["+counter+"]"));
//	        	System.out.println("In Stock " +element2.getText());
//	            break;
//	        }
//	        
//	    }
	}
	
	public void click_ViewBag() {
		waitForFindElementPresent(ViewBag);
		ViewBag.click();
	}
	
	public double get_total_price() {
		String tot = tot_price.getText().replace("$", "");
		double tot2 = Double.parseDouble(tot);
		return tot2;
		
	}
	
	public double get_shipping() {
		String shipp = shipping.getText().replace("$","");
		double shipp2 = Double.parseDouble(shipp);
		return shipp2;
	}
	
	public double get_TotalPrice() {
		String shipp = TotalPrice.getText().replace("$","");
		double shipp2 = Double.parseDouble(shipp);
		return shipp2;
	}

}
