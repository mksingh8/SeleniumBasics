package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

	public class ActionClass {

		public static void main(String[] args) throws Exception {
		
			System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.navigate().to("https://www.irctc.co.in/nget/train-search");
			Thread.sleep(2000);
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),' TRAINS ')]"))).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'Book Ticket')]")).click();
			
			//action.build().perform();
			

	}

}
