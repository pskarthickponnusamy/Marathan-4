package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
public static String[][] readlData(String filename) throws IOException {
		//Set Path
		XSSFWorkbook book = new XSSFWorkbook("./data/"+filename+".xlsx");		
		//Open Sheet
		XSSFSheet sheet = book.getSheetAt(0);//index start from zero		
		//GetRowCount
		int rowN = sheet.getLastRowNum();		
		//getColumnCount
		short columnN = sheet.getRow(0).getLastCellNum();	
		
		String[][]data=new String[rowN][columnN];
		//Print Entire Sheet
		for (int i = 1; i <= rowN; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnN; j++) {
				XSSFCell column = row.getCell(j);
				System.out.print(column.getStringCellValue()+" ");
				data[i-1][j]=column.getStringCellValue();
			}
			System.out.print("\n");
		}
		book.close();
		return data;
	}
}
