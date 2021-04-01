package com.crm.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class LoginPage extends TestBase  //TestBase class is parent class for all the pages created. Contact, Deals, Home, Login, Sign Up
{
//define object repository or page objects on login page. Just defined 5 webElements as of now. 
	
	@FindBy(name = "username")  //username element is defined
	WebElement username;   //webelement variable is define.
	
	@FindBy(name = "password")   //this line is as same as //driver.findBy.name("password"
	WebElement password;
	
	@FindBy(xpath = "//*[@id='loginForm']/div/div/input[@value = 'Login']")
	WebElement loginButton;
	
	//signUp link on homepage
	@FindBy(xpath = "//ul/li[2]/a[contains(text(),'Sign Up')]")
	WebElement SignUpLink;
	
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	@FindBy(xpath = "//ul/li[6]/a[contains(text(),'Contact')]")
	WebElement contactlink;
	
	public LoginPage()  //constructor of this class.
	{
		PageFactory.initElements(driver, this);  //initialize element
		              //driver is coming from base class. this is pointing to current class object.
		             //all these variables(crmLogo, signUplink, loginButton, passwrod, username) will be initialie with driver.
	}
	
	//Action to be perfromed on web element.
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCRMLogo()
	{
		return crmLogo.isDisplayed(); //it will return true if the logo is displayed;
	}
	
	public HomePage login(String un, String pswd) throws InterruptedException
	{
		username.sendKeys(un); 
		password.sendKeys(pswd);
		Thread.sleep(2000);
		loginButton.click();
		
		return new HomePage();  //after clicking on login button, it will go to homepage, so I am returning homepage object.
		
	}
	public boolean contactLink()
	{
	     return contactlink.isDisplayed();
	}
	public boolean contactLinkenable()
	{
		return contactlink.isEnabled();
	}
	
	
	public void totallinksonloginpage()  //counting total links on login page
	{
		List <WebElement>  alllinktags = driver.findElements(By.tagName("a")); //findElements not findElement
		System.out.println("Total links on current webpage are: " +alllinktags.size());
		for(WebElement x: alllinktags)
			if(!(x.isEnabled()))  //checking if the link is not enabled
				System.out.println(x.getText());
		
	}
	}


