package com.pageObjects.AMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BasePage;

public class DashboardPage extends BasePage {
	LogInPage AMSLogin;
	CommonPage AMSComm;

	// Function to call the driver
	public DashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//||>LOCATORS<||\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\*//^\\

///* Elements on Dashboard Page

	// Cancel button update password pop-up window
	@FindBy(xpath = "//button[starts-with(text(),'Cancel')]")
	WebElement CancelBtnUpdatePasswordPopUpLoc;

	// Dashboard home button Loc
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/parent::a")
	WebElement DashboardHomeTabBtnLoc;

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
	@FindBy(xpath = "//*[contains(text(),'Welcom')]")
	WebElement LoggedInUserNameLoc;

	// Dashboard Grid Elements
	@FindBy(xpath = "//div[@class='grids']/*[@class='col col-data']")
	WebElement DashboardElementsGrid;

	public String EleGridElements = "//div[@class='grids']/*[@class='col col-data']";
	public String Count = "/div/p";
	public String Ref = "/div/span";

	@FindBy(xpath = "//div[@class=\"charts mt-2\"]/p")
	WebElement SecondChartOnDashLoc;
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

	// Hours Of Support
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
	@FindBy(xpath = "//div[@class='col mt-4'][1]//div[@class='card']")
	WebElement EmailCardLoc; // Card
	@FindBy(xpath = "//div[@class='col mt-4'][1]//div[@class='card']//*[@class='titlecard']")
	WebElement EmailCardTitleLoc; // Card Title
	@FindBy(xpath = "//div[@class='col mt-4'][1]//div[@class='card']//span[@class='text-left mt-2']")
	WebElement EmailValue;

	// Call
	@FindBy(xpath = "//div[@class='col mt-4'][2]//div[@class='card']")
	WebElement CallCardLoc; // Card
	@FindBy(xpath = "//div[@class='col mt-4'][2]//div[@class='card']//*[@class='titlecard']")
	WebElement CallTitleLoc;
	@FindBy(xpath = "//div[@class='col mt-4'][2]//div[@class='card']//span[@class='text-left mt-2']")
	WebElement CallValueLoc;

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
	@FindBy(xpath = "//*[contains(text(),'Bulk Asset Import')]")
	WebElement BulkAssetImportTabLoc;

	// Header of Bulk Asset Import Tab
	@FindBy(xpath = "//div//label[@class='heading']")
	WebElement HeadingBulkAssetImportLoc;

	// Bulk Employee Import Button
	@FindBy(xpath = "//*[contains(text(),'Bulk Employee Import')]")
	WebElement BulkEmployeeImportTabLoc;

	// Header of Bulk Employee Import Tab
	@FindBy(xpath = "//div//label[@class='heading']")
	WebElement HeadingBulkEmployeeImportLoc;

	// Utility Tracker Button
	@FindBy(xpath = "//*[contains(text(),'Utility Tracker')]")
	WebElement UtilityTrackerTabLoc;

	// Utility Tracker Header
	@FindBy(xpath = "//*[@class='title']")
	WebElement UtilityTrackerHeaderLoc;

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

///* On Dashboard page

	// Navigate to The dashboard page
	public void NavigateToDashboardPage() {
		waitForFindElementPresent(DashboardHomeTabBtnLoc);
		DashboardHomeTabBtnLoc.click();
		AMSComm = new CommonPage(driver);
		System.out.println("Current Page URL is : " + AMSComm.getPageURL());
		System.out.println("Inside Dashboard Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Dashboard");
		System.out.println("Current page header : " + HederMess);
	}

	// Click on the Cancel Button on the update password pop-up window
	public void ClickCancelBtnOnChangePasswordPopup() throws InterruptedException {
		Thread.sleep(1000);
		waitForFindElementPresent(CancelBtnUpdatePasswordPopUpLoc);
		CancelBtnUpdatePasswordPopUpLoc.click();
	}

	// Home button on the Dashboard page
	public void ClickDashboardHomeBtn() throws InterruptedException {
		waitForFindElementPresent(DashboardHomeTabBtnLoc);
		DashboardHomeTabBtnLoc.click();
	}

	// Click on the Sidebar Toggle button
	public void ClickSidebarToggleButton() throws InterruptedException {
		waitForFindElementPresent(SideBarToggleLoc);
		SideBarToggleLoc.click();
	}

	// Click the Notification bell icon
	public void ClickNotificationBell() throws InterruptedException {
		waitForFindElementPresent(NotificationBelliconLoc);
		NotificationBelliconLoc.click();
		System.out.println("Clicked on Notification Bell");
		System.out.println("Current page title : " + TabsTitleLoc.getText());
	}

