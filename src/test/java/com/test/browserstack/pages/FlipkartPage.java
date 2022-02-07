package com.test.browserstack.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.test.browserstack.utils.CommonFactory;
import com.test.browserstack.utils.DriverManager;

public class FlipkartPage {
	
	
	
	@FindBy(how= How.CSS,using = "[placeholder=\"Search for products, brands and more\"]")
    private WebElement serachField;
	
	@FindBy(how= How.CSS,using = "[type=\"submit\"]")
    private WebElement serachButton;

	@FindBy(how= How.XPATH,using = "//button[text()=\"✕\"]")
    private WebElement closePopupButton;
	
	@FindBy(how= How.CSS,using = "[type=\"checkbox\"]~div [src=\"//static-assets-web.flixcart.com/www/linchpin/fk-cp-zion/img/fa_62673a.png\"]")
    private WebElement flipkartAssured;
	
	//Can make it dynamic
	@FindBy(how= How.XPATH,using = "//div[text()=\"Brand\"]/parent::div/following-sibling::div/div/div[@title=\"SAMSUNG\"]")
    private WebElement SamsuneBrandSeelct;
	
	@FindBy(how= How.XPATH,using = "//div[text()=\"Price -- Low to High\"]")
    private WebElement lowtoHigh;
	
	
	@FindBy(how= How.CSS,using = "[rel=\"noopener noreferrer\"]")
    private List<WebElement> getLinkOfAllProduct;
	
	
	@FindBy(how= How.XPATH,using = "//a[@rel=\"noopener noreferrer\"]/div[2]/div[1]/div[1]")
    private List<WebElement> productName;
	
	
	@FindBy(how= How.XPATH,using = "//a[@rel=\"noopener noreferrer\"]/div[2]/div[2]/div[1]/div[1]/div[1]")
    private List<WebElement> priceList;
	
	
	
	
	
	
	
	
	
	public FlipkartPage()
	{
		//CommonFactory.initilseElement(this);
		PageFactory.initElements(DriverManager.getDriver(), this);
		
	}
	
	public void closePopup()
	{
		closePopupButton.click();
	}
	
	public void seachMobile(String mobileName)
	{
		serachField.sendKeys(mobileName);
		serachButton.click();
	}
	
	public void selectFlipkartAssuredInFilter()
	{
		flipkartAssured.click();
	}
	
	public void selectbrand()
	{
		SamsuneBrandSeelct.click();
	}
	
	//can customise with different condition
	public void selectFilter()
	{
		lowtoHigh.click();
	}
	
	public ArrayList<String> getProductLink()

	{
			ArrayList<String> getList= new ArrayList();
			
			for(int i=0;i<getLinkOfAllProduct.size();i++)
			{
				getList.add(CommonFactory.getArrtibute(getLinkOfAllProduct.get(i),"href"));
			}
			System.out.println(getList);
			return getList;
			
	
	}
	
	public ArrayList<String> getProducName()

	{
			ArrayList<String> getList= new ArrayList();
			
			for(int i=0;i<productName.size();i++)
			{
				getList.add(productName.get(i).getText());
			}
			System.out.println(getList);
			return getList;
			
			
	}
	
	public ArrayList<String> getProductPrice()

	{
			ArrayList<String> getList= new ArrayList();
			
			for(int i=0;i<priceList.size();i++)
			{
				getList.add(priceList.get(i).getText());
			}
			System.out.println(getList);
			return getList;
			
			
	}
}

