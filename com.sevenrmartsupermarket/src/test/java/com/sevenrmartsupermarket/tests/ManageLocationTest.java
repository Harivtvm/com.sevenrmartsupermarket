package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageLocationTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	ManageLocationPage manageLocationPage;
	ExcelReader excelRead = new ExcelReader();
	GeneralUtility generalUtility = new GeneralUtility();
	
	
	@Test
	public void verifyNewLocationCreation() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnManageLocation();
		manageLocationPage=new ManageLocationPage(driver);
		excelRead.setExcelFile("Location Data", "Location");
		String country=excelRead.getCellData(2, 0);
		String state=excelRead.getCellData(2, 1);
		String location=excelRead.getCellData(2, 2);
		String deliveryCharge=excelRead.getCellData(2, 3);
		manageLocationPage.newLocationCreation(country, state, location, deliveryCharge);
		homePage.clickOnManageLocation();
		boolean check=manageLocationPage.LocationInList(location);
		Assert.assertTrue(check);
		
	}

}
