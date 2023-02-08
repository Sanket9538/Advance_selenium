package data_driver_testing1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils_method {  //

   public static FileInputStream fi;
   public static FileOutputStream fo;
   public static XSSFWorkbook wb;
   public static XSSFSheet ws;
   public static XSSFRow row;
   public static XSSFCell cell ;
   public static  CellStyle style;
   
   public static int getRowCount(String xlfile,String xlsheet) throws IOException
   {  //every method is a static method so we can access directly through class name.(no object creation is required)
	   //getRowCount=it will return the no. rows in excel sheet. need to pass excel file path and sheet name (parameters) 
	   
	   fi=new FileInputStream(xlfile); 
	   wb=new XSSFWorkbook(fi);
	   ws=wb.getSheet(xlsheet);
	   int rowcount=ws.getLastRowNum();
	   wb.close();
	   fi.close();
	   return rowcount;
	    
   }
  
   public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
   { // getCellcount=it will return the no. of cells in the parti. row. pass 3 parameters
	   fi=new FileInputStream(xlfile);
	   wb=new XSSFWorkbook(fi);
	   ws=wb.getSheet(xlsheet);
	   row=ws.getRow(rownum);
	   int cellcount=row.getLastCellNum();
	   wb.close();
	   fi.close();
       return cellcount;
         
   }
   
   public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
   { //getcelldata= read the data from cell.
	  fi=new FileInputStream(xlfile);
	  wb=new XSSFWorkbook (fi);
	  ws=wb.getSheet(xlsheet);
	  row=ws.getRow(rownum);
	  cell=row.getCell(colnum);
	  
	  
	  String data;
	  try // if cell doesnt have any data then data formatter will throw an exception.
	  {
		  //data=cell.tostring(); 
		  //to get the data from excel, we use toSString(). toString() method it will get/return the data in the string format.but in excel also we have different types of data.
		 //want data as it is in excel.so for this, we have use special class- data formatter 
		  DataFormatter formatter=new DataFormatter();
		  data=formatter.formatCellValue(cell);
		  return data;
	  }
		catch(Exception e)
		{
			data=""; // 
			
		}
	  wb.close();
	  fi.close();
	  return data;
	
   }
   
   public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
   { //this method will write the data into cell.
	   fi=new FileInputStream(xlfile);
	   wb=new XSSFWorkbook(fi);
	   ws=wb.getSheet(xlsheet);
	   row=ws.getRow(rownum);
	   cell=row.createCell(colnum);
	   cell.setCellValue(data);
	   fo=new FileOutputStream(xlfile);
	   wb.write(fo);
	   fi.close();
	   fo.close();
   }
   
   public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
   {
	   fi=new FileInputStream(xlfile);
	   wb=new XSSFWorkbook(fi);
	   ws=wb.getSheet(xlsheet);
	   row=ws.getRow(rownum);
	   cell=row.getCell(colnum);
	   
	   style=wb.createCellStyle();
	   
	   style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	   
	   
	   cell.setCellStyle(style);
	   fo=new FileOutputStream(xlfile);
	   wb.write(fo);
	   wb.close();
	   fi.close();
	   fo.close(); 
	   
   }
   
   public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
   {
	   fi=new FileInputStream(xlfile);
	  wb=new  XSSFWorkbook(fi);
	   ws=wb.getSheet(xlsheet);
	   row=ws.getRow(rownum);
	   cell=row.getCell(colnum);
	   
	   style=wb.createCellStyle();
	   
	   style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	   
	   cell.setCellStyle(style);
	   fo=new FileOutputStream(xlfile);
	   wb.write(fo);
	   wb.close();
	   fi.close();
	   fo.close();
	   
	   
	   
   }

public static int getRowcount(String path, String string) {
	// TODO Auto-generated method stub
	return 0;
}
   
   
}
