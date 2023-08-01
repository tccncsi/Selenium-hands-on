package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advancedselenium.net_a_porter_website.pageobject.HMHomePage;
import com.advancedselenium.net_a_porter_website.pageobject.NetAPorterAccountPage;

public class HMHomePageTest extends BaseClass{
	//WebDriver driver;
	
	HMHomePage hmhp;
  @Test
  public void f() {
	  System.out.println("H and M dummy test");
	  
  }
  
  
  @Test
  public void men_section_test() throws InterruptedException {
	 
	  hmhp=new HMHomePage(driver);
	  hmhp.handlePopup();
	  hmhp.hovering_sports_tab();
	  hmhp.clicking_on_view_all_option();
	  String heading=hmhp.get_heading_at_men_page();
	  assertTrue(hmhp.heading_at_men_page(),"Heading on Men page is not displayed");
      assertEquals(heading,"VIEW ALL - WORKOUT CLOTHES FOR MEN","Correct heading is not displayed");
      hmhp.selecting_sorting_option();
      //hmhp.selecting_recomended_option();
      assertTrue(hmhp.is_recomended_selected(),"Recomended option not selected");
      hmhp.selecting_lowest_price_option();
      Thread.sleep(3000);
      hmhp.selecting_sorting_option();
      Thread.sleep(3000);
	 
  }
}
