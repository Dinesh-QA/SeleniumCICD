package com.facbook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class FacebookTest {
	@Test
	public void launchFacebook() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com");

			System.out.println("Title of the page is:: " + driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println("Printing from YML File userName : " + System.getenv("FB_UserName"));
			System.out.println("Printing from YML File password : " + System.getenv("FB_PassWord"));

			// ✅ Take screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// ✅ Save screenshot to a known path (must match upload path in workflow)
			File destFile = new File("target/screenshot.png");
			Files.copy(screenshot, destFile);
			System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
