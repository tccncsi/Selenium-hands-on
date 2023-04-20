package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.EmployeePage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class EmployeeModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	EmployeePage AMSEmp;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteAllEmployeeTCs() throws Exception {
		System.out.println("Execute All Employee Module related Test Cases");
		CreateEmployeeTest();
		SearchTheEmployeeTest();
		UpdateEmployeeTest();
		DeleteEmployeeTest();
	}

	// Create
	public void CreateEmployeeTest() throws InterruptedException, IOException {

		// Objects of Below Pages
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSComm.TestCaseName("CreateEmployeeTest()");
		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();
		AMSEmp.ClickCreateEmployeeButton();
		// Fill The Form
		AMSEmp.EnterEmployeeId("EmployeeID");
		AMSEmp.EnterEmployeeName("EmployeeName");
		AMSEmp.SelectStatus("Status");
		AMSEmp.EnterDateOfJoining("DateOfJoining");
		AMSEmp.EnterEmail("EmailId");
		// Click Close Button
		// AMSEmp.ClickEmpCloseButton();
		// Click Save Button
		AMSEmp.ClickEmpSaveButton();
		// AMSlogin.Logout();
	}

	// Read
	public void SearchTheEmployeeTest() throws InterruptedException, IOException {
		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.TestCaseName("SearchTheEmployee");
		AMSlogin.RefreshPage();
		// AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();
		AMSEmp.SelectItemFromItemsPerPageDropDownEmp("15");
		AMSEmp.SearchEmployee("EmailId");
		// AMSEmp.VerifyDataNotFoundMessDisplayed();
		AMSEmp.VerifyRecordDisplayed();
		AMSComm.GetRowData();
		// AMSlogin.Logout();
	}

	// Update
	public void UpdateEmployeeTest() throws InterruptedException, IOException {
		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSComm = new CommonPage(driver);
		AMSComm.TestCaseName("UpdateEmployeeTest");
		AMSlogin.RefreshPage();
		// AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();
		AMSEmp.SearchEmployee("EmailId");
		AMSEmp.VerifyRecordDisplayed();
		AMSEmp.ClickEditUserToolTip();
		AMSEmp.UpdateEmpStatus("NewEmpStatus");
		AMSEmp.UpdateEmpEmail("NewEmpEmailId");
		// AMSEmp.ClickCloseBtn();
		AMSEmp.ClickUpdteBtn();
		// AMSlogin.Logout();
	}

	// Delete
	public void DeleteEmployeeTest() throws InterruptedException, IOException {
		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSComm = new CommonPage(driver);
		AMSlogin.RefreshPage();
		AMSComm.TestCaseName("UpdateEmployeeTest");
		// AMSlogin.Login(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();
		AMSEmp.SearchEmployee("NewEmpEmailId");
		AMSEmp.VerifyRecordDisplayed();
		AMSEmp.ClickDeleteUserToolTip();
		AMSEmp.YesDeleteEmployee();
		// AMSEmp.SearchEmployee("NewEmpEmailId");
		// AMSEmp.VerifyDataNotFoundMessDisplayed();
		AMSlogin.Logout();
	}
}
