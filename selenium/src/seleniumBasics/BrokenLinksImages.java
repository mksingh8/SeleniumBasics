package seleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinksImages {

	public static void main(String[] args) throws InterruptedException, IOException, MalformedURLException {
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

		// Put all the anchor tags in a List, then add all the image web-element to the
		// same list
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));

		// remove the anchor and image files without any link (i.e. href) and put the
		// remaining link in activelinks array list
		ArrayList<WebElement> activeLinks = new ArrayList<WebElement>();
		System.out.println("Total number of image and anchor links ====>" + links.size());

		for (int i = 0; i < links.size(); i++) {
			//System.out.println(links.get(i).getAttribute("href"));
			if (links.get(i).getAttribute("href") != null
					&& (!links.get(i).getAttribute("href").contains("javascript")) 
					&& (!links.get(i).getAttribute("href").contains("<a"))) {
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("Total number of image and anchor links ====>" + links.size());
		System.out.println("Total numbes of active links ====>" + activeLinks.size());
/*		//to print all the href, check the links not following proper URL format and remove those links from the above for loop conitions
		for(int m=0; m<activeLinks.size(); m++) {
			System.out.println(activeLinks.get(m).getAttribute("href"));
		}
*/		

		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection con = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();

			con.connect();
			String responseMsg = con.getResponseMessage();
			con.disconnect();
			
			System.out.println(activeLinks.get(j).getAttribute("href") +"====>"+responseMsg);

		}

	}

}
