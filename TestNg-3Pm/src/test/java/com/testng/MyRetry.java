package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

	int count =0;
	@Override
	public boolean retry(ITestResult result) {
		
		if (count<1000) {
			count++;
			return true;
		}

		
		return false;
	}

	

}
