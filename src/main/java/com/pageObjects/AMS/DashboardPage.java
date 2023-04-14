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

	// UpdatePasswordPopUp Close button Loc
	@FindBy(xpath = "//button[1]")
	WebElement UpdatePasswordPopUp;

	// DashboardMainTest home button Loc
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]/parent::a")
	WebElement DashboardHomeTabBtnLoc;

	// Master tab button dropdown Loc
	@FindBy(xpath = "//span[contains(text(),'Master')]/parent::a") // alternate option -> "//ul/li/a//span/i[@xpath=1]"
	WebElement MasterTabBtnLoc;

	// Assets tab Loc
	@FindBy(xpath = "//a[@href='#/home/assets'][contains(text(),'Assets')]")
	WebElement AssetsBtnLoc;

	// Cancel button update password pop up window
	@FindBy(xpath = "//button[starts-with(text(),'Cancel')]")
	WebElement CancelBtnUpdatePasswordPopUpLoc;
	
	// Employee Tab Loc
	@FindBy(xpath = "//a[@routerlink='/home/employee']")
	WebElement EmployeeBtnLoc;
	
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
		System.out.println("On DashboardMainTest");
		System.out.println("Current Page URL is : " + AMSComm.getPageURL());
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
		System.out.println("Inside Assets Tab\n");
	}
	
	// Click/Select Assets from Master Dropdown
	public void ClickOnEmployeeTab() {
		waitForFindElementPresent(EmployeeBtnLoc);
		EmployeeBtnLoc.click();
		System.out.println("Inside Employee Tab\n");
	}
}
