package seleniumBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinksImagesPart2 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to the site
		driver.get("https://www.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("msingh904");
		driver.findElement(By.name("password")).sendKeys("password");
		Thread.sleep(1000);// it is necessity here because another element <div id="preloader"> obscures it
		WebElement LogInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		LogInBtn.click();

		// 2 frames are available, switch to the mainpanel frame
		driver.switchTo().frame("mainpanel");

		// Put all the anchor tags in a List, then add all the image web-element to the
		// same list
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

		// identify the href with improper url format and put them in inactivelinks
		// array list
		ArrayList<WebElement> inactiveLinks = new ArrayList<WebElement>();

		for (int i = 0; i < links.size(); i++) {
			// System.out.println(links.get(i).getAttribute("href"));
			if (links.get(i).getAttribute("href") != null && /*(!links.get(i).getAttribute("href").contains("https://"))
					&& (!links.get(i).getAttribute("href").contains("http://"))
					&&*/ links.get(i).getAttribute("href").contains("javascript")) {
				inactiveLinks.add(links.get(i));
			}
		}
		System.out.println("Total number of inactive image and anchor links ====>" + inactiveLinks.size());
		for (int a = 0; a < inactiveLinks.size(); a++) {
			String inactlinks = inactiveLinks.get(a).getAttribute("href");
			System.out.println(inactlinks);
		}

		driver.quit();

	}

}
