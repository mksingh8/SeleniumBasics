package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class BrowserNavigation {

		public static void main(String[] args) {

			System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
	
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);// dynamic wait. max time allowed for page to
																				// load.
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// dynamic wait. max wait time, system will
			// wait for web-element to appear on page

			
			driver.navigate().to("https://www.google.co.in");
			//Difference between driver.get() and driver.navigate()?
			//later one is used to navigate to external url
			driver.navigate().to("https://www.irctc.co.in/nget/train-search");
			driver.navigate().refresh();
			for(int i=0; i<3; i++) {
				driver.navigate().back();
				System.out.println(driver.getTitle());
				driver.navigate().forward();
				System.out.println(driver.getTitle());
			}
	}

}
