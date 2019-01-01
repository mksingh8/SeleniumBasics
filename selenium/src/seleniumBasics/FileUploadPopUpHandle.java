package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadPopUpHandle {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.gecko.driver", "/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		

		//window popup might appear when user clicks on the browse button to find the file to be uploaded. Windows pop
		//does not supported by Selenium as of now, there is workaround for this issue.
		
		driver.navigate().to("https://html.com/input-type-file/");
		//Browse the file to be uploaded using the send keys command. identify the webelement to upload the file, but
		//don't use the click command, as window app pop will appear and selenium would not be able to handle it.
		driver.findElement(By.xpath("//input[@name='fileupload']")).sendKeys("/home/manish/Downloads/MySql/MySql Guide");
		
		FileUploadPopUpHandle obj = new FileUploadPopUpHandle();//creating object
		
		int c = obj.sum(20, 50);//instead of 'c' you can input any variable name
		System.out.println(c);	//printing the result

	}
	
	public int sum(int a, int b) {//return type is integer
		
		int c = a+b;
		return c;
	}

}
