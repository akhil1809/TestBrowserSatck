package com.test.browserstack.utils;



import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserFactory {
	public static WebDriver webDriver=null;
	 public static String user_Name=System.getenv("AUTOMATE_USERNAME");
	 public static String access_Key=System.getenv("AUTOMATE_ACCESS_KEY");
	 public static String url="https://" + user_Name + ":" + access_Key + "@hub-cloud.browserstack.com/wd/hub";
		
	public static void openBrowser(Config.BROWSER browser)
	{
		
		switch(browser)
		{
		case CHROME:
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
            webDriver=new ChromeDriver();
            DriverManager.setDriver(webDriver);
            break;
			
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
           // FirefoxOptions firefoxOptions=new FirefoxOptions();
           // firefoxOptions.addArguments("--start-maximized");
            webDriver=new FirefoxDriver();
            DriverManager.setDriver(webDriver);
			break;
		case BROWSERSTACK:
			System.out.println(user_Name);
        	System.out.println(access_Key);
        	DesiredCapabilities caps=new DesiredCapabilities();
        	caps.setCapability("os_version", "Big Sur");
            caps.setCapability("resolution", "1920x1080");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest");
            caps.setCapability("os", "OS X");
            caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
            caps.setCapability("build", "BStack Build Number 3");
		try {
			webDriver=new RemoteWebDriver(new URL(url),caps);
			DriverManager.setDriver(webDriver);
		       } catch (MalformedURLException e) {
			   e.printStackTrace();
		      }
        	break;
		case SAFARI:
            webDriver=new SafariDriver();
            DriverManager.setDriver(webDriver);
            break;
			
		}
		DriverManager.getDriver().manage().deleteAllCookies();
		CommonFactory.maximiazedBrowser();
	}
	
	
	
}
