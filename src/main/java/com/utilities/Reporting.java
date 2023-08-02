package com.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.*;
import com.pageObjects.AmazonPage;

import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraException;

public class Reporting implements ITestListener {

	/****************************************************************************
	 * @author P1334185
	 * @implNote Provide proper Jira project URL E.g: https://tccncsi.atlassian.net
	 *           Jira User name E.g: tcc.ncsi@gmail.com API token copy from Jira
	 *           E.g: ma3FMYoFan4qjQc8im4HEF20 Project key should be, Short name
	 *           E.g: PROJDT
	 ****************************************************************************/

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public WebDriver driver = null;
	public static String userDir = "user.dir";
	public ReadConfig readconfig = new ReadConfig();
	public ReadJiraConfig jiraconfig = new ReadJiraConfig();
	public static int flag;
	String defects;

	public int totalTC = 0;
	public int passTC = 0;
	public int failTC = 0;
	public int skipTC = 0;
	public String timeStampStart;
	public String timeStampEnd;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		// String repName = "Test-Report" + timeStamp + ".html";
		String repName = "Test-Report.html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty(userDir) + "/test-output/" + repName);// specify
																										// location of
																										// the report

		htmlReporter.loadXMLConfig(System.getProperty(userDir) + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "Selenabler Baseline Framework");
		extent.setSystemInfo("Environemnt", "SIT");
		extent.setSystemInfo("user", "IDC Test Team");

		htmlReporter.config().setDocumentTitle("Selenabler Baseline Framework"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) {
		passTC++;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
	}

