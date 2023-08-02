package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Concept {

	WebDriver driver;

	@Test
	private void demo() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mages\\eclipse-workspace\\TestNg-3Pm\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		String actual = driver.getTitle();
		System.out.println(actual);

		String expected = " Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println(expected);

		//Assert.assertEquals(actual, expected); //Hard Assert

		SoftAssert s = new SoftAssert();
		s.assertEquals(actual, expected);
		s.assertAll();
		System.out.println("Java");
	}

}
