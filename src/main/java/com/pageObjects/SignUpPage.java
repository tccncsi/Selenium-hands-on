package com.pageObjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.base.BasePage;
import com.utilities.XLUtils;


public class SignUpPage extends BasePage{

	public SignUpPage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	}
	
	int noOfRecords;
	
	@FindBy(xpath = "//input[@name='q3_fullName[first]']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='q3_fullName[last]']")
	WebElement LastName;
	
	
	@FindBy(xpath = "//input[@name='q8_age']")
	WebElement Age;

	@FindBy(xpath = "//input[@placeholder = 'mm-dd-yyyy']")
	WebElement Date;

	@FindBy(xpath = "//select[@name='q10_gender']")
	WebElement Gender;

	@FindBy(xpath = "//input[@name='q4_email']")
	WebElement Email;

	@FindBy(xpath = "//input[@id='input_6_full']")
	WebElement PhoneNumber;

	@FindBy(xpath = "//input[@id='input_9_addr_line1']")
	WebElement Address;

	@FindBy(xpath = "//input[@id='input_9_postal']")
	WebElement PostalCode;

	@FindBy(xpath = "//select[@id='input_9_country']")
	WebElement Country;

	@FindBy(xpath = "//input[@id='input_9_city']")
	WebElement City;

	
	@FindBy(xpath = "//select[@id='input_20']")
	WebElement MethodOfPayment;

	@FindBy(xpath = "(//*[contains(text(),'Quantity')])[1]/parent::span/select")
	WebElement RegQuantity;
	
	@FindBy(xpath = "(//*[contains(text(),'Quantity')])[2]/parent::span/select")
	WebElement ShirtQuantity;
	
	@FindBy(xpath = "//span[@id='payment_total']")
	WebElement TotalAmt;
	
	@FindBy(xpath = "//input[@id='lite_mode_25']")
	WebElement Date2;
	
	@FindBy(xpath = "//select[@id='hour_25']")
	WebElement Hour;
	
	@FindBy(xpath = "//select[@id='min_25']")
	WebElement Minute;
	
	@FindBy(xpath = "//textarea[@id='input_60']")
	WebElement Description;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;
	
	@FindBy(xpath = "//*[contains(text(),' T-Shirt Size ')]/parent::li/div/div/span/label")
	WebElement Tshirtsizes;
	
	@FindBy(xpath = "//input[@id='first_13']")
	WebElement EmergencyFirstName;
	
	@FindBy(xpath = "//input[@id='last_13']")
	WebElement EmergencyLastName;
	
	@FindBy(xpath= "//input[@id='input_15_phone']")
	WebElement EmergencyPhoneNo;
	
	@FindBy(xpath= "//input[@id='input_15_area']")
	WebElement EmergencyAreaCode;
	
	@FindBy(xpath= "//input[@name='q16_relationship']")
	WebElement Relationship;

	
	
   public void enterName(String FName,String LName)
   {
	   waitForFindElementPresent(FirstName);
	   FirstName.sendKeys(FName);
	   
	   waitForFindElementPresent(LastName);
	   LastName.sendKeys(LName);
   }
   
   
   public void enterEmergencyName(String FName,String LName)
   {
	   waitForFindElementPresent(EmergencyFirstName);
	   EmergencyFirstName.sendKeys(FName);
	   
	   waitForFindElementPresent(EmergencyLastName);
	   EmergencyLastName.sendKeys(LName);
   }
   
   public void enterRelationship(String relationship)
   {
	   waitForFindElementPresent(Relationship);
	   Relationship.sendKeys(relationship);
   }
   
   public void enterEmergencyPhoneNo(String AreaCode,String PhoneNo)
   {
	   waitForFindElementPresent(EmergencyAreaCode);
	   EmergencyAreaCode.sendKeys(AreaCode);
	   
	   waitForFindElementPresent(EmergencyPhoneNo);
	   EmergencyPhoneNo.sendKeys(PhoneNo);
   }
   
   public void enterAge(String age) throws IOException
   {
	   waitForFindElementPresent(Age);
	   Age.sendKeys(age);
   }
   
	public void enterDate(String date)
	{
		waitForFindElementPresent(Date);
		Date.sendKeys(date);
	}
	
	public void enterGender(String gender)
	{
		waitForFindElementPresent(Gender);
		Select select = new Select(Gender);
		select.selectByVisibleText(gender);
	}
	
	public void enterEmail(String email)
	{
		waitForFindElementPresent(Email);
		Email.sendKeys(email);
	}
	
	public void enterPhoneNo(String PhoneNo)
	{
		waitForFindElementPresent(PhoneNumber);
		PhoneNumber.sendKeys(PhoneNo);
	}
	
	public void enterAddress(String address)
	{
		waitForFindElementPresent(Address);
		Address.sendKeys(address);
	}
	
	public void enterCity(String city)
	{
		waitForFindElementPresent(City);
		City.sendKeys(city);
	}
	
	public void enterPostalCode(String postalcode)
	{
		waitForFindElementPresent(PostalCode);
		PostalCode.sendKeys(postalcode);
	}
	
	public void enterCountry(String country)
	{
		waitForFindElementPresent(Country);
		Select select = new Select(Country);
		select.selectByValue(country);
	}
	
	public void enterTshirtSize(String tshirtsize)
	{
		List<WebElement> lists = driver.findElements(By.xpath("//*[contains(text(),' T-Shirt Size ')]/parent::li/div/div/span/label"));
		for(WebElement e : lists)
		{
			if(e.getText().equalsIgnoreCase(tshirtsize))
			{
				e.click();
				break;
			}
		}
		
	}
	
	public void enterTime(String time,String date) throws NumberFormatException, IOException
	{
		waitForFindElementPresent(Date2);
		Date2.sendKeys(date);
		String zero = Integer.toString(0);
		
		System.out.println("time is "+time);
		String[] lists = time.split(":");
		char c = lists[0].charAt(0);
		
		if(Character.toString(c).equalsIgnoreCase(zero))
		{
			char a = lists[0].charAt(1);
			waitForFindElementPresent(Hour);
			Select S = new Select(Hour);
			S.selectByValue(Character.toString(a));
		}
		else
		{
			waitForFindElementPresent(Hour);
			Select S = new Select(Hour);
			System.out.println(lists[0]);
			S.selectByValue(lists[0]);
		}
			
		
		int flag = 0;
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("recordNo"));
		
		String TshirtSize = XLUtils.FetchExcelData("Min");
		String[] TshirtSizes = TshirtSize.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String TS : TshirtSizes)
				if (flag != noOfRecords) {
					System.out.println(TS);
					waitForFindElementPresent(Minute);
					Select S = new Select(Minute);
					System.out.println(TS);
					S.selectByValue(TS);
					flag++;
				} else {
					break;
				}

		}
		
	}
	
	public void enterDescription(String description)
	{
		waitForFindElementPresent(Description);
		Description.sendKeys(description);
	}
	
	public void enterPaymentMethod(String paymentmethod)
	{
		waitForFindElementPresent(MethodOfPayment);
		Select select = new Select(MethodOfPayment);
		select.selectByValue(paymentmethod);
	}
	
	public void enterQuantity(String quantity)
	{
		waitForFindElementPresent(RegQuantity);
		RegQuantity.sendKeys(quantity);
		
		waitForFindElementPresent(ShirtQuantity);
		ShirtQuantity.sendKeys(quantity);
		
		waitForFindElementPresent(TotalAmt);
		System.out.println(TotalAmt.getText() +" is the total amount");
	}
	

	
}
