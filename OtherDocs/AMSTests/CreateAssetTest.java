package com.AMS.Master;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class CreateAssetTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetPage AMSAssets;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void CreatAssetTest1() throws InterruptedException, IOException {
		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm	= new CommonPage(driver);

		AMSComm.TestCaseName("CreateAssetTest");

		// Login to AMS Application
		AMSlogin.LoginToAMSApplication(readconfig.getAMSUsername(), readconfig.getAMSPassword());

		
		// Click on "Master" Tab
		AMSDashboard.ClickMasterTabBtn();

		// Click on "Assets" tab inside Master Tab
		AMSDashboard.ClickAssetsfromMaster();

		// Click on "Create Asset" button on Assets page
		AMSAssets.ClickonCreateAssetBtn();

		// Fill the form //
		
		  AMSAssets.EnterAssetNumber("AssetsNumber");
		  AMSAssets.EnterAssetSerialNumber("AssetSerialNumber");
		  AMSAssets.SelectLocation("Location");
		  AMSAssets.EnterAssetDescription("AssetDescription");
		  AMSAssets.SelectAssetType("AssetType"); AMSAssets.EnterCount("Count");
		  AMSAssets.EnterRemark("Remark");
		 
		
		
		/*
		 * AMSAssets.FillTheCompleteForm("AssetsNumber", "AssetSerialNumber",
		 * "Location", "AssetDescription", "AssetGroup", "Department", "Vendor",
		 * "AssetType", "Count", "Remark");
		 */

		// Click on "Create" button in form
		// AMSAssets.ClickOnCreateButton();

		// Click on "Cancel" button in form
		 AMSAssets.ClickOnCancelButton();
		
		// Verify the pop is diplayed and validate the error message displayed is correct
		//AMSAssets.VerifyCreateAssetSuccessfullMessage("Record Created Successfully!");
	}
}
