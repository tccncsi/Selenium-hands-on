package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetsStatusPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class AssetsStatusModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetsStatusPage AMSAssetStatus;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void AssetsGroupModuleTestExecution() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetStatus = new AssetsStatusPage(driver);

		AMSComm.Print(
				"\nExecute All AssetsGroup Module related Test Cases\n--------------------------------------------------");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		GetAllRowsPresent();
		CreateAssetsStatusTest();
		SearchAssetsStatusTest();
		UpdateAssetsStatusTest();
		DeleteAssetsStatusTest();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void GetAllRowsPresent() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("SearchAssetsStatusTest");
		AMSAssetStatus.ItemsPerPageDropDown("15");
		AMSAssetStatus.VerifyRecordIsPresent();
		AMSAssetStatus.GetRowData();
	}
	
	public void CreateAssetsStatusTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("CreateAssetsStatusTest");
		AMSAssetStatus.ClickCreateAssetStatusButton();
		AMSAssetStatus.EnterAssetStatusName("AssetStatusName");
		AMSAssetStatus.ClickCreateButton();
		// AMSAssetStatus.ClickCancelButton();
		AMSAssetStatus.ValidateMessAfterAssetStatus("SuccessMessAfterCreate");
	}

	public void SearchAssetsStatusTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("SearchAssetsStatusTest");
		AMSAssetStatus.ItemsPerPageDropDown("15");
		AMSAssetStatus.SearchAssetsStatus("AssetStatusName");
		AMSAssetStatus.VerifyRecordIsPresent();
		AMSAssetStatus.GetRowData();
	}

	public void UpdateAssetsStatusTest() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("UpdateAssetsStatusTest");
		AMSAssetStatus.SearchAssetsStatus("AssetStatusName");
		AMSAssetStatus.VerifyRecordIsPresent();
		AMSAssetStatus.ClickEditTooltip();
		AMSAssetStatus.EnterAssetStatusNameToUpdate("NewAssetStatusName");
		// AMSAssetStatus.ClickCancelButtonInUpdate();
		AMSAssetStatus.ClickUpdateButtonInUpdate();
		AMSAssetStatus.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteAssetsStatusTest() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("DeleteAssetsStatusTest");
		AMSAssetStatus.SearchAssetsStatus("NewAssetStatusName");
		AMSAssetStatus.VerifyRecordIsPresent();
		AMSAssetStatus.GetRowData();
		AMSAssetStatus.ClickDeleteTooltip();
		AMSAssetStatus.YesDeleteIt("DeleteMessAfterDel");
	}
}
