package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.JiraCreateIssue;
import com.advancedselenium.net_a_porter_website.pageobject.MissGuidedHomePage;

public class Assessment31JulyMissGuidedTest extends BaseClass{
	
	MissGuidedHomePage mghp;
	@JiraCreateIssue(isCreateIssue = true)
	@Test
  public void links_test() throws InterruptedException {
		driver.get("https://www.missguided.co.uk/");
	  
	  System.out.println("Dummy test for miss guided website");
	  mghp=new MissGuidedHomePage(driver);
	  mghp.handleCookiePopup();
	  mghp.clicking_on_clothing_tab();
	  assertTrue(mghp.max_discount_displayed(),"Max Discount option is not displayed !");
	  mghp.selecting_from_sort_options();
	  
	  assertTrue(mghp.add_to_cart_btn_displayed(),"Add to cart btn is not displayed !");
	  mghp.clicking_on_add_to_cart_btn();
	  
	  assertTrue(mghp.selecting_size_displayed(),"Select size is not displayed !");
	  mghp.selecting_suitable_size();
	  
	  mghp.clicking_on_add_to_bag();	  
	  assertTrue(mghp.validating_cart(),"Total price is not correct.");
	  
	  
	  
  }
}
