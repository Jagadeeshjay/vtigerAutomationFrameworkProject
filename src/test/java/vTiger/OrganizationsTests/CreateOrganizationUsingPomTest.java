package vTiger.OrganizationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateOrganizationUsingPomTest extends BaseClass{
	
	@Test(retryAnalyzer=vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void createOrgUsingPomTest() throws IOException {
		
		
		
		/*Excel File - Test Data*/
		String ORGNAME = eutil.readDataFromExcelFile("Organizations", 1, 2)+jutil.getRandomNumber();
		
		WebDriver driver = null;
		
				//Step 4: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 5: click on create organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create new organization with mandatory information and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 7: Validate:
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
	
	
	}
}
