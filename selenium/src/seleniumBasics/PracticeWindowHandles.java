package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.shaadi.com/");
		driver.findElement(By.xpath("//a[@class='member_login']")).click();
		WebElement email = driver.findElement(By.xpath("//div[@id='modalContent_login']"
				+ "//div[@class='form_container']//input[@name='email' and @id='login_page']"));
		Thread.sleep(1000);
		email.sendKeys("aman@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//div[@id='modalContent_login']//div[@class='form_container']//input[@name='password' and @id='password_page']"));
		pass.sendKeys("passsword");

	}

}
