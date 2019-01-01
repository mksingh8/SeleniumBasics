package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class HandleFrames {

		public static void main(String[] args) throws Exception {
			
			System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.navigate().to("https://www.irctc.co.in/nget/train-search");
			//Thread.sleep(2000);
			
			//driver.switchTo().frame("chatbotwindow"); //Switch to frame by Name
			//driver.switchTo().frame(0);//Switch to frame by Index
			
			//Switch to frame by WebElement
			//identify the frame by any locators
			WebElement iFrameElelement = driver.findElement(By.id("chatbotwindow"));
			driver.switchTo().frame(iFrameElelement);
			
			driver.findElement(By.id("queryInput2")).sendKeys("Train to Hwh from CSMT");
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(text(),'Ask')]")).click();
			
			//Switch back to main frame
			driver.switchTo().defaultContent();
			
			//to check if the control is given to the mainframe, enter a value in any text field
			driver.findElement(By.xpath("//input[@class='ui-inputtext ui-widget ui-state-default "+
			"ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("CSMT");
			Thread.sleep(2000);
			driver.quit();


	}

}
