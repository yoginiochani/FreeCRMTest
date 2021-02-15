package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{

	
	TestBase init = new TestBase();
	SignUpPage signup = new SignUpPage();
	
	public SignUpPageTest()
	{
		super();
		
		
	}
	@BeforeMethod
	public void setUp()
	{
		TestBase.initialization();
		System.out.println("browser is started");
	}

	@Test(priority = 0)
	public void SignUpLinkTest() throws InterruptedException
	{
	  signup.verifySignUpLink();	
	 System.out.println("The signUp link is clicked");
	}
	
	@Test(priority = 1)
	public void totallinks() throws InterruptedException
	{
		signup.verifySignUpLink();
		int tt = signup.totalinksonSignUpPage();
		System.out.println("Total links on signup page are: " + tt);
		
	}
	
	@Test(priority = 2)
	public void pricingLinkTest() throws InterruptedException
	{
		signup.verifyPricingLink();
		System.out.println("The pricing link is clicked");
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
