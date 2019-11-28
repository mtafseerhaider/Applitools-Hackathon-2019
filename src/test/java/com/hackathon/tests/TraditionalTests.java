package com.hackathon.tests;

import com.hackathon.base.AutomationBase;
import com.hackathon.configs.HackathonApp;
import com.hackathon.constants.Globals;
import com.hackathon.pages.pages.DynamicContent;
import com.hackathon.pages.pages.LoginPage;
import com.hackathon.pages.pages.TableSort;
import com.hackathon.utils.DataProviders;
import com.hackathon.utils.SmartWait;
import com.hackathon.utils.Timer;
import com.hackathon.utils.TransactionTimer;
import org.apache.commons.lang3.time.StopWatch;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class TraditionalTests extends AutomationBase
{
	private WebDriver driver;
	// below variables are for non-data-driven tests
	private String strUsername = "Tafseer";
	private String strPassword = "1234";

	// 1. Login Page UI Elements Test

	@Test (priority = 1)
	public void verifyLoginPageUIElements () throws Exception
	{
		// Create Selenium WebDriver instance
		driver = getDriver ();
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		StopWatch stopwatch = new StopWatch ();
		SoftAssertions verification = new SoftAssertions ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		verification.assertThat (driver.getTitle ()).as ("Validation Point: FAILED - App is NOT loaded - see app URL").contains ("ACME demo app");
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Test 1 - Login Form text Label
		verification.assertThat (loginPage.getLoginFormText ()).as ("Validation Point: FAILED - Label is NOT as specified.").contains ("Login Form");
		// Test 2 - Username Label
		verification.assertThat (loginPage.getUsernameLabelText ()).as ("Validation Point: FAILED - Label is NOT as specified.").contains ("Username");
		// Test 3 - Password Label
		verification.assertThat (loginPage.getPasswordLabelText ()).as ("Validation Point: FAILED - Label is NOT as specified.").contains ("Password");
		// Test 4 - Sign in Label
		verification.assertThat (loginPage.getLoginButtonText ()).as ("Validation Point: FAILED - Label is NOT as specified.").contains ("Log In");
		// Test 5 - Remember Me checkbox Label
		verification.assertThat (loginPage.getRememberMeCheckboxLabelText ()).as ("Validation Point: FAILED - Label is NOT as specified.")
				.contains ("Remember Me");
		// Test 6 - Username field
		verification.assertThat (loginPage.isUsernameFieldExist ()).as ("Validation Point: FAILED - Username text field does NOT exist").isEqualTo (true);
		// Test 7 - Password field
		verification.assertThat (loginPage.isPasswordFieldExist ()).as ("Validation Point: FAILED - Password text field does NOT exist").isEqualTo (true);
		// Test 8 - Login button
		verification.assertThat (loginPage.isLoginButtonExist ()).as ("Validation Point: FAILED - Sign in button does NOT exist").isEqualTo (true);
		verification.assertAll ();
	}

	// 2. Data Driven Test
	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = Globals.DATAPROVIDER_EXCEL)
	public void dataDrivenLogin (Hashtable<String, String> data)
			throws Exception
	{
		// Create Selenium WebDriver instance
		driver = getDriver ();
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		StopWatch stopwatch = new StopWatch ();
		SoftAssertions verification = new SoftAssertions ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		verification.assertThat (driver.getTitle ()).as ("Validation Point: FAILED - App is NOT loaded - see app URL")
				    .contains ("ACME demo app");
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		loginPage.typeUsername (data.get (Globals.LOGIN_USERNAME));
		loginPage.typePassword (data.get (Globals.LOGIN_PASSWORD));
		loginPage.clickLogin ();
		verification.assertAll ();
	}

	// Table Sort Test
	@Test (priority = 3)
	public void verifyAmountColumnIsSorted () throws Exception
	{
		// Create Selenium WebDriver instance
		driver = getDriver ();
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		TableSort tableSort = new TableSort (driver);
		StopWatch stopwatch = new StopWatch ();
		SoftAssertions verification = new SoftAssertions ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, false);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		verification.assertThat (driver.getTitle ()).as ("Validation Point: FAILED - App is NOT loaded - see app URL").contains ("ACME demo app");
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		loginPage.typeUsername (strUsername);
		loginPage.typePassword (strPassword);
		loginPage.clickLogin ();

		// Table Sort Test
		tableSort.clickAmountHeader ();
		verification.assertThat (tableSort.isAmountColumnSortedSuccessfully ()).as ("Validation Point: FAILED - Amount column is NOT successfully sorted in ascending order")
				    .isEqualTo (true);
		verification.assertAll ();
	}

	// Table Sort Test
	@Test (priority = 4)
	public void verifyTransactionTableAfterSorting () throws Exception
	{
		System.out.println ("I cannot automate this scenario in traditional way using Selenium WebDriver");
		/*This test requires to place all the data of the transaction table in a Hashtable in the form of rows and columns
		and then verifying that the rows have not been affected after Amount column has been sorted in ascending order.
		Putting all the data in Hashtable using Selenium WebDriver with Java or any other language involves exhaustive implementation
		both logic wise and maintenance wise.
		and once done maintenance would be another saga.*/
	}

	// Canvas Chart Test
	@Test (priority = 6)
	public void compareExpensesChart ()
	{
		System.out.println ("I cannot automate this test in traditional way using Selenium WebDriver");
		/*The functional part of this test i.e. clicking on the Compare Expense link and then clicking on the Show data for next year are supported by Selenium WebDriver.
		However, the actual comparison part of this test cannot be automated using Selenium WebDriver.
		REASON: This test involves image comparison which is not supported by Selenium WebDriver by default.
		An image comparison library such as Ocular or AI powered SDK such as Applitools Eyes is required to automate such tests.*/
	}


	// Dynamic Content Test
	@Test (priority = 7)
	public void verifyFlashSaleAds () throws Exception
	{
		// Create Selenium WebDriver instance
		driver = getDriver ();
		driver.manage ().timeouts ().setScriptTimeout (30, TimeUnit.SECONDS);

		// Create objects for the page classes required to be used in this test
		HackathonApp hackathonApp = new HackathonApp (driver);
		LoginPage loginPage = new LoginPage (driver);
		DynamicContent dynamicContent = new DynamicContent (driver);
		StopWatch stopwatch = new StopWatch ();
		SoftAssertions verification = new SoftAssertions ();

		// Navigate to the application
		TransactionTimer.start (stopwatch);
		hackathonApp.navigateHackathonApp (strAppVersion, true);
		SmartWait.waitUntilPageIsLoaded (Timer.getLongWaitTime ());
		verification.assertThat (driver.getTitle ()).as ("Validation Point: FAILED - App is NOT loaded - see app URL").contains ("ACME demo app");
		TransactionTimer.stop (stopwatch, "Login Form Page", driver);

		// Log in
		loginPage.typeUsername (strUsername);
		loginPage.typePassword (strPassword);
		loginPage.clickLogin ();

		// Verify flash sale ads are displayed
		// Verify ad1
		verification.assertThat (dynamicContent.isFlashSaleAdDisplayed ()).as ("Validation Point: FAILED - Flash Sale ad is not displayed.")
				    .isEqualTo (true);
		// Verify ad2
		verification.assertThat (dynamicContent.isFlashSaleAd2Displayed ()).as ("Validation Point: FAILED - Flash Sale ad2 is not displayed.")
				    .isEqualTo (true);
		verification.assertAll ();
	}
}
