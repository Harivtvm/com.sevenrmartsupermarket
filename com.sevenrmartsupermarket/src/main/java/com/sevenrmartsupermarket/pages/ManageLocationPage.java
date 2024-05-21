package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility = new GeneralUtility();
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newLocationButton;
	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[1]")
	private WebElement countryDropDown;
	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	private WebElement stateDropDown;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']") 
	private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@class='btn btn-danger']") 
	private WebElement saveButton;
	@FindBy(xpath = "//table//tr//td[1]") 
	private List<WebElement> locationsListElement;
	
	public void newLocationCreation(String country,String state,String location,String charge) {
		newLocationButton.click();
		pageUtility=new PageUtility(driver);
		pageUtility.select_ByVisibleText(countryDropDown, country);
		pageUtility.select_ByVisibleText(stateDropDown, state);
		locationField.sendKeys(location);
		 deliveryChargeField.sendKeys(charge);
		 saveButton.click();
	}
	public boolean LocationInList(String location) {
		List<String> locationList=new ArrayList<String>();
		locationList=generalUtility.getTextofElements(locationsListElement);
		if (locationList.contains(location)) {
			return true;
		}else {
				return false;
		}
		}
	
	
}






