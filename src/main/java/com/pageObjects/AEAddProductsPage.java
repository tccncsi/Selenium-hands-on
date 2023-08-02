package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class AEAddProductsPage extends BasePage {

	public AEAddProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	Actions actions = new Actions(driver);

	@FindBy(css = "#top-navigation > div > div > div:nth-child(8) > a")
	WebElement ClearanceMenu;

	@FindBy(css = "div:nth-child(8) > div > div > div:nth-child(2) > div > a:nth-child(1)")
	WebElement TopOption;

	@FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
	WebElement AcceptCookie;

	@FindBy(css = "button.qa-btn-cancel")
	WebElement closeButton;

	@FindBy(xpath = "//div[contains(@class, 'product-tile qa-product-tile __eadf2 _item_1c1emu')]")
	List<WebElement> LastChanceProducts;

	@FindBy(css = "div.qa-product-prices:nth-child(1) > div:nth-child(1)")
	WebElement QuickShopProductPrice;

	@FindBy(xpath = "//span[@class='dropdown-text']")
	WebElement SizeDropdownButton;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/li")
	List<WebElement> SizeDropdownList;

	@FindBy(xpath = "//button[@class='qty-inc-btn  _qty-inc-btn_gjd6pr']")
	WebElement IncreaseQuantity;

	@FindBy(css = "button.btn-primary:nth-child(1)")
	WebElement AddToBagButton;

	@FindBy(css = ".qa-btn-view-bag")
	WebElement ViewBagButton;

	@FindBy(css = ".qa-animated-list")
	WebElement AddedBagProduct;

	@FindBy(css = "._sale-price_6tsvav")
	WebElement productPriceInCart;

	@FindBy(css = ".order-subtotal-merchandise-value")
	WebElement productPriceInOrderSection;

	@FindBy(css = ".order-subtotal-shipping-value")
	WebElement ShippingPriceInOrderSection;

	@FindBy(css = ".order-subtotal-total-value")
	WebElement SubTotalValue;

	// Method to accept cookies
	public void acceptCookie() {
		waitForFindElementClickable(AcceptCookie);
		AcceptCookie.click();
	}

	// Method to hover on Clearance Menu
	public void hoverOverClearanceMenu() {
		actions.moveToElement(ClearanceMenu).perform();
	}

	// Method to select Top option from the list
	public void selectOnTopOption() {
		TopOption.click();
	}

	// Method to click on the product tile with the lowest price
	public void clickOnProductWithLowestPrice() throws InterruptedException {
		int indexOfLowestPriceProduct = getProductWithLowestPrice();
		WebElement LowestPriceProduct = LastChanceProducts.get(indexOfLowestPriceProduct);

		System.out.println("Lowest Product Name:"
				+ LowestPriceProduct.findElement(By.cssSelector(".tile-details .product-name")).getText());
		System.out.println("Product Id:" + LowestPriceProduct.getAttribute("data-product-id"));

		executor.executeScript("arguments[0].scrollIntoView(true);", LowestPriceProduct);
		actions.moveToElement(LowestPriceProduct).perform();

		WebElement QuickShopButton = LowestPriceProduct.findElement(By.cssSelector(".product-tile .clickable"));
		QuickShopButton.click();
		Thread.sleep(2000);
	}

	// Method to find out the product with lowest price from list of webElements
	private int getProductWithLowestPrice() throws InterruptedException {
		int count = 1;
		Thread.sleep(5000);
		WebElement minPriceProduct = null;
		float minPrice = Float.MAX_VALUE;
		for (WebElement products : LastChanceProducts) {

			System.out.println("Size of Last Chance Products:" + LastChanceProducts.size());
			System.out.println(
					count + "=" + products.findElement(By.cssSelector(".tile-details .product-name")).getText());
			float price = Float.parseFloat(
					products.findElement(By.cssSelector(".tile-details .product-sale-price")).getText().substring(1));
			System.out.println("Price of the product: " + price);

			if (price < minPrice) {
				minPrice = price;
				minPriceProduct = products;
				System.out.println(
						"Index of stored lowest price element = " + LastChanceProducts.indexOf(minPriceProduct));
			}
			count += 1;
		}
		return LastChanceProducts.indexOf(minPriceProduct);
	}

	// Method to compare price before and after clicking on Quick Shop
	public void VerifyProductPrices() throws InterruptedException {
		executor.executeScript("arguments[0].scrollIntoView(true);", QuickShopProductPrice);
		int indexOfLowestPriceProduct = getProductWithLowestPrice();
		WebElement LowestPriceProduct = LastChanceProducts.get(indexOfLowestPriceProduct);

		float actualPrice = Float.parseFloat(LowestPriceProduct
				.findElement(By.cssSelector(".tile-details .product-sale-price")).getText().substring(1));
		float priceInQuickShop = Float.parseFloat(QuickShopProductPrice.getText().substring(1));
		System.out.println("Actual Price: " + actualPrice + " Quick Shop Price:" + priceInQuickShop);

		assertEquals(actualPrice, priceInQuickShop);
	}

	// Method to select available product size
	public void getAvailableProuductSize() {
		executor.executeScript("arguments[0].scrollIntoView(true);", SizeDropdownButton);
		SizeDropdownButton.click();

		List<WebElement> availableProductSizes = new ArrayList<>();
		int sizeCounter = 1;
		int ListSize = 0;

		System.out.println("-------------Inside Method of Printing all available product sizes--------------------");
		for (WebElement productSize : SizeDropdownList) {
			if (!productSize.getText().contains("Out of Stock")) {
				System.out.println(sizeCounter + " = " + productSize.getText());
				availableProductSizes.add(productSize);
				sizeCounter += 1;
			}
		}

		ListSize = availableProductSizes.size();
		if (ListSize > 0) {
			Random random = new Random();
			int randomIndex = random.nextInt(ListSize);
			WebElement randomProductSize = availableProductSizes.get(randomIndex);
			executor.executeScript("arguments[0].scrollIntoView(true);", randomProductSize);
			randomProductSize.click();
		}

	}

	//Method to increase Product Quantity by one
	public void IncreaseProductQuantity() {
		IncreaseQuantity.click();
	}

	//Method to click on Add to Bag Button
	public void clickOnAddToBagButton() {
		AddToBagButton.click();
	}

	//Method to click on View Bag Button
	public void clickOnViewBagButton() {
		implicitWait();
		ViewBagButton.click();
	}

	//Method to verify bag details details such as prices and sub-totals
	public void verifyBagProductDetails() {
		executor.executeScript("arguments[0].scrollIntoView(true);", AddedBagProduct);

		Float CartProductPrice = Float.parseFloat(productPriceInCart.getText().substring(1));

		Float InOrderProductPrice = Float.parseFloat(productPriceInOrderSection.getText().substring(1));

		Float ShippingPrice = Float.parseFloat(ShippingPriceInOrderSection.getText().substring(1));

		Float OrderSubTotal = Float.parseFloat(SubTotalValue.getText().substring(1));

		System.out.println("Cart Price: " + CartProductPrice);
		System.out.println("Order Price: " + InOrderProductPrice);
		System.out.println("Shipping Price: " + ShippingPrice);
		System.out.println("Sub Total Price: " + OrderSubTotal);

		assertEquals(CartProductPrice, InOrderProductPrice, "Product Prices are not same in cart and order section");

		assertEquals(InOrderProductPrice + ShippingPrice, OrderSubTotal,
				"Total value is not same after adding shipping charges");
	}

}
