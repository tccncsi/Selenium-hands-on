package com.advancedselenium.net_a_porter_website.pageobject;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advance_selenium.net_a_porter_website.base.BasePage;
import com.advance_selenium.net_a_porter_website.utilities.XLUtils;

public class PHPTraveleersHomePage extends BasePage {

	public PHPTraveleersHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Making object for XLUtils.
	XLUtils xlutil = new XLUtils();

	//Different Locators 
	@FindBy(css = "#menu > div.nav_right > ul > li:nth-child(2) > a")
	WebElement signup_btn;

	@FindBy(css = "#inputFirstName")
	WebElement first_name_field;

	@FindBy(css = "#inputLastName")
	WebElement last_name_field;

	@FindBy(css = "#inputEmail")
	WebElement email_field;

	@FindBy(css = " div.iti-arrow")
	WebElement dropdown_arrow;

	@FindBy(xpath = "//div[4]/div/div/div/ul/li[@data-dial-code='91']")
	WebElement india_code;

	@FindBy(css = "#inputPhone")
	WebElement phone_num_field;

	@FindBy(css = "#inputCompanyName")
	WebElement company_name_field;

	@FindBy(css = "#inputAddress1")
	WebElement company_address_field;

	@FindBy(css = "#inputCity")
	WebElement company_city_field;

	@FindBy(css = "#stateinput")
	WebElement company_state_field;

	@FindBy(css = "#inputPostcode")
	WebElement company_postcode_field;

	@FindBy(css = "#customfield2")
	WebElement additional_phone_field;

	@FindBy(css = "#containerPassword > div:nth-child(4) > div > button")
	WebElement generate_password_btn;

	@FindBy(css = "#inputGeneratePasswordLength")
	WebElement generated_password_length_field;

	@FindBy(css = "#inputGeneratePasswordOutput")
	WebElement generated_password_field;

	@FindBy(css = "#modalGeneratePassword > div > div > div.modal-body > div:nth-child(4) > div > button:nth-child(1)")
	WebElement modal_generate_password_btn;

	@FindBy(css = "#btnGeneratePasswordInsert")
	WebElement entering_generated_password;

	@FindBy(css = "#modalGeneratePassword > div > div > div.modal-footer > button.btn.btn-default")
	WebElement generate_password_close_btn;

	@FindBy(css = "#frmCheckout > p > input")
	WebElement register_btn;

	@FindBy(css = "div.col-lg-8.col-xl-9.primary-content > div.alert.alert-danger")
	WebElement error_dialog_box;

	@FindBy(css = "#main-body > div > div.row > div.col-lg-8.col-xl-9.primary-content > div.alert.alert-danger > strong")
	WebElement error_dialog_box_heading;

	@FindBy(css = "div.col-lg-8.col-xl-9.primary-content > div.alert.alert-danger > ul > li")
	WebElement error_msg;
	
	@FindBy(css="div > em")
	WebElement dashboard_name;

	
	
