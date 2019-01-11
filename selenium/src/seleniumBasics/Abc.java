package seleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abc extends BrowserFactory {

	public void loadSite() throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"/home/manish/git/SeleniumBasics/selenium/src/seleniumBasics/config.properties");

		prop.load(ip);

		String url = prop.getProperty("url");
		String browserName = prop.getProperty("browser");
		Long pageLoad = Long.parseLong((prop.getProperty("pageLoadTime")));
		Long implictlyWait = Long.parseLong((prop.getProperty("implicitlyWaitTime")));

		if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/chromedriver");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/internetexplorer");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implictlyWait, TimeUnit.SECONDS);

		driver.get(url);

	}

	/*// ExplicitWait
	public static void clickOnMethod(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
*/
}
