package seleniumBasics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlashElementUsingJS {

	static WebDriver driver;
	
	public FlashElementUsingJS() {
		super();
	}
	
	public static void main(String[] args) throws IOException, Exception {
		/*
		Abc a = new Abc();
		a.loadSite();*/
		System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.id("pass")).sendKeys("test");
		Thread.sleep(2000);
		WebElement lgInbtn = driver.findElement(By.xpath("//input[@id='u_0_2']"));
		FlashElementUsingJS.flash(lgInbtn, driver);
		driver.quit();
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i<100; i++) {
		changeColor("rgb(0,200.0)", element, driver);
		changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguement[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
