package com.hackathon.tests;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import com.hackathon.base.AutomationBase;
import com.hackathon.configs.HackathonApp;
import com.hackathon.constants.Globals;
import com.hackathon.pages.pages.CanvasChart;
import com.hackathon.pages.pages.LoginPage;
import com.hackathon.pages.pages.TableSort;
import com.hackathon.utils.DataProviders;
import com.hackathon.utils.SmartWait;
import com.hackathon.utils.Timer;
import com.hackathon.utils.TransactionTimer;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class VisualAITests extends AutomationBase
{
	private WebDriver driver;
	private Eyes openEyes;
	private String strCurrentTestName = null;
	private int iterator = 1;
	// below variables are for non-data-driven tests
	private String    strUsername = "Tafseer";
	private String    strPassword = "1234";

	// 1. Login Page UI Elements Test
	@Test(priority = 1)
	public void verifyLoginPageUIElements () throws Exception
	{
		strCurrentTestName = "Login Page UI Elements Test";
		// Create Selenium WebDriver instance
		driver = getDriver ();
		// Create Applitools Eyes instance
		openEyes = getEyesFor (Globals.APPLITOOLS_DISABLE_EYES, strAppName, strCurrentTestName);
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		StopWatch stopwatch = new StopWatch ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		openEyes.checkWindow ("Checkpoint 1: Verify application has successfully loaded.");
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

	}

	// 2. Data Driven Test
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = Globals.DATAPROVIDER_EXCEL)
	public void dataDrivenLogin (Hashtable<String, String> data)
			throws Exception
	{
		strCurrentTestName = "Data Driven Test " + iterator;
		// Create Selenium WebDriver instance
		driver = getDriver ();
		// Create Applitools Eyes instance
		openEyes = getEyesFor (Globals.APPLITOOLS_DISABLE_EYES, strAppName, strCurrentTestName);
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		StopWatch stopwatch = new StopWatch ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		loginPage.typeUsername (data.get (Globals.LOGIN_USERNAME));
		loginPage.typePassword (data.get (Globals.LOGIN_PASSWORD));
		loginPage.clickLogin ();
		openEyes.checkWindow ("Checkpoint 1: Verify that user has successfully logged in.");
		iterator = iterator + 1;

	}

	// Table Sort Test
	@Test (priority = 3)
	public void verifyTransactionsTable () throws Exception
	{
		strCurrentTestName = "Table Sort Test";
		// Create Selenium WebDriver instance
		driver = getDriver ();
		// Create Applitools Eyes instance
		openEyes = getEyesFor (Globals.APPLITOOLS_DISABLE_EYES, strAppName, strCurrentTestName);
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		TableSort tableSort = new TableSort (driver);
		StopWatch stopwatch = new StopWatch ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		TransactionTimer.start (stopwatch);
		loginPage.typeUsername (strUsername);
		loginPage.typePassword (strPassword);
		loginPage.clickLogin ();
		TransactionTimer.stop (stopwatch, "Home Page", driver);
		// Table Sort Test
		TransactionTimer.start (stopwatch);
		tableSort.clickAmountHeader ();
		openEyes.checkWindow ("Checkpoint 1: Verify that transaction table is sorted successfully after clicking Amount header.");
		TransactionTimer.stop (stopwatch, "Home Page State After Transaction Table Sorted", driver);
	}

	// Canvas Chart Test
	@Test (priority = 4)
	public void compareExpensesChart () throws Exception
	{
		strCurrentTestName = "Canvas Chart Test";
		// Create Selenium WebDriver instance
		driver = getDriver ();
		// Create Applitools Eyes instance
		openEyes = getEyesFor (Globals.APPLITOOLS_DISABLE_EYES, strAppName, strCurrentTestName);
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		CanvasChart canvasChart = new CanvasChart (driver);
		StopWatch stopwatch = new StopWatch ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		TransactionTimer.start (stopwatch);
		loginPage.typeUsername (strUsername);
		loginPage.typePassword (strPassword);
		loginPage.clickLogin ();
		TransactionTimer.stop (stopwatch, "Home Page", driver);

		// Canvas Chart Test
		TransactionTimer.start (stopwatch);
		canvasChart.clickCompareExpenses ();
		openEyes.checkWindow ("Checkpoint 1: Verify that bar chart comparing the expenses for the year 2017 and 2018 is displayed.");
		TransactionTimer.stop (stopwatch, "Canvas Chart Page", driver);

		TransactionTimer.start (stopwatch);
		canvasChart.clickShowDataForNextYear ();
		openEyes.checkWindow ("Checkpoint 2: Verify that data for the next year has been added successfully.");
		TransactionTimer.stop (stopwatch, "Canvas Chart Page For Next Year Data", driver);

	}

	// Dynamic Content Test
	@Test (priority = 5)
	public void verifyFlashSaleAds () throws Exception
	{
		strCurrentTestName = "Dynamic Content Test";
		// Create Selenium WebDriver instance
		driver = getDriver ();
		// Create Applitools Eyes instance
		openEyes = getEyesFor (Globals.APPLITOOLS_DISABLE_EYES, strAppName, strCurrentTestName);
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		StopWatch stopwatch = new StopWatch ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, true);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		TransactionTimer.start (stopwatch);
		loginPage.typeUsername (strUsername);
		loginPage.typePassword (strPassword);
		loginPage.clickLogin ();
		// Verify flash sale ads are displayed
		// Set Eyes Match level to LAYOUT for dynamic content
		openEyes.setMatchLevel (MatchLevel.LAYOUT);
		openEyes.checkWindow ("Checkpoint 1: Verify that user has successfully logged in and Flash Sale ads are displaying.");
		TransactionTimer.stop (stopwatch, "Home Page with Flash Sale Ads", driver);
	}
}
