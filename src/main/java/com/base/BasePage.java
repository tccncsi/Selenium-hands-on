package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends Page {

	

	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e) {
			System.out.println("Some exception occured while creating element:- " +locator.toString());
			e.printStackTrace();
		}
		return element;
		
	}
	
	


	@Override
	public String getText(By locator) {
		
		return getElement(locator).getText();
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
			catch(Exception e) {
				System.out.println("Some exception occured while waiting for element:- " +locator.toString());
				e.printStackTrace();
			}	
		
	}

	@Override
	public void waitForFindElementPresent(WebElement locator) {
		try {
			wait.until(ExpectedConditions.visibilityOf(locator));
			}
			catch(Exception e) {
				System.out.println("Some exception occured while waiting for element:- " +locator.toString());
				e.printStackTrace();
			}	
		
	}
	
	
	@Override
	public String findText(WebElement locator) {
		
		return locator.getText();
	}

	@Override
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	

}
