package testNGBasics;

import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test(expectedExceptions = ArithmeticException.class)
	public void logInTest() {
		System.out.println("LoginTest");
		int i = 100 / 0;// if you want to handle any exception using TestNG, use expectedExceptions keyword.
	}

	@Test(dependsOnMethods = "logInTest") // this is depended on the logInTest method, if it get passed, only then this
											// will be executed.
	public void homePageTest() {
		System.out.println("HomePageTest");
	}

	@Test(dependsOnMethods = "homePageTest")
	public void searchPageTest() {
		System.out.println("SearchPageTest");
	}

	@Test(invocationCount = 5, timeOut = 20000) // invocationCount will allow to execute the same test x times. timeout
												// - max time the test case should take to execute.
	public void regPageTest() {
		System.out.println("RegPageTest");
	}

}
