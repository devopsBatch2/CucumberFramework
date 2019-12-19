package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    //WorkBook
    //Sheet
    //Row
    //Cell
    //filePath

    //openExcelFile (String path, String sheetName)--> return void
    //getValue (int rowNum , int cellNum )--> return String
    //setValue (String value, int rowNum, int celNum) --> return void
    //getNumberOfrows ()-->  return int

    private static XSSFWorkbook workbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String filePath;

    public static void openExcelFile (String excelFileName,String SheetName){
        filePath="src/test/resources/data/"+excelFileName+".xlsx";
        File file =new File(filePath);

        try {
            FileInputStream input =new FileInputStream(file);
            workbook =new XSSFWorkbook(input);
            excelSheet =workbook.getSheet(SheetName);

        } catch (Exception e) {
            System.out.println("No such file in directory.");

        }

    }

    /**
     * Method will accept row num and cellNum and will return the value on
     * that cell from excel file
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getValue (int rowNum,int cellNum){
        row =excelSheet.getRow(rowNum);
        cell=row.getCell(cellNum);
        return cell.toString();
    }
    public static void setValue(String value, int rowNum, int cellNum) throws IOException {//String value insert value in row
        row =excelSheet.getRow(rowNum);
        cell =row.getCell(cellNum);
        if (cell == null){                                         //if set emptu return NULL
            cell = row.createCell(cellNum);
            cell.setCellType(CellType.STRING);                     //what kind of type
            cell.setCellValue(value);                             //provide that value as paramater
        }else{
            cell.setCellValue(value);
        }
        FileOutputStream output =null;
        try{


             output =new FileOutputStream(filePath);             //go to the file and write update ,if
            workbook.write(output);
        }catch (FileNotFoundException e){
            System.out.println("No such file in directory.");        //if no file
        }finally {
            output.close();
        }
    }

    /**
     * Method will return the number of rows in excel file
     * @return
     */
    public static int getNumberOfRows (){
        return excelSheet.getPhysicalNumberOfRows();             //get as not null number of rows
    }
                                                           //
}
