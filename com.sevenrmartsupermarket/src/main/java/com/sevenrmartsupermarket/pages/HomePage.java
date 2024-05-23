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
	private WebElement pushNotificationElement;
	@FindBy(xpath = "//div[@class='col-lg-3 col-6']")
	private List <WebElement> dashboardElements;
	@FindBy(xpath = "//div[@class='row']//div[2]//a")
	private  WebElement adminUsersTileElement;
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private  WebElement adminRightCornerLogo;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private  WebElement logoutButton;
	@FindBy(xpath = "//a//p[contains(text(),'Manage Product')]")
	private  WebElement manageProductElement;
	@FindBy(xpath="//a//p[contains(text(),'Manage Orders')]")
	private WebElement manageOrderElement;
	@FindBy(xpath="//a//p[contains(text(),'Manage Location')]")
	private WebElement manageLocationElement;
	@FindBy(xpath="//a//p[contains(text(),'Manage Category')]")
	private WebElement manageCategoryElement;
	@FindBy(xpath="(//a//p[contains(text(),'Category')])[2]")
	private WebElement categoryRadioElement;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
public void clickOnCategorySelection() {
	manageCategoryElement.click();	
	categoryRadioElement.click();
	}
public void clickOnManageLocation() {
	manageLocationElement.click();	
	}
	public void clickOnManageProduct() {
		manageProductElement.click();
	}
	public void clickOnManageOrder() {
		manageOrderElement.click();
	}
	public void logout() {
		adminRightCornerLogo.click();
		logoutButton.click();
	}
	public void clickOnPushNotification() {
		pushNotificationElement.click();
	}
	public void clickOnAdminUserTile() {
		adminUsersTileElement.click();
	}
	public String getProfilename() {
	return profileName.getText();	
	}
	
	public int graphicElementsSize() {
		int b=dashboardElements.size();
		return b;
	
	}
}
