package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static void main(String[] args) {
	 
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();//Launching FF browser
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//dynamic wait. max time allowed for page to load.
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//dynamic wait. max wait time, system will
		//wait for web-element to appear on page
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getClass());
		driver.getCurrentUrl();
		driver.quit();

	}

}
