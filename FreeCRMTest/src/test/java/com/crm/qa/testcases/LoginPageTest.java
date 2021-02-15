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
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test (priority = 1)
	public void HomePageTitleTest() throws InterruptedException
	{
		String ActualTitle = homepage.validateHomePageTitle1();
		System.out.println(ActualTitle);
		Thread.sleep(2000);
		String Expected = "CRMPRO";
		System.out.println(Expected);	
		Assert.assertEquals(ActualTitle, Expected, "The title does not match");
	}
	
	@Test(priority = 2)
	public void totalLinksOnHomePage()
	{
		int total = homepage.allLinks();
		System.out.println("Total links on home page are: " + total);
		
	}
	
	@Test (priority = 3)
	public void validateuserTest() throws InterruptedException
	{
		boolean flag = homepage.validateuser();
		Assert.assertTrue(flag);
		}
	
	@Test(priority = 4)
	public void validateContactLinkTest() throws InterruptedException
	{
		contactspage = homepage.validateContactLink();
	}
	
	/*
	@Test(priority = 3)
	public void verifyContactLinkTest() throws InterruptedException
	{
		Thread.sleep(3000);
		contactspage = homepage.ContactLink();
		System.out.println("I clicked on contact link");
	}*/
		
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
}
