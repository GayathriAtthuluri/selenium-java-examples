package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandlingExamples {

    private static final String FILE_PATH = "C:\\Users\\gayatria\\Downloads\\TestData.xlsx";

    // Read Excel Data
    public void readExcelFile() throws IOException {

        FileInputStream file = new FileInputStream(FILE_PATH);

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("LoginData");

        int totalRows = sheet.getLastRowNum();

        int totalColumns = sheet.getRow(0).getLastCellNum();

        System.out.println("Total Rows : " + totalRows);

        System.out.println("Total Columns : " + totalColumns);

        System.out.println("\n===== Excel Data =====\n");

        for (int i = 0; i <= totalRows; i++) {

            for (int j = 0; j < totalColumns; j++) {

                String cellValue = sheet.getRow(i).getCell(j).toString();

                System.out.print(cellValue + "\t");

            }

            System.out.println();

        }

        workbook.close();

        file.close();

    }

    public static void main(String[] args) throws IOException {

        FileHandlingExamples example = new FileHandlingExamples();

        example.readExcelFile();

    }

}