package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomePageTest extends TestBase{


	HomePage homepage;
	LoginPage loginpage;
	
	
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage(); //object of login page
		 //object of Homepage is created so you can access methods of HomePage class
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority = 1)
	public void validateHomePageTitleTest() throws InterruptedException
	{

		String ActualTitle = homepage.validateHomePageTitle1(); //goes to method and gets the homepage title and returns it.
		System.out.println(ActualTitle);
		Thread.sleep(2000);
		String Expected = "CRMPRO";
		System.out.println(Expected);	
		Assert.assertEquals(ActualTitle, Expected, "The title does not match"); // if the title does not match, then it will fail and message will display.
	}
	
	
	@Test(priority =2)
	public void totalLinksOnHomePage()
	{
		int total = homepage.allLinksOnHomePage();
		System.out.println("Total links on home page are: " + total);

	}
	
	
	@Test(priority = 3)
	public void validateUserTest() throws InterruptedException
	{
		
		boolean flag = homepage.verifycorrectusername();
		Assert.assertTrue(flag,"The User Name is not present");
	}
		
	
	@Test(priority = 4)
	public void validateContactLinkTest() throws InterruptedException
	{
		 homepage.validateContactLink();
		 
	}
	
	
	@Test(priority = 5)
	public void validateDealLinkTest()
	{
		homepage.dealslink(); //clicks on "new deal" link in deals
		
	}
	
	@Test(priority = 6)
	public void addBoxesLinkTest()
	{
		homepage.addBoxesLink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

