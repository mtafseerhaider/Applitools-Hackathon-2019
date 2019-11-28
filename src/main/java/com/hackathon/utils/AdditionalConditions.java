package com.hackathon.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class AdditionalConditions
{
	public static ExpectedCondition<Boolean> isPageReady ()
	{
		return driver ->
		{
			String strBrowserID = driver.getWindowHandle ();
			String strBrowserReadyState = String.valueOf (((JavascriptExecutor) driver).executeScript ("return document.readyState"));
			String strCurrentPageTitle = driver.getTitle ();
			System.out.println (
					"Loading Page: " + strCurrentPageTitle + "..........." + "Page Loaded State: " + strBrowserReadyState + "Browser: " + strBrowserID);
			return ((JavascriptExecutor) driver).executeScript ("return document.readyState").equals ("complete");
		};
	}
}
