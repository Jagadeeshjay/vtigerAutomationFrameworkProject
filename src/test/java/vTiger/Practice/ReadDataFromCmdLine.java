package vTiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLine {
@Test								//its an eg for to Run time Parameters its for eclipse
									//here we click run as-run other >> arguments >>vm arguments -Dbrowser=chrome -Dusername=Jay
public void readData() {
	 String BROWSER = System.getProperty("browser");
	 String USERNAME = System.getProperty("username");
	 
	 System.out.println(BROWSER);
	 System.out.println(USERNAME);
}
}
