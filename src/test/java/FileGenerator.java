import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("username");
        header.createCell(1).setCellValue("password");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("standard_user");
        row1.createCell(1).setCellValue("secret_sauce");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("visual_user");
        row2.createCell(1).setCellValue("secret_sauce");


        FileOutputStream fileOut = new FileOutputStream("src/test/resources/testdata.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();

        System.out.println("Success! testdata.xlsx has been created.");
    }
}