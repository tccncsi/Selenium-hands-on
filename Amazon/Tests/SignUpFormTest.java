package com.testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.SignUpPage;
import com.utilities.DataGeneratorUtility;
import com.utilities.XLUtils;

public class SignUpFormTest extends BaseClass
{
	SignUpPage signuppage;
	int recordNo;
	
	@Test
	public void SignUp() throws IOException
	{

		recordNo = Integer.parseInt(XLUtils.FetchExcelData("recordNo"));
		signuppage = new SignUpPage(driver);
		signuppage.enterName(XLUtils.getDataGeneratorDetails("FirstName", recordNo),XLUtils.getDataGeneratorDetails("LastName", recordNo));
		signuppage.enterAge(XLUtils.getDataGeneratorDetails("Age", recordNo));
		signuppage.enterDate(XLUtils.getDataGeneratorDetails("Date", recordNo));
		signuppage.enterGender(XLUtils.getDataGeneratorDetails("Gender", recordNo));
		signuppage.enterEmail(XLUtils.getDataGeneratorDetails("Email", recordNo));
		signuppage.enterPhoneNo(XLUtils.getDataGeneratorDetails("Phone Number", recordNo));
		signuppage.enterAddress(XLUtils.getDataGeneratorDetails("Address", recordNo));
		signuppage.enterCity(XLUtils.getDataGeneratorDetails("City", recordNo));
		signuppage.enterPostalCode(XLUtils.getDataGeneratorDetails("PostalCode", recordNo));
		signuppage.enterCountry(XLUtils.getDataGeneratorDetails("Country", recordNo));
		signuppage.enterTshirtSize(XLUtils.getDataGeneratorDetails("Tshirt Size", recordNo));
		signuppage.enterEmergencyName(XLUtils.getDataGeneratorDetails("FirstName", 5),XLUtils.getDataGeneratorDetails("LastName", 5));
		signuppage.enterEmergencyPhoneNo("001", XLUtils.getDataGeneratorDetails("Phone Number", 1));
		signuppage.enterRelationship(XLUtils.getDataGeneratorDetails("Relationship", recordNo));
		signuppage.enterPaymentMethod(XLUtils.getDataGeneratorDetails("Method of Payment", recordNo));
		signuppage.enterQuantity(XLUtils.getDataGeneratorDetails("Quantity", recordNo));
		signuppage.enterTime(XLUtils.getDataGeneratorDetails("Time", recordNo),XLUtils.getDataGeneratorDetails("Date", recordNo));
		signuppage.enterDescription(XLUtils.getDataGeneratorDetails("Description", recordNo));
		
	}
}
