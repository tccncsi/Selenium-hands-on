package com.utilities;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.utilities.JiraServiceProvider;

import net.rcarz.jiraclient.JiraException;

public class TestListener implements ITestListener {

	/****************************************************************************
	 * @author P1334185
	 * @implNote Provide proper Jira project URL E.g: https://tccncsi.atlassian.net
	 *           Jira User name E.g: tcc.ncsi@gmail.com API token copy from Jira
	 *           E.g: ma3FMYoFan4qjQc8im4HEF20 Project key should be, Short name
	 *           E.g: PROJDT
	 ****************************************************************************/

	public ReadJiraConfig jiraconfig = new ReadJiraConfig();
	public ReadConfig readconfig = new ReadConfig();

	public void onTestSuccess(ITestResult result) {

		/*
		 * JiraServiceProvider JiraServiceProvider = new
		 * JiraServiceProvider(jiraconfig.getJiraURL(), jiraconfig.getJiraUsername(),
		 * jiraconfig.getJiraToken(), jiraconfig.getJiraProjectKey());
		 * 
		 * try { JiraServiceProvider.isJiraAlreadyPresent(result.getMethod().
		 * getConstructorOrMethod().getMethod().getName()); } catch (JiraException e) {
		 * e.printStackTrace(); }
		 */
	}

	public void onTestFailure(ITestResult result) {

		

		/* Check the Jira Annotation and Jira configutation is enabled or not */

		String testCaseName = result.getMethod().getConstructorOrMethod().getMethod().getName();

		try {
			String testCase = XLUtils.FetchExcelTestCaseData(testCaseName);
			String[] testCaseDetails = testCase.split("\n\n");

			if (testCaseDetails.length > 0) {
				System.out.println("Test case Module: " + testCaseDetails[0].toString());
				System.out.println("Test case Summary: " + testCaseDetails[1].toString());
				System.out.println("Test case Steps: " + testCaseDetails[2].toString());

				/* Defect summary E.g. Test case name + some text */
				String issueSummary = testCaseDetails[0].toString() + " - " + testCaseName + " - "
						+ testCaseDetails[1].toString() + " Failed in Selenabler Framework";

				/* Defect description */
				String issueDescription = "Test steps:\n" + testCaseDetails[2].toString()
						+ "\n\nFailure Reason from Selenabler Framework:\n" + result.getThrowable().getMessage() + "\n";

				/* JIRA Integration to create new defect */
				System.out.println("Jira config: " + jiraconfig.getIsJiraEnable());
				if (isJiraAnnotationPresent(result) && jiraconfig.getIsJiraEnable()) {
					JiraServiceProvider JiraServiceProvider = new JiraServiceProvider(jiraconfig.getJiraURL(),
							jiraconfig.getJiraUsername(), jiraconfig.getJiraToken(), jiraconfig.getJiraProjectKey());

					JiraServiceProvider.createJiraIssue(jiraconfig.getIssueType(), issueSummary, issueDescription,
							jiraconfig.getJiraReporter(), null);
				} else if (readconfig.getDefectLogIsEnable()) {

				} else {
					System.out.println(
							"Jira defect tracking is disabled or add @JiraCreateIssue(isCreateIssue = true) annotation to your test case.");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		/* Method call to create new defect in Jira */

	}

	/*
	 * This method check whether the JiraAnnotation is added to the test case or not
	 */
	private boolean isJiraAnnotationPresent(ITestResult result) {
		boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(JiraCreateIssue.class).isCreateIssue();
		return islogIssue;
	}

	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {

		// TODO Auto-generated method stub

	}

}
