package com.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class youngandreckHP extends BasePage{
	
	public youngandreckHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//li[@class='main-menu'])[6]")
	WebElement nav_mens;
	
	@FindBy(xpath="(//div[@class='dropdown_column__menu'])[12]//li/a")
	List<WebElement> mens_top;

	@FindBy(css = "footer.footer > div > div:nth-child(3) > div > div > ul > li > p > a")
	List<WebElement> support_links;
	
	public void mouseOver_nav_mens() {
		action = new Actions(driver);
		action.moveToElement(nav_mens).perform();
	}
	
	public double check_links_mentop() throws IOException {
		return validateLinks(mens_top);
	}
	
	public double check_links_footer() throws IOException {
		return validateLinks(support_links);
	}
	
	public void check_ratio(double pass_ratio) {
		if(pass_ratio!=1) {
			Assert.assertTrue(false);
		}
	}
	
	
	
	
}
