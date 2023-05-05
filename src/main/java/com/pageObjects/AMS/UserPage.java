package com.pageObjects.AMS;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BasePage;
import com.utilities.XLUtils;

public class UserPage extends BasePage {

	LogInPage AMSLogin;

	// Function to call the driver
	public UserPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// *************************************|Locators|****************************
	// Create User -----------------------------------------//

	// Items Per Page dropdown on screen
	@FindBy(xpath = "//select[@class='sort']")
	WebElement ItemsPerPageDDLoc;

	// Search By textbox on the screen
	@FindBy(xpath = "//input[@id='search']")
	WebElement SearchByTextboxReqWindowLoc;

	// After Search
	// ---------------------------------------------------------------------------
	// Visible Table
	@FindBy(xpath = "//table//tbody")
	WebElement VisibleTableLoc;
	String presenttable = "//table//tbody";

	// Visible rows
	@FindBy(xpath = "//table//tbody//tr")
	WebElement VisibleRowsLoc;
	String presentrows = "//table//tbody//tr";

	// Visible Columns
	@FindBy(xpath = "//tbody//tr//td") // Asset Number
	WebElement VisibleColumnsLoc;
	String presentcols = "//tbody//tr//td";

	// "Data Not Found...!" Message on the screen
	@FindBy(xpath = "//span[contains(text(),' Data')]")
	WebElement DataNotFoundMessLoc;

	// Copyright Message on screen at the bottom
	@FindBy(xpath = "//footer/label[1]")
	WebElement CopyRightMessage1Loc;
	@FindBy(xpath = "//footer/label[2]")
	WebElement CopyRightMessage2Loc;

	// User Edit tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-edit ml-5']")
	WebElement EdittooltipLoc;

	// User Delete tooltip
	@FindBy(xpath = "//td//*[@class='fa fa-trash']")
	WebElement DeletetooltipLoc;

//	----------------------------------------------

	// Create User Button
	@FindBy(xpath = "//button[contains(text(),'Create User ')]")
	WebElement CretUserBtnLoc;

	// Create User window title
	@FindBy(xpath = "//*[@id='exampleModalCenterTitle']")
	WebElement CrteUserwindowTitleLoc;

	// User Name Label
	@FindBy(xpath = "//div[@id='createUser']//label[@for='userForm' and contains(text(),'User Name')]")
	WebElement UserNameLabelLoc;

	// Enter User Name textbox
	@FindBy(xpath = "//div[@id='createUser']//input[@placeholder='Enter User Name']")
	WebElement EntrUserNameLoc;

	// Error Message 1
	@FindBy(xpath = "//div[@id='createUser']//div[normalize-space()='username is required']")
	WebElement EntUsernameErrorMessageLoc;

	// Employee ID Label
	@FindBy(xpath = "//div[@id='createUser']//label[@for='userForm'][contains(text(),'Employee ID')]")
	WebElement EmpIdLabelLoc;

	// Enter Employee ID textbox
	@FindBy(xpath = "//div[@id='createUser']//input[contains(@placeholder,'Enter Employee ID')]")
	WebElement EntrEmpIdLoc;

	// Error Message 2
	@FindBy(xpath = "//div[@id='createUser']//div[@class='p-error'][contains(text(),'employee id is required')]")
	WebElement EntEmpIdErrorMessageLoc;

	// User Email Label
	@FindBy(xpath = "//div[@id='createUser']//label[@for='userForm'][normalize-space()='User Email']")
	WebElement UserEmailLabelLoc;

	// Enter User Email textbox
	@FindBy(xpath = "//div[@id='createUser']//input[@type='email']")
	WebElement EntrUserEmailLoc;

	// Error Message 3
	@FindBy(xpath = "//div[@id='createUser']//div[@class='p-error'][normalize-space()='email is required']")
	WebElement EntUserEmailErrorMessageLoc;

	// Role Name Label
	@FindBy(xpath = "//div[@id='createUser']//label[@for='userForm'][normalize-space()='Role Name']")
	WebElement RoleNameLabelLoc;

	// Select Role Drop Down
	@FindBy(xpath = "//div[@id='createUser']//select")
	WebElement SelectRoleLoc;

	// Error Message 3
	@FindBy(xpath = "//div[@id='createUser']//div[@class='p-error'][contains(text(),'role is required')]")
	WebElement SelectRoleErrorMessageLoc;

