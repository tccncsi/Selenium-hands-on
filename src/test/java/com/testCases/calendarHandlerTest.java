package com.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.utilities.ReadConfig;

import bsh.Console;

public class calendarHandlerTest {

	public static void main(String[] args) throws Exception {


		String month = "July 2023";

		String date = "Sun Jul 09 2023";

		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/hotels");
		driver.findElement(By.xpath("//button[@name=\"from\"]")).click();
		Thread.sleep(2000);

		while (true) {
			String Lbltext = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']//div")).getText();
			System.out.println(Lbltext);
			if (Lbltext.equals(month)) {
				break;
			}

			else {
				driver.findElement(By.xpath("//div[@class='DayPicker-wrapper']//div[2]//*[local-name()='svg']")).click();
			}
		}

		driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();

	}

}


	
