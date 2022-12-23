package vTiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice {
@Test(priority = 0)
public void createCustomerTest()
{
	System.out.println("create custome");
}
@Test(priority = 1)
public void modifyCustomerTest() {
	System.out.println("modify customer");
}

@Test(priority = 2)
public void deletCustomerTest()
{
	System.out.println("Delete customer");
}
}