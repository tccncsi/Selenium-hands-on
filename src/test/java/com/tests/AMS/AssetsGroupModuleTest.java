package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetsGroupPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class AssetsGroupModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetsGroupPage AMSAssetGrp;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void ExecuteAssetsGroupModuleTests() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetGrp = new AssetsGroupPage(driver);
		AMSComm.Print("Executing AssetsGroupModule Testcases...");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.NavigateToDashboardPage();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		CreateAssetsGroupTest();
		SearchAssetsGroupTest();
		UpdateAssetsGroupTest();
		DeleteAssetsGroupTest();

		AMSlogin.Logout();

		AMSComm.TotalTestCount("8", "4");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void CreateAssetsGroupTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("CreateAssetsGroupTest");
		AMSAssetGrp.ClickCreateAssetGroupButton();
		AMSAssetGrp.EnterAssetGroup("AssetsGroup");
		AMSAssetGrp.CheckTrue();
		AMSAssetGrp.ClickCreateButton();
		// AMSAssetGrp.ClickCancelButton();
		AMSAssetGrp.ValidateMessAfterCreateAssetGrp("SuccessMessAfterCreate");
	}

	public void SearchAssetsGroupTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.GetTableData("Assets Group");
		AMSComm.TestCaseName("SearchRequestTest");
		AMSAssetGrp.ItemsPerPageDropDown("15");
		AMSAssetGrp.SearchAssetsGroup("AssetsGroup");
		AMSComm.GetTableData("Assets Group");
	}

	public void UpdateAssetsGroupTest() throws IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("UpdateAssetsGroupTest");
		AMSAssetGrp.SearchAssetsGroup("AssetsGroup");
		AMSComm.GetTableData("Asset Group");
		AMSAssetGrp.ClickEditTooltip();
		AMSAssetGrp.EnterAssetGroupToUpdate("NewAssetsGroup");
		// AMSAssetGrp.ClickCancelButtonInUpdate();
		AMSAssetGrp.ClickUpdateButtonInUpdate();
		AMSAssetGrp.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteAssetsGroupTest() throws IOException, InterruptedException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("DeleteAssetsGroupTest");
		AMSAssetGrp.SearchAssetsGroup("NewAssetsGroup");
		AMSComm.GetTableData("Asset Group");
		AMSComm.ClickDeleteTooltip();
		AMSComm.YesDeleteIt("DeleteMessAfterDel");
	}
}
