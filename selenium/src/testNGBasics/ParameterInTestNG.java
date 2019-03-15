package testNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterInTestNG {
	WebDriver driver;
/*	
	Parameter values are defined in POM xml. all the parameters value must be passed in test method, otherwise, it will throw Exception. 
	Parameters should be defined in the same order in both annotations. testNG follow the Parameters sequence 
	while assigning the value to the test parameters. 
	These parameters value can only be used in @Test annotation not in @BeforeMethod. 
	Each test should have its own @Parameters annotation. Parameter value of one test can not be used in another test.	
*/	

/*	//Example: 1
	@Parameters({"url","userid"})
	@Test
	public void startBrowser(String url, String userid){
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://www.google.com");
		driver.get(url);
	
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Sign In']")).isDisplayed(),
				"Gmail page is not displayed");
		
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userid);
		Assert.assertEquals(driver.getTitle(), "Gmail","Gmail login page is not displayed");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

*/	
	//Example: 2
	@Parameters({"browser", "url"})
	@Test(priority=0)
	public void startBrowser(String browser, String url) {
		
		if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			driver = new FirefoxDriver();
			
		} else if (browser.contains("chrome")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
}

	@Parameters({"url"})
	@Test
	public void openGmail(String url) {
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Sign In']")).isDisplayed(),
				"Gmail page is not displayed");
	}
	@Parameters({"browser","url","userid"})
	@Test(dependsOnMethods="openGmail")
	public void enterUserID(String browser, String url, String userid) throws Exception {
		
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userid);
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Gmail","Gmail login page is not displayed");

		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
