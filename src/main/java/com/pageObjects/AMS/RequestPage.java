
package com.pageObjects.AMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.base.BasePage;
import com.utilities.XLUtils;

public class RequestPage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public RequestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// *************************************|Locators|****************************

	// Items Per Page dropdown on screen

	@FindBy(xpath = "//select[@class='sort']")
	WebElement ItemsPerPageDDLoc;

	// Search By textbox on screen

	@FindBy(xpath = "//div[@class='containers mt-5']//input[@id='search']")
	WebElement SearchByTextboxReqWindowLoc;

	// Rejected Button on screen

	@FindBy(xpath = "//button[contains(text(),'Rejected')]")
	WebElement RejectedBtnReqPageLoc;

	// Pending Button on screen

	@FindBy(xpath = "//button[contains(text(),'Pending')]")
	WebElement PendingBtnReqPageLoc;

	// Approved button on screen

	@FindBy(xpath = "//button[contains(text(),'Approved')]")
	WebElement ApprovedBtnReqPage;

	// All button on screen

	@FindBy(xpath = "//button[contains(text(),'All')]")
	WebElement AllBtnReqPage;

	// After Search first row

	@FindBy(xpath = "//tbody//tr[1]")
	WebElement FirstRowAfterSearchLoc;

	// First Row Elements

	@FindBy(xpath = "//tbody//tr//td[1]") // Asset Number
	WebElement FirstColLoc;

	@FindBy(xpath = "//tbody//tr//td[2]") // Request Type
	WebElement SecondColLoc;

	@FindBy(xpath = "//tbody//tr//td[3]") // RequestBy
	WebElement ThirdColLoc;

	@FindBy(xpath = "//tbody//tr//td[4]") // RequestDate
	WebElement ForthColLoc;

	@FindBy(xpath = "//tbody//tr//td[5]") // Remark
	WebElement FifthColLoc;

	@FindBy(xpath = "//tbody//tr//td[6]") // Status
	WebElement SixthColLoc;

	@FindBy(xpath = "//tbody//tr//td[7]") // Action
	WebElement SeventhColLoc;

	@FindBy(xpath = "//tbody//tr//td[8]") // Details
	WebElement EighthColLoc;

	@FindBy(xpath = "//tbody//tr[2]//tr[2]//td[2]") // To Employee ex."Amol N Patil"
	WebElement InsideDetailsSecondRowColLoc;

	// "Data Not Found...!" Message on screen
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

	// CopyRight Message on screen at bottom

	@FindBy(xpath = "//footer/label[1]")
	WebElement CopyRightMessageLoc;

	// *************************************|Methods|*****************************

	// Select Item from "Items per Page Dropdown"
	public void ItemsPerPageDropDown(String SelectText) {
		waitForFindElementPresent(ItemsPerPageDDLoc); // Create object of the Select class
		Select items = new Select(ItemsPerPageDDLoc);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside ItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the Request using Search Box
	public void SearchRequest(String AssetsNumbr) throws IOException {
		System.out.println("Inside SearchRequest()");
		waitForFindElementPresent(SearchByTextboxReqWindowLoc);
		SearchByTextboxReqWindowLoc.clear();
		SearchByTextboxReqWindowLoc.sendKeys(XLUtils.FetchExcelData(AssetsNumbr));
		System.out.println("Serched Request for Asset Number("+ AssetsNumbr + ")");
	}

	public void VerifyRecordDisplayed() {
		if (FirstRowAfterSearchLoc.isDisplayed() == true) {
			System.out.println("Record Displayed!");
		}
	}

	public void VerifyDataNotFoundMessDisplayed() {
		if (DataNotFoundMessLoc.isDisplayed() == true) {
			String DNFMessage = DataNotFoundMessLoc.getText();
			System.out.println("The Message Displayed!");
			System.out.println("Message is '" + DNFMessage + "'");
		}
	}

	/*
	 * // Get First Row Elements public void ValidateFirstRow() throws IOException {
	 * String R1 = FirstColLoc.getText(), R2 = SecondColLoc.getText(), R3 =
	 * ThirdColLoc.getText(), R4 = ForthColLoc.getText(), R5 =
	 * FifthColLoc.getText(), R6 = SixthColLoc.getText(), R7 =
	 * SeventhColLoc.getText(), R8 = EighthColLoc.getText();
	 * 
	 * // Actual row data Array System.out.println("Row Data => " + "|" + R1 + "|" +
	 * R2 + "|" + R3 + "|" + R4 + "|" + R5 + "|" + R6 + "|" + R7 + "|" + R8 + "|");
	 * }
	 */

	// Get Row data
	public void GetReqRowData() throws IOException {
		waitForFindElementPresent(EighthColLoc);
		EighthColLoc.click();
		String AssetNumber = FirstColLoc.getText(), RequestType = SecondColLoc.getText(),
				RequestDate = ForthColLoc.getText(), Status = SixthColLoc.getText(),
				ToEmployee = InsideDetailsSecondRowColLoc.getText();
		System.out.println("Row Data => " + "|" + AssetNumber + "|" + RequestType + "|" + RequestDate + "|" + Status
				+ "|" + ToEmployee + "|");
	}

	public void ClickRejectedButton() {
		System.out.println("Inside ClickRejectedButton()");
		waitForFindElementPresent(RejectedBtnReqPageLoc);
		RejectedBtnReqPageLoc.click();
	}

	public void ClickPendingButton() {
		System.out.println("Inside ClickPendingButton()");
		waitForFindElementPresent(PendingBtnReqPageLoc);
		PendingBtnReqPageLoc.click();
	}

	public void ClickApprovedButton() {
		System.out.println("Inside ClickApprovedButton()");
		waitForFindElementPresent(ApprovedBtnReqPage);
		ApprovedBtnReqPage.click();
	}

	public void ClickAllButton() {
		System.out.println("Inside ClickAllButton()");
		waitForFindElementPresent(AllBtnReqPage);
		AllBtnReqPage.click();
	}

}
