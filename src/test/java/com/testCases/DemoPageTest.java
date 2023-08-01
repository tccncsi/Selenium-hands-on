package com.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import com.base.BaseClass;
import com.utilities.JiraCreateIssue;
import com.pageObjects.DemoPage;

public class DemoPageTest extends BaseClass {
	DemoPage demopage;
	

	@JiraCreateIssue(isCreateIssue = false)
	@Test(priority = 0, enabled = false)
	public void JiraTestcase() {
		System.out.println("This is a demo test case.");
		assertTrue(false);
	}

	@JiraCreateIssue(isCreateIssue = false)
	@Test(priority = 0, enabled = false)
	public void TestcaseForExcelData() {
		System.out.println("This is a demo test case.");
		assertTrue(false);
	}

	@JiraCreateIssue(isCreateIssue = false)
	@Test(priority = 0, enabled = false)
	public void JiraTestcaseForAttachement() throws IOException {
		System.out.println("This is a demo test case to attach error screenshot in defect.");	
		
		demopage = new DemoPage(driver);
		demopage.demoMethod();
			
		assertTrue(false);
	}
}
