package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.JiraCreateIssue;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;
import com.advancedselenium.net_a_porter_website.pageobject.MankindHomePage;
import com.advancedselenium.net_a_porter_website.pageobject.MissGuidedHomePage;
import com.advancedselenium.net_a_porter_website.pageobject.PHPTraveleersHomePage;

public class AllAssessmentScenarioTest extends BaseClass {
	MankindHomePage mhp;
	MissGuidedHomePage mghp;
	PHPTraveleersHomePage pthp;

	//Automating Mankind Website
	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void checking_filter() throws InterruptedException {
		driver.get("https://www.mankind.co.uk/");
		System.out.println("test for Mankind website !!");
		mhp = new MankindHomePage(driver);
		mhp.handleCookiePopup();
		mhp.handleSignUpPopup();

		assertTrue(mhp.skin_tab_displayed(), "Skin tab is not displayed!");
		mhp.hovering_over_skin_tab();
		mhp.click_on_facemask();
		Thread.sleep(5000);
		int initial_product_list = mhp.storing_all_products_for_originallist();

		assertTrue(mhp.price_range_option_displayed(), "Price range option is not displayed !");
		mhp.price_range_selection();
		Thread.sleep(5000);
		int price_list = mhp.storing_all_products_for_price_filter_page();

		assertTrue(mhp.clear_all_button_displayed(), "Clear button is not displayed !");
		mhp.click_on_clear_all_button();

		int final_product_list = mhp.storing_all_products_after_removing_filter();

		int correct_price_count = mhp.checking_each_price_value_lies_in_range();
		// System.out.println(correct_price_count);
		assertEquals(price_list, correct_price_count, "All the item's price is not in the given range $15.0-$30.0");

		assertEquals(initial_product_list, final_product_list,
				"The number of products before applying filter and after applying filter are not same !");

		assertTrue(!(mhp.checking_if_displayed_products_are_equal()),
				"Products displayed before filter and after are not same !");

	}
	
	
	//Automating MissGuided website
	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void links_test() throws InterruptedException {
		
		driver.get("https://www.missguided.co.uk/");

		System.out.println("test for miss guided website");
		mghp = new MissGuidedHomePage(driver);
		mghp.handleCookiePopup();
		mghp.clicking_on_clothing_tab();
		assertTrue(mghp.max_discount_displayed(), "Max Discount option is not displayed !");
		mghp.selecting_from_sort_options();

		assertTrue(mghp.add_to_cart_btn_displayed(), "Add to cart btn is not displayed !");
		mghp.clicking_on_add_to_cart_btn();

		assertTrue(mghp.selecting_size_displayed(), "Select size is not displayed !");
		mghp.selecting_suitable_size();

		mghp.clicking_on_add_to_bag();
		assertTrue(mghp.validating_cart(), "Total price is not correct.");

	}
	
	
	//Automating PHP Traveller website
		@JiraCreateIssue(isCreateIssue = true)
	@Test(enabled=false)
	public void registration_test() throws IOException, InterruptedException {
			driver.get("https://phptravels.com/demo/");
		System.out.println("test for PHP Travelers website");
		pthp = new PHPTraveleersHomePage(driver);
		assertTrue(pthp.signup_btn_displayed(), "signup tab is not visible");
		pthp.click_on_signup_btn();
		pthp.enteringtextinfields();

		pthp.generating_password();

//		  assertTrue(pthp.error_msg_box_displayed(),"Error Message box is not displayed");
//		  assertTrue(pthp.error_msg_heading_displayed(),"Error message box heading is not displayed");
//		  assertTrue(pthp.error_msg_displayed(),"Error message is not displayed.");

		String actual_value = pthp.dashboard_name();
		String expected_value = XLUtils.FetchExcelData("FirstName") + " " + XLUtils.FetchExcelData("LastName");
		assertEquals(actual_value, expected_value, "Registartion is unsuccessfully !!");

	}

	@JiraCreateIssue(isCreateIssue = true)
	@Test // (enabled=false)
	public void validating_password() {
		driver.get("https://phptravels.com/demo/");

		pthp = new PHPTraveleersHomePage(driver);
		pthp = new PHPTraveleersHomePage(driver);
		assertTrue(pthp.signup_btn_displayed(), "signup tab is not visible");
		pthp.click_on_signup_btn();
		assertTrue(pthp.validating_password_field_for_less_than_64(),
				"Password not generated according to the given length");
		assertTrue(pthp.validating_password_field_for_equal_to_64(),
				"Password generated is not equal to the given length");
		assertTrue(!(pthp.validating_password_field_for_graeter_than_64()), "Password is not following the range");
		assertTrue(pthp.validating_password_field_for_equal_to_8(),
				"Not satisfying the lower boundary value condition");
		assertTrue(!(pthp.validating_password_field_for_less_than_8()), "Password is not follwoing the lower range");
	}
}
