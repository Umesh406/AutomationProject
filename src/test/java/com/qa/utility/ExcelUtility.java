package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	//1.get the rowCount
	public static int getRowCount(String xFile,String xSheet) throws IOException
	{
		fileLoc =new FileInputStream(xFile);
		workBook= new XSSFWorkbook(fileLoc);
		workSheet = workBook.getSheet(xSheet);
		int rowCount = workSheet.getLastRowNum();
		return rowCount;
		
	}
	
	
	//2.get the cellCount
	
	public static int getCellCount(String xFile,String xSheet,int rowNum ) throws IOException
	{
		fileLoc =new FileInputStream(xFile);
		workBook= new XSSFWorkbook(fileLoc);
		workSheet = workBook.getSheet(xSheet);
		row = workSheet.getRow(rowNum);
		int cellCount=row.getLastCellNum(); 
		return cellCount;
	}
	
	//3.read the data from each cell and return the cellData
	
	public static String getData(String xFile,String xSheet,int rowNum,int coloumnNum) throws IOException
	{
		fileLoc =new FileInputStream(xFile);
		workBook= new XSSFWorkbook(fileLoc);
		workSheet = workBook.getSheet(xSheet);
		row = workSheet.getRow(rowNum);
		cell = row.getCell(coloumnNum);
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		workBook.close();
		fileLoc.close();
		return cellData;
	}
	
	
	

}
