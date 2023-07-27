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

	@FindBy(css = "ul.products-listing.small li.product-item a.item-link")
	List<WebElement> anchorElements;

	@FindBy(css = "div.load-more-products > button")
	WebElement LoadMoreButton;

	@FindBy(css = "div.load-more-products > h2")
	WebElement TotalProductsCount;
	

	// Method to select Sort By Dropdown
	public void clickOnSortBy() {
		executor.executeScript("arguments[0].scrollIntoView(true);", SortByDropdown);
		SortByDropdown.click();
	}

	// Method to check <Recommended> option is selected
	public boolean checkRecommendedSelected() {
		return RecommendedOption.isSelected();
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

	public String currentProductShown() {
		return TotalProductsCount.getAttribute("data-items-shown");
	}

	public String totalDataShown() {
		return TotalProductsCount.getAttribute("data-total");
	}

	public int getTotalProductsCount() {
		return anchorElements.size();
	}

	// Method to click on the Load More Products button repeatedly until all
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
//	            try {
//	                Thread.sleep(2000);
//	            } catch (InterruptedException e) {
//	                e.printStackTrace();
//	            }
	        }

	    } while (itemsShown < totalItems);

	    System.out.println("All products are now shown.");
	}


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
