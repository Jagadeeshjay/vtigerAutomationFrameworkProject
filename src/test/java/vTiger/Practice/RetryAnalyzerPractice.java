package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyserImplementation.class)
	public void practiceRetry()
	{
		System.out.println("Run");
		Assert.fail();
	}
	
	public void practiceRetry1()
	{
		System.out.println("Run 1");
	}

}
