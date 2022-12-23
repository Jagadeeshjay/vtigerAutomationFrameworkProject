package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility 
{

	//Declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown ;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling :: img[@title='Select']")
	private WebElement OrganizationImg ;
	
	@FindBy(name="search_text")
	private WebElement searchEdt ;
	
	@FindBy(name="search")
	private WebElement searchBtn ;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn ;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//Utilization
	
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will create new Contact with last name
	 * @param lastname
	 */
	public void CreateNewContact(String lastname)
	{
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void CreateNewContact(String lastname,String OrgName,WebDriver driver)
	{
		lastnameEdt.sendKeys(lastname);
		OrganizationImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	
}	
	
	

