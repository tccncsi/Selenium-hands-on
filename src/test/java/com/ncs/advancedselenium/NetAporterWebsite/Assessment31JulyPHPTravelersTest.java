package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.JiraCreateIssue;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;
import com.advancedselenium.net_a_porter_website.pageobject.PHPTraveleersHomePage;

public class Assessment31JulyPHPTravelersTest extends BaseClass{
	
	PHPTraveleersHomePage pthp;
	
	@JiraCreateIssue(isCreateIssue = true)
  @Test(enabled=false)
  public void registration_test() throws IOException, InterruptedException {
		driver.get("https://phptravels.com/demo/");
	  System.out.println("Dummy test for PHP Travelers website");
	  pthp=new PHPTraveleersHomePage(driver);
	  assertTrue(pthp.signup_btn_displayed(),"signup tab is not visible");
	  pthp.click_on_signup_btn();
	  pthp.enteringtextinfields();
	  
	  pthp.generating_password();
	  
//	  assertTrue(pthp.error_msg_box_displayed(),"Error Message box is not displayed");
//	  assertTrue(pthp.error_msg_heading_displayed(),"Error message box heading is not displayed");
//	  assertTrue(pthp.error_msg_displayed(),"Error message is not displayed.");
	  
	  String actual_value=pthp.dashboard_name();
	  String expected_value=XLUtils.FetchExcelData("FirstName")+" "+XLUtils.FetchExcelData("LastName");
	  assertEquals(actual_value,expected_value,"Registartion is unsuccessfully !!");
	  
  }
  
  @JiraCreateIssue(isCreateIssue = true)
  @Test//(enabled=false)
  public void validating_password() {
	  driver.get("https://phptravels.com/demo/");
	  
	  pthp=new PHPTraveleersHomePage(driver);
	  pthp=new PHPTraveleersHomePage(driver);
	  assertTrue(pthp.signup_btn_displayed(),"signup tab is not visible");
	  pthp.click_on_signup_btn();
	  assertTrue(pthp.validating_password_field_for_less_than_64(),"Password not generated according to the given length");
	  assertTrue(pthp.validating_password_field_for_equal_to_64(),"Password generated is not equal to the given length");
	  assertTrue(!(pthp.validating_password_field_for_graeter_than_64()),"Password is not following the range");
	  assertTrue(pthp.validating_password_field_for_equal_to_8(),"Not satisfying the lower boundary value condition");
	  assertTrue(!(pthp.validating_password_field_for_less_than_8()),"Password is not follwoing the lower range");
  }
}
