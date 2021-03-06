package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{

	
	public static WebDriver startApplication(WebDriver driver, String browser, String appURL)
	{
		
		if (browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		
		else if(browser.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else
		{
			System.out.println("invalid browser");
			
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
		
		
	}
	
	
	public static void EndApplication(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
}
