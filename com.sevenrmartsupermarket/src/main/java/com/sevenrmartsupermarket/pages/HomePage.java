package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//ul//li[6]")
	private WebElement pushnotificationelement;
	@FindBy(xpath = "//div[@class='col-lg-3 col-6']")
	private List <WebElement> dashboardelements;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPushNotification() {
		pushnotificationelement.click();
	}
	public String getProfilename() {
	return profileName.getText();	
	}
	
	public int graphicElementsSize() {
		generalUtility=new GeneralUtility();
		List<String> items = new ArrayList<String>();
		items=generalUtility.getTextofElements(dashboardelements);
		int a=items.size();
		return a;
	
	}
}
