package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.HandMHP;

public class Assessment3 extends BaseClass {
	HandMHP HandMhomepage;

	@Test
	public void hAndMItems() throws InterruptedException {
		HandMhomepage = new HandMHP(driver);

//		Clicks on Accept Cookies Button
		HandMhomepage.click_accept_cookies();

//		Hovers Sport Menu From the NavBar
		HandMhomepage.mouseOversportMenu();

//		Clicks on Sport View All
		HandMhomepage.click_sport_viewall();

//		Clicks on New Arrival On Mens Page
		HandMhomepage.click_sport_new_arrival();

//		Clicks on Sort By Dropdown
		HandMhomepage.click_sortby_dropdown();

//		Checks Whether the Recommended is Selected By Default or not
		Assert.assertTrue(HandMhomepage.check_recommended_selected());

//		Loads all items and stores all recommended Items
		HandMhomepage.load_all_items();
		String[] recommended_all = HandMhomepage.store_All_Items_href();
		Thread.sleep(3000);
		
		// Clicks Lowest Price Filter 
		HandMhomepage.click_sortby_dropdown();
		HandMhomepage.click_LowestPrice();
		System.out.println("Clicked on Lowest First option----------------------------------");
		
		Thread.sleep(2000);
		
//		Loads all items and stores href in a list 
		HandMhomepage.load_all_items();
		String[] lowest_all = HandMhomepage.store_All_Items_href();
		Assert.assertFalse(recommended_all.equals(lowest_all));
		
//		Clicks on Dropdown and selects recommended button
		HandMhomepage.click_sortby_dropdown();
		HandMhomepage.click_recommendedbutton();
		System.out.println("Clicked on Recommended----------------------------------");

//		Loads all items and stores href in a list 
		HandMhomepage.load_all_items();
		String[] recommended2 = HandMhomepage.store_All_Items_href();
		
//		Checks if recommended sortby has been applied
		Assert.assertTrue(recommended2.equals(recommended2));
		 
		}
}
