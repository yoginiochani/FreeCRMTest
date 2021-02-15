package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebElement contact;
	WebElement user;
	WebElement home;
	WebElement search;
	WebElement deals;
	WebElement all_links;
		
	
	
	public String validateHomePageTitle1()
	{
		String ActualTitle = driver.getTitle();
		return ActualTitle;
	}
	
	
	public boolean validateuser() throws InterruptedException
	{
		//System.out.println("The logo is " +crmImage.isDisplayed());
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		user = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]"));
		System.out.println(user.getText());
		return user.isDisplayed(); //it will return true or false.
		
		                              //it will return true if logo is there
		    
	}
	
	public int allLinks()
	{
		List<WebElement> all_links = driver.findElements(By.tagName("a"));
		int tlinks = all_links.size();
		return tlinks;
		
	}
	
	
	
	public ContactsPage validateContactLink() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		contact = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'Contacts')]"));
		contact.click();
		
		home = driver.findElement(By.xpath("//ul/li[1]/a[contains(text(),'Home')]")); //clicking back on home link
		home.click();
		System.out.println("I clicked on home link in contact");
		Thread.sleep(2000);
		search = driver.findElement(By.xpath("//div/div[@id=\"quickSearchPanel\"]/select[@name = 'quick_search_selector']"));
		search.click(); //clicked on search option in home link
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select/optgroup[2]/option[contains(text(),'india')]")).click();
		System.out.println("I clicked on India option in search link");
		return new ContactsPage();
		
	}
	
	public void dealslink()
	{
		driver.switchTo().frame("mainpanel");
		
		deals = driver.findElement(By.xpath("//ul/li[5]/a[contains(text(),'Deals')]"));
		Actions action = new Actions(driver);
		action.moveToElement(deals).perform(); //contact webElement is define above
		driver.findElement(By.xpath("//ul/li[5]/ul/li[1]/a[contains(text(),'New Deal')]")).click();
	}
		
	}
