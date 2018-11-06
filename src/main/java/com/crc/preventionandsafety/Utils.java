package com.crc.preventionandsafety;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Commenting the use of Utils Files
//More COmmits

public class Utils {

        public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook propertyWorkbook = null;

    propertyWorkbook = WorkbookFactory.create(inputStream);
    
        //Read sheet inside the workbook by its name

    Sheet siteinfo = propertyWorkbook.getSheet("siteinfo");

    //Find number of rows in excel file

    int rowCount = siteinfo.getLastRowNum()-siteinfo.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {

        Row row = siteinfo.getRow(i);

        //Create a loop to print cell values in a row

        for (int j = 0; j < row.getLastCellNum(); j++) {

            //Print Excel data in console

            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

        }

        System.out.println();

    }

    

    }

    

    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class

    Utils objExcelFile = new Utils();

    //Prepare the path of excel file

    String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";

    //Call read file method of the class to read data

    objExcelFile.readExcel(filePath,"ExportExcel.xlsx","ExcelGuru99Demo");

    }

}