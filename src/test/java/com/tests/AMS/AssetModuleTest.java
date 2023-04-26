package com.tests.AMS;

import java.io.IOException;

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
	DashboardPage AMSDashboard;
	AssetPage AMSAssets;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteAllAssetModuleTCs() throws Exception {
		// 1. Execute CreatAssetTest
		CreatAssetTest();
		// 2. Execute SerachAssetsTest
		SerachAssetTest();
		// 3. Execute UpdateAssetsTest
		UpdateAssetTest();
		// 4. Execute SerachAssets
		DeleteAssetTest();
	}

	// Create
	public void CreatAssetTest() throws InterruptedException, IOException {

		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("CreateAssetTest");
		AMSlogin.RefreshPage();
		// Login to AMS Application
		AMSlogin.LoginToAMSApplication();
		// Click on "Master" Tab
		AMSDashboard.ClickMasterTabBtn();
		// Click on "Assets" tab inside Master Tab
		AMSDashboard.ClickAssetsfromMaster();

		// Click on "Create Asset" button on Assets page
		AMSAssets.ClickonCreateAssetBtn();
		// Click on "Cancel" button in form
		AMSAssets.ClickOnCancelButton();
		// Click on "Create Asset" button on Assets page
		AMSAssets.ClickonCreateAssetBtn();

		// Fill the form //
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

		// Click on "Create" button in form and
		// Verify the pop is diplayed and validate the error message displayed
		AMSAssets.ClickOnCreateButton();
		AMSAssets.VerifyCreateAssetSuccessfullMessage("CreateAssetSuccessfullMessage");
		AMSlogin.Logout();
	}

	// Read
	public void SerachAssetTest() throws NumberFormatException, IOException, InterruptedException {

		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("SerachAssetTest()");
		AMSlogin.RefreshPage();
		AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickAssetsfromMaster();
		AMSAssets.SelectItemFromItemsPerPageDropDown("25");
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.VerifyRecordDisplayed();
		// AMSAssets.VerifyDataNotFoundMessageIsPresent();
		AMSlogin.Logout();
	}

	// Update
	public void UpdateAssetTest() throws NumberFormatException, InterruptedException, IOException {

		// Objects of Below Pages AMSlogin = new LogInPage(driver); AMSDashboard =
		new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("UpdateAssetTest()");
		AMSlogin.RefreshPage();
		AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickAssetsfromMaster();
		AMSAssets.clickOnUpdateAssetsIcon(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.UpdateAssetType("NewAssetType");
		AMSAssets.UpdateAssetDescription("NewAssetDescription");
		AMSAssets.ClickUpdateBtn();
		AMSAssets.UpdateSuccessfullyPopUpMessage("Record Updated Successfully!");
		AMSlogin.Logout();
	}

	// Delete
	public void DeleteAssetTest() throws NumberFormatException, IOException, InterruptedException {

		// Objects of Below Pages AMSlogin = new LogInPage(driver); AMSDashboard =
		new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("DeleteAssetTest()");
		AMSlogin.RefreshPage();
		AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickAssetsfromMaster();
		AMSAssets.DeleteTheTopMostRecordAfterSearch(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.VerifyDataNotFoundMessageIsPresent();
		AMSlogin.Logout();
	}
}
