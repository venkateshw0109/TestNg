package com.testng;

import org.testng.annotations.Test;

public class ExceptionTest {
	
	
	@Test
	private void add() {

		int a=10;
		int b=20;
		
		System.out.println(a+b);
	}
	
	@Test(expectedExceptions = ArithmeticException.class)
	private void divide() {

		int a=10;
		int b=0;
		
		System.out.println(a/b);
		
		
	}

}
