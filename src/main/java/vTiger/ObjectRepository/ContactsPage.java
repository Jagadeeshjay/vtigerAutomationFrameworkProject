package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement CreateContactLookupImg;

//Initialization
public ContactsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}



//Utilization
public WebElement getCreateContactLookupImg()
{
	return CreateContactLookupImg;
}

//Business library
/**
 * This method will click on create contact lookup image
 */
public void ClickOnCreateContactImg()
{
	 CreateContactLookupImg.click();	
}
}
