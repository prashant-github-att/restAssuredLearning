package com.restAssureLearning.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.restAssureLearning.Payloads.Users;

public class ExcelDataReader {
	
	private static XSSFWorkbook workbook;

	public static String[][] getAllData(String sheetName, String excelNameWithPath) throws IOException { 
		
		FileInputStream fs = new FileInputStream(excelNameWithPath);
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		String [][] exceldata = new String [rowCount][colCount];
		for (int i=0;i<rowCount; i++) {
			for (int j=0;j<colCount; j++) {
				if (sheet.getRow(i+1).getCell(j).getCellType().name().equals("NUMERIC")){
					Double d =  (Double)sheet.getRow(i+1).getCell(j).getNumericCellValue();
					exceldata[i][j] = d.toString().split("\\.")[0];
				}
				else
				exceldata[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
	
		return exceldata;
	}
	
public static String[] getAllFieldValues(String sheetName, String excelNameWithPath,String fieldName) throws IOException { 
		
		FileInputStream fs = new FileInputStream(excelNameWithPath);
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		int colValueForGivenField = 0;
		for (int i=0;i<colCount; i++) {
			if(sheet.getRow(0).getCell(i).getStringCellValue().equals(fieldName))
					colValueForGivenField=i;
			
		}
	
		String [] fieldValues = new String [rowCount];
		for (int i=0;i<rowCount; i++) {

			if (sheet.getRow(i+1).getCell(colValueForGivenField).getCellType().name().equals("NUMERIC")){
				Double d =  (Double)sheet.getRow(i+1).getCell(colValueForGivenField).getNumericCellValue();
				fieldValues[i] = d.toString().split("\\.")[0];
			}
			else
				fieldValues[i] = sheet.getRow(i+1).getCell(colValueForGivenField).getStringCellValue();
			
		}
	
		return fieldValues;
	}


	
	
}
