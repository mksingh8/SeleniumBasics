package seleniumBasics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DesiredCap {

	public static void main(String[] args) throws MalformedURLException {
		
		/*String sProxyServerURL = "134.209.123.111";
		String sProxyServerPort = "3128";
		
		String sHttpProxy = sProxyServerURL + ":" + sProxyServerPort;
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(sHttpProxy).setFtpProxy(sHttpProxy).setSslProxy(sHttpProxy);
		*/
		//proxy.setProxyAutoconfigUrl("abc")
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("marionette", true);
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		//cap.setCapability(CapabilityType.PROXY, proxy);
		
		FirefoxOptions options = new FirefoxOptions();
		options.merge(cap);
		
		/*System.setProperty("webdriver.gecko.driver", 
				"/home/manish/Downloads/Selenium/Lib/Browser/geckodriver-v0.23.0-linux64/geckodriver");
		WebDriver driver = new FirefoxDriver(options);
		*/
		String Huburl = "http://192.168.0.105:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(Huburl), options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		

	}

}
