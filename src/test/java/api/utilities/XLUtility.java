package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	
	public int getRowCount(String sheetName) throws Exception
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Last Row Number: "+rowCount);
		workbook.close();
		fi.close();
		return rowCount;
		
	}
	
	public int getCellCount(String sheetName, int rowNum) throws Exception
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	
	
	
	public String getCellData(String sheetName, int rowNum, int colNum) throws Exception
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			
			data=formatter.formatCellValue(cell);
		}catch (Exception e) {
			data="";
			
		}
		workbook.close();
		fi.close();
		return data;
	
	}
	
	

}
