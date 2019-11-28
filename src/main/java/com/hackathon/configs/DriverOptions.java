package com.hackathon.configs;

import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class DriverOptions
{
	public static ChromeOptions getChromeOptions ()
	{
		ChromeOptions options = new ChromeOptions ();
		options.addArguments ("--incognito");
		options.addArguments ("--start-maximized");
		options.addArguments ("--no-sandbox");
		options.addArguments ("--disable-gpu");
		options.addArguments ("--no-default-browser-check");
		options.setHeadless (HEADLESS);

		return options;
	}

	public final static boolean HEADLESS = Boolean.getBoolean ("headless");
}
