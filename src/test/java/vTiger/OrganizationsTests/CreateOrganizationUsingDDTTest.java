package vTiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationUsingDDTTest extends BaseClass{

	@Test
	public void createOrgUsingDDTTest() throws IOException {

				/*Excel File - Test Data*/
				String ORGNAME = eutil.readDataFromExcelFile("Organizations", 1, 2)+jutil.getRandomNumber();
				
				
			
				
				//Step 4: Click on Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 5: click on create organization lookup image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 6: Create new organization with mandatory information and save
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
}
}