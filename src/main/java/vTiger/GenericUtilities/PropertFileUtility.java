package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author Jagadeesh S
 *
 */
public class PropertFileUtility {
/**
 * This generic method will read the key from property file and  return the value
 * @param Key
 * @return
 * @throws IOException
 */
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(Key);
		return value;
		
	}


}

