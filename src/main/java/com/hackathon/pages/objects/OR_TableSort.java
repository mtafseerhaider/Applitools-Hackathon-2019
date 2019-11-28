package com.hackathon.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author TAFSEER HAIDER
 * Dated: 24/11/2019
 */
public class OR_TableSort
{
	@CacheLookup
	@FindBy(how = How.ID, using = ("amount"))
	public WebElement lblAmountHeader;

	@CacheLookup
	@FindBy(how = How.ID, using = ("transactionsTable"))
	public WebElement tblTransactionTable;
}
