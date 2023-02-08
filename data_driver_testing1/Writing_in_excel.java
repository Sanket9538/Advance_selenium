package data_driver_testing1;

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
		 
		//for(int r=0;r<=5;r++ )
			//{
		//		XSSFRow row=sheet.createRow(r);
			//	for (int c=0;c<3;c++)
			//	{
				//	XSSFCell cell=row.createCell(c);
				//	cell.setCellValue("Welcome");
				//}
				

	//}
	   XSSFRow row1=sheet.createRow(1);
	   row1.createCell(0).setCellValue(123);
	   row1.createCell(1).setCellValue("Sanket");
		
	   XSSFRow row2=sheet.createRow(2);
	   row2.createCell(0).setCellValue(456);
	   row2.createCell(1).setCellValue("saheb");

	   XSSFRow row3=sheet.createRow(3);
	   row3.createCell(0).setCellValue(9538);
	   row3.createCell(1).setCellValue("king");

	   
	   
	   
	   
	   workbook.write(file);
	   workbook.close();
	   file.close();
	   
	   System.out.println("Done !!!");
}
}
