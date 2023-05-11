package com.tests.AMS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class AssetModuleTest extends BaseClass {

	LogInPage AMSlogin;
	DashboardPage AMSDash;
	AssetPage AMSAssets;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteAssetModuleTests() throws Exception {

		// Objects of Required Pages
		AMSlogin = new LogInPage(driver);
		AMSDash = new DashboardPage(driver);
		AMSComm = new CommonPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm.Print("Executing AssetModule Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDash.NavigateToDashboardPage();
		AMSDash.ClickMasterTabBtn();

//		Execute all Asset Module Tests
		GetAllRowsPresent();
		ClickCancelBtnOnCreateAsset();
		CreateAssetTest();
		SearchAssetTest();
		UpdateAssetTest();
		DeleteAssetTest();

		AMSlogin.Logout();
		AMSComm.TotalTestCount("18", "6");
	}

/// Get all the rows present on the asset's main page
	public void GetAllRowsPresent() throws IOException {
		AMSComm.TestCaseName("GetAllRowsPresent()");
		AMSComm.ManualTestCount("1");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.SelectItemFromItemsPerPageDropDown("25");
		AMSComm.VerifyRecordIsPresent();
		AMSComm.GetRowData("All Assets");
	}

/// Cancel on Create Asset
	public void ClickCancelBtnOnCreateAsset() {
		AMSComm.TestCaseName("ClickCancelBtnOnCreateAsset");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.ClickonCreateAssetBtn();
		AMSAssets.ClickOnCancelButton();
	}

/// Create
	public void CreateAssetTest() throws InterruptedException, IOException {
		AMSComm.TestCaseName("CreateAssetTest");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.ClickonCreateAssetBtn();
		// Fill out the form //
		AMSAssets.EnterAssetNumber("AssetNumber");
		AMSAssets.EnterAssetSerialNumber("AssetSerialNumber");
		AMSAssets.SelectLocation("Location");
		AMSAssets.EnterAssetDescription("AssetDescription");
		AMSAssets.SelectAssetGroup("AssetGroup");
		AMSAssets.SelectDepartment("Department");
		AMSAssets.SelectVendor("Vendor");
		AMSAssets.SelectAssetType("AssetType");
		AMSAssets.EnterCount("Count");
		AMSAssets.EnterRemark("Remark");
		AMSAssets.ClickOnCreateButton();
		AMSComm.ValidateMessAfterCreated("SuccessMessAfterCreate");
	}

/// Read
	public void SearchAssetTest() throws NumberFormatException, IOException, InterruptedException {
		AMSComm.TestCaseName("SearchAssetTest()");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSComm.GetTableData("Assets");
	}

/// Update
	public void UpdateAssetTest() throws NumberFormatException, InterruptedException, IOException {
		AMSComm.TestCaseName("UpdateAssetTest()");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSComm.VerifyRecordIsPresent();
		AMSComm.ClickEditTooltip();
		AMSAssets.UpdateAssetType("NewAssetType");
		AMSAssets.UpdateAssetDescription("NewAssetDescription");
		AMSComm.ClickUpdateButtonInUpdate();
		AMSComm.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

/// Delete
	public void DeleteAssetTest() throws NumberFormatException, IOException, InterruptedException {
		AMSComm.TestCaseName("DeleteAssetTest()");
		AMSDash.ClickOnAssetsTab();
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSComm.VerifyRecordIsPresent();
		AMSComm.ClickDeleteTooltip();
		AMSComm.YesDeleteIt("DeleteMessAfterDel");
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.VerifyDataNotFoundMessageIsPresent();
	}
}