	// Validate the logged-in username on the dashboard
	public void AssertLoggedInUsername(String Username) {
		String ActualUsrname = LoggedInUserNameLoc.getText();
		Assert.assertEquals(ActualUsrname, "Welcome " + Username);
		System.out.println("Logged in UserName : " + ActualUsrname);
	}

	// Second chart present on dashboard home page
	public void TextsOnDashboard() {
		System.out.println("Second Chart Title : " + SecondChartOnDashLoc.getText());
	}

	// Find Grids and verify whether the lelementsclickable or not
	public void FindGridElements(String Gridnum) throws InterruptedException {
		ClickDashboardHomeBtn();
		// To locate the Grid
		WebElement myGrids = driver.findElement(By.xpath(EleGridElements + "[" + Gridnum + "]"));
		WebElement myGridElement1 = driver.findElement(By.xpath(EleGridElements + "[" + Gridnum + "]" + Count));
		WebElement myGridElement2 = driver.findElement(By.xpath(EleGridElements + "[" + Gridnum + "]" + Ref));
		System.out.println("Grid Reference : " + myGridElement2.getText());
		System.out.println("Grid Value : " + myGridElement1.getText());
		myGrids.click();
	}

///* About Us

	// Click About Us Button
	public void ClickAboutUsBtn() {
		waitForFindElementPresent(AboutUsBtnLoc);
		AboutUsBtnLoc.click();
	}

	// About Us Header
	public void ValidateAboutUsHeader() {
		waitForFindElementPresent(AboutUsHeaderLoc);
		System.out.println("Header -> " + AboutUsHeaderLoc.getText());
	}

	// Our Purpose (Title + Information)
	public void ValidateOurPurposeText() {
		waitForFindElementPresent(OurPurposeTitleLoc);
		waitForFindElementPresent(OurPurposeInfoLoc);
		System.out.println("Title : " + OurPurposeTitleLoc.getText());
		System.out.println("Information : " + OurPurposeInfoLoc.getText());
	}

	// Clients (Card + Title + Text)
	public void ValidateClientsCardElements() {
		waitForFindElementPresent(ClientsCardLoc);
		waitForFindElementPresent(ClientsCardTitleLoc);
		waitForFindElementPresent(ClientsCardTextLoc);
		// Check Clients card is displayed or not
		ClientsCardLoc.isDisplayed();
		System.out.println("Clients Card is present");
		// Get the Clients card's title and text
		System.out.println("Card Title : " + ClientsCardTitleLoc.getText());
		System.out.println("Reference : " + ClientsCardTextLoc.getText());
	}

	// Project (Card + Title + Text)
	public void ValidateProjectsCardElements() {
		waitForFindElementPresent(ProjectsCardLoc);
		waitForFindElementPresent(ProjectsCardTitleLoc);
		waitForFindElementPresent(ProjectsCardTextLoc);
		// Check whether Clients cdisplayedlayd or not
		ProjectsCardLoc.isDisplayed();
		System.out.println("Project Card is present");
		// Get the Project card's title and text
		System.out.println("Card Title : " + ProjectsCardTitleLoc.getText());
		System.out.println("Reference : " + ProjectsCardTextLoc.getText());
	}

	// Hours Of support (Card + Title + Text)
	public void ValidateHoursCardElements() {
		waitForFindElementPresent(HrsOfSupportCardLoc);
		waitForFindElementPresent(HrsOfSupportCardTitleLoc);
		waitForFindElementPresent(HrsOfSupportCardTextLoc);
		// Check Clients cis displayed and or not
		HrsOfSupportCardLoc.isDisplayed();
		System.out.println("Hours Of support Card is present");
		// Get Hours Of support card's title and text
		System.out.println("Card Title : " + HrsOfSupportCardTitleLoc.getText());
		System.out.println("Reference : " + HrsOfSupportCardTextLoc.getText());
	}

	// Employees (Card + Title + Text)
	public void ValidateEmployeeCardElements() {
		waitForFindElementPresent(EmployeesCardLoc);
		waitForFindElementPresent(EmployeesCardTitleLoc);
		waitForFindElementPresent(EmployeesCardTextLoc);
		// Check Clients card is displayed or not
		EmployeesCardLoc.isDisplayed();
		System.out.println("Employees Card is present");
		// Gthe et Employees card's title and text
		System.out.println("Card Title : " + EmployeesCardTitleLoc.getText());
		System.out.println("Reference : " + EmployeesCardTextLoc.getText());
	}

///* Contact

