package com.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtils {

	public String readProperty(String key) {

		String value = null;
		try {
			FileInputStream input = new FileInputStream(
					"C:\\Users\\Naveen\\eclipse-workspace\\SpiceJet-Capstone2\\src\\test\\resources\\Config.properties");
			Properties prop = new Properties();  
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;

	}


	public String getExcelData(int sheetno, int rowno , int colno ) {
		String value = null;
		try {
			FileInputStream input = new FileInputStream(readProperty("Excel"));
			XSSFWorkbook book = new XSSFWorkbook(input);
			Cell cell = book.getSheetAt(sheetno).getRow(rowno).getCell(colno);
			value = cell.getStringCellValue();
			book.close();

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return value;

	} 






}
