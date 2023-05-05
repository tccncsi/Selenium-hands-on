package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class EmployeeFormEnterPage extends BasePage
{

	public EmployeeFormEnterPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='relative']/div/div")
	WebElement Title;
	
	@FindBy(xpath = "//ul[@role='listbox']/li")
	WebElement TitleList;
	
	@FindBy(xpath = "//input[@name='first-name']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='last-name']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='field-5']")
	WebElement Birthdate;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement CellPhone;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@name='address-line-1']")
	WebElement StreetAddress;

	@FindBy(xpath = "//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath = "//input[@name='zip']")
	WebElement ZipCode;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement Continue;
	
	@FindBy(xpath = "(//button[@type='button']/span)[2]")
	WebElement ContinueBtn;
	
	@FindBy(xpath = "//input[@placeholder='IT Engineer']")
	WebElement PositionDivision;
	
	@FindBy(xpath = "//input[@name='date']")
	WebElement DateofHire;
	
	@FindBy(xpath = "//*[local-name()='svg' and @viewBox='0 0 16 16']")
	WebElement WorkCode;
	
	@FindBy(xpath = "//input[@name='first-name']")
	WebElement EmergencyFirstName;
	
	@FindBy(xpath = "//input[@name='last-name']")
	WebElement EmergencyLastName;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement EmergencyPhoneNo;
	
	@FindBy(xpath = "//input[@id='field-18']")
	WebElement Relationship;
	
	@FindBy(xpath = "//textarea[@id='field-19']")
	WebElement MedicalInfo;
	
	@FindBy(xpath = "//input[@id='field-23']")
	WebElement Languages;
	
	@FindBy(xpath = "(//*[local-name()='svg' and @viewBox='0 0 448 512'])[1]")
	WebElement MartialStatus;
	
	@FindBy(xpath = "//*[@id=\"aidaform\"]/main/form/div[1]/div[2]/div/div[2]/div[2]/button/span")
	WebElement Submit;
	
	@FindBy(xpath= "//div[@id='aidaform']/main/div/div/following-sibling::h1")
	WebElement success;
	
	
	public void selectTitle(String title)
	{
		waitForFindElementPresent(Title);
		Title.click();
		//driver.findElement(By.xpath("//ul[@id='lb3qggsenu8dj']/li[2]")).click();
		List<WebElement> l = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getText().equalsIgnoreCase(title))
			{
				l.get(i).click();
				break;
			}
		}
	}
	
	
	public void enterFirstName(String fname)
	{
		waitForFindElementPresent(FirstName);
		FirstName.clear();
		FirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname)
	{
		waitForFindElementPresent(LastName);
		LastName.clear();
		LastName.sendKeys(lname);
	}
	
	public void enterBirthDate()
	{
		waitForFindElementPresent(Birthdate);
		Birthdate.clear();
		Birthdate.sendKeys("10");
		Birthdate.sendKeys("11");
		Birthdate.sendKeys("1990");
	}
	
	public void enterPhoneNo(String phoneno)
	{
		waitForFindElementPresent(CellPhone);
		CellPhone.clear();
		CellPhone.sendKeys(phoneno);
	}
	
	public void enterEmail(String email)
	{
		waitForFindElementPresent(Email);
		Email.clear();
		Email.sendKeys(email);
	}
	
	public void enterAddress(String street,String city,String postalcode)
	{
		waitForFindElementPresent(StreetAddress);
		StreetAddress.clear();
		StreetAddress.sendKeys(street);
		
		waitForFindElementPresent(City);
		City.clear();
		City.sendKeys(city);
		
		waitForFindElementPresent(ZipCode);
		ZipCode.clear();
		ZipCode.sendKeys(postalcode);
	}
	
	public void clickContinue()
	{
		waitForFindElementPresent(Continue);
		Continue.click();
	}
	
	public void enterPositionDivision(String position)
	{
		waitForFindElementPresent(PositionDivision);
		PositionDivision.clear();
		PositionDivision.sendKeys(position);
		
	}
	
	public void enterDateOfHire()
	{
		waitForFindElementPresent(DateofHire);
		DateofHire.clear();
		DateofHire.sendKeys("01");
		DateofHire.sendKeys("01");
		DateofHire.sendKeys("2023");
	}
	
	public void selectWorkCode(String workcode)
	{
		waitForFindElementPresent(WorkCode);
		List<WebElement> l = driver.findElements(By.xpath("//*[local-name()='svg' and @viewBox='0 0 16 16']"));
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='-mt-1']"));
		for(int i=0;i<li.size();i++)
		{
			if(li.get(i).getText().equalsIgnoreCase(workcode))
			{
				l.get(i).click();
				break;
			}
		}
	}
	
	public void enterEmergencyDetails(String fname,String lname,String phoneno,String relationship)
	{
		waitForFindElementPresent(EmergencyFirstName);
		EmergencyFirstName.clear();
		EmergencyFirstName.sendKeys(fname);
		
		waitForFindElementPresent(EmergencyLastName);
		EmergencyLastName.clear();
		EmergencyLastName.sendKeys(lname);
		
		waitForFindElementPresent(EmergencyPhoneNo);
		EmergencyPhoneNo.clear();
		EmergencyPhoneNo.sendKeys(phoneno);
		
		waitForFindElementPresent(Relationship);
		Relationship.clear();
		Relationship.sendKeys(relationship);
		
	}
	
	public void enterMedicalInfo(String medicalinfo)
	{
		waitForFindElementPresent(MedicalInfo);
		MedicalInfo.clear();
		MedicalInfo.sendKeys(medicalinfo);

	}
	
	public void clickContinueBtn()
	{
		waitForFindElementPresent(ContinueBtn);
		ContinueBtn.click();
	}
	
	public void enterLanguage(String language)
	{
		waitForFindElementPresent(Languages);
		Languages.clear();
		Languages.sendKeys(language);
	}
	
	public void selectMartialStatus(String martialstatus)
	{
		waitForFindElementPresent(MartialStatus);
		MartialStatus.click();
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='flex w-full']/following-sibling::ul/li"));
		System.out.println(li.size());
		for(int i=0;i<li.size();i++)
		{
			System.out.println(li.get(i).getText());
			
			if(li.get(i).getText().equalsIgnoreCase(martialstatus))
			{
				li.get(i).click();
				break;
			}
		}
	}
	
	public void clickSubmit() throws InterruptedException
	{
		waitForFindElementPresent(Submit);
		Submit.click();
		Thread.sleep(2000);
		waitForFindElementPresent(success);
		Assert.assertEquals(success.getText(), "Success! We've received your submission");
	}
	
}
