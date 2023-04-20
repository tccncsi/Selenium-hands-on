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
	public void AssetsGroupModuleTestExecution() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetGrp = new AssetsGroupPage(driver);

		AMSComm.Print(
				"\nExecute All AssetsGroup Module related Test Cases\n--------------------------------------------------");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		CreateAssetsGroupTest();
		SearchAssetsGroupTest();
		UpdateAssetsGroupTest();
		DeleteAssetsGroupTest();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void CreateAssetsGroupTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("CreateAssetsGroupTest");
		AMSAssetGrp.ClickCreateAssetGroupButton();
		AMSAssetGrp.EnterAssetGroup("AssetGroup");
		AMSAssetGrp.CheckTrue();
		AMSAssetGrp.ClickCreateButton();
		// AMSAssetGrp.ClickCancelButton();
		AMSAssetGrp.ValidateMessAfterCreateAssetGrp("SuccessMessAfterCreate");
	}

	public void SearchAssetsGroupTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("SearchRequestTest");
		AMSAssetGrp.ItemsPerPageDropDown("15");
		AMSAssetGrp.SearchAssetsGroup("AssetGroup");
		AMSAssetGrp.VerifyRecordIsPresent();
		AMSAssetGrp.GetRowData();
	}

	public void UpdateAssetsGroupTest() throws IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("UpdateAssetsGroupTest");
		AMSAssetGrp.SearchAssetsGroup("AssetGroup");
		AMSAssetGrp.VerifyRecordIsPresent();
		AMSAssetGrp.ClickEditTooltip();
		AMSAssetGrp.EnterAssetGroupToUpdate("NewAssetGroup");
		// AMSAssetGrp.ClickCancelButtonInUpdate();
		AMSAssetGrp.ClickUpdateButtonInUpdate();
		AMSAssetGrp.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteAssetsGroupTest() throws IOException {
		AMSDashboard.ClickOnAssetsGroupTab();
		AMSComm.TestCaseName("DeleteAssetsGroupTest");
		AMSAssetGrp.SearchAssetsGroup("NewAssetGroup");
		AMSAssetGrp.VerifyRecordIsPresent();
		AMSAssetGrp.ClickDeleteTooltip();
		AMSAssetGrp.YesDeleteIt("DeleteMessAfterDel");
	}
}
