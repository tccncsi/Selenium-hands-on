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

public class AssetPage extends BasePage {

	// Function to call the driver
	public AssetPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//*************************************|Locators|*************************************\\

	// "Items Per Page" dropdown inside Assets window Loc
	@FindBy(xpath = "//label[contains(text(),\"Items Per Page\")]//following-sibling::select")
	WebElement SelectItemsPerPageDropDwon;

	// Search By textbox on Assets window
	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchByTextboxAssetsWindowLoc;

	// "x" button to cancel the action of writing text inside "Search By" textbox on
	// Assets window
	@FindBy(xpath = "//div//input[@id='search']/following-sibling::i")
	WebElement xBtnCancelTheSearchActionLoc;

	// Delete the first Asset in list after search
	@FindBy(xpath = "//i[@data-toggle='tooltip'][1]")
	WebElement DeleteAssetFromDBLoc;

	// Create Asset button on Assets window
	@FindBy(xpath = "//button[contains(text(),'Create Asset')]")
	WebElement CreateAssetBtnOnAssetsWindowLoc;

//	* Under Create Assets window
//	---------------------------------------------

	// Create Assets header message
	@FindBy(xpath = "//*[@id='exampleModalLongTitle']")
	WebElement CreateAssetsHeaderMessageLoc;

	/*
	// "x" button to cancel or minimize the Create Assets window
	@FindBy(xpath = "//button/span[contains(.,'�') and @xpath = 1]")
	WebElement CloseAssetWindowBtnXLoc;
*/
// Form Filling

	// Asset Number textbox
	@FindBy(xpath = "(//input[@placeholder='Enter asset number'])[1]")
	WebElement AssetNumberTextboxLoc;

	// Asset Serial Number textbox
	@FindBy(xpath = "//div//input[@placeholder='Enter serial number']")
	WebElement AssetSerialNumberTextboxLoc;

	// Location dropdown
	@FindBy(xpath = "(//select[@id='dept'])[1]")
	WebElement LocationDropdownAssetsLoc;

	// Asset Description textbox
	@FindBy(xpath = "(//input[@placeholder='Enter short description'])[1]")
	WebElement AssetDescriptionTextboxLoc;

	// Asset Group dropdown
	@FindBy(xpath = "(//select[@id='assetGroup'])[1]")
	WebElement AssetGroupDropdownLoc;

	// Department dropdown
	@FindBy(xpath = "(//select[@id='department'])[1]")
	WebElement DepartmentDropdownLoc;

	// Vendor dropdown
	@FindBy(xpath = "(//select[@id='vendorName'])[1]")
	WebElement VendorDropdownLoc;

	// Asset Type dropdown
	@FindBy(xpath = "(//select[@id='fixedOrMovable'])[1]")
	WebElement AssetTypeDropdownLoc;

	// Status fixed value
	@FindBy(xpath = "(//input[@placeholder='Available'])[1]")
	WebElement StatusFixedValueLoc;

	// Count input box
	@FindBy(xpath = "(//input[@placeholder='Enter Count'])[1]")
	WebElement CountInputBoxLoc;

	// Remark textbox
	@FindBy(xpath = "(//textarea[@placeholder='Enter Your Remarks'])[1]")
	WebElement RemarkTextboxLoc;

	// Cancel button at the end
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='Cancel'])[2]")
	WebElement CancelBtnAssetsWindowLoc;

	// Create button at the end
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Create')]")
	WebElement CreateBtnAssetsWindowLoc;

	// 'Record Created Successfully!' pop up
	@FindBy(xpath = "//body/div/div[@role='dialog']/div[1]")
	WebElement SuccessfulPopupLoc;

	// Successful pop up message at the end
	@FindBy(xpath = "//*[@id='swal2-title']")
	WebElement SuccessfulPopupMessageLoc; // OR (//h2[normalize-space()='Record Created Successfully!'])[1]

	// Successful pop up OK button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement SuccessfulPopupOKBtnLoc;

	// After search first row loc
	@FindBy(xpath = "//tbody//tr[1]")
	WebElement FirstRowAfterSearchLoc;

	// Delete asset icon in first row as per search Loc
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement DeleteFirstAssetLoc;

	// Are You Sure? Confirmation message
	@FindBy(xpath = "//button[contains(text(),'Yes, Delete It!')]")
	WebElement AreYouSureConfirmtionPopYesDeleteItLoc;

	// Deleted successfull Dialog box
	@FindBy(xpath = "(//div[@role='dialog'])[8]")
	WebElement DeletedSuccessfullDialogboxLoc;

	// Deleted successfull message
	@FindBy(xpath = "//div[@id='swal2-content']")
	WebElement DeletedSuccessfullMessageLoc;

	// OK Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement DeletedSuccessfullOKBtnLoc;

	// "Data Not Found...!" Message
	@FindBy(xpath = "//span[normalize-space()='Data Not Found...!']")
	WebElement DataNotFoundMessageLoc;

