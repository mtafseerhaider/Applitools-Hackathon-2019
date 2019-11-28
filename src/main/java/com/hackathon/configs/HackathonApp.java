package com.hackathon.configs;

import com.hackathon.base.AutomationBase;
import org.openqa.selenium.WebDriver;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class HackathonApp extends AutomationBase
{
	private WebDriver driver;

	public HackathonApp (WebDriver driver)
	{
		this.driver = driver;
	}

	public void navigateHackathonApp (String strAppVersion, boolean blnShowAd)
	{
		String strAppUrl;
		if (strAppVersion.equalsIgnoreCase ("V1") && blnShowAd != true)
		{
			strAppUrl = "https://demo.applitools.com/hackathon.html";
			System.out.println ("This automated test script will be executed on Hackathon App V1 with URL: " + strAppUrl);
			driver.get (strAppUrl);
		}
		else if (strAppVersion.equalsIgnoreCase ("V1") && blnShowAd == true)
		{
			strAppUrl = "https://demo.applitools.com/hackathon.html?showAd=true";
			System.out.println ("This automated test script will be executed on Hackathon App V1 loaded with ads with URL: " + strAppUrl);
			driver.get (strAppUrl);
		}
		else if (strAppVersion.equalsIgnoreCase ("V2") && blnShowAd != true)
		{
			strAppUrl = "https://demo.applitools.com/hackathonV2.html";
			System.out.println ("This automated test script will be executed on Hackathon App V2 with URL: " + strAppUrl);
			driver.get (strAppUrl);
		}
		else if (strAppVersion.equalsIgnoreCase ("V2") && blnShowAd == true)
		{
			strAppUrl = "https://demo.applitools.com/hackathonV2.html?showAd=true";
			System.out.println ("This automated test script will be executed on Hackathon App V2 loaded with ads with URL: " + strAppUrl);
			driver.get (strAppUrl);
		}

	}

}
