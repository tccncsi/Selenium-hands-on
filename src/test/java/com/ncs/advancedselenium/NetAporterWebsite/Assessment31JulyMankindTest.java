package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.JiraCreateIssue;
import com.advancedselenium.net_a_porter_website.pageobject.MankindHomePage;

public class Assessment31JulyMankindTest extends BaseClass{
	MankindHomePage mhp;
	
	@JiraCreateIssue(isCreateIssue = true)
  @Test
  public void checking_filter() throws InterruptedException {
		driver.get("https://www.mankind.co.uk/");
	  System.out.println("Dummy test for Mankind website !!");
	  mhp=new MankindHomePage(driver);
	  mhp.handleCookiePopup();
	  mhp.handleSignUpPopup();
	  
	  assertTrue(mhp.skin_tab_displayed(),"Skin tab is not displayed!");
	  mhp.hovering_over_skin_tab();
	  mhp.click_on_facemask();
	  Thread.sleep(5000);
	  int initial_product_list=mhp.storing_all_products_for_originallist();
	 
	  assertTrue(mhp.price_range_option_displayed(),"Price range option is not displayed !");
	  mhp.price_range_selection();
	  Thread.sleep(5000);
	  int price_list=mhp.storing_all_products_for_price_filter_page();
	  
	  
	  assertTrue(mhp.clear_all_button_displayed(),"Clear button is not displayed !");
	  mhp.click_on_clear_all_button();
	  
	  int final_product_list=mhp.storing_all_products_after_removing_filter();
	  
	  
	  int correct_price_count=mhp.checking_each_price_value_lies_in_range();
	  //System.out.println(correct_price_count);	  
	  assertEquals(price_list,correct_price_count,"All the item's price is not in the given range $15.0-$30.0");
	  
	  assertEquals(initial_product_list,final_product_list,"The number of products before applying filter and after applying filter are not same !");
	  
	  assertTrue(!(mhp.checking_if_displayed_products_are_equal()),"Products displayed before filter and after are not same !");
	  
  }
}
