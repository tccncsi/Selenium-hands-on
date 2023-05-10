package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class DashboardModuleTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDash;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteDashboardTests() throws Exception {

		// Objects of Required Pages
		AMSlogin = new LogInPage(driver);
		AMSDash = new DashboardPage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.Print("Executing Dashboard Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDash.NavigateToDashboardPage();

		// Execute DashboardMainPageTest
		DashboardMainPageTest();
		AboutUsModuleTest();
		ContactModuleTest();
		MasterModuleTest();
		UtilityModuleTest();
		ReportsModuleTest();
		FindGridElementsTest();

		AMSlogin.Logout();

		AMSComm.TotalTestCount("4", "7");
	}

	public void DashboardMainPageTest() throws NumberFormatException, IOException, InterruptedException {
		AMSComm.TestCaseName("DashboardMainPageTest()");
		AMSComm.ManualTestCount("1");
		AMSDash.NavigateToDashboardPage();
		AMSDash.ClickSidebarToggleButton();
		AMSDash.AssertLoggedInUsername(XLUtils.FetchExcelData("AMSUsername"));
		AMSDash.TextsOnDashboard();
		AMSDash.ClickNotificationBell();
	}

	public void AboutUsModuleTest() throws InterruptedException {
		AMSComm.TestCaseName("AboutUsModuleTest()");
		AMSComm.ManualTestCount("0");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.ClickAboutUsBtn();
		AMSDash.ValidateAboutUsHeader();
		AMSDash.ValidateOurPurposeText();
		AMSDash.ValidateClientsCardElements();
		AMSDash.ValidateProjectsCardElements();
		AMSDash.ValidateHoursCardElements();
		AMSDash.ValidateEmployeeCardElements();
	}

	public void ContactModuleTest() throws InterruptedException {
		AMSComm.TestCaseName("ContactModuleTest()");
		AMSComm.ManualTestCount("0");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.ClickContactBtn();
		AMSDash.ValidateContactUsHeader();
		AMSDash.ValidateLocationCardElements();
		AMSDash.ValidateEmailCardElements();
		AMSDash.ValidateCallCardElements();
	}

	public void MasterModuleTest() throws InterruptedException {
		AMSComm.TestCaseName("MasterModuleTest()");
		AMSComm.ManualTestCount("1");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.ClickMasterTabBtn();
		// Inside Master verify each module/tab button is clickable
		AMSDash.ClickOnAssetsTab();
		AMSDash.ClickOnEmployeeTab();
		AMSDash.ClickOnRequestTab();
		AMSDash.ClickOnAssetsGroupTab();
		AMSDash.ClickOnAssetsDepartmentTab();
		AMSDash.ClickOnAssetsVendorTab();
		AMSDash.ClickOnAssetsStatusTab();
		AMSDash.ClickOnUserTab();
	}

	public void UtilityModuleTest() throws InterruptedException {
		AMSComm.TestCaseName("UtilityModuleTest()");
		AMSComm.ManualTestCount("1");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.ClickUtilityTabBtn();
		// Inside Utility verify each module/tab button is clickable
		AMSDash.ClickOnBulkAssetImportTab();
		AMSDash.ClickOnBulkEmployeeImportTab();
		AMSDash.ClickOnUtilityTrackerTab();
	}

	public void FindGridElementsTest() throws InterruptedException {
		AMSComm.TestCaseName("FindGridElementsTest()");
		AMSComm.ManualTestCount("0");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.FindGridElements("1");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.FindGridElements("2");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.FindGridElements("3");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.FindGridElements("4");
	}

	public void ReportsModuleTest() throws InterruptedException {
		AMSComm.TestCaseName("ReportsModuleTest()");
		AMSComm.ManualTestCount("1");
		AMSDash.ClickDashboardHomeBtn();
		AMSDash.ClickReportsTab();
		AMSDash.ClickOnAuditTrackBtn();
		AMSDash.ClickOnAssetReportBtn();
		AMSDash.ClickOnAssetTransferReportBtn();
		AMSDash.ClickOnAssetGroupReportBtn();
		AMSDash.ClickOnEmployeeReportBtn();
		AMSDash.ClickOnAssetDepartmentReportBtn();
		AMSDash.ClickOnAssetVendorReportBtn();
		AMSDash.ClickOnAssetStatusReportBtn();
		AMSDash.ClickOnUsersReportBtn();
		AMSDash.ClickOnLoginTrackerBtn();
	}
}
