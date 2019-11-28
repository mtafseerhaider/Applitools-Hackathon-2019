package com.hackathon.pages.pages;

import com.hackathon.constants.Globals;
import com.hackathon.exceptions.ValidationFailed;
import com.hackathon.pages.objects.OR_LoginPage;
import com.hackathon.utils.JavaScriptUtility;
import com.hackathon.utils.Timer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.hackathon.utils.SmartWait.waitFor;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class LoginPage
{
	WebDriver    driver;
	OR_LoginPage orLoginPage = null;

	public LoginPage (WebDriver driver)
	{
		this.driver = driver;
		orLoginPage = PageFactory.initElements (driver, OR_LoginPage.class);
	}

	public String getLoginFormText () throws Exception
	{
		String CSS = "body > div > div > h4";
		String strLoginFormText = null;
		strLoginFormText = JavaScriptUtility.retrieveInnerText (CSS);

		return strLoginFormText;
	}

	public String getUsernameLabelText () throws Exception
	{
		String CSS = "form > div:nth-child(1) > label";
		String strUsernameLabelText = null;
		strUsernameLabelText = JavaScriptUtility.retrieveInnerText (CSS);

		return strUsernameLabelText;
	}

	public String getPasswordLabelText () throws Exception
	{
		String CSS = "form > div:nth-child(2) > label";
		String strPasswordLabelText = null;
		strPasswordLabelText = JavaScriptUtility.retrieveInnerText (CSS);

		return strPasswordLabelText;
	}

	public String getLoginButtonText () throws Exception
	{
		String CSS = "#log-in";
		String strLoginLabelText = null;
		strLoginLabelText = JavaScriptUtility.retrieveInnerText (CSS);

		return strLoginLabelText;
	}

	public String getRememberMeCheckboxLabelText () throws Exception
	{
		String CSS = "div.form-check-inline > label";
		String strRememberMeLabelText = null;
		strRememberMeLabelText = JavaScriptUtility.retrieveInnerText (CSS);

		return strRememberMeLabelText;
	}

	public boolean isUsernameFieldExist ()
	{
		waitFor (orLoginPage.txtUsername, Timer.getIntWaitTime ());
		if (!orLoginPage.txtUsername.isDisplayed ())
		{
			return false;
		}

		return true;
	}

	public boolean isPasswordFieldExist ()
	{
		waitFor (orLoginPage.txtPassword, Timer.getIntWaitTime ());
		if (!orLoginPage.txtPassword.isDisplayed ())
		{
			return false;
		}

		return true;
	}

	public boolean isLoginButtonExist ()
	{
		waitFor (orLoginPage.btnLogin, Timer.getIntWaitTime ());
		if (!orLoginPage.btnLogin.isDisplayed ())
		{
			return false;
		}

		return true;
	}

	public void typeUsername (String strUsername) throws Exception
	{
		waitFor (orLoginPage.txtUsername, Timer.getIntWaitTime ());
		orLoginPage.txtUsername.clear ();
		switch (strUsername)
		{
			case "SKIP":
				if (Globals.APPLITOOLS_DISABLE_EYES == true)
				{
					clickLogin ();
					if (verifyErrorMessage (orLoginPage.txtPassword) == true)
					{
						System.out.println ("VALIDATION POINT: PASSED");
					}
					else
						throw new ValidationFailed ();
					break;
				}
				else
					orLoginPage.txtUsername.sendKeys ("");
				break;
			default:
				orLoginPage.txtUsername.sendKeys (strUsername);
		}
	}

	public void typePassword (String strPassword) throws Exception
	{
		waitFor (orLoginPage.txtPassword, Timer.getIntWaitTime ());
		orLoginPage.txtPassword.clear ();
		switch (strPassword)
		{
			case "SKIP":
				if (Globals.APPLITOOLS_DISABLE_EYES == true)
				{
					clickLogin ();
					if (verifyErrorMessage (orLoginPage.txtPassword) == true)
					{
						System.out.println ("VALIDATION POINT: PASSED");
					}
					else
						throw new ValidationFailed ();
					break;
				}
				else
					orLoginPage.txtPassword.sendKeys ("");
				break;
			default:
				orLoginPage.txtPassword.sendKeys (strPassword);
		}
	}

	public void clickLogin ()
	{
		waitFor (orLoginPage.btnLogin, Timer.getIntWaitTime ());
		orLoginPage.btnLogin.click ();
	}

	public boolean verifyErrorMessage (WebElement webElement) throws Exception
	{
		if (orLoginPage.txtUsername.equals (webElement))
		{
			String strActualErrorMessageForMandatoryCheck = "Username must be present";
			String strCombinedErrorMessage = "Both Username and Password must be present";
			String strRevisedCombinedErrorMessage = "Please enter both username and password";
			String CSS = "div div:nth-child(4)";
			String strReceivedErrorMessage = JavaScriptUtility.retrieveInnerText (CSS);
			if (strReceivedErrorMessage.equalsIgnoreCase (strActualErrorMessageForMandatoryCheck) || strReceivedErrorMessage.equalsIgnoreCase (strCombinedErrorMessage) || strReceivedErrorMessage.equalsIgnoreCase (strRevisedCombinedErrorMessage))
			{
				return true;
			}
			else
				return false;
		}
		else if (orLoginPage.txtPassword.equals (webElement))
		{
			String strActualErrorMessageForMandatoryCheck = "Password must be present";
			String strCombinedErrorMessage = "Both Username and Password must be present";
			String strRevisedCombinedErrorMessage = "Please enter both username and password";
			String CSS = "div div:nth-child(4)";
			String strReceivedErrorMessage = JavaScriptUtility.retrieveInnerText (CSS);
			if (strReceivedErrorMessage.equalsIgnoreCase (strActualErrorMessageForMandatoryCheck) || strReceivedErrorMessage.equalsIgnoreCase (strCombinedErrorMessage) || strReceivedErrorMessage.equalsIgnoreCase (strRevisedCombinedErrorMessage))
			{
				return true;
			}
			else
				return false;
		}
		else
			System.out.println ("A valid WebElement is required to do data validation.");

		return true;
	}
}
