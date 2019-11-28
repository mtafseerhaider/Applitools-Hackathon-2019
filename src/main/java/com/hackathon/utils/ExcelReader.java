package com.hackathon.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

/**
 * @author TAFSEER HAIDER
 * Dated: 09/11/2019
 */
public class ExcelReader
{
	public  String           filePath;
	public  FileInputStream  fileIn    = null;
	public  FileOutputStream fileOut   = null;
	private XSSFWorkbook     workbook  = null;
	private XSSFSheet        sheet     = null;
	private XSSFRow          row       = null;
	private XSSFCell         cell      = null;
	private String           strValue  = null;
	private int              rowNumber = 1;

	public ExcelReader (String filePath)
	{

		this.filePath = filePath;
		try
		{
			fileIn = new FileInputStream (filePath);
			workbook = new XSSFWorkbook (fileIn);
			sheet = workbook.getSheetAt (0);
			fileIn.close ();
		}
		catch (Exception e)
		{

			e.printStackTrace ();
		}

	}

	//Setter and Getters of row and columns
	public void setCurrentRowNumber (int rowNumber)
	{
		this.rowNumber = rowNumber;
	}

	public int getCurrentRowNumber ()
	{
		return this.rowNumber;
	}

	// returns the row count in a sheet
	public int getRowCount (String sheetName)
	{
		int index = workbook.getSheetIndex (sheetName);
		if (index == -1)
			return 0;
		else
		{
			sheet = workbook.getSheetAt (index);
			int number = sheet.getLastRowNum () + 1;
			return number;
		}

	}

	// returns the data from a cell
	public String getCellData (String sheetName, String colName, int rowNum)
	{
		try
		{
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex (sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt (index);
			row = sheet.getRow (0);
			for (int i = 0; i < row.getLastCellNum (); i++)
			{
				if (row.getCell (i).getStringCellValue ().trim ().equals (colName.trim ()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt (index);
			row = sheet.getRow (rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell (col_Num);

			if (cell == null)
				return "";

			if (cell.getCellType () == CellType.STRING)
				return cell.getStringCellValue ();
			else if (cell.getCellType () == CellType.NUMERIC || cell.getCellType () == CellType.FORMULA)
			{

				String cellText = String.valueOf (cell.getNumericCellValue ());
				if (HSSFDateUtil.isCellDateFormatted (cell))
				{
					double d = cell.getNumericCellValue ();
					Calendar cal = Calendar.getInstance ();
					cal.setTime (HSSFDateUtil.getJavaDate (d));
					cellText = (String.valueOf (cal.get (Calendar.YEAR))).substring (2);
					cellText = cal.get (Calendar.DAY_OF_MONTH) + "/" + cal.get (Calendar.MONTH) + 1 + "/" + cellText;

				}

				return cellText;
			}
			else if (cell.getCellType () == CellType.BLANK)
				return "";
			else
				return String.valueOf (cell.getBooleanCellValue ());

		}
		catch (Exception e)
		{

			e.printStackTrace ();
			return "row " + rowNum + " or column " + colName + " does not exist in sheet";
		}
	}

	// returns the data from a cell
	public String getCellData (String sheetName, int colNum, int rowNum)
	{
		try
		{
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex (sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt (index);
			row = sheet.getRow (rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell (colNum);
			if (cell == null)
				return "";

			if (cell.getCellType () == CellType.STRING)
				return cell.getStringCellValue ();
			else if (cell.getCellType () == CellType.NUMERIC || cell.getCellType () == CellType.FORMULA)
			{

				String cellText = String.valueOf (cell.getNumericCellValue ());
				if (HSSFDateUtil.isCellDateFormatted (cell))
				{
					// format in form of M/D/YY
					double d = cell.getNumericCellValue ();

					Calendar cal = Calendar.getInstance ();
					cal.setTime (HSSFDateUtil.getJavaDate (d));
					cellText = (String.valueOf (cal.get (Calendar.YEAR))).substring (2);
					cellText = cal.get (Calendar.MONTH) + 1 + "/" + cal.get (Calendar.DAY_OF_MONTH) + "/" + cellText;

				}

				return cellText;
			}
			else if (cell.getCellType () == CellType.BLANK)
				return "";
			else
				return String.valueOf (cell.getBooleanCellValue ());
		}
		catch (Exception e)
		{

			e.printStackTrace ();
			return "row " + rowNum + " or column " + colNum + " does not exist  in sheet";
		}
	}

}
