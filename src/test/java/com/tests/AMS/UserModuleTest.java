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
	public void ExecuteUserModuleTests() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSUser = new UserPage(driver);
		AMSComm.Print("Executing User Module Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDashboard.NavigateToDashboardPage();
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		GetAllRowsPresent();
		CreateUserTest();
		AMSDashboard.ClickMasterTabBtn();
		SearchUserTest();
		UpdateUserTest();
		DeleteUserTest();
		AMSDashboard.ClickMasterTabBtn();
		GetAllRowsPresent();
		AMSlogin.Logout();

		AMSComm.TotalTestCount("24", "5");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void GetAllRowsPresent() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("GetAllRowsPresent");
		AMSUser.ItemsPerPageDropDown("15");
		AMSComm.GetTableData("Users");
	}

	public void CreateUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("CreateUserTest");
		AMSComm.ManualTestCount("12");
		AMSUser.ClickCreateUserButton();
		AMSUser.EnterUserName("UserName1");
		AMSUser.EnterEmployeeID("EmpID1");
		AMSUser.EnterEmail("Email1");
		AMSUser.SelectRole("Role1");
		AMSUser.EnterPassword("UserPassword1");
		AMSUser.ClickCreateButton();
		// AMSComm.ValidateMessAfterCreated("SuccessMessAfterCreate");
		// AMSUser.ValidateMessAfterUser("Errmess");
		AMSComm.RefreshPage();
		// AMSUser.ClickCancelButton();
	}

	public void SearchUserTest() throws InterruptedException, IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("SearchUserTest");
		AMSComm.ManualTestCount("2");
		AMSUser.ItemsPerPageDropDown("15");
		AMSUser.SearchUser("EmpID1");
		AMSComm.GetTableData("Users");
	}

	public void UpdateUserTest() throws IOException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("UpdateUserTest");
		AMSComm.ManualTestCount("10");
		AMSUser.SearchUser("EmpID1");
		AMSUser.VerifyRecordIsPresent();
		AMSUser.ClickEditTooltip();
		AMSUser.EnterUserNameToUpdate("NewUsername1");
		AMSUser.EnterEmailToUpdate("NewEmail1");
		AMSUser.SelectRoleToUpdate("ChangeRole1");
		AMSUser.ClickCancelButtonInUpdate();
		// AMSComm.ClickUpdateButtonInUpdate();
		// AMSComm.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	public void DeleteUserTest() throws IOException, InterruptedException {
		AMSDashboard.ClickOnUserTab();
		AMSComm.TestCaseName("DeleteUserTest");
		AMSUser.SearchUser("EmpID1");
		AMSUser.VerifyRecordIsPresent();
		AMSComm.GetRowData("Users");
		AMSComm.ClickDeleteTooltip();
		AMSComm.YesDeleteIt("DeleteMessAfterDel");
	}

}
