package com.pageObjects;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class modifySearchPage extends BasePage {

	public modifySearchPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "  //input[@name ='search']")
	WebElement Search_txtbox;

	@FindBy(xpath = "//button[@name='from']//div")
	WebElement Checkin;

	@FindBy(id = "prefix__up-chevron")
	WebElement Checkout;

	@FindBy(xpath = "//button[@name='to']//div")
	WebElement Checkoutdate;

	@FindBy(xpath = "//button[@name=\"travellers\"]//div")
	WebElement traveller_box;

	@FindBy(id = "prefix__hotels")
	WebElement Hotel_Logo;

	// Hotels guest house checkbox
	@FindBy(xpath = "(//div[@class=\"flex flex-start p-relative flex-middle\"])[26]")
	WebElement guestHouse;

	@FindBy(xpath = "(//div[@class=\"flex flex-start p-relative flex-middle\"])[27]")
	WebElement Apartment;

	//  property - appartment get data
	@FindBy(xpath = "(//span[@class='fs-2 c-neutral-400'])[29]")
	WebElement appartment_data;

	// viewing 5star hotel count
	@FindBy(xpath = "//span[@class=\"fw-600\"]")
	WebElement get5starhotelcount;

	// click on hotel with deals check box
	@FindBy(xpath = "//span[@class=\"checkbox__mark bs-border bc-neutral-500 bw-1 ba\"]")
	WebElement hoteldeal;

	// element on footerpage
	@FindBy(xpath = "//a[contains(text(),\"Gift Cards\")]")
	WebElement giftcard;

	@FindAll({ @FindBy(xpath = "//button[contains(text(),'View details')]") })
	List<WebElement> viewDetails;

	public int hotelDetailsCount() {
		System.out.println(viewDetails.size());
		return viewDetails.size();
	}

	public String search_txtbox() { // search textbox assertion

		return Search_txtbox.getText();
	}

	public String getcheckin_date() {
		waitForFindElementPresent(Checkin);
		return Checkin.getText();
	}

	public String getCheckout_date() {
		return Checkoutdate.getText();
	}

	public String adult_child_data() {
		return traveller_box.getText();
	}

	public void guesthouse() {
		waitForFindElementPresent(guestHouse);
		guestHouse.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String appartment_getdata() {
		waitForFindElementPresent(appartment_data);
		System.out.println(appartment_data.getText());
		return appartment_data.getText();
	}
	
	public String guesthouse_getdata() {
		waitForFindElementPresent(guestHouse);
		System.out.println(guestHouse.getText());
		return guestHouse.getText();
		
	}

	public String fivestar_hotelcount() {
		waitForFindElementPresent(get5starhotelcount);
		System.out.println(get5starhotelcount.getText());
		return get5starhotelcount.getText();
	}

	public void waitForResult() {
		waitForFindElementPresent(get5starhotelcount);
	}

	public void hoteldeals() {
		waitForFindElementPresent(hoteldeal);
		hoteldeal.click();
	}

	public void giftcards() {
		waitForFindElementPresent(Apartment);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Apartment);
	}

}
