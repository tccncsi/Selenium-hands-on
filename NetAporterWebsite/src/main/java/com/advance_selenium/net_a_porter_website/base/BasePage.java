package com.advance_selenium.net_a_porter_website.base;

import java.util.concurrent.TimeUnit;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// flag for step count in defect
		static String issueDescription;
		public static int flag=0;
		
		/* flag to count the number of defects in current build */
		public static int defectCount=0;

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
		} catch (Exception e) {
			System.out.println("Some exception occured while creating element:- " + locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public String getText(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public String getText(WebElement element) {
		return element.getText();
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some exception occured while waiting for element:- " + locator.toString());
			e.printStackTrace();
		}
		
	}

	@Override
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@Override
	public void waitForFindElementPresent(WebElement locator) {
		try {
			explicitWait.until(ExpectedConditions.visibilityOf(locator));
		} catch (Exception e) {
			System.out.println("Some exception occured while waiting for element:- " + locator.toString());
			e.printStackTrace();
		}
		
	}

	@Override
	public void waitForFindElementClickable(WebElement locator) {
		try {
			explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("Some exception occured while waiting for element:- " + locator.toString());
			e.printStackTrace();
		}
		
	}

	@Override
	public String findText(WebElement locator) {
		return locator.getText();
	}

	@Override
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}
		return flag;
	}
	
	
	public static String getFailedStep(String issueDescriptionNew) throws IOException
	{
	    String temp ="";
		String arr[]= issueDescriptionNew.split(Integer.toString(flag));

					for(String a : arr)
					{
						
						if(a.contains("is failed"))
						{
							
							if(a.contains(")"))
							{
								temp = a.replace(")","");
								//System.out.println(temp);
							}
							else if(a.contains("."))
							{
								temp = a.replace(".","");
								//System.out.println(temp);
							}
							else
							{
								temp = issueDescriptionNew;
							}
						}
						
					}
		
		flag=0;
		return temp;
	}

	
	

}
