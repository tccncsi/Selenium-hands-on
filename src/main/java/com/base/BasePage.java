package com.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pageObjects.AmazonPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
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
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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

	
	  public static String checkIssueDescription(String testCaseName) throws IOException 
	  {
			String testCase = null;
			String issueDes = "";
			testCase = XLUtils.FetchExcelTestCaseData(testCaseName);
			
			String[] testCaseDetails = null;
			if (testCase != null)
				testCaseDetails = testCase.split("\n\n");

			if (testCaseDetails != null && testCaseDetails.length > 0) {
				/* Test case details from excel sheet */
				
				  String teststepcolumn = testCaseDetails[2].toString();
				  if(flag==0)
				  {
					  issueDes = testCaseDetails[3].toString();
					  issueDes = issueDes + " ";
				  }
				  else
				  {
					  String[] testSteps = null;
					  testSteps = teststepcolumn.split("\n");
					  //testSteps = teststepcolumn.split("\\."); 
					  if(testSteps !=null && testSteps.length > 0) 
					  { 
						  System.out.println("------***********------");
						      
						   for(int i=0;i<flag;i++) 
						  {
					        
					         issueDescription = testSteps[i].toString();
					         
					         if(flag>0)
					         {
					        	 issueDes = issueDes + issueDescription + " ";
					        	 if(i!=flag-1)
					        	 {
					        		 issueDes = issueDes + "\n";
						        	 	 
					        	 }
					        	 //System.out.println(issueDes);
					         }
					        
					      } 
				  }
				  
				    
				  }

			}
			issueDes = issueDes + "is failed";
			
			return issueDes;	

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
