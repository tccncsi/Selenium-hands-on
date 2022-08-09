package com.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;

public class Reporting implements ITestListener, IAnnotationTransformer {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public WebDriver driver = null;

	// ***** Added by Shivaji on 08/01/2021 for email body. *****
	public static String userDir = "user.dir";
	public ReadConfig readconfig = new ReadConfig();
	public String timeStampStart;
	public String timeStampEnd;

	public int totalTC = 0;
	public int passTC = 0;
	public int failTC = 0;
	public int skipTC = 0;

	// ***** End of note *****

	public void onStart(ITestContext testContext) {
		timeStampStart = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aa").format(new java.util.Date());// time stamp
		String repName = "Test-Report.html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specify
																											// location
																											// of the
																											// report

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "vishal");

		htmlReporter.config().setDocumentTitle("Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location
		// of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {

		totalTC += 1;
		passTC += 1;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
	}

	public void onTestFailure(ITestResult tr) {
		totalTC += 1;
		failTC += 1;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the failed information
																							// to the report with RED
																							// color highlighted
		System.out.println(tr.getName());
		this.driver = ((BaseClass) tr.getInstance()).driver;
		captureScreen(driver, tr.getName());
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		

		System.out.println("test case name   " + tr.getName());

	}

	public void onTestSkipped(ITestResult tr) {

		totalTC += 1;
		skipTC += 1;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));// send the skipped
																							// information to the report
																							// with Orange color
																							// highlighted

		
		System.out.println("test case name   " + tr.getName()); // highlighted

	}

	public void onFinish(ITestContext context) {

		/* Retry logic code */

		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		Set<ITestResult> skippedTests = context.getSkippedTests().getAllResults();

		// remove failed duplicate TC
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}

		// remove skipped duplicate TC
		for (ITestResult temp : skippedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getSkippedTests().getResults(method).size() > 1) {
				skippedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					skippedTests.remove(temp);
				}
			}
		}

		extent.flush();
		createEmailBody();
	}

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public static void captureScreen(WebDriver driver, String tname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {

			System.out.println("Exception has been thrown" + e.getMessage());
		}
		System.out.println("Screenshot taken");
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();

		if (retry == null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
	}

	public void createEmailBody() {

	//	int TotalLogin_PageTestTC = Login_PageTestPassTC + Login_PageTestFailTC + Login_PageTestSkipTC;
	//	int TotalLogin_PageTest2TC = Login_PageTest2PassTC + Login_PageTest2FailTC + Login_PageTest2SkipTC;

		timeStampEnd = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aa").format(new java.util.Date());// time stamp
		// timeStampEnd.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));

		File f = new File(System.getProperty("user.dir") + "/test-output/" + "email body.htm");
		BufferedWriter bw = null;
		String emailBody = "  <!DOCTYPE html>\r\n" + "  <html>\r\n" + "  <head>  \r\n" + "  <style>\r\n"
				+ "thead {color: black;}\r\n" + "tbody {color: black;}\r\n" + "tfoot {color: black;}\r\n" + "\r\n"
				+ "table, th, td{\r\n" + "  border: 1px solid black;\r\n" + "  padding: 5px;\r\n"
				+ "  border-collapse: collapse;\r\n" + "  width: 500px;\r\n" + "  text-align: left;\r\n" + "}\r\n"
				+ "</style>\r\n" + "  </head>\r\n" + "  <body>\r\n" + "  Dear All,\r\n" + "  <br/><br/>\r\n"
				+ "  Please see below summary for Daily Test Execution Status for Demo as on  " + timeStampStart
				+ ".\r\n" + "  <br/><br/>\r\n" + "  <b>Test Statistics</b>\r\n" + "<br/><br/>\r\n" + "  <table>\r\n"
				+ "    <tr>\r\n" + "      <th>Total</th>\r\n" + "      <th>Pass</th>\r\n" + "      <th>Fail</th>\r\n"
				+ "      <th>Skip</th>\r\n" + "    </tr>\r\n" + "    <tr>\r\n" + "      <td>" + totalTC + "</td>\r\n"
				+ "       <td>" + passTC + "</td>\r\n" + "      <td>" + failTC + "</td>\r\n" + "      <td>" + skipTC
				+ "</td>\r\n" + "    </tr>\r\n" + "  </table><br/><br/>\r\n"

				+ "  <table>\r\n" + "<tr>\r\n" + "     " + " <th style=\"width:52%\">DEMO Scenario</th>\r\n" + "    "
				+ "  <th>Total</th>\r\n" + "      " + "<th>Pass</th>\r\n" + "      " + "<th>Fail</th>\r\n"
				+ "<th>Skip</th>\r\n" +

				/*
				 * " </tr>\r\n" + "    <tr>\r\n" + " <td>" + "Login Scenario 1" + "</td>\r\n" +
				 * "<td>" + TotalLogin_PageTestTC + "</td>\r\n" + " <td>" + Login_PageTestPassTC
				 * + "</td>\r\n" + " <td>" + Login_PageTestFailTC + "</td>\r\n" + " <td>" +
				 * Login_PageTestSkipTC + "</td>\r\n" + "    </tr>\r\n" +
				 * 
				 * " </tr>\r\n" + "    <tr>\r\n" + " <td>" + "Login Scenario 2" + "</td>\r\n" +
				 * "<td>" + TotalLogin_PageTest2TC + "</td>\r\n" + " <td>" +
				 * Login_PageTest2PassTC + "</td>\r\n" + " <td>" + Login_PageTest2FailTC +
				 * "</td>\r\n" + " <td>" + Login_PageTest2SkipTC + "</td>\r\n" + "    </tr>\r\n"
				 */				 "  </table>\r\n"

				/*
				 * + "  <br/>  \r\n" + "	Start Time&nbsp;:&nbsp;" + timeStampStart + ".\r\n"
				 * + "	<br/>\r\n" + "	End Time&nbsp;&nbsp;:&nbsp;" + timeStampEnd + ".\r\n"
				 */

				+ "  <br/>\r\n" + "  Please refer attachment for execution details.<br/>\r\n" + "  <br/>\r\n"
				+ "  Thank you.\r\n" + "  <br/><br/>\r\n" + "  Best Regards,<br/>\r\n"
				+ "  Test Automation Team<br/>\r\n" + "  Email: tcc.ncsi@ncs.com.sg \r\n" + "  <br/>\r\n"
				+ "  </body>\r\n" + "  </html>\r\n" + "";
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(emailBody);
			bw.close();
			// Desktop.getDesktop().browse(f.toURI());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
