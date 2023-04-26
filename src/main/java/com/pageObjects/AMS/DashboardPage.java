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

///* Elements on Dashboard Page

	// Cancel button update password pop up window
	@FindBy(xpath = "//button[starts-with(text(),'Cancel')]")
	WebElement CancelBtnUpdatePasswordPopUpLoc;

	// Dashboard home button Loc
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/parent::a")
	WebElement DashboardHomeTabBtnLoc;

	// NCS Logo
	@FindBy(xpath = "//img[@src='./assets/images/logoncsi.svg']")
	WebElement NCSLogoLoc;

	// Sidebar Toggle button
	@FindBy(xpath = "//a[contains(@class,'sidebar-toggle') and @role='button']")
	WebElement SideBarToggleLoc;

	// Notification bell icon
	@FindBy(xpath = "//i[@class='fa-solid fa-bell']")
	WebElement NotificationBelliconLoc;

	// Title on Tabs
	@FindBy(xpath = "//p[@class='title']")
	WebElement TabsTitleLoc;

///----------------------------------------------------------------------------------------------------------------------------

///* Inside Dashboard Page

	// Logged In User Name
	@FindBy(xpath = "//p[@class='name']")
	WebElement LoggedInUserNameLoc;

	// Dashboard Grid Elements
	@FindBy(xpath = "//div[@class='grids']/*[@class='col col-data']")
	WebElement DashboardElementsGrid;

	public String EleGrid = "//div[@class='grids']";
	public String Elements = "/*[@class='col col-data']";
	public String Ref = "/div/p";
	public String Count = "/div/span";

///----------------------------------------------------------------------------------------------------------------------------

///* Inside About Us Tab

	// # About Us Button
	@FindBy(xpath = "//a[contains(text(),'About us')]")
	WebElement AboutUsBtnLoc;

	// About Us Header
	@FindBy(xpath = "//p[@class='title']")
	WebElement AboutUsHeaderLoc;

	// Our Purpose (Information)
	@FindBy(xpath = "//p[@class='titles']")
	WebElement OurPurposeTitleLoc;
	@FindBy(xpath = "//span[@class='aboutclss']")
	WebElement OurPurposeInfoLoc;

	// Clients
	@FindBy(xpath = "(// div[@class='card-body'])[1]")
	WebElement ClientsCardLoc; // Element present or not
	@FindBy(xpath = "(// div[@class='card-body'])[1]/*[@class='card-title']")
	WebElement ClientsCardTitleLoc;
	@FindBy(xpath = "(// div[@class='card-body'])[1]/*[@class='card-text']")
	WebElement ClientsCardTextLoc;

	// Projects
	@FindBy(xpath = "(// div[@class='card-body'])[2]")
	WebElement ProjectsCardLoc; // Element present or not
	@FindBy(xpath = "(// div[@class='card-body'])[2]/*[@class='card-title']")
	WebElement ProjectsCardTitleLoc;
	@FindBy(xpath = "(// div[@class='card-body'])[2]/*[@class='card-text']")
	WebElement ProjectsCardTextLoc;

	// Hours Of support
	@FindBy(xpath = "(// div[@class='card-body'])[3]")
	WebElement HrsOfSupportCardLoc; // Element present or not
	@FindBy(xpath = "(// div[@class='card-body'])[3]/*[@class='card-title']")
	WebElement HrsOfSupportCardTitleLoc;
	@FindBy(xpath = "(// div[@class='card-body'])[3]/*[@class='card-text']")
	WebElement HrsOfSupportCardTextLoc;

	// Employees
	@FindBy(xpath = "(// div[@class='card-body'])[4]")
	WebElement EmployeesCardLoc; // Element present or not
	@FindBy(xpath = "(// div[@class='card-body'])[4]/*[@class='card-title']")
	WebElement EmployeesCardTitleLoc;
	@FindBy(xpath = "(// div[@class='card-body'])[4]/*[@class='card-text']")
	WebElement EmployeesCardTextLoc;

