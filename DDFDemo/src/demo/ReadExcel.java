package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] getData(String fileName, String sheetName) throws IOException {	//Defining the method
		File file = new File("C:\\Software\\TestData.xlsx");
		FileInputStream ips = new FileInputStream(file);	//For reading data, for writing data, we use - FileOutputStream.
		Workbook Wb = new XSSFWorkbook(ips);	//file is in .xlsx format . For .xls we use HSSFWorkbook
		Sheet Sh = Wb.getSheet(sheetName);
		
		int rowNum = Sh.getLastRowNum() + 1;
		int colNum = Sh.getRow(0).getLastCellNum();
		String[][] data = new String[rowNum][colNum];
		
		for (int i=0; i< rowNum; i++){	//Used to iterate over rows
			Row row = Sh.getRow(i);
				for (int j=0; j<colNum; j++){	//Used to iterate over columns
					String value = row.getCell(j).getStringCellValue();
					data[i][j] = value;
				}
		}
		return data;
	}
}
