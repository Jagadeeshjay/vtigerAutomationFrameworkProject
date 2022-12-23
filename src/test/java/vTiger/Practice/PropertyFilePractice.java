package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {
	public static void main(String[] args) throws IOException {
		//Step 1 Load the file location into file input string
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2 Create Object of properties from java.util package
		Properties pobj=new Properties();
		
		//Step 3 Load file input string into properties
		pobj.load(fis);
		
		//Read the value using Key
		String value = pobj.getProperty("url");
		System.out.println(value);
	}

}