///----------------------------------------------------------------------------------------------------------------------------

///* Inside Contact Tab

	// Contact Button
	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement ContactButtonLoc;

	// Contact Us Header
	@FindBy(xpath = "//p[@class='title']")
	WebElement ContactUsHeaderLoc;

	// Location
	@FindBy(xpath = "(//div[contains(@class,'card')])[2]")
	WebElement LocationCardLoc; // Card
	@FindBy(xpath = "//*[@class='titlecard ']")
	WebElement LocationCardTitleLoc; // Card Title
	@FindBy(xpath = "//p[contains(text(),'NCSI Technologies (India)')]")
	WebElement LocationCardInfoLoc; // Card Information

	// Email
	@FindBy(xpath = "//div[@class='card']//div[@class='card-body']")
	WebElement EmailCardLoc; // Card
	@FindBy(xpath = "//*[contains(text(),'Email')]")
	WebElement EmailCardTitleLoc; // Card Title

	// Call
	@FindBy(xpath = "//div//*[contains(text(),'Call')]")
	WebElement CallElementLoc; // Card

///----------------------------------------------------------------------------------------------------------------------------

///----------------------------------------------------------------------------------------------------------------------------

// Inside Master Module	
	// Master tab button dropdown Loc
	@FindBy(xpath = "//span[contains(text(),'Master')]/parent::a")
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

///----------------------------------------------------------------------------------------------------------------------------

///* Inside Utility Module

	// # Utility Tab Button Drop Down
	@FindBy(xpath = "//span[contains(text(),'Utility')]")
	WebElement UtilityTabButtonLoc;

	// Bulk Asset Import Button
	@FindBy(xpath = "//a[contains(text(),'Bulk Asset Import')]")
	WebElement BulkAssetImportTabLoc;

	// Header of Bulk Asset Import Tab
	@FindBy(xpath = "//label[@class='heading']")
	WebElement HeadingBulkAssetImportLoc;

	// Bulk Employee Import Button
	@FindBy(xpath = "//a[contains(text(),'Bulk Employee Import')]")
	WebElement BulkEmployeeImportTabLoc;

	// Header of Bulk Employee Import Tab
	@FindBy(xpath = "//label[@class='heading']")
	WebElement HeadingBulkEmployeeImportLoc;

	// Utility Tracker Button
	@FindBy(xpath = "//a[contains(text(),'Utility Tracker')]")
	WebElement UtilityTrackerTabLoc;

///----------------------------------------------------------------------------------------------------------------------------

///* Inside Reports Module

	// # Reports Module Button
	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	WebElement ReportsModuleBtnLoc;

	// Audit Track Button
	@FindBy(xpath = "//a[contains(text(),'Audit Track')]")
	WebElement AudioTrackBtnLoc;

	// Asset Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset Report')]")
	WebElement AudioReportBtnLoc;

	// Asset Transfer Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset Transfer Report')]")
	WebElement AssetTransfrReportBtnLoc;

	// Asset Group Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset Group Report')]")
	WebElement AssetGroupReportBtnLoc;

	// Employee Report Button
	@FindBy(xpath = "//a[contains(text(),'Employee Report')]")
	WebElement EmployeeReportBtnLoc;

	// Asset Department Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset department Report')]")
	WebElement AssetDepartReportBtnLoc;

	// Asset Vendor Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset Vendor Report')]")
	WebElement AssetVendorReportBtnLoc;

	// Asset Status Report Button
	@FindBy(xpath = "//a[contains(text(),'Asset Status Report')]")
	WebElement AssetStatusReportBtnLoc;

	// Users Report Button
	@FindBy(xpath = "//a[contains(text(),'Users Report')]")
	WebElement UsersReportBtnLoc;

	// Login Tracker Button
	@FindBy(xpath = "//a[contains(text(),'Login Tracker')]")
	WebElement LoginTrackerBtnLoc;

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
