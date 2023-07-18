package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;
import com.advancedselenium.net_a_porter_website.pageobject.NetAPorterAccountPage;
import com.advancedselenium.net_a_porter_website.pageobject.NetAPorterHomePage;

public class NetAPorterEndToEndScenarioTest extends BaseClass {

	NetAPorterHomePage nhp;
	NetAPorterAccountPage nap;

	@Test
	public void checkingFullFunctionality() throws InterruptedException {
		nhp = new NetAPorterHomePage(driver);
		nap = new NetAPorterAccountPage(driver);

		nhp.click_on_language_change_dropdown();
		nhp.click_on_language_change_dropdown_on_changing_language();
		String currentUrl = nhp.getUrlOfCurrentPage();
		assertTrue(currentUrl.contains("zh-in"), "The language does not changes to japanese!!");

		nhp.click_on_language_change_dropdown();
		nhp.click_on_language_change_dropdown_on_changing_language();
		String currUrl = nhp.getUrlOfCurrentPage();
		assertTrue(currUrl.contains("en-in"), "The language does not changes to English!!");

		nhp.click_on_account_tab();
		String account_tab_heading = nhp.get_account_page_heading();
		assertEquals(account_tab_heading, "Sign in", "The heading is not matching!!");

		
		nap = nhp.click_on_create_account_btn();
		assertEquals(nap.get_register_page_heading(), "Register", "The user is not at register page!");
		
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

	}
}
