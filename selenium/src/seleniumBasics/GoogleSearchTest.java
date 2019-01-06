/**
 * 
 */
package seleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author manish
 *
 */
public class GoogleSearchTest {

	/**
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("testing");
		//Thread.sleep(2000);

		// ul[contains(@role,'listbox')]//li/decendant::div[@class='sbai']

		List<WebElement> gOptions = driver.findElements(By.xpath("//ul[contains(@role,'listbox')]//li"));

		System.out.println(gOptions.size());
		String grsult = null;

		for (int i = 0; i < gOptions.size(); i++) {

			grsult = gOptions.get(i).getText();
			System.out.println(grsult);

			if (grsult.contains("testing of hypothesis")) {
				gOptions.get(i).click();
				break;
			}
		}
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