	// Clthe ick Contact Button
	public void ClickContactBtn() {
		waitForFindElementPresent(ContactButtonLoc);
		ContactButtonLoc.click();
	}

	// Contact Us Header
	public void ValidateContactUsHeader() {
		waitForFindElementPresent(ContactUsHeaderLoc);
		System.out.println("Title : " + ContactUsHeaderLoc.getText());
	}

	// Location (Card + Title + Text)
	public void ValidateLocationCardElements() {
		waitForFindElementPresent(LocationCardLoc);
		waitForFindElementPresent(LocationCardTitleLoc);
		waitForFindElementPresent(LocationCardInfoLoc);
		// Check Location cis and display or not
		LocationCardLoc.isDisplayed();
		System.out.println("Location Card is present");
		// Get the Location card's title and text
		System.out.println("Card Title : " + LocationCardTitleLoc.getText());
		System.out.println("Reference : " + LocationCardInfoLoc.getText());
	}

	// Email (Card + Title + Text)
	public void ValidateEmailCardElements() {
		waitForFindElementPresent(EmailCardLoc);
		// Check Email card is displayed or not
		EmailCardLoc.isDisplayed();
		System.out.println("Email Card is present");
		// Get the Email card's title and text
		System.out.println("Card Title : " + EmailCardTitleLoc.getText());
		System.out.println("Reference : " + EmailValue.getText());
	}

	// Call (Card + Title + Text)
	public void ValidateCallCardElements() {
		waitForFindElementPresent(CallCardLoc);
		// Check Call card is displayed or not
		CallCardLoc.isDisplayed();
		System.out.println("Call Card is present");
		// Get the Call card's title and text
		System.out.println("Card Title : " + CallTitleLoc.getText());
		System.out.println("Reference : " + CallValueLoc.getText());
	}

///* Master Module

	// Click on Master dropdown
	public void ClickMasterTabBtn() throws InterruptedException {
		waitForFindElementPresent(MasterTabBtnLoc);
		MasterTabBtnLoc.click();
		System.out.println("Inside Master Tab");
	}

	// Click/Select Assets from Master Dropdown
	public void ClickOnAssetsTab() {
		waitForFindElementPresent(AssetsBtnLoc);
		AssetsBtnLoc.click();
		System.out.println("Inside Assets Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Assets");
	}

	// Click/Select Assets from Master Dropdown
	public void ClickOnEmployeeTab() {
		waitForFindElementPresent(EmployeeBtnLoc);
		EmployeeBtnLoc.click();
		System.out.println("Inside Employee Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Employee");
	}

	// Click/Select Request from Master Dropdown
	public void ClickOnRequestTab() {
		waitForFindElementPresent(RequestTabBtnLoc);
		RequestTabBtnLoc.click();
		System.out.println("Inside Request Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Request");
	}

	// Click/Select Assets Group from Master Dropdown
	public void ClickOnAssetsGroupTab() {
		waitForFindElementPresent(AssetsGroupBtnLoc);
		AssetsGroupBtnLoc.click();
		System.out.println("Inside AssetsGroup Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Asset Group");
	}

	// Click/Select Assets Department from Master Dropdown
	public void ClickOnAssetsDepartmentTab() {
		waitForFindElementPresent(AssetsDepartmentBtnLoc);
		AssetsDepartmentBtnLoc.click();
		System.out.println("Inside AssetsDepartment Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Asset Department");
	}

	// Click/Select Assets Vendor from Master Dropdown
	public void ClickOnAssetsVendorTab() {
		waitForFindElementPresent(AssetsVendorBtnLoc);
		AssetsVendorBtnLoc.click();
		System.out.println("Inside AssetsVendor Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Vendor");
	}

	// Click/Select Assets Status from Master Dropdown
	public void ClickOnAssetsStatusTab() {
		waitForFindElementPresent(AssetsStatusBtnLoc);
		AssetsStatusBtnLoc.click();
		System.out.println("Inside AssetsStatus Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Asset Status");
	}

	// Click/Select User from Master Dropdown
	public void ClickOnUserTab() {
		waitForFindElementPresent(UserBtnLoc);
		UserBtnLoc.click();
		System.out.println("Inside User Tab");
		// Header of the page
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Users");
	}

///* Utility Module

	// Click on Utility dropdown/button
	public void ClickUtilityTabBtn() throws InterruptedException {
		waitForFindElementPresent(UtilityTabButtonLoc);
		UtilityTabButtonLoc.click();
		System.out.println("Inside Utility Tab");
	}

