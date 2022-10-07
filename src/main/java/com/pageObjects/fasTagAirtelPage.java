package com.pageObjects;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.utilities.XLUtils;

public class fasTagAirtelPage extends BasePage {

	public fasTagAirtelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'NETC FASTag')]")
	WebElement fastag;

	@FindBy(xpath = "//div[@class='upload-rc']")
	WebElement insertfrontimage;
	
	@FindBy(xpath="(//div[@class='upload-rc'])[2]")
	WebElement backsideimage;

	// click on FasTag
	public void clickonFastag() {
		waitForFindElementPresent(fastag);
		fastag.click();
	}

	// click on first image
	public void clickfirstimg() {
		waitForFindElementPresent(insertfrontimage);
		insertfrontimage.click();
	}

	// insert first image
	public void firstimg() {
		driver.switchTo().activeElement().sendKeys("C:\\Users\\P1345360\\Pictures\\Screenshots\\frontimage.jpg");
//		try {
//			driver.switchTo().activeElement().sendKeys(XLUtils.fetchExcelData("backimage"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 ((RemoteWebDriver) driver.switchTo().activeElement()).getKeyboard().pressKey(Keys.CANCEL);
		((RemoteWebDriver)driver).getKeyboard().pressKey(Keys.CANCEL);
	
//		WebElement chooseFile = driver.findElement(By.xpath("(//input[@capture='filesystem'])[1]"));
//		chooseFile.sendKeys("C:\\Users\\P1345360\\Pictures\\Screenshots\\navaratri.png");
	}
	
	public void clickbackimg() {
		waitForFindElementPresent(backsideimage);
		backsideimage.click();
	}
}


