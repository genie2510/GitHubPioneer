package com.business.thrive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.business.thrive.ReadMatchData.PlayerInfo;

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

	public static void writeToExcel(Sheet sheet, List<PlayerInfo> teamPlayers, boolean isTabExist) {
		int rowIdx = 1;

		if(isTabExist) {
			System.out.println("Existtttttttttttttttt");
			int maxColumn = 0;
			for (Row row : sheet) {
			    if (row.getLastCellNum() > maxColumn) {
			        maxColumn = row.getLastCellNum();
			    }
			}

			sheet.shiftColumns(1, maxColumn-1, 1);
			for (PlayerInfo p : teamPlayers) {
				Row row = sheet.getRow(rowIdx++);
				if (!p.score.isEmpty()) {
					if (p.score.equals("DNB")) {
						row.createCell(1).setCellValue(p.score);
					} else {
						try {
							row.createCell(1).setCellValue(Double.parseDouble(p.score));
						} catch (NumberFormatException e) {
							row.createCell(1).setCellValue(p.score);
						}
					}
				}
			}	
		}else {	
			for (PlayerInfo p : teamPlayers) {
				Row row = sheet.createRow(rowIdx++);
				
				row.createCell(0).setCellValue(p.name);
				if (!p.score.isEmpty()) {
					if (p.score.equals("DNB")) {
						row.createCell(1).setCellValue(p.score);
					} else {
						try {
							row.createCell(1).setCellValue(Double.parseDouble(p.score));
						} catch (NumberFormatException e) {
							row.createCell(1).setCellValue(p.score);
						}
					}
				}
			}
		}		
	}

	public static Workbook createExcelTab(String team, String excelFilePath, List<PlayerInfo> teamPlayers) {
		File file = new File(excelFilePath);
		Workbook excelSheet = null;
		boolean isTabExist = false;
		
		try {
			excelSheet = file.exists() ? new XSSFWorkbook(new FileInputStream(file)) : new XSSFWorkbook();
			Sheet tab = excelSheet.getSheet(team);
			if (tab == null) {
				tab = excelSheet.createSheet(team);
				CellStyle headerStyle = excelSheet.createCellStyle();
				Font headerFont = excelSheet.createFont();
				headerFont.setBold(true);
				headerStyle.setFont(headerFont);
				headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

				tab.createRow(0);
				Row headerRow = tab.createRow(0);
				Cell headerCell = headerRow.createCell(0);
				//headerCell.setCellValue("Won " + "winner");
				headerCell.setCellStyle(headerStyle);

				for (int col = 0; col < 20; col++) {
					Cell cell = headerRow.getCell(col);
					if (cell == null) {
						cell = headerRow.createCell(col);
					}
					cell.setCellStyle(headerStyle);
				}
				System.out.println("Created new Tab for team : " + team);
			} else {
				System.out.println("Tab already exist for team : " + team);
				isTabExist = true;
			}
			writeToExcel(tab,teamPlayers,isTabExist);
			try (FileOutputStream fos = new FileOutputStream(file)) {
				excelSheet.write(fos);
			}
			
		} catch (Exception e) {
			System.err.println("Error writing to Excel: " + e.getMessage());
		}
		return excelSheet;
	}
}
