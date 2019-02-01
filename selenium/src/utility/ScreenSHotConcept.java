package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenSHotConcept {
	static WebDriver driver;
	
	public static void TakeScreenshotOf(String imageName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("/home/manish/eclipse-workspace/abc/src/abc/"+imageName+ ".jpg"));	
		
	}
}
