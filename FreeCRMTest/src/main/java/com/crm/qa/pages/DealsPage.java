package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	//@CacheLookup   you can use this if you want to fatch element from saved cache memory instead of going to browse again and again.
	//This will improve the script performance. use it only if you think that element is not going to change. if the DOM element is refreshed or changed, then this 
	//will not work and throw you "stale element exception."
	
	WebElement title, Company, Pcontact, Damount, prob, commission,description,product;
	
	public void dealForm(String titleName, String companyName, String primaryContact) throws InterruptedException//, String companyName, String primaryContact)
	{
		System.out.println("I am in dealForm method");
		Thread.sleep(3000);
		title = driver.findElement(By.xpath("//*[@id='title']"));
		Company= driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/input[3][@name=\"client_lookup\"]"));
		Pcontact = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]/input[3][@name=\"contact_lookup\"]"));
	    Damount = driver.findElement(By.xpath("//*[@id=\"amount\"]"));
	    prob = driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[@name = 'probability']"));
	    commission = driver.findElement(By.xpath("//tbody/tr[7]/td[2]/input[@name = 'commission']"));
	    description = driver.findElement(By.xpath("//tbody/tr/td[1]/textarea[@name = \"description\"]"));
	    
	    product = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/select[@name = \"product_id\"]"));
		Assert.assertTrue(title.isDisplayed());
		if(title.isDisplayed())
		{
			System.out.println("The title is displayed");
		}
		else
		{
			System.out.println("The title is not displayed");
		}
		
		title.sendKeys(titleName);
		Company.sendKeys(companyName);
		Pcontact.sendKeys(primaryContact);
		//Damount.sendKeys(amount);
		//prob.sendKeys(proba);
		//commission.sendKeys(comm);
		
		description.sendKeys("\r\n" + 
				"TestNG is a testing framework for the Java programming"+
					" language created by Cédric Beust and inspired "+
				"by JUnit and NUnit. The design goal of TestNG is to"+ 
					" cover a wider range of test categories: unit, functional,"+
				" end-to-end, integration, etc., with more powerful and easy-to-use functionalities.");
		product.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/select/option[9][contains(text(),'pants')]")).click();  //clicks on pants options in drop down
		
		driver.findElement(By.xpath("//tbody/tr[1]/td/input[1][@type = \"submit\"]")).click(); //this line clicks on save button
	}

}
