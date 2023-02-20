package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./Data/TestData.xlsx");
		Workbook workBook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cellN = row.getCell(cellNum);
		return cellN.getStringCellValue();
	}
}
