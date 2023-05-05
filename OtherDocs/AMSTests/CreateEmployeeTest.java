package com.AMS.Master;
import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.EmployeePage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class CreateEmployeeTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	EmployeePage AMSEmp;
	
	public ReadConfig readconfig = new ReadConfig();
	
	@Test(priority = 1, enabled = true)
	public void CreateTheEmployee() throws InterruptedException, IOException{

		// Objects of Below Pages
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		
		AMSComm.TestCaseName("SearchTheEmployee");
		AMSlogin.LoginToAMSApplication(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();
		
		AMSEmp.ClickCreateEmployeeButton();
		
		// Fill The Form
		/*
		 * AMSEmp.EnterEmployeeId("EmployeeID");
		 * AMSEmp.EnterEmployeeName("EmployeeName"); AMSEmp.SelectStatus("Status");
		 * AMSEmp.EnterDateOfJoining("DateOfJoining"); AMSEmp.EnterEmail("EmailId");
		 */
		AMSEmp.FillTheCompleteEmployeeForm("EmployeeID", "EmployeeName", "Status", "DateOfJoining", "EmailId");
		
		// Click Close Button
		AMSEmp.ClickEmpCloseButton();
		
		// Click Save Button
		//AMSEmp.ClickEmpSaveButton();
	}
}
