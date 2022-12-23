package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookupImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookupImg() {
		return CreateOrgLookupImg;
	}
	
	//Business library
	/**
	 * This method will click on create organization lookup image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		CreateOrgLookupImg.click();
	}
}
