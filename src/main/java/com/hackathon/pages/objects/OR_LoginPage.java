package com.hackathon.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class OR_LoginPage
{
	@CacheLookup
	@FindBy(how = How.ID, using = ("username"))
	public WebElement txtUsername;

	@CacheLookup
	@FindBy(how = How.ID, using = ("password"))
	public WebElement txtPassword;

	@CacheLookup
	@FindBy(how = How.ID, using = ("log-in"))
	public WebElement btnLogin;


}
