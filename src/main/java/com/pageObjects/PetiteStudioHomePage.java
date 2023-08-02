package com.pageObjects;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import org.openqa.selenium.interactions.Actions;


public class PetiteStudioHomePage extends BasePage{

	
	//---------------Shop All Tab--------------------
    @FindBy(xpath = "//*[text()='Shop All']")
    private WebElement shopAllLink;
    
	//---------------Shop All Links-------------------
	@FindBy(css = "ul.sub-nav-list li a")
    private List<WebElement> anchorTags;

	//---------------Help Section Links----------------
	@FindBy(css = "div.link-list.help-list ul li a")
	private List<WebElement> helpSectionLinks;
	

	
	public PetiteStudioHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	//Returns List of anchor tags present in <Shop All> section
    public List<WebElement> getAnchorTags() {
        return anchorTags;
    }
    
	//Returns List of anchor tags present in <Help> section
    public List<WebElement> getHelpSectionLinks() {
        return helpSectionLinks;
    }
    
    
    //Returns the list of href attributes of all anchor tags found in <Shop All> Section
    public List<String> getAllAnchorTagsHrefs() {
        return anchorTags.stream().map(element -> element.getAttribute("href")).collect(Collectors.toList());
    }
    
    //Returns the list of href attributes of all anchor tags found in <Help> Section
    public List<String> getAllHelpSectionLinksHrefs() {
        return helpSectionLinks.stream().map(element -> element.getAttribute("href")).collect(Collectors.toList());
    }
    
    //Hover Shop All
    public void hoverOverShopAllLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shopAllLink).perform();
    }
    
   
    // ---------------------------------------- Modified Code ------------------------------------------------
    public void verifyShopAllLinks() {
    	verifyHrefLinks(getAllAnchorTagsHrefs());
    }
   
    
    public void verifyHelpLinks() {
    	verifyHrefLinks(getAllHelpSectionLinksHrefs());
    }
    
    public void verifyHelpLinksResponseCode() {
    	verifyHrefResponseCode(getAllHelpSectionLinksHrefs(),404);
    }
}
