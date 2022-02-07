package com.test.browserstack.utils;

import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonFactory {
	
	public static void maximiazedBrowser()
	{
	   Toolkit toolkit = Toolkit.getDefaultToolkit();
	   int Width = (int) toolkit.getScreenSize().getWidth();
	   int Height = (int)toolkit.getScreenSize().getHeight();
	          
	   DriverManager.getDriver().manage().window().setSize(new Dimension(Width,Height));
	}

	
	public static void wait(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initilseElement(Object object)
	{
		PageFactory.initElements(DriverManager.getDriver(), object);
	}
	
	
	public static WebElement getElement(String xpath)
	{
		return DriverManager.getDriver().findElement(By.xpath(xpath));
	}
	
	public static String getArrtibute(WebElement element, String attrName)
	{
		return element.getAttribute(attrName);
	}
}
