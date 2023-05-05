package com.pageObjects.AMS;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

///----------------------------------------------------------------------------------------------------------------------	
	// Visible Table
	@FindBy(xpath = "//table//tbody")
	WebElement VisibleTableLoc;
	String presenttable = "//table//tbody";
	String presentrows = "//table//tbody//tr";

	// "Data Not Found...!" Message on the screen
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

	// Assets Group Delete tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement AssetGrpDeletetooltipLoc;

	// Delete Asset Group
	// Delete the Confirmation message
	@FindBy(xpath = "//button[contains(text(),'Yes, Delete It!')]")
	WebElement ConfirmBeforeDeleteLoc;
	// After deletion message
	@FindBy(xpath = "//*[@id='swal2-title']")
	WebElement AfterDeletionMessLoc;
	// Click the Ok Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement ClickOKBtnDeleteLoc;

	// Successfully Update Mess
	@FindBy(xpath = "//*[@id='swal2-title']")
	WebElement UpdateMessLoc;

	// Update OK Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement UpdateMessOkBtnLoc;

	// Update Button in the Edit window
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateButtonEditWindoqLoc;

	// Assets Group Edit tooltip
	@FindBy(xpath = "//tr//*[@class='fa fa-edit' and @type='button']")
	WebElement AssetGrpEdittooltipLoc;

	// Message Popup after Record Created
	// Actual Message -> "Record Created Successfully!"
	@FindBy(xpath = "(//*[@id='swal2-title'])")
	WebElement MessAfterCreatedLoc;
	// OK Button to close the message popup
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkBtnMessPopCreatedLoc;

///-----------------------------------------------------------------------------------------------------------------------

	// Print Testcase name
	public void TestCaseName(String EnterTestCaseName) {
		System.out.println("\nInside " + EnterTestCaseName + "\n------------------------------------------------");
	}

	public void ManualTestCount(String ManualTestCount) {
		System.out.println("Manual Testcases Covered : " + ManualTestCount);
	}

	public void TotalTestCount(String ManualTestCount, String AutomationTestCount) {
		System.out.println("\n-------------------------------------------------------\nTotal Manual Testcase Count : "
				+ ManualTestCount + "\nTotal Automation Testcase Count : " + AutomationTestCount);
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

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				System.out.print(celtext);
				System.out.print(" ");
			}
			System.out.println("\n-------------------------------------");
		}
	}

	// Verify "Data Not Found!" The message is displayed.
	public void VerifyDataNotFoundMessDisplayed() {
		if (DataNotFoundMessLoc.isDisplayed() == true) {
			String DNFMessage = DataNotFoundMessLoc.getText();
			System.out.println("Message is '" + DNFMessage + "'");
		}
	}

	// Verify Record is present
	public void VerifyRecordIsPresent() {

		// check if element visible
		try {
			List<WebElement> rows = driver.findElements(By.xpath(presentrows));
			if (rows.size() > 0) {
				if (rows.size() == 1) {
					System.out.println(rows.size() + " Record is present.");
				} else {
					System.out.println(rows.size() + " Records are present.");
				}

			} else {
				System.out.println("Record is not present.");
				VerifyDataNotFoundMessDisplayed();
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Verify the table is present and if present get the table data
	public void GetTableData(String TableName) {
		// check if element visible
		try {
			List<WebElement> rows = driver.findElements(By.xpath(presentrows));
			if (rows.size() > 0) {
				if (rows.size() == 1) {
					System.out.println(rows.size() + " Record is present.");
					GetRowData(TableName);
				} else {
					System.out.println(rows.size() + " Records are present.");
					GetRowData(TableName);
				}

			} else {
				System.out.println("Record is not present.");
				VerifyDataNotFoundMessDisplayed();
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// SuccessMessAfterCreate
	public void ValidateMessAfterCreated(String ExpectedMess) throws IOException {
		waitForFindElementPresent(MessAfterCreatedLoc);
		String ActualMess = MessAfterCreatedLoc.getText();
		Assert.assertEquals(ActualMess, XLUtils.FetchExcelData(ExpectedMess));
		OkBtnMessPopCreatedLoc.click();
		System.out.println("Message displayed is " + ActualMess);
	}

	// Verify Edit button/tooltip is clickable
	public void ClickEditTooltip() {
		waitForFindElementPresent(AssetGrpEdittooltipLoc);
		AssetGrpEdittooltipLoc.click();
	}

	// Verify Update Button functionality
	public void ClickUpdateButtonInUpdate() {
		waitForFindElementPresent(UpdateButtonEditWindoqLoc);
		UpdateButtonEditWindoqLoc.click();
	}

	// Validate Successfully updated message
	public void ValidateUpdatedSuccessMess(String ExMess) throws IOException {
		waitForFindElementPresent(UpdateMessLoc);
		String ActMessage = UpdateMessLoc.getText();
		Assert.assertEquals(ActMessage, XLUtils.FetchExcelData(ExMess));
		UpdateMessOkBtnLoc.click();
		System.out.println(ActMessage);
	}

	/// Delete Data
	public void ClickDeleteTooltip() {
		waitForFindElementPresent(AssetGrpDeletetooltipLoc);
		AssetGrpDeletetooltipLoc.click();
	}

	// Delete the Confirmation message
	public void YesDeleteIt(String ExMess) throws IOException, InterruptedException {
		waitForFindElementPresent(ConfirmBeforeDeleteLoc);
		ConfirmBeforeDeleteLoc.click();
		Thread.sleep(1000);
		waitForFindElementPresent(AfterDeletionMessLoc);
		String Mess = AfterDeletionMessLoc.getText();
		Assert.assertEquals(Mess, XLUtils.FetchExcelData(ExMess));
		waitForFindElementPresent(ClickOKBtnDeleteLoc);
		ClickOKBtnDeleteLoc.click();
		System.out.println(Mess);
	}
}
