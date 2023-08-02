package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
	
	@Test(retryAnalyzer = MyRetry.class)
	private void logIn() {

		Assert.assertEquals("Arun", "Arun");
		
	}
	
	@Test
	private void logOut() {

		Assert.assertEquals("Balaji", "Bala");

	}

}
