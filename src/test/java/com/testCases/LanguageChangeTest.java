package com.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.HomePage;
import com.utilities.JiraCreateIssue;
import com.utilities.XLUtils;

public class LanguageChangeTest extends BaseClass {

	HomePage homepage;

	@JiraCreateIssue(isCreateIssue = true)
	@Test(enabled = false)
	public void LanguageChange() {
		homepage = new HomePage(driver);
		homepage.clickLanguageSelector();
		homepage.selectLanguage();
		String currentUrl = homepage.getUrl();
		Assert.assertTrue(currentUrl.contains("zh-sg"), "Website language is not changed to chinese.");
		homepage.clickLanguageSelector();
		homepage.selectLanguage();
		String currentUrlChanges = homepage.getUrl();
		Assert.assertEquals(currentUrlChanges, "https://www.net-a-porter.com/en-sg/");
		//Assert.assertTrue(false);
	}

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void SignUp2() throws InterruptedException {

		String excelPath = "src\\main\\java\\com\\testData\\TestData.xlsx";
		String sheetName = "Sheet1";
		int rowNumber = 0;
		
		String regEmail=XLUtils.getCellData(excelPath, sheetName, rowNumber, 1);
		String regPassword=XLUtils.getCellData(excelPath, sheetName, rowNumber+1, 1);
		String firstName=XLUtils.getCellData(excelPath, sheetName, rowNumber+2, 1);
		String lastName=XLUtils.getCellData(excelPath, sheetName, rowNumber+3, 1);
		String IBirthDay=XLUtils.getCellData(excelPath, sheetName, rowNumber+4, 1);
		String IBirthMonth=XLUtils.getCellData(excelPath, sheetName, rowNumber+5, 1);
		String IBirthYear=XLUtils.getCellData(excelPath, sheetName, rowNumber+6, 1);
		String VBirthYear=XLUtils.getCellData(excelPath, sheetName, rowNumber+9, 1);
		
		homepage = new HomePage(driver);
		homepage.clickAccountIcon();
		homepage.clickCreateAccount();
		Thread.sleep(1000);
		homepage.enterRegEmail(regEmail);
		homepage.enterRegPassword(regPassword);
		homepage.clickTitleDropdown();
		homepage.selectUserTitle();
		homepage.enterFirstName(firstName);
		homepage.enterLastName(lastName);
		homepage.enterBirthDay(IBirthDay);
		homepage.enterBirthMonth(IBirthMonth);
		homepage.enterBirthYear(IBirthYear);
		Assert.assertEquals(homepage.getDobErrorMessage(), "You must be at least 14 years old");
		Thread.sleep(2000);
		homepage.enterBirthYear("");
		homepage.enterBirthYear(VBirthYear);
		homepage.clickCASubmitForm();
		Assert.assertTrue(false);
		//Thread.sleep(10000);
		//homepage.clickImageCloseButton();
	}
}
