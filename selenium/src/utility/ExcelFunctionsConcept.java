package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctionsConcept {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelFunctionsConcept(String path) {

			try {
				fis = new FileInputStream(path);
				this.path = path;
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
				fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//return number of rows available in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index== -1) {//if sheet does not exist, return 0
			return 0;
		} else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum()+1;
			return number;
		}
	}
	
	//return data of a cell
	public void getCellData(String sheetName, String colName) {
		
		
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		ExcelFunctionsConcept excel = new ExcelFunctionsConcept("/home/manish/git/SeleniumBasics/selenium"
				+ "/src/test/Data/WebDriverTestDataDemo.xlsx");
		int rowCount = excel.getRowCount("RegData");
		System.out.println("sheet1 roecount: " +rowCount);
		
		System.out.println("sheet2 roecount: "+excel.getRowCount("Sheet2"));
		System.out.println("sheet3 roecount: "+excel.getRowCount("Sheet3"));

	}

}
