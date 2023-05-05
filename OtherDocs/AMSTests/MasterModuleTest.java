package com.tests.AMS;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetPage;
import com.pageObjects.AMS.AssetsDepartmentPage;
import com.pageObjects.AMS.AssetsGroupPage;
import com.pageObjects.AMS.AssetsStatusPage;
import com.pageObjects.AMS.AssetsVendorPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.EmployeePage;
import com.pageObjects.AMS.LogInPage;
import com.pageObjects.AMS.RequestPage;
import com.pageObjects.AMS.UserPage;
import com.utilities.ReadConfig;

public class MasterModuleTest extends BaseClass {

	public ReadConfig readconfig = new ReadConfig();

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDash;
	AssetPage AMSAsset;
	EmployeePage AMSEmp;
	RequestPage AMSReq;
	AssetsGroupPage AMSAssetGrp;
	AssetsDepartmentPage AMSAssetDepart;
	AssetsVendorPage AMSVendor;
	AssetsStatusPage AMSStatus;
	UserPage AMSUser;

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void ExecuteMasterModuleTests() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDash = new DashboardPage(driver);
		AMSAsset = new AssetPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSReq = new RequestPage(driver);
		AMSAssetGrp = new AssetsGroupPage(driver);
		AMSAssetDepart = new AssetsDepartmentPage(driver);
		AMSVendor = new AssetsVendorPage(driver);
		AMSStatus = new AssetsStatusPage(driver);
		AMSUser = new UserPage(driver);

		AssetModuleTest Asset = new AssetModuleTest();
		EmployeeModuleTest EMP = new EmployeeModuleTest();
		RequestModuleTest Req = new RequestModuleTest();
		AssetsGroupModuleTest AGrp = new AssetsGroupModuleTest();
		AssetsDepartmentModuleTest Depart = new AssetsDepartmentModuleTest();
		AssetsVendorModuleTest Vendor = new AssetsVendorModuleTest();
		AssetsStatusModuleTest Status = new AssetsStatusModuleTest();
		UserModuleTest User = new UserModuleTest();

		AMSComm.Print("Executing Master Module Testcases...");

// 		*** All Test Suites ***

		Asset.ExecuteAssetModuleTests();
		EMP.ExecuteAllEmployeeTCs();
		Req.ExecuteRequestModuleTests();
		AGrp.ExecuteAssetsGroupModuleTests();
		Depart.ExecuteAssetsDepartmentModuleTests();
		Vendor.ExecuteAssetsVendorModuleTests();
		Status.ExecuteAssetsStatusModuleTests();
		User.ExecuteUserModuleTests();
	}
}
