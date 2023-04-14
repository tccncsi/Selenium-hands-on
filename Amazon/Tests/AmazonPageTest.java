package com.AMS.Login;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.AmazonBabyPage;
import com.pageObjects.AmazonPage;
import com.pageObjects.AmazonAddProductPage;
import com.utilities.JiraCreateIssue;

public class AmazonPageTest extends BaseClass{

	AmazonPage amazonpage;
	AmazonBabyPage amazonbabypage;
	AmazonAddProductPage amazonaddproductpage;
	
	/* Prerequisites
	 * 1 - Update test case sheet with test steps 
	 * 2 - Update Jira flag in jira config 
	 * 3 - Update generic utility flag in config 
	 * 4 - Update Jira env in both jira config and generic config 
	 * 4 - @Jira annotation should be set true accordingly 
	 * 5 - Update flag character under each test method
	 */
	
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 1, enabled = true)
	public void loginToAmazon() throws InterruptedException, IOException 
	{
		amazonpage = new AmazonPage(driver);
		amazonpage.reachSignInPage();
		amazonpage.enterUsername();
		amazonpage.enterPassword();
		amazonpage.signIn();

	}
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(priority = 2, enabled = true)
	public void searchProductOnAmazon() throws InterruptedException, IOException
	{
		
		amazonbabypage = new AmazonBabyPage(driver);
		amazonbabypage.login();
		amazonbabypage.NavigateToProduct();
		amazonbabypage.EnterProductOnSearchBar();
		amazonbabypage.hitEnter();
		
	}
	

	
}