	// Bulk Asset Import Button
	public void ClickOnBulkAssetImportTab() {
		waitForFindElementPresent(BulkAssetImportTabLoc);
		BulkAssetImportTabLoc.click();
		System.out.println("Inside BulkAssetImport Tab");
		/*
		 * // Header of Bulk Asset Import Tab String HederMess =
		 * HeadingBulkAssetImportLoc.getText(); Assert.assertEquals(HederMess,
		 * "Import Asset Details");
		 * System.out.println("Header Message on current page : " + HederMess);
		 */
	}

	// Bulk Employee Import Button
	public void ClickOnBulkEmployeeImportTab() {
		waitForFindElementPresent(BulkEmployeeImportTabLoc);
		BulkEmployeeImportTabLoc.click();
		System.out.println("Inside BulkEmployeeImport Tab");
		/*
		 * // Header of Bulk Employee Import Tab String HederMess =
		 * HeadingBulkEmployeeImportLoc.getText(); Assert.assertEquals(HederMess,
		 * "Import Employee Details");
		 * System.out.println("Header Message on current page : " + HederMess);
		 */
	}

	// Utility Tracker Button
	public void ClickOnUtilityTrackerTab() {
		waitForFindElementPresent(UtilityTrackerTabLoc);
		UtilityTrackerTabLoc.click();
		System.out.println("Inside UtilityTracker Tab");
		// Header of Bulk Utility Tracker Tab
		String HederMess = TabsTitleLoc.getText();
		Assert.assertEquals(HederMess, "Utility Tracker");
		System.out.println("Header Message on current page : " + HederMess);
	}

// Reports Tab

	// Click Reports Link
	public void ClickReportsTab() {
		waitForFindElementPresent(ReportsModuleBtnLoc);
		ReportsModuleBtnLoc.click();
		System.out.println("Inside ClickReportsTab Tab");
	}

	// Audit Track
	public void ClickOnAuditTrackBtn() {
		waitForFindElementPresent(AudioTrackBtnLoc);
		AudioTrackBtnLoc.click();
		System.out.println("Inside Audio Track Tab");
	}

	// Asset Report Button
	public void ClickOnAssetReportBtn() {
		waitForFindElementPresent(AudioReportBtnLoc);
		AudioReportBtnLoc.click();
		System.out.println("Inside Asset Report Tab");
	}

	// Asset Transfer Report
	public void ClickOnAssetTransferReportBtn() {
		waitForFindElementPresent(AssetTransfrReportBtnLoc);
		AssetTransfrReportBtnLoc.click();
		System.out.println("Inside Asset Transfer Report Tab");
	}

	// Asset Group Report
	public void ClickOnAssetGroupReportBtn() {
		waitForFindElementPresent(AssetGroupReportBtnLoc);
		AssetGroupReportBtnLoc.click();
		System.out.println("Inside Asset Group Report Tab");
	}

	// Employee Report Button
	public void ClickOnEmployeeReportBtn() {
		waitForFindElementPresent(EmployeeReportBtnLoc);
		EmployeeReportBtnLoc.click();
		System.out.println("Inside Employee Report Tab");
	}

	// Asset Department Report Button
	public void ClickOnAssetDepartmentReportBtn() {
		waitForFindElementPresent(AssetDepartReportBtnLoc);
		AssetDepartReportBtnLoc.click();
		System.out.println("Inside Asset Department Report Tab");
	}

	// Asset Vendor Report Button
	public void ClickOnAssetVendorReportBtn() {
		waitForFindElementPresent(AssetVendorReportBtnLoc);
		AssetVendorReportBtnLoc.click();
		System.out.println("Inside Asset Vendor Report Tab");
	}

	// Asset Status Report Button
	public void ClickOnAssetStatusReportBtn() {
		waitForFindElementPresent(AssetStatusReportBtnLoc);
		AssetStatusReportBtnLoc.click();
		System.out.println("Inside Asset Status Report Tab");
	}

	// Users Report Button
	public void ClickOnUsersReportBtn() {
		waitForFindElementPresent(UsersReportBtnLoc);
		UsersReportBtnLoc.click();
		System.out.println("Inside Users Report Tab");
	}

	// Login Tracker Button
	public void ClickOnLoginTrackerBtn() {
		waitForFindElementPresent(LoginTrackerBtnLoc);
		LoginTrackerBtnLoc.click();
		System.out.println("Inside Login Tracker Tab");
	}
}
