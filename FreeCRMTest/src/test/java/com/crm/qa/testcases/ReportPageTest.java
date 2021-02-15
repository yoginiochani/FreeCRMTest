package com.crm.qa.testcases;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ReportsPage;
import com.crm.qa.utilities.TestUtil;

public class ReportPageTest extends TestBase{
	
	
	LoginPage loginpage;   //login page object is creates so I can access login credential and login to application. 
	HomePage homepage;
	ReportsPage reportpage = new ReportsPage();
	//TestUtil tstutl = new TestUtil();
	
	public ReportPageTest()
	{
		super();    //TestBase constructor is called to configure property file.
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
	
		loginpage = new LoginPage(); //object of login page
		homepage= new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void reportlink() throws InterruptedException
	{
		
		reportpage.ReportLink();
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("closed the browser");
		driver.quit();
		
	}
	
	
}