	public void onTestFailure(ITestResult tr) {
		failTC++;
		BasePage.defectCount++;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the failed information
																							// to the report with RED
																							// color highlighted
		System.out.println(tr.getName());
		this.driver = ((BaseClass) tr.getInstance()).driver;
		String screenshotPath = captureScreen(driver, tr.getName(), readconfig.getScreenshotPath());

		File file = new File(screenshotPath);

		if (file.exists() && readconfig.getAttachScreenshotIsEnable()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/* Testcase method name from test class */
		String testCaseName = tr.getMethod().getConstructorOrMethod().getMethod().getName();

		try {
			String testCase = null;

			testCase = XLUtils.FetchExcelTestCaseData(testCaseName);
			String[] testCaseDetails = null;
			if (testCase != null)
				testCaseDetails = testCase.split("\n\n");

			if (testCaseDetails != null && testCaseDetails.length > 0) {
				/* Test case details from excel sheet */
				// System.out.println("Test case Module: " + testCaseDetails[0].toString());
				// System.out.println("Test case Summary: " + testCaseDetails[1].toString());
				// System.out.println("Test case Steps: " + testCaseDetails[2].toString());

				// defect description with all steps till failed
				String issueDescriptionNew = BasePage.checkIssueDescription(testCaseName);

				// failed step detail to append in summary
				String defectSummary = BasePage.getFailedStep(issueDescriptionNew);

				/* Check the Jira Annotation and Jira configutation is enabled or not */
				System.out.println("Jira config: " + jiraconfig.getIsJiraEnable());

				if (isJiraAnnotationPresent(tr) && jiraconfig.getIsJiraEnable()) {
					String issueSummary = jiraconfig.getJiraEnv() + " | " + testCaseDetails[0].toString() + " | "
							+ testCaseName + " | " + defectSummary + " in Selenabler Framework";

					// Append automation error logs to the defect description
					String issueDescription = issueDescriptionNew;
					issueDescription += "\n" + "\nError/Exception found in selenabler framework: "
							+ tr.getThrowable().getMessage() + "\n";

					JiraServiceProvider JiraServiceProvider = new JiraServiceProvider(jiraconfig.getJiraURL(),
							jiraconfig.getJiraUsername(), jiraconfig.getJiraToken(), jiraconfig.getJiraProjectKey());

					/* Method call to create new defect in Jira */
					JiraServiceProvider.createJiraIssue(jiraconfig.getIssueType(), issueSummary, issueDescription,
							jiraconfig.getJiraReporter(), file);

				}

				Boolean flag = readconfig.getDefectLogIsEnable();
				System.out.println("\nGeneric Defect Utility configuration is: " + flag);

				if (flag) {
					String issueSummary = readconfig.getDefectEnv() + " | " + testCaseDetails[0].toString() + " | "
							+ testCaseName + " | " + defectSummary + " in Selenabler Framework";

				 
					// checking if issue exists under excel already
					if (XLUtils.isGenericDefectAlreadyPresent(issueSummary)) {
						XLUtils.CreateDefectExcelDataGeneric(testCaseName, issueSummary, issueDescriptionNew,
								"Failure Reason from Selenabler Framework:\n" + tr.getThrowable().getMessage(),
								readconfig.getBrowserName().toString(), readconfig.getDefectEnv(),
								readconfig.getDefectStatus(), screenshotPath, readconfig.getAttachScreenshotIsEnable());
					}

				} else {
					System.out.println(
							"Jira defect tracking is disabled or add @JiraCreateIssue(isCreateIssue = true) annotation to your test case.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult tr) {
		skipTC++;
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));// send the skipped
																							// information to the report
																							// with Orange color
																							// highlighted
	}

	public void onFinish(ITestContext testContext) {

		defects = String.valueOf(BasePage.defectCount);
		extent.setSystemInfo("Defects found", defects);

		extent.flush();
		createEmailBody();
	}

	@Override
	public void onTestStart(ITestResult result) {
		totalTC++;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public static String captureScreen(WebDriver driver, String tname, String screenshotPath) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty(userDir) + screenshotPath + tname + ".png";
		File target = new File(path);
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {

			System.out.println("Exception has been thrown" + e.getMessage());
		}
		System.out.println("Screenshot taken");
		return path;
	}

	private boolean isJiraAnnotationPresent(ITestResult result) {
		boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(JiraCreateIssue.class).isCreateIssue();
		return islogIssue;
	}

	public void createEmailBody() {

		timeStampEnd = new SimpleDateFormat("MMM dd yyyy hh:mm:ss aa").format(new java.util.Date());// time stamp
		// timeStampEnd.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));

		File f = new File(System.getProperty("user.dir") + "/test-output/" + "email body.htm");
		BufferedWriter bw = null;
		String emailBody = "  <!DOCTYPE html>\r\n" + "  <html>\r\n" + "  <head>  \r\n" + "  <style>\r\n"
				+ "thead {color: black;}\r\n" + "tbody {color: black;}\r\n" + "tfoot {color: black;}\r\n" + "\r\n"
				+ "table, th, td{\r\n" + "  border: 1px solid black;\r\n" + "  padding: 5px;\r\n"
				+ "  border-collapse: collapse;\r\n" + "  width: 500px;\r\n" + "  text-align: left;\r\n" + "}\r\n"
				+ "</style>\r\n" + "  </head>\r\n" + "  <body>\r\n" + "  Dear All,\r\n" + "  <br/><br/>\r\n"
				+ "  Please see below summary for Daily Test Execution Status for " + readconfig.getProjectName()
				+ " as on " + timeStampEnd + ".\r\n" + "  <br/><br/>\r\n" + "  <b>Test Statistics</b>\r\n"
				+ "<br/><br/>\r\n" + "  <table>\r\n" + "    <tr>\r\n" + "      <th>Total</th>\r\n"
				+ "      <th>Pass</th>\r\n" + "      <th>Fail</th>\r\n" + "      <th>Skip</th>\r\n" + "    </tr>\r\n"
				+ "    <tr>\r\n" + "      <td>" + totalTC + "</td>\r\n" + "       <td>" + passTC + "</td>\r\n"
				+ "      <td>" + failTC + "</td>\r\n" + "      <td>" + skipTC + "</td>\r\n" + "    </tr>\r\n"
				+ "  </table><br/>\r\n"

				/*
				 * + "  <table>\r\n" + "<tr>\r\n" + "     " +
				 * " <th style=\"width:52%\">E2E Scenario</th>\r\n" + "    " +
				 * "  <th>Total</th>\r\n" + "      " + "<th>Pass</th>\r\n" + "      " +
				 * "<th>Fail</th>\r\n" + "<th>Skip</th>\r\n" +
				 * 
				 * " </tr>\r\n" + "    <tr>\r\n" + " <td>" +
				 * "E Filing returns for tax type for PAYE" + "</td>\r\n" + "<td>" + TotalE2E1TC
				 * + "</td>\r\n" + " <td>" + E2E1PassTC + "</td>\r\n" + " <td>" + E2E1FailTC +
				 * "</td>\r\n" + " <td>" + E2E1SkipTC + "</td>\r\n" + "    </tr>\r\n" +
				 * 
				 * " </tr>\r\n" + "    <tr>\r\n" + " <td>" + "VAT - Online Assessment" +
				 * "</td>\r\n" + "<td>" + TotalE2E2TC + "</td>\r\n" + " <td>" + E2E2PassTC +
				 * "</td>\r\n" + " <td>" + E2E2FailTC + "</td>\r\n" + " <td>" + E2E2SkipTC +
				 * "</td>\r\n" + "    </tr>\r\n" +
				 * 
				 * " </tr>\r\n" + "    <tr>\r\n" + " <td>" + "ASMT-VAT" + "</td>\r\n" + "<td>" +
				 * TotalE2E3TC + "</td>\r\n" + " <td>" + E2E3PassTC + "</td>\r\n" + " <td>" +
				 * E2E3FailTC + "</td>\r\n" + " <td>" + E2E3SkipTC + "</td>\r\n" +
				 * "    </tr>\r\n" + "  </table>\r\n"
				 */

				/*
				 * + "  <br/>  \r\n" + "	Start Time&nbsp;:&nbsp;" + timeStampStart + ".\r\n"
				 * + "	<br/>\r\n" + "	End Time&nbsp;&nbsp;:&nbsp;" + timeStampEnd + ".\r\n"
				 */
				+ "  \r\n" + "  Total number of defects found in this build: <b>" + defects + "</b> \r\n"
				+ "  <br/>\r\n" + "  <br/>\r\n" + "  Please refer attachment for execution details.<br/>\r\n"
				+ "  <br/>\r\n" + "  Thank you.\r\n" + "  <br/><br/>\r\n" + "  Best Regards,<br/>\r\n"
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
