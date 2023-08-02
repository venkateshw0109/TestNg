package com.testng;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class Dependency_Test extends BaseClass {
	
	@Test
	private void browserLaunch() {

		browser("chrome");
	}

	@Test(dependsOnMethods = "browserLaunch")
	private void userLaunchTheUrl() {

		getUrl("https://www.amazon.in/");
	}
	
	@Test(dependsOnMethods = "userLaunchTheUrl")
	private void closeTheProgram() {

		closeTheBrowser();
	}

}