	// Password Label
	@FindBy(xpath = "//div[@id='createUser']//label[contains(text(),'Password')]")
	WebElement PasswordLabelLoc;

	// Enter Password textbox
	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement EntrPasswordLoc;

	// Error Message 4
	@FindBy(xpath = "//div[contains(text(),'password is required')]")
	WebElement EntPasswordErrorMessageLoc;

	// Create Button
	@FindBy(xpath = "//button[@id='closeModal' and contains(text(),'Create')]")
	WebElement CreateButtonLoc;

	// Cancel Button
	@FindBy(xpath = "//div[@id='createUser']//button[@type='button'][contains(text(),'Cancel')]")
	WebElement CancelButtonLoc;

	// Message Popup after Creating User
	// Actual Message -> "Record Created Successfully!"
	@FindBy(xpath = "(//*[@id='swal2-title'])")
	WebElement MessAfterCreateAssetUserLoc;
	// OK Button to close the message popup
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement OkBtnMessPopCreateAssetUserLoc;

	// * Edit User

	// Update User Name
	@FindBy(xpath = "//div[@id='edit']//input[@placeholder='Enter User Name']")
	WebElement UpdtUsernameLoc;

	// Error message 1 on Edit window for User name
	@FindBy(xpath = "//div[@id='edit']//div[@class='p-error'][normalize-space()='username is required']")
	WebElement ErrMess1EditWindoqLoc;

	// Update Employee ID
	@FindBy(xpath = "//div[@id='edit']//input[@placeholder='Enter Employee ID']")
	WebElement UpdtEmployeeIDLoc;

	// Error message 2 on Edit window for Employee ID
	@FindBy(xpath = "//div[@id='edit']//div[normalize-space()='User code is required']")
	WebElement ErrMess2EditWindoqLoc;

	// Update Email
	@FindBy(xpath = "//div[@id='edit']//input[@type='email']")
	WebElement UpdtEmailLoc;

	// Error message 3 on Edit window for Email
	@FindBy(xpath = "//div[@id='edit']//div[@class='p-error'][normalize-space()='email is required']")
	WebElement ErrMess3EditWindoqLoc;

	// Update Role
	@FindBy(xpath = "//div[@id='edit']//select")
	WebElement UpdtRoleLoc;

	// Error message 4 on Edit window for Email
	@FindBy(xpath = "//div[@id='edit']//div[@class='p-error'][normalize-space()='role is required']")
	WebElement ErrMess4EditWindoqLoc;

	// Successfully Update Message
	@FindBy(xpath = "//*[@id='swal2-title']")
	WebElement UpdateMessLoc;

	// Update OK Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement UpdateMessOkBtnLoc;

	// Cancel Button in the Edit window
	@FindBy(xpath = "//div[@id='edit']//button[@type='button'][normalize-space()='Cancel']")
	WebElement CancelButtonEditWindoqLoc;

	// Update Button in Edit window
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	WebElement UpdateButtonEditWindoqLoc;

	// Delete User...........................
	// Delete Confirmation message
	@FindBy(xpath = "//button[contains(text(),'Yes, Delete It!')]")
	WebElement ConfirmBeforeDeleteLoc;
	// After deletion message
	@FindBy(xpath = "//*[@id='swal2-title']") // //*[contains(text(),'Deleted')]
	WebElement AfterDeletionMessLoc;
	// Click Ok Button
	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement ClickOKBtnDeleteLoc;

	// *************************************|Methods|*****************************

	// Select Item from "Items per Page Drop-down"
	public void ItemsPerPageDropDown(String SelectText) {
		waitForFindElementPresent(ItemsPerPageDDLoc); // Create object of the Select class
		Select items = new Select(ItemsPerPageDDLoc);
		items.selectByVisibleText(SelectText);
		System.out.println("Inside ItemsPerPageDropDown() : Selected Item is - " + SelectText);
	}

	// Search the User using Search Box
	public void SearchUser(String UsersStatusName) throws IOException {
		System.out.println("Inside SearchUser()");
		waitForFindElementPresent(SearchByTextboxReqWindowLoc);
		SearchByTextboxReqWindowLoc.clear();
		SearchByTextboxReqWindowLoc.sendKeys(XLUtils.FetchExcelData(UsersStatusName));
		System.out.println("Serched Users Status for User Name(" + (XLUtils.FetchExcelData(UsersStatusName)) + ")");
	}

