package com.pageObjects.AMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.utilities.XLUtils;

public class CommonPage extends BasePage {

	// Functoion to call the driver
	public CommonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Print Testcase name
	public void TestCaseName(String EnterTestCaseName) {
		System.out.println("\nInside " + EnterTestCaseName + "\n------------------------------------------------");
	}

	// Print the message
	public void Print(String UserInput) {
		System.out.println(UserInput);
	}

	// Get Page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Get Page URL
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	// Get Page Source
	public String getCurrentPageSource() {
		driver.getPageSource();
		return driver.getPageSource();
	}

	public String FromExcel(String data) throws IOException {
		String ExcelCellData = XLUtils.FetchExcelData(data);
		return ExcelCellData;
	}
}
