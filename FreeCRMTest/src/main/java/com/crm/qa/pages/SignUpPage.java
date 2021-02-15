package com.crm.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{

	WebElement link, pricinglink, featurelink;
	
	
	
	public boolean verifySignUpLink() throws InterruptedException
	{
		Thread.sleep(2000);
		link = driver.findElement(By.xpath("//ul/li[2]/a[contains(text(),'Sign Up')]"));
		link.click();
		return link.isEnabled();
		
		
	}
	
	public int totalinksonSignUpPage()
	{
		List<WebElement> totlinksonSignupPage = driver.findElements(By.tagName("a"));
		int total = totlinksonSignupPage.size();
		return total;
		
	}
	
	public boolean verifyPricingLink() throws InterruptedException
	{
		Thread.sleep(2000);
		String mainWindow = driver.getWindowHandle();     //getting window handle for main window and store it in string variable.
		pricinglink = driver.findElement(By.xpath("//ul/li[3]/a[contains(text(),'Pricing')]"));  //get pricing element
		pricinglink.click();                              //clicks on price links. 
		
		
		
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);        //go to main window
		
		featurelink = driver.findElement(By.xpath("//ul/li[4]/a[contains(text(),'Features')]"));
		featurelink.click();
		System.out.println("The feature link is clicked");
		
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);
		
		return pricinglink.isEnabled();
	}
	
}
