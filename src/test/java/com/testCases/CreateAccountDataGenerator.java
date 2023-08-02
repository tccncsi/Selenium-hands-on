package com.testCases;

import java.io.IOException;


import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.XLUtils;

public class CreateAccountDataGenerator extends BaseClass {
//	int counter;
//	String email;
//	String Firstname;
//	String Lastname;
//	int DOB_day;
//	int DOB_month;
//	int invalid_DOB_year;
//	int DOB_year;
//	DataFactory df;
	int noOfRecords;
	
	@Test
	public void generate_email() throws IOException {
		String excelPath = "src\\main\\java\\com\\testData\\TestData.xlsx";
	    String sheetName = "Columns";
		noOfRecords = Integer.parseInt(XLUtils.getCellData(excelPath, sheetName, 0, 1));
		System.out.println(noOfRecords);
//		for (int i = 0; i < noOfRecords; i++) {
//			
//			counter = XLUtils.setDataGeneratorDetails("Name", counter, name);
//		}
		
	}
	
}