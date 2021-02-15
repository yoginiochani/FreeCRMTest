package com.crm.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class newCompanyData {
	static Workbook book;
	static Sheet sheet;
	public static String filepath = "C:\\Yogini\\eclipse.workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\crm_new_company.xlsx";
	
	public static Object[][] getnewCompanyData(String sheetName)
	{
		
		FileInputStream file = null;
		try {
			 file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} 
		catch (EncryptedDocumentException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 	 for(int i = 0; i < sheet.getLastRowNum(); i++)
	 	 {
	 		 for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++)
	 		 {
	 			 data[i][k] = sheet.getRow(i+1).getCell(k).toString();
	 			 //System.out.println(data[i][k]);
	 		 }
	 		 //System.out.println();
	 	 }
		return data;
	}
	
}


