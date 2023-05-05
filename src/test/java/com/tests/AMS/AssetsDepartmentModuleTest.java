package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetsDepartmentPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class AssetsDepartmentModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	AssetsDepartmentPage AMSAssetDepart;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void ExecuteAssetsDepartmentModuleTests() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSAssetDepart = new AssetsDepartmentPage(driver);
		AMSComm.Print("Executing Login Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDashboard.NavigateToDashboardPage();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		CreateAssetsDepartmentTest();
		SearchAssetsDepartmentTest();
		UpdateAssetsDepartmentTest();
		DeleteAssetsDepartmentTest();

		AMSlogin.Logout();

		AMSComm.TotalTestCount("0", "4");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void CreateAssetsDepartmentTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsDepartmentTab();
		AMSComm.TestCaseName("CreateAssetsDepartmentTest");
		AMSAssetDepart.ClickCreateAssetDepartmentButton();
		AMSAssetDepart.EnterAssetDepartment("AssetDepartment");
		AMSAssetDepart.ClickCreateButton();
		// AMSAssetDepart.ClickCancelButton();
		AMSAssetDepart.ValidateMessAfterAssetDepartment("SuccessMessAfterCreate");
	}

	public void SearchAssetsDepartmentTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnAssetsDepartmentTab();
		AMSComm.TestCaseName("SearchAssetsDepartmentTest");
		AMSAssetDepart.ItemsPerPageDropDown("15");
		AMSAssetDepart.SearchAssetsDepartment("AssetDepartment");
		AMSComm.GetTableData("Assets Department");
	}

	public void UpdateAssetsDepartmentTest() throws IOException {
		AMSDashboard.ClickOnAssetsDepartmentTab();
		AMSComm.TestCaseName("UpdateAssetsDepartmentTest");
		AMSAssetDepart.SearchAssetsDepartment("AssetDepartment");
		AMSAssetDepart.ClickEditTooltip();
		AMSAssetDepart.EnterAssetDepartmentToUpdate("NewAssetDepartment");
		// AMSAssetDepart.ClickCancelButtonInUpdate();
		AMSComm.ClickUpdateButtonInUpdate();
		AMSComm.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteAssetsDepartmentTest() throws IOException, InterruptedException {
		AMSDashboard.ClickOnAssetsDepartmentTab();
		AMSComm.TestCaseName("DeleteAssetsDepartmentTest");
		AMSAssetDepart.SearchAssetsDepartment("NewAssetDepartment");
		AMSComm.GetTableData("Assets Department");
		AMSComm.ClickDeleteTooltip();
		AMSComm.YesDeleteIt("DeleteMessAfterDel");
	}
}
