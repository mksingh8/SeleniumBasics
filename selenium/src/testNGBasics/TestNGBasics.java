package testNGBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	/*
	 * Sequence: 
	 * before suite 
	 * before test 
	 * before class 
	 * before method 
	 * Test1 - Google Title Test 
	 * after method 
	 * before method 
	 * Test2 
	 * after method 
	 * after class 
	 * after test 
	 * PASSED: googleTitleTest PASSED: searTest
	 * 
	 */
	// pre condition
	@BeforeSuite
	public void bSuite() {
		System.out.println("before suite");
	}

	@BeforeClass
	public void bClass() {
		System.out.println("before class");
	}

	@BeforeMethod
	public void bMehod() {
		System.out.println("before method");
	}

	@BeforeTest
	public void bTest() {
		System.out.println("before test");
	}

	// test case
	@Test
	public void googleTitleTest() {
		System.out.println("Test1 - Google Title Test");
	}

	@Test
	public void searchTest() {
		System.out.println("Test2");
	}

	// post condition
	@AfterMethod
	public void aMethod() {
		System.out.println("after method");
	}

	@AfterTest
	public void aTest() {
		System.out.println("after test");
	}

	@AfterClass
	public void aClass() {
		System.out.println("after class");
	}

	@AfterSuite
	public void aSuite() {
		System.out.println("after suite");
	}

}
