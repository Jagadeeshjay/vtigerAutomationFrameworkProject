package vTiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	private static final String ExcpectedCondoditons = null;

	/**
	 * This method will Maximize the Window when its called
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
		
	}

	/**
	 * This method will Minimize the Window when its called
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) 
	{
		driver.manage().window().minimize();
		
	}
	
	/**
	 * This Method will wait for entire page is load for 20 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This Method is used to wait for element to be Visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method Wait for element to be Clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This is a custom wait for a second to wait for element to become clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitForSecond(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<5)
		{
			try
			{
				element.click(); //exception, in order handle exception we create (try ,catch) block,IQ question
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	//This two methods are example for Method Overloading,IQ question 
	/**
	 * This Method will handle drop down based on index value
	 * @param element
	 * @param index
	 */
	public void handleDropeDown(WebElement element ,int index)   //1
	{
		Select sl=new Select(element);
		sl.selectByIndex(index);
	}
	
	/**
	 * This Method will handle drop down based on the value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element ,String value)   //2
	{
		Select sl=new Select(element);
		sl.selectByValue(value);
	}
	
	
	/**
	 * This Method will handle drop down based on the visible text
	 * @param visibleText
	 * @param element
	 */
	  public void handleDropDown(String visibleText , WebElement element)
	{
		Select sl=new Select(element);
		sl.selectByValue(visibleText);
	}
	  
	  /**
	   * This Method will perform mouse hover action
	   * @param driver
	   * @param element
	   */
	  public void mouseHoverAction(WebDriver driver ,WebElement element)
	  {
		  Actions act =new Actions(driver);
		  act.moveToElement(element).perform();
	  }
	
	  /**
	   * This Method will perform mouse hover action based on Offset //offset means x and y coordinates 
	   * @param driver
	   * @param element
	   * @param x
	   * @param y
	   */
	 public void mouseHoverAction(WebDriver driver,WebElement element ,int x,int y) 
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element, x,y).perform();
	 }
	/**
	 * This method will perform right click randomly on web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on particular  web element 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 *  This method will double click randomly on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 *  This method will perform double click on particular  web element 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will drag and drop from source element to target element 
	 * @param driver
	 * @param srcelement
	 * @param tarelement
	 */
	public void dragAndDropAction(WebDriver driver ,WebElement srcelement,WebElement tarelement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelement, tarelement).perform();
	}
	
	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException 
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * This method will switch to frame based on Index
	 * @param driver
	 * @param index
	 */
	public void switcToFrame(WebDriver driver,int index)
	{
	driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on name or ID
	 * @param driver
	 * @param nameorID
	 */
	public void switcToFrame(WebDriver driver,String nameorID)
	{
	driver.switchTo().frame(nameorID);
	}
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switcToFrame(WebDriver driver,WebElement element)
	{
	driver.switchTo().frame(element);
	}
	
	/**
	 *  This method will switch to the default frame
	 * @param driver
	 */
	public void switcToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

	
	
	/**
	 * This method used to scroll down upto specific point
	 * @param driver
	 */
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method used to make  scroll down action on Web element  
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver ,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public String takesScreenshot(WebDriver driver,String screenshot) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des =new File(".\\ScreenShot\\"+screenshot+".png");
		Files.copy(src, des);
		return des.getAbsolutePath();
		
	}
	public void switchToWindow(WebDriver driver,String partialTitle)
	
	{
		Set<String> allWindowsid = driver.getWindowHandles();
		for(String x : allWindowsid)
		{
			String curTitle = driver.switchTo().window(x).getTitle();
			if(curTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

