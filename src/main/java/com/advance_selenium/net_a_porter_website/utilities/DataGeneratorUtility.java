package com.advance_selenium.net_a_porter_website.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.advance_selenium.net_a_porter_website.utilities.*;
import java.util.Locale;

public class DataGeneratorUtility {

	
	int counter;
	int flag;
    String nric;
	DataFactory df;
	Integer noOfRecords;
	Integer lengthofchars;
	String column;

	
	
	public void getNames(String colname) throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String name = df.getFirstName() + " " + df.getLastName();
			System.out.println(name);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, name);
		}
	}

	public void getFirstName(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String fname = df.getFirstName();
			System.out.println(fname);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, fname);
		}
	}
	
	public void getLastName(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String lname = df.getLastName();
			System.out.println(lname);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, lname);
		}
	}
	
	public void getStreetNames(String colname) throws IOException {
		// creating a list of streetnames
		counter = 0;
		df = new DataFactory();
		
		 noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords")); 
		 for(int i = 0; i < noOfRecords; i++) 
		 {
		 
		 String street = df.getAddress();
		 
		 System.out.println(street); 
		 
		 counter = XLUtils.setDataGeneratorDetails(colname, counter, street); 
		 
		 }
	
	}

	
	public void getCity(String colname) throws IOException {
		// creating a list of city
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String city = df.getCity();

			System.out.println(city);
			
		    counter = XLUtils.setDataGeneratorDetails(colname, counter, city); 
			 
			 }
		

	}

	
	public void getsPostalCode(String colname) throws IOException {
		// creating a list of postalcode
		counter = 0;
		df = new DataFactory();
	
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String postalcode = df.getNumberText(5);
			System.out.println(postalcode);

			counter = XLUtils.setDataGeneratorDetails(colname, counter, postalcode);

		}

	}

	
	public void getBusinessNames(String colname) throws IOException {
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String business = df.getBusinessName();
			System.out.println(business);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, business);
		}

	}

	
	public void getDateFormat1(String colname) throws IOException {
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
				

				try {
					counter = XLUtils.setDataGeneratorDetails(colname, counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	
	public void getDateFormat2(String colname) throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(start);
				System.out.println(timeStamp);
				

				try {
					counter = XLUtils.setDataGeneratorDetails(colname, counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	public void getDateFormat3(String colname) throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("E dd-MM-yyyy").format(start);
				System.out.println(timeStamp);
				
				try {
					counter = XLUtils.setDataGeneratorDetails(colname, counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}
	
	public void getTimeStamp(String colname) throws NumberFormatException, IOException
	{
		counter=0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) 
			{
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("hh:mm:ss").format(start);
				System.out.println(timeStamp);
				counter = XLUtils.setDataGeneratorDetails(colname, counter, timeStamp);
			}
		}
		
		
	}
	
	public void getMobileNo(String colname) throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {

			String MobileNo = df.getNumberText(Integer.parseInt(XLUtils.FetchExcelData("MobileNoLimit")));
			System.out.println(MobileNo);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, MobileNo);
		}
	}



	
	public void generateEmailIds(String colname) throws IOException {
		// Concatenating first and last name to create email id
		counter = 0;
		df = new DataFactory();
		
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
				counter = XLUtils.setDataGeneratorDetails(colname, counter, text);
			} else {
				System.out.println(email);
				counter = XLUtils.setDataGeneratorDetails(colname, counter, email);
			}

		}
	}
	
	public void getEmail(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		df = new DataFactory();
		
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String fname = XLUtils.getDataGeneratorDetails("FirstName", counter);
			String lname = XLUtils.getDataGeneratorDetails("LastName", counter);
			

			String email = fname + "_" + lname + XLUtils.FetchExcelData("domain");

			String text = "";

			if (email.contains("'")) {
				String e[] = email.split("'");
				for (String f : e) {
					text += f;
					System.out.println(text);

				}
				counter = XLUtils.setDataGeneratorDetails(colname, counter, text);
			} else {
				System.out.println(email);
				counter = XLUtils.setDataGeneratorDetails(colname, counter, email);
			}

		}
	}
	
	public void getCustomisedText(String colname) throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		//column = XLUtils.FetchColumnName(counter,"TextArea");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		lengthofchars = Integer.parseInt(XLUtils.FetchExcelData("lengthofchars"));
		for (int i = 0; i < noOfRecords; i++) {

			String text = "";
			for (int j = 0; j < 50; j++) {
				text += df.getRandomWord() + " ";
			}
			String textarea = text.substring(0, lengthofchars).trim();
			System.out.println(textarea);

			counter = XLUtils.setDataGeneratorDetails(colname, counter, textarea);
		}

	}
	
	public void getNRIC(String colname) throws IOException {
		counter = 0;
		df = new DataFactory();
		//column = XLUtils.FetchColumnName(counter,"NRICNumber");
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		nric = XLUtils.FetchExcelData("nric");

		for (int i = 0; i < noOfRecords; i++) {
			char c = df.getRandomChar();
			String NRIC = nric + df.getNumberText(7) + Character.toUpperCase(c);
			System.out.println(NRIC);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, NRIC);
		}
	}
	
	public void getQuantity(String colname) throws IOException
	{
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		int min = Integer.parseInt(XLUtils.FetchExcelData("min"));
		int max = Integer.parseInt(XLUtils.FetchExcelData("max"));
		
		for(int i=0;i< noOfRecords; i++)
		{
			String quant = Integer.toString(df.getNumberBetween(min,max));
			counter = XLUtils.setDataGeneratorDetails(colname, counter, quant);
		}
		
	}
	
	public void getBoolean(String colname) throws NumberFormatException, IOException
	{
		counter=0;
		flag=0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for(int i=0;i< noOfRecords; i++)
		{
			 if(flag!=noOfRecords)
			 {
				 counter = XLUtils.setDataGeneratorDetails(colname, counter, String.valueOf(df.chance(0)));
				 flag++;
				 counter = XLUtils.setDataGeneratorDetails(colname, counter, String.valueOf(df.chance(100)));
				 flag++;
			 }
			 else
			 {
				 break;
			 }
			
		}
		
	}
	
	public void getAge(String colname) throws NumberFormatException, IOException
	{
		counter=0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for(int i=0;i< noOfRecords; i++)
		{
			int agemin = Integer.parseInt(XLUtils.FetchExcelData("agemin"));
			int agemax = Integer.parseInt(XLUtils.FetchExcelData("agemax"));
			String age = Integer.toString(df.getNumberBetween(agemin,agemax));
			System.out.println(age);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, age);
		}
	}
	
	public void getGenders(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		
		String gender = XLUtils.FetchExcelData("genders");
		String[] genders = gender.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String G : genders)
				if (flag != noOfRecords) {
					System.out.println(G);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, G);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getTshirtsize(String colname) throws IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		
		String TshirtSize = XLUtils.FetchExcelData("TshirtSize");
		String[] TshirtSizes = TshirtSize.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String TS : TshirtSizes)
				if (flag != noOfRecords) {
					System.out.println(TS);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, TS);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getPayments(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		
		String Payments = XLUtils.FetchExcelData("Payments");
		String[] Paymentss = Payments.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : Paymentss)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getCountry(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String[] countryCodes = Locale.getISOCountries();
		for (String countryCode : countryCodes) 
		{

		    Locale obj = new Locale("", countryCode);

		    System.out.println("Country Code = " + obj.getCountry() + ", Country Name = " + obj.getDisplayCountry());
            String country = obj.getDisplayCountry();
            System.out.println(country);
            if(flag!=noOfRecords)
            {
            	counter = XLUtils.setDataGeneratorDetails(colname, counter, country);
				flag++;
            }
            else
            {
            	break;
            }
		}
		
	}
	
	public void getRelationship(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String Relationship = XLUtils.FetchExcelData("Relationships");
		String[] Relationships = Relationship.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : Relationships)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getWorkCode(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String WorkCode = XLUtils.FetchExcelData("WorkCodes");
		
		String[] WorkCodes = WorkCode.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : WorkCodes)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
		
	}
	
	public void getLanguages(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String Languages = XLUtils.FetchExcelData("Languages");
		String[] Language = Languages.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : Language)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getMartialStatus(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String MartialStatus = XLUtils.FetchExcelData("MartialStatuses");
		
		String[] MartialStatuses = MartialStatus.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : MartialStatuses)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
	}
	
	public void getPositionDivision(String colname) throws NumberFormatException, IOException
	{
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		String PositionDivision = XLUtils.FetchExcelData("PositionDivisions");
		String[] PositionDivisions = PositionDivision.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PY : PositionDivisions)
				if (flag != noOfRecords) {
					System.out.println(PY);
					counter = XLUtils.setDataGeneratorDetails(colname, counter, PY);
					flag++;
				} else {
					break;
				}

		}
		
	}
	
	public void getEmergencyPhoneNo(String colname) throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {

			String MobileNo = df.getNumberText(Integer.parseInt(XLUtils.FetchExcelData("MobileNoLimit")));
			System.out.println(MobileNo);
			counter = XLUtils.setDataGeneratorDetails(colname, counter, MobileNo);
		}
	}
	
	
}
