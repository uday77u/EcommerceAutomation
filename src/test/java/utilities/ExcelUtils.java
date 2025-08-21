package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;

    public ExcelUtils(String excelPath) {
        try (FileInputStream fis = new FileInputStream(excelPath)) {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load Excel file: " + excelPath, e);
        }
    }

    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.toString();
    }

    public int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getLastRowNum() + 1;
    }
}
