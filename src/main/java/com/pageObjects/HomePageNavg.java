package com.pageObjects;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.base.BasePage;

public class HomePageNavg extends BasePage {

	
	
  public HomePageNavg(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

    @FindBy(id="hamburger")
    WebElement leftPannel; 
	
    @FindBy(xpath="//span[contains(text(),'System administration')]")
    WebElement sysAdmin;
    
    @FindBy(xpath="//span[contains(text(),'Password rules')]")
    WebElement pwdRules;
        
    @FindBy(xpath="(//*[@type='text'])[1]")
    WebElement pwdLength;
    
    @FindBy(xpath="//*[contains(text(),'SUBMIT')]")
    WebElement submtBtn;
        
    @FindBy(xpath="//*[contains(text(),'Number of characters is required')]")
    WebElement pwdLengthErr;
    
    @FindBy(xpath="//*[contains(text(),'PAST REQUESTS')]")
    WebElement pastRequests;
    
    @FindBy(xpath="//*[contains(text(),'Search past requests')]")
    WebElement searchpastRequests;
    
    @FindBy(xpath="(//*[contains(text(),'All')])[2]")
    WebElement allDropdown;
    
    @FindBy(xpath="(//*[contains(text(),'Approved')])[4]")
    WebElement approved;
    
    @FindBy(xpath="(//*[contains(text(),'Withdrawn')])[2]")
    WebElement withdrawn;
   
	public String gePwdLengthErrText() {
		return findText(pwdLengthErr);
	}
	

	// Returns Page title
	public String getLoginPageTitle() {
		return getPageTitle();
		
	}
		
	public void waitLeftPannel() {
		waitForFindElementPresent(leftPannel);
		
	}
	public void waitPwdLength() {
		waitForFindElementPresent(pwdLength);
		
	}
	
	public void waitSysAdmin() {
		waitForFindElementPresent(sysAdmin);
		
	}
	
	public void waitPwdLengthErr() {
		waitForFindElementPresent(pwdLengthErr);
		
	}
	
	public void waitsearchPastRequest() {
		waitForFindElementPresent(searchpastRequests);
		
	}
	
	public void waitApprovedRequest() {
		waitForFindElementPresent(approved);
		
	}
	
    public void clickLeftpannel() 
	{
		
    	waitLeftPannel();
		executor.executeScript("arguments[0].click();", leftPannel);
		waitSysAdmin();
		executor.executeScript("arguments[0].click();", sysAdmin);
		executor.executeScript("arguments[0].click();", pwdRules);
		waitPwdLength();
	}
	
	public String clearPwdLength()
	{
		
		pwdLength.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		waitLeftPannel();
		executor.executeScript("arguments[0].click();", leftPannel);
		submtBtn.click();
		executor.executeScript("scroll(0, -250);");
		waitPwdLengthErr();
		return gePwdLengthErrText();
		
		
	}
	
	public void pastRequests() 
	{
		executor.executeScript("arguments[0].click();", leftPannel);
		pastRequests.click();
		waitsearchPastRequest();
		logger.info("Past Requests results are displayed");
	}
	
	public void filterPastRequests() 
	{
		allDropdown.click();
		waitApprovedRequest();
		approved.click();
		logger.info("Results are filtered by Approved status");
		implicitWait();
		withdrawn.click();
		logger.info("Results are filtered by Withdrawn status");
	}
	
}
