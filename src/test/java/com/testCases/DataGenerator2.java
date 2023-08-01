package com.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.XLUtils;

public class DataGenerator2 extends BaseClass {

	int counter;
	int flag;

	DataFactory df;
	Integer noOfRecords;
	Integer lengthofchars;
	String column;

	
	@Test(priority = 0, enabled = false)
	public void getApplicantReferenceNo() throws IOException {
		
		 counter = 0; 
		 df = new DataFactory(); 
		 noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		 
		  for (int i = 0; i < noOfRecords; i++) {
		  
		  String apprefno = df.getNumberText(6); 
		  System.out.println(apprefno); 
		  counter = XLUtils.setDataGeneratorDetails("Applicant Reference No", counter,
		  apprefno); }
		 
	}
	
	@Test(priority = 1, enabled = false)
	public void getNames() throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String name = df.getFirstName() + " " + df.getLastName();
			System.out.println(name);
			counter = XLUtils.setDataGeneratorDetails("Name of contact person", counter, name);
		}
	}

	@Test(priority = 2, enabled = false)
	public void getStreetNames() throws IOException {
		// creating a list of streetnames
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"StreetName");
		 noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords")); 
		 for(int i = 0; i < noOfRecords; i++) 
		 {
		 
		 String street = df.getAddress();
		 
		System.out.println(street); 
		
		counter = XLUtils.setDataGeneratorDetails(column, counter, street); 
		 
		 }
	
	}

	@Test(priority = 3, enabled = false)
	public void getCity() throws IOException {
		// creating a list of city
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"City");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String city = df.getCity();

			System.out.println(city);
			
		    counter = XLUtils.setDataGeneratorDetails(column, counter, city); 
			 
			 }
		

	}

	@Test(priority = 4, enabled = true)
	public void getsPostalCode() throws IOException {
		// creating a list of postalcode
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String postalcode = df.getNumberText(5);
			System.out.println(postalcode);

			counter = XLUtils.setDataGeneratorDetails("PostalCode", counter, postalcode);

		}

	}

	@Test(priority = 5, enabled = true)
	public void getBusinessNames() throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String business = df.getBusinessName();
			System.out.println(business);
			counter = XLUtils.setDataGeneratorDetails("Name of company (English)", counter, business);
		}

	}

	@Test(priority = 6, enabled = false)
	public void getDateIncorporation() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(start);
				System.out.println(timeStamp);
				// System.out.println("Date = "+start.toString());

				try {
					counter = XLUtils.setDataGeneratorDetails("Date of incorporation (YYYY-MM-DD)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	@Test(priority = 7, enabled = true)
	public void getDateCommencement() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(start);
				System.out.println(timeStamp);
				// System.out.println("Date = "+start.toString());

				try {
					counter = XLUtils.setDataGeneratorDetails("Date(yyyy.mm.dd)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}

	

	@Test(priority = 8, enabled = false)
	public void getMobileNo() throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {

			String MobileNo = df.getNumberText(15);
			System.out.println(MobileNo);
			counter = XLUtils.setDataGeneratorDetails("MobileNo", counter, MobileNo);
		}
	}



	@Test(priority = 9, enabled = false)
	public void generateEmailIds() throws IOException {
		// Concatenating first and last name to create email id
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String name = XLUtils.getDataGeneratorDetails("Name of contact person", counter);
			String names[] = name.split(" ");

			String email = names[0] + "_" + names[1] + XLUtils.FetchExcelData("domain");

			String text = "";

			if (email.contains("'")) {
				String e[] = email.split("'");
				for (String f : e) {
					text += f;
					System.out.println(text);

				}
				counter = XLUtils.setDataGeneratorDetails("Email address", counter, text);
			} else {
				System.out.println(email);
				counter = XLUtils.setDataGeneratorDetails("Email address", counter, email);
			}

		}
	}
	
	@Test(priority = 10, enabled = false)
	public void getCustomisedText() throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		lengthofchars = Integer.parseInt(XLUtils.FetchExcelData("lengthofchars"));
		for (int i = 0; i < noOfRecords; i++) {

			String text = "";
			for (int j = 0; j < 50; j++) {
				text += df.getRandomWord() + " ";
			}
			String textarea = text.substring(0, lengthofchars).trim();
			System.out.println(textarea);

			counter = XLUtils.setDataGeneratorDetails("TextArea", counter, textarea);
		}

	}
}
