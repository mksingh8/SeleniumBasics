package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.co.in");
		// explicit wait is specifically for 1 element.
		clickOn(driver, driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[2]")), 30);
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	/*
	 * Differences:
	 * 
	 * 1) Implicit wait is set for the entire duration of the webDriver object.
	 * Suppose , you want to wait for a certain duration, let's say 5 seconds before
	 * each element or a lot of elements on the webpage load. Now, you wouldn't want
	 * to write the same code again and again. Hence, implicit wait. However, if you
	 * want to wait for only one element, use explicit.
	 * 
	 * 2) You not only need web element to show up but also to be clickable or to
	 * satisfy certain other property of web elements. Such kind of flexibility can
	 * be provided by explicit wait only. Specially helpful if dynamic data is being
	 * loaded on webpage. You can wait for that element to be developed (not just
	 * show up on DOM) using explicit wait.
	 * 
	 */
}
