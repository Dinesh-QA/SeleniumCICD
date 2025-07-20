package com.facbook.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookTest {
	@Test
	public void launchFacebook() {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize(); // ✅ Maximizes the browser window

	    driver.get("https://www.facebook.com");
	    System.out.println("Title of the page is:: " + driver.getTitle());
	    System.out.println("Additional task Done. . . .");

	    driver.quit();
	}

}
