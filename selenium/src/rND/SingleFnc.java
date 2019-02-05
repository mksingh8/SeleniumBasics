package rND;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SingleFnc {
	static WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	public static void TakeScreenshotOf(String imageName) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(
				System.getProperty("user.dir") + "/ScreenShots/" + imageName + "_" + System.currentTimeMillis() + ".jpg"));

	}
	
	@BeforeSuite
	public void extReportInitialization() {

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("/home/manish/git/SeleniumBasics/selenium/src/extentReportConcept/"
				+ System.currentTimeMillis() + "_" + "extentReportDemo.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
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
			utility.ScreenShotConcept.TakeScreenshotOf(result.getName());
			//ScreenShotConcept.TakeScreenshotOf("testTest");
			//logger.addScreenCaptureFromPath(ssPath);
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
		driver.quit();
		logger.log(Status.INFO, "Browser is closed");
		logger.log(Status.INFO, "Test is completed");
		extent.flush();
	}

}
