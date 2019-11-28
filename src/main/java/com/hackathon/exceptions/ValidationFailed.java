package com.hackathon.exceptions;

/**
 * @author TAFSEER HAIDER
 * Dated: 24/11/2019
 */
public class ValidationFailed extends Exception
{
	public ValidationFailed ()
	{
		super ("VALIDATION POINT: FAILED");
	}
}
