package com.testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.HomePageNavg;
import com.pageObjects.LoginPage;



public class SAM_PageTest extends BaseClass{
	

	

	@BeforeMethod
	public void login() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.Login(readconfig.getsysUsername(),readconfig.getsysPassword());
		
	}
	
	@Test(priority=1)
	public void verifyPwdRules() 
	{
	
		HomePageNavg hp= new HomePageNavg(driver);
		hp.clickLeftpannel();
		logger.info("Password Rule is clicked");		
		String title=hp.getLoginPageTitle();
		System.out.println("Page title is " +title);
		Assert.assertEquals(title, "SEAB iEXAMS2 - Password rules");
		String Error=hp.clearPwdLength();
		System.out.println("Error message is " +Error);	
		Assert.assertEquals(Error, "Number of characters is required");
		
		
	
	}


}
