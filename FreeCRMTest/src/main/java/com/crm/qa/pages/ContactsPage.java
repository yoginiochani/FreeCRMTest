package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	
	WebElement contact;
	WebElement clicks;
	WebElement totlinks;
	static int linkcount = 0;
		
	public void contactlink()
	{
	driver.switchTo().frame("mainpanel");
	contact = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'Contacts')]"));
	contact.click();
	}

	public void hooverOver() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		WebElement contact = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'Contacts')]"));
		System.out.println("contact is displayed");
		Assert.assertTrue(contact.isDisplayed());
		
		if(contact.isDisplayed())
		{
			System.out.println("The contact is displayed");
			Assert.assertTrue(contact.isDisplayed());
		}
		else
		{
		System.out.println("The contact link is not displayed");
		}
		Actions action = new Actions(driver);
		action.moveToElement(contact).perform(); //contact webElement is define above
		Thread.sleep(2000);
		WebElement fullSearchForm = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul/li[3]/a[contains(text(),'Full Search Form')]"));
		fullSearchForm.click();
		System.out.println("clicked on full search form link");
		
		}
	
	public void totalLinks()
	{
		List<WebElement> totlinks = driver.findElements(By.tagName("a"));
		int links = totlinks.size();
		System.out.println("Total links on contact page are:" + links);
		
		/*for (WebElement links: driver.findElements(By.tagName("a"))) {
			   System.out.println(links.getText());
			   linkcount++;
			  }
		System.out.println(linkcount);*/
	}
}