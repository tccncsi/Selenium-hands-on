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
	DashboardPage AMSDash;
	EmployeePage AMSEmp;

	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteEmployeeModuleTests() throws Exception {
		// Objects of Below Pages
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDash = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);

		AMSComm.Print("Executing Employee Module Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDash.NavigateToDashboardPage();
		AMSDash.ClickMasterTabBtn();

		GetAllRowsPresent();
		CreateEmployeewindowCloseAction();
		CreateEmployeeTest();
		SearchEmployeeTest();
		UpdateEmployeeTest();
		DeleteEmployeeTest();

		AMSlogin.Logout();

		AMSComm.TotalTestCount("14", "6");
	}

	/// Get all the rows present on the asset's main page
	public void GetAllRowsPresent() throws IOException {
		AMSComm.TestCaseName("GetAllRowsPresent()");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.SelectItemFromItemsPerPageDropDownEmp("15");
		AMSComm.VerifyRecordIsPresent();
		AMSComm.GetRowData("All Employees");
	}

	// Close
	public void CreateEmployeewindowCloseAction() {
		AMSComm.TestCaseName("CreateEmployeewindowCloseAction()");
		AMSComm.ManualTestCount("1");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.ClickCreateEmployeeButton();
		AMSEmp.ClickEmpCloseButton();
	}

	// Create
	public void CreateEmployeeTest() throws InterruptedException, IOException {
		AMSComm.TestCaseName("CreateEmployeeTest()");
		AMSComm.ManualTestCount("7");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.ClickCreateEmployeeButton();
		// Fill out The Form
		AMSEmp.EnterEmployeeId("EmployeeID");
		AMSEmp.EnterEmployeeName("EmployeeName");
		AMSEmp.SelectStatus("Status");
		AMSEmp.EnterDateOfJoining("DateOfJoining");
		AMSEmp.EnterEmail("EmailId");
		AMSEmp.ClickEmpSaveButton();
		AMSComm.ValidateMessAfterCreated("SuccessMessAfterCreate");
	}

	// Read
	public void SearchEmployeeTest() throws InterruptedException, IOException {
		AMSComm.TestCaseName("SearchEmployeeTest");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.SelectItemFromItemsPerPageDropDownEmp("15");
		AMSEmp.SearchEmployee("EmailId");
		AMSComm.VerifyRecordIsPresent();
		AMSComm.GetRowData("Employees");
	}

	// Update
	public void UpdateEmployeeTest() throws InterruptedException, IOException {
		AMSComm.TestCaseName("UpdateEmployeeTest");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.SearchEmployee("EmailId");
		AMSComm.VerifyRecordIsPresent();
		AMSEmp.ClickEditUserToolTip();
		AMSEmp.UpdateEmpStatus("NewEmpStatus");
		AMSEmp.UpdateEmpEmail("NewEmpEmailId");
		// AMSEmp.ClickCloseBtn();
		AMSComm.ClickUpdateButtonInUpdate();
		AMSComm.ValidateUpdatedSuccessMess("UpdateSuccesMess");
	}

	// Delete
	public void DeleteEmployeeTest() throws InterruptedException, IOException {
		AMSComm.TestCaseName("DeleteEmployeeTest");
		AMSDash.ClickOnEmployeeTab();
		AMSEmp.SearchEmployee("NewEmpEmailId");
		AMSComm.VerifyRecordIsPresent();
		AMSComm.ClickDeleteTooltip();
		AMSComm.YesDeleteIt("DeleteMessAfterDel");
		AMSEmp.SearchEmployee("NewEmpEmailId");
		AMSComm.VerifyDataNotFoundMessDisplayed();
	}
}
