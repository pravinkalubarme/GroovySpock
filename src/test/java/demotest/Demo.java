package demotest;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {
// this is demo main class
    public static void main(String[] args) throws IOException {
        FileInputStream file= new FileInputStream("C:\\Users\\pravi\\Desktop\\1Single User.xls");
        double value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(1).getCell(0).getNumericCellValue();
        System.out.println("Value:"+value);
    }
}
