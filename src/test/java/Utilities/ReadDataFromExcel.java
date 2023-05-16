package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	public static String[][] getDataFromSheet(String workbookLocation, String workSheetName) throws IOException {
	    XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") + "/" + workbookLocation);
	    XSSFSheet workSheet = workbook.getSheet(workSheetName);

	    int noOfRows = workSheet.getLastRowNum() + 1;
	    int noOfColumns = workSheet.getRow(0).getLastCellNum();
	    String[][] dataTable = new String[noOfRows][noOfColumns];

	    for (int i = workSheet.getFirstRowNum(); i < workSheet.getLastRowNum() + 1; i++) {
	        Row row = workSheet.getRow(i);
	        for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
	            Cell cell = row.getCell(j);
	            dataTable[i][j] = cell.getStringCellValue();
	        }
	    }

	    workbook.close();
	    return dataTable;
	    
	    
	}
	
	private static String getCellValueAsString(Cell cell) {
	    CellType cellType = cell.getCellType();
	    String val = "";

	    switch (cellType) {
	        case STRING:
	            val = cell.getStringCellValue();
	            break;

	        case NUMERIC:
	            DataFormatter dataFormatter = new DataFormatter();
	            val = dataFormatter.formatCellValue(cell);
	            break;

	        case BOOLEAN:
	            val = String.valueOf(cell.getBooleanCellValue());
	            break;

	        case BLANK:
	            break;
	    }
	    return val;
	}

}
