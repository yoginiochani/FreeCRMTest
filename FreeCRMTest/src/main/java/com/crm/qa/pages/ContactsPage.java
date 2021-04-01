package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{

	WebElement contact;
	WebElement clicks;
	WebElement totlinks;
	static int linkcount = 0;
	WebElement combinedForm;
	WebElement newContact, companies;


	public void contactlink()
	{
		try {
			System.out.println("I am in contactlink method");
			driver.switchTo().frame("mainpanel");
			contact = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'Contacts')]"));
			contact.click();
		}
		catch(Exception e)
		{
			System.out.println("coulnd not find contact link" + e);
		}
	}
	
	
	public boolean verifyContactLabel()
	{
		//driver.switchTo().frame("mainpanel");
		WebElement contactLabel = driver.findElement(By.xpath("//td[1][contains(text(),'Contact')]"));
		System.out.println("The label is preent in contact means I am on correct page: " +contactLabel);
		return contactLabel.isDisplayed();
	}

	public void hooverOver() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel"); //switching to contact frame

		WebElement contact =driver.findElement(By.xpath("//ul/li[4]/a[@href='https://classic.freecrm.com/system/index.cfm?action=contact']"));

		Thread.sleep(1000);
		Assert.assertTrue(contact.isDisplayed());
		
		Actions action = new Actions(driver);
		action.moveToElement(contact).perform(); //contact webElement is define above
		Thread.sleep(2000);

		//next three line is to click on fullSearchForm link from contact drop down
		WebElement fullSearchForm = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul/li[3]/a[contains(text(),'Full Search Form')]"));
		fullSearchForm.click();
		System.out.println("clicked on full search form link");

		//driver.switchTo().frame("mainpanel"); //switching back to contact frame
		driver.navigate().back();
		action.moveToElement(contact).perform(); //contact webElement is define above
		Thread.sleep(1000);
		WebElement combinedForm = driver.findElement(By.xpath("//ul/li[4]/ul/li[2]/a[contains(text(),'Combined Form')]"));
		combinedForm.click();
		System.out.println("Clicked on Combined Form link");
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");//switching back to contact frame
		action.moveToElement(contact).perform(); //contact webElement is define above
		WebElement newContact = driver.findElement(By.xpath("//ul/li[4]/ul/li[1]/a[contains(text(),'New Contact')]"));
        newContact.click();
		System.out.println("Clicked on New Contact link");

	}

	private void full_Search_Form_link()
	{
		// TODO Auto-generated method stub

	}

	public void totalLinks()
	{
		List<WebElement> totlinks = driver.findElements(By.tagName("a")); //finding total links on contact page
		int links = totlinks.size();  
		System.out.println("Total links on contact page are:" + links);
		int r = 0;

		for (WebElement link: driver.findElements(By.tagName("a")))
		{
			System.out.println(link.getText());
			if(link.getText().contains("Besant")) //trying to see how many links contains the word "Besant"
			{
				r = r+1;
			}

			linkcount++;
		}
		System.out.println("The total link contains with the word 'Besant' are " + r ); //printing out total link
		System.out.println(linkcount);
	}
	//below method gets all the optins from contact link and prints them out.
	public void AllOptions() throws InterruptedException 
	{
		driver.switchTo().frame("mainpanel"); //switching to frame

		WebElement contact =driver.findElement(By.xpath("//ul/li[4]/a[@href='https://classic.freecrm.com/system/index.cfm?action=contact']"));
		Actions action = new Actions(driver);
		action.moveToElement(contact).perform(); //contact webElement is define above
		Thread.sleep(2000);
		
	      List <WebElement> options = driver.findElements(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/ul/li")); //this line will get the all the options under contact link
	      int size = options.size();
	      for(int i =0; i<size ; i++){ //for loop prints out all the options
	         String optionName = options.get(i).getText();
	         System.out.println(optionName);
	      
	      }

	}
}
