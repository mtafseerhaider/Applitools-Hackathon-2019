package com.hackathon.utils;

import com.hackathon.base.AutomationBase;
import com.hackathon.constants.Globals;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * @author TAFSEER HAIDER
 * Dated: 09/11/2019
 */
public class DataProviders extends AutomationBase
{
	@DataProvider(name = "excel")
	public Object[][] readData (Method testCase)
	{
		int rows = excel.getRowCount (Globals.EXCEL_DATASHEET);
		System.out.println ("Total rows are : " + rows);
		String testName = testCase.getName ();

		// Find the test case start row

		int testCaseRowNumber = 2;

		for (testCaseRowNumber = 2; testCaseRowNumber <= rows; testCaseRowNumber++)
		{

			String testCaseName = excel.getCellData (Globals.EXCEL_DATASHEET, 0, testCaseRowNumber);

			if (testCaseName.equalsIgnoreCase (testName))

				break;

		}

		excel.setCurrentRowNumber (testCaseRowNumber);
		System.out.println ("Test case starts from row number: " + testCaseRowNumber);

		// Checking total rows in test case

		int dataStartRowNumber = testCaseRowNumber;

		int testRows = 0;
		while (!excel.getCellData (Globals.EXCEL_DATASHEET, 0, dataStartRowNumber + testRows).equals (""))
		{
			testRows++;
		}

		System.out.println ("Total rows of data are : " + testRows);

		// Checking total cols in test case

		int columnInception = testCaseRowNumber;
		int dataStartFromColumn = 2;

		while (!excel.getCellData (Globals.EXCEL_DATASHEET, dataStartFromColumn, columnInception).equals (""))
		{
			dataStartFromColumn++;

		}

		System.out.println ("Total columns are : " + dataStartFromColumn);

		// Printing data
		Object[][] data = new Object[testRows][1];
		int i = 0;
		for (int rowNumber = dataStartRowNumber; rowNumber < (dataStartRowNumber + testRows); rowNumber++)
		{
			Hashtable<String, String> table = new Hashtable<String, String> ();
			for (int columnNumber = 2; columnNumber < dataStartFromColumn; columnNumber++)
			{
				String testData = excel.getCellData (Globals.EXCEL_DATASHEET, columnNumber, rowNumber);
				String columnName = excel.getCellData (Globals.EXCEL_DATASHEET, columnNumber, 1);
				table.put (columnName, testData);
			}

			data[i][0] = table;
			i++;
		}

		return data;

	}
}
