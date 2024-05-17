package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility=new GeneralUtility();
	
	@FindBy(xpath="(//div[@class='card-header'])[2]")
	WebElement listProductHeader;
	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;
	@FindBy(xpath="//table//tr//td[1]")
	List<WebElement> productList;
	@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//li")
	List<WebElement> pagelist;
	
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getTextOfListHeader() {
		String text=listProductHeader.getText();
		return text;
	}
	public void clickOnNext() {
		pageutility=new PageUtility(driver);
pageutility.scrollAndClick(nextButton);
	
	}
	
	public List getAllProductList() {
		List<String> productlist=new ArrayList<String>();
		productlist=generalutility.getTextofElements(productList);
		int pages=pagelist.size()-3;
		System.out.println("Number of pages = "+pages+"-1");
		for(int i=0;i<pages;i++) {
			clickOnNext();
			for(WebElement element:productList) {
				productlist.add(element.getText());
		}
		}
		System.out.println(productlist.size());
	return productlist;
	}
	
	public int getAllProductCount() {
		List<String> product=new ArrayList<String>();
		product=getAllProductList();
		return product.size();
	}

}
	
