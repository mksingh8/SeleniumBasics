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
			
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//dynamic wait. max time allowed for page to load.
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//dynamic wait. max wait time, system will 
			//wait for web-element to appear on page
			
			driver.navigate().to("https://www.irctc.co.in/nget/train-search");
			//Thread.sleep(2000);//static wait
			
			Actions action = new Actions(driver);
			
			//mouse hovering functionality. reach to an element
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),' TRAINS ')]"))).build().perform();
			//Thread.sleep(3000);//static wait is not required if you use dynamic wait
			driver.findElement(By.xpath("//span[contains(text(),'Book Ticket')]")).click();
			
			//action.build().perform();//always use this command at the end of action command
			
			//performing drag and drop
			driver.navigate().to("http://jqueryui.com/droppable");
			
			//page is having one frame, so switch the control to frame
			driver.switchTo().frame(0);
			action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
			.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();
			
			//switch to main frame
			driver.switchTo().defaultContent();
			
			driver.quit();

	}

}
