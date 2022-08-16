package com.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LandingClearTripPage extends BasePage {

	public LandingClearTripPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[name()='svg'][@class=' c-pointer c-neutral-900'])[1]") // popup close
	WebElement Popup;

	/*
	 * public void dynamic_popup() { try { Alert alert = driver.switchTo().alert();
	 * alert.dismiss(); } catch (NoAlertPresentException ne) {
	 * System.out.println("Alert not displayed"); // ne.printStackTrace(); } }
	 */

	@FindBy(xpath = "//h1") // heading "search hotel"
	WebElement Heading;

	@FindBy(xpath = "//span[@class=\"td-none c-neutral-400 hover:c-secondary-500 flex flex-middle c-pointer p-2 br-4 hover:bg-neutral-0 mr-6\"] ")
	WebElement supportlabel;

	@FindBy(name = "description") // title
	WebElement title;

	@FindBy(xpath = "//label[contains(text(),\"Where to?\")]") // where to label assertion
	WebElement whereto_label;

	@FindBy(xpath = "//label[contains(text(),\"Check-in\")]") // checkin label assertion
	WebElement checkinlabel;

	@FindBy(xpath = "//label[contains(text(),\"Check-out\")]")
	WebElement checkoutlabel;

	@FindBy(xpath = "//label[contains(text(),\"Travellers\")]")
	WebElement travellerlabel;

	@FindBy(name = "search") // click on where to text box
	WebElement Click_on_textbox;

	@FindBy(xpath = "(//*[@class=\"to-ellipsis o-hidden ws-nowrap c-inherit fs-3\"])[5]") // Click on suggestion list
																							// having Chennai
	WebElement click_on_list;

	@FindBy(name = "search") // enter data in where to? textbox
	WebElement Enter_Locality;

	@FindBy(xpath = "//button[@name='from']") // checkin date arrow
	WebElement Checkin_Arrow;

	@FindBy(xpath = "//div[@class='DayPicker-Caption']//div") // gettext august 2022
	WebElement currentmonth;

	@FindBy(xpath = "//div[@class='DayPicker-wrapper']//div[2]//*[local-name()='svg']") // rightside forward arrow for
																						// checkin
	WebElement arrow;

	public String getmonth() {
		waitForFindElementPresent(currentmonth);
		System.out.println(currentmonth.getText());
		return currentmonth.getText();
	}

	public void calender(String month, String date) {
		System.out.println(month);
		System.out.println(date);
		while (true) {
			if (getmonth().equals(month)) {
				break;

			} else {
				waitForFindElementPresent(arrow);
				arrow.click();
			}

		}
		driver.findElement(By.xpath("//div[@aria-label='" + date + "']")).click();
	}

	@FindBy(xpath = "//div[@class='DayPicker-Caption']//div") // get November 2022
	WebElement checkin_month;

	public String getcheckout_month() {
		waitForFindElementPresent(checkin_month);
		System.out.println(checkin_month.getText());
		return checkin_month.getText();
	}

	public void checkout_calender(String checkout_month, String dates) {
		while (true) {
			if (getcheckout_month().equals(checkout_month)) {
				break;
			} else {
				arrow.click();
			}
		}

		driver.findElement(By.xpath("//div[@aria-label='" + dates + "']")).click();
	}

	public void closePopup() {
		try {
			waitForFindElementPresent(Popup); // popup close method
			Popup.click();
		} catch (NoSuchElementException e) {
			System.out.println("No Popup");
		}
	}

	public String whereto_label() {
		return whereto_label.getText();
	}

	public String checkin_label() {
		return checkinlabel.getText();
	}

	public String checkout_label() {
		return checkoutlabel.getText();
	}

	public String GetHeading() {
		waitForFindElementPresent(Heading); // get heading for assertion
		return Heading.getText();
	}

	public String GetTitle() {
		return title.getText();
	}

	public String GetSupport() {
		return supportlabel.getText();
	}

	@FindBy(xpath = "//*[@class=\"c-pointer c-secondary-500\"]") // next month click arrow check in
	WebElement Checkin_nxt_arrow;

	@FindBy(xpath = "(//div[@class=\"Day-grid flex flex-middle flex-column flex-center\"])[9]") // checkin date picker
	WebElement Checkin_Date;

	@FindBy(xpath = "(//div[@class=\"p-1 day-gridContent flex flex-middle flex-column flex-center Round-trip\"])[16]") // date
																														// for
																														// invalid
																														// location
	WebElement Checkin_for_invalid_scenario;

	public void setdate() {
		Checkin_for_invalid_scenario.click();
	}

	@FindBy(xpath = "//button[@name=\"from\"]") // checkin date box
	WebElement Checkin_box;

	@FindBy(xpath = "//button[@name='to']")
	WebElement Checkout_box;

	@FindBy(xpath = "//*[@class=\"c-pointer c-secondary-500\"]") //
	WebElement Checkout_nxt_arrow;

	@FindBy(id = "prefix__down-chevron") // arrow for checkout date
	WebElement Checkout_Arrow;

	@FindBy(xpath = "(//div[@class=\"p-1 day-gridContent flex flex-middle flex-column flex-center Round-trip\"])[14]") // date
																														// for
																														// checkout
	WebElement Checkout_Date;

	@FindBy(name = "travellers") // click on the travellers box
	WebElement travellerbxarrow;

	@FindBy(xpath = "//button[@name='travellers']") // travellers text box
	WebElement travellerbox;

	//click on 2 room 4 adult from dropdownlist
	@FindBy(xpath = "(//*[@class=\"ls-reset br-4 w-100p fs-inherit px-2 dropdown__item  hover:bg-secondary-500 hover:c-white c-pointer c-neutral-900\"])[3]") 
	WebElement travellerlist;

	@FindBy(xpath = "//*[contains ( text() , 'Add more rooms and travellers')]") // link in traveller dropdown
	WebElement linkintraveller;

	@FindBy(xpath = "//*[@class=\"fs-2 c-pointer c-secondary-500 hover:td-underline\"]")
	WebElement show_opt;

	@FindBy(xpath = "//*[contains(text(),\"Search Hotels\")]") // search btn
	WebElement SearchHotel_Btn;

	@FindBy(xpath = "(//*[@class=\"current-stroke c-blue c-pointer\"])[2]") // increment button for adults
	WebElement increment_btn;

	@FindBy(xpath = "//*[@class=\"current-stroke c-blue c-pointer\"]") // adult decrement
	WebElement decrement_adult;

	@FindBy(xpath = "//*[@class=\"current-stroke c-grey-20 c-not-allowed\"]") // child increment
	WebElement increment_child;

	@FindBy(xpath = "(//*[@class=\"current-stroke c-blue c-pointer\"])[3]") // child decrement
	WebElement decrement_child;
	
	//less than arrow for child
	@FindBy(xpath = "//select[@class=\"select focus:bc-secondary-500 bw-1 bs-solid w-100p br-4 fs-2 c-pointer c-neutral-900 h-9 fs-3 bc-neutral-100 c-neutral-400\"]") 
	WebElement lessthanarrow;

	@FindBy(xpath = "//*[@class=\"pt-2\"]") // add room
	WebElement addroom;

	@FindBy(xpath = "(//*[@class=\"current-stroke c-blue c-pointer\"])[5]") // add room adult increment
	WebElement addroom_incr;

	@FindBy(xpath = "//span[@class=\"fs-2 c-secondary-500 hover:td-underline c-pointer\"]")
	WebElement delete_btn;
	 
	//click on "Continue with Email"
	@FindBy(xpath="//span[contains(text(),\"Continue with Email\")]")
	WebElement click_on_email;
	
	public void clickontextbox() {
		waitForFindElementPresent(Click_on_textbox);
		Click_on_textbox.click();
	}

	public void clickonlist() {
		waitForFindElementPresent(click_on_list);
		click_on_list.click();
	}

	public void setLocality(String place) {

		Enter_Locality.sendKeys(place);
	}

	public void checkin_arrow() {
		waitForFindElementPresent(Checkin_Arrow);
		Checkin_Arrow.click();
	}

	public void checkinarrow() {
		Checkin_nxt_arrow.click();
	}

	public void checkindate() {
		waitForFindElementPresent(Checkin_Date);
		Checkin_Date.click();
	}

	public String checkinbox() {
		waitForFindElementPresent(Checkin_box);
		return Checkin_box.getText();
	}

	public void checkoutarrow() {
		Checkout_nxt_arrow.click();
	}

	public void checkout_arrow() {
		Checkout_Arrow.click();
	}

	public void checkoutdate() {
		Checkout_Date.click();
	}

	public String Checkoutbox() {
		waitForFindElementPresent(Checkout_box);
		return Checkout_box.getText();
	}

	public String traveller_box() {
		waitForFindElementPresent(travellerbox);
		return travellerbox.getText();
	}

	public void travellerarrow() {
		travellerbxarrow.click();
	}

	public void travellerlist() {
		travellerlist.click();

	}

	public void link_travelleR_box() {
		linkintraveller.click();
	}

	public void showopt() {
		show_opt.click();
	}

	public void incrementbtn() {
		increment_btn.click();
	}

	public void decrementadult() {
		decrement_adult.click();
	}

	public void incrementchild() {
		increment_child.click();
	}

	public void decrementchild() {
		decrement_child.click();
	}

	public void add_room() {
		addroom.click();
	}

	public void less_than_arr() {
		lessthanarrow.click();
	}

	public void add_room_incradult() {
		addroom_incr.click();
	}

	public void delete_btn() {
		delete_btn.click();
	}
	
	public void click_on_email() {
		click_on_email.click();
	}

	public void Search_btn() {
		SearchHotel_Btn.click();

	}
	
	

}
