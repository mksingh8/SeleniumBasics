package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorConcept {
	
	public static void main (String args[]) {
		
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		//simple example of if else loop
		if(pageTitle.equalsIgnoreCase("Simple HTML Elements For Automation - Ultimate QA")) {
			System.out.println("Correct Title is Displayed");
		}
		else {
			System.out.println("Incorrect page is dispalyed");
		}
		//locators	
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mohan");
		driver.findElement(By.id("et_pb_contact_email_0")).sendKeys("a@gmail.com");
		driver.findElement(By.name("et_pb_contact_name_0")).sendKeys("Anthony");
		driver.findElement(By.linkText("Click me using this link text!")).click();
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Click me using this link")).click();
		//detailed xpath is explained in xpath class. 
		driver.quit();
		//absolute xpath should not be used. Only relative xpath should be used.
		//cssSelector, if id present "#{idValue"}, if id not there but class, ".{className}"
		//Priority - 1.id, 2.xpath or cssSelector, 3.name, 4.class name
		
	}

}
