package seleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindowPopUpConcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.popuptest.com/");
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[1]/b/a")).click();

		Set<String> handler = driver.getWindowHandles();

		System.out.println("No of popup windows: " + handler.size());

		Iterator<String> itr = handler.iterator();

		// In case of multiple pop up windows
		for (int i = 0; i < handler.size(); i++) {
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			//System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			driver.close();

		}
		// if there is only single pop up window
		/*
		 * String parentWindow = itr.next(); System.out.println("parent window id is: "
		 * + parentWindow); String childWindow = itr.next();
		 * System.out.println("child window id is: " + childWindow);
		 * driver.switchTo().window(childWindow);
		 * System.out.println("Child Window title is: " + driver.getTitle());
		 * driver.close();
		 * 
		 * driver.switchTo().window(parentWindow);
		 * System.out.println("parent Window title is: " + driver.getTitle());
		 */
		driver.quit();

		/*
		 * Summary: 3 types of pop up 1. alerts aka JavaScript pop up -- Alert API --
		 * Alert alert = driver.switchTo.alert(); accept, dismiss 2. Browse/Attach pop
		 * up -- if type=file, locator.sendKeys("qualified file path") 3. Browser Window
		 * pop up aka adv pop up -- windowsHandler API, getWindowHandles()
		 */

	}

}
