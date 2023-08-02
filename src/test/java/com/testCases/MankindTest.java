package com.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.MankindHomePage;
import com.pageObjects.MankindSignUpPage;
import com.utilities.JiraCreateIssue;
import com.utilities.XLUtils;

public class MankindTest extends BaseClass {

	MankindHomePage mkhomepage;
	MankindSignUpPage mksignuppage;
	int recordNo;

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void changeCountryTest() throws InterruptedException, NumberFormatException, IOException {
		mkhomepage = new MankindHomePage(driver);

		System.out.println("\n-------- Mankind Test Started---------");

		mkhomepage.acceptCookies();
		mkhomepage.closeSignUpModal();
		mkhomepage.clickOnCountryIcon();
		mkhomepage.selectShippingCountry();
		mkhomepage.selectLanguage();
		mkhomepage.selectCurrency();
		mkhomepage.clickOnLanguageSaveButton();

		assertTrue(mkhomepage.getVerifyMessage().contains("Your settings have been saved"),"Settings have not been saved successfully.");
	}

	@JiraCreateIssue(isCreateIssue = true)
	@Test
	public void signUpTest() throws InterruptedException, IOException {
		mkhomepage = new MankindHomePage(driver);
		mksignuppage = new MankindSignUpPage(driver);

		String fullName = XLUtils.FetchExcelData("Fullname");
		String validEmail = XLUtils.FetchExcelData("validEmail");
		String validPassword = XLUtils.FetchExcelData("validPassword");
		String mobileNumber = "1234567890";

		mkhomepage.clickOnAccountIcon();

		mksignuppage.clickOnSignUpContinue();
		Thread.sleep(2000);
		mksignuppage.enterFullName(fullName);
		mksignuppage.enterEmail(XLUtils.FetchExcelData("invalidEmail"));
		Thread.sleep(2000);
		mksignuppage.enterConfirmEmail(validEmail);

		assertTrue(mksignuppage.getEmailError().contains("Email address must be a valid email"),"Invalid Email Error is not displayed");

		mksignuppage.clearEmailBox();
		mksignuppage.enterEmail(validEmail);

		String newEmail = mksignuppage.createNewEmail(XLUtils.FetchExcelData("validEmail"));
		System.out.println("Newly Generated Email is: " + newEmail);
		XLUtils.setCellData("validEmail", newEmail);

		//Steps to store new generated email to the excel file <FormTestData.xlsx>
		mksignuppage.enterPassword(XLUtils.FetchExcelData("invalidPassword"));
		mksignuppage.enterConfirmPassword(validPassword);
		Thread.sleep(2000);

		assertTrue(mksignuppage.getConfirmPasswordError().contains("Password must match"),"Password mismatch Error is not displayed");

		mksignuppage.clearPassword();
		mksignuppage.enterPassword(validPassword);

		// String mobileNumber = String.valueOf(XLUtils.FetchExcelData("mobileNumber"));
		// System.out.println("Mobile Number: " + mobileNumber);

		mksignuppage.enterMobileNumber(mobileNumber);
		Thread.sleep(2000);
		mksignuppage.selectNoThanks();
		mksignuppage.clickOnSignUpContinue();
		Thread.sleep(3000);
		mkhomepage.acceptCookies();

		mkhomepage.clickOnAccountIcon();

		mksignuppage.clikcOnAccountDetailsCard();

		System.out.println("Full Name: " + fullName + " Email: " + validEmail + " MobileNo: " + mobileNumber);

		String regFullName = mksignuppage.getRegisteredName();
		String regEmail = mksignuppage.getRegisteredEmail();
		String regMobileNumber = mksignuppage.getRegisteredMobileNumber();

		System.out.println("Reg. Full Name: " + regFullName + " Reg. Email: " + regEmail + " Reg. MobileNo: " + regMobileNumber);

		assertEquals(fullName, regFullName);
		assertEquals(validEmail, regEmail);
		assertEquals(mobileNumber, regMobileNumber);

	}
}
