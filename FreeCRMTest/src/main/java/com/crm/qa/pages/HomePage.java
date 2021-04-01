package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	WebElement contact;
	WebElement user;
	WebElement home;
	WebElement search;
	WebElement deals;
	WebElement all_links;
	WebElement addBoxes;
		
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle1()
	{
		String ActualTitle = driver.getTitle();
		return ActualTitle;
	}
	
	
	public boolean verifycorrectusername() throws InterruptedException //validate if the user name is present or not
	{
		//System.out.println("The logo is " +crmImage.isDisplayed());
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		user = driver.findElement(By.xpath("//td[1][contains(text(),\"User: group automation\")]"));
		System.out.println(user.getText());
		return user.isDisplayed(); //it will return true or false.
	}
	
	public int allLinksOnHomePage()
	{
		List<WebElement> all_links = driver.findElements(By.tagName("a"));
		int tlinks = all_links.size();
		return tlinks;
		
	}
	public ContactsPage validateContactLink() throws InterruptedException
	{
		driver.switchTo().frame("mainpanel");
		contact = driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"));
		contact.click();
		
		home = driver.findElement(By.xpath("//ul/li[1]/a[contains(text(),'Home')]")); //clicking back on home link
		home.click();
		System.out.println("I clicked on home link in contact");
		Thread.sleep(2000);
		search = driver.findElement(By.xpath("//div/div[@id=\"quickSearchPanel\"]/select[@name = 'quick_search_selector']"));
		search.click(); //clicked on search option in home link
		Thread.sleep(2000);
		return new ContactsPage();
		
	}
	
	public DealsPage dealslink()
	{
		driver.switchTo().frame("mainpanel");
		
		deals = driver.findElement(By.xpath("//ul/li[5]/a[contains(text(),'Deals')]"));
		Actions action = new Actions(driver);
		action.moveToElement(deals).perform(); //contact webElement is define above
		driver.findElement(By.xpath("//ul/li[5]/ul/li[1]/a[contains(text(),'New Deal')]")).click();
		return new DealsPage();
	}
	
	public addBoxes addBoxesLink()
	{
		driver.switchTo().frame("mainpanel");
		addBoxes = driver.findElement(By.xpath("//*[@id=\"navMenu\"]/ul/li[2]/a"));
		addBoxes.click();
		return new addBoxes();
	}
		
	}
