package com.base;

import java.lang.reflect.InvocationTargetException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public WebDriver driver;
	public NgWebDriver ngDriver;
	public JavascriptExecutor executor;
	public Logger logger;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void setup(String brwname, String url) throws InvocationTargetException {
		logger = Logger.getLogger("Selenabler Baseline Framework");
		PropertyConfigurator.configure("Log4j.properties");

		try {
			switch (brwname) {
			case "chrome":

				ChromeOptions cap = new ChromeOptions();
				cap.addArguments("--disable-extensions");
				// to disable browser extension
				// pop-up cap.setAcceptInsecureCerts(true);
				cap.addArguments("--disable-dev-shm-usage");
				System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(cap);
				executor = (JavascriptExecutor) driver;
				ngDriver = new NgWebDriver(executor);
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
				driver = new FirefoxDriver();
				break;

			case "ie":
				System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
				driver = new InternetExplorerDriver();
				break;
			}
		} catch (Exception e) {
			System.out.println("Exception has been occured" + e.getMessage());
		}

		driver.manage().deleteAllCookies();
		driver.get(url);
		logger.info("url is opened");
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardown() {
		driver.quit();
		System.out.println("\nEnd of Execution!");
	}

}
