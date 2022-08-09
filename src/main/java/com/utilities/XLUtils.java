package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	
	
	public static int getRowCount(String xlfile,String xlsheet)  
	{
		int rowcount = 0;
		try {
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			rowcount=ws.getLastRowNum();
			wb.close();
			fi.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(" File NotFound Exception has been occured");
		} catch (IOException e) {
			System.out.println(" IOException has been occured");
		}
		return rowcount;
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) 
	{
		int cellcount = 0;
		try {
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) 
	{
		String data = null;
		try {
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.getCell(colnum);
			try 
			{
				DataFormatter formatter = new DataFormatter();
			    String cellData = formatter.formatCellValue(cell);
			    return cellData;
			}
			catch (Exception e) 
			{
				data="";
			}
			wb.close();
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	public static String fetchExcelData(String EleName) throws IOException

	   {

		   
		   String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\Data.xlsx";
		   String temp[][] = new String[2][2];
		   
		   File f = new File(path);
		   FileInputStream fis = new FileInputStream(f);
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		   int x=0;
		   int y=0;
		   
		   for(int a=0;a<wb.getNumberOfSheets();a++)
		   {
			   //System.out.println("Current sheet name is "+wb.getNumberOfSheets());
			   String sheetName = wb.getSheetName(a);
			   XSSFSheet xs= wb.getSheet(sheetName);
			   int rowno = xs.getLastRowNum();
			   String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];
			   
			   
			   for(int i=0;i<rowno;i++)
			   {
				   int cellno = xs.getRow(i).getLastCellNum();
				   //System.out.println("Row count is "+rowno+" and cell count is "+cellno);
				   
				   for(int j=0;j<cellno;j++)
				   {
					   data[i][j] = xs.getRow(i).getCell(j).toString();
					   //System.out.println(data[i][j]);
					   if(data[i][j].equalsIgnoreCase(EleName) && data[i][j]!=null)
					   {
						   data[i][j+1]= xs.getRow(i).getCell(j+1).toString();
						   temp[x][y] = data[i][j+1];
						   break;
					   }
					   
				   }
				   
			   }
		   }
		   
		  
	   return temp[x][y]; 
	}
	
	public static void setCellData(String EleName,String text) throws IOException
	   {
		  
			String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\testData\\Data.xlsx";
		   File f = new File(path);
		   FileInputStream fis = new FileInputStream(f);
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		   FileOutputStream fos = null;
		   for(int a=0;a<wb.getNumberOfSheets();a++)
		   {
			   String sheetName = wb.getSheetName(a);
			   XSSFSheet xs= wb.getSheet(sheetName);
			   int rowno = xs.getLastRowNum();
			   String data[][] = new String[rowno][xs.getRow(0).getLastCellNum()];
			  
			   
			   for(int i=0;i<rowno;i++)
			   {
				   int cellno = xs.getRow(i).getLastCellNum();
				   
				   for(int j=0;j<cellno;j++)
				   {
					   data[i][j] = xs.getRow(i).getCell(j).toString();
					  
					   if(data[i][j].equalsIgnoreCase(EleName) && data[i][j]!=null)
					   {
						   Cell c = xs.getRow(i).createCell(j+1);
						   c.setCellValue(text);
						    fos = new FileOutputStream(f);
						   wb.write(fos);
					   }
					   
				   }
				   
			   }
		   }
		   System.out.println(fos + "test");
		  
	  fos.close();
	}
}
