package com.pageObjects.AMS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.base.BasePage;
import com.utilities.XLUtils;

public class EmployeePage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public EmployeePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//*************************************|Locators|*************************************\\

	// "Items Per Page" dropdown inside Employee window Loc
	@FindBy(xpath = "//div//label[contains(text(),\"Items Per Page\")]//following-sibling::select[@class='sort'][1]")
	WebElement SelectItemsPerPageDropDownLoc;

	// Search By textbox on Employee window
	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchByTextboxEmpWindowLoc;

	// Active Button on screen
	@FindBy(xpath = "//button[contains(text(),'Active')]")
	WebElement ActiveBtnEmpPageLoc;

	// Inactive Button on screen
	@FindBy(xpath = "//button[contains(text(),'Inactive ')]")
	WebElement InactiveBtnEmpPageLoc;

	// All button on screen
	@FindBy(xpath = "// button[contains(text(),'All')]")
	WebElement AllBtnEmpPage;

	// After Search first row
	@FindBy(xpath = "//tbody//tr[1]")
	WebElement FirstRowAfterSearchLoc;

	// First Row Elements
	@FindBy(xpath = "//tbody//tr//td[1]") // Employee ID
	WebElement FirstRowEmployeeIDLoc;
	@FindBy(xpath = "//tbody//tr//td[2]") // Employee Name
	WebElement FirstRowEmployeeNameLoc;
	@FindBy(xpath = "//tbody//tr//td[3]") // Status
	WebElement FirstRowStatusLoc;
	@FindBy(xpath = "//tbody//tr//td[4]") // Date of Joining
	WebElement FirstRowDateofJoiningLoc;
	@FindBy(xpath = "//tbody//tr//td[5]") // Email ID
	WebElement FirstRowEmailIDLoc;

	// "Data Not Found...!" Message
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

	// Create Employee Button
	@FindBy(xpath = "//button[contains(text(),'Create Employee')]")
	WebElement CreateEmployeeBtnLoc;

	// FILL THE FORM

	// EMPLOYEE ID : Text Box
	@FindBy(xpath = "//form//div[1]/input[@placeholder='Enter Employee Code']")
	WebElement EMPIdTxtBoxLoc;

	// EMPLOYEE ID : Error Message
	@FindBy(xpath = "//form//div[1]/small[contains(text(),'Employee Id')]")
	WebElement EMPIdErrMessLoc;

	// EMPLOYEE NAME : Text Box
	@FindBy(xpath = "//form//div[2]/input[@placeholder='Enter name']")
	WebElement EMPNameTxtBoxLoc;

	// EMPLOYEE NAME : Error Message
	@FindBy(xpath = "//form//div[2]/small[contains(text(),'Employee name')]")
	WebElement EMPNameErrMessLoc;

	// STATUS : Dropdown
	@FindBy(xpath = "//form//div[3]/select[@id='status']")
	WebElement StatusDropDownLoc;

	// STATUS : Error Message
	@FindBy(xpath = "//form//div[3]/small[contains(text(),'Status')]")
	WebElement StatusErrMessLoc;

	// Date of Joining : Select Dropdown
	@FindBy(xpath = "//form//div[4]/input[@type='date'][1]")
	WebElement DateOfJoiningDropDownLoc;

	// Date of Joining : Error Message
	@FindBy(xpath = "//form//div[4]/small[contains(text(),'Date is r')]")
	WebElement DateOfJoiningErrMessLoc;

	// Email : Enter Email
	@FindBy(xpath = "//form//div[5]//input[@type='email']")
	WebElement EnterEmailLoc;

	// Email : Error Message
	@FindBy(xpath = "//form//div[5]/small[contains(text(),'Email')]")
	WebElement EmailErrMessLoc;

	// Close Button
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Close')]")
	WebElement CreateEmpCloseBtnLoc;

	// Save Button
	@FindBy(xpath = "//button[contains(text(),' Save ')]")
	WebElement CreateEmpSaveBtnLoc;

	// Edit Employee button
	@FindBy(xpath = "//tr//td/i[@class='fa fa-edit']")
	WebElement EditEmployeeBtnLoc;

	// Delete Employee button
	@FindBy(xpath = "//tr/td//i[@class='fa fa-trash']")
	WebElement DeleteEmployeeBtnLoc;

	// Update Employee form locators

	// Employee Id
	@FindBy(xpath = "//div[@id='editUser']//div[@class='modal-content']//div[1]//input[1]")
	WebElement EditEntrEmployeeIdLoc;

	// Employee Name
	@FindBy(xpath = "//div[@id='editUser']//div[@class='modal-content']//div[1]//input[1]")
	WebElement EditEntrEmployeeNameLoc;

	// Status
	@FindBy(xpath = "(//select[@id='status'])[2]")
	WebElement EditSelectStatusLoc;

	// Date of Joining
	@FindBy(xpath = "(//input[@type='date'])[2]")
	WebElement EntrDateLoc;

	// Email-ID
	@FindBy(xpath = "(//input[@type='email'])[2]")
	WebElement EntrEmailLoc;

	// Close Button
	@FindBy(xpath = "(//button[@type='button'][contains(text(),'Close')])[2]")
	WebElement CloseBtnLoc;

	// Update Button
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateBtnLoc;

