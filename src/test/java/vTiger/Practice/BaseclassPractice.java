package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseclassPractice {

	@BeforeSuite
	public void bsconfig()
	{
		System.out.println("Before suite");
	}
	@BeforeMethod
	public void bmconfig()
	{
		System.out.println("Before Method");
	}
	@BeforeClass
	public void bcconfig()
	{
		System.out.println("Before Class");
	}
	@AfterClass
	public void acconfig()
	{
		System.out.println("After Class ");
	}
	@Test
	public void test()
	{
		System.out.println("Test 1");
	}
	@AfterSuite
	public void asconfig()
	{
		System.out.println("after suite");
	}
	@AfterMethod
	public void amconfig()
	{
		System.out.println(" After Method");
	}
	
}
