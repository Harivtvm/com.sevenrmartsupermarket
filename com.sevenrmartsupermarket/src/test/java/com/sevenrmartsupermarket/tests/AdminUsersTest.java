 package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	ExcelReader excelRead = new ExcelReader();
	GeneralUtility generalUtility = new GeneralUtility();

	@Test(priority=4)
	public void verifyNewUserCreation() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnAdminUserTile();
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.newButtonClick();
		excelRead.setExcelFile("UserCreationData", "UserData");
		String username = excelRead.getCellData(1, 0);
		username=username+GeneralUtility.getRandomFullname();
		String password = excelRead.getCellData(1, 1);
		String usertype = excelRead.getCellData(1, 2);
		//String fname = GeneralUtility.getRandomFullname();
		//adminuserspage.saveUser(fname, fname, usertype);                //using faker
		adminUsersPage.saveUser(username, password, usertype);       //using excelread
		// adminuserspage.saveUser("hari123455", "pass", "Partner");     //using parametrised method
		String actual = adminUsersPage.getTextAlertMessage();
		String expected = "User Created Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
	}
	@Test(priority=1)
	public void verifyNewUserSearch() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnAdminUserTile();
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.newButtonClick();
		String fname = GeneralUtility.getRandomFullname();
		adminUsersPage.saveUser(fname, fname,"Admin");
		boolean actual=adminUsersPage.userInList(fname);
		Assert.assertTrue(actual);
		
	}
	@Test(priority=2)
	public void verifyNewUserLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnAdminUserTile();
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.newButtonClick();
		String fname = GeneralUtility.getRandomFullname();
		adminUsersPage.saveUser(fname, fname,"Admin");
		homePage.logout();
		loginPage.login(fname,fname);
	String actual=homePage.getProfilename();
	Assert.assertEquals(actual, fname);
	}
	@Test(priority=3)
	public void verifyDeactivationFunctionality() {
		loginPage = new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnAdminUserTile();
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.deactivateUser("Theron Mante");
		
		
	}
}
	

