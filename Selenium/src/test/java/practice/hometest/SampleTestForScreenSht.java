package practice.hometest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;

public class SampleTestForScreenSht {
	@Test
public void screenShot() throws IOException
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	//step1:create an object to event fire
	TakesScreenshot ts=(TakesScreenshot)driver;
	//step2:use getScreenshot method to get file
	File src= ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/test.png");
    FileUtils.copyFile(src, dest);
    driver.quit();
    
    
}

}
