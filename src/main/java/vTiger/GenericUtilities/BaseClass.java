package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations
 * @author Jagadeesh
 *
 */
public class BaseClass {
public 	PropertFileUtility putil=new PropertFileUtility();
public	ExcelFileUtility eutil=new ExcelFileUtility();
public	JavaUtility jutil=new JavaUtility();
public	WebDriverUtility wutil=new WebDriverUtility();
public static WebDriver sdriver=null;
public WebDriver driver=null;
	
	
@BeforeSuite (groups = {"SmokeSuite","RegressionSuite"})
public void bsconfig()
{
	System.out.println("========Database Connection Successfull=======");
}

//@Parameters("BROWSER")		//We use this tag when we do Parallel execution for different browsers
//This method will only work for running for different browser,if need to do other execution e have to comment this 
//parameter tag
@BeforeTest
//@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
public void bcconfig(/*String BROWSER*/) throws IOException
{
	String BROWSER = putil.readDataFromPropertyFile("browser");
	String URL = putil.readDataFromPropertyFile("url");
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("========"+BROWSER+"========Browser is launched========");
		
	}
	else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		System.out.println("========"+BROWSER+"========Browser is launched========");
		
	}
	else
	{
		System.out.println("========Invalid Browser Details========");
	}
	sdriver = driver;
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);
	
	}

@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
public void bmconfig() throws IOException
{
	String USERNAME = putil.readDataFromPropertyFile("username");
	String PASSWORD = putil.readDataFromPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("========Login To App Is Sucessfull========");

}
@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
public void amconfig()
{
	HomePage hp=new HomePage(driver);
	hp.logoutOfApp(driver);
	System.out.println("========Log OUt Is Sucessfull========");
	
}

@AfterTest
//@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
public void afconfig()
{
	driver.quit();
	System.out.println("========Browser Is Closed========");
}

@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
public void ascongif()
{
	System.out.println("========Database Is Closed========");
}



}
