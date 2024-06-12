package practice.hometest;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageVerificationTest {
@Test
public void HomePageTest(Method mtd)
{
System.out.println(mtd.getName()+"test start");
String expectedPage="Home Page";
WebDriver	driver=new ChromeDriver();
driver.get("http://localhost:8888/");
driver.manage().window().maximize();
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("password");
driver.findElement(By.id("submitButton")).click();
String actualTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
//HardAssert
Assert.assertEquals(actualTitle, expectedPage);
driver.close();
System.out.println(mtd.getName()+"test end");

}
@Test
public void verifyLogoHomePage(Method mtd)
{
System.out.println(mtd.getName()+"test start");

WebDriver	driver=new ChromeDriver();
driver.get("http://localhost:8888/");
driver.manage().window().maximize();
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("password");
driver.findElement(By.id("submitButton")).click();
boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
//HardAsser
Assert.assertEquals(true, status);

//Assert.assertTrue(status);(in this methode if status is true it will pass else it will fail)
driver.close();
System.out.println(mtd.getName()+"test end");

}
}
