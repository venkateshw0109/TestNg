package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	public static Actions actions;

	public static void browser(String browser) {

		if (browser.equals("chrome")) {

			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();

		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

	}

	public static void getUrl(String url) {

		driver.get(url);
	}

	public static void getTitle() {

		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void selection(WebElement element, String value, String option) {

		Select s = new Select(element);

		if (option.equalsIgnoreCase("byValue")) {
			s.selectByValue(value);

		}

		else if (option.equalsIgnoreCase("byVisibleText")) {

			s.selectByVisibleText(value);
		}

		else if (option.equalsIgnoreCase("byindex")) {

			int parseInt = Integer.parseInt(value);

			s.selectByIndex(parseInt);
		}

	}

	public static void scrollUpAndDownWithElementJs(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void scrollUpJs() {

		js.executeScript("window.scrollBy(0, -1000);");
	}

	public static void scrollDownJs() {

		js.executeScript("window.scrollBy(0, -1000);");
	}

	public static void quiteBrowser() {
		driver.quit();
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void sendKeys(WebElement element, String values) {
		element.sendKeys(values);
	}

	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {

		actions.dragAndDrop(sourceElement, targetElement).perform();
	}

	public static void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	public static void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public static void isDisplayed(WebElement element) {
		element.isDisplayed();
	}

	public static void sendKeysUsingJs(WebElement element, String value) {
		js.executeScript("arguments[0].value = arguments[1]", element, value);
	}

	public static void clickUsingJs(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	public static void clickUsingActions(WebElement element) {
		actions.click(element).perform();
	}

	public static void closeTheBrowser() {
		driver.close();
	}

	public static void simpleAlert() {

		driver.switchTo().alert().accept();

	}

	public static void ConfirmAlert(boolean accept) {

		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (accept) {
			alert.accept();
			System.out.println("Accepted Alert: " + alertText);
		} else {
			alert.dismiss();
			System.out.println("Dismissed Alert: " + alertText);
		}
	}

	public static void handlePromptAlert(boolean accept, String input) {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();

		if (accept) {
			alert.sendKeys(input);
			alert.accept();
			System.out.println("Accepted Prompt Alert: " + alertText);
			System.out.println("Entered Input: " + input);
		} else {
			alert.dismiss();
			System.out.println("Dismissed Prompt Alert: " + alertText);
		}
	}

	public static void implicitWait(int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
	}

	public static void takeScreenshot(String fileName, String name) throws IOException {
//		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//		String screenshotFileName = fileName + "_" + timeStamp + ".png";
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		String destinationDir = "screenshots/";
//		File des = new File(name+destinationDir + screenshotFileName);
//		FileUtils.copyFileToDirectory(src, des);

	}

	public static void screenShot(String filename) throws IOException {

		//String title2 = driver.getTitle();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File destinateFile = new File(System.getProperty("screenshot.dir") + "\\screenshot"
				+ formater.format(calendar.getTime()) + filename + ".png");

		FileUtils.copyFileToDirectory(sourceFile, destinateFile);

	}

	public static void getWindowHandle() {

		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

	public static void getWindowHandles(int value) {

		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> li = new ArrayList<>(windowHandles);

		driver.switchTo().window(li.get(value));

	}

}
