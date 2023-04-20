
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

public class AssetsStatusPage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public AssetsStatusPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// *************************************|Locators|****************************
	// *************************************|Locators|****************************

	// Items Per Page drop down on screen
	@FindBy(xpath = "//select[@class='sort']")
	WebElement ItemsPerPageDDLoc;

	// Search By text box on screen
	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchByTextboxReqWindowLoc;

	// After Search
	// ---------------------------------------------------------------------------
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

	// Assets Status Edit tool tip
	@FindBy(xpath = "//td//*[@class='fa fa-edit ml-5']")
	WebElement EdittooltipLoc;

	// Assets Status Delete tool tip
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement AssetGrpDeletetooltipLoc;

	/// ----------------------------------------------------------------------------------///

	// Create Assets Status Button
	@FindBy(xpath = "//button[contains(text(),'Create Asset Status ')]")
	WebElement CretAssetStatusBtnLoc;

	// Create Asset Status window title
	@FindBy(xpath = "//*[@id='exampleModalCenterTitle' and contains(text(),'Create Asset Status')]")
	WebElement CrteAssetStatuswindowTitleLoc;

	// Asset Status Name Label
	@FindBy(xpath = "//label[contains(text(),'Asset Status Name')]")
	WebElement AssetStatusNameLabelLoc;

	// Enter Asset Status Name text box
	@FindBy(xpath = "//div[@id='createAssetStatus']//input[@type='text']")
	WebElement EntrAssetStatusNameLoc;

	// Error Message
	@FindBy(xpath = "//div[contains(text(),'status name is required')]")
	WebElement EntAssetErrorMessageLoc;

	// Create Button
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Create')]")
	WebElement CreateButtonLoc;

	// Cancel Button
	@FindBy(xpath = "//div[@id='createAssetStatus']//button[@type='button'][contains(text(),'Cancel')]")
	WebElement CancelButtonLoc;

	// Message Popup after Creating Assets Status
	// Actual Message -> "Record Created Successfully!"
	@FindBy(xpath = "(//*[@id='swal2-title'])")
	WebElement MessAfterCreateAssetStatusLoc;
	// OK Button to close the message pop up
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkBtnMessPopCreateAssetStatusLoc;

	// * Edit Assets Status

	// Enter Asset Status Name text box in Edit window
	@FindBy(xpath = "//div[@id='edit']//input[@type='text']")
	WebElement EditAssetNameStatusLoc;

	// Cancel Button in Edit window
	@FindBy(xpath = "//div[@id='edit']//button[@type='button'][normalize-space()='Cancel']")
	WebElement CancelButtonEditWindoqLoc;

	// Update Button in Edit window
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateButtonEditWindoqLoc;

	// Error message 1 on Edit window for Status name
	@FindBy(xpath = "//div[@id='edit']//span[contains(text(),'Asset group name is required !')]")
	WebElement ErrMess1EditWindoqLoc;

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
	@FindBy(xpath = "//*[contains(text(),'Deleted')]")
	WebElement AfterDeletionMessLoc;
	// Click OK Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement ClickOKBtnDeleteLoc;

	// *************************************|Methods|*****************************

	// Select Item from "Items per Page Drop-down"
	public void ItemsPerPageDropDown(String SelectText) {
		waitForFindElementPresent(ItemsPerPageDDLoc); // Create object of the Select class
		Select items = new Select(ItemsPerPageDDLoc);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside ItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the Request using Search Box
	public void SearchAssetsStatus(String AssetsStatusName) throws IOException {
		System.out.println("Inside SearchAssetsStatus()");
		waitForFindElementPresent(SearchByTextboxReqWindowLoc);
		SearchByTextboxReqWindowLoc.clear();
		SearchByTextboxReqWindowLoc.sendKeys(XLUtils.FetchExcelData(AssetsStatusName));
		System.out.println("Serched Assets Status for Asset Status Name(" + AssetsStatusName + ")");
	}

	// Verify "Data Not Found!" Message is displayed.
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

	public void ClickCreateAssetStatusButton() {
		waitForFindElementPresent(CretAssetStatusBtnLoc);
		CretAssetStatusBtnLoc.click();
	}

	public String CreateAssetStatusWindowTitle() {
		waitForFindElementPresent(CrteAssetStatuswindowTitleLoc);
		return CrteAssetStatuswindowTitleLoc.getText();
	}

	public String AssetStatusTxtBoxLabel() {
		waitForFindElementPresent(AssetStatusNameLabelLoc);
		return AssetStatusNameLabelLoc.getText();
	}

	public void ClickInsideEnterAssetStatusName() {
		waitForFindElementPresent(EntrAssetStatusNameLoc);
		EntrAssetStatusNameLoc.click();
	}

	public void EnterAssetStatusName(String AssetStatusName) throws IOException {
		waitForFindElementPresent(EntrAssetStatusNameLoc);
		EntrAssetStatusNameLoc.sendKeys(XLUtils.FetchExcelData(AssetStatusName));
	}

	public void ValidateErrorMessage1(String ExErrorMess) {
		String ErrorMess = EntAssetErrorMessageLoc.getText();
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
	public void ValidateMessAfterAssetStatus(String ExpectedMess) throws IOException {
		waitForFindElementPresent(MessAfterCreateAssetStatusLoc);
		String ActualMess = MessAfterCreateAssetStatusLoc.getText();
		Assert.assertEquals(ActualMess, XLUtils.FetchExcelData(ExpectedMess));
		OkBtnMessPopCreateAssetStatusLoc.click();
	}

	/// Update Assets Status Window ///

	public void ClickEditTooltip() {
		waitForFindElementPresent(EdittooltipLoc);
		EdittooltipLoc.click();
	}

	public void EnterAssetStatusNameToUpdate(String AssetsStatusName) throws IOException {
		waitForFindElementPresent(EditAssetNameStatusLoc);
		EditAssetNameStatusLoc.clear();
		EditAssetNameStatusLoc.sendKeys(XLUtils.FetchExcelData(AssetsStatusName));
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

	public void ValidateUpdatedSuccessMess(String ExMess) throws IOException {
		waitForFindElementPresent(UpdateMessLoc);
		String ActMessage = UpdateMessLoc.getText();
		Assert.assertEquals(ActMessage, XLUtils.FetchExcelData(ExMess));
		UpdateMessOkBtnLoc.click();
		System.out.println(ActMessage);
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
		System.out.println(Mess);
	}
}
