package com.pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BasePage;
import com.utilities.ReadConfig;

public class AmazonAddProductPage extends BasePage
{

	public AmazonAddProductPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
    WebElement SignIn;
	
	@FindBy(xpath= "(//*[contains(text(),'Sign in')])[1]")
	WebElement SignInButton;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement SignInBtn;
	
	@FindBy(xpath = "//label[@for='ap_email']")
	WebElement emailHeader;
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement Babylink;
	
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement SearchBar;
	
	@FindBy(xpath = "(//span[contains(text(),'4.6 out of 5 stars')])[1]")
	WebElement rating;
	
	//@FindBy(xpath = "(//span[@class='rush-component']/a/div/img)[5]")
	//@FindBy(xpath = "(//img[@alt='Pampers Premium Care Pants, Large size baby Diapers, (L) 88 Count Softest ever Pampers Pants,'])[2]")
	@FindBy(xpath = "(//span[@class='rush-component']/a/div/img[@alt='Pampers Premium Care Pants, Large size baby Diapers, (L) 88 Count Softest ever Pampers Pants,'])")
	WebElement productLink;
	
	@FindBy(xpath = "//select[@name='quantity']")
	WebElement quantity;
	
	@FindBy(xpath = "//input[@title='Add to Shopping Cart']")
	WebElement addToCart;
	
	@FindBy(xpath = "//span[@id='submit.add-to-cart-announce']")
	WebElement addToCartText;
	
	@FindBy(xpath = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']/span")
	WebElement successMsg;
	
	@FindBy(xpath = "(//a[@target='_self']/img)[3]")
	WebElement productImg;
	
	@FindBy(xpath = "(//a[contains(text(),'Go to Cart')])[2]")
	WebElement gotoCart;
	
	@FindBy(xpath = "(//*[contains(text(),'Shopping Cart')])[2]")
	WebElement cartHeader;
	
	@FindBy(xpath = "(//span[contains(text(),'RESULTS')])[1]")
	WebElement resultHeader;
	
	public ReadConfig readconfig = new ReadConfig();
	Actions A;
	
	
	public void login() throws InterruptedException
	{
		waitForFindElementPresent(SignIn);
		A = new Actions(driver);
		A.moveToElement(SignIn).build().perform();
		Thread.sleep(2000);
		waitForFindElementPresent(SignInButton);
		SignInButton.click();
		
		waitForFindElementPresent(emailID);
		emailID.sendKeys(readconfig.getUsername());
		waitForFindElementPresent(continueBtn);
		continueBtn.click();
		waitForFindElementPresent(password);
		
		waitForFindElementPresent(password);
		password.sendKeys(readconfig.getPassword());
		
		waitForFindElementPresent(SignInBtn);
		SignInBtn.click();
		logger.info("Sign In completed");
	}
	
	
	public void navigateToProductPage()
	{
		
		Select s = new Select(Babylink);
		s.selectByVisibleText("Baby");
		waitForFindElementPresent(SearchBar);
		SearchBar.sendKeys(readconfig.getProduct());
		//precondition failed step
		//Assert.assertTrue(false);
		SearchBar.sendKeys(Keys.ENTER);
		Assert.assertEquals(resultHeader.getText(),"RESULTS");
		logger.info("Navigated to Baby Section");
	}
	
	public void selectProduct()
	{
		flag++;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", productLink);
		//Assert.assertEquals(productLink.getAttribute("alt"), "Pampers Premium Care Pants, Large size baby Diapers, (L) 88 Count Softest ever Pampers Pants,");
		Assert.assertEquals(productLink.getAttribute("alt"),readconfig.getProductText());
		
		productLink.click();
		logger.info("Product is selected");
	}
	
	public void addToCart() throws InterruptedException
	{
		flag++;
		
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();

		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);

		System.out.println(driver.switchTo().window(child_window).getTitle());

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", quantity);
		
		Select quant = new Select(quantity);
		System.out.println(readconfig.getQuantity());
		quant.selectByValue(readconfig.getQuantity());
		
		waitForFindElementPresent(addToCart);
		System.out.println(addToCartText.getText());
		Assert.assertEquals(addToCartText.getText(), "Add to Car");
		addToCart.click();
		}
		}
		logger.info("Product name is added to cart");
	}
	
	public void verifyProductAdded() throws IOException
	{
		flag++;	
		waitForFindElementPresent(successMsg);
		String actual = productImg.getAttribute("alt");
		//String expected = "Pampers Premium Care Pants, Large size baby Diapers, (L) 88 Count Softest ever Pampers Pants,";
		Assert.assertEquals(actual,readconfig.getProductText());
		logger.info("Added product is verified");
	}
	
	public void verifyShoppingCart() throws IOException, InterruptedException
	{
		flag++;		
		waitForFindElementPresent(gotoCart);
		Thread.sleep(3000);
		gotoCart.click();
		waitForFindElementPresent(cartHeader);
		Assert.assertEquals(cartHeader.getText(), "Shopping Cart");
		logger.info("Shopping cart is updated");
	}
}