	public boolean signup_btn_displayed() {
		waitForFindElementPresent(signup_btn);
		return signup_btn.isDisplayed();
	}

	
	//Clicking on signup button and signup page opens in new tab
	//So shifting focus to new tab
	public void click_on_signup_btn() {
		waitForFindElementPresent(signup_btn);
		signup_btn.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String originalHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	
	
	//Successfully Fetching data from the excel sheet and 
	//Entering values in different fields of the registration page
	public void enteringtextinfields() throws IOException {
		
		waitForFindElementPresent(first_name_field);
		// System.out.println("excel result:" + XLUtils.FetchExcelData("FirstName"));
		first_name_field.sendKeys(XLUtils.FetchExcelData("FirstName"));
		waitForFindElementPresent(last_name_field);
		last_name_field.sendKeys(XLUtils.FetchExcelData("LastName"));
		waitForFindElementPresent(email_field);
		email_field.sendKeys(XLUtils.FetchExcelData("email"));
		waitForFindElementPresent(dropdown_arrow);
		dropdown_arrow.click();
		waitForFindElementPresent(india_code);
		india_code.click();
		waitForFindElementPresent(phone_num_field);
		phone_num_field.sendKeys(XLUtils.FetchExcelData("phoneNum1"));
		waitForFindElementPresent(company_name_field);
		company_name_field.sendKeys(XLUtils.FetchExcelData("CompanyName"));
		waitForFindElementPresent(company_address_field);
		company_address_field.sendKeys(XLUtils.FetchExcelData("CompanyAddress"));
		waitForFindElementPresent(company_city_field);
		company_city_field.sendKeys(XLUtils.FetchExcelData("CompanyCity"));
		waitForFindElementPresent(company_state_field);
		company_state_field.sendKeys(XLUtils.FetchExcelData("CompanyState"));
		waitForFindElementPresent(company_postcode_field);
		company_postcode_field.sendKeys(XLUtils.FetchExcelData("Postcode"));
		waitForFindElementPresent(additional_phone_field);
		additional_phone_field.sendKeys(XLUtils.FetchExcelData("PhoneNum2"));

	}

	
	//Generating password having 20 characters
	public void generating_password() throws InterruptedException {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("20");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);

		waitForFindElementPresent(entering_generated_password);
		entering_generated_password.click();

		Thread.sleep(30000);

		waitForFindElementPresent(register_btn);
		register_btn.click();
	}

	
	//Validating lengths for different generated password 
	public boolean validating_password_field_for_less_than_64() {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("63");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);
		if (len != 63) {
			waitForFindElementPresent(generate_password_close_btn);
			generate_password_close_btn.click();
			return false;
		}

		waitForFindElementPresent(generate_password_close_btn);
		generate_password_close_btn.click();
		return true;

	}

	public boolean validating_password_field_for_equal_to_64() {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("64");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);
		if (len != 64) {
			waitForFindElementPresent(generate_password_close_btn);
			generate_password_close_btn.click();
			return false;
		}

		waitForFindElementPresent(generate_password_close_btn);
		generate_password_close_btn.click();
		return true;

	}

	public boolean validating_password_field_for_graeter_than_64() {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("65");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);
		if (len != 65) {
			waitForFindElementPresent(generate_password_close_btn);
			generate_password_close_btn.click();
			return false;
		}

		waitForFindElementPresent(generate_password_close_btn);
		generate_password_close_btn.click();
		return true;

	}

	public boolean validating_password_field_for_less_than_8() {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("7");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);
		if (len != 7) {
			waitForFindElementPresent(generate_password_close_btn);
			generate_password_close_btn.click();
			return false;
		}

		waitForFindElementPresent(generate_password_close_btn);
		generate_password_close_btn.click();
		return true;

	}

	public boolean validating_password_field_for_equal_to_8() {
		waitForFindElementPresent(generate_password_btn);
		generate_password_btn.click();
		waitForFindElementPresent(generated_password_length_field);
		generated_password_length_field.sendKeys(Keys.CONTROL, "a");
		generated_password_length_field.sendKeys(Keys.DELETE);
		generated_password_length_field.sendKeys("8");
		waitForFindElementPresent(modal_generate_password_btn);
		modal_generate_password_btn.click();
		waitForFindElementPresent(generated_password_field);
		int len = generated_password_field.getAttribute("value").length();
		// System.out.println(len);
		if (len != 8) {
			waitForFindElementPresent(generate_password_close_btn);
			generate_password_close_btn.click();
			return false;
		}

		waitForFindElementPresent(generate_password_close_btn);
		generate_password_close_btn.click();
		return true;

	}
	
	public boolean error_msg_box_displayed() {
		waitForFindElementPresent(error_dialog_box);
		return error_dialog_box.isDisplayed();
	}
	
	public boolean error_msg_heading_displayed() {
		waitForFindElementPresent(error_dialog_box_heading);
		return error_dialog_box_heading.isDisplayed();
	}
	
	public boolean error_msg_displayed() {
		waitForFindElementPresent(error_msg);
		return error_msg.isDisplayed();
	}
	
	//getting the user's name from the dashboard after successful registration 
	public String dashboard_name() {
		waitForFindElementPresent(dashboard_name);
		return dashboard_name.getText();
	}
	
	
	

}
