package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotConcept {
	static WebDriver driver;

	public static void TakeScreenshotOf(String imageName) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(
				System.getProperty("user.dir") + "/ScreenShots/" + imageName + "_" + System.currentTimeMillis() + ".jpg"));

	}

	public static String TakeScreenshotpath(String imageName) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(file, new File(System.getProperty("user.dir") + "/ScreenShots/" + imageName
				+ "_" + System.currentTimeMillis() + ".jpg"));
		
		String path = System.getProperty(System.getProperty("user.dir") + "/ScreenShots/" + imageName
				+ "_" + System.currentTimeMillis() + ".jpg");

		// System.out.println(path);
		return path;

	}

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver",
				"/home/manish/Downloads/Selenium/Lib" + "/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		System.out.println(TakeScreenshotpath("abc"));
		driver.quit();
		
	}
}
