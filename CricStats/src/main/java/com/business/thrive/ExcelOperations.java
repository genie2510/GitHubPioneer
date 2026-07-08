package com.business.thrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static String createExcel(String series) {

		String filePath = "src/main/resources/" + series + ".xlsx";
		File file = new File(filePath);

		if (file.exists()) {
			System.out.println("Excel file already exists at: " + filePath);
		} else {
			System.out.println("Creating new Excel file: " + filePath);
		}
		return filePath;
	}
	
	public static void createExcelTab(String team, String excelFilePath) {
        File file = new File(excelFilePath);
        
        try (Workbook workbook = file.exists() ? new XSSFWorkbook(new FileInputStream(file)) : new XSSFWorkbook()) {
            
            Sheet sheet1 = workbook.getSheet(team);
            if (sheet1 == null) {
                sheet1 = workbook.createSheet(team);
                System.out.println("Created new Tab for team : "+team);
            }else
            	System.out.println("Tab already exist for team : "+team);
            
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }
        } catch (Exception e) {
            System.err.println("Error writing to Excel: " + e.getMessage());
        }
    }
}
