package com.ncs.advancedselenium.NetAporterWebsite;



import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import com.advancedselenium.net_a_porter_website.pageobject.*;
import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;


public class NetAPorterHomePageTest extends BaseClass{
	
	NetAPorterHomePage nhp;
	NetAPorterAccountPage nap;
	
//  @Test
//  public void f() {
//	  System.out.println("First Test case executed");
//  }
  
  	@Test
  	public void choosing_language_japanese() throws InterruptedException {
  		nhp=new NetAPorterHomePage(driver);
  		nhp.click_on_language_change_dropdown();
  		nhp.click_on_language_change_dropdown_on_changing_language();
  		String currentUrl=nhp.getUrlOfCurrentPage();
  		assertTrue(currentUrl.contains("zh-in"),"The language does not changes to japanese!!");
  		
		nhp.click_on_language_change_dropdown();
		nhp.click_on_language_change_dropdown_on_changing_language();
		String currUrl=nhp.getUrlOfCurrentPage();
		assertTrue(currUrl.contains("en-in"),"The language does not changes to English!!");

	  
  }
  	
  		
  		@Test
  		public void clicking_on_account_tab() throws InterruptedException {
  			nhp=new NetAPorterHomePage(driver);
  			nhp.click_on_account_tab();
  			String account_tab_heading=nhp.get_account_page_heading();
  			assertEquals(account_tab_heading,"Sign in","The heading is not matching!!");
  			
  			//Creating object for registration page
  			nap=new NetAPorterAccountPage(driver);
  			nap=nhp.click_on_create_account_btn();  			 			
  			assertEquals(nap.get_register_page_heading(),"Register","The user is not at register page!");
  			
  			
  	        
  	}
}
