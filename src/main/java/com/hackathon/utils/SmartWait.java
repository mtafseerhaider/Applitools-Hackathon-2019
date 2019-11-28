package com.hackathon.utils;

import com.hackathon.base.AutomationBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.function.Function;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class SmartWait extends AutomationBase
{
	public static void waitUntilPageIsLoaded (int timer)
	{
		try
		{
			WebDriver driver = getDriver ();
			WebDriverWait wait = new WebDriverWait (driver, timer);
			wait.until (AdditionalConditions.isPageReady ());

		}
		catch (StaleElementReferenceException | TimeoutException | NoSuchElementException | MalformedURLException e)
		{
			e.printStackTrace ();
		}
	}

	public static void waitFor (WebElement webElement, int timer)
	{
		try
		{
			WebDriver driver = getDriver ();
			Wait<WebDriver> wait = new FluentWait<WebDriver> (driver).withTimeout (Duration.ofSeconds (timer)).pollingEvery (Duration.ofSeconds (2))
					.withMessage ("TimeoutException is thrown");
			wait.until ((ExpectedConditions.refreshed (ExpectedConditions.visibilityOf (webElement))));
			wait.until (SmartWait.elementLoaded (webElement));
		}
		catch (StaleElementReferenceException | TimeoutException | NoSuchElementException | MalformedURLException e)
		{
			e.printStackTrace ();
		}
	}

	public static Function<WebDriver, Boolean> elementLoaded (WebElement webElement)
	{
		return driver -> {
			WebElement element = webElement;
			return element != null && element.isDisplayed ();
		};
	}

	public static void waitUntilGone (WebElement webElement, int timer)
	{
		try
		{
			WebDriver driver = getDriver ();
			// wait for the dynamic element to disappear
			WebDriverWait exists = new WebDriverWait (driver, timer);
			exists.until (ExpectedConditions.refreshed (ExpectedConditions.invisibilityOf (webElement)));
		}
		catch (StaleElementReferenceException | TimeoutException | NoSuchElementException | MalformedURLException e)
		{
			e.printStackTrace ();
		}

	}

	public static WebDriverWait shortWait (int timer) throws Exception
	{
		WebDriver driver = getDriver ();
		return new WebDriverWait (driver, timer);
	}

	public static void actionDelay (int timer)
	{
		try
		{
			Thread.sleep (timer);
		}
		catch (Exception ign)
		{
		}
	}
}
