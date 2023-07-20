package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class PetiteStudioHomePage extends BasePage{

	public PetiteStudioHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// ------------------Locators------------------------------------

	@FindBy(xpath = "//*[text()='Shop All']")
	WebElement ShopAllLink;
	
	
	//--------------------Shop All-Categories Locators------------------------
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[1]")
	WebElement NewArrivals;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[2]")
	WebElement BestSellers;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[3]")
	WebElement Dresses;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[4]")
	WebElement Tops;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[5]")
	WebElement Bottoms;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[6]")
	WebElement Knitwear;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[7]")
	WebElement Outerwear;
	
	@FindBy(xpath = "//ul[@class='sub-nav-list']/li[8]")
	WebElement FinalSale;
	
	
	//-------------------------Shop All-Collections Locators---------------------------------
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[1]")
	WebElement SummerCollection;
	
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[2]")
	WebElement Suggyl;
	
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[3]")
	WebElement SpringCollection;
	
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[4]")
	WebElement BuvetteCollection;
	
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[5]")
	WebElement BusinessCasual;
	
	@FindBy(xpath = "//div[@class='grid-t-2 grid-d-2'][2]//ul/li[6]")
	WebElement Accessories;
	
	@FindBy(css="div.grid-m-hide.grid-t-4.grid-d-5.collection-title > h1")
	WebElement PageHeading;
	
	
	
    public void hoverOverShopAllLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(ShopAllLink).build().perform();
    }
    
    public String getPageHeadingText() {
    	return PageHeading.getText();
    }
    
	//--------------------Shop All-Categories Methods------------------------
    public void clickOnNewArrivals() {
    	NewArrivals.click();
    }
    
    public void clickOnBestSellers() {
    	BestSellers.click();
    }
    
    public void clickOnDresses() {
    	Dresses.click();
    }
    
    public void clickOnTops() {
    	Tops.click();
    }
    
    public void clickOnBottoms() {
    	Bottoms.click();
    }
    
    public void clickOnKnitwear() {
    	Knitwear.click();
    }
    
    public void clickOnOuterwear() {
    	Outerwear.click();
    }
    
    public void clickOnFinalSale() {
    	FinalSale.click();
    }
    
	//--------------------Shop All-Collections Methods------------------------
    public void clickOnSummerCollection() {
    	SummerCollection.click();
    }
    
    public void clickOnSuggyl() {
    	Suggyl.click();
    }
     
    public void clickOnSpringCollection() {
    	SpringCollection.click();
    }
  
    public void clickOnBuvetteCollection() {
    	BuvetteCollection.click();
    }
    
    public void clickOnBusinessCasual() {
    	BusinessCasual.click();
    }
    
    public void clickOnAccessories() {
    	BusinessCasual.click();
    }
    
    
    
}
