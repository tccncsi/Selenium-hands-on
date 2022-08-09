package com.testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.HomePageNavg;
import com.pageObjects.LoginPage;



public class SAM_006_25_26 extends BaseClass{
	

	

	@BeforeMethod
	public void login() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login(readconfig.getsysUsername(),readconfig.getsysPassword());
		
	}
	
	@Test(priority=2)
	public void verifyPastRequests() 
	{
	
		HomePageNavg hp= new HomePageNavg(driver);
		hp.clickLeftpannel();
		logger.info("Password Rule is clicked");		
		String title=hp.getLoginPageTitle();
		System.out.println("Page title is " +title);		
		Assert.assertEquals(title, "SEAB iEXAMS2 - Password rules");
		hp.pastRequests();
	    hp.filterPastRequests();
	
	}


}
