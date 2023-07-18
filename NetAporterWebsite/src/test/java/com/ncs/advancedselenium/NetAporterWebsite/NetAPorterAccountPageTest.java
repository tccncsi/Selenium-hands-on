package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;
import com.advancedselenium.net_a_porter_website.pageobject.NetAPorterAccountPage;
import com.advancedselenium.net_a_porter_website.pageobject.NetAPorterHomePage;

public class NetAPorterAccountPageTest extends BaseClass{
	
	NetAPorterHomePage nhp;
	NetAPorterAccountPage nap;
 
  
  
  @Test
	public void validRegistration() throws InterruptedException {

		nap=new NetAPorterAccountPage(driver);
		String excelPath = "src\\main\\java\\testData\\FormTestData.xlsx";
        String sheetName = "Data";
        int rowNumber = 0;
          	        
        String regEmail=XLUtils.getCellData(excelPath, sheetName, rowNumber, 1);       
        String regPassword=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regfname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String reglname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regdate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);       
        String regmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        
        nap.enter_email(regEmail);
        nap.enter_password(regPassword);
        nap.clicking_on_title_dropdown_menu();
        nap.selecting_value_from_dropdown();
        nap.enter_firstname(regfname);
        nap.enter_lastname(reglname);
        nap.enter_birthday_date(regdate);
        nap.enter_birthday_month(regmonth);
        nap.enter_birthday_year(regyear);
        //nap.accepting_sign_up_checkbox();
        //nap.clickingOnCreateAccountButton();
        
        //boolean visible=nap.captcha_is_dispayed();
        //assertTrue(visible,"The captcha container is not displayed");
        
        
	}
  
  	@Test
  	public void invalid_birthday_date() {
  		nap=new NetAPorterAccountPage(driver);
  		String excelPath = "src\\main\\java\\testData\\FormTestData.xlsx";
        String sheetName = "Data";
        int rowNumber = 0;
          	        
        String regEmail=XLUtils.getCellData(excelPath, sheetName, rowNumber, 1);
        String regPassword=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regfname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String reglname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regdate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);        
        String regmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);       
        String regyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbDate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
                
        nap.enter_email(regEmail);
        nap.enter_password(regPassword);
        nap.clicking_on_title_dropdown_menu();
        nap.selecting_value_from_dropdown();
        nap.enter_firstname(regfname);
        nap.enter_lastname(reglname);
        nap.enter_birthday_date(invalidbDate);
        nap.enter_birthday_month(invalidbmonth);
        nap.enter_birthday_year(invalidbyear);
        String error_msg=nap.error_msg_for_birthday();
        assertTrue(nap.error_msg_displayed(),"Error message not displayed !!");
        assertEquals(nap.error_msg_for_birthday(),"You must be at least 14 years old","Correct error message is not displayed!");;
  		
  	}
  	
  	@Test
  	public void invalid_email_field() {
  		nap=new NetAPorterAccountPage(driver);
  		String excelPath = "src\\main\\java\\testData\\FormTestData.xlsx";
        String sheetName = "Data";
        int rowNumber = 0;
          	        
        String regEmail=XLUtils.getCellData(excelPath, sheetName, rowNumber, 1);
        String regPassword=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regfname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String reglname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regdate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);        
        String regmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);       
        String regyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbDate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_email=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        
        nap.enter_email(invalid_email);
        nap.enter_password(regPassword);
        assertTrue(nap.email_error_displayed(),"Error message is not displayed!");
        assertEquals(nap.email_error_msg(),"Enter a valid Email","Correct error message is not displayed !");
  		
  	}
  	
  	@Test
  	public void invalid_password_field() {
  		nap=new NetAPorterAccountPage(driver);
  		String excelPath = "src\\main\\java\\testData\\FormTestData.xlsx";
        String sheetName = "Data";
        int rowNumber = 0;
          	        
        String regEmail=XLUtils.getCellData(excelPath, sheetName, rowNumber, 1);
        String regPassword=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regfname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String reglname=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String regdate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);        
        String regmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);       
        String regyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbDate=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbmonth=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalidbyear=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_email=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_pspch=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_pupch=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_ple=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_plch=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_ponalpha=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        String invalid_ponnum=XLUtils.getCellData(excelPath, sheetName, ++rowNumber, 1);
        
        nap.checking_for_invalid_values(invalid_pspch);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Must be 8 characters or more","Correct error msg is not displayed!!");
        nap.checking_for_invalid_values(invalid_pupch);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Your password must contain at least one number","Correct error msg is not displayed !!");
        nap.checking_for_invalid_values(invalid_ple);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Must be 8 characters or more","Correct error msg is not displayed !!");
        nap.checking_for_invalid_values(invalid_plch);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Your password must contain at least one number","Correct error msg is not displayed !!");
        nap.checking_for_invalid_values(invalid_ponalpha);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Your password must contain at least one number","Correct error msg is not displayed !!");
        nap.checking_for_invalid_values(invalid_ponnum);
        assertTrue(nap.password_error_displayed(),"Error msg is not displayed !");
        assertEquals(nap.password_error_msg(),"Your password must contain at least one uppercase letter","Correct error msg is not displayed !!");
        
        
  	}
  
  
}
