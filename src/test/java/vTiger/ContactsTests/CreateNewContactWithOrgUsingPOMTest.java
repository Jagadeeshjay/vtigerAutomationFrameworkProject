package vTiger.ContactsTests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateNewContactWithOrgUsingPOMTest extends BaseClass {
	
	@Test
	
public void createConWithOrgTest() throws IOException {
		
		//Step 1:-read test Data		
		String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 2);
		String ORGNAME = eutil.readDataFromExcelFile("Contacts", 4, 3)+jutil.getRandomNumber();
		
		
		
		
		//Step 5: Navigate to Organizations LInk
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Click On create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create Organization with Mandatory details and Save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 8 Validate Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("Organization created");
		}
		else
		{
			System.out.println("Organization not created");
		}
		
		//Step 9: Navigate to Contacts link
		hp.clickOnContactsLink();
		
		//Step 10: Click on Create Contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.ClickOnCreateContactImg();
		
		//Step 11: Create Contact with mandatory fields 
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContact(LASTNAME, ORGNAME, driver);
		
		//Step 16: Validate for Contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getContactHeader();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(ContactHeader);
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
	
		
		
		
	}
}
