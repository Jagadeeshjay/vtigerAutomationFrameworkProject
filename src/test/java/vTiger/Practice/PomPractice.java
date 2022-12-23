package vTiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.ObjectRepository.LoginPage;

public class PomPractice {
	
	public static void main(String[] args) {
			 //Log in to browser
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//	//Login to Application
		LoginPage lp=new LoginPage(driver);
//		lp.getUsernameedt().sendKeys("admin");
//		lp.getPasswordedt().sendKeys("admin");
//		lp.getLoginedt().click();
		
		lp.loginToApp("admin" , "admin");
		
		
		
	//	driver.findElement(By.name("user_name")).sendKeys("admin");
	//	driver.findElement(By.name("user_password")).sendKeys("admin");
	//	driver.findElement(By.id("submitButton")).click();

		//Click on Organization link
		//driver.findElement(By.linkText("Organizations")).click();

		//Click on Create Organization lookup image
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Click new Organization with mandatory information and save
//		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
	//	driver.findElement(By.name("button")).click();

			}


}
