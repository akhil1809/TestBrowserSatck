package com.test.browserstack.utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Factory {
	
	public static String browserName;	
	
	
	@BeforeTest(groups= {"flipkartest"})
	@Parameters({"browser","url"})
    public void setup(String browser,String url)
    { 
        Factory.browserName=browser;
        DriverManager.setBrowserName(browser);
		BrowserFactory.openBrowser(Config.BROWSER.valueOf(Factory.browserName));	
		DriverManager.getDriver().get(url);
    }

	@AfterTest(groups= {"flipkartest"})
	public void endSetup()
    {

	DriverManager.getDriver().close();
	DriverManager.getDriver().quit();

    }

}
