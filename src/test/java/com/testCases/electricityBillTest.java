package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.airtelHomePage;
import com.utilities.XLUtils;

public class electricityBillTest extends BaseClass {

	airtelHomePage user;

	@Test

	public void login() {
		
		
		user = new airtelHomePage(driver);

		user.loginflow();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.scrolldown();
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user.electricbill();
		try {
			user.enterState(XLUtils.fetchExcelData("State"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.selectState();
//		user.clickonproceed();
		user.selectbiller();
		user.selectbillername();
		user.enterconsumerno();
		try {
			user.consumerid(XLUtils.fetchExcelData("consumernum"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.clickOnBillUnit();
		try {
			user.enterbillingunit(XLUtils.fetchExcelData("billunit"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
