package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

import reactor.core.Exceptions;

public class Login_TestDataPage extends TestBase {


	WebElement u_name, p_word, l_button;


	public void testData(String uname, String pword) throws InterruptedException
	{

		u_name = driver.findElement(By.name("username"));
		u_name.sendKeys(uname);

		p_word = driver.findElement(By.name("password"));
		p_word.sendKeys("password");

		l_button = driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input[@value = 'Login']"));

		Thread.sleep(1000);
		l_button.click();
		
		String Expected_title = "CRMPRO";  //after you login, you should have this tile
		String actual_title = driver.getTitle();  //actual title on login page,
		
		Assert.assertNotEquals(actual_title, Expected_title, "The login credential are invalid and still logged in"); //checking to see if the title are not same.
		//if title are same, then invalid login credentials are working.
	}

}




