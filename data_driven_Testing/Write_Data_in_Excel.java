package data_driven_Testing;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Write_Data_in_Excel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream("D:\\selenum ROGRAM\\testdata13.xlsx");
       XSSFWorkbook workbook=new XSSFWorkbook();
       XSSFSheet sheet=workbook.createSheet("Data");
       //XSSFCell cell=row.createCell(c);

		Scanner sc=new Scanner(System.in); 
		for(int r=0;r<=3;r++ )
		{
			XSSFRow row=sheet.createRow(r);
			for (int c=0;c<2;c++)
			{
			  System.out.println("enter a value");
				String value=sc.next();
				row.createCell(c).setCellValue(value);
				
			}
			
		}
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing is done");
		
		
	}

}
