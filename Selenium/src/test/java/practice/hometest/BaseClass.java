package practice.hometest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseClass {
	JavaUtility j = new JavaUtility();

	public ExcelUtility elib = new ExcelUtility();
	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public WebdriverUtility wdlib = new WebdriverUtility();
    public JavaUtility jlib= new JavaUtility();
	public WebDriver driver=null;

	public HomePage hlib;

	@BeforeSuite(groups = {"smoke","regressionTest"})
	public void configBS() {
		System.out.println("==connect to DB ,Report Config===== BS");
		//dblib.getClass();
	}
   // @Parameters("browser")//one more u can receive parametr ,,
	@BeforeClass(groups = {"smoke","regressionTest"})
	public void configBC() throws IOException {//String browser1

		System.out.println("===lauch browser==== BC");
		String browser = flib.getDataFromPropertiesFile("browser");
		//String browser=browser1;
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
	}

	@BeforeMethod(groups = {"smoke","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("BM");
		 LoginPage l = new LoginPage(driver);
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		driver.get(URL);
		l.loginToapp(USERNAME, PASSWORD);


	}
	

	@AfterMethod(groups = {"smoke","regressionTest"})
	public void configAM() throws InterruptedException {
		System.out.println("AM");
		hlib= new HomePage(driver);
		hlib.Logout();
		System.out.println("logout");
	}

	@AfterClass(groups = {"smoke","regressionTest"})
	public void configAC() {
		System.out.println("AC");
		System.out.println("close the browser");
		driver.close();

	}

	@AfterSuite(groups = {"smoke","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===close Db ,Report AS");
		//dblib.closeConnection();
	}
	
	
}
