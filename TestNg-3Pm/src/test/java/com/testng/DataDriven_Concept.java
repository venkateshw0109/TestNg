package com.testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

public class DataDriven_Concept extends BaseClass{
	
	  

	public static void main(String[] args) throws IOException {
		browser("chrome");
		getUrl("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		
	
		File f = new File("C:\\Users\\mages\\OneDrive\\Desktop\\Datas.xlsx");// xls

		FileInputStream fis = new FileInputStream(f);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheetAt = wb.getSheetAt(0);

		int rowSize = sheetAt.getPhysicalNumberOfRows();

		for (int i = 0; i < rowSize; i++) {

			XSSFRow row = sheetAt.getRow(i);

			int cellSize = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellSize; j++) {
				XSSFCell cell = row.getCell(j);

				CellType cellType = cell.getCellType();

				if (cellType.equals(cellType.STRING)) {

					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}

				else if (cellType.equals(cellType.NUMERIC)) {

					double d = cell.getNumericCellValue();
					long l = (long) d;
					System.out.println(l);

				}
			}
		}

		System.out.println(">>>>>>Particular Data<<<<<<<<");
		String stringCellValue = wb.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
		System.out.println(stringCellValue);
			
		WebElement userName = driver.findElement(By.xpath("//input[@id='ap_email']"));
		userName.sendKeys(stringCellValue);
//	
	}

}
