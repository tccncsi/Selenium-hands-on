//package com.testCases;
//
//import java.util.ArrayList;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.base.BaseClass;
//import com.pageObjects.HandMHP;
//
//public class Assessment3 extends BaseClass {
//	HandMHP HandMhomepage;
//
//	@Test
//	public void hAndMItems() throws InterruptedException {
//		HandMhomepage = new HandMHP(driver);
//
////		Clicks on Accept Cookies Button
//		HandMhomepage.click_accept_cookies();
//
////		Hovers Sport Menu From the NavBar
//		HandMhomepage.mouseOversportMenu();
//
////		Clicks on Sport View All
//		HandMhomepage.click_sport_viewall();
//
////		Clicks on New Arrival On Mens Page
//		HandMhomepage.click_sport_new_arrival();
//
////		Clicks on Sort By Dropdown
//		HandMhomepage.click_sortby_dropdown();
//
////		Checks Whether the Recommended is Selected By Default or not
//		Assert.assertTrue(HandMhomepage.check_recommended_selected());
//		
////		Thread.sleep(2000);
////		HandMhomepage.click_grid3();
//
////		Loads all items and stores all recommended Items
//		HandMhomepage.load_all_items();
//		
////		System.out.println("\n -----------Now Printing the list of elements -------------------");
////		System.out.println(HandMhomepage.printListofWebElements());
//		
//		ArrayList<String> recommended_all = HandMhomepage.store_All_Items_href();
//		Thread.sleep(3000);
//		
//		
////		Assert.assertTrue(false);
//		// Clicks Lowest Price Filter 
//		HandMhomepage.click_sortby_dropdown();
//		HandMhomepage.click_LowestPrice();
//		System.out.println("Clicked on Lowest First option---------------------------------->");
//		
//		Thread.sleep(2000);
//		
////		Loads all items and stores href in a list 
//		HandMhomepage.load_all_items();
//		ArrayList<String> lowest_all = HandMhomepage.store_All_Items_href();
//		Assert.assertFalse(recommended_all.equals(lowest_all));
//		
////		Clicks on Dropdown and selects recommended button
//		HandMhomepage.click_sortby_dropdown();
//		HandMhomepage.click_recommendedbutton();
//		System.out.println("Clicked on Recommended---------------------------------->");
//
////		Loads all items and stores href in a list 
//		HandMhomepage.load_all_items();
//		ArrayList<String> recommended2 = HandMhomepage.store_All_Items_href();
//		
//		System.out.println(recommended2.size());
//		System.out.println(recommended_all.size());
//		
//		System.out.println(recommended2);
//		System.out.println(recommended_all);
////		
////		Checks if recommended sortby has been applied
//		Assert.assertTrue(recommended2.equals(recommended_all));
//		 
//		}
//}
