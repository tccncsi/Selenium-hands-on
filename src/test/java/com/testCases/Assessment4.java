package com.testCases;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AmericanEagleHP;

public class Assessment4 extends BaseClass {
	AmericanEagleHP AEHP;
	int ToBuyQuant=2;
	
	@Test
	public void Add_Products() throws InterruptedException {
		AEHP = new AmericanEagleHP(driver);
		
//		Clicks on Accept All Cookies
		AEHP.click_acceptcookies();
		
//		Hovers on Clearance Item
		AEHP.hover_Clearance();
		
//		Clicks on Top Item
		AEHP.click_tops();
		
		Thread.sleep(2000);
		
//		Stores every element in HashMap
		Map<Integer, Double> values = AEHP.get_last_chance_all_price();
		
//		Arranges the element in Ascending order and returns first index 
		Entry<Integer, Double> element_lowest = AEHP.sort_last_chance_all_price(values);
		
//		Storing in the variables
		int element_index = element_lowest.getKey();
		double element_price = element_lowest.getValue();
		
		System.out.println(element_index +" " +element_lowest);
		

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@aria-label='Close'])[1]")).click();
		
//		Fetching the element depending on Index and click on the item
		AEHP.hover_lowest_item(element_index);
		
		
		AEHP.click_quick_shop(element_index);
		
		Thread.sleep(2000);
		String side_price = AEHP.validate_price();
		double side_price2 = Double.parseDouble(side_price);
		
		
		System.out.println(side_price2);
		System.out.println(element_price);
		Assert.assertEquals(side_price2, element_price);
		
		AEHP.check_quantity(ToBuyQuant);
		
		AEHP.click_AddTobag();
		
		AEHP.click_first_available_size();
		
		AEHP.click_ViewBag();
		Thread.sleep(3000);
		
		Assert.assertEquals(AEHP.get_total_price(), element_price*ToBuyQuant);
		
		Assert.assertEquals(AEHP.get_shipping() + AEHP.get_total_price(),AEHP.get_TotalPrice());
	}

}
