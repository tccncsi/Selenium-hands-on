package com.pageObjects.AMS;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.BasePage;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class CommonPage extends BasePage {

	// Function to call the driver
	public CommonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ReadConfig readconfig = new ReadConfig();

	// Visible Table
	@FindBy(xpath = "//table//tbody")
	WebElement VisibleTableLoc;
	String presenttable = "//table//tbody";

	// Print Testcase name
	public void TestCaseName(String EnterTestCaseName) {
		System.out.println("\nInside " + EnterTestCaseName + "\n------------------------------------------------");
	}

	// Print the message
	public void Print(String UserInput) {
		System.out.println(UserInput);
	}

	// Get Page Title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Get Page URL
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	// Get Page Source
	public String getCurrentPageSource() {
		driver.getPageSource();
		return driver.getPageSource();
	}

	public String ReadExcel(String data) throws IOException {
		return XLUtils.FetchExcelData(data);
	}

	public void RefreshPage() {
		driver.navigate().refresh();
	}

	// Get Row data
	public void GetRowData(String data) throws IOException {

		// To locate the table.
		WebElement mytable = driver.findElement(By.xpath(presenttable));

		// To locate rows of the table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate the rows In the table.
		int rows_count = rows_table.size();

		System.out.println("\nTable of " + data + " : \n----------------------------------");

		// Loop will execute till the last row of the table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();

			/*
			 * System.out.println("Number of cells In Row " + row + " are " +
			 * columns_count);
			 */

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				if (celtext != null) {
					System.out.print(celtext);
				} else if (celtext == null) {
					System.out.print("NullValue");
				}
				System.out.print(" ");
			}
			System.out.println(
					"\n------------------------------------------------------------------------------------- ");
		}
	}

	public void name() {

	}
}
