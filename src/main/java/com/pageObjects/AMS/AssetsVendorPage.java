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

public class AssetsVendorPage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public AssetsVendorPage(WebDriver driver) {
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

// After Search
//---------------------------------------------------------------------------
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

	// Assets Vendor Edit tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-edit ml-5']")
	WebElement EdittooltipLoc;

	// Assets Vendor Delete tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement AssetGrpDeletetooltipLoc;

///----------------------------------------------------------------------------------///

	// Create Assets Vendor Button
	@FindBy(xpath = "//button[contains(text(),'Create Asset Vendor ')]")
	WebElement CretAssetVendorBtnLoc;

	// Create Asset Vendor window title
	@FindBy(xpath = "//*[@id='exampleModalCenterTitle']")
	WebElement CrteAssetVendorwindowTitleLoc;

	// Asset Vendor Name Label
	@FindBy(xpath = "//label[contains(text(),'Asset Vendor Name')]")
	WebElement AssetVendorNameLabelLoc;

	// Enter Asset Vendor Name textbox
	@FindBy(xpath = "//div[@id='createAssetVendor']//input[@type='text']")
	WebElement EntrAssetVendorNameLoc;

	// Error Message
	@FindBy(xpath = "//div[contains(text(),'vendor name is required')]")
	WebElement EntAssetErrorMessageLoc;

	// Asset Vendor Code Label
	@FindBy(xpath = "div[id='createAssetVendor'] label[for='vendorForm']")
	WebElement AssetVendorCodeLabelLoc;

	// Enter Asset Vendor Code textbox
	@FindBy(xpath = "//input[@placeholder='Enter Asset Vendor Code'][@type='text']")
	WebElement EntrAssetVendorCodeLoc;

	// Error Message
	@FindBy(xpath = "//div[@id='createAssetVendor']//div[@class='p-error'][normalize-space()='vendor code is required']")
	WebElement EntAssetCodeErrorMessageLoc;

	// Create Button
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Create')]")
	WebElement CreateButtonLoc;

	// Cancel Button
	@FindBy(xpath = "//div[@id='createAssetVendor']//button[@type='button'][contains(text(),'Cancel')]")
	WebElement CancelButtonLoc;

	// Message Popup after Creating Assets Vendor
	// Actual Message -> "Record Created Successfully!"
	@FindBy(xpath = "(//*[@id='swal2-title'])")
	WebElement MessAfterCreateAssetVendorLoc;
	// OK Button to close the message popup
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkBtnMessPopCreateAssetVendorLoc;

	// * Edit Assets Vendor

	// Enter Asset Vendor Name textbox in Edit window
	@FindBy(xpath = "//div[@id='edit']//input[@type='text']")
	WebElement EditAssetNameVendorLoc;

	// Enter Asset Vendor Code textbox in Edit window
	@FindBy(xpath = "//div[@id='edit']//input[2]")
	WebElement EditAssetCodeVendorLoc;

	// Cancel Button in Edit window
	@FindBy(xpath = "//div[@id='edit']//button[@type='button'][normalize-space()='Cancel']")
	WebElement CancelButtonEditWindoqLoc;

	// Update Button in Edit window
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateButtonEditWindoqLoc;

	// Error message 1 on Edit window for vendor name
	@FindBy(xpath = "//div[@id='edit']//div[normalize-space()='vendor name is required']")
	WebElement ErrMess1EditWindoqLoc;