// Update Asset ***************************************************************************************

	// Update Asset icon
	@FindBy(xpath = "//i[@data-target='#createAssetEdit']")
	WebElement UpdateFirstAsseticonLoc;

	// Asset Number
	@FindBy(xpath = "(//input[@type='text'])[14]")
	WebElement AssetNumberLoc;

	// Asset Serial Number
	@FindBy(xpath = "(// input[@type='text'])[15]")
	WebElement AssetSerielNumberLoc;

	// Location
	@FindBy(xpath = "(//select[@id='dept'])[3]")
	WebElement AssetLocationLoc;

	// Asset Description
	@FindBy(xpath = "(//input[@type='text'])[16]")
	WebElement AssetDescriptionLoc;

	// Asset Group
	@FindBy(xpath = "(//select[@id='assetGroup'])[3]")
	WebElement AssetGroupLoc;

	// Department
	@FindBy(xpath = "(//select[@id='department'])[3]")
	WebElement AssetDepartmentLoc;

	// Vendor
	@FindBy(xpath = "(//select[@id='vendorName'])[3]")
	WebElement AssetVendorLoc;

	// Status
	@FindBy(xpath = "(//select[@id='statusName'])")
	WebElement AssetStatusLoc;

	// Asset Type
	@FindBy(xpath = "(//select[@id='fixedOrMovable'])[3]")
	WebElement AssetTypeLoc;

	// Remark
	@FindBy(xpath = "//textarea[@placeholder='Enter Remarks'][1]")
	WebElement AssetRemarkLoc;

	// Close btn
	@FindBy(xpath = "(//button[@type='button'][contains(text(),'Close')])[1]")
	WebElement AssetCloseLoc;

	// Update Button
	@FindBy(xpath = "//button[starts-with(text(),'Update')]")
	WebElement AssetUpdateLoc;

	// Record Updated Successfully!

	// pop up
	@FindBy(xpath = "(//div[@role='dialog'])[8]")
	WebElement UpdateSuccessPopUp;

	// message
	@FindBy(xpath = "//h2[@id='swal2-title']")
	WebElement UpdateSuccessMessage;

	// Ok btn
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement UpdateSuccessOKBtn;

//*************************************|Methods|*************************************\\

