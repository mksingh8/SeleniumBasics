package testNGBasics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgTest {

	/*
	 * Sequence: before suite before test before class before method Test1 - Google
	 * Title Test after method before method Test2 after method after class after
	 * test PASSED: googleTitleTest PASSED: searTest
	 * 
	 */
	// pre condition

	public static WebDriver driver = null;

	@BeforeSuite
	public void bSuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void bTest() {
		System.out.println("before test");
	}

	@BeforeClass
	public void bClass() {
		System.out.println("before class");
	}

	@BeforeMethod
	public void bMehod() {
		System.out.println("before method");
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.google.com");
	}

	// test case, priority is a keyword decide the sequence of execution
	@Test(priority = 1,groups="BooleanTest")
	public void googleTitleTest() {
		System.out.println("Test1");
		System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Google", "Title is not matched ==> Failed");
	}

	@Test(priority = 2,groups="BooleanTest")
	public void searchTest() {
		System.out.println("Test2");
		WebElement googleLogo = driver.findElement(By.id("hplogo"));
		/*if (googleLogo.isDisplayed()) {
			System.out.println("Google Logo is displayed with color as: " + googleLogo.getCssValue("color"));
			System.out.println("Google Logo is displayed with id as: " + googleLogo.getAttribute("id"));
		} else {
			System.out.println("Google Logo is not displayed");
		}*/
		
		//Assert.assertEquals(googleLogo.isDisplayed(), true, "Google Logo is not displayed.");
		Assert.assertTrue(googleLogo.isDisplayed(), "Google Logo is not displayed.");

	}

	@Test(priority=3,groups="ClickTest")
	public void gMailClick() {
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
	}

	// post condition
	@AfterMethod
	public void aMethod() {
		System.out.println("after method");
		driver.quit();
	}

	@AfterClass
	public void aClass() {
		System.out.println("after class");
	}

	@AfterTest
	public void aTest() {
		System.out.println("after test");
	}

	@AfterSuite
	public void aSuite() {
		System.out.println("after suite");
	}

}
