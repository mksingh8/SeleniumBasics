package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static void main(String[] args) {
	 
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");

	}

}
