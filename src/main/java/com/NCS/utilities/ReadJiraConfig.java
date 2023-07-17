package com.NCS.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadJiraConfig {

	public Properties pro;
	public FileInputStream fis;

	public ReadJiraConfig() {
		File src = new File("./Configuration/JiraConfig.properties");

		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		try {
			fis.close();
		} catch (IOException e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// code to check Jira is enabled or not
	public Boolean getIsJiraEnable() {
		return Boolean.parseBoolean(pro.getProperty("isJiraEnable"));
	}

	public String getJiraURL() {
		return pro.getProperty("jiraURL");
	}

	public String getJiraUsername() {
		return pro.getProperty("jiraUser");
	}

	public String getJiraToken() {
		return pro.getProperty("APIToken");
	}

	public String getIssueType() {
		return pro.getProperty("issueType");
	}

	public String getJiraProjectKey() {
		return pro.getProperty("projKey");
	}
	
	public String getJiraReporter() {
		return pro.getProperty("Reporter");
	}
	
	public String getJiraEnv() {
		return pro.getProperty("defectEnv");
	}


	// ****************** End of Editing/code ***************
}
