package vTiger.ContactsTests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationsTest  extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	
 public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
 {
	//Step 1: Read the Test data
	String LASTNAME = eutil.readDataFromExcelFile("CONTACTS",4,2);
	String ORGNAME = eutil.readDataFromExcelFile("CONTACTS",4,3)+jutil.getRandomNumber();
	
	
	//Step 5 : Navigate to organization
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	Reporter.log("Organization is clicked",true);
	
	
	//Step 6 : Click on create organization lookup image
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	Reporter.log("Create Organization look up imageis clicked",true);
	
	
	//Step 7: Create organization with mandatory field and save
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME);
	Reporter.log("Organization is created"+ORGNAME,true);
	
	//Step 8 : Validate Organization
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String orgHeader = oip.getOrganizationHeaderText();
	Assert.assertTrue(orgHeader.contains(ORGNAME));
	
	
	//Step 9: Navigate to contact link
	hp.getContactsLnk();
	Reporter.log("Contact is clicked",true);
	
	//Step 10: Click on create contact lookup image
	ContactsPage cp=new ContactsPage(driver);
	cp.ClickOnCreateContactImg();
	Reporter.log("Create Contact look up  is clicked",true);
	
	//Step 11: Create contact with mandatory fields
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.CreateNewContact(LASTNAME,ORGNAME,driver);
	Reporter.log("Contact  is Created"+LASTNAME,true);
	
	
	
	//Step 16: Validate for Contacts
	ContactsInfoPage cip= new ContactsInfoPage(driver);
	String ContactHeader = cip.getContactHeader();
	Assert.assertEquals(ContactHeader.contains(LASTNAME), true)	;
	
	
	
 }
	
	//@Test(enabled = false)
	@Test(groups = "RegressionSuite")
	public void DemoTest()
	{
		System.out.println("This is Demo");
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



