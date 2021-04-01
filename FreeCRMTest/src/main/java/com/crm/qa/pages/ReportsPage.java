package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class ReportsPage extends TestBase{


	WebElement Report;

	public void ReportLink()
	{
		System.out.println("I am in ReportLink method to click on report link");
		driver.switchTo().frame("mainpanel");
		Report = driver.findElement(By.xpath("//ul/li[15]/a[contains(text(),'Reports')]"));
		if(Report.isDisplayed())
		{
			System.out.println("The link is present");
			Report.click();
		}
		else
		{
			System.out.println("The link is not present");
		}
		
		WebElement rtitle = driver.findElement(By.xpath("//table/tbody/tr/td/fieldset/legend"));	
		if(rtitle.isDisplayed())
		{
		 System.out.println("I am in Report page " + rtitle.getText());  
		 
		}
		else
		{
			System.out.println("I am not in report page");
		}
	}
	
	

}




