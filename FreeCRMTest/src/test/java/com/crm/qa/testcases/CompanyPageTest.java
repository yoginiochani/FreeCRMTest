package com.crm.qa.testcases;

import org.junit.After;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompanyPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.DealsContactsData;
import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.newCompanyData;

public class CompanyPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	CompanyPage cmpnypage;
	
	
	
	public CompanyPageTest()
	{
		super();
	}
	
	
	@BeforeMethod   //this beforemethod will execute before every individual test.
	public void setUp() throws InterruptedException
	{
		
		initialization();
		loginpage = new LoginPage(); //object of login page
		homepage= new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		cmpnypage = new CompanyPage();
		
	}
	
	@Test(priority = 1)
	public void CompanyLink() throws InterruptedException
	{
		
		String ttle = cmpnypage.companylink();
		System.out.println("The company link is clicked");
		System.out.println("The title is " + ttle);
		cmpnypage.clientLookUp();
		System.out.println("First Test is passed");
		
	}
	
	@Test (priority = 2)
	public void newCompanylink() throws InterruptedException
	{
		
		cmpnypage.newCompanyhoover();
		System.out.println("Second test is passed");
		
	}
	
	@DataProvider
	public Object[][] CompnyData()
	{
		Object data[][] = newCompanyData.getnewCompanyData("new_company_data"); //passing sheetName which is "Login" in excel
		return data;
	}
	
	@Test(priority = 3, dataProvider = "CompnyData")
	public void newCompnyFormData(String companyName, String industry, CharSequence[] annualRevenue) throws InterruptedException
	{
		cmpnypage.newCompanyhoover();
		Thread.sleep(2000);
		cmpnypage.companydata(companyName, industry, annualRevenue);
		System.out.println("Entered two data, Company name and industry");
		System.out.println("Third test is passed");
		
	
		cmpnypage.logout();
		System.out.println("I looged out from application");
	}
	
	@AfterMethod     //if you say @AfterTest, then it will execute all the test at once and teardown method last only once. 
	public void teardown()
	{
		driver.quit();
	}

}
