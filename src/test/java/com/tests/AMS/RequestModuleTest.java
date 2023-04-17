package com.tests.AMS;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.AMS.CommonPage;
import com.pageObjects.AMS.DashboardPage;
import com.pageObjects.AMS.LogInPage;
import com.pageObjects.AMS.RequestPage;
import com.utilities.ReadConfig;

public class RequestModuleTest extends BaseClass {

	// Variable Declaration
	CommonPage AMSComm;
	LogInPage AMSlogin;
	DashboardPage AMSDashboard;
	RequestPage AMSReq;

	public ReadConfig readconfig = new ReadConfig();

	// Execution Method
	@Test(priority = 1, enabled = true)
	public void RequestModuleTestExecution() throws Exception {

		// Objects of Below Pages //
		AMSComm = new CommonPage(driver);
		AMSlogin = new LogInPage(driver);
		AMSDashboard = new DashboardPage(driver);
		AMSReq = new RequestPage(driver);

		AMSComm.Print("\nExecute All Request Module related Test Cases");

		AMSlogin.LoginToAMSApplication();
		AMSDashboard.ClickDashboardHomeBtn();

// 		*** All Test Methods ***
		SearchRequestTest();
		CheckRequestByFilter();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void SearchRequestTest() throws InterruptedException, IOException {

		AMSComm.TestCaseName("SearchRequestTest");

		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnRequestTab();

		AMSReq.ItemsPerPageDropDown("15");
		AMSReq.SearchRequest("4632300004");
		AMSReq.VerifyRecordDisplayed();
		AMSReq.GetReqRowData();
	}

	public void CheckRequestByFilter() throws InterruptedException {

		AMSComm.TestCaseName("CheckRequestByFilter");

		AMSDashboard.ClickMasterTabBtn();
		AMSDashboard.ClickOnRequestTab();

		AMSReq.ClickAllButton();
		AMSReq.ClickApprovedButton();
		AMSReq.ClickPendingButton();
		AMSReq.ClickRejectedButton();
	}
}
