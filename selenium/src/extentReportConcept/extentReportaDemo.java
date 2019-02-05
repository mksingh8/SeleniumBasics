package extentReportConcept;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utility.ScreenShotConcept;

public class extentReportaDemo {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeSuite
	public void extReportInitialization() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("/home/manish/git/SeleniumBasics/selenium/src/extentReportConcept/"
				+ System.currentTimeMillis() + "_" + "extentReportDemo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("testName");
	}

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib" + "/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			utility.ScreenShotConcept.TakeScreenshotpath(result.getName());
			//ScreenShotConcept.TakeScreenshotOf("testTest");
			//logger.addScreenCaptureFromPath(ssPath);
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
		driver.quit();
		logger.log(Status.INFO, "Browser is closed");
		logger.log(Status.INFO, "Test is completed");
		extent.flush();
	}

	@Test
	public void test1() {

		logger = extent.createTest("Testing GoogleSearchTest case");
		driver.get("https://www.google.com");
		logger.log(Status.INFO, "Navigated to Google Seach Page.");
		driver.findElement(By.name("q")).sendKeys("who are Angel Brokers");
		logger.log(Status.PASS, "text to be search is entered in the search box");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		logger.pass("Clicked on the search button");
		
		Assert.assertEquals(driver.getTitle(), "GoogleMap", "Title is not matching");
		
	}
/*
	@Test
	public void test2() {

		logger = extent.createTest("Testing facebookHomePage test case");
		driver.get("https://www.facebook.com");
		logger.log(Status.INFO, "Navigated to Facebook Page.");
		
		//logger.fail("button not available");

	}
	
*/	

}
