package dataDrivenApproach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.TestUtil;

public class DataProvideConcept {
	WebDriver driver;
	
	@BeforeMethod
	public void initialMethod() {
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.navigate().to("https://www.w3schools.com/howto/howto_css_signup_form.asp");
		driver.findElement(By.xpath("//*[@id=\"main\"]/button")).click();
	}
	
	@DataProvider
/*	public Iterator<Object[]> getTestData() {
		return TestUtil.getTestData();
	}
	*/
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getExcelData();
		return testData.iterator();	
	}
	
	@Test(dataProvider = "getTestData")
	public void regTest(String userName, String password) {//sequence should be same as per the data provider
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter email']")).clear();
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter email']")).sendKeys(userName);
		
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter Password']")).clear();
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter Password']"))
		.sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Repeat Password']")).clear();
		driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Repeat Password']"))
				.sendKeys(password);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
