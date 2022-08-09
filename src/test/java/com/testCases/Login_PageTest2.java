package com.testCases;




import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class Login_PageTest2 extends BaseClass {
	LoginPage loginPage;
	
	@Test(priority=0)
	public void Login_PageTest2() 
	{
		loginPage = new LoginPage(driver);
		loginPage.Login(readconfig.getsysUsername(),readconfig.getsysPassword());
		String title=loginPage.getLoginPageTitle();
		System.out.println("Page title is" +title);
		Assert.assertEquals(title, "SEAB iEXAMS");
	}
	
	
	/*@Test(dataProvider="Logindata")
	public void loginiExamExcelData(String uname, String pwd)  
	{
		
		loginPage = new LoginPage(driver);
		loginPage.Login(uname,pwd);
		String title=loginPage.getLoginPageTitle();
		System.out.println("Page title is" +title);
		Assert.assertEquals(title, "SEAB iEXAMS2");
	}
	
	@DataProvider(name="Logindata")
	String [][] getData()
	{
		String path=System.getProperty("user.dir") +"/src/main/java/com/testData/Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum] [colcount];
		
		for(int i=1;i<=rownum;i++)
			
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
	}*/
}
