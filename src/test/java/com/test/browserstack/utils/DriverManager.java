package com.test.browserstack.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal<WebDriver> webDriver=new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> browser=new ThreadLocal<String>();
	
	public static WebDriver getDriver()
    {
        return webDriver.get();
    }

    public static void setDriver(WebDriver driverObject)
    {
    	webDriver.set(driverObject);
    }

    public static String getBrowserName() {
        return browser.get();
    }

    public static void setBrowserName(String name) {
    	browser.set(name);
    }

}
