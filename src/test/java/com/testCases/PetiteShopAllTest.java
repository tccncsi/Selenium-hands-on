package com.testCases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.PetiteStudioHomePage;
import com.utilities.JiraCreateIssue;

public class PetiteShopAllTest extends BaseClass {
	PetiteStudioHomePage petitehomepage;

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void ShopAllTest() throws InterruptedException {
		petitehomepage = new PetiteStudioHomePage(driver);
		
		petitehomepage.hoverOverShopAllLink();
		Thread.sleep(3000);
	}
}
