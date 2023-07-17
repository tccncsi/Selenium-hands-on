package com.NCS.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public WebDriver driver;
	public JavascriptExecutor executor;
	public Logger logger;
	public Actions action;
	public WebDriverWait explicitWait;

	public Page(WebDriver driver) {
		this.driver = driver;
		this.explicitWait = new WebDriverWait(this.driver, 120);
		this.executor = (JavascriptExecutor) driver;
		this.action = new Actions(driver);
		this.logger = Logger.getLogger("iExam");
		PropertyConfigurator.configure("Log4j.properties");
	}

	// Abstract Methods for POM

	public abstract String getPageTitle();

	public abstract WebElement getElement(By locator);

	public abstract String getText(By locator);
	
	public abstract String getText(WebElement element);

	public abstract void waitForElementPresent(By locator);

	public abstract void implicitWait();

	// Abstract Methods for Page Factory

	public abstract void waitForFindElementPresent(WebElement locator);

	public abstract void waitForFindElementClickable(WebElement locator);

	public abstract String findText(WebElement locator);
	
	public abstract boolean isFileDownloaded(String downloadPath, String fileName);

}
