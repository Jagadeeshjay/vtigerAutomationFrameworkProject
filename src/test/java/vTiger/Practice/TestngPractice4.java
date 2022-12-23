package vTiger.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestngPractice4 {
	@Test
	public void createCustomerTest()
	{
		System.out.println("create custome");
	}
	@Ignore	// 1st method:- it will disable from total no of test runs
	@Test
	public void modifyCustomerTest() {
		System.out.println("modify customer");
	}

	@Test(enabled = false)	//2nd method :- it will disable from total no of test runs
	public void deletCustomerTest()
	{
		System.out.println("Delete customer");
	}
}
