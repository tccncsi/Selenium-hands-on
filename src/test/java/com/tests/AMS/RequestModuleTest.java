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
		AMSDashboard.ClickMasterTabBtn();

// 		*** All Test Methods ***
		SearchRequestTest();
		CheckAllRequests();
		CheckApprovedRequests();
		CheckPendingRequests();
		CheckRejectedRequests();

		AMSlogin.Logout();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void SearchRequestTest() throws InterruptedException, IOException {

		AMSComm.TestCaseName("SearchRequestTest");

		AMSDashboard.ClickOnRequestTab();

		AMSReq.ItemsPerPageDropDown("15");
		AMSReq.SearchRequest("4632300004");
		// AMSReq.VerifyRecordDisplayed();
		AMSReq.VerifyRecordIsPresent();
		AMSReq.GetReqRowData();
	}

	public void CheckAllRequests() throws InterruptedException {
		AMSComm.TestCaseName("CheckAllRequests");
		AMSDashboard.ClickOnRequestTab();
		AMSReq.ClickAllButton();
		AMSReq.VerifyRecordIsPresent();
		AMSComm.Print(AMSReq.getTextAllButton());
	}

	public void CheckApprovedRequests() {
		AMSComm.TestCaseName("CheckApprovedRequests");
		AMSDashboard.ClickOnRequestTab();
		AMSReq.ClickApprovedButton();
		AMSReq.ValidateStatus(AMSReq.getTextApprovedButton());
	}

	public void CheckPendingRequests() {
		AMSComm.TestCaseName("CheckPendingRequests");
		AMSDashboard.ClickOnRequestTab();
		AMSReq.ClickPendingButton();
		AMSReq.ValidateStatus(AMSReq.getTextPendingButton());
	}

	public void CheckRejectedRequests() {
		AMSComm.TestCaseName("CheckRejectedRequests");
		AMSDashboard.ClickOnRequestTab();
		AMSReq.ClickRejectedButton();
		AMSReq.ValidateStatus(AMSReq.getTextRejectedButton());
	}
}
