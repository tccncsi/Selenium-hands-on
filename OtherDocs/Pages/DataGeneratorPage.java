package com.pageObjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.base.BasePage;
import com.utilities.XLUtils;

public class DataGeneratorPage {

	
	int counter;
	int flag;
    String nric;
	DataFactory df;
	Integer noOfRecords;
	Integer lengthofchars;
	String column;

	
	
	public void getNames() throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"Name");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String name = df.getFirstName() + " " + df.getLastName();
			System.out.println(name);
			counter = XLUtils.setDataGeneratorDetails("Name of contact person", counter, name);
		}
	}

	
	public void getStreetNames(String colname) throws IOException {
		// creating a list of streetnames
		counter = 0;
		df = new DataFactory();
		
		//column = XLUtils.fetchColumnData();
		
		 noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords")); 
		 for(int i = 0; i < noOfRecords; i++) 
		 {
		 
		 String street = df.getAddress();
		 
		 System.out.println(street); 
		//String col = null;
		counter = XLUtils.setDataGeneratorDetails(colname, counter, street); 
		 
		 }
	
	}

	
	public void getCity() throws IOException {
		// creating a list of city
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"City");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String city = df.getCity();

			System.out.println(city);
			String col = null;
		    counter = XLUtils.setDataGeneratorDetails(col, counter, city); 
			 
			 }
		

	}

	
	public void getsPostalCode() throws IOException {
		// creating a list of postalcode
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"PostalCode");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String postalcode = df.getNumberText(5);
			System.out.println(postalcode);

			counter = XLUtils.setDataGeneratorDetails("PostalCode", counter, postalcode);

		}

	}

	
	public void getBusinessNames() throws IOException {
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"Business");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String business = df.getBusinessName();
			System.out.println(business);
			counter = XLUtils.setDataGeneratorDetails("Name of company (English)", counter, business);
		}

	}

	
	public void getDateFormat1() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"Date(yyyy.mm.dd)");
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
	
	
	public void getDateFormat2() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"Date(dd.mm.yyyy)");
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
					counter = XLUtils.setDataGeneratorDetails("Date(dd.mm.yyyy)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	public void getDateFormat3() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"Date(E dd.mm.yyyy)");
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
					counter = XLUtils.setDataGeneratorDetails("Date(E dd.mm.yyyy)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	
	
	public void getMobileNo() throws IOException {
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"MobileNo");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {

			String MobileNo = df.getNumberText(15);
			System.out.println(MobileNo);
			counter = XLUtils.setDataGeneratorDetails("MobileNo", counter, MobileNo);
		}
	}



	
	public void generateEmailIds() throws IOException {
		// Concatenating first and last name to create email id
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"EmailAddress");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String name = XLUtils.getDataGeneratorDetails("Name", counter);
			String names[] = name.split(" ");

			String email = names[0] + "_" + names[1] + XLUtils.FetchExcelData("domain");

			String text = "";

			if (email.contains("'")) {
				String e[] = email.split("'");
				for (String f : e) {
					text += f;
					System.out.println(text);

				}
				counter = XLUtils.setDataGeneratorDetails("EmailAddress", counter, text);
			} else {
				System.out.println(email);
				counter = XLUtils.setDataGeneratorDetails("EmailAddress", counter, email);
			}

		}
	}
	
	
	public void getCustomisedText() throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"TextArea");
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
	
	public void getNRIC() throws IOException {
		counter = 0;
		df = new DataFactory();
		column = XLUtils.FetchColumnName(counter,"NRICNumber");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		nric = XLUtils.FetchExcelData("nric");

		for (int i = 0; i < noOfRecords; i++) {
			char c = df.getRandomChar();
			String NRIC = nric + df.getNumberText(7) + Character.toUpperCase(c);
			System.out.println(NRIC);
			counter = XLUtils.setDataGeneratorDetails("NRICNumber", counter, NRIC);
		}
	}
}
