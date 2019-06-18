package seleniumBasics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridConcept {

	public static void main(String[] args) throws MalformedURLException {
		
		//Start the Hub
		//java -jar selenium-server-standalone-3.141.59.jar -role hub
		
		//Start the node
		//java -Dwebdriver.gecko.driver="/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.105:4444/grid/register/
		
		
		
		
		//1. define DesireCapablities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.LINUX);
		cap.setBrowserName("firefox");
		
		//2. Firefox options
		FirefoxOptions options = new FirefoxOptions();
		options.merge(cap);
		
		String HubURL = "http://192.168.0.105:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(HubURL), options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
