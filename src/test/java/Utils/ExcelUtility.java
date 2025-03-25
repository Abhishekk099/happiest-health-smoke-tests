package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    private String filePath;

    public ExcelUtility(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readUrls() throws IOException {
        List<String> urls = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // First sheet

        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming URLs are in the first column
            if (cell != null) {
                urls.add(cell.getStringCellValue());
            }
        }
        workbook.close();
        return urls;
    }

    public void updateStatus(int rowIndex, String status) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        fis.close();

        Row row = sheet.getRow(rowIndex);
        if (row == null) row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(1); // Writing status in the second column
        cell.setCellValue(status);

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
}
