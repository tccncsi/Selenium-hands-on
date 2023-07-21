package com.testCases;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.PetiteStudioHP;
import com.utilities.JiraCreateIssue;

public class Assessment2 extends BaseClass{
	PetiteStudioHP petitehomepage;
	
	@JiraCreateIssue(isCreateIssue = true)
	@Test(enabled=false)
	public void RedirectLinks() throws InterruptedException {
		petitehomepage = new PetiteStudioHP(driver);
		petitehomepage.hover_shopall();
		String arr_link = petitehomepage.getatt_arrivallink();
		Assert.assertEquals(arr_link,"https://www.petitestudionyc.com/collections/new-arrivals");
		String best_link = petitehomepage.getatt_best_sellerslink();		
		Assert.assertEquals(best_link,"https://www.petitestudionyc.com/collections/best-sellers");
		String dresses_link= petitehomepage.getatt_dresseslink();
		Assert.assertEquals(dresses_link,"https://www.petitestudionyc.com/collections/dresses");
		String tops_link= petitehomepage.getatt_topslink();
		Assert.assertEquals(tops_link,"https://www.petitestudionyc.com/collections/tops");
		String bottoms_link= petitehomepage.getatt_bottomslink();
		Assert.assertEquals(bottoms_link,"https://www.petitestudionyc.com/collections/bottoms");
		String knitwearlink= petitehomepage.getatt_knitwearlink();
		Assert.assertEquals(knitwearlink,"https://www.petitestudionyc.com/collections/knitwear");
		String outerwearlink= petitehomepage.getatt_outerwearlink();
		Assert.assertEquals(outerwearlink,"https://www.petitestudionyc.com/collections/coats-jackets");
		String finalsalelink= petitehomepage.getatt_finalsalelink();
		Assert.assertEquals(finalsalelink,"https://www.petitestudionyc.com/collections/sale");
		String summer = petitehomepage.getatt_Summer();
		Assert.assertEquals(summer,"https://www.petitestudionyc.com/collections/summer-23-collection");
		String suggyl = petitehomepage.getatt_Suggyl();
		Assert.assertEquals(suggyl,"https://www.petitestudionyc.com/collections/suggyl-x-petite-studio-capsule");
		String spring = petitehomepage.getatt_Spring();
		Assert.assertEquals(spring,"https://www.petitestudionyc.com/collections/spring-23-collection");
		String buvette = petitehomepage.getatt_buvette();
		Assert.assertEquals(buvette,"https://www.petitestudionyc.com/collections/buvette-collection");
		String business = petitehomepage.getatt_business();
		Assert.assertEquals(business,"https://www.petitestudionyc.com/collections/business-staples");
		String accessories = petitehomepage.getatt_accessories();
		Assert.assertEquals(accessories,"https://www.petitestudionyc.com/collections/accessories/Accessories");
		
		petitehomepage.click_logo();
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		String contact = petitehomepage.getatt_contactus();
		Assert.assertEquals(contact,"https://www.petitestudionyc.com/pages/contact-us");
		String returncenter = petitehomepage.getatt_returncenter();
		Assert.assertEquals(returncenter,"https://petitestudionyc.loopreturns.com/#/");		
		String shipping_return = petitehomepage.getatt_shipping_return();
		Assert.assertEquals(shipping_return,"https://www.petitestudionyc.com/pages/shipping-returns");		
		String size_chart = petitehomepage.getatt_size_chart();
		Assert.assertEquals(size_chart,"https://www.petitestudionyc.com/pages/size-chart");		
		String terms_service = petitehomepage.getatt_terms_service();
		Assert.assertEquals(terms_service,"https://www.petitestudionyc.com/pages/terms-of-service");		
		String track = petitehomepage.getatt_track();
		Assert.assertEquals(track,"https://www.petitestudionyc.com/pages/track-your-order");		
		String privacy = petitehomepage.getatt_privacy();
		Assert.assertEquals(privacy,"https://www.petitestudionyc.com/pages/privacy-policy");		
				
	}

	@Test
	public void DynamicRedirect() throws IOException {
		petitehomepage = new PetiteStudioHP(driver);
		petitehomepage.hover_shopall();
		
		/* For Category Items */
		int total_categoryItem=petitehomepage.count_categoryItems();
		for(int i=1; i<total_categoryItem+1; i++) {
			String url = petitehomepage.category_iter_link(i);
			if (url=="#" || url=="") {
				Assert.assertFalse(true);
			}
			else {
				int result=petitehomepage.fetch_httpurlconnection(url);
				if (result!=200) {
					Assert.assertFalse(true);
				}
			}
		}
//			else if(url.contains(petitehomepage.category_text_iter_link(i))) {
//				System.out.println("Pass : "+url);
//			}
//			else {
//				System.out.println("Fail : "+url);
//				System.out.println(petitehomepage.category_text_iter_link(i));
//			}
		
		/* For Collection Items */
		int total_collectionItem=petitehomepage.count_collectionItems();
		for(int j=1; j<total_collectionItem+1; j++) {
			String url = petitehomepage.collection_iter_link(j);
			if (url=="#" || url=="") {
				Assert.assertFalse(true);
			}
			else {
				int result=petitehomepage.fetch_httpurlconnection(url);
				if (result!=200) {
					Assert.assertFalse(true);
				}
			}
		}
//			else if(url.contains(petitehomepage.collection_text_iter_link(j))) {
//				System.out.println("Pass : "+url);
//			}
//			else {
//				System.out.println("Fail : "+url);
//				System.out.println(petitehomepage.category_text_iter_link(j));
//			}
		
		petitehomepage.click_logo();
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		/* For Footer Items */
		int total_footerItem=petitehomepage.count_footerItems();
		for(int k=1;k<=total_footerItem;k++) {
			String url = petitehomepage.footerItems_iter_link(k);
			if (url=="#" || url=="") {
				Assert.assertFalse(true);
			}
			else {
				int result=petitehomepage.fetch_httpurlconnection(url);
				if (result!=200) {
					Assert.assertFalse(true);
				}
			}
		}
	}
	
	
	public void extra_code() {
//		petitehomepage.click_new_arrivallink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/new-arrivals");
		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_best_sellerslink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/best-sellers");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_dresseslink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/dresses");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_topslink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/tops");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_bottomslink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/bottoms");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_knitwearlink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/knitwear");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_outerwearlink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/coats-jackets");
//		
//		petitehomepage.click_logo();
//		petitehomepage.hover_shopall();
//		petitehomepage.click_finalsalelink();
//		Assert.assertEquals(driver.getCurrentUrl(),"https://www.petitestudionyc.com/collections/sale");
//		
//		petitehomepage.click_logo();
		}
		
	}