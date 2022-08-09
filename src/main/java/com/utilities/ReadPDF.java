package com.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDF {

	ReadPDF readPIN;

	public String readPINfromPDF(String fileName, String separator, int index)
			throws MalformedURLException, IOException, InterruptedException {

		String userHome = System.getProperty("user.home");
		String filePath = userHome + "/Downloads/" + fileName;
		System.out.println("PDF downloaded at: " + filePath);
		Thread.sleep(5000);
		URL url = new URL("file:///" + filePath);
		InputStream is = url.openStream();

		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;

		document = PDDocument.load(fileParse); // Loading the PDF document

		String pdfContent = new PDFTextStripper().getText(document); // converting pdf text into String
		// System.out.println("PDF Content is: " + pdfContent);

		String[] stringarray = pdfContent.split(separator);
		String issuedPin = stringarray[index].trim();
		System.out.println("Issued PIN Number is: " + issuedPin);
		document.close();

		// delete downloaded PDF document
		File file = new File(url.toString());
		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

		return issuedPin;
	}

	public void readSSIDandPasswordFromPDF(String filename)
			throws MalformedURLException, IOException, InterruptedException {
		readPIN = new ReadPDF();

		String PIN = readPIN.readPINfromPDF(filename, "STAFF IDs ASSIGNED", 1);

		if (PIN.contains("Taxpayer Identification No")) {
			String[] stringarray;
			String issuedPin = PIN;

			String[] SSID = PIN.split("Taxpayer Identification No.");
			issuedPin = SSID[0];
			System.out.println(issuedPin);
			stringarray = issuedPin.split(" ");
			int j = 1;
			for (int i = 0; i < (stringarray.length); i++) {
				XLUtils.setCellData("SSID" + (j),
						stringarray[i].replace("SSID:", " ").replace(",", " ").trim().toString());
				XLUtils.setCellData("Password" + (j), stringarray[i + 1].replace("Password:", " ").trim().toString());

				i++;
				j++;
			}
		} else {
			String[] stringarray = PIN.split(" ");
			int j = 1;
			for (int i = 0; i < (stringarray.length); i++) {
				XLUtils.setCellData("SSID" + (j),
						stringarray[i].replace("SSID:", " ").replace(",", " ").trim().toString());
				XLUtils.setCellData("Password" + (j), stringarray[i + 1].replace("Password:", " ").trim().toString());

				i++;
				j++;
			}
		}

	}
	
}
