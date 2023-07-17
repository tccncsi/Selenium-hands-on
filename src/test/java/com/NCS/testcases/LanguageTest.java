package com.NCS.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NCS.base.BaseClass;
import com.NCS.pageObjects.NetAPorterHP;
import com.NCS.pageObjects.Account;

public class LanguageTest extends BaseClass{

	NetAPorterHP HP;
	Account account;
	
	@Test
	public void LanguageChangeToAlbania() throws InterruptedException, IOException{
		HP = new NetAPorterHP(driver);
		HP.click_language_switch();
		HP.click_Albania();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-al/");
		HP.click_language_switch();
		HP.click_India();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.net-a-porter.com/en-in/");
		HP.click_Account();
		account = new Account(driver);
		account.click_create_account();
		account.enter_Email();
		account.enter_Password();
		account.enter_Title();
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
