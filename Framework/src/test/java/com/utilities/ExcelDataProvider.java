package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;/* Workbook declaration*/
	
	public ExcelDataProvider() 
	{
		File src=new File("./TestData/DataFile.xlsx");
		
		try /* Handling FIS exception*/
		{
			FileInputStream fis= new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read the Excell file"+ e.getMessage());
		}
		
	}
	
	public String getStringData(int sheetIndex,int row,int column) /* Method Overloading Example #1 */
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int column) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	

}
