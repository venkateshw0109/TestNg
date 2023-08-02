package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class Grouping_Concept extends BaseClass{
	
	@BeforeGroups({"Electronics" , "Mine" , "Dresses"})
	private void setUp() {

		browser("chrome");
		getUrl("https://www.amazon.in/");

	}
	
	@Test(groups = "Electronics")
	private void lapTop() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("lapTop");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(groups = "Mine")
	private void watch() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("watch");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}
	
	@Test(groups = "Mine")
	private void shoes() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("shoes");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(groups = "Electronics")
	private void mobiles() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("mobiles");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(groups = "Dresses")
	private void kidsDresses() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("kids Dresses");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}

	
	@Test(groups = "Dresses")
	private void mensDresses() {

		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("Mens dresses");
		searchBox.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();

	}
	

}
