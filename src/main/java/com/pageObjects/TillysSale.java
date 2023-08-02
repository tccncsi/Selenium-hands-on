package com.pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class TillysSale extends BasePage{

	public TillysSale(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='category-chunk pb-2'])[1]//span[@class='font-weight-normal']")
	List<WebElement> discount_mens;

	public int get_max_discount_mens() {
		ArrayList<String> discounts = fetch_all_text(discount_mens);
		System.out.println(Collections.max(discounts));
		int index= discounts.indexOf(Collections.max(discounts));
		return index+1;
	}

	public void hovers_img(int index) {
		String locator = "((//div[@class='category-chunk pb-2'])[1]//img[@class='product-tile-image tile-image'])["+index+"]";
		action = new Actions(driver);
		WebElement element_img = driver.findElement(By.xpath(locator));
//		executor.executeScript("window.scrollBy(250)", "");
		action.moveToElement(element_img).perform();
	}
}
