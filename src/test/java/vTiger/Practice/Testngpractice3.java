package vTiger.Practice;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Testngpractice3 {
	public class TestNGPractice {
		@Test
		public void createCustomerTest()
		{
			Assert.fail();
			System.out.println("create custome");
			
		}
		@Test(dependsOnMethods = "createCustomerTest")
		public void modifyCustomerTest() {
			System.out.println("modify customer");
		}

		@Test(dependsOnMethods = {"createCustomerTest","modifyCustomerTest"})
		public void deletCustomerTest()
		{
			System.out.println("Delete customer");
		}
		}
}
