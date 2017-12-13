package com.readXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	public static void main(String[] args) {
		ReadExcelSheet.readExcel("Credentials","TC2_Check_Login", "username");
	}
	public static void readExcel(String sheetName,String testCaseName, String fieldName) {
		String fileSrc = System.getProperty("user.dir")+"\\DataSheet\\TestData.xlsx";

		try {
			FileInputStream fis = new FileInputStream(fileSrc);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetName);
			
			XSSFRow row = sheet.getRow(0);
			int targetColumn = -1;
			for(int i=0; i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(fieldName))
					targetColumn=i;
			}
			
			int targetRow=-1;
			
			for(int i=0; i<sheet.getLastRowNum();i++) {
				if(row.getCell(0).getStringCellValue().trim().equalsIgnoreCase(testCaseName))
					targetRow = i;
			}
			
			row = sheet.getRow(1);
			XSSFCell cell = row.getCell(targetColumn);
			String value = cell.getStringCellValue();
			System.out.println(value);
			
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	
}
