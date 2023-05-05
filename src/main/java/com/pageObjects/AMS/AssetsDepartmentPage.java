
package com.pageObjects.AMS;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BasePage;
import com.utilities.XLUtils;

public class AssetsDepartmentPage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public AssetsDepartmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// *************************************|Locators|****************************

	// Items Per Page dropdown on screen
	@FindBy(xpath = "//select[@class='sort']")
	WebElement ItemsPerPageDDLoc;

	// Search By textbox on screen
	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchByTextboxReqWindowLoc;

// After Search ---------------------------------------------------------------------------
	// Visible Table
	@FindBy(xpath = "//table//tbody")
	WebElement VisibleTableLoc;
	String presenttable = "//table//tbody";

	// Visible rows
	@FindBy(xpath = "//table//tbody//tr")
	WebElement VisibleRowsLoc;
	String presentrows = "//table//tbody//tr";

	// Visible Columns
	@FindBy(xpath = "//tbody//tr//td") // Asset Number
	WebElement VisibleColumnsLoc;
	String presentcols = "//tbody//tr//td";

	// "Data Not Found...!" Message on screen
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

	// CopyRight Message on screen at bottom
	@FindBy(xpath = "//footer/label[1]")
	WebElement CopyRightMessage1Loc;
	@FindBy(xpath = "//footer/label[2]")
	WebElement CopyRightMessage2Loc;

	// Assets Group Edit tooltip
	@FindBy(xpath = "//tr//*[@class='fa fa-edit ml-5']")
	WebElement AssetGrpEdittooltipLoc;

	// Assets Group Delete tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement AssetGrpDeletetooltipLoc;

// Create Asset Department ---------------------------------------------------------------------------------------

	// Create Assets Department Button
	@FindBy(xpath = "//button[contains(text(),'Create Department')]")
	WebElement CretAssetDepartBtnLoc;

	// Create Asset Department window title
	@FindBy(xpath = "//*[@id='exampleModalCenterTitle']")
	WebElement CrteAssetDepartwindowTitleLoc;

	// Asset Department Name Header
	@FindBy(xpath = "//label[contains(text(),'Asset Department Name')]")
	WebElement AssetDepartNameHeaderLoc;

	// Enter Asset Department textbox
	@FindBy(xpath = "//div[@id='createAssetDept']//input[@type='text']")
	WebElement EntrAssetDepartLoc;

	// Error Message
	@FindBy(xpath = "//div[contains(text(),'department name is required')]")
	WebElement EntAssetErrorMessageLoc;

	// Create Button
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Create')]")
	WebElement CreateButtonLoc;

	// Cancel Button
	@FindBy(xpath = "//div[@id='createAssetDept']//button[@type='button'][contains(text(),'Cancel')]")
	WebElement CancelButtonLoc;

	// Message Popup after Creating Assets Group
	// Actual Message -> "Record Created Successfully!"
	@FindBy(xpath = "(//*[@id='swal2-title'])")
	WebElement MessAfterCreateAssetDepartLoc;
	// OK Button to close the message popup
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkBtnMessPopCreateAssetDepartLoc;

// * Edit Assets Group

	// Enter Asset Department Name textbox in Edit window
	@FindBy(xpath = "//div[@id='edit']//input[@type='text']")
	WebElement EnterAssetDepartLoc;

	// Cancel Button in Edit window
	@FindBy(xpath = "//div[@id='edit']//button[@type='button'][normalize-space()='Cancel']")
	WebElement CancelButtonEditWindoqLoc;

	// Update Button in Edit window
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateButtonEditWindoqLoc;

	// Error message on Edit window
	@FindBy(xpath = "//div[@id='edit']//div[normalize-space()='department name is required']")
	WebElement ErrMessEditWindoqLoc;

	// Successfully Update Mess
	@FindBy(xpath = "//*[@id='swal2-title']")
	WebElement UpdateMessLoc;

	// Update OK Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement UpdateMessOkBtnLoc;

// Delete Asset Group...........................
	// Delete Confirmation message
	@FindBy(xpath = "//button[contains(text(),'Yes, Delete It!')]")
	WebElement ConfirmBeforeDeleteLoc;
	// After deletion message
	@FindBy(xpath = "//*[@id='swal2-title']") // //*[contains(text(),'Deleted')]
	WebElement AfterDeletionMessLoc;
	// Click Ok Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement ClickOKBtnDeleteLoc;

