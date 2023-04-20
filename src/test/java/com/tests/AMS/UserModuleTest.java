package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.pageObjects.AMS.UserPage;
import com.utilities.ReadConfig;

public class UserModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	UserPage AMSUser;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void AssetsGroupModuleTestExecution() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSUser = new UserPage(driver);

		AMSComm.Print(
				"\nExecute All AssetsGroup Module related Test Cases\n--------------------------------------------------");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		GetAllRowsPresent();
		CreateUserTest();
		SearchUserTest();
		UpdateUserTest();
		DeleteUserTest();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void GetAllRowsPresent() throws IOException {
		AMSDashboard.ClickOnAssetsStatusTab();
		AMSComm.TestCaseName("GetAllRowsPresent");
		AMSUser.ItemsPerPageDropDown("15");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.GetRowData();
	}

	public void CreateUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("CreateUserTest");
		AMSUser.ClickCreateUserButton();
		AMSUser.EnterUserName("UserName");
		AMSUser.ClickCreateButton();
		// AMSUser.ClickCancelButton();
		AMSUser.ValidateMessAfterUser("SuccessMessAfterCreate");
	}

	public void SearchUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("SearchUserTest");
		AMSUser.ItemsPerPageDropDown("15");
		AMSUser.SearchUser("UserName");
		;
		AMSUser.VerifyRecordIsPresent();
		AMSUser.GetRowData();
	}

	public void UpdateUserTest() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("UpdateUserTest");
		AMSUser.SearchUser("UserName");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.ClickEditTooltip();
		AMSUser.EnterUserNameToUpdate("NewUserName");
		// AMSUser.ClickCancelButtonInUpdate();
		AMSUser.ClickUpdateButtonInUpdate();
		AMSUser.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteUserTest() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("DeleteUserTest");
		AMSUser.SearchUser("NewUserName");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.GetRowData();
		AMSUser.ClickDeleteTooltip();
		AMSUser.YesDeleteIt("DeleteMessAfterDel");
	}
}
