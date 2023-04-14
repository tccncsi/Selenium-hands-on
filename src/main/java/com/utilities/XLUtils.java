package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xlfile, String xlsheet) {
		int rowcount = 0;
		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			rowcount = ws.getLastRowNum();
			wb.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println(" File NotFound Exception has been occured");
		} catch (IOException e) {
			System.out.println(" IOException has been occured");
		}
		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) {
		int cellcount = 0;
		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) {
		String data = null;
		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			try {
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue(cell);
				return cellData;
			} catch (Exception e) {
				data = "";
			}
			wb.close();
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);

		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		// cell = ws.getRow(rownum).getCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public static void setColumnName(ArrayList<String> columns) throws IOException {
		String path = System.getProperty("user.dir") + "\\Data Form\\FormDataGenerator.xlsx";

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		FileOutputStream fos = null;

		XSSFSheet xs = wb.getSheet("Sheet1");
		xs.createRow(0);

		for (int i = 0; i < columns.size(); i++) {

			xs.getRow(0).createCell(i).setCellValue(columns.get(i));
			System.out.println(xs.getRow(0).getCell(i).toString());
			fos = new FileOutputStream(f);
			wb.write(fos);
		}

		wb.close();
		fos.close();
	}

	static String UserDirectory = System.getProperty("user.dir");
	static String ExcelPath = "\\src\\main\\java\\com\\testData\\";
	static String FileName1 = "AMSTestData.xlsx";

	public static String FetchExcelData(String EleName) throws IOException {

		String path = UserDirectory + ExcelPath + FileName1;
		String temp[][] = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		for (int a = 0; a < wb.getNumberOfSheets(); a++) {
			// System.out.println("Current sheet name is "+wb.getNumberOfSheets());
			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			int rowno = xs.getLastRowNum();
			String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

			for (int i = 0; i < rowno; i++) {
				int cellno = xs.getRow(i).getLastCellNum();
				// System.out.println("Row count is "+rowno+" and cell count is "+cellno);

				for (int j = 0; j < cellno; j++) {
					data[i][j] = xs.getRow(i).getCell(j).toString();
					// System.out.println(data[i][j]);
					if (data[i][j].equalsIgnoreCase(EleName) && data[i][j] != null) {
						data[i][j + 1] = xs.getRow(i).getCell(j + 1).toString();
						temp[x][y] = data[i][j + 1];
						break;
					}

				}

			}
		}
		// System.out.println(temp[x][y]);
		return temp[x][y];
	}

	public static String FetchGeneratorData(String EleName) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\TestData.xlsx";
		String temp[][] = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		for (int a = 0; a < wb.getNumberOfSheets(); a++) {
			// System.out.println("Current sheet name is "+wb.getNumberOfSheets());
			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			int rowno = xs.getLastRowNum();
			String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

			for (int i = 0; i < rowno; i++) {
				int cellno = xs.getRow(i).getLastCellNum();
				// System.out.println("Row count is "+rowno+" and cell count is "+cellno);

				for (int j = 0; j < cellno; j++) {
					data[i][j] = xs.getRow(i).getCell(j).toString();
					// System.out.println(data[i][j]);
					if (data[i][j].equalsIgnoreCase(EleName) && data[i][j] != null) {
						data[i][j + 1] = xs.getRow(i).getCell(j + 1).toString();
						temp[x][y] = data[i][j + 1];
						break;
					}

				}

			}
		}
		// System.out.println(temp[x][y]);
		return temp[x][y];
	}

	// fetch column name from test data sheet and print under data generator
	public static String FetchColumnName(int counter, String ele) throws IOException {

		String path = // System.getProperty("user.dir") +
						// "\\src\\main\\java\\com\\testData\\New.xlsx";
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\TestData.xlsx";

		String temp[][] = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		XSSFSheet xs = wb.getSheet("Sheet1");
		int rowno = xs.getLastRowNum();
		int colno = xs.getRow(0).getLastCellNum();
		ArrayList<String> al = new ArrayList<String>();
		String data[][] = new String[rowno][colno];

		for (int i = 0; i < rowno; i++) {
			for (int j = 0; j < colno; j++) {
				data[0][j] = xs.getRow(0).getCell(j).toString();
				if (data[0][j] != null) {
					temp[x][y] = data[0][j];
					// if(temp[x][y].toString().equalsIgnoreCase(ele))
					// {
					System.out.println(temp[x][y]);
					// XLUtils.setCellDataGenerator(path_data, "Sheet1", 0, j, temp[x][y]);
					al.add(temp[x][y]);
					// System.out.println(al);

					// }

				}

			}

		}

		return temp[x][y];
		// return al;
	}

	// fetch all the column name values from test data sheet to call their
	// respective function
	public static ArrayList<String> fetchColumnData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\FormTestData.xlsx";
		String temp[][] = new String[2][2];
		String tempData[][] = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		ArrayList<String> al = new ArrayList<String>();
		XSSFSheet xs = wb.getSheet("Columns");
		int rowno = xs.getLastRowNum();
		String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

		tempData[x][y] = "";
		int cellno = xs.getRow(0).getLastCellNum();

		for (int k = 0; k < cellno; k++) {
			data[0][k] = xs.getRow(0).getCell(k).toString();

			if (data[0][k] != null) {
				data[0][0 + k] = xs.getRow(0).getCell(0 + k).toString();

				temp[x][y] = data[0][0 + k];
				// System.out.println(temp[x][y]);

			}
			al.add(temp[x][y]);
			// System.out.println(al);

		}

		return al;
	}

	public static String FetchExcelTestCaseData(String TestcaseName) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\TestCases.xlsx";
		String temp[][] = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		for (int a = 0; a < wb.getNumberOfSheets(); a++) {
			// System.out.println("Current sheet name is "+wb.getNumberOfSheets());
			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			int rowno = xs.getLastRowNum();
			String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

			for (int i = 0; i < rowno; i++) {
				int cellno = xs.getRow(i).getLastCellNum();
				// System.out.println("Row count is "+rowno+" and cell count is "+cellno);

				for (int j = 0; j < cellno; j++) {
					data[i][j] = xs.getRow(i).getCell(j).toString();
					// System.out.println(data[i][j]);
					if (data[i][j].equalsIgnoreCase(TestcaseName) && data[i][j] != null) {
						data[i][j + 1] = xs.getRow(i).getCell(j + 1).toString();
						data[i][j + 2] = xs.getRow(i).getCell(j + 2).toString();
						data[i][j + 3] = xs.getRow(i).getCell(j + 3).toString();
						data[i][j + 4] = xs.getRow(i).getCell(j + 4).toString();

						temp[x][y] = data[i][j + 1] + "\n\n" + data[i][j + 2] + "\n\n" + data[i][j + 3] + "\n\n"
								+ data[i][j + 4];
						break;
					}
				}

			}
		}
		System.out.println("Excel data: " + temp[x][y]);
		return temp[x][y];
	}

	public static void setCellData(String EleName, String text) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\FormTestData.xlsx";

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		FileOutputStream fos = null;
		for (int a = 0; a < wb.getNumberOfSheets(); a++) {
			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			int rowno = xs.getLastRowNum();
			String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

			for (int i = 0; i < rowno; i++) {
				int cellno = xs.getRow(i).getLastCellNum();

				for (int j = 0; j < cellno; j++) {
					data[i][j] = xs.getRow(i).getCell(j).toString();

					if (data[i][j].equalsIgnoreCase(EleName) && data[i][j] != null) {
						Cell c = xs.getRow(i).createCell(j + 1);
						c.setCellValue(text);
						fos = new FileOutputStream(f);
						wb.write(fos);
					}

				}

			}
		}

		fos.close();
	}

	public static int setDataGeneratorDetails(String EleName, int counter, String text) throws IOException {

		String path = System.getProperty("user.dir") + "\\Data Form\\FormDataGenerator.xlsx";

		File f = new File(path);

		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		FileOutputStream fos = null;
		for (int a = 0; a < wb.getNumberOfSheets(); a++) {
			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			// no limitation to the last row
			int column = xs.getRow(0).getLastCellNum();
			for (int i = 0; i < column; i++) {
				xs.createRow(1048575).createCell(i).setCellValue(".");
			}

			int rowno = xs.getLastRowNum();
			int colno = xs.getRow(0).getLastCellNum();
			String data[][] = new String[rowno][colno];

			for (int i = counter; i <= rowno; i++) {

				for (int j = 0; j < colno; j++) {
					data[0][j] = xs.getRow(0).getCell(j).toString(); // to get the header name contents

					if (data[0][j].equalsIgnoreCase(EleName) && data[0][j] != null) {

						if (j == 0 || xs.getRow(counter + 1) == null) // for first column only we will create row
						{
							xs.createRow(counter + 1); // to update fresh entry in new row
						}

						Cell c = xs.getRow(counter + 1).createCell(j);
						c.setCellValue(text);
						fos = new FileOutputStream(f);
						wb.write(fos);
						counter++; // update counter to enter data in columns
						i = rowno; // to exit the row loop

					}

				}

			}
		}

		fos.close();
		return counter;
	}

	public static String getDataGeneratorDetails(String EleName, int counter) throws IOException {

		String path = System.getProperty("user.dir") + "\\Data Form\\FormDataGenerator.xlsx";
		String[][] temp = new String[2][2];

		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int x = 0;
		int y = 0;

		for (int a = 0; a < wb.getNumberOfSheets(); a++) {

			String sheetName = wb.getSheetName(a);
			XSSFSheet xs = wb.getSheet(sheetName);
			int rowno = xs.getLastRowNum();
			String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];

			for (int i = counter; i < rowno; i++) {
				int cellno = xs.getRow(i).getLastCellNum();

				for (int j = 0; j < cellno; j++) {
					data[0][j] = xs.getRow(0).getCell(j).toString();

					if (data[0][j].equalsIgnoreCase(EleName)) {
						data[i][j] = xs.getRow(i + 1).getCell(j).toString();
						temp[x][y] = data[i][j];
						// System.out.println(temp[x][y]);
						counter++;
						i = rowno;
					}

				}

			}
		}
		return temp[x][y];

	}

	public static void CreateDefectExcelData(String tcName, String tcSummary, String tcDesc, String defectID,
			String defectStatus, String defectEnv) throws IOException {

		String path = System.getProperty("user.dir") + "\\Defect Report\\JiraDefects.xlsx";
		File myFile_ED = new File(path);
		FileInputStream inputStream_ED = new FileInputStream(myFile_ED);

		XSSFWorkbook workbook_ED = new XSSFWorkbook(inputStream_ED);
		XSSFSheet sheet_ED = workbook_ED.getSheetAt(0);
		Iterator<Row> riterator_ED = sheet_ED.iterator();
		Row row_ED = sheet_ED.createRow(sheet_ED.getLastRowNum() + 1);
		if (sheet_ED.getLastRowNum() == 0) {

		}
		/*
		 * Cell SrNo = row_ED.createCell(0); SrNo.setCellValue("Sr. No.");
		 */

		Cell cellTcName = row_ED.createCell(0);
		cellTcName.setCellValue(tcName);

		Cell cellDefectID = row_ED.createCell(1);
		cellDefectID.setCellValue(defectID);

		Cell cellTcSummary = row_ED.createCell(2);
		cellTcSummary.setCellValue(tcSummary);

		Cell cellTcDesc = row_ED.createCell(3);
		cellTcDesc.setCellValue(tcDesc);

		Cell cellDefectStatus = row_ED.createCell(4);
		cellDefectStatus.setCellValue(defectStatus);

		Cell cellDefectEnv = row_ED.createCell(5);
		cellDefectEnv.setCellValue(defectEnv);

		FileOutputStream os_ED = new FileOutputStream(myFile_ED);
		workbook_ED.write(os_ED);

		System.out.println("Data is successfully written :" + defectID);

		os_ED.close();
		workbook_ED.close();
		inputStream_ED.close();
	}

	public static void CreateDefectExcelDataGeneric(String tcName, String tcSummary, String tcSteps,
			String errorDetails, String browser, String defectEnv, String defectStatus, String screenshotFilePath,
			Boolean screenshotFlag) throws IOException {
		XSSFWorkbook workbook_ED = null;
		XSSFSheet sheet_ED = null;
		FileOutputStream os_ED = null;
		FileInputStream inputStream_ED = null;

		// BasePage.defectCount++;

		try {
			String path = System.getProperty("user.dir") + "\\Defect Report\\GenericDefectList.xlsx";
			File myFile_ED = new File(path);
			inputStream_ED = new FileInputStream(myFile_ED);

			workbook_ED = new XSSFWorkbook(inputStream_ED);
			sheet_ED = workbook_ED.getSheetAt(0);
			Iterator<Row> riterator_ED = sheet_ED.iterator();
			Row row_ED = sheet_ED.createRow(sheet_ED.getLastRowNum() + 1);
			if (sheet_ED.getLastRowNum() == 0) {
			}

			Cell cellTcName = row_ED.createCell(0);
			cellTcName.setCellValue(tcName);

			Cell cellTcSummary = row_ED.createCell(1);
			cellTcSummary.setCellValue(tcSummary);

			Cell cellTcSteps = row_ED.createCell(2);
			cellTcSteps.setCellValue(tcSteps);

			Cell cellDefectDetails = row_ED.createCell(3);
			cellDefectDetails.setCellValue(errorDetails);

			String dateTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()).toString();
			Cell cellDateTime = row_ED.createCell(4);
			cellDateTime.setCellValue(dateTime);

			Cell cellBrowserName = row_ED.createCell(5);
			cellBrowserName.setCellValue(browser);

			Cell cellDefectEnv = row_ED.createCell(6);
			cellDefectEnv.setCellValue(defectEnv);

			Cell cellDefectStatus = row_ED.createCell(7);
			cellDefectStatus.setCellValue(defectStatus);

			// update duplicate defect 0 for each new defect
			Cell cellDuplicateDefect = row_ED.createCell(8);
			cellDuplicateDefect.setCellValue("0");

			os_ED = new FileOutputStream(myFile_ED);
			workbook_ED.write(os_ED);

			/* Code to insert screenshot into excel sheet */

			if (screenshotFlag) {
				System.out.println("Screenshot path: " + screenshotFilePath);
				InputStream is = new FileInputStream(screenshotFilePath);
				byte[] bytes = IOUtils.toByteArray(is);
				int pictureIdx = workbook_ED.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

				// inputStream_ED.close();

				CreationHelper helper = workbook_ED.getCreationHelper();
				// create sheet
				// Sheet sheet = workbook_ED.createSheet();
				// Create the drawing patriarch. This is the top level container for all shapes.
				Drawing drawing = sheet_ED.createDrawingPatriarch();

				// add a picture shape
				ClientAnchor anchor = helper.createClientAnchor();
				// set top-left corner of the picture,
				// subsequent call of Picture#resize() will operate relative to it
				// anchor.setCol1(8);
				anchor.setCol1(9);
				anchor.setRow1(sheet_ED.getLastRowNum());
				Picture pict = drawing.createPicture(anchor, pictureIdx);
				// auto-size picture relative to its top-left corner
				pict.resize();
				pict.resize(0.1, 0.2);

				// save workbook
				try {
					os_ED = new FileOutputStream(myFile_ED);
					workbook_ED.write(os_ED);

					/* workbook_ED.write(os_ED); */
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			// Resize all columns to fit the content size
			for (int i = 0; i < 3; i++) {
				sheet_ED.autoSizeColumn(i);
			}

			System.out.println("Data is successfully written for TC :" + tcName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (inputStream_ED != null) {
				try {
					os_ED.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

			if (workbook_ED != null) {
				try {
					workbook_ED.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}

			if (inputStream_ED != null) {
				try {
					inputStream_ED.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		}

	}

	public static String FetchGenericDefectList(String issueSummary) throws IOException {
		// fetching under genericdefectList whether similar summary exists or not
		String path = System.getProperty("user.dir") + "\\Defect Report\\GenericDefectList.xlsx";
		String temp = null;

		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String summary = cell.getStringCellValue();
				// System.out.print(cell.getStringCellValue() +"\n");
				if (summary.equalsIgnoreCase(issueSummary)) {
					temp = summary;
					// System.out.println("Issue found :------ "+summary);
				}
			}
		}
		return temp;

	}

	public static Boolean isGenericDefectAlreadyPresents(String issueSummary) throws IOException {
		/* Code to check if the defect is already exist in the excel */
		String path = System.getProperty("user.dir") + "\\Defect Report\\GenericDefectList.xlsx";
		if (XLUtils.FetchGenericDefectList(issueSummary) != null) {
			int counter = 0;
			XSSFWorkbook workbook = new XSSFWorkbook(path);
			XSSFSheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String summary = cell.getStringCellValue();
					// System.out.println(cell.getAddress());
					int totalrow = firstSheet.getLastRowNum();
					for (int i = 0; i < totalrow; i++) {
						String defectSummary = XLUtils.getCellData(path, "Defect Dump", i, 1);
						if (summary.equalsIgnoreCase(issueSummary)) {
							counter++;
							System.out.println(counter);
							char c[] = cell.getAddress().toString().toCharArray();
							for (char a : c) {
								if (Character.isDigit(a)) {

									int rownum = Integer.parseInt(Character.toString(a)) - 1;
									String defectStatus = XLUtils.getCellData(path, "Defect Dump", rownum, 7);
									// System.out.println(defectStatus);

									if (defectStatus.equalsIgnoreCase("To Do")
											|| defectStatus.equalsIgnoreCase("In Progress")) {
										counter = 0;
										System.out.println(
												"************************************************************************************************************************************");
										System.out.println(
												"Issue for same test case already exists in Excel with Open Status: "
														+ issueSummary);
										System.out.println(
												"************************************************************************************************************************************");
										break;
									} else if (defectStatus.equalsIgnoreCase("Done")) {
										counter = 1;
										System.out.println(
												"************************************************************************************************************************************");
										System.out.println("This is a new Defect :" + issueSummary);
										System.out.println(
												"************************************************************************************************************************************");

										return true;
									}
								}
							}
						}
					}

				}

			}

		}
		// return null;
		return null;

	}

	public static Boolean isGenericDefectAlreadyPresent(String issueSummary) throws IOException {
		String path = System.getProperty("user.dir") + "\\Defect Report\\GenericDefectList.xlsx";
		int counter = 0;

		if (XLUtils.FetchGenericDefectList(issueSummary) != null) {
			XSSFWorkbook workbook = new XSSFWorkbook(path);
			XSSFSheet firstSheet = workbook.getSheet("Defect Dump");

			int totalrow = firstSheet.getLastRowNum();

			for (int i = 0; i < totalrow + 1; i++) {
				String defectSummary = XLUtils.getCellData(path, "Defect Dump", i, 1);
				String defectStatus = XLUtils.getCellData(path, "Defect Dump", i, 7);

				if (defectStatus.equalsIgnoreCase("Done") && defectSummary.equalsIgnoreCase(issueSummary)) {

					counter = 0;
					continue;

				} else if (defectStatus.equalsIgnoreCase("To Do") || defectStatus.equalsIgnoreCase("In Progress")) {
					if (defectSummary.equalsIgnoreCase(issueSummary)) {

						counter = 1;

						// update the duplicate defect count
						String num = XLUtils.getCellData(path, "Defect Dump", i, 8);
						int number = Integer.parseInt(num) + counter;
						XLUtils.setCellData(path, "Defect Dump", i, 8, Integer.toString(number));

						// update the timestamp for this duplicate defect
						String latestTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()).toString();
						String earlierTime = XLUtils.getCellData(path, "Defect Dump", i, 4);
						String newTime = latestTime + " ," + "\n" + earlierTime;
						XLUtils.setCellData(path, "Defect Dump", i, 4, newTime);
					}
				}

			}
		}

		if (counter == 0) {
			System.out.println(
					"************************************************************************************************************************************");
			System.out.println("This is a new Defect :" + issueSummary);
			System.out.println(
					"************************************************************************************************************************************");
			return true;
		} else {
			System.out.println(
					"************************************************************************************************************************************");
			System.out.println("Issue for same test case already exists in Excel with Open Status: " + issueSummary);
			System.out.println(
					"************************************************************************************************************************************");
			return false;
		}

	}

}