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
		//all the links have input tag as "a"
		List<WebElement> inputList = driver.findElements(By.tagName("a"));
		System.out.println("No of input fields: " + inputList.size());
		
		//to print the content of the List use, for loop 
		for (int i = 0; i < inputList.size(); i++) {
			/*
			 * Iterator<WebElement> itr = inputList.iterator(); WebElement we = itr.next();
			 * System.out.println(we.getText());
			 */
			String inputText = inputList.get(i).getText();
			System.out.println(inputText);

		}
		System.out.println(inputList.size());
		driver.quit();

	}

}
