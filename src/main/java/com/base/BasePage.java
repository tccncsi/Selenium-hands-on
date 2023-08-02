package com.base;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

//	flag for counting the total no of links present
	int TotalLink = 0;
	int PassLink = 0;
	int counter_links = 0;
	int pass_links = 0;

	
//	For iteraring through a list of webelements fetching href value and checking if it's a valid url or not 
	@Override
	public int validateLinks(List<WebElement> ele) throws IOException {
	    Iterator<WebElement> items = ele.iterator();
	    while (items.hasNext()) {
	        String url = items.next().getAttribute("href");
	        int[] result = verifyLinks(url); // Assuming verifyLinks returns an int array
	        int currentTotalLink = result[0]; // Get the values from the result array
	        int currentPassLink = result[1];
	        TotalLink += currentTotalLink; 
	        PassLink += currentPassLink;
	        System.out.println(url);
	    }
	    if (TotalLink == 0) {
	        return 0; 
	    } else {
	    	System.out.println("Total Pass ratio : "+PassLink/TotalLink);
	        return PassLink/TotalLink; 
	    }
	}

	
//	Checking the url is a good url and not a broken url, and checking if it is equal to responseCode expected
	public int[] verifyLinks(String url) throws IOException {
	    if (url.equals("#") || url.equals("")) {
	        counter_links++;
	        System.out.println("Failed: " + url);
	    } else {
	        URL fetch_url = new URL(url);
	        HttpURLConnection connection = (HttpURLConnection) fetch_url.openConnection();
	        connection.setRequestMethod("GET");
	        int responseCode = connection.getResponseCode();
	        if (responseCode > 400) {
	            counter_links++;
	            System.out.println("Failed: " + url);
	        } else {
	            counter_links++;
	            pass_links++;
	        }
	        connection.disconnect(); // Close the connection to release resources.
	    }
	    int[] values = new int[2];
	    values[0] = counter_links;
	    values[1] = pass_links;
	    return values;
	}

	
	
	
//	Fetches all href for WebElements and stores it in a array
	@Override
	public ArrayList<String> fetch_all_href(List<WebElement> element) {
//		System.out.println(element);
		ArrayList<String> all_url = new ArrayList<String>();
		Iterator<WebElement> items = element.iterator();

		while (items.hasNext()) {
		    String url1 = items.next().getAttribute("href");
		    all_url.add(url1);
		}

		System.out.println(all_url);
		System.out.println("Finish");
	    return all_url;
	}

	@Override
	public ArrayList<String> fetch_all_text(List<WebElement> element) {
		ArrayList<String> all_text = new ArrayList<String>();
		Iterator<WebElement> items = element.iterator();
		
		while(items.hasNext()) {
			String text = items.next().getText();
			all_text.add(text);
		}
		System.out.println(all_text);
		return all_text;
	}

	@Override
	public String convertDate(String date_con) {
		System.out.println("DAte Fetched : "+date_con);
		
		String[] dateTocon = date_con.split(" ");
		String temp = "";
		
		for(int i=1;i<=3;i++) {
			System.out.println(dateTocon[dateTocon.length-i]);
			
			String result = dateTocon[dateTocon.length-i]+" "+temp;
			temp = result;			
		}
		
		System.out.println("After substring "+temp);
		String[] newDate = temp.split(" ");
		
		System.out.println("Year : "+newDate[2]);
		System.out.println("Month : "+newDate[1]);
		System.out.println("Date : "+newDate[0]);
		
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		ArrayList<String> monthss = new ArrayList<>(Arrays.asList(months));
		int monthnumber = monthss.indexOf(newDate[1])+1;
		System.out.println(monthnumber);
		
		String monthFormat = String.format("%02d", monthnumber);
		System.out.println("month in format : "+monthFormat);
		System.out.println("Date :"+newDate[0]);
		
		int dateString = Integer.parseInt(newDate[0]);  
		
		String dateFormat = String.format("%02d", dateString);
		System.out.println(dateFormat);
		
		return monthFormat+"-"+dateFormat+"-"+newDate[2];		
		
	}
		

}









