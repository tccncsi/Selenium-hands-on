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

public class UpdateAssetTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetPage AMSAssets;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void UpdateAssets() throws NumberFormatException, InterruptedException, IOException {

		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssets = new AssetPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("SerachAssets");
		AMSlogin.LoginToAMSApplication(readconfig.getAMSUsername(), readconfig.getAMSPassword());

		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickAssetsfromMaster();
		
		AMSAssets.clickOnUpdateAssetsIcon(XLUtils.FetchExcelData("Asset"));
		AMSAssets.UpdateAssetType("NewAssetType");
		AMSAssets.UpdateAssetDescription("NewAssetDescription");
		AMSAssets.ClickUpdateBtn();
		AMSAssets.UpdateSuccessfullyPopUpMessage("Record Updated Successfully!");
	}
}