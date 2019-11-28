package com.hackathon.utils;

import com.hackathon.base.AutomationBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;

/**
 * @author TAFSEER HAIDER
 */
public class JavaScriptUtility extends AutomationBase
{
	private static WebDriver driver;
	// constructor
	public JavaScriptUtility ()
	{
	}

	/**
	 * execute - generic method to execute a non-parameterized JS command
	 *
	 * @param command
	 */
	public static void execute (String command) throws MalformedURLException
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript (command);
	}

	/**
	 * execute - overloaded method to execute a JS command on WebElement
	 *
	 * @param command
	 * @param element
	 */
	public static void execute (String command, WebElement element) throws MalformedURLException
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript (command, element);
	}

	/**
	 * click - method to execute a JavaScript click event
	 *
	 * @param element
	 */
	public static void click (WebElement element) throws MalformedURLException
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("arguments[0].click();", element);
	}

	/**
	 * click - overloaded method to execute a JavaScript click event using By
	 *
	 * @param by
	 */
	public static void click (By by) throws MalformedURLException
	{
		driver = getDriver ();
		WebElement element = driver.findElement (by);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("arguments[0].click();", element);
	}

	/**
	 * sendKeys - method to execute a JavaScript value event
	 *
	 * @param keys
	 * @param element
	 */
	public static void sendKeys (String keys, WebElement element) throws MalformedURLException
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("arguments[0].value='" + keys + "';", element);
	}

	public static String getText (WebElement element) throws MalformedURLException
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String strText = (String) javascriptExecutor.executeScript ("return arguments[0].text;", element);
		return strText;
	}

	public static String retrieveInnerText (String CSS) throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String script = "return document.querySelector(" + "'" + CSS + "'" + ").innerText;";
		String text = javascriptExecutor.executeScript (script).toString ();
		return text;
	}

	public static void click (String CSS) throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		String script = "return document.querySelector(" + "'" + CSS + "'" + ").click;";
		javascriptExecutor.executeScript (script).toString ();
	}

	public static void scrollDown () throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("window.scrollBy(0,250)");
	}

	public static void scrollToBottom () throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollIntoView (WebElement element) throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
	}

	public static void scrollUp () throws Exception
	{
		driver = getDriver ();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript ("window.scrollBy(0,-250)");
	}

}
