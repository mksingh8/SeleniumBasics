package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
		
		//use Select class to handle dropdown box. Create the object of Select class by passing the  
		Select select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByVisibleText("Saab");
		select.selectByIndex(0);
		//select.selectByValue("MentionStringTobeSelected");
		
		//
		
		
	}

}
