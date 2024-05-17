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

	LoginPage loginpage;
	HomePage homepage;
	AdminUsersPage adminuserspage;
	ExcelReader excelread = new ExcelReader();
	GeneralUtility generaltility = new GeneralUtility();

	@Test
	public void verifyNewUserCreation() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUserTile();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.newButtonClick();
		excelread.setExcelFile("UserCreationData", "UserData");
		String username = excelread.getCellData(1, 0);
		username=username+GeneralUtility.getRandomFullname();
		String password = excelread.getCellData(1, 1);
		String usertype = excelread.getCellData(1, 2);
		//String fname = GeneralUtility.getRandomFullname();
		//adminuserspage.saveUser(fname, fname, usertype);                //using faker
		adminuserspage.saveUser(username, password, usertype);       //using excelread
		// adminuserspage.saveUser("hari123455", "pass", "Partner");     //using parametrised method
		String actual = adminuserspage.getTextAlertMessage();
		String expected = "User Created Successfully";
		Boolean result = actual.contains(expected);
		Assert.assertTrue(result);
	}
	@Test
	public void verifyNewUserSearch() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUserTile();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.newButtonClick();
		String fname = GeneralUtility.getRandomFullname();
		adminuserspage.saveUser(fname, fname,"Admin");
		boolean actual=adminuserspage.userInList(fname);
		Assert.assertTrue(actual);
		
	}
	@Test
	public void verifyNewUserLogin() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUserTile();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.newButtonClick();
		String fname = GeneralUtility.getRandomFullname();
		adminuserspage.saveUser(fname, fname,"Admin");
		homepage.logout();
		loginpage.login(fname,fname);
	String actual=homepage.getProfilename();
	Assert.assertEquals(actual, fname);
	}
	@Test
	public void verifyDeactivationFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUserTile();
		adminuserspage = new AdminUsersPage(driver);
		adminuserspage.deactivateUser("Romy20240517_13072523062.864756916217");
		
		
	}
}
	