//*************************************|Methods|*************************************\\

	// Select Item from "Items per Page Dropdown"
	public void SelectItemFromItemsPerPageDropDownEmp(String SelectText) {
		waitForFindElementPresent(SelectItemsPerPageDropDownLoc);
		// Create object of the Select class
		Select items = new Select(SelectItemsPerPageDropDownLoc);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside SelectItemFromItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the Assets using Search Box
	// >> Valid inputs -> Asset no, Employee-name, category etc.
	public void SearchEmployeeByText(String EmployeeName) {
		System.out.println("Inside SearchEmployeeByText()");
		waitForFindElementPresent(SearchByTextboxEmpWindowLoc);
		SearchByTextboxEmpWindowLoc.clear();
		SearchByTextboxEmpWindowLoc.sendKeys(EmployeeName);
		System.out.println("Inside SearchEmployeeByText() : Serched Employee is - " + EmployeeName);
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

	// Get First Row Elements
	public void ValidateFirstRow(String ExpEmployeeID, String ExpEmployeeName, String ExStatus, String ExDateofJoining,
			String ExEmailID) throws IOException {

		/*
		 * String EmployeeID = FirstRowEmployeeIDLoc.getText(); String EmployeeName =
		 * FirstRowEmployeeNameLoc.getText(); String Status =
		 * FirstRowStatusLoc.getText(); String DateOfJoining =
		 * FirstRowDateofJoiningLoc.getText(); String EmailId =
		 * FirstRowEmailIDLoc.getText();
		 */

		/*
		 * Assert.assertEquals(EmployeeID, XLUtils.FetchExcelData(ExpEmployeeID));
		 * Assert.assertEquals(EmployeeName, XLUtils.FetchExcelData(ExpEmployeeName));
		 * Assert.assertEquals(Status, XLUtils.FetchExcelData(ExStatus));
		 * Assert.assertEquals(DateOfJoining, XLUtils.FetchExcelData(ExDateofJoining));
		 * Assert.assertEquals(EmailId, XLUtils.FetchExcelData(ExEmailID));
		 */

		System.out.println("Expected => " + "|" + ExpEmployeeID + "|" + ExpEmployeeName + "|" + ExStatus + "|"
				+ ExDateofJoining + "|" + ExEmailID + "|");
		System.out.println("Actual => " + "|" + FirstRowEmployeeIDLoc.getText() + "|"
				+ FirstRowEmployeeNameLoc.getText() + "|" + FirstRowStatusLoc.getText() + "|"
				+ FirstRowDateofJoiningLoc.getText() + "|" + FirstRowEmailIDLoc.getText() + "|");

		/*
		 * EmployeeID EmployeeName Status DateOfJoining EmailId
		 */

		// Expected row data Array
		String EmployeeDetailsEx[] = { XLUtils.FetchExcelData(ExpEmployeeID), XLUtils.FetchExcelData(ExpEmployeeName),
				XLUtils.FetchExcelData(ExStatus), XLUtils.FetchExcelData(ExDateofJoining),
				XLUtils.FetchExcelData(ExEmailID) };

		// Actual row data Array
		String EmployeeDetailsAc[] = { FirstRowEmployeeIDLoc.getText(), FirstRowEmployeeNameLoc.getText(),
				FirstRowStatusLoc.getText(), FirstRowDateofJoiningLoc.getText(), FirstRowEmailIDLoc.getText() };

		// Asserting row data
		for (String i : EmployeeDetailsEx)
			for (String j : EmployeeDetailsAc)
				Assert.assertEquals(i, j);
	}

	// Click on Create Employee Button
	public void ClickCreateEmployeeButton() {
		System.out.println("ClickCreateEmployeeButton()");
		waitForFindElementPresent(CreateEmployeeBtnLoc);
		CreateEmployeeBtnLoc.click();
	}

	// Fill the Form

	public void EnterEmployeeId(String EmployeeId) throws IOException {
		System.out.println("Inside EnterEmployeeId()");
		waitForFindElementPresent(EMPIdTxtBoxLoc);
		EMPIdTxtBoxLoc.clear();
		EMPIdTxtBoxLoc.sendKeys(XLUtils.FetchExcelData(EmployeeId));
	}

	public void EnterEmployeeName(String EmployeeName) throws IOException {
		System.out.println("Inside EnterEmployeeName()");
		waitForFindElementPresent(EMPNameTxtBoxLoc);
		EMPNameTxtBoxLoc.clear();
		EMPNameTxtBoxLoc.sendKeys(XLUtils.FetchExcelData(EmployeeName));
	}

	public void SelectStatus(String EmpStatus) throws IOException {
		System.out.println("Inside SelectStatus()");
		waitForFindElementPresent(StatusDropDownLoc);
		// Create object of the Select class
		Select status = new Select(StatusDropDownLoc);
		status.selectByVisibleText(XLUtils.FetchExcelData(EmpStatus));
	}

	public void EnterDateOfJoining(String JoiningDate) throws IOException {
		System.out.println("Inside EnterDateOfJoining()");
		waitForFindElementPresent(DateOfJoiningDropDownLoc);
		DateOfJoiningDropDownLoc.clear();
		DateOfJoiningDropDownLoc.sendKeys(XLUtils.FetchExcelData(JoiningDate));
	}

	public void EnterEmail(String EmpEmail) throws IOException {
		System.out.println("Inside EnterDateOfJoining()");
		waitForFindElementPresent(EnterEmailLoc);
		EnterEmailLoc.clear();
		EnterEmailLoc.sendKeys(XLUtils.FetchExcelData(EmpEmail));
	}

	// Fill the form at once
	public void FillTheCompleteEmployeeForm(String EmployeeID, String EmployeeName, String Status, String DateOfJoining,
			String EmailId) throws IOException {
		// Insert all Information
		EnterEmployeeId(EmployeeID);
		EnterEmployeeName(EmployeeName);
		SelectStatus(Status);
		EnterDateOfJoining(DateOfJoining);
		EnterEmail(EmailId);
	}

	// Click on Close Button
	public void ClickEmpCloseButton() {
		waitForFindElementPresent(CreateEmpCloseBtnLoc);
		CreateEmpCloseBtnLoc.click();
		System.out.println("Close the 'Create Employee' window");
	}

	// Click on Save Button
	public void ClickEmpSaveButton() {
		waitForFindElementPresent(CreateEmpSaveBtnLoc);
		CreateEmpSaveBtnLoc.click();
	}

	// Click on edit user button
	public void ClickEditUserToolTip() {
		waitForFindElementPresent(EditEmployeeBtnLoc);
		EditEmployeeBtnLoc.click();
	}

	// Click on delete user button
	public void ClickDeleteUserToolTip() {
		waitForFindElementPresent(DeleteEmployeeBtnLoc);
		DeleteEmployeeBtnLoc.click();
	}

	// Update Employee form

	// fill the all information
	public void FillUpdateUserForm(String EmpId, String EmpName, String SelStatus, String EdtDate, String EdtEmail)
			throws IOException {
		System.out.println("Inside FillUpdateUserForm()");

		// Enter Employee Id
		waitForFindElementPresent(EditEntrEmployeeIdLoc);
		EditEntrEmployeeIdLoc.clear();
		EditEntrEmployeeIdLoc.sendKeys(XLUtils.FetchExcelData(EmpId));

		// Enter Employee Name
		waitForFindElementPresent(EditEntrEmployeeNameLoc);
		EditEntrEmployeeNameLoc.clear();
		EditEntrEmployeeNameLoc.sendKeys(XLUtils.FetchExcelData(EmpName));

		// Select Status
		waitForFindElementPresent(EditSelectStatusLoc);
		Select status = new Select(EditSelectStatusLoc); // Create object of the Select class
		status.selectByVisibleText(XLUtils.FetchExcelData(SelStatus));
		waitForFindElementPresent(EditSelectStatusLoc);

		// Date of Joining
		waitForFindElementPresent(EntrDateLoc);
		EntrDateLoc.clear();
		EntrDateLoc.sendKeys(XLUtils.FetchExcelData(EdtDate));

		// Enter Email
		waitForFindElementPresent(EntrEmailLoc);
		EntrEmailLoc.clear();
		EntrEmailLoc.sendKeys(XLUtils.FetchExcelData(EdtEmail));
	}

	// Close form - click close button
	public void ClickCloseBtn() {
		waitForFindElementPresent(CloseBtnLoc);
		CloseBtnLoc.click();
	}

	// Update employee - click on Update button
	public void ClickUpdteBtn() {
		waitForFindElementPresent(UpdateBtnLoc);
		UpdateBtnLoc.click();
	}

}