	// Error message 2 on Edit window for vendor code
	@FindBy(xpath = "//div[@id='edit']//div[normalize-space()='vendor code is required']")
	WebElement ErrMess2EditWindoqLoc;

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
	public void SearchAssetsVendor(String AssetsVendorName) throws IOException {
		System.out.println("Inside SearchAssetsVendor()");
		waitForFindElementPresent(SearchByTextboxReqWindowLoc);
		SearchByTextboxReqWindowLoc.clear();
		SearchByTextboxReqWindowLoc.sendKeys(XLUtils.FetchExcelData(AssetsVendorName));
		System.out.println("Serched Assets Vendor for Asset Vendor Name(" + AssetsVendorName + ")");
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

	public void ClickCreateAssetVendorButton() {
		waitForFindElementPresent(CretAssetVendorBtnLoc);
		CretAssetVendorBtnLoc.click();
	}

	public String CreateAssetVendorWindowTitle() {
		waitForFindElementPresent(CrteAssetVendorwindowTitleLoc);
		return CrteAssetVendorwindowTitleLoc.getText();
	}

	public String EnterAssetVendorTxtBoxLabel() {
		waitForFindElementPresent(AssetVendorNameLabelLoc);
		return AssetVendorNameLabelLoc.getText();
	}

	public void ClickInsideEnterAssetVendorName() {
		waitForFindElementPresent(EntrAssetVendorNameLoc);
		EntrAssetVendorNameLoc.click();
	}

	public void EnterAssetVendorName(String AssetVendorName) throws IOException {
		waitForFindElementPresent(EntrAssetVendorNameLoc);
		EntrAssetVendorNameLoc.sendKeys(XLUtils.FetchExcelData(AssetVendorName));
	}

	public void ValidateErrorMessage1(String ExErrorMess) {
		String ErrorMess = EntAssetErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, ExErrorMess);
	}

	public String EnterAssetVendorCodeTxtBoxLabel() {
		waitForFindElementPresent(AssetVendorCodeLabelLoc);
		return AssetVendorCodeLabelLoc.getText();
	}

	public void ClickInsideEnterAssetVendorCode() {
		waitForFindElementPresent(EntrAssetVendorCodeLoc);
		EntrAssetVendorCodeLoc.click();
	}

	public void EnterAssetVendorCode(String AssetVendorName) throws IOException {
		waitForFindElementPresent(EntrAssetVendorCodeLoc);
		EntrAssetVendorCodeLoc.sendKeys(XLUtils.FetchExcelData(AssetVendorName));
	}

	public void ValidateVendorCodeErrMess(String ExErrorMess) {
		String ErrorMess = EntAssetCodeErrorMessageLoc.getText();
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
	public void ValidateMessAfterAssetVendor(String ExpectedMess) throws IOException {
		waitForFindElementPresent(MessAfterCreateAssetVendorLoc);
		String ActualMess = MessAfterCreateAssetVendorLoc.getText();
		Assert.assertEquals(ActualMess, XLUtils.FetchExcelData(ExpectedMess));
		OkBtnMessPopCreateAssetVendorLoc.click();
	}

	/// Update Assets Vendor Window ///

	public void ClickEditTooltip() {
		waitForFindElementPresent(EdittooltipLoc);
		EdittooltipLoc.click();
	}

	public void EnterAssetVendorNameToUpdate(String AssetsVendorName) throws IOException {
		waitForFindElementPresent(EditAssetNameVendorLoc);
		EditAssetNameVendorLoc.clear();
		EditAssetNameVendorLoc.sendKeys(XLUtils.FetchExcelData(AssetsVendorName));
	}

	public void EnterAssetVendorCodeToUpdate(String AssetsVendorName) throws IOException {
		waitForFindElementPresent(EditAssetCodeVendorLoc);
		EditAssetCodeVendorLoc.clear();
		EditAssetCodeVendorLoc.sendKeys(XLUtils.FetchExcelData(AssetsVendorName));
	}

	public void ClickCancelButtonInUpdate() {
		waitForFindElementPresent(CancelButtonEditWindoqLoc);
		CancelButtonEditWindoqLoc.click();
	}

	public void ClickUpdateButtonInUpdate() {
		waitForFindElementPresent(UpdateButtonEditWindoqLoc);
		UpdateButtonEditWindoqLoc.click();
	}

	public void ValidateErrorMessage1Update(String ExErrorMess) {
		String ErrorMess = ErrMess1EditWindoqLoc.getText();
		Assert.assertEquals(ErrorMess, ExErrorMess);
	}

	public void ValidateErrorMessage2Update(String ExErrorMess) {
		String ErrorMess = ErrMess2EditWindoqLoc.getText();
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
