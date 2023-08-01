package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AmazonHP;
import com.pageObjects.AmazonRP;
import com.pageObjects.AmazonSearchJeans;
import com.pageObjects.AmazonTodayDeal;
import com.pageObjects.TillysHP;
import com.pageObjects.TillysSale;
import com.pageObjects.youngandreckHP;

public class Practical_assess extends BaseClass{
	youngandreckHP younghomepage;
	TillysHP tillyshomepage;
	TillysSale tillyssale;
	AmazonHP amazonhomepage;
	AmazonTodayDeal amazonTD;
	AmazonSearchJeans amazonsearch;
	AmazonRP amazonreviewpage;
	
	
	@Test(enabled=false)
	public void Links() throws IOException {
		younghomepage = new youngandreckHP(driver);
		
//		hovers over mens section from navbar
		younghomepage.mouseOver_nav_mens();
		
//		Passes all the links present in mens top section to a function and checks if all the links are valid
		double pass_ratio = younghomepage.check_links_mentop();
		
//		Checks if the ratio is 1 to ensure all the links were valid
		younghomepage.check_ratio(pass_ratio);

//		Passes all the links present in footer support section to a function and checks if all the links are valid
		double pass_ratio2 = younghomepage.check_links_footer();

//		Checks if the ratio is 1 to ensure all the links were valid
		younghomepage.check_ratio(pass_ratio2);
		
		System.out.println("Completed young and reckless scenario");
	}
	
	@Test(enabled=false)
	public void add_products() {
		tillyshomepage = new TillysHP(driver);
		tillyssale = new TillysSale(driver);
		
//		Clicks on Sale tab from Navbar
		tillyshomepage.click_nav_Sale();
		
//		Fetches all the discounted text under mens section
		int max_disc_mens_index = tillyssale.get_max_discount_mens();
		
//		hovers the least discount items
		tillyssale.hovers_img(max_disc_mens_index);
		
	}
	
	@Test(enabled = false)
	public void AddProducts() {
		amazonhomepage = new AmazonHP(driver);
		amazonTD = new AmazonTodayDeal(driver);
		
//		Clicks on Todays deal from the navbar
		amazonhomepage.click_nav_TodayDeal();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/deals?ref_=nav_cs_gb","Todays Deal Page not loaded");
		
//		Stores index of Maximum Discount from Category and clicks on it
		int indexDisc = amazonTD.getMaxDiscountCategory();
		amazonTD.click_MaxDisc(indexDisc);
		
//		Stores index of Maximum Discounted Product and clicks on it
		int indexProduct = amazonTD.getMaxProduct();
		amazonTD.click_MaxProduct(indexProduct);
		
//		Stores index of Maximum Discounted Product Item and Clicks on It
		int indexProductItem = amazonTD.getMaxProductItem();
		amazonTD.click_MaxProductItem(indexProductItem);
		
//		Stores the Price of the Product Item
		int MaxProductItemPrice = amazonTD.getMaxProductItemPrice();
		
//		Clicks on Add to Bag 
		amazonTD.click_addToBag();
		
//		Clicks on Go to Cart Button
		amazonTD.click_goToCart();
		
//		Asserting previous page price and cart price page
		Assert.assertEquals(MaxProductItemPrice, amazonTD.getPriceFromCart());
	}
	
	@Test
	public void FetchWriteRecords() throws InterruptedException {
		amazonhomepage = new AmazonHP(driver);
		amazonsearch = new AmazonSearchJeans(driver);
		amazonreviewpage = new AmazonRP(driver);
		
//		Enters "Jeans" in Search Bar
		amazonhomepage.searchJeans();
		
//		Clicks on Search Button
		amazonhomepage.click_searchButton();
		
		Thread.sleep(3000);
//		Clicks on 4 Star Ratings from Categories
		amazonsearch.click_rating4();
		
		Thread.sleep(2000);
		
//		Clicks on First Item having ratings greater than 1500
		int indexCondRating = amazonsearch.getRatingsCount();
		amazonsearch.click_maxRating_item(indexCondRating);
		
//		Switches window to the new tab
		amazonsearch.handleWindow();

//		Clicks on Ratings link
		amazonsearch.click_ratingLink();
		
//		Clicks on See more Reviews
		amazonreviewpage.click_seeMoreReviews();
		
//		Gets all the data in format and writes in a txt file
		amazonreviewpage.getReviewInFormat();
	}
	
	
	
	

}
