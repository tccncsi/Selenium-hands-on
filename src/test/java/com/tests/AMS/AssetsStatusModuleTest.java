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
	public void ExecuteAssetsStatusModuleTests() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetStatus = new AssetsStatusPage(driver);
		AMSComm.Print("Executing Assets Status Module Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDashboard.NavigateToDashboardPage();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		GetAllRowsPresent();
		CreateAssetsStatusTest();
		SearchAssetsStatusTest();
		UpdateAssetsStatusTest();
		DeleteAssetsStatusTest();

		AMSlogin.Logout();
		
		AMSComm.TotalTestCount("20", "5");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void GetAllRowsPresent() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("SearchAssetsStatusTest");
		AMSAssetStatus.ItemsPerPageDropDown("15");
		AMSComm.GetTableData("Asset Status");
	}

	public void CreateAssetsStatusTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("CreateAssetsStatusTest");
		AMSAssetStatus.ClickCreateAssetStatusButton();
		AMSAssetStatus.EnterAssetStatusName("AssetStatusName");
		AMSAssetStatus.ClickCreateButton();
		// AMSAssetStatus.ClickCancelButton();
		AMSComm.ValidateMessAfterCreated("SuccessMessAfterCreate");
	}

	public void SearchAssetsStatusTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("SearchAssetsStatusTest");
		AMSAssetStatus.ItemsPerPageDropDown("15");
		AMSAssetStatus.SearchAssetsStatus("AssetStatusName");
		AMSComm.GetTableData("Asset Status");
	}

	public void UpdateAssetsStatusTest() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("UpdateAssetsStatusTest");
		AMSAssetStatus.SearchAssetsStatus("AssetStatusName");
		AMSComm.GetTableData("Asset Status");
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
		AMSComm.GetTableData("Asset Status");
		AMSAssetStatus.ClickDeleteTooltip();
		AMSAssetStatus.YesDeleteIt("DeleteMessAfterDel");
	}
}
