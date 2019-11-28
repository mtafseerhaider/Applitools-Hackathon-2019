package com.hackathon.base;

import com.applitools.eyes.selenium.Eyes;
import com.hackathon.configs.AutomationFactory;
import com.hackathon.constants.Globals;
import com.hackathon.utils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class AutomationBase
{
	private static AutomationFactory automationDriver;
	public static  ExcelReader       excel = new ExcelReader (Globals.EXCEL_WORKBOOK);
	public static String    strAppVersion = System.getProperty ("appVersion");
	public static String    strAppName = System.getProperty ("appName");


	@BeforeSuite(alwaysRun = true)
	public static void initiateAutomation ()
	{
		automationDriver = new AutomationFactory ();
	}

	public static WebDriver getDriver () throws MalformedURLException
	{
		return automationDriver.instantiateDriver ();
	}

	public static Eyes getEyesFor (boolean blnDisableEyes, String strAppName, String strCurrentTestName) throws Exception
	{
		return automationDriver.instantiateEyesFor (blnDisableEyes, strAppName, strCurrentTestName);
	}

	@AfterMethod(alwaysRun = true)
	public void clearCookies ()
	{
		try
		{
			getDriver ().manage ().deleteAllCookies ();
		}
		catch (Exception ex)
		{
			System.err.println ("Unable to clear cookies: " + ex.getCause ());
		}
	}

	@AfterMethod
	public void closeEyes ()
	{
		if (Globals.APPLITOOLS_DISABLE_EYES == false)
		{
			automationDriver.closeEyes ();
		}
	}


	@AfterSuite (alwaysRun = true)
	public void closeAutomationDrivers ()
	{
		automationDriver.quitDriver ();

	}

}
