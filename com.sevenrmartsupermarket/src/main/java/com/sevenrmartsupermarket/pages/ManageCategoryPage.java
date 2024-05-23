package com.sevenrmartsupermarket.pages;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageCategoryPage {
	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility = new GeneralUtility();
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newCreateCategoryButton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement selectGroupBox;
	@FindBy(xpath = "//input[@value='yes'and@name='top_menu']")
	private WebElement showOnTopMenuRadioButton;
	@FindBy(xpath = "//input[@value='yes'and@name='show_home']")
	private WebElement showOnLeftMenuRadioButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement chooseFileButton;
	@FindBy(xpath = "//table//tr[1]//td[1]")
	private WebElement categoryTopRow;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void chooseFile() throws Exception {
		pageUtility=new PageUtility(driver);
		String path="D:\\pics\\auto.jfif";
		pageUtility.fileUpload(chooseFileButton, path);
	}
	
	public void formFill(String category) throws Exception {
		newCreateCategoryButton.click();
		categoryField.sendKeys(category);
		selectGroupBox.click();
		chooseFile();
		pageUtility=new PageUtility(driver);
		pageUtility.scrollAndClick(showOnTopMenuRadioButton);
		showOnLeftMenuRadioButton.click();
		pageUtility.scrollAndClick(saveButton);
		
		
	}
	
	public String getTextCategoryTop() {
		return categoryTopRow.getText();
	}
	
}