//@*** Assets Page Methods 

	// Select Item from "Items per Page Dropdown"
	public void SelectItemFromItemsPerPageDropDown(String SelectText) {
		waitForFindElementPresent(SelectItemsPerPageDropDwon);
		// Create object of the Select class
		Select items = new Select(SelectItemsPerPageDropDwon);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside SelectItemFromItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the Assets using Search Box >> Valid inputs -> Asset no,
	// Employee-name, category etc.
	public void SearchAssetsByText(String AssetsNoOREmployeeNameORCategory) {
		waitForFindElementPresent(SearchByTextboxAssetsWindowLoc);
		SearchByTextboxAssetsWindowLoc.clear();
		SearchByTextboxAssetsWindowLoc.sendKeys(AssetsNoOREmployeeNameORCategory);
		System.out.println("Inside SearchAssetsByText() : Searched Assets is - " + AssetsNoOREmployeeNameORCategory);
	}

	public void VerifyRecordDisplayed() {
		if (FirstRowAfterSearchLoc.isDisplayed() == true) {
			System.out.println("Record Displayed!");
		}
	}

	// Click on "x" button to cancel the current search activity
	public void CloseTheSerachActivityOnSearchBy() {
		waitForFindElementPresent(xBtnCancelTheSearchActionLoc);
		xBtnCancelTheSearchActionLoc.click();
	}

	// Click on "Create Asset" Button
	public void ClickonCreateAssetBtn() {
		waitForFindElementPresent(CreateAssetBtnOnAssetsWindowLoc);
		CreateAssetBtnOnAssetsWindowLoc.click();
	}

	// Validate the Create Assets window header
	public void ValidateCreateAssetsHeaderMessage(String Expected) {
		waitForFindElementPresent(CreateAssetsHeaderMessageLoc);
		String HederMess = CreateAssetsHeaderMessageLoc.getText();
		Assert.assertEquals(HederMess, Expected);
		// Print out the result
		System.out.println(
				"Actual Header Message(" + HederMess + ") And Expected Header Message(" + Expected + ") -> Matched ");
	}

// Form Fill **********************************************************************

	// Enter the Asset Number
	public void EnterAssetNumber(String AssetNumber) throws IOException {
		System.out.println("Inside 'EnterAssetNumber()'");
		waitForFindElementPresent(AssetNumberTextboxLoc);
		AssetNumberTextboxLoc.click();
		AssetNumberTextboxLoc.sendKeys(XLUtils.FetchExcelData(AssetNumber));
	}

	// Enter the Asset Serial Number
	public void EnterAssetSerialNumber(String AssetSerialNumber) throws IOException {
		System.out.println("Inside 'EnterAssetSerialNumber()'");
		waitForFindElementPresent(AssetSerialNumberTextboxLoc);
		AssetSerialNumberTextboxLoc.click();
		AssetSerialNumberTextboxLoc.sendKeys(XLUtils.FetchExcelData(AssetSerialNumber));
	}

	// Select Location from dropdown
	public void SelectLocation(String Location) throws IOException {
		System.out.println("Inside 'SelectLocation()'");
		waitForFindElementPresent(LocationDropdownAssetsLoc);
		// Create object of the Select class
		Select location = new Select(LocationDropdownAssetsLoc);
		location.selectByVisibleText(XLUtils.FetchExcelData(Location));
	}

	// Enter Asset Description
	public void EnterAssetDescription(String AssetDescription) throws IOException {
		System.out.println("Inside 'EnterAssetDescription()'");
		waitForFindElementPresent(AssetDescriptionTextboxLoc);
		AssetDescriptionTextboxLoc.click();
		AssetDescriptionTextboxLoc.sendKeys(XLUtils.FetchExcelData(AssetDescription));
	}

	// Select Asset Group from dropdown
	public void SelectAssetGroup(String AssetGroup) throws IOException {
		System.out.println("Inside 'SelectAssetGroup()'");
		waitForFindElementPresent(AssetGroupDropdownLoc);
		// Create object of the Select class
		Select AG = new Select(AssetGroupDropdownLoc);
		AG.selectByVisibleText(XLUtils.FetchExcelData(AssetGroup));
	}

	// Select Department from dropdown
	public void SelectDepartment(String DepartMent) throws IOException {
		System.out.println("Inside 'SelectDepartment()'");
		waitForFindElementPresent(DepartmentDropdownLoc);
		// Create object of the Select class
		Select Dept = new Select(DepartmentDropdownLoc);
		Dept.selectByVisibleText(XLUtils.FetchExcelData(DepartMent));
	}

	// Select Vendor from dropdown
	public void SelectVendor(String Vendor) throws IOException {
		System.out.println("Inside 'SelectVendor()'");
		waitForFindElementPresent(VendorDropdownLoc);
		// Create object of the Select class
		Select vendor = new Select(VendorDropdownLoc);
		vendor.selectByVisibleText(XLUtils.FetchExcelData(Vendor));
	}

	// Select Asset Type from dropdown
	public void SelectAssetType(String AssetType) throws IOException {
		System.out.println("Inside 'SelectAssetType()'");
		waitForFindElementPresent(AssetTypeDropdownLoc);
		// Create object of the Select class
		Select Atype = new Select(AssetTypeDropdownLoc);
		Atype.selectByVisibleText(XLUtils.FetchExcelData(AssetType));
	}

	// Enter Count inside input box
	public void EnterCount(String Count) throws IOException {
		System.out.println("Inside 'EnterCount()'");
		waitForFindElementPresent(CountInputBoxLoc);
		CountInputBoxLoc.click();
		CountInputBoxLoc.sendKeys(XLUtils.FetchExcelData(Count));
	}

	// Enter Remark (current date)
	public void EnterRemark(String Remark) throws IOException {
		System.out.println("Inside 'EnterRemark()'");
		waitForFindElementPresent(RemarkTextboxLoc);
		RemarkTextboxLoc.click();
		RemarkTextboxLoc.sendKeys(XLUtils.FetchExcelData(Remark));
	}

	// Click on Cancel button at the bottom of form
	public void ClickOnCancelButton() {
		System.out.println("'ClickOnCancelButton()'");
		waitForFindElementPresent(CancelBtnAssetsWindowLoc);
		CancelBtnAssetsWindowLoc.click();
		System.out.println("Clicked on 'Cancel' button");
	}

	// Click on Create button at the end
	public void ClickOnCreateButton() {
		System.out.println("'ClickOnCreateButton()'");
		waitForFindElementPresent(CreateBtnAssetsWindowLoc);
		CreateBtnAssetsWindowLoc.click();
		System.out.println("Clicked on 'Create' button");
	}

	// Fill the complete form
	public void FillTheCompleteForm(String EnterAssetNumber, String EnterAssetSerialNumber, String SelectLocation,
			String EnterAssetDescription, String SelectAssetGroup, String SelectDepartment, String SelectVendor,
			String SelectAssetType, String EnterCount, String EnterRemark) throws IOException {

		System.out.println("Formfilling Started...");

		// All the steps performed here
		EnterAssetNumber(EnterAssetNumber);
		EnterAssetSerialNumber(EnterAssetSerialNumber);
		SelectLocation(SelectLocation);
		EnterAssetDescription(EnterAssetDescription);
		SelectAssetGroup(SelectAssetGroup);
		SelectDepartment(SelectDepartment);
		SelectVendor(SelectVendor);
		SelectAssetType(SelectAssetType);
		EnterCount(EnterCount);
		EnterRemark(EnterRemark);
		System.out.println("Formfilling completed...!");
	}

	// Verify that, Assets has created successfully!
	public void VerifyCreateAssetSuccessfullMessage(String ExpectedErrorMessage) throws IOException {
		System.out.println("Inside 'VerifyCreateAssetSuccessfullMessage()'");
		waitForFindElementPresent(SuccessfulPopupLoc);

		// isDisplayed() method returns boolean value either True or False
		if (SuccessfulPopupLoc.isDisplayed()) {
			// To print the value
			System.out.println("Successful Popup displayed");
		} else {
			// To print the value
			System.out.println("Successful Popup not displayed");
		}

		// Assert to check that message is corrent
		String Mess = SuccessfulPopupMessageLoc.getText();
		Assert.assertEquals(Mess, XLUtils.FetchExcelData(ExpectedErrorMessage));
		System.out.println("Successful Popup Message Matches -> " + Mess);
		// Click on OK button
		SuccessfulPopupOKBtnLoc.click();
	}

	public void ValidateErrorMessageAfterDeletedAsset(String ExpectedMessage) {
		waitForFindElementPresent(DeletedSuccessfullDialogboxLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = DeletedSuccessfullDialogboxLoc.isDisplayed();
		System.out.println("Successful Popup displayed :" + Display);
		String Message = DeletedSuccessfullMessageLoc.getText();
		// Assert to check that message is corrent
		Assert.assertEquals(Message, ExpectedMessage);
		// Click on OK button
		DeletedSuccessfullOKBtnLoc.click();

	}

	// Delete the first record searched as asset number
	public void DeleteTheTopMostRecordAfterSearch(String AssetToDelete) {
		System.out.println("Inside 'DeleteTheTopMostRecordAfterSearch()'");
		// Search the asset to delete
		SearchAssetsByText(AssetToDelete);
		waitForFindElementPresent(FirstRowAfterSearchLoc);
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = FirstRowAfterSearchLoc.isDisplayed();
		if (Display == true) {
			// Click on delete tooltip
			DeleteFirstAssetLoc.click();
			AreYouSureConfirmtionPopYesDeleteItLoc.click();
			ValidateErrorMessageAfterDeletedAsset("Your Record Has Been Deleted.");
			System.out.println("Record deleted successfully!");
		}
	}

	public void VerifyDataNotFoundMessageIsPresent() {
		if (DataNotFoundMessageLoc.isDisplayed() == true) {
			System.out.println("Record deleted!");
		}
	}

//--------------------------------------------------------------------------------------------------------------------------------------------

	public void UpdateAssetNumber(String AssetNumber) throws IOException {
		System.out.println("Inside 'UpdateAssetNumber()'");
		waitForFindElementPresent(AssetNumberLoc);
		AssetNumberLoc.clear();
		AssetNumberLoc.sendKeys(XLUtils.FetchExcelData(AssetNumber));
	}

	public void UpdateAssetSerialNumber(String AssetSerielNumber) throws IOException {
		System.out.println("Inside 'UpdateAssetSerialNumber()'");
		waitForFindElementPresent(AssetNumberLoc);
		AssetNumberLoc.clear();
		AssetNumberLoc.sendKeys(XLUtils.FetchExcelData(AssetSerielNumber));
	}

	public void UpdateLocation(String Location) throws IOException {
		System.out.println("Inside 'UpdateLocation()'");
		waitForFindElementPresent(AssetLocationLoc);
		// Create object of the Select class
		Select location = new Select(AssetLocationLoc);
		location.selectByVisibleText(XLUtils.FetchExcelData(Location));
	}

	public void UpdateAssetDescription(String AssetDescription) throws IOException {
		System.out.println("Inside 'UpdateAssetDescription()'");
		waitForFindElementPresent(AssetDescriptionLoc);
		AssetDescriptionLoc.clear();
		AssetDescriptionLoc.sendKeys(XLUtils.FetchExcelData(AssetDescription));
	}

	public void UpdateAssetGroup(String AssetGroup) throws IOException {
		System.out.println("Inside 'UpdateAssetGroup()'");
		waitForFindElementPresent(AssetGroupLoc);
		// Create object of the Select class
		Select AssetGP = new Select(AssetGroupLoc);
		AssetGP.selectByVisibleText(XLUtils.FetchExcelData(AssetGroup));
	}

	public void UpdateDepartment(String AssetDepartment) throws IOException {
		System.out.println("Inside 'UpdateDepartment()'");
		waitForFindElementPresent(AssetDepartmentLoc);
		// Create object of the Select class
		Select ADept = new Select(AssetDepartmentLoc);
		ADept.selectByVisibleText(XLUtils.FetchExcelData(AssetDepartment));
	}

	public void UpdateVendor(String AssetVendor) throws IOException {
		System.out.println("Inside 'UpdateVendor()'");
		waitForFindElementPresent(AssetVendorLoc);
		// Create object of the Select class
		Select AVendor = new Select(AssetVendorLoc);
		AVendor.selectByVisibleText(XLUtils.FetchExcelData(AssetVendor));
	}

	public void UpdateStatus(String AssetStatus) throws IOException {
		System.out.println("Inside 'UpdateVendor()'");
		waitForFindElementPresent(AssetStatusLoc);
		// Create object of the Select class
		Select AStatus = new Select(AssetStatusLoc);
		AStatus.selectByVisibleText(XLUtils.FetchExcelData(AssetStatus));
	}

	public void UpdateAssetType(String AssetType) throws IOException {
		System.out.println("Inside 'UpdateAssetType()'");
		waitForFindElementPresent(AssetTypeLoc);
		// Create object of the Select class
		Select AStatus = new Select(AssetTypeLoc);
		AStatus.selectByVisibleText(XLUtils.FetchExcelData(AssetType));
	}

	public void UpdateRemark(String AssetRemark) throws IOException {
		System.out.println("Inside 'UpdateRemark()'");
		waitForFindElementPresent(AssetRemarkLoc);
		// Create object of the Select class
		Select ARemark = new Select(AssetRemarkLoc);
		ARemark.selectByVisibleText(XLUtils.FetchExcelData(AssetRemark));
	}

	public void ClickCloseBtn() throws IOException {
		System.out.println("Inside 'ClickCloseBtn()'");
		
		waitForFindElementPresent(AssetCloseLoc);
		AssetCloseLoc.click();
	}

	public void UpdateSuccessfullyPopUpMessage(String ExpectedMessage) {
		System.out.println("Inside 'UpdateSuccessfullyPopUpMessage()'");
		
		waitForFindElementPresent(UpdateSuccessPopUp);
		
		// isDisplayed() method returns boolean value either True or False
		Boolean Display = UpdateSuccessPopUp.isDisplayed();
		
		// To print the value
		System.out.println("Successful Popup displayed :" + Display);

		String Mess = UpdateSuccessMessage.getText();
		// Assert to check that message is corrent
		Assert.assertEquals(Mess, ExpectedMessage);
		
		System.out.println("Successful Popup Message Matches -> " + Mess);
		
		// Click on OK button
		UpdateSuccessOKBtn.click();
	}

}
