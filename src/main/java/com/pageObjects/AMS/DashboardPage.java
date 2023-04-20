package com.pageObjects.AMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;

public class DashboardPage extends BasePage {
	LogInPage AMSLogin;
	CommonPage AMSComm;

	// Function to call the driver
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>LOCATORS<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

	// Cancel button update password pop up window
	@FindBy(xpath = "//button[starts-with(text(),'Cancel')]")
	WebElement CancelBtnUpdatePasswordPopUpLoc;

	// Dashboard home button Loc
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/parent::a")
	WebElement DashboardHomeTabBtnLoc;

// Master Module	
	// Master tab button dropdown Loc
	@FindBy(xpath = "//span[contains(text(),'Master')]/parent::a") // alternate option -> "//ul/li/a//span/i[@xpath=1]"
	WebElement MasterTabBtnLoc;

	// Assets tab Loc
	@FindBy(xpath = "//a[@href='#/home/assets'][contains(text(),'Assets')]") ///////////////// update xpath
	WebElement AssetsBtnLoc;

	// Employee Tab Loc
	@FindBy(xpath = "//a[@routerlink='/home/employee']")
	WebElement EmployeeBtnLoc;

	// Request Tab Loc
	@FindBy(xpath = "//*[contains(text(),'Request')][1]")
	WebElement RequestTabBtnLoc;

	// Assets Group Tab Loc
	@FindBy(xpath = "(//*[contains(text(),'Assets Group')])")
	WebElement AssetsGroupBtnLoc;

	// Assets Department Tab Loc
	@FindBy(xpath = "//*[contains(text(),'Assets Department')]")
	WebElement AssetsDepartmentBtnLoc;

	// Assets Vendor Tab Loc
	@FindBy(xpath = "//*[contains(text(),'Assets Vendor')]")
	WebElement AssetsVendorBtnLoc;

	// Assets Status Tab Loc
	@FindBy(xpath = "//*[contains(text(),'Assets Status')]")
	WebElement AssetsStatusBtnLoc;

	// User Tab Loc
	@FindBy(xpath = "//li[.='User']/child::a")
	WebElement UserBtnLoc;

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>METHODS<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

	// Click on Cancel Button on update password pop up window
	public void ClickCancelBtnOnChangePasswordPopup() throws InterruptedException {
		Thread.sleep(2000);
		waitForFindElementPresent(CancelBtnUpdatePasswordPopUpLoc);
		CancelBtnUpdatePasswordPopUpLoc.click();
	}

	// Home button on DashboardMainTest page
	public void ClickDashboardHomeBtn() throws InterruptedException {
		AMSComm = new CommonPage(driver);
		waitForFindElementPresent(DashboardHomeTabBtnLoc);
		DashboardHomeTabBtnLoc.click();
		System.out.println("Current Page URL is : " + AMSComm.getPageURL());
		System.out.println("Inside Dashboard Tab");
	}

	// Click on Master dropdown
	public void ClickMasterTabBtn() throws InterruptedException {
		Thread.sleep(2000);
		waitForFindElementPresent(MasterTabBtnLoc);
		MasterTabBtnLoc.click();
		System.out.println("Inside Master Tab");
	}

	// Click/Select Assets from Master Dropdown
	public void ClickAssetsfromMaster() {
		waitForFindElementPresent(AssetsBtnLoc);
		AssetsBtnLoc.click();
		System.out.println("Inside Assets Tab");
	}

	// Click/Select Assets from Master Dropdown
	public void ClickOnEmployeeTab() {
		waitForFindElementPresent(EmployeeBtnLoc);
		EmployeeBtnLoc.click();
		System.out.println("Inside Employee Tab");
	}

	// Click/Select Request from Master Dropdown
	public void ClickOnRequestTab() {
		waitForFindElementPresent(RequestTabBtnLoc);
		RequestTabBtnLoc.click();
		System.out.println("Inside Request Tab");
	}

	// Click/Select Assets Group from Master Dropdown
	public void ClickOnAssetsGroupTab() {
		waitForFindElementPresent(AssetsGroupBtnLoc);
		AssetsGroupBtnLoc.click();
		System.out.println("\nInside AssetsGroup Tab");
	}

	// Click/Select Assets Department from Master Dropdown
	public void ClickOnAssetsDepartmentTab() {
		waitForFindElementPresent(AssetsDepartmentBtnLoc);
		AssetsDepartmentBtnLoc.click();
		System.out.println("\nInside AssetsDepartment Tab");
	}

	// Click/Select Assets Vendor from Master Dropdown
	public void ClickOnAssetsVendorTab() {
		waitForFindElementPresent(AssetsVendorBtnLoc);
		AssetsVendorBtnLoc.click();
		System.out.println("\nInside AssetsVendor Tab");
	}

	// Click/Select Assets Status from Master Dropdown
	public void ClickOnAssetsStatusTab() {
		waitForFindElementPresent(AssetsStatusBtnLoc);
		AssetsStatusBtnLoc.click();
		System.out.println("\nInside AssetsStatus Tab");
	}

	// Click/Select User from Master Dropdown
	public void ClickOnUserTab() {
		waitForFindElementPresent(UserBtnLoc);
		UserBtnLoc.click();
		System.out.println("\nInside User Tab");
	}

}
