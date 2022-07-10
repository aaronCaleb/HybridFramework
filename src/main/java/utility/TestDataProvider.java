package utility;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import static utility.ReadExcelFile.excelPath;

public class TestDataProvider {


    public static Object[][] getTestData() throws IOException {

        ReadExcelFile excelReader = new ReadExcelFile(excelPath);

        int totalRows = excelReader.getRowCount("test1");
        int totalCells = excelReader.getCellCount("test1", 1);

        String testData[][] = new String[totalRows][totalCells];

        for (int rowNum = 1; rowNum < totalRows; rowNum++) { //1
            for (int colNum = 0; colNum < totalCells; colNum++) { //0
                testData[rowNum-1][colNum] = excelReader.getCellData("test1", rowNum, colNum);
            }
        }
        return testData;


    }

}
