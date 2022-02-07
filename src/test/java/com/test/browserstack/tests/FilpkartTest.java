package com.test.browserstack.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.browserstack.pages.FlipkartPage;
import com.test.browserstack.utils.CommonFactory;

public class FilpkartTest {
	
	public FlipkartPage flipkartPage;
	
	@BeforeClass(groups = {"flipkartest"})
	public void initSetup()
	{
		flipkartPage= new FlipkartPage();
	}
	
	@Test(priority = 1, groups = {"flipkartest"})
	public void  getSearch()
	{
		flipkartPage.closePopup();
		flipkartPage.seachMobile("Samsung Galaxy S10");
		CommonFactory.wait(5);
		String result=CommonFactory.getElement("//span[text()=\"Samsung Galaxy S10\"]").getText();
		Assert.assertEquals(result, "Samsung Galaxy S10");
	}
	
	
	@Test(priority = 2,groups = {"flipkartest","regrssion"})
	public void  getFilterresults()
	{
		flipkartPage.selectFlipkartAssuredInFilter();
		CommonFactory.wait(2);
		flipkartPage.selectbrand();
		CommonFactory.wait(2);
		flipkartPage.selectFilter();
		CommonFactory.wait(2);
		
		flipkartPage.getProducName();
		
		flipkartPage.getProductLink();
		flipkartPage.getProductPrice();
		
	}
	

}
