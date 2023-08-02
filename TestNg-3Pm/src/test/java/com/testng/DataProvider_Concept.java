package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class DataProvider_Concept extends BaseClass {
	//2D Array
	

	
	@BeforeMethod
	private void setUp() {

		browser("chrome");
		getUrl("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
	
	}
	
	@Test(dataProvider = "datas")
	private void logIn( String name , String pass) {

		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_email']"));
		userName.sendKeys(name);
		userName.sendKeys(Keys.ENTER);
		
		WebElement passWord = driver.findElement(By.xpath("//input[@id='ap_password']"));
		passWord.sendKeys(pass);
		passWord.sendKeys(Keys.ENTER);
	}
	
	@DataProvider
	private Object[][] datas() {

		return new Object[][]{   {"Dinesh123@gmail.com" ,"12345678"} ,
			                     {"Arun222@gmail.com" , "55555"} ,
			                     {"Bala555@gmail.com" , "89645465"} 
			                     
		 };
	}

}
