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
	public void UserModuleTestExecution() throws Exception {

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
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("GetAllRowsPresent");
		AMSUser.ItemsPerPageDropDown("15");
		AMSUser.VerifyRecordIsPresent();
		AMSComm.GetRowData("User");
	}

	public void CreateUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("CreateUserTest");
		AMSUser.ClickCreateUserButton();
		AMSUser.EnterUserName("UserName1");
		AMSUser.EnterEmployeeID("EmpID1");
		AMSUser.EnterEmail("Email1");
		AMSUser.SelectRole("Role1");
		AMSUser.EnterPassword("UserPassword1");
		AMSUser.ClickCreateButton();
		// AMSUser.ClickCancelButton();
		AMSUser.ValidateMessAfterUser("SuccessMessAfterCreate");
	}

	public void SearchUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("SearchUserTest");
		AMSUser.ItemsPerPageDropDown("15");
		AMSUser.SearchUser("EmpID1");
		AMSUser.VerifyRecordIsPresent();
		AMSComm.GetRowData("User");
	}

	public void UpdateUserTest() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("UpdateUserTest");
		AMSUser.SearchUser("EmpID1");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.ClickEditTooltip();
		AMSUser.EnterUserNameToUpdate("NewUsername1");
		AMSUser.EnterEmailToUpdate("NewEmail1");
		AMSUser.SelectRoleToUpdate("ChangeRole1");
		// AMSUser.ClickCancelButtonInUpdate();
		AMSUser.ClickUpdateButtonInUpdate();
		AMSUser.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteUserTest() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("DeleteUserTest");
		AMSUser.SearchUser("EmpID1");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.GetRowData();
		AMSUser.ClickDeleteTooltip();
		AMSUser.YesDeleteIt("DeleteMessAfterDel");
	}
}