// *************************************|Methods|*****************************

	// Select Item from "Items per Page Dropdown"
	public void ItemsPerPageDropDown(String SelectText) {
		waitForFindElementPresent(ItemsPerPageDDLoc); // Create object of the Select class
		Select items = new Select(ItemsPerPageDDLoc);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside ItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the Request using Search Box
	public void SearchAssetsDepartment(String AssetsDepartmentName) throws IOException {
		System.out.println("Inside SearchAssetsDepartment()");
		waitForFindElementPresent(SearchByTextboxReqWindowLoc);
		SearchByTextboxReqWindowLoc.clear();
		SearchByTextboxReqWindowLoc.sendKeys(XLUtils.FetchExcelData(AssetsDepartmentName));
		System.out.println("Serched Assets Department for Asset Department Name(" + AssetsDepartmentName + ")");
	}

	// Verify "Data Not Found!" Message is desplayed.
	public void VerifyDataNotFoundMessDisplayed() {
		if (DataNotFoundMessLoc.isDisplayed() == true) {
			String DNFMessage = DataNotFoundMessLoc.getText();
			System.out.println("Message is '" + DNFMessage + "'");
		}
	}

	public void VerifyRecordIsPresent() {

		// check if element visible
		try {
			List<WebElement> rows = driver.findElements(By.xpath(presentrows));
			if (rows.size() > 0) {
				if (rows.size() == 1) {
					System.out.println(rows.size() + " Record is present.");
				} else {
					System.out.println(rows.size() + " Records are present.");
				}

			} else {
				System.out.println("Record is not present.");
				VerifyDataNotFoundMessDisplayed();
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Get Row data
	public void GetRowData() throws IOException {

		// To locate table.
		WebElement mytable = driver.findElement(By.xpath(presenttable));

		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();

		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			System.out.println("All Rows");
			System.out.print("| ");
			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				if (celtext != null) {
					System.out.print(celtext);
				} else if (celtext == null) {
					System.out.print("NullValue");
				}
				System.out.print(" | ");
			}
			System.out.println("\n-------------------------------------------------- ");
		}
	}

	public void ClickCreateAssetDepartmentButton() {
		waitForFindElementPresent(CretAssetDepartBtnLoc);
		CretAssetDepartBtnLoc.click();
	}

	public String CreateAssetDepartmentWindowTitle() {
		waitForFindElementPresent(CrteAssetDepartwindowTitleLoc);
		return CrteAssetDepartwindowTitleLoc.getText();
	}

	public String AssetDepartmentHeader() {
		waitForFindElementPresent(AssetDepartNameHeaderLoc);
		return AssetDepartNameHeaderLoc.getText();
	}

	public void ClickInsideEnterAssetDepartment() {
		waitForFindElementPresent(EntrAssetDepartLoc);
		EntrAssetDepartLoc.click();
	}

	public void EnterAssetDepartment(String AssetDepartmentName) throws IOException {
		waitForFindElementPresent(EntrAssetDepartLoc);
		EntrAssetDepartLoc.sendKeys(XLUtils.FetchExcelData(AssetDepartmentName));
	}

	public String ErrorMessVisible() {
		waitForFindElementPresent(EntAssetErrorMessageLoc);
		return EntAssetErrorMessageLoc.getText();
	}

	public void ValidateErrorMessage1(String ExErrorMess) {
		String ErrorMess = ErrorMessVisible();
		Assert.assertEquals(ErrorMess, ExErrorMess);
	}

	public void ClickCreateButton() {
		waitForFindElementPresent(CreateButtonLoc);
		CreateButtonLoc.click();
	}

	public void ClickCancelButton() {
		waitForFindElementPresent(CancelButtonLoc);
		CancelButtonLoc.click();
	}

	// SuccessMessAfterCreate
	public void ValidateMessAfterAssetDepartment(String ExpectedMess) throws IOException {
		waitForFindElementPresent(MessAfterCreateAssetDepartLoc);
		String ActualMess = MessAfterCreateAssetDepartLoc.getText();
		Assert.assertEquals(ActualMess, XLUtils.FetchExcelData(ExpectedMess));
		OkBtnMessPopCreateAssetDepartLoc.click();
	}

/// Update Assets Group Window ///

	public void ClickEditTooltip() {
		waitForFindElementPresent(AssetGrpEdittooltipLoc);
		AssetGrpEdittooltipLoc.click();
	}

	public void EnterAssetDepartmentToUpdate(String AssetsDepartmentName) throws IOException {
		waitForFindElementPresent(EnterAssetDepartLoc);
		EnterAssetDepartLoc.clear();
		EnterAssetDepartLoc.sendKeys(XLUtils.FetchExcelData(AssetsDepartmentName));
	}

	public void ClickCancelButtonInUpdate() {
		waitForFindElementPresent(CancelButtonEditWindoqLoc);
		CancelButtonEditWindoqLoc.click();
	}

	public void ClickUpdateButtonInUpdate() {
		waitForFindElementPresent(UpdateButtonEditWindoqLoc);
		UpdateButtonEditWindoqLoc.click();
	}

	public String ErrorMessUpdateWindowVisible() {
		waitForFindElementPresent(ErrMessEditWindoqLoc);
		return ErrMessEditWindoqLoc.getText();
	}

	public void ValidateErrorMessage2(String ExErrorMess) {
		String ErrorMess = ErrorMessUpdateWindowVisible();
		Assert.assertEquals(ErrorMess, ExErrorMess);
	}

	public void ValidateUpdatedSuccessMess(String ExMess) throws IOException {
		waitForFindElementPresent(UpdateMessLoc);
		String ActMessage = UpdateMessLoc.getText();
		Assert.assertEquals(ActMessage, XLUtils.FetchExcelData(ExMess));
		UpdateMessOkBtnLoc.click();
		System.out.println("ActMessage");
	}

/// Delete Asset Group ///

	public void ClickDeleteTooltip() {
		waitForFindElementPresent(AssetGrpDeletetooltipLoc);
		AssetGrpDeletetooltipLoc.click();
	}

	// Delete Confirmation message
	public void YesDeleteIt(String ExMess) throws IOException {
		waitForFindElementPresent(ConfirmBeforeDeleteLoc);
		ConfirmBeforeDeleteLoc.click();
		waitForFindElementPresent(AfterDeletionMessLoc);
		String Mess = AfterDeletionMessLoc.getText();
		Assert.assertEquals(Mess, XLUtils.FetchExcelData(ExMess));
		waitForFindElementPresent(ClickOKBtnDeleteLoc);
		ClickOKBtnDeleteLoc.click();
		System.out.println("Mess");
	}
}
