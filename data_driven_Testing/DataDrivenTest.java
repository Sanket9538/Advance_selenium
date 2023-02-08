package data_driven_Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
	// WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
	FileInputStream file=new FileInputStream("D:\\selenum ROGRAM\\Book1.xlsx");
	    
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rows=sheet.getLastRowNum();
		System.out.println("Numer of rows:"+ rows);
		
		XSSFRow row=sheet.getRow(0);
		int cols=row.getLastCellNum();
		System.out.println("Number of cols:"+cols);
		//retrive the specific value
		//System.out.println(sheet.getRow(2).getCell(1).toString());
		
		for(int r=0; r<=5; r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			
			
			
			for(int c=0; c<cols; c++)
			{
				XSSFCell cell=currentrow.getCell(c);
				System.out.print(cell.toString()+"     ");
			}
			
			
			System.out.println();
		}
		
		
		

	}

}
