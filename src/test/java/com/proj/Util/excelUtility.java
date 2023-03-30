package com.proj.Util;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class excelUtility {
	public static HashMap<String, String> getLocatorInfo(String filePath, String objName) {
		HashMap<String, String> map = new HashMap<String, String>();
		try (InputStream ins = new FileInputStream(filePath)){
			Workbook workbook = WorkbookFactory.create(ins);
			Sheet sheet = workbook.getSheetAt(0);
			int num = sheet.getLastRowNum();
			for (int i = 1; i < num; i++) {
				Row row = sheet.getRow(i);
				String tempObjName = row.getCell(0).getStringCellValue();
				if (tempObjName.equalsIgnoreCase(objName)) {
					map.put("locatorProperties", row.getCell(1).getStringCellValue());
					map.put("locatorValue", row.getCell(2).getStringCellValue());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in given location");
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			System.out.println("EncryptedDocumentException error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input output exception error");
			e.printStackTrace();
		}
		return map;
	}
}
