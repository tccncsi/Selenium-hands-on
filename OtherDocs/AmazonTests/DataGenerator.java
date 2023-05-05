package com.testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.XLUtils;


public class DataGenerator extends BaseClass {

	int counter;
	int flag;
	String column;
	// int noOfRecords = readconfig.getNoOfRecords();
	// int noOfNRICs = readconfig.getNoOfNRICs();
	// int lengthofcharacters = readconfig.getLength();
	// String nric = readconfig.getNRIC();
	DataFactory df;
	Integer noOfRecords;
	Integer lengthofchars;
	String gender;
	String prefix;
	String nric;

	@Test(priority = 1, enabled = true)
	public void getNames() throws IOException {
		// creating a list of names

		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));

		for (int i = 0; i < noOfRecords; i++) {
			String name = df.getFirstName() + " " + df.getLastName();
			System.out.println(name);
			//column = XLUtils.FetchColumnName();
			
				counter = XLUtils.setDataGeneratorDetails("Name", counter, name);
			
			
		}
	}

	@Test(priority = 2, enabled = false)
	public void getStreetNames() throws IOException {
		// creating a list of streetnames
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String street = df.getAddress();

			System.out.println(street);

			counter = XLUtils.setDataGeneratorDetails("StreetName", counter, street);

		}

	}

	@Test(priority = 3, enabled = false)
	public void getCity() throws IOException {
		// creating a list of city
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {

			String city = df.getCity();

			System.out.println(city);

			counter = XLUtils.setDataGeneratorDetails("City", counter, city);

		}

	}

	@Test(priority = 4, enabled = false)
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

	@Test(priority = 5, enabled = false)
	public void getBusinessNames() throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String business = df.getBusinessName();
			System.out.println(business);
			counter = XLUtils.setDataGeneratorDetails("Business", counter, business);
		}

	}

	@Test(priority = 6, enabled = false)
	public void getDate() throws IOException {
		// creating a list of Random Dates in yyyy.MM.dd
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(start);
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

	@Test(priority = 7, enabled = false)
	public void getCustomDate() throws IOException {
		// creating a list of Random Dates in dd.MM.yyyy
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(start);
				System.out.println(timeStamp);
				// System.out.println("Date = "+start.toString());

				try {
					counter = XLUtils.setDataGeneratorDetails("Date(dd.MM.yyyy)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}

	@Test(priority = 8, enabled = false)
	public void getCustomDateE() throws IOException {
		// creating a list of Random Dates in EEE,dd.MM.yyyy
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		Date minDate = df.getDate(2000, 1, 1);
		Date maxDate = new Date();
		{

			for (int i = 0; i < noOfRecords; i++) {
				Date start = df.getDateBetween(minDate, maxDate);
				String timeStamp = new SimpleDateFormat("EEE,dd.MM.yyyy").format(start);
				System.out.println(timeStamp);
				// System.out.println("Date = "+start.toString());

				try {
					counter = XLUtils.setDataGeneratorDetails("Date(E dd.MM.yyyy)", counter, timeStamp);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}

	@Test(priority = 7, enabled = false)
	public void getAllEmailAddress() throws IOException {
		// creating a list of EmailAddress

		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String email = df.getEmailAddress();
			if (email.contains("'")) {
				continue;
			}
			System.out.println(email);
			counter = XLUtils.setDataGeneratorDetails("EmailAddress", counter, email);
		}

	}

	@Test(priority = 7, enabled = false)
	public void getEmailAddress() throws IOException {
		// creating a list of EmailAddress with domain @somema1l.com

		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		for (int i = 0; i < noOfRecords; i++) {
			String email = df.getEmailAddress();

			/*
			 * if(email.contains("'")) { continue; }
			 */

			String emailpart[] = email.split("@");
			for (String e : emailpart) {
				if (e.contains("somema1l.us")) {
					System.out.println(e);
					// counter = XLUtils.setDataGeneratorDetails("EmailAddress",counter, email);
				}
			}

		}

	}

	/*
	 * //old method
	 * 
	 * @Test(priority = 8,enabled = false) public void getAllPrefixes() throws
	 * IOException { counter=0; df = new DataFactory(); df.setNameDataValues(new
	 * setTestDataPage()); for(String prefix : new setTestDataPage().getPrefixes())
	 * { System.out.println(prefix); counter =
	 * XLUtils.setDataGeneratorDetails("Prefix",counter, prefix); }
	 * 
	 * } //old method
	 * 
	 * @Test(priority = 9,enabled = false) public void getAllGenders() throws
	 * IOException { counter=0; df = new DataFactory(); df.setNameDataValues(new
	 * setTestDataPage()); for(String gender : new setTestDataPage().genders()) {
	 * System.out.println(gender); counter =
	 * XLUtils.setDataGeneratorDetails("Gender",counter, gender); }
	 * 
	 * }
	 */

	@Test(priority = 8, enabled = false)
	public void getPrefix() throws IOException {
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		// String prefix = readconfig.getPrefix();
		prefix = XLUtils.FetchExcelData("prefixs");
		String[] prefixes = prefix.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String PF : prefixes)
				if (flag != noOfRecords) {
					System.out.println(PF);
					counter = XLUtils.setDataGeneratorDetails("Prefix", counter, PF);
					flag++;
				} else {
					break;
				}

		}

	}

	@Test(priority = 11, enabled = false)
	public void getGenders() throws IOException {
		counter = 0;
		flag = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		// String gender = readconfig.getGender();
		gender = XLUtils.FetchExcelData("genders");
		String[] genders = gender.split(",");

		for (int i = 0; i < noOfRecords; i++) {
			for (String G : genders)
				if (flag != noOfRecords) {
					System.out.println(G);
					counter = XLUtils.setDataGeneratorDetails("Gender", counter, G);
					flag++;
				} else {
					break;
				}

		}

	}

	/*
	 * //old method
	 * 
	 * @Test(priority = 10,enabled = false) public void getNRICNumbers() throws
	 * IOException { counter=0; df = new DataFactory(); String a[] =
	 * {"S","T","F","G","M"};
	 * 
	 * for(String s : a) {
	 * 
	 * for(int i=0;i<noOfNRICs;i++) { char c = df.getRandomChar(); String NRIC =
	 * s+df.getNumberText(7) +Character.toUpperCase(c); System.out.println(NRIC);
	 * counter = XLUtils.setDataGeneratorDetails("NRICNumber",counter, NRIC); }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */
	
	// get nrics from input by user
	@Test(priority = 11, enabled = false)
	public void getNRIC() throws IOException {
		counter = 0;
		df = new DataFactory();
		noOfRecords = Integer.parseInt(XLUtils.FetchExcelData("noOfRecords"));
		nric = XLUtils.FetchExcelData("nric");

		for (int i = 0; i < noOfRecords; i++) {
			char c = df.getRandomChar();
			String NRIC = nric + df.getNumberText(7) + Character.toUpperCase(c);
			System.out.println(NRIC);
			counter = XLUtils.setDataGeneratorDetails("NRICNumber", counter, NRIC);
		}
	}

	@Test(priority = 12, enabled = false)
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

	@Test(priority = 13, enabled = false)
	public void generateEmailIds() throws IOException {
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
				counter = XLUtils.setDataGeneratorDetails("EmailIds", counter, text);
			} else {
				System.out.println(email);
				counter = XLUtils.setDataGeneratorDetails("EmailIds", counter, email);
			}

		}
	}

}
