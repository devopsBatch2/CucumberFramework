package runner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class ExcelTest {

    public static void main(String[] args) {

        // ~/.m2

        File file =new File("src/test/resources/data/testData.xlsx");//rigt clic under test file copy path
        try {
            FileInputStream input =new FileInputStream(file);
            XSSFWorkbook workBook=new XSSFWorkbook(input);
            XSSFSheet excelSheet =workBook.getSheet ("Sheet1");
           String value = excelSheet.getRow(0).getCell(0).toString();
            System.out.println(value);
            System.out.println(excelSheet.getRow(2).getCell(3));
            XSSFRow row =excelSheet.getRow(1);
            XSSFCell cell=row.getCell(2);//cell return me value
            System.out.println(cell);

            XSSFRow row2=excelSheet.getRow(4);
            XSSFCell cell2 =row2.createCell(3);
            cell2.setCellType(CellType.STRING);
            cell2.setCellValue("Miami");


            FileOutputStream fileOutput =new FileOutputStream("src/test/resources/data/testData.xlsx");
            workBook.write (fileOutput);




        } catch (Exception e) {
            System.out.println("Excel file does not exist!");
        }
    }
}
