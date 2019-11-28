package com.hackathon.utils;

import com.hackathon.base.AutomationBase;
import com.hackathon.constants.Globals;

/**
 * @author TAFSEER HAIDER
 * Dated: 09/11/2019
 */
public class ModeUtil extends AutomationBase
{
	public static boolean isSuiteRunnable (String suiteName)
	{

		int rows = excel.getRowCount (Globals.EXCEL_TESTSUITE);

		for (int rowNumber = 2; rowNumber <= rows; rowNumber++)
		{

			String suite = excel.getCellData (Globals.EXCEL_TESTSUITE, "Suite Name", rowNumber);

			if (suite.equalsIgnoreCase (suiteName))
			{

				String mode = excel.getCellData (Globals.EXCEL_TESTSUITE, Globals.EXCEL_MODE, rowNumber);

				if (mode.equalsIgnoreCase (Globals.MODE_SKIP))
				{
					return false;
				}
				else if (mode.equalsIgnoreCase (Globals.MODE_EYES))
				{
					Globals.APPLITOOLS_DISABLE_EYES = false;
					return true;
				}
				else
					return true;
			}
		}
		return true;
	}

	public static boolean isTestRunnable (String testName)
	{

		int rows = excel.getRowCount (Globals.EXCEL_TESTSUITE);

		for (int rowNumber = 2; rowNumber <= rows; rowNumber++)
		{

			String testCase = excel.getCellData (Globals.EXCEL_TESTSUITE, "Test Case Name", rowNumber);

			if (testCase.equalsIgnoreCase (testName))
			{

				String mode = excel.getCellData (Globals.EXCEL_TESTSUITE, "Mode", rowNumber);

				if (mode.equalsIgnoreCase ("SKIP"))
				{
					return false;
				}
				if (mode.equalsIgnoreCase (Globals.MODE_SKIP))
				{
					return false;
				}
				else if (mode.equalsIgnoreCase (Globals.MODE_EYES))
				{
					Globals.APPLITOOLS_DISABLE_EYES = false;
					return true;
				}
				else if (mode.equalsIgnoreCase (Globals.MODE_RUN))
				{
					return true;
				}
				else
					System.out.println ("Please set the correct execution mode.");
				System.out.println ("Correct Execution Modes are:");
				System.out.println (" RUN – For executing only functional tests");
				System.out.println (" EYES – For executing visual functional tests powered by Applitools");
				System.out.println (" SKIP – For skipping the test\n");
				System.exit (0);
			}

		}
		return true;
	}
}
