package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utilities.TestUtil;
import com.crm.qa.utilities.WebEventListener;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;  //global variable, so it can be used through out the program in side child class.
	public static EventFiringWebDriver e_driver;  //  object is created for logs in console
	public static WebEventListener eventListener;  //object is created for logs in console
	
	
	
	public TestBase()     //created constructor of the class and read the properties
	{
		//prop = new Properties(); //object of the Properties
		try
		{
			prop = new Properties();
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//configuration//configu.properties");
			prop.load(input);
			System.out.println("I am in TestBase constructor");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{	
			e.printStackTrace();
			
		}
	}

	
	public static void initialization()
	{
		//System.out.println("I am in initialization method now");
		String browserName = prop.getProperty("Browser");  //reading browser name from property file, configu.properties
		System.out.println(browserName);
		
		if(browserName.trim().equals("Chrome"))
		{
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tilak\\git\\FreeCRMTest\\FreeCRMTest\\src\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "C:\\Yogini\\geckoDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //location of browser in local drive
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			System.setProperty("Webdriver, gecko driver","C:\\Users\\tilak\\git\\FreeCRMTest\\FreeCRMTest\\src\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//creating object of EventFiringWebDriver and EvenetListener.
		//these lines of code is to generate line by line log when code is executing.  WebEventListener.java is created in com.crm.qa.utilities. its copy and paste code except for the screenshot of when exception occures.
		e_driver = new EventFiringWebDriver(driver); //object is created. it is declared above
		//Now, create object of EventListener
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		
		System.out.println(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);  //created class called TestUtil and defined variable there,
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); //now you can change time from there itself. to see class. press ctrl and click on variables(page_load_Timeout, implict_wait)
		
		String url = prop.getProperty("url");
		System.out.println("the url is " + url);
		//driver.get(prop.getProperty("url")); //reading url from property file by using prop object
		driver.navigate().to(prop.getProperty("url"));
	}
}
