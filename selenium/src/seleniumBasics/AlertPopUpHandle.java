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

		Alert alert = driver.switchTo().alert();//this will return a Alert, just store the result in Alert datatype variable
		String popUpmsg = alert.getText();//to get the text in the alert popup
		System.out.println(popUpmsg);
		
		//simple validation for the alert message
		if(popUpmsg.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("Correct Pop up message displayed which is " +popUpmsg);
		}
		else {
			System.out.println("Incorrect alert message is displayed.");
		}
		Thread.sleep(2000);//to halt the execution of the code for 2 secs
		alert.accept(); //to click on the accept button
		//alert.dismiss();//to click on cancel button


		//window popup might appear when user clicks on the browse button to find the file to be uploaded. Windows pop
		//does not supported by Selenium as of now, there is workaround for this issue.

		driver.navigate().to("https://html.com/input-type-file/");
		//Browse the file to be uploaded using the send keys command. identify the webelement to upload the file, but
		//don't use the click command, as window app pop will appear and selenium would not be able to handle it.
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("/home/manish/Downloads/MySql/MySql Guide");
	}

}