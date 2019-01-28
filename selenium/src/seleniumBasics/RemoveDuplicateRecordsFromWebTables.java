package seleniumBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoveDuplicateRecordsFromWebTables {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to the site
		driver.get("https://www.freecrm.com/");

		driver.findElement(By.name("username")).sendKeys("msingh904");
		driver.findElement(By.name("password")).sendKeys("password");
		Thread.sleep(1000);// it is necessity here because another element <div id="preloader"> obscures it
		WebElement LogInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		LogInBtn.click();

		// 2 frames are available, switch to the mainpanel frame
		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		// to Delete the duplicate records on the contact page, select the respective
		// check box
		String before_xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		String beforeCheck_xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String afterCheck_xpath = "]/td[1]/input";

		ArrayList<String> conNamesList = new ArrayList<String>();
		Set<String> conList = new HashSet<String>();
		// To iterate through the contact name list and select check box against
		for (int i = 4; i < 25; i++) {
			WebElement conName = driver.findElement(By.xpath(before_xpath + i + after_xpath));
			conName.getText();
			if ("Manish Singh".contains(conName.getText())) {
				continue;
			}
			conNamesList.add(conName.getText());
			driver.findElement(By.xpath(beforeCheck_xpath + i + afterCheck_xpath)).click();
		}

		for (String contactName : conNamesList) {
			if (conList.add(contactName)) {
				driver.findElement(By.xpath("//a[@_name='" + contactName + "']//parent::td[@class='datalistrow']"
						+ "/preceding-sibling::td/input")).click();
				// a[@_name='Jane Guha']//parent::td[@class='datalistrow']/preceding-sibling::td/input
				System.out.println("unique contact name: " + contactName);
			}
		}

		// Select the Delete option from the drop down box
		WebElement checkedRecords = driver.findElement(By.name("do_action"));
		Select select = new Select(checkedRecords);
		select.selectByVisibleText("Delete Checked");
		driver.findElement(By.xpath("//input[@value='DO']")).click();// this will generate an alert which is to be
																		// handled
		// Switch to the Alert and cancel it
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		//alert.accept();
		driver.quit();

	}
}