package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/**
	 * This method will read the data from Excel sheet
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String SheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		 Row rw = sh.getRow(row);
		 Cell ce = rw.getCell(cell);
		String value = ce.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will Count the last row number  from Excel sheet
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method will write the Data into Excel sheet
	 * @param SheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataintExcelFile(String SheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(row);
		Cell ce = rw.getCell(cell);
		
		ce.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(IConstantUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will read Multiple data into the data provider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMulitipleDataIntoDataProvider(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();	//---row
		int lastCell = sh.getRow(0).getLastCellNum();	//----cell
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
