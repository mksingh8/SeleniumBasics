package seleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropertiesFile {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/home/manish/git/SeleniumBasics/selenium/src/seleniumBasics/config.properties");

		prop.load(ip);

		// Remove all the hard-coded values, and get it from the config file
		String url = prop.getProperty("url");
		String browseName = prop.getProperty("browser");
		Long pageLoad = Long.parseLong((prop.getProperty("pageLoadTime")));
		Long implictlyWait = Long.parseLong((prop.getProperty("implicitlyWaitTime")));

		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("browser"));

		if (browseName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			driver = new FirefoxDriver();

		} else if (browseName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/chromedriver");
			driver = new ChromeDriver();

		} else if (browseName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/internetexplorer");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implictlyWait, TimeUnit.SECONDS);

		driver.get(url);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
