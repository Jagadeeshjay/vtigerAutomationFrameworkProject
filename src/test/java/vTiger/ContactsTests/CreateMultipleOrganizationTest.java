package vTiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrganizationTest extends BaseClass {
	// Step 1: Create all the Objects
		
		@Test(dataProvider = "OrgData")
		public void createMultipleOrg(String ORG, String INDUSTRY) throws IOException {
			
			/* Property File - Common Data */
		
			String ORGNAME = ORG+jutil.getRandomNumber();

			


			// Step 4: Click on Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();

			// Step 5: click on create organization lookup image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrgLookUpImg();

			// Step 6: Create new organization with mandatory information and save
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME, INDUSTRY);

			// Step 7: Validate:
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeaderText();
			if (OrgHeader.contains(ORGNAME)) {
				System.out.println(OrgHeader);
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}

			
			
		}

		@DataProvider(name = "OrgData")
		public Object[][] getData() throws EncryptedDocumentException, IOException {
			return eutil.readMulitipleDataIntoDataProvider("MultipleOrganization");

		}
}
