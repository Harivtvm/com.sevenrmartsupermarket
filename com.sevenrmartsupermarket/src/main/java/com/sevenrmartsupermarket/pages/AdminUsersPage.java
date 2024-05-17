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

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generaltility = new GeneralUtility();

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeDropdown;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertMessageUserCreation;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	private List<WebElement> usertablenamelist;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButtonPrimary;
	@FindBy(xpath = "//div[@class='col-sm-6 form-group']//input[@class='form-control']")
	private WebElement searchUsernameField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonSecondary;
	//table//tr[13]//td[5]

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean userInList(String name) {
		
		List<String> namelist=new ArrayList<String>();
		namelist=generaltility.getTextofElements(usertablenamelist);
		boolean a=namelist.contains(name);
		System.out.println(namelist);
		return a;
	}
	
public String getTextAlertMessage() {
	String a=alertMessageUserCreation.getText();
	return a;
}
	public void newButtonClick() {
		newButtonElement.click();
	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUserType(String text) {
		
		pageutility.select_ByVisibleText(userTypeDropdown, text);
	}
	public void deactivateUser(String name) {
		pageutility=new PageUtility(driver);
		List<String> namelist=new ArrayList<String>();
		int a=usertablenamelist.size();
		namelist=generaltility.getTextofElements(usertablenamelist);
		//System.out.println(namelist);
		int index=0;
		for(index=0;index<namelist.size();index++)
		{
			if(namelist.get(index).equals(name)) {
				index++;
				break;
			}
		}
		WebElement deactivateButton=driver.findElement(By.xpath("//table//tr["+index+"]//td[5]//a[1]"));	
		pageutility.scrollAndClick(deactivateButton);

		
		
	}
	public void saveUser(String username,String password,String usertype) {
		enterUserName(username);
		enterPassword(password);
		selectUserType(usertype);
		saveButtonElement.click();
		
	}
	
}
