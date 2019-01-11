/**
 * 
 */
package seleniumBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author manish
 *
 */
public class HandleDynamicWebTable {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * Method 1. By traversing through the table -- it has to iterate through the
		 * table. Method 2. using xpath -- this is fast. Task is to select a particular
		 * check-box in the web table.
		 */

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
		Thread.sleep(1000);//it is necessity here because another element <div id="preloader"> obscures it
		WebElement LogInBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		//LogInBtn.click();

		// applying Explicit wait
		clickOnBtn(driver, LogInBtn, 20);

		// 2 frames are available, switch to the mainpanel frame
		driver.switchTo().frame("mainpanel");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		/*
		 * Check the xpath to find a logic to implement the same in the for loop to
		 * traverse through all the contact names System.out.println(
		 * driver.findElement(By.xpath("
		 * //*[@id=\"vContactsForm\"]/table/tbody/tr[4]/td[2]/a")).getText());
		 * //*[@id="vContactsForm"]/table/tbody/tr[4]/td[1]/input
		 * //*[@id="vContactsForm"]/table/tbody/tr[5]/td[1]/input

		// *[@id="vContactsForm"]/table/tbody/tr[5]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[6]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[7]/td[2]/a
		// *[@id="vContactsForm"]/table/tbody/tr[24]/td[2]/a

		 */

		// to Delete the duplicate records on the contact page, select the respective check box
		String before_xpath = "//*[@id=\"vContactsForm\"]/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		// implement array-list to count the occurrence of unique strings
		List<String> conListArray = new ArrayList<String>();
		Set<String> uniqueCon = null;

		for (int i = 4; i < 25; i++) {
			WebElement contactname = null;
			try {
				contactname = driver.findElement(By.xpath(before_xpath + i + after_xpath));
			} catch (Exception e) {
				System.out.println("Please correct the last row number of the Web Table. Refer this error message ==>");
				e.printStackTrace();
			}
			// contactList = Arrays.asList(contactlist.getText());
			conListArray.add(contactname.getText());//to add the contact name one by one to the Array List
		}

		uniqueCon = new HashSet<String>(conListArray);
		for (String con : uniqueCon) {
			System.out.println(con + ": " + Collections.frequency(conListArray, con));
		}

		//To iterate through the contact name list and select check box against any specific name
		/*		for (int i = 4; i < 25; i++) {
			WebElement contactlist = driver.findElement(By.xpath(before_xpath + i +
					after_xpath)); 
			System.out.println(contactlist.getText());
			//to select the check box against contact name Jane Guha
			if (contactlist.getText().contains("Jane Guha")) { 
				i++;//To skip the first record, it's not a good approach as this will select 1 check box of another contact 
				//which is not intended. Implemented array list method in the next code to remove the duplicate records
				driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[" + i
						+ "]/td[1]/input")) .click();
			} 
		}
		 */



		//Select the Delete option from the drop down box
		WebElement checkedRecords = driver.findElement(By.name("do_action"));
		Select select = new Select(checkedRecords);
		select.selectByVisibleText("Delete Checked");
		driver.findElement(By.xpath("//input[@value='DO']")).click();//this will generate an alert which is to be handled

		// Switch to the Alert and cancel it
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		// Switch to the alert and accept the alert to delete the selected records
		/*
		 * driver.findElement(By.xpath("//input[@value='DO']")).click(); 
		 * alert.accept();
		 */
		driver.quit();//close the browser

	}

	// explicit wait method
	public static void clickOnBtn(WebDriver driver, WebElement locator, long timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

}
