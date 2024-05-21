package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	HomePage homepage;
	PageUtility pageUtility;
	Properties properties = new Properties();
	WaitUtility waitUtility;
	

	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement userNameField;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinButton;
	@FindBy(xpath = "//button[@class='close']")
	WebElement alertCloseButton;
	@FindBy(xpath = "//div[@class='login-logo']//a//b")
	WebElement loginHeaderlogo;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberme;
	@FindBy(xpath = "//input[@id='remember']")
	WebElement remembermeCheckbox;
	By homePageWaitElement=By.xpath("//a[@class='d-block']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
		
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickonSigninButton() {
		signinButton.click();
	}

	public boolean checkboxIsEnabled() {
		pageUtility=new PageUtility(driver);
		return pageUtility.is_Enabled(remembermeCheckbox);
	}
	public void login() {
		waitUtility=new WaitUtility(driver);
		String username = properties.getProperty("userName");
		String password = properties.getProperty("password");
		enterUserName(username);
		enterPassword(password);
		clickonSigninButton();
		waitUtility.waitForElementToBeVisible(homePageWaitElement, 20);
		
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSigninButton();
	}

	public boolean getErrorMessageAlert() {
	 boolean closebuttondisplayed=alertCloseButton.isDisplayed();
	 return  closebuttondisplayed;

	}
	public String logoText() {
		String actuallogo= loginHeaderlogo.getText();
		return actuallogo;
	}
	public String useridText() {
		String actualText= userNameField.getAttribute("placeholder");
		return actualText;
	}
	public String remembermeText() {
		String actualText= rememberme.getText();
		return actualText;
	}
}
