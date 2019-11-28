package com.hackathon.listeners;

import com.hackathon.utils.ModeUtil;
import org.testng.*;

/**
 * @author TAFSEER HAIDER
 * Dated: 09/11/2019
 */
public class TestListener extends TestListenerAdapter implements ITestListener, ISuiteListener
{
	@Override public void onTestStart (ITestResult result)
	{

	}

	@Override public void onTestSuccess (ITestResult result)
	{

	}

	@Override public void onTestFailure (ITestResult failingTest)
	{

	}

	@Override public void onTestSkipped (ITestResult result)
	{

	}

	@Override public void onTestFailedButWithinSuccessPercentage (ITestResult result)
	{

	}

	@Override public void onStart (ITestContext context)
	{
		System.out.println ("Test tag name: " + context.getName ());
		ITestNGMethod methods[] = context.getAllTestMethods ();
		System.out.println ("Following methods will be executed in this test tag:");
		for (ITestNGMethod method : methods)
		{
			System.out.println (method.getMethodName ());
		}
	}

	@Override public void onFinish (ITestContext context)
	{

	}

	@Override public void onStart (ISuite suite)
	{
		if (!ModeUtil.isSuiteRunnable (suite.getName ()))
		{
			System.out.println ("Skipping: " + suite.getName ());
			throw new SkipException ("Skipping the test case " + suite.getName () + " as part of run mode configuration.");
		}
		else
			System.out.println ("Executing: " + suite.getName ());
	}

	@Override public void onFinish (ISuite suite)
	{

	}
}
