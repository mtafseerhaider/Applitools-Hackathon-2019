package com.hackathon.constants;

/**
 * @author TAFSEER HAIDER
 * Dated: 09/11/2019
 */
public class Globals
{
	// Excel sheet constant variable names
	public static final String  DATAPROVIDER_EXCEL      = "excel";
	public static final String  EXCEL_WORKBOOK          = System.getProperty ("user.dir") + "/src/resources/data/data.xlsx";
	public static final String  EXCEL_DATASHEET         = "Tests";
	public static final String  EXCEL_TESTSUITE         = "Suite";
	public static final String  APPLITOOLS_API_KEY      = "strEyesAPIKey";
	public static       boolean APPLITOOLS_DISABLE_EYES = true;
	public static final String  EXCEL_MODE              = "Mode";
	public static final String  MODE_RUN                = "RUN";
	public static final String  MODE_EYES               = "EYES";
	public static final String  MODE_SKIP               = "SKIP";

	// Login Page
	public static final String  LOGIN_USERNAME               = "strUsername";
	public static final String  LOGIN_PASSWORD               = "strPassword";
}
