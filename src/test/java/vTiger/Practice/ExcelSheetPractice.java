package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1: Load File location into File Input Stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a Work Book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step 4: Navigate to required Row
		 Row rw = sh.getRow(7);
		
		//Step 5: Navigate to required Cell
		 Cell ce = rw.getCell(4);
		
		//Step 6: Capture the Data Present in that Cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		//To get multiple value
		String value1 = rw.getCell(2).getStringCellValue();
		System.out.println(value1);
		
		
		
		
	}
}
