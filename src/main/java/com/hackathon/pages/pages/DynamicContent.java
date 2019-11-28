package com.hackathon.pages.pages;

import com.hackathon.pages.objects.OR_DynamicContent;
import com.hackathon.utils.Timer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.hackathon.utils.SmartWait.waitFor;

/**
 * @author TAFSEER HAIDER
 * Dated: 26/11/2019
 */
public class DynamicContent
{
	WebDriver         driver;
	OR_DynamicContent orDynamicContent = null;

	public DynamicContent (WebDriver driver)
	{
		this.driver = driver;
		orDynamicContent = PageFactory.initElements (driver, OR_DynamicContent.class);
	}

	public boolean isFlashSaleAdDisplayed ()
	{
		waitFor (orDynamicContent.imgFlashSale, Timer.getIntWaitTime ());
		if (orDynamicContent.imgFlashSale.isDisplayed () != true)
		{
			return false;
		}

		return true;
	}

	public boolean isFlashSaleAd2Displayed ()
	{
		waitFor (orDynamicContent.imgFlashSale2, Timer.getIntWaitTime ());
		if (orDynamicContent.imgFlashSale2.isDisplayed () != true)
		{
			return false;
		}

		return true;
	}
}
