package com.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.NetAPorterHP;
import com.utilities.JiraCreateIssue;
import com.utilities.XLUtils;
import com.pageObjects.Account;

public class LanguageTest extends BaseClass{

	NetAPorterHP HP;
	Account account;
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(enabled=true)
	public void LanguageChangeToChina() throws InterruptedException, IOException{
		HP = new NetAPorterHP(driver);
		account = new Account(driver);
		
		
		HP.click_language_switch();
		HP.click_china();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/zh-in/");
		HP.click_language_switch();
		HP.click_english();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-in/");
		HP.click_Account();
		account.click_create_account();
		
		String excelPath = "src\\main\\java\\com\\testData\\TestData.xlsx";
	    String sheetName = "Sheet1";
	    int coloumnno = 1;
	    	
		account.enter_Email(XLUtils.getCellData(excelPath, sheetName, 0, coloumnno));
		account.enter_Password(XLUtils.getCellData(excelPath, sheetName, 1, coloumnno));
		account.enter_Firstname(XLUtils.getCellData(excelPath, sheetName, 2, coloumnno));
		account.enter_Lastname(XLUtils.getCellData(excelPath, sheetName, 3, coloumnno));
		account.enter_Title();
		account.enter_Dob(XLUtils.getCellData(excelPath, sheetName, 4, coloumnno),XLUtils.getCellData(excelPath, sheetName, 5, coloumnno),XLUtils.getCellData(excelPath, sheetName, 6, coloumnno));
		Assert.assertEquals(account.get_invaliddob(), "You must be at least 14 years ol");
		account.clear_DOB();
		account.enter_Dob(XLUtils.getCellData(excelPath, sheetName, 4, coloumnno),XLUtils.getCellData(excelPath, sheetName, 5, coloumnno),XLUtils.getCellData(excelPath, sheetName, 7, coloumnno));
		account.click_CreateAccountButton();
//		account.click_closebutton();

		
	}
	
	@Test(enabled=false)
	public void LanguageChangeToAlgeria() throws InterruptedException, IOException{
		HP = new NetAPorterHP(driver);
		HP.click_language_switch();
		HP.click_Algeria();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-dz/");
	}
	
	@Test(enabled=false)
	public void LanguageChangeToAndorra() throws InterruptedException, IOException{
		HP = new NetAPorterHP(driver);
		HP.click_language_switch();
		HP.click_Andorra();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-ad/");
	}
	
	@Test(enabled=false)
	public void LanguageChangeToAnguilla() throws InterruptedException, IOException{
		HP = new NetAPorterHP(driver);
		HP.click_language_switch();
		HP.click_Anguilla();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-ai/");
	}
}
