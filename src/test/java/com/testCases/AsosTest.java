package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AsosHomePage;
import com.utilities.JiraCreateIssue;

public class AsosTest extends BaseClass {
	
	AsosHomePage asoshp;
	
    @JiraCreateIssue(isCreateIssue = true)
	@Test
	public void menAccessoriesLinksTest() throws InterruptedException {
		asoshp=new AsosHomePage(driver);
		
		asoshp.clickOnMenOption();
		
		Thread.sleep(2000);
		
		asoshp.hoverAccessoriesOption();
		
		asoshp.verifyAccessoriesLinks();
		
		asoshp.verifyFooterLinks();
	}

}
