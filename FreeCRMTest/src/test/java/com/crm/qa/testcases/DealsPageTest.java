package com.crm.qa.testcases;


import org.testng.annotations.*;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.DealsContactsData;

public class DealsPageTest extends TestBase {
        
	HomePage homepage;
	LoginPage loginpage;
	DealsPage dealform;
	
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage(); //object of login page
		homepage= new HomePage();
		dealform = new DealsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@DataProvider
	public Object[][] DealsData()
	{
		Object data[][] = DealsContactsData.getDealsTestData("crm_deals_data"); //passing sheetName 		return data;
		return data;
	}
	
	
	@Test(dataProvider = "DealsData")
	public void DealsFormTest(String title, String company, String primary_contact) throws InterruptedException
	{
		homepage.dealslink();
		Thread.sleep(2000);
		//driver.switchTo().frame("mainpanel");
		//dealform.dealForm("CRM Automation", "Rajeev", "Google");
		
		dealform.dealForm(title, company, primary_contact);
		
		System.out.println("The data are in and test is passed");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

