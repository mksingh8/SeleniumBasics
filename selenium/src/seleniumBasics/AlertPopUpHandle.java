package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		Alert alert = driver.switchTo().alert();
		String popUpmsg = alert.getText();
		System.out.println(popUpmsg);
		
		if(popUpmsg.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("Correct Pop up message displayed which is " +popUpmsg);
		}
		else {
			System.out.println("Incorrect alert message is displayed.");
		}
		Thread.sleep(2000);//to halt the execution of the code for 2 secs
		alert.accept(); //to click on the accept button
		//alert.dismiss();//to click on cancel button

	}

}