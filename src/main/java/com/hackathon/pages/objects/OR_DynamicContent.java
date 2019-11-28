package com.hackathon.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author TAFSEER HAIDER
 * Dated: 26/11/2019
 */
public class OR_DynamicContent
{
	@CacheLookup
	@FindBy(how = How.ID, using = ("flashSale"))
	public WebElement imgFlashSale;

	@CacheLookup
	@FindBy(how = How.ID, using = ("flashSale2"))
	public WebElement imgFlashSale2;
}
