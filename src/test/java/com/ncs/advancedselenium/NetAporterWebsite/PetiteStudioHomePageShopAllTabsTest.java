package com.ncs.advancedselenium.NetAporterWebsite;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.advance_selenium.net_a_porter_website.base.BaseClass;
import com.advance_selenium.net_a_porter_website.utilities.JiraCreateIssue;
import com.advancedselenium.net_a_porter_website.pageobject.PetiteStudioHomePage;

public class PetiteStudioHomePageShopAllTabsTest extends BaseClass {

	PetiteStudioHomePage pshp;

//	@Test
//	public void f() {
//	}
	
//	@JiraCreateIssue(isCreateIssue = true)
//	@Test
//	public void validating_different_tabs_of_shopAll_tab() {
//		pshp=new PetiteStudioHomePage(driver);
//		pshp.hovering_over_tab();
//		String new_arrivals=pshp.get_href_attribute_for_the_specified_link(1);
//		assertEquals(new_arrivals,"https://www.petitestudionyc.com/collections/new-arrivals","Not redirecting to the new arrivals page!");
//		String best_sellers=pshp.get_href_attribute_for_the_specified_link(2);
//		assertEquals(best_sellers,"https://www.petitestudionyc.com/collections/best-sellers","Not redirecting to the best sellers page !");
//		String dresses=pshp.get_href_attribute_for_the_specified_link(3);
//		assertEquals(dresses,"https://www.petitestudionyc.com/collections/dresses","Not redirecting to the dresses page!");
//		String tops=pshp.get_href_attribute_for_the_specified_link(4);
//		assertEquals(tops,"https://www.petitestudionyc.com/collections/tops","Not redirecting to the tops page!");
//		String bottoms=pshp.get_href_attribute_for_the_specified_link(5);
//		assertEquals(bottoms,"https://www.petitestudionyc.com/collections/bottoms","Not redirecting to the bottoms page!");
//		String knit_wear=pshp.get_href_attribute_for_the_specified_link(6);
//		assertEquals(knit_wear,"https://www.petitestudionyc.com/collections/knitwear","Not redirecting to the knit wear page!");
//		String outer_wear=pshp.get_href_attribute_for_the_specified_link(7);
//		assertEquals(outer_wear,"https://www.petitestudionyc.com/collections/coats-jackets","Not redirecting to the outer wear page!");
//		String final_sale=pshp.get_href_attribute_for_the_specified_link(8);
//		assertEquals(final_sale,"https://www.petitestudionyc.com/collections/sale","Not redirecting to the final sale page!");
//	
//	}
//	
//	
//	@JiraCreateIssue(isCreateIssue = true)
//	@Test
//	public void validating_different_tabs_on_second_section() {
//		pshp=new PetiteStudioHomePage(driver);
//		pshp.hovering_over_tab();
//		String summer_collection=pshp.get_href_attribute_for_second_section(1);
//		assertEquals(summer_collection,"https://www.petitestudionyc.com/collections/summer-23-collection","Not redirecting to the summer 23 collection page !");
//		String suggly_collection=pshp.get_href_attribute_for_second_section(2);
//		assertEquals(suggly_collection,"https://www.petitestudionyc.com/collections/suggyl-x-petite-studio-capsule","Not redirecting to the suggly collection page !");
//		String spring_collection=pshp.get_href_attribute_for_second_section(3);
//		assertEquals(spring_collection,"https://www.petitestudionyc.com/collections/spring-23-collection","Not redirecting to the spring collection page !");
//		String buvette_collection=pshp.get_href_attribute_for_second_section(4);
//		assertEquals(buvette_collection,"https://www.petitestudionyc.com/collections/buvette-collection","Not redirecting to the buvette collection page !");
//		String business_casual=pshp.get_href_attribute_for_second_section(5);
//		assertEquals(business_casual,"https://www.petitestudionyc.com/collections/business-staples","Not redirecting to the business collection page !");
//		String accessories=pshp.get_href_attribute_for_second_section(6);
//		assertEquals(accessories,"https://www.petitestudionyc.com/collections/accessories/Accessories","Not redirecting to the accessories page !");
//	}
//	
//	
//	@JiraCreateIssue(isCreateIssue = true)
//	@Test
//	public void validating_different_tabs_under_help_section() {
//		pshp=new PetiteStudioHomePage(driver);
//		pshp.hovering_over_tab();
//		String contact_us=pshp.get_href_attribute_under_help_section(1);
//		assertEquals(contact_us,"https://www.petitestudionyc.com/pages/contact-us","Not redirecting to the contact us page !");
//		String return_link=pshp.get_href_attribute_under_help_section(3);
//		assertEquals(return_link,"https://www.petitestudionyc.com/a/returns","Not redirecting to the return centre page !");
//		String shipping=pshp.get_href_attribute_under_help_section(4);
//		assertEquals(shipping,"https://www.petitestudionyc.com/pages/shipping-returns","Not redirecting to the shiiping return page !");
//		String size=pshp.get_href_attribute_under_help_section(6);
//		assertEquals(size,"https://www.petitestudionyc.com/pages/size-chart","Not redirecting to the size chart page !");
//		String terms=pshp.get_href_attribute_under_help_section(7);
//		assertEquals(terms,"https://www.petitestudionyc.com/pages/terms-of-service","Not redirecting to the terms of services page !");
//		String track=pshp.get_href_attribute_under_help_section(8);
//		assertEquals(track,"https://www.petitestudionyc.com/pages/track-your-order","Not redirecting to the Track your order page !");
//		String privacy_policy_page=pshp.get_href_attribute_under_help_section(9);
//		assertEquals(privacy_policy_page,"https://www.petitestudionyc.com/pages/privacy-policy","Not redirecting to the Privacy policy page!");
//		
//	}
	
	@Test
	public void ValidatingAllLinksUnderShopAllTabTest() {
		pshp=new PetiteStudioHomePage(driver);
		pshp.hovering_over_tab();
		pshp.validating_left_section_for_shopAlltab();
		pshp.validating_right_section_for_shopAlltab();
		pshp.hovering_over_logo();
		pshp.validating_all_links_under_help_section();
	}
	
}
