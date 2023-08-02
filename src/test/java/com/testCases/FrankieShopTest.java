package com.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.FrankieShopPage;
import com.utilities.JiraCreateIssue;

public class FrankieShopTest extends BaseClass {

	FrankieShopPage frankieshop;

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void FrankieShopFilterTest() throws InterruptedException {
		frankieshop = new FrankieShopPage(driver);

		frankieshop.accpetCookies();
		frankieshop.hoverOnShopMenu();
		Thread.sleep(2000);
		frankieshop.clickOnMenCategory();
		Thread.sleep(2000);
		frankieshop.clickOnNewIn();
		String pageTitle = frankieshop.getCategoryPageTitle();
		
		//-------------Assert Statement--------------
		assertTrue(pageTitle.contains("New Arrivals"), "Selected listing page is not same as selected.");

		frankieshop.clickOnLoadMore();
		List<String> productListBeforeFilter = frankieshop.getProductList();
		
		System.out.println(productListBeforeFilter);
		
		frankieshop.clickOnFilter();
		String filterValue = frankieshop.getFilterValue();
		frankieshop.selectSize();
		frankieshop.clickSizeCloseButton();
		Thread.sleep(5000);
		frankieshop.clickOnLoadMore();
		List<String> appliedFilterProducts = frankieshop.getProductList();
		
		System.out.println(appliedFilterProducts);
		System.out.println("Filter Value to be searched " + filterValue);
		
		boolean resultAfterFilter = frankieshop.checkForFilterResult(frankieshop.getProductSizes(), filterValue);
		
		//-------------Assert Statement--------------
		assertTrue(resultAfterFilter);

		frankieshop.clearFilter();
		Thread.sleep(2000);
		frankieshop.clickOnLoadMore();

		List<String> productListAfterFilter = frankieshop.getProductList();
		
		System.out.println(productListBeforeFilter);
		System.out.println(productListAfterFilter);

		//-------------Assert Statement--------------
		assertEquals(productListBeforeFilter, productListAfterFilter, "The Original List is not displayed correctly.");
	}
}
