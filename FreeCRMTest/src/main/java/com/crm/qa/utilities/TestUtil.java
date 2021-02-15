package com.crm.qa.utilities;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_Load_TimeOut = 20;
	public static long IMPLICIT_WAIT = 20;	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("leftpanel");
	}
}
