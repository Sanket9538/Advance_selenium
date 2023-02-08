package data_driven_Testing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Writing_in_excel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream("D:\\selenum ROGRAM\\testdata1234.xlsx");
		 XSSFWorkbook workbook=new XSSFWorkbook();
	       XSSFSheet sheet=workbook.createSheet("Data");
	       
	       for(int r=0;r<=5;r++ )
			{
				XSSFRow row=sheet.createRow(r);
				for (int c=0;c<3;c++)
				{
					XSSFCell cell=row.createCell(c);
					cell.setCellValue("Welcome");
				}
				
			}

	       
	       workbook.write(file);
	        workbook.close();
	        file.close();
	        
	        System.out.println("writing is done");
}
}
