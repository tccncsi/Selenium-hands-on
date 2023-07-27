package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import com.base.BasePage;

public class HMSportPage extends BasePage {

	public HMSportPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "form > fieldset.dropdown-container.dropdown-sortby > button")
	WebElement SortByDropdown;

	@FindBy(xpath = "//*[@id='dropdown-sort-bestmatch']")
	WebElement RecommendedOption;

	@FindBy(css = "#dropdown-sort > ul > li:nth-child(1) > label")
	WebElement Recommended;

	@FindBy(xpath = "//*[@id='dropdown-sort-lowestprice']")
	WebElement LowestPriceOption;

	@FindBy(css = "ul.products-listing.small li.product-item span.price.regular")
	List<WebElement> PricesList;

	@FindBy(css = "div.image-container > a")
	List<WebElement> anchorElements;
	
	@FindBy(xpath="//ul[@class='products-listing large']/li/article/div/a")
	List<WebElement> LargeElements;

	@FindBy(css = "div.load-more-products > button")
	WebElement LoadMoreButton;

	@FindBy(css = "div.load-more-products > h2")
	WebElement TotalProductsCount;
	
	@FindBy(css="form > fieldset.filter-toggleiteminrow.js-filter-toggleiteminrow > ul > li:nth-child(1)")
	WebElement ImageLargeSize;
	

	// Method to select Sort By Dropdown
	public void clickOnSortBy() {
		executor.executeScript("arguments[0].scrollIntoView(true);", SortByDropdown);
		SortByDropdown.click();
	}

	// Method to check <Recommended> option is selected
	public boolean checkRecommendedSelected() {
		return RecommendedOption.isSelected();
	}

	//Method to set image size large
	public void setImageSizeLarge() {
		executor.executeScript("arguments[0].scrollIntoView(true);", ImageLargeSize);
		ImageLargeSize.click();
	}
	
	// Method to select Lowest Price option from dropdown
	public void selectLowestPriceOption() {
		clickOnSortBy();
		LowestPriceOption.click();
	}

	// Method to select Recommended Option
	public void selectRecommendedOption() {
		Recommended.click();
	}

	//Method to get currect product shown count
	public String currentProductShown() {
		return TotalProductsCount.getAttribute("data-items-shown");
	}
	
	//Method to get actual product available count
	public String totalDataShown() {
		return TotalProductsCount.getAttribute("data-total");
	}

	public int getTotalProductsCount() {
		return anchorElements.size();
	}

	// Method to click on the Load More Products button repeatedly until all products shown
	public void clickOnLoadMoreProductsButtonUntilAllShown() throws InterruptedException {
	    int itemsShown;
	    int totalItems;
	    do {
	        itemsShown = Integer.parseInt(currentProductShown());
	        totalItems = Integer.parseInt(totalDataShown());
	        System.out.println("Items Shown: " + itemsShown + " || Total Items: " + totalItems);

	        if (itemsShown < totalItems) {
	        	Thread.sleep(2000);
	            executor.executeScript("arguments[0].click();", LoadMoreButton);
	        }

	    } while (itemsShown < totalItems);
	    System.out.println("All products are now shown.");
	}


	//Method to store href into list of string
	public List<String> getProductHrefLinks() {
		List<String> productHrefList = new ArrayList<>();
		List<WebElement> products = anchorElements;

		for (WebElement product : products) {
			productHrefList.add(product.getAttribute("href"));
		}

		System.out.println("Total Number of links stored : " + productHrefList.size());
		return productHrefList;
	}

}
