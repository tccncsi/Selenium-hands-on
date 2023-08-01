package com.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.EmployeeFormEnterPage;
import com.utilities.XLUtils;

public class EmployeeFormEnterPageTest extends BaseClass
{
	EmployeeFormGenerateDataTest employeeform;
	EmployeeFormEnterPage employeeformenterpage;
	int recordNo;
	
	@Test
    public void enterEmployeeFormDetails() throws NumberFormatException, IOException, InterruptedException
    {
		employeeform = new EmployeeFormGenerateDataTest();
		employeeformenterpage = new EmployeeFormEnterPage(driver);
		
		recordNo = Integer.parseInt(XLUtils.FetchExcelData("recordNo"));
		employeeformenterpage.selectTitle("Dr");
		employeeformenterpage.enterFirstName(XLUtils.getDataGeneratorDetails("FirstName", recordNo));
		employeeformenterpage.enterLastName(XLUtils.getDataGeneratorDetails("LastName", recordNo));
		employeeformenterpage.enterBirthDate();
		employeeformenterpage.enterPhoneNo(XLUtils.getDataGeneratorDetails("Phone Number", recordNo));
		employeeformenterpage.enterEmail(XLUtils.getDataGeneratorDetails("Email", recordNo));
		employeeformenterpage.enterAddress(XLUtils.getDataGeneratorDetails("StreetName", recordNo), XLUtils.getDataGeneratorDetails("City", recordNo), XLUtils.getDataGeneratorDetails("PostalCode", recordNo));
		employeeformenterpage.clickContinue();
		employeeformenterpage.enterPositionDivision(XLUtils.getDataGeneratorDetails("PositionDivision", recordNo));
		employeeformenterpage.enterDateOfHire();
		employeeformenterpage.selectWorkCode(XLUtils.getDataGeneratorDetails("WorkCode", recordNo));
		employeeformenterpage.enterEmergencyDetails(XLUtils.getDataGeneratorDetails("EmergencyFirstName", recordNo),XLUtils.getDataGeneratorDetails("EmergencyLastName", recordNo),XLUtils.getDataGeneratorDetails("EmergencyPhoneNo", recordNo),XLUtils.getDataGeneratorDetails("EmergencyRelationship", recordNo));
		employeeformenterpage.enterMedicalInfo(XLUtils.getDataGeneratorDetails("Description", recordNo));
		employeeformenterpage.clickContinueBtn();
		employeeformenterpage.enterLanguage(XLUtils.getDataGeneratorDetails("Language", recordNo));
		employeeformenterpage.selectMartialStatus(XLUtils.getDataGeneratorDetails("MartialStatus", recordNo));
		employeeformenterpage.clickSubmit();
    }
	
}
