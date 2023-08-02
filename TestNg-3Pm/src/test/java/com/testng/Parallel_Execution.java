package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Parallel_Execution  {
	WebDriver driver;
	
	@Test
	private void amazon01() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mages\\eclipse-workspace\\TestNg-3Pm\\driver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	
	@Test
	private void amazon02() {

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\mages\\eclipse-workspace\\TestNg-3Pm\\driver\\msedgedriver.exe");
		
		 driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
	}

}
