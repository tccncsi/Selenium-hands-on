package com.AMS.Master;

import java.io.IOException;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.AMS.AssetPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class SearchAssetTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetPage AMSAssets;
	CommonPage AMSComm;


	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void SerachAssets() throws NumberFormatException, IOException, InterruptedException {

		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm	= new CommonPage(driver);

		AMSComm.TestCaseName("SerachAssets");
		AMSlogin.LoginToAMSApplication(readconfig.getAMSUsername(), readconfig.getAMSPassword());

		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickAssetsfromMaster();

		AMSAssets.SelectItemFromItemsPerPageDropDown("25");
		AMSAssets.SearchAssetsByText(XLUtils.FetchExcelData("AssetNumber"));
		AMSAssets.VerifyRecordDisplayed();
	}
}
