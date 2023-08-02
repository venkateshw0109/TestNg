package com.testng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class SimpleAnnotation extends BaseClass {

	@BeforeSuite
	private void browserLaunch() {

		browser("chrome");
	}

	@BeforeTest
	private void userLaunchTheUrl() {

		getUrl("https://www.amazon.in/");
	}

	@BeforeClass
	private void credentials() {

//		WebElement signIn = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
//		signIn.click();
//
//		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_email']"));
//		userName.sendKeys("AutomationPractice123@gmail.com");
//		userName.sendKeys(Keys.ENTER);
//
//		WebElement passWord = driver.findElement(By.xpath("//input[@id='ap_password']"));
//		passWord.sendKeys("12345678");
//		passWord.sendKeys(Keys.ENTER);
		System.out.println("user credentials");
	}

	@BeforeMethod
	private void UsergetTitle() throws IOException, InterruptedException {

		String title = driver.getTitle();
		screenShot("beforeMethod");

	}

	@Test(priority = 2)
	private void lapTop() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("lapTop");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(priority = -1)
	private void watch() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("watch");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test
	private void mobiles() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("mobiles");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(priority = 1 , invocationCount = 4)
	private void shoes() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("shoes");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(enabled = false)
	private void dresses() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("dresses");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	@AfterMethod
	private void userGetTitleAfterTest() throws IOException, InterruptedException {

		String title = driver.getTitle();
		Thread.sleep(5000);

		screenShot("afterMethod");

	}

	@AfterClass
	private void logOut() {

		System.out.println("Logout");
	}

	@AfterTest
	private void deleteTheCookies() {

		driver.manage().deleteAllCookies();
	}

	@AfterSuite
	private void closeTheProgram() {

		driver.quit();
	}

}
