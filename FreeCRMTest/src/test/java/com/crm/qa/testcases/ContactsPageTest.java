package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;



public class ContactsPageTest extends TestBase {
	
	
	LoginPage loginpage;
	ContactsPage contactspage;
	HomePage homepage;
	
	public ContactsPageTest() 
	{
		super(); //superclass (TestBase) construtor is called
	}
	
	
	@BeforeMethod   //this beforemethod will execute before every individual test.
	public void setUp() throws InterruptedException
	{
		
		initialization();
		loginpage = new LoginPage(); //object of login page
		//testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage= new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority = 1)
	public void contactLinkTest()
	{
		contactspage.contactlink();
		System.out.println("First test is passed");
	}
	
	@Test(priority = 3)
	public void hooverOverContact() throws InterruptedException
	{
		 contactspage.hooverOver();
		System.out.println("Third test is passed");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void tlinks()
	{
		contactspage.contactlink();
		contactspage.totalLinks();
		System.out.println("Second test is passed");
	}
	
	@AfterMethod    //this aftermethod will be execueted after each test. 
	
	public void teardown()
	{
		System.out.println("closed the browser");
		driver.quit();
		
	}
	
	
	
}


