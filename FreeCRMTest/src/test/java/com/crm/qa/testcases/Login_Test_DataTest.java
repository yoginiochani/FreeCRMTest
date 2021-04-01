package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Login_TestDataPage;
import com.crm.qa.utilities.DealsContactsData;
import com.crm.qa.utilities.LoginTestData;

public class Login_Test_DataTest extends TestBase {

	Login_TestDataPage testdata = new Login_TestDataPage();

	public Login_Test_DataTest()
	{
		super();
	}

	@BeforeMethod

	public void setup()
	{
		initialization();
	}

	
	@DataProvider
	public Object[][] logintestData()
	{
		Object data[][] = LoginTestData.getloginTestData("logintestdata"); //reading login negative test data from excel sheet.
		return data;
	}
	@Test(dataProvider = "logintestData")
	public void testdata(String username, String password) throws InterruptedException
	{
		System.out.println("I am in testdata method");
		testdata.testData(username, password);

	}

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}


