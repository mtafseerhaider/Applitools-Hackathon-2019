package com.hackathon.pages.pages;

import com.hackathon.pages.objects.OR_CanvasChart;
import com.hackathon.pages.objects.OR_TableSort;
import com.hackathon.utils.Timer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.hackathon.utils.SmartWait.waitFor;

/**
 * @author TAFSEER HAIDER
 * Dated: 26/11/2019
 */
public class CanvasChart
{
	WebDriver      driver;
	OR_CanvasChart orCanvasChart = null;

	public CanvasChart (WebDriver driver)
	{
		this.driver = driver;
		orCanvasChart = PageFactory.initElements (driver, OR_CanvasChart.class);
	}

	public void clickCompareExpenses ()
	{
		waitFor (orCanvasChart.lnkCompareExpenses, Timer.getIntWaitTime ());
		orCanvasChart.lnkCompareExpenses.click ();
	}

	public void clickShowDataForNextYear ()
	{
		waitFor (orCanvasChart.btnShowDataForNextYear, Timer.getIntWaitTime ());
		orCanvasChart.btnShowDataForNextYear.click ();
	}
}
