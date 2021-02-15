package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CompanyPage extends TestBase 
{
	
	WebElement Companylink, clientLookUp, clientLookUpButton, hoovertocompany;
	WebElement cmpnyname, industryy, ann_Revenue, employeess, logout;
	
	public String companylink() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		//driver.switchTo().frame("leftpanel");
		Companylink = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[3]/a"));
		Companylink.click();
		Thread.sleep(2000);
		
		
		String title = driver.getTitle();
		return title;
		
	}
	
	public void clientLookUp() throws InterruptedException
	{
		clientLookUp = driver.findElement(By.xpath("//table/tbody/tr[7]/td[2]/input[3]"));
		clientLookUp.sendKeys("Amazon");
		Thread.sleep(2000);
		clientLookUpButton = driver.findElement(By.xpath("//table/tbody/tr[7]/td[2]/input[4]"));
		clientLookUpButton.click();
		System.out.println("Entered name and clicked on button");
		
		
		Set<String> windows = driver.getWindowHandles();  //printing the address of the all the open window. in this case, two windows open up.
		for(String i :windows)
			System.out.println(i);
		
		Thread.sleep(2000);
		
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().window(mainWindow);
	}
	
	public void newCompanyhoover() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		hoovertocompany  = driver.findElement(By.xpath("//ul/li[3]/a[text()= 'Companies']"));
		Actions action = new Actions(driver);
		action.moveToElement(hoovertocompany).perform(); //contact webElement is define above
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[3]/ul/li[1]/a[text()='New Company']")).click();
		System.out.println("clicked on new company link");
		
	}
	
	public void companydata(String compnyname, String industry, CharSequence[] annualRevenue) throws InterruptedException
	{
		cmpnyname = driver.findElement(By.id("company_name"));
		cmpnyname.sendKeys(compnyname);
		Thread.sleep(1000);
		industryy = driver.findElement(By.name("industry"));
		industryy.sendKeys(industry);
		Thread.sleep(1000);
		//int annual_rev = annRevenue;
		//driver.findElement(By.cssSelector("input[name = 'annual_revenue']")).sendKeys(""+annRevenue);
		driver.findElement(By.name("annual_revenue")).sendKeys(annualRevenue);
		
		driver.findElement(By.name("status")).click();
		driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]/select/option[5]")).click();
		System.out.println("The 'New' option is clicked");
		
		Select category = new Select(driver.findElement(By.name("category")));
		category.selectByVisibleText("Client");
		Thread.sleep(2000);
		System.out.println("The category is selected");
		
		
	}
	public void logout()
	{
		logout = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a"));
	if(logout.isDisplayed())
	{
		System.out.println("logout link is displayed");
		logout.click();
	}
	else
	{
		System.out.println("logout link is not diplayed");
	}
	}

}
