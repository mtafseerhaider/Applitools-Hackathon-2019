package com.hackathon.utils;

/**
 * @author TAFSEER HAIDER
 * Dated: 07/11/2019
 */
public class Timer
{
	public Timer ()
	{

	}

	// Standard wait timeout
	public static int getIntWaitTime ()
	{

		return 15;

	}

	// Short wait used for unexpected alerts
	public static int getShortWaitTime ()
	{

		return 5;

	}

	// Extra long wait timeout used in some searches
	public static int getLongWaitTime ()
	{

		return 60;

	}
}
