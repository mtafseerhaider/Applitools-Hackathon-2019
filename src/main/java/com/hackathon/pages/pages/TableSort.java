package com.hackathon.pages.pages;

import com.hackathon.pages.objects.OR_TableSort;
import com.hackathon.utils.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.hackathon.utils.SmartWait.waitFor;

/**
 * @author TAFSEER HAIDER
 * Dated: 24/11/2019
 */
public class TableSort
{
	WebDriver    driver;
	OR_TableSort orTableSort = null;

	public TableSort (WebDriver driver)
	{
		this.driver = driver;
		orTableSort = PageFactory.initElements (driver, OR_TableSort.class);
	}

	public void clickAmountHeader ()
	{
		waitFor (orTableSort.lblAmountHeader, Timer.getIntWaitTime ());
		orTableSort.lblAmountHeader.click ();
	}

	public List<String> getOriginalAmountColumnList ()
	{
		String strTableId = "transactionsTable";
		int intRowCount;
		int intColumnCount;
		List<String> amountColumnList = new ArrayList<> ();
		intRowCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr")).size ();
		intColumnCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr/td[5]")).size ();
		for (int i = 1; i <= intColumnCount; i++)
		{
			String amountColumnText = driver.findElement (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr[" + i + "]/td[5]/span")).getText ();
			amountColumnList.add (amountColumnText);
		}

		return amountColumnList;
	}

	public List<String> getSortedAmountColumnList ()
	{
		String strTableId = "transactionsTable";
		int intRowCount;
		int intColumnCount;
		List<String> amountColumnList = new ArrayList<> ();
		intRowCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr")).size ();
		intColumnCount = driver.findElements (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr/td[5]")).size ();
		for (int i = 1; i <= intColumnCount; i++)
		{
			String amountColumnText = driver.findElement (By.xpath ("//*[@id='" + strTableId + "']/tbody/tr[" + i + "]/td[5]/span")).getText ();
			amountColumnList.add (amountColumnText);
		}

		// Sorting part
		amountColumnList.stream().sorted().collect(Collectors.toList()).equals(amountColumnList);
		return amountColumnList;
	}

	public boolean isAmountColumnSortedSuccessfully ()
	{
		List<String> originalAmountColumnList = getOriginalAmountColumnList ();
		List<String> sortedAmountColumnList = getSortedAmountColumnList ();

		if (!originalAmountColumnList.equals (sortedAmountColumnList))
		{
			return false;
		}

		return true;
	}

}
