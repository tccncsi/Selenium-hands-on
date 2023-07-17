package com.NCS.utilities;

import java.io.File;
import java.io.IOException;

import com.NCS.base.BasePage;

import bsh.org.objectweb.asm.Label;
import net.rcarz.jiraclient.*;
import net.rcarz.jiraclient.Issue.FluentCreate;

public class JiraServiceProvider {

	private JiraClient Jira;
	private String project;
	private String JiraUrl;
	public ReadJiraConfig jiraconfig = new ReadJiraConfig();

	public JiraServiceProvider(String JiraUrl, String username, String password, String project) {

		this.JiraUrl = JiraUrl;

		/* Create basic authentication object */
		BasicCredentials creds = new BasicCredentials(username, password);

		/* Initialize the Jira client with the url and the API token credentials */
		Jira = new JiraClient(JiraUrl, creds);
		this.project = project;
	}

	public void createJiraIssue(String issueType, String summary, String description, String reporterName, File attachment) {

		try {
            //update defect count
			//BasePage.defectCount++;
			
			//Avoid Creating Duplicate Issue with same summary
			  if (isJiraAlreadyPresent(summary,attachment))  
			  {
			       
			/* Code for screenshot path in comment*/
			String Screenpath = "For more details check error screenshot: " + "\\Screenshots\\"
					+ summary.split(" ")[0].toString() + ".png";

			/* Create issue if not exists */
			FluentCreate fleuntCreate = Jira.createIssue(project, issueType);
			fleuntCreate.field(Field.SUMMARY, summary);
			fleuntCreate.field(Field.DESCRIPTION, description);
			//fleuntCreate.field(Field.ASSIGNEE, "TCC NCSI");
			Issue newIssue = fleuntCreate.execute();
			//newIssue.addComment(Screenpath);
			newIssue.addAttachment(attachment);
			
			/* Code to print newly created defect details */
			System.out.println("***************************************************************************");
			System.out.println("New issue created in Jira with ID: " + newIssue);
			System.out.println("New issue URL is :" + JiraUrl + "/browse/" + newIssue);
			System.out.println("***************************************************************************");

			try {
				XLUtils.CreateDefectExcelData(summary.split(" ")[0], summary, description, newIssue.toString(),
						newIssue.getStatus().toString(), jiraconfig.getJiraEnv());
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			}
		} catch (JiraException e) {
			e.printStackTrace();
		}
	}

	public boolean isJiraAlreadyPresent(String summary,File attachment) throws JiraException {
		/* Code to check if the defect is already exist in the Jira */
		Issue.SearchResult sr = Jira.searchIssues("summary ~ \"" + summary + "\"");
		
		String Comment= "";
		
		System.out.println("Search result: " + sr.total);
		if (sr.total > 0) {
			System.out.println("***************************************************************************");
			System.out.println("Defect for same test-step already exists on Jira: " + sr.issues.toString());
			System.out.println("***************************************************************************");

			
			 for (int i = 0; i < sr.total; i++) 
			{
			  String defectStatus = sr.issues.get(i).getStatus().toString();
			  System.out.println(defectStatus);
			  if(defectStatus.equalsIgnoreCase("TO DO") || defectStatus.equalsIgnoreCase("IN PROGRESS"))
			   {
				  Comment = sr.issues.get(i).getDescription();
				  System.out.println("Defect for same test-step already exists on Jira:" +Comment);
				  sr.issues.get(i).addComment("Defect for same test-step already exists on Jira:" +"\n" +Comment +"\n");
				  /* Add error screenshot in the existing defect */
				  sr.issues.get(i).addAttachment(attachment);
				  break;
			   }
			    
			   else if(defectStatus.equalsIgnoreCase("Done"))
			    {
				   Comment = sr.issues.get(i).getDescription();
				   System.out.println("This is a new Defect: " +"\n" +Comment);
				   return true;
				}
			}
			 
			return false;
		} 
			 else 
			 {
			return true;
		     }
	}
	
	
	
}
