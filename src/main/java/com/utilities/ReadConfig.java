package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;
	public FileInputStream fis;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

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

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getApplicationURL(String key) {
		String value = pro.getProperty(key);
		return value;
	}

	public String getUsername() {
		String username = pro.getProperty("userName");
		return username;
	}

	public String getAMSUsername() {
		String username = pro.getProperty("AMSUsername");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getAMSPassword() {
		String password = pro.getProperty("AMSPassword");
		return password;
	}

	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	public String getScreenshotPath() {
		return pro.getProperty("screenshotPath").toString();
	}

	public Boolean getAttachScreenshotIsEnable() {
		return Boolean.parseBoolean(pro.getProperty("attachScreenshotIsEnable"));
	}

	public Boolean getDefectLogIsEnable() {
		return Boolean.parseBoolean(pro.getProperty("defectGenericUtility"));
	}

	public String getDefectLogFilePath() {
		return pro.getProperty("defectFilepath");
	}

	public String getBrowserName() {
		return pro.getProperty("browser");
	}

	public String getProduct() {
		return pro.getProperty("product");
	}

	public String getQuantity() {
		return pro.getProperty("quantity");
	}

	public String getDefectEnv() {
		return pro.getProperty("defectGenericEnv");
	}

	public String getDefectStatus() {
		return pro.getProperty("defectStatus");
	}

	public String getProjectName() {
		return pro.getProperty("projectName");
	}

	public String getProductText() {
		return pro.getProperty("productText");
	}

	// ****************** End of Editing/code ***************
}
