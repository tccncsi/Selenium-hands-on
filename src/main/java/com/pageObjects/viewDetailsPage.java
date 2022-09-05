package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class viewDetailsPage extends BasePage {
	
	public viewDetailsPage  (WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	//turrya chennai name
	@FindBy(xpath="//h2[1]")
	WebElement hotelname;
	
	//MAp view
		@FindBy(xpath="//li[contains(text(),\"Map view\")]")
		WebElement viewmap;
	
		//click on zoom in (plus sign)
		@FindBy(xpath="(//iframe[@title='Criteo DIS iframe'])[3]")
		WebElement plussign;
		
	//wait for hotel name 
	public void waitforHotelName() {
		waitForFindElementPresent(hotelname);
		
	}
	
	//get the turrya hotel price
	public void viewdetail_turryaprice() {
		waitForFindElementPresent( driver.findElement(By.xpath("//span[@class=\"fs-7 fw-700 c-neutral-900\"]")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String price2 = driver.findElement(By.xpath("//span[@class=\"fs-7 fw-700 c-neutral-900\"]")).getText();
		
		 String result2 = price2.substring(0, 0) + price2.substring(0+1);
		   System.out.println(result2);
		   
		   result2 = result2.replaceAll(",","");
				   System.out.println(result2);
				   
	}
	
	//scroll until view map is visible
	public void scrolluntil_viewmap_visible() {
		waitForFindElementPresent(viewmap);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", viewmap);
	}
	
	 //click on view map
		public void click_view_map() {
			waitForFindElementPresent(viewmap);
			viewmap.click();
		}
		
		//wait for map to load
		public void waituntil_maploads() {
			waitForFindElementPresent(plussign);
		}
		
		//click on plus sign
		public void click_plussign() {
			waitForFindElementPresent(plussign);
			plussign.click();
		}

	
	
 
	

}
