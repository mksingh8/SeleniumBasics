package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ScrollingConcept {
	
	/* Syntax of JavascriptExecutor:
	JavascriptExecutor js = (JavascriptExecutor) driver;  
   	js.executeScript(Script,Arguments);
   	
   	scrollBypixel
   	executeScript("window.scrollBy(x-pixels,y-pixels)");
	
	scroll down vertical or horizontal to an element
	js.executeScript("arguments[0].scrollIntoView();", element);
		
	scroll at the bottom of web page
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	*/
	
	/*Scroll without using JavascriptExecutor
	 * 
	driver.findElement(By.xpath("xpath")).sendKeys(Keys.PAGE_DOWN)
	but this will scroll down only once.

	but if u want to move to that element, use the below code:
	WebElement scroll = driver.findElement(By.cssSelector("ur selector"));//u can use By.xpath or By.id here
	Actions actions = new Actions(driver);
	actions.moveToElement(scroll);
	actions.perform();
	
	
	*/
	
	WebDriver driver;
	JavascriptExecutor js;
	
	//
	@BeforeMethod
	public void getWebsite() {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
		driver.manage().window().maximize();
	}
	
	@Test(enabled = false)
	public void scrollByPixel() {
		
		js = (JavascriptExecutor)driver;
		//scroll down the page vertical y 900 pixel 
		js.executeScript("window.scrollBy(0, 1900)");
	}
	
	@Test(enabled = false)
	public void scrollVisibleElement() {
		String notRecomdXpath = "/html/body/div[2]/section[3]/div/div[1]/main/div[1]/div/div"
				+ "/div/div/div/ul/span/a/strong";
		WebElement ele = driver.findElement(By.xpath(notRecomdXpath));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);//this can be used for horizontal scrolling as well
		
		
		//scroll at the bottom of web page
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}

	@Test(enabled = false)
	public void scrollBySendKeys() {
		String notRecomdXpath = "/html/body/div[2]/section[3]/div/div[1]/main/div[1]/div/div/div/div"
				+ "/div/div[2]/ul[2]/li[1]/a";
		WebElement ele = driver.findElement(By.xpath(notRecomdXpath));
		ele.sendKeys(Keys.PAGE_DOWN);
	}
	
	@Test
	public void scrollByActionClass() {
		String notRecomdXpath = "/html/body/div[2]/section[3]/div/div[1]/main/div[1]/div/div"
				+ "/div/div/div/ul/span/a/strong";
		WebElement ele = driver.findElement(By.xpath(notRecomdXpath));
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	/*
	 * o/p:
		FAILED: scrollByActionClass
		org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: 
			(736.4000015258789, 4725.72509765625) is out of bounds of viewport width (1853) and height (951)	
		*/
		
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
