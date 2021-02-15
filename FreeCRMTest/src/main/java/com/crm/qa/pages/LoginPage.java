package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  //TestBase class is parent class for all the pages created. Contact, Deals, Home, Login, Sign Up
{
//define object repository or page objects on login page. Just defined 5 webElements as of now. 
	
	@FindBy(name = "username")  //username element is defined
	WebElement username;   //webelement variable is define.
	
	@FindBy(name = "password")   //this line is as same as 
								//driver.findBy.name("password"
	WebElement password;
	
	@FindBy(xpath = "//*[@id='loginForm']/div/div/input[@value = 'Login']")
	WebElement loginButton;
	
	//signUp link
	@FindBy(xpath = "//ul/li[2]/a[contains(text(),'Sign Up')]")
	WebElement SignUpLink;
	
	
	public LoginPage()  //constructor of this class.
	{
		PageFactory.initElements(driver, this);  //initialize element
		              //driver is coming from base class. this is pointing to current class object.
		             //all these variables(crmLogo, signUplink, loginButton, passwrod, username) will be initialie with driver.
	}
	
	//Action to be perfromed on web element.
	
	
	
	public HomePage login(String un, String pswd) throws InterruptedException
	{
		username.sendKeys(un); 
		System.out.println("Entered username");
		password.sendKeys(pswd);
		System.out.println("Entered password");
		Thread.sleep(2000);
		loginButton.click();
		System.out.println("Clicked on login button");
		return new HomePage();
		
	}
	
	}


