package com.pageObjects.AMS;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;

public class Random extends BasePage {

	// Function to call the driver
	public Random(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Visible Table
	@FindBy(xpath = "//table//tbody")
	WebElement VisibleTableLoc;
	String presenttable = "//table//tbody";
	String presentrows = "//table//tbody//tr";

	// Previous button below the table
	@FindBy(xpath = "//button[contains(text(),'Previous')]")
	WebElement PreviousBtnLoc;

	// Active Page no. (* button below the table)
	@FindBy(xpath = "//*[@class='page-item active']/a[@class='page-link']")
	WebElement PageItemAvtiveBtnLoc;

	// Next button below the table
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	WebElement NextBtnLoc;

	// "Data Not Found...!" Message on the screen
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

///-------------------------------------------------------------------------------

	// Verify "Data Not Found!" The message is displayed.
	public void VerifyDataNotFoundMessDisplayed() {
		if (DataNotFoundMessLoc.isDisplayed() == true) {
			String DNFMessage = DataNotFoundMessLoc.getText();
			System.out.println("Message is '" + DNFMessage + "'");
		}
	}

	// Get Row data
	public void GetData(String data, String pageno) throws IOException {

		// To locate the table.
		WebElement mytable = driver.findElement(By.xpath(presenttable));

		// To locate rows of the table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate the rows In the table.
		int rows_count = rows_table.size();

		String currntpageno = PageItemAvtiveBtnLoc.getText();

		System.out.println("\nTable of " + data + " : \n----------------------------------");

		// Loop will execute till the last row of the table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				System.out.print(celtext);
				System.out.print(" ");
			}
			System.out.println("\n-------------------------------------");
			if (currntpageno != pageno) {
				NextBtnLoc.click();
			} else if ((currntpageno == pageno)) {
				System.out.println("We are on page no. " + currntpageno);
			}
		}
	}

	// Verify the table is present and if present get the table data
	public void GetAllRecords(String TableName, String PageNo) {
		// check if element visible
		try {
			List<WebElement> rows = driver.findElements(By.xpath(presentrows));
			if (rows.size() > 0) {
				if (rows.size() == 1) {
					System.out.println(rows.size() + " Record is present.");
					GetData(TableName, PageNo);
				} else {
					System.out.println(rows.size() + " Records are present.");
					GetData(TableName, PageNo);
				}

			} else {
				System.out.println("Record is not present.");
				VerifyDataNotFoundMessDisplayed();
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Exception in GetTableData : " + e.getStackTrace());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in GetTableData : " + e.getStackTrace());
		}
	}

	// Get Row data
	public void LoggedInUserStatus(String Tablename, String pageno) throws IOException {

		String currntpageno = PageItemAvtiveBtnLoc.getText();
		// Converting String into int using Integer.parseInt()
		int i = Integer.parseInt(currntpageno);
		int pagenumber = Integer.parseInt(pageno);

		while (i <= pagenumber) {

			// To locate the table.
			WebElement mytable = driver.findElement(By.xpath(presenttable));

			// To locate rows of the table.
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			// To calculate the rows In the table.
			int rows_count = rows_table.size();

			System.out.println("\nTable of " + Tablename + " : \n----------------------------------");

			// Loop will execute till the last row of the table.
			for (int row = 0; row < rows_count; row++) {

				// To locate columns(cells) of that specific row.
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				// To calculate no of columns (cells). In that specific row.
				int columns_count = Columns_row.size();

				// Loop will execute till the last cell of that specific row.
				for (int column = 0; column < columns_count; column++) {

					if (column == 1) {
						// To retrieve text from that specific cell.
						String celtext = Columns_row.get(1).getText();
						System.out.print(celtext);
					}
				}

				System.out.println(
						"\n-----------------------------------------------------------------------------------------");
			}
			
			if (i != pagenumber) {
				NextBtnLoc.click();
			} else if (i == pagenumber) {
				System.out.println("We are on page no. " + i);
			}
		}

	}

}