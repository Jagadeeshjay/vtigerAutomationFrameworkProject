package vTiger.Practice;

import org.testng.annotations.Test;

public class Testngpractice1 {
	public class TestNGPractice {
		@Test(invocationCount = 2,priority = 0)
		public void createCustomerTest()
		{
			System.out.println("create custome");
		}
		@Test(invocationCount = 3,priority = 1)
		public void modifyCustomerTest() {
			System.out.println("modify customer");
		}

		@Test(invocationCount = 5,priority = 2)
		public void deletCustomerTest()
		{
			System.out.println("Delete customer");
		}
		}
}
