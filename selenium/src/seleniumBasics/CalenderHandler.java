package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalenderHandler {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.spicejet.com/");

		// *[@id="flightSearchContainer"]/div[4]/button
		driver.findElement(By.xpath(
				"//input[@id='ctl00_mainContent_view_date1']/following-sibling::input[@id='ctl00_mainContent_txt_Fromdate']/following-sibling::button"))
				.click();
		
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]/td[1]
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]/td[2]
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[1]/td[3]
		
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[5]/td[1]
		//*[@id="ui-datepicker-div"]/div[1]/table/tbody/tr[5]/td[7]
		
		WebElement dateValue = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[3]/a"));
		System.out.println("Get Text: "+dateValue.getText());
		System.out.println("Get Attribute class: "+dateValue.getAttribute("class"));
		System.out.println("CssValue color: "+dateValue.getCssValue("color"));
		
		System.out.println("get Location: "+dateValue.getLocation());
		System.out.println("Get Tag Name: "+dateValue.getTagName());
		
		driver.quit();
		
//		String before_xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[";
//		String after_xpath = "]/td[";
//		
//		for(int rowNum=0; rowNum<6; rowNum++) {
//			for(int colNum=0; colNum<8; colNum++) {
//				WebElement dateValues = driver.findElement(By.xpath(before_xpath+rowNum+after_xpath+colNum+"]"));
//				if(dateValues.getText().contains("15")) {
//					dateValues.click();
//				}				
//			}
//		}
		
		
		
		
		
		
		
		
		
		

	}

}
