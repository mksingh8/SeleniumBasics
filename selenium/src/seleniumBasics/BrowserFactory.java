package seleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver driver;

	// public static void main(String[] args) throws IOException {
	// openWebsite();
	/*
	 * System.setProperty("webdriver.gecko.driver",
	 * "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver"
	 * ); WebDriver driver = new FirefoxDriver();//Launching FF browser
	 * 
	 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//dynamic
	 * wait. max time allowed for page to load.
	 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//dynamic
	 * wait. max wait time, system will //wait for web-element to appear on page
	 * 
	 * driver.get("https://www.google.com");
	 * 
	 * System.out.println(driver.getClass()); driver.getCurrentUrl(); driver.quit();
	 */

// creating a general method that can be extended to open the Web site directly
	public static void openWebsite() throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/home/manish/git/SeleniumBasics/selenium/src/seleniumBasics/config.properties");
		prop.load(ip);

		String url = prop.getProperty("url");
		String broserName = prop.getProperty("browser");
		Long pageLoad = Long.parseLong(prop.getProperty("pageLoadTime"));
		Long implictlyWait = Long.parseLong(prop.getProperty("implicitlyWaitTime"));

		if (broserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			driver = new FirefoxDriver();
		} else if (broserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/chromedriver");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implictlyWait, TimeUnit.SECONDS);

		driver.get(url);

	}
}
