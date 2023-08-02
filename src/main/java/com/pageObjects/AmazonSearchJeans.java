package com.pageObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class AmazonSearchJeans extends BasePage{

	public AmazonSearchJeans(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@id='reviewsRefinements']//a[@class='a-link-normal s-navigation-item'])[1]")
	WebElement rating4;
	
	@FindBy(xpath = "//div[@class='a-row a-size-small']/span[2]/a/span")
	List<WebElement> ratingsCount;
	
	@FindBy(xpath = "(//a[@id=\"acrCustomerReviewLink\"])[1]")
	WebElement rating_link;
	
	public void click_rating4() {
		rating4.click();
	}

	int counter = 0;
	
	public int getRatingsCount() {
		ArrayList<String> text = fetch_all_text(ratingsCount);
		Iterator<String> items = text.iterator();
		while(items.hasNext()) {
			counter++;
			String item = items.next();
			if(item.length()>3) {
				String item_new = item.replace(",", "");
				System.out.println(item_new);
				int item_conv = Integer.parseInt(item_new);
				if(item_conv>1500) {
					System.out.println(item_conv);
					return counter;
				}
			}
		}
		System.out.println("There's no review with count greater than 1500");
		return -1;
	}

	public void click_maxRating_item(int indexCondRating) {
		driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])["+indexCondRating+"]")).click();
	}
	
	public void click_ratingLink() {
		waitForFindElementPresent(rating_link);
		rating_link.click();
	}

	public void handleWindow() {
		String originalWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
	}
}
