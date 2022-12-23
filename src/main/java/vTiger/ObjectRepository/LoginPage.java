package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1
	
	//Rule 2  - Declaration
	
	@FindBy(name="user_name")
	private WebElement usernameedt;
	
	@FindBy(name="user_password")
	private WebElement passwordedt;
	
	@FindBy(id="submitButton")
	private WebElement loginedt;

	
	//Rule 3  - Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4	- Utilization
	
	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginedt() {
		return loginedt;
	}
	
	//Business libraries
	/**
	 * This Business library will perform login action
	 * @param Username
	 * @param Password
	 */
	public void loginToApp(String Username,String Password)
	{
		usernameedt.sendKeys(Username);
		passwordedt.sendKeys(Password);
		loginedt.click();
	}
	
	
	
}
