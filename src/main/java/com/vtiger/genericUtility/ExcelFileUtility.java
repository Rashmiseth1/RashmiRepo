package com.vtiger.genericUtility;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	public String readStringDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable {
		FileInputStream fise=new FileInputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\staragile\\Manual Testing\\Wellsforgocompany\\Framework_sel3\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

}
