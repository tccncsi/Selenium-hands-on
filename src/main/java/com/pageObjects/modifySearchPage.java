package com.pageObjects;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
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
	
	//add room
	@FindBy(xpath="//span[contains(text(),\"Add room\")]")
	WebElement addroom;

	@FindBy(id = "prefix__hotels")
	WebElement Hotel_Logo;

	// Hotels guest house checkbox
	@FindBy(xpath = "(//div[@class=\"flex flex-start p-relative flex-middle\"])[26]")
	WebElement guestHouse;

	@FindBy(xpath = "(//div[@class=\"flex flex-start p-relative flex-middle\"])[29]")
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
	
	
	// see more link for property type filter
	@FindBy(xpath="(//div[contains(text(),'See more')])[2]")
	WebElement seemore_property;
	
	
	//get text for guest house
	@FindBy(xpath="(//div[@class=\"flex flex-middle flex-between flex-1\"])[26]//span")
	WebElement gettext;
	
	//clear all link 
	@FindBy(xpath="//div[contains(text(),'Clear all')]")
	WebElement clearall;
	
	// see more link for Amenities
	@FindBy(xpath="//div[contains(text(),\"See more\")]")
	WebElement seemoreamenities;
	
	//bar filter in amenities
	@FindBy(xpath="(//div[@class=\"flex flex-start p-relative flex-middle\"])[23]")
	WebElement bar;
	
	
	//bar get data
	@FindBy(xpath="(//span[contains(text(),32)])[2]")
	WebElement getdatabar;

	
	//get text Turyaa chennai
	@FindBy (xpath="//h2")
	WebElement turyachennai;
	
	
	//get loaction of turya hotel
	@FindBy(xpath="(//p[contains(text(),'Omr Road')])[1]")
	WebElement turya_location;
	
	//click on view details
	@FindBy(xpath="(//button[contains(text(),\"View details\")])[1]")
	WebElement view_details_turyaa;
	
	
	//next page (after view details) turya get text
	@FindBy(xpath="//div[@class=\"flex flex-middle flex-between\"]//h2")
	WebElement nexttruya;
	
	
	@FindBy(xpath="//p[@class=\"p-2 fs-3 c-secondary-500 hover:td-underline c-pointer\"]")
	WebElement addroomlink;
	
	//wait for Quick select in traveller box
	@FindBy (xpath="//p[@class=\"fs-2 c-neutral-400 p-2\"]")
	WebElement quickselect;
	
	//click on plus sign adults
	@FindBy(xpath="(//li[@class=\"flex-inline\"])[6]")
	WebElement plussign;
	
	//click on view details button
	@FindBy(xpath="//button[contains(text(),\"View details\")]")
	WebElement viewdetails;
	
	//modify search button
	@FindBy(xpath="//button[contains(text(),\"Modify search\")]")
	WebElement modifysearch;
	

	
	
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

	public void click_ontravellerbox() {
		waitForFindElementPresent(traveller_box);
		traveller_box.click();
		
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
	
	public int guesthouse_getdata() {
		waitForFindElementPresent(gettext);
		System.out.println(gettext.getText());
		return Integer.parseInt(gettext.getText());
		
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

	//scrolluntil guest house is visible
	public void guesthouse_visible() {
		waitForFindElementPresent( guestHouse);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", guestHouse);
	}

	public void seemoreproperty_visible() {
		waitForFindElementPresent( seemore_property);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", seemore_property);
		
	}
	
	public void scrollupto_bottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void clear_all() {
		waitForFindElementPresent(clearall);
				
		}
	
	public void seemore_amenities() {
		waitForFindElementPresent(seemoreamenities);
		seemoreamenities.click();
	}
	
	public void baar() {
		waitForFindElementPresent(bar);
		bar.click();
	}
	
	public int getdata_bar() {
		waitForFindElementPresent(getdatabar);
		System.out.println(getdatabar.getText());
		return Integer.parseInt(getdatabar.getText());
	}
	
	
	//gettext for Turya chennai
	public String get_turyaachennai() {
		waitForFindElementPresent(turyachennai);
		System.out.println(turyachennai.getText());
		return turyachennai.getText();
	}
	
	
	//get turya location
	public String get_turyaloc() {
		waitForFindElementPresent(turya_location);
		System.out.println(turya_location.getText());
		return turya_location.getText();
	}
	

	//price for turya hotel


 
   public void RemoveCharString(){
 
	String str = driver.findElement(By.xpath("//div[@class=\"mt-2 mb-1\"]//span")).getText();
 
//String result = str.substring(0, index) + str.substring(index+1);
 
  String result = str.substring(0, 0) + str.substring(0+1);
   System.out.println(result);
   
   result = result.replaceAll(",","");
		   System.out.println(result);
		   
 
}
   
   public void get_price_turrya() {
	 String price = driver.findElement(By.xpath("//div[@class=\"mt-2 mb-1\"]//span ")).getText();
	 String oldprice = price.substring(0, 0)+ price.substring(0+1);
	 System.out.println(oldprice);
	 oldprice  = oldprice.replaceAll(",", "");
	 System.out.println(oldprice);
//	 Integer.parseInt(oldprice);
	 

	   String room = driver.findElement(By.xpath("//button[@name=\"travellers\"]//div")).getText();
	   char counts = room.charAt(0);
	   System.out.println(counts);
	   int count =Integer.parseInt(String.valueOf(counts)); 
	   System.out.println(count);
	 int newprice = Integer.parseInt(oldprice) * count;
	 System.out.println(newprice);
			 
   }
   
   
   //separate 2 from traveler data
   public void number_of_rooms()
   {
	   String room = driver.findElement(By.xpath("//button[@name=\"travellers\"]//div")).getText();
	   char count = room.charAt(0);
	   
//	   String count = room.substring(0, 0)+ room.substring(0+1);
	 
	   System.out.println(count);
	   
   }

   public void viewdetailsturyaa() {
	   waitForFindElementPresent(view_details_turyaa);
	   view_details_turyaa.click();
   }
   
   public String get_turya_nextpage() {
	   waitForFindElementPresent(nexttruya);
	  System.out.println(nexttruya.getText());
	  return nexttruya.getText();
	  }
   
   public void remove_chennai() {
	   String str1 = driver.findElement(By.xpath("//span[contains(text(),\"Omr Road, Chennai\")]")).getText();
	   String[] str2 = str1.split(",");
	   System.out.println(str2[0]);
   }
   
   //wait for text to be visible
   public void waitfortext() {
	   waitForFindElementPresent(nexttruya);
   }
   
   //add room from drop down
   public void addroom_link() {
	   waitForFindElementPresent(addroom);
	  addroom.click();
   }
   
   //click on add more rooms and travellers 
   public void clickon_addroomlink() {
	   waitForFindElementPresent(addroomlink);
	   addroomlink.click();
   }
   
   //wait for quick select to be visible (traveller box)
   public void quick_select() {
	   waitForFindElementPresent(quickselect);

   }
   
   //modify search btn
   public void modifysrach_btn() {
	   waitForFindElementPresent(modifysearch);
	   modifysearch.click();
   }
   
   //plus sign adults
   public void plussign_adults() {
	   waitForFindElementPresent(plussign);
	   plussign.click();
   }
   
   //click on view details btn
   public void viewdetails_btn() {
	   waitForFindElementPresent(viewdetails);
	   viewdetails.click();
	   
   }
   
  
}

