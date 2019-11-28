package com.hackathon.configs;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;
import static com.hackathon.configs.DriverOptions.getChromeOptions;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class AutomationFactory
{
	protected static WebDriver webDriver;
	private          Eyes                 eyes;
	private final    String               operatingSystem     = System.getProperty ("os.name").toUpperCase ();
	private final    String               systemArchitecture  = System.getProperty ("os.arch");
	private final    boolean              headlessMode        = Boolean.getBoolean ("headless");
	private          BatchInfo batchInfo = new BatchInfo (System.getProperty ("batchInfo"));
	private final    String               eyesAPIKey          = System.getProperty ("eyesAPIKey");

	public WebDriver instantiateDriver ()
	{
		if (null == webDriver)
		{
			System.out.println (" ");
			System.out.println ("Current Operating System: " + operatingSystem);
			System.out.println ("Current Architecture: " + systemArchitecture);
			System.out.println ("Headless Mode: " + headlessMode);
			System.out.println (" ");
			webDriver = new ChromeDriver (getChromeOptions ());
		}

		return webDriver;
	}

	public Eyes instantiateEyesFor (boolean blnDisableEyes, String strAppName, String strCurrentTestName)
	{
		if (eyes == null && !blnDisableEyes)
		{
			System.out.println ("Getting Eyes for " + strAppName);
			eyes = new Eyes ();
			eyes.setIsDisabled (blnDisableEyes);
			eyes.setApiKey (eyesAPIKey);
			eyes.setBatch (batchInfo);
			eyes.setForceFullPageScreenshot (true);
			eyes.open (instantiateDriver (), strAppName, strCurrentTestName);
		}

		return eyes;
	}

	public void closeEyes ()
	{
		try
		{
			eyes.closeAsync ();
		}
		finally
		{
			eyes.abortIfNotClosed ();
		}
		eyes = null;

	}

	public void quitDriver ()
	{
		if (null != webDriver)
		{
			webDriver.quit ();
			webDriver = null;
		}
	}
}
