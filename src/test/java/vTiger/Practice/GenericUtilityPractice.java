package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.PropertFileUtility;

public class GenericUtilityPractice {
	
public static void main(String[] args) throws IOException {
	
	PropertFileUtility pUtil=new PropertFileUtility();
	String value = pUtil.readDataFromPropertyFile("browser");
	System.out.println(value);
}
}
