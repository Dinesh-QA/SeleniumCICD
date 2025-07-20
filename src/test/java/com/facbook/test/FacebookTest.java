package com.facbook.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FacebookTest {
	@Test
	public void launchFacebook() {

		String userName = System.getenv("FB_UserName");
		String password = System.getenv("FB_PassWord");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // ✅ Maximizes the browser window

		driver.get("https://www.facebook.com");
		System.out.println("Title of the page is:: " + driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlContains("https://www.facebook.com/"));
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']"))
				.sendKeys(userName);
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.urlContains("facebook.com"));
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
