package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import com.base.BasePage;

public class FrankieShopPage extends BasePage {

	public FrankieShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	Actions actions = new Actions(driver);

	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement acceptCookies;

	@FindBy(css = "li:nth-child(1) > mega-menu-panels:nth-child(1) > button")
	WebElement shopMenu;

	@FindBy(xpath = "//*[text()='Men']")
	WebElement menCategory;

	@FindBy(xpath = "//a[@class='hd-Panel_Link fz-18_120' and @href='/collections/mens-new-arrivals']")
	WebElement newIn;

	@FindBy(xpath = "//h1[@class='sec-HeaderText_Title']")
	WebElement categoryPageTitle;

	@FindBy(css = ".boost-pfs-filter-tree-desktop-button > button:nth-child(1)")
	WebElement filterOption;

	@FindBy(xpath = "//*[@id='shopify-section-collection-template-boost-pfs-filter']/div[1]/div[1]/ul/li")
	List<WebElement> productList;

	@FindBy(xpath = "//button[@class='boost-pfs-filter-load-more-button']")
	WebElement loadMoreButton;

	@FindBy(css = ".boost-pfs-filter-load-more")
	WebElement loadMoreDiv;

	@FindBy(css = "#boost-pfs-filter-tree-pf-opt-size > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > button")
	WebElement sizeSelect;

	@FindBy(xpath = "//button[@class='boost-pfs-filter-close-button']")
	WebElement closeButton;

	
	@FindBy(css=".clc-Toolbar_FilterControlClear")
	WebElement clearFilter;
	
	/*-------------------------Methods------------------------------*/

	
	//Method to accept cookies
	public void accpetCookies() {
		implicitWait();
		acceptCookies.click();
	}

	//Method to hover on shop menu
	public void hoverOnShopMenu() {
		actions.moveToElement(shopMenu).perform();
	}

	//Method to select Men category (second level)
	public void clickOnMenCategory() {
		menCategory.click();
	}

	//Method to select New In option from Men Category
	public void clickOnNewIn() {
		newIn.click();
	}

	//Method to get heading of selected catgory page
	public String getCategoryPageTitle() {
		return categoryPageTitle.getText();
	}

	//Method to click on Filter option
	public void clickOnFilter() {
		filterOption.click();
	}

	//Method to get value of selected filter from available filter options (XXL)
	public String getFilterValue() {
		return sizeSelect.getText();
	}

	//Method to store and return all available prouducts displayed on page
	public List<String> getProductList() {

		// int counter=1;
		List<String> availableProductList = new ArrayList<>();

		for (WebElement product : productList) {
			String productName = product.findElement(By.cssSelector(".clc-List_Item .prd-Card_Body .prd-Card_Title"))
					.getText();
			availableProductList.add(productName);
			// System.out.println(counter+" = "+productName);
			// counter+=1;
		}
		return availableProductList;
	}

	//Method to store and return array of available product sizes for each product
	public List<List<String>> getProductSizes() {
		List<List<String>> availableProductSizes = new ArrayList<>();
		for (WebElement productSizeShown : productList) {
			List<WebElement> productSizeList = productSizeShown
					.findElements(By.cssSelector(".clc-List_Item .prd-Card_OptionList .prd-Card_Option"));
			List<String> sizesForCurrentProduct = new ArrayList<>();

			for (WebElement productSizeElement : productSizeList) {
				String inSize = productSizeElement.getText();
				sizesForCurrentProduct.add(inSize);
			}
			availableProductSizes.add(sizesForCurrentProduct);
		}
		System.out.println("Printing List of stored sizes: " + availableProductSizes);
		return availableProductSizes;
	}

	// Method to check if the products displayed are contains selected filter size
	public boolean checkForFilterResult(List<List<String>> availableProductSizes, String filterValue) {
		for (List<String> sizesForCurrentProduct : availableProductSizes) {
			if (!sizesForCurrentProduct.contains(filterValue)) {
				return false;
			}
		}
		return true;
	}

	//Method to get status of Load More Button whethere it is displayed or not
	public String getLoadMoreDivStatus() {
		String attribute = loadMoreDiv.getAttribute("style");
		int colonIndex = attribute.indexOf(':');
		if (colonIndex != -1) {
			// Extract the part after the colon and remove whitespaces
			String status = attribute.substring(colonIndex + 1).trim();
			System.out.println("Load More Button Status: " + status);
			return status;
		}
		return null;
	}

	//Method to click on Load More button
	public void clickOnLoadMore() throws InterruptedException {
		// executor.executeScript("arguments[0].scrollIntoView(true);", loadMoreButton);
		while (!"none;".equals(getLoadMoreDivStatus())) {
			executor.executeScript("arguments[0].click();", loadMoreButton);
			Thread.sleep(5000);
		}
		System.out.println("All products are now shown.");
	}

	//Method to select size (XXL) from filter options
	public void selectSize() {
		sizeSelect.click();
	}

	//Method to click on close button of filter options
	public void clickSizeCloseButton() {
		closeButton.click();
	}
	
	//Method to click on clear filter option
	public void clearFilter() {
		clearFilter.click();
	}

}
