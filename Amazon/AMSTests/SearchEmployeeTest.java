package com.AMS.Master;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.EmployeePage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class SearchEmployeeTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	EmployeePage AMSEmp;
	CommonPage AMSComm;
	
	public ReadConfig readconfig = new ReadConfig();
	
	@Test(priority = 1, enabled = true)
	public void SearchTheEmployee() throws InterruptedException{

		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSEmp = new EmployeePage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("SearchTheEmployee");
		AMSlogin.LoginToAMSApplication(readconfig.getAMSUsername(), readconfig.getAMSPassword());
		
		AMSDashboard.ClickDashboardHomeBtn();
		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnEmployeeTab();

		AMSEmp.SelectItemFromItemsPerPageDropDownEmp("15");
		AMSEmp.SearchEmployeeByText("EmployeeName");
		
		AMSEmp.VerifyDataNotFoundMessDisplayed();
		
		// AMSEmp.VerifyRecordDisplayed();
	}
}
