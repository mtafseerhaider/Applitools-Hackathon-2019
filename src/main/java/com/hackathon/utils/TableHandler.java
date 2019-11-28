package com.hackathon.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author TAFSEER HAIDER
 * Dated: 25/11/2019
 */
public class TableHandler
{
	private WebDriver driver;

	public TableHandler (WebDriver driver)
	{
		this.driver = driver;
	}

	public int getTableRowCount (String strTableId)
	{
		int intRowCount;
		intRowCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr")).size ();

		return intRowCount;
	}

	public int getColumnCount (String strTableId)
	{
		int intColumnCount;
		intColumnCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr/td")).size ();

		return intColumnCount;
	}


}
