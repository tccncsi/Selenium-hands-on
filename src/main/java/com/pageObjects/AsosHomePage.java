package com.pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class AsosHomePage extends BasePage{

	public AsosHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	Actions actions = new Actions(driver);
	
	@FindBy(xpath="//*[@id='men-floor']")
	WebElement menOption;
	
	@FindBy(xpath="(//span[text()='Accessories'])[3]")
	WebElement accessoriesOption;
	
	@FindBy(css="#\\30 502a9b2-d1e8-4b34-9741-1141607c715e .M8Zxf1o .GL2wQf0 .ZAntzlZ a")
	List<WebElement> accessoriesLinks;
	
	@FindBy(css=".x1ETIN7 a")
	List<WebElement> footerLinks;
	
	/*------------------Methods-----------------------*/
	
	//Method to click on Men option
	public void clickOnMenOption() {
		menOption.click();
	}
	
	//Method to hover on accessories option
	public void hoverAccessoriesOption() {
		actions.moveToElement(accessoriesOption).perform();
	}
	
    //Returns the list of href attributes of all anchor tags found in <Accessories> Section
    public List<String> getAccessoriesAnchorTagsHrefs() {
        return accessoriesLinks.stream().map(element -> element.getAttribute("href")).collect(Collectors.toList());
    }
    
    //Returns the list of href attributes of all anchor tags found in <Footer> Section
    public List<String> getFooterAnchorTagsHrefs() {
        return footerLinks.stream().map(element -> element.getAttribute("href")).collect(Collectors.toList());
    }
    
    //Method to check whether links in accessories are not null
    public void verifyAccessoriesLinks() {    	
    	List<String> links=getAccessoriesAnchorTagsHrefs();
    	
    	System.out.println("------------Checking Accessories Links--------------------");
    	
        for (String link : links) {
        	System.out.println(link);
        	Assert.assertTrue(link != null,"Link is null");
        }
		// verifyHrefLinks(getAccessoriesAnchorTagsHrefs());
    }
    
    //Method to check whether links in footer are not null
    public void verifyFooterLinks() {    	
    	List<String> Footerlinks=getFooterAnchorTagsHrefs();
    	
    	System.out.println("------------Checking Footer Links--------------------");
    	
        for (String link : Footerlinks) {
        	System.out.println(link);
        	Assert.assertTrue(link != null,"Link is null");
        }
		//verifyHrefLinks(getFooterAnchorTagsHrefs());
    }
}
