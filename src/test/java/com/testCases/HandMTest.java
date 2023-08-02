package com.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.HMHomePage;
import com.pageObjects.HMSportPage;
import com.utilities.JiraCreateIssue;

public class HandMTest extends BaseClass {

	HMHomePage hmhomepage;
	HMSportPage hmsportpage;

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void verifyRecommendedSortSelectedByDefault() throws InterruptedException, IOException {
		hmhomepage = new HMHomePage(driver);
		hmsportpage = new HMSportPage(driver);

		//To validate Recommended option is selected by default
		hmhomepage.acceptCookiesIfDisplayed();
		hmhomepage.hoverOverSportMenu();
		hmhomepage.selectSportsMensViewAll();
		//hmsportpage.setImageSizeLarge();
		hmsportpage.clickOnSortBy();
		assertTrue(hmsportpage.checkRecommendedSelected(), "Recommended option is not selected as default option");

		//To verify all products are changed after selecting Lower Price option

		hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
		List<String> initialHref = hmsportpage.getProductHrefLinks();
		hmsportpage.selectLowestPriceOption();
		Thread.sleep(3000);
		//hmsportpage.setImageSizeLarge();
		hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
		List<String> updatedHref = hmsportpage.getProductHrefLinks();
		assertTrue(!initialHref.equals(updatedHref));

		//To verify Recommended products are displayed again correctly
		hmsportpage.clickOnSortBy();
		hmsportpage.selectRecommendedOption();
		Thread.sleep(2000);
		//hmsportpage.setImageSizeLarge();
		hmsportpage.clickOnLoadMoreProductsButtonUntilAllShown();
		List<String> recommendedHref = hmsportpage.getProductHrefLinks();
		assertTrue(initialHref.equals(recommendedHref));
	}
}
