package com.ecommerce.utility.excel;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Excel {

	@GetMapping("/excelDownload")
	public void excelDownload(HttpServletResponse response) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("First Sheet");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;
		
		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("Number");
		cell = row.createCell(1);
		cell.setCellValue("Name");
		cell = row.createCell(2);
		cell.setCellValue("Title");
		
		// Body
		for(int i = 0; i < 3; i++) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(i);
			cell = row.createCell(1);
			cell.setCellValue(i + "_name");
			cell = row.createCell(2);
			cell.setCellValue(i + "_title");
		}
		
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");
		
		// Excel File OutputStream
		wb.write(response.getOutputStream());
		wb.close();
	}
}
