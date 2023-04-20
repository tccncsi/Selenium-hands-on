package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetsVendorPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class AssetsVendorModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetsVendorPage AMSAssetsVendor;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void AssetsGroupModuleTestExecution() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetsVendor = new AssetsVendorPage(driver);

		AMSComm.Print(
				"\nExecute All AssetsGroup Module related Test Cases\n--------------------------------------------------");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		CreateAssetsVendorTest();
		SearchAssetsVendorTest();
		UpdateAssetsVendorTest();
		DeleteAssetsVendorTest();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void CreateAssetsVendorTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsVendorTab();
		AMSComm.TestCaseName("CreateAssetsVendorTest");
		AMSAssetsVendor.ClickCreateAssetVendorButton();
		AMSAssetsVendor.EnterAssetVendorName("AssetVendorName");
		AMSAssetsVendor.EnterAssetVendorCode("AssetVendorCode");
		AMSAssetsVendor.ClickCreateButton();
		// AMSAssetDepart.ClickCancelButton();
		AMSAssetsVendor.ValidateMessAfterAssetVendor("SuccessMessAfterCreate");
	}

	public void SearchAssetsVendorTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsVendorTab();
		AMSComm.TestCaseName("SearchAssetsVendorTest");
		AMSAssetsVendor.ItemsPerPageDropDown("15");
		AMSAssetsVendor.SearchAssetsVendor("AssetVendorName");
		AMSAssetsVendor.VerifyRecordIsPresent();
		AMSAssetsVendor.GetRowData();
	}

	public void UpdateAssetsVendorTest() throws IOException {
		AMSDashboard.ClickOnAssetsVendorTab();
		AMSComm.TestCaseName("UpdateAssetsVendorTest");
		AMSAssetsVendor.SearchAssetsVendor("AssetVendorName");
		AMSAssetsVendor.VerifyRecordIsPresent();
		AMSAssetsVendor.ClickEditTooltip();
		AMSAssetsVendor.EnterAssetVendorNameToUpdate("NewAssetVendorName");
		AMSAssetsVendor.EnterAssetVendorCodeToUpdate("NewAssetVendorCode");
		// AMSAssetDepart.ClickCancelButtonInUpdate();
		AMSAssetsVendor.ClickUpdateButtonInUpdate();
		AMSAssetsVendor.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteAssetsVendorTest() throws IOException {
		AMSDashboard.ClickOnAssetsVendorTab();
		AMSComm.TestCaseName("DeleteAssetsVendorTest");
		AMSAssetsVendor.SearchAssetsVendor("NewAssetVendorName");
		AMSAssetsVendor.VerifyRecordIsPresent();
		AMSAssetsVendor.GetRowData();
		AMSAssetsVendor.ClickDeleteTooltip();
		AMSAssetsVendor.YesDeleteIt("DeleteMessAfterDel");
	}

}
