package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOrdersPage {
	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility=new GeneralUtility();
	
	@FindBy(xpath="//a[@href='javascript:void(0)']")
	WebElement searchPrimaryButton;
	@FindBy(xpath="//input[@id='od']")
	WebElement orderIdInputField;
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchSecondaryButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	WebElement tableOrderIdFirstRow;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[6]//a[text()='Change Status']")
	WebElement changeStatus;
	@FindBy(xpath="//select[@id='status']")
	WebElement dropDownUpdateStatus;
	@FindBy(xpath="//button[@class='btn btn-info']")
	WebElement updateButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[6]//span")
	WebElement statusDisplay;
	
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPrimarySearchButton() {
		searchPrimaryButton.click();
	}
	public void enterOrderId(String orderId) {
		orderIdInputField.sendKeys(orderId);
	}
	public void clickOnSecondarySearchButton() {
		searchSecondaryButton.click();
	}
	public String getTextOfSearch() {
		return tableOrderIdFirstRow.getText();
	}
	public void searchFunction(String orderId) {
		clickOnPrimarySearchButton();
		 enterOrderId(orderId);
		 clickOnSecondarySearchButton();
	}
	public void changeStatus(String status) {
		pageUtility=new PageUtility(driver);
		pageUtility.scrollAndClick(changeStatus);
		pageUtility.select_ByVisibleText(dropDownUpdateStatus, status);
		updateButton.click();
		}
	public String changeStatusCheck() {
		driver.navigate().back();
		return statusDisplay.getText();
		
	}
	}
	
	
	

