package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utilities.XLUtils;

public class AmazonHP extends BasePage{

	public AmazonHP(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div#nav-xshop > a:nth-child(5)")
	WebElement nav_TodayDeal;
	
	@FindBy(css = "input#twotabsearchtextbox")
	WebElement nav_Search;
	
	@FindBy(css = "input#nav-search-submit-button")
	WebElement searchButton;
	
	public void click_nav_TodayDeal() {
		nav_TodayDeal.click();
	}

	public void searchJeans() {
		String xlfile = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\TestData.xlsx";
		String xlsheet = "Assessment";
		String keyword = XLUtils.getCellData(xlfile, xlsheet, 0, 1);
		nav_Search.sendKeys(keyword);	
	}
	
	public void click_searchButton() {
		searchButton.click();
	}
	
	
}