	// Verify "Data Not Found!" Message is displayed.
	public void VerifyDataNotFoundMessDisplayed() {
		if (DataNotFoundMessLoc.isDisplayed() == true) {
			String DNFMessage = DataNotFoundMessLoc.getText();
			System.out.println("Message is '" + DNFMessage + "'");
		}
	}

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
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Get Row data
	public void GetRowData() throws IOException {

		// To locate table.
		WebElement mytable = driver.findElement(By.xpath(presenttable));

		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();

		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);
			System.out.println("All Rows");
			System.out.print("| ");
			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				if (celtext != null) {
					System.out.print(celtext);
				} else if (celtext == null) {
					System.out.print("NullValue");
				}
				System.out.print(" | ");
			}
			System.out.println("\n-------------------------------------------------- ");
		}
	}

	public void ClickCreateUserButton() {
		waitForFindElementPresent(CretUserBtnLoc);
		CretUserBtnLoc.click();
	}

	public String CreateUserWindowTitle() {
		waitForFindElementPresent(CrteUserwindowTitleLoc);
		return CrteUserwindowTitleLoc.getText();
	}

	public String UserTxtBoxLabel() {
		waitForFindElementPresent(UserNameLabelLoc);
		return UserNameLabelLoc.getText();
	}

	public void ClickInsideEnterUserName() {
		waitForFindElementPresent(EntrUserNameLoc);
		EntrUserNameLoc.click();
	}

	public void EnterUserName(String Username) throws IOException {
		ClickInsideEnterUserName();
		EntrUserNameLoc.sendKeys(XLUtils.FetchExcelData(Username));
	}

	public void ValidateErrorMessage1(String ExErrorMess) throws IOException {
		String ErrorMess = EntUsernameErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, XLUtils.FetchExcelData(ExErrorMess));
	}

	public String EmployeeIDLabel() {
		waitForFindElementPresent(EmpIdLabelLoc);
		return EmpIdLabelLoc.getText();
	}

	public void ClickInsideEmpId() {
		waitForFindElementPresent(EntrEmpIdLoc);
		EntrEmpIdLoc.click();
	}

	public void EnterEmployeeID(String EMPID) throws IOException {
		ClickInsideEmpId();
		EntrEmpIdLoc.sendKeys(XLUtils.FetchExcelData(EMPID));
	}

	public void ValidateErrorMessage2(String ExErrorMess) throws IOException {
		String ErrorMess = EntEmpIdErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, XLUtils.FetchExcelData(ExErrorMess));
	}

	public String EmailLabel() {
		waitForFindElementPresent(UserEmailLabelLoc);
		return UserEmailLabelLoc.getText();
	}

	public void ClickInsideEmail() {
		waitForFindElementPresent(EntrUserEmailLoc);
		EntrUserEmailLoc.click();
	}

	public void EnterEmail(String Email) throws IOException {
		ClickInsideEmail();
		EntrUserEmailLoc.sendKeys(XLUtils.FetchExcelData(Email));
	}

	public void ValidateErrorMessage3(String ExErrorMess) throws IOException {
		String ErrorMess = EntUserEmailErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, XLUtils.FetchExcelData(ExErrorMess));
	}

	public String RoleNameLabel() {
		waitForFindElementPresent(RoleNameLabelLoc);
		return RoleNameLabelLoc.getText();
	}

	public void ClickRole() {
		waitForFindElementPresent(SelectRoleLoc);
		SelectRoleLoc.click();
	}

	public void SelectRole(String Role) throws IOException {
		ClickRole();
		SelectRoleLoc.click();
		// Create object of the Select class
		Select items = new Select(SelectRoleLoc);
		items.selectByVisibleText(XLUtils.FetchExcelData(Role));
		System.out.println("Inside SelectItemFromItemsPerPageDropDown() : Selected Item is - " + Role);
	}

	public void ValidateErrorMessage4(String ExErrorMess) throws IOException {
		String ErrorMess = SelectRoleErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, XLUtils.FetchExcelData(ExErrorMess));
	}

	public String PasswordLabel() {
		waitForFindElementPresent(PasswordLabelLoc);
		return PasswordLabelLoc.getText();
	}

	public void ClickInsidePassword() {
		waitForFindElementPresent(EntrPasswordLoc);
		EntrPasswordLoc.click();
	}

	public void EnterPassword(String Password) throws IOException {
		ClickInsidePassword();
		EntrPasswordLoc.sendKeys(XLUtils.FetchExcelData(Password));
	}

	public void ValidateErrorMessage5(String ExErrorMess) throws IOException {
		String ErrorMess = EntPasswordErrorMessageLoc.getText();
		Assert.assertEquals(ErrorMess, XLUtils.FetchExcelData(ExErrorMess));
	}

	public void ClickCreateButton() {
		waitForFindElementPresent(CreateButtonLoc);
		CreateButtonLoc.click();
	}

	public void ClickCancelButton() {
		waitForFindElementPresent(CancelButtonLoc);
		CancelButtonLoc.click();
	}

	// SuccessMessAfterCreate
	public void ValidateMessAfterUser(String ExpectedMess) throws IOException {
		// waitForFindElementPresent(MessAfterCreateAssetUserLoc);
		// String ActualMess = MessAfterCreateAssetUserLoc.getText();
		// Assert.assertEquals(ActualMess, XLUtils.FetchExcelData(ExpectedMess));
		OkBtnMessPopCreateAssetUserLoc.click();
	}

	/// Update Users Window ///

	public void ClickEditTooltip() {
		waitForFindElementPresent(EdittooltipLoc);
		EdittooltipLoc.click();
	}

	public void EnterUserNameToUpdate(String Username) throws IOException {
		waitForFindElementPresent(UpdtUsernameLoc);
		UpdtUsernameLoc.clear();
		UpdtUsernameLoc.sendKeys(XLUtils.FetchExcelData(Username));
	}

	public void EnterEmpployeeIdToUpdate(String EmplID) throws IOException {
		waitForFindElementPresent(UpdtEmployeeIDLoc);
		UpdtEmployeeIDLoc.clear();
		UpdtEmployeeIDLoc.sendKeys(XLUtils.FetchExcelData(EmplID));
	}

	public void EnterEmailToUpdate(String Email) throws IOException {
		waitForFindElementPresent(UpdtEmailLoc);
		UpdtEmailLoc.clear();
		UpdtEmailLoc.sendKeys(XLUtils.FetchExcelData(Email));
	}

	public void SelectRoleToUpdate(String Role) throws IOException {
		waitForFindElementPresent(UpdtRoleLoc);
		UpdtRoleLoc.click();
		UpdtRoleLoc.click();
		// Create object of the Select class
		Select items = new Select(UpdtRoleLoc);
		items.selectByVisibleText(XLUtils.FetchExcelData(Role));
		System.out.println("Selected Role is - " + (XLUtils.FetchExcelData(Role)));
	}

	public void ClickCancelButtonInUpdate() {
		waitForFindElementPresent(CancelButtonEditWindoqLoc);
		CancelButtonEditWindoqLoc.click();
	}

	public void ClickUpdateButtonInUpdate() {
		waitForFindElementPresent(UpdateButtonEditWindoqLoc);
		UpdateButtonEditWindoqLoc.click();
	}

	public void ValidateErrorMessage1Update(String ExErrorMess) {
		String ErrorMess = ErrMess1EditWindoqLoc.getText();
		Assert.assertEquals(ErrorMess, ExErrorMess);
	}

	public void ValidateUpdatedSuccessMess(String ExMess) throws IOException {
		waitForFindElementPresent(UpdateMessLoc);
		String ActMessage = UpdateMessLoc.getText();
		Assert.assertEquals(ActMessage, XLUtils.FetchExcelData(ExMess));
		UpdateMessOkBtnLoc.click();
		System.out.println(ActMessage);
	}

	/// Delete User ///
	public void ClickDeleteTooltip() {
		waitForFindElementPresent(DeletetooltipLoc);
		DeletetooltipLoc.click();
	}

	// Delete Confirmation message
	public void YesDeleteIt(String ExMess) throws IOException {
		waitForFindElementPresent(ConfirmBeforeDeleteLoc);
		ConfirmBeforeDeleteLoc.click();
		waitForFindElementPresent(AfterDeletionMessLoc);
		String Mess = AfterDeletionMessLoc.getText();
		Assert.assertEquals(Mess, XLUtils.FetchExcelData(ExMess));
		waitForFindElementPresent(ClickOKBtnDeleteLoc);
		ClickOKBtnDeleteLoc.click();
		System.out.println(Mess);
	}

}
