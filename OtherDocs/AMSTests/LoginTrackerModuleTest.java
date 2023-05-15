package com.tests.AMS;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.AssetPage;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.pageObjects.AMS.Random;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class LoginTrackerModuleTest extends BaseClass {

	LogInPage AMSlogin;
	DashboardPage AMSDash;
	CommonPage AMSComm;
	Random	AMSRDM;
	
	public ReadConfig readconfig = new ReadConfig();

	@Test(priority = 1, enabled = true)
	public void ExecuteLoginTrackerModuleTests() throws Exception {

		// Objects of Required Pages
		AMSlogin = new LogInPage(driver);
		AMSComm = new CommonPage(driver);
		AMSDash = new DashboardPage(driver);
		AMSRDM = new  Random(driver);
				
		AMSComm.Print("Executing LoginTrackerModule Testcases...");
		AMSlogin.LoginToAMSApplication();
		AMSDash.NavigateToDashboardPage();
		AMSDash.ClickReportsTab();

//		Execute all Asset Module Tests
		GetLoginDetails();

		AMSlogin.Logout();
	}

/// Get all the rows present on the asset's main page
	public void GetLoginDetails() throws IOException {
		AMSComm.TestCaseName("GetLoginDetails()");
		AMSDash.ClickOnLoginTrackerBtn();
		AMSComm.ItemsPerPageDropDown("25");
		//AMSComm.GetAllRecords("LoginDetails", "23");
		AMSRDM.LoggedInUserStatus("LoginTracker", "23");
	}
}
