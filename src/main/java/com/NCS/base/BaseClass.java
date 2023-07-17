package com.NCS.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.NCS.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public WebDriver driver;
	public JavascriptExecutor executor;
	public Logger logger; // To log test info.

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void setup(String brwname, String url) {
		logger = Logger.getLogger("Net A Porter Website opened");
		PropertyConfigurator.configure("Log4j.properties");

		try {
			switch (brwname) {
			case "chrome":

				ChromeOptions cap = new ChromeOptions();
				cap.addArguments("--disable-extensions");
				cap.addArguments("--disable-dev-shm-usage");
				System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(cap);
				executor = (JavascriptExecutor) driver;
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				driver = new FirefoxDriver();
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception has been occured" + e.getMessage());
		}
		driver.manage().deleteAllCookies();
		driver.get(url);
		logger.info("Website opened");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
