package com.crm.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;





public class LoginPageTest extends TestBase {
	
	LoginPage loginpage; //object of LoginPage class is created at class level,so i can use it through out the programs
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	
//constructor of this class is created, so that
//you can call constructor of TestBase class. it's compulsory
//because you need to initialize the property
//Test case should be separated----independent of each other
//before each test case ---launch the browser and login
//@test --execute test
//After each test case----close the browser
			
	
	public LoginPageTest() 
	{
		super(); //superclass (TestBase) construtor is called
	}

	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		initialization();
		loginpage = new LoginPage(); //object of login page
		//testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage= new HomePage();
		//homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test (priority = 1)
	public void LoginPageTitleTest() throws InterruptedException
	{
		String ActualTitle = loginpage.ValidateLoginPageTitle(); //goes to method and gets the homepage title and returns it.
		System.out.println(ActualTitle);
		Thread.sleep(2000);
		String Expected = "CRMPRO  - CRM software for customer relationship management, sales, and support.";
		System.out.println(Expected);	
		Assert.assertEquals(ActualTitle, Expected, "The title does not match"); // if the title does not match, then it will fail and message will display.
	}
	
	@Test(priority = 2)
	public void validateCRMLogoTest()
	{
		boolean result = loginpage.ValidateCRMLogo();
		Assert.assertTrue(result); // test will pass if the result is true otherwise test will fail
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =4)
	public void verifyContactLinkTest()
	{
		boolean contactlinkdisplay = loginpage.contactLink();  //to check if the contact link is displayed on loginpage 
		boolean contactlinkenabled = loginpage.contactLinkenable(); //to check if the contact link is enabled or not.
		
		try {
			Assert.assertTrue(contactlinkdisplay, "Contact link is not displayed");
		}
		catch(Exception e)
		{
			System.out.println("The exception is " + e.getMessage());
		}
		try {
			Assert.assertTrue(contactlinkenabled, "Contact link is not enabled");
		}
		catch(Exception e)
		{
			System.out.println("The exception is " + e.getMessage());
		}
	}
	
	@Test(priority = 5)
	public void gettotallinksonloginpage()
	{
		loginpage.totallinksonloginpage();
	}
	
	@AfterMethod  //after every test, it will close the browser
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
}
