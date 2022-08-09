package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFile {
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFCell cell;
    FileInputStream fi;

    public static void main(String[] args) {
        ReadExcelFile read = new ReadExcelFile();
        int num = read.getRowCount("dataForNewUser.xlsx", "Sheet1");
        System.out.println(num);
        int newNum = read.getCellCount("dataForNewUser.xlsx", "Sheet1");
        System.out.println(newNum);
        String data = read.getCellData("dataForNewUser.xlsx", "Sheet1", 1, 4);
        System.out.println(data);
    }
    public int getRowCount(String fileName, String sheetName) {
        int rows = 0;
        try {
            fi = new FileInputStream("src/test/resources/Data/" + fileName);
            wb = new XSSFWorkbook(fi);
            sheet = wb.getSheet(sheetName);
            rows = sheet.getLastRowNum();
            wb.close();
            fi.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rows;
    }

    public int getCellCount(String fileName, String sheetName) {
        int colCount = 0;
        try {
            fi = new FileInputStream("src/test/resources/Data/" + fileName);
            wb = new XSSFWorkbook(fi);
            sheet = wb.getSheet(sheetName);
            colCount = sheet.getRow(0).getLastCellNum();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return colCount;
    }

    public String getCellData(String fileName, String sheetName, int rowNum, int colNum) {
        String data = null;
        try {
            fi = new FileInputStream("src/test/resources/Data/" + fileName);
            wb = new XSSFWorkbook(fi);
            sheet = wb.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

        }catch(IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
