package dataDrivenApproach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Xls_Reader;

public class DataDrivenConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.w3schools.com/howto/howto_css_signup_form.asp");
		driver.findElement(By.xpath("//*[@id=\"main\"]/button")).click();
		Thread.sleep(1000);
		
/*		Here I have created a utility Xls_Reader which has the necessary excel actions needed. Its a public class so just
 * create an instance/object of the class and call all it's method using object reference.

*/		
		String sheetName = "RegData";
		String userNameCol = "username";
		String passCol = "password";

		Xls_Reader reader = new Xls_Reader(
				"/home/manish/git/SeleniumBasics/selenium/src/test/Data/WebDriverTestDataDemo.xlsx");
		int count = reader.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= count; rowNum++) {
			String userName = reader.getCellData(sheetName, userNameCol, rowNum);
			String password = reader.getCellData(sheetName, passCol, rowNum);
			
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter email']")).clear();
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter email']")).sendKeys(userName);
			
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter Password']")).clear();
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Enter Password']"))
			.sendKeys(password);
			
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Repeat Password']")).clear();
			driver.findElement(By.xpath("//*[@id=\"id01\"]//input[@placeholder='Repeat Password']"))
					.sendKeys(password);

		}
		
		driver.close();
	}

}
