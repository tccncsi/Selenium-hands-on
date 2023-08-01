package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advancedselenium.net_a_porter_website.pageobject.FreePeopleHomePage;

public class Assessment31JulyFreePeopleTest extends BaseClass{
	
	FreePeopleHomePage fphp;
//  @Test
//  public void hitting_url() {
//	  System.out.println("Dummy test for Free people website !!");
//  }
  
  @Test
  public void validating_links_of_different_section() throws InterruptedException {
	  
	  Thread.sleep(10000);
	  
	  fphp=new FreePeopleHomePage(driver);
	  assertTrue(fphp.jeans_tab_displayed(),"Jeans tab is not visible");
	  fphp.hovering_over_jeans_tab();
	  fphp.validating_all_links_under_jeans_section();
	  
  }
}
