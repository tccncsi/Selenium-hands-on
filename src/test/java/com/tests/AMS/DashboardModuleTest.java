package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.utilities.ReadConfig;

public class DashboardModuleTest extends BaseClass {

	// Variable Declaration
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	CommonPage AMSComm;

	public ReadConfig readconfig = new ReadConfig();

	// Testcase 1 for Valid User
	@Test(priority = 1, enabled = true)
	public void DashboardMainPageTest() throws NumberFormatException, IOException, InterruptedException {
		// Objects of Below Pages
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSComm = new CommonPage(driver);

		AMSComm.TestCaseName("DashboardMainPageTest()");
		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();
	}
}
