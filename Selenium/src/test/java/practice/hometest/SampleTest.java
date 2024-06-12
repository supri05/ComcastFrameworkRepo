package practice.hometest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SampleTest {
	@Test
	public void HomePageTest(Method mtd)
	{
	Reporter.log(mtd.getName()+"test start",true);
	
	Reporter.log("step-1",true);
	Reporter.log("step-2",true);
	SoftAssert s=new SoftAssert();
	Assert.assertEquals("Home","Home");
	
	Reporter.log("step-3",true);
	s.assertEquals("Title1","Title");
	Reporter.log("step-4",true);
	Reporter.log(mtd.getName()+"test end",true);
	s.assertAll();//it will print the exception
	}
	@Test
	public void verifyLogoHomePage(Method mtd)
	{
	Reporter.log(mtd.getName()+"test start",true);
	Reporter.log("step-1",true);
	Reporter.log("step-2",true);
	Reporter.log("step-3",true);
	Assert.assertTrue(true);
	Reporter.log("step-4",true);
	
	Reporter.log(mtd.getName()+"test end",true);

	}
}
