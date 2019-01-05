package seleniumBasics;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com");
		// all the links have input tag as "a", will return a list of WebElements
		List<WebElement> inputList = driver.findElements(By.tagName("a"));
		System.out.println("No of tags fields: " + inputList.size());// know the number of links

		// to print the content of the List use, for loop with Iterator or without
		// Iterator

		Iterator<WebElement> itr = inputList.iterator();
		for (int i = 0; i < inputList.size(); i++) {
			WebElement we = itr.next();
			System.out.println(we.getAttribute("text"));
		}

		// OR use this simple method.
		/*
		 * for (int i = 0; i < inputList.size(); i++) { String inputText =
		 * inputList.get(i).getText(); System.out.println(inputText); }
		 */
		driver.quit();

	}

}
