package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.DataProviders;
import com.sevenrmartsupermarket.utilities.GeneralUtility;





public class LoginTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	DataProviders dataprovider;
	
@Test
public void verifyLogin() {
 loginPage=new LoginPage(driver);

	loginPage.login();
}
@Test
public void verifyValidUserLogin() {
	
	loginPage = new LoginPage(driver);		
	homePage = new HomePage(driver);
	loginPage.login();
	String expectedProfileName = "Admin";
	String actualProfileName = homePage.getProfilename();
	Assert.assertEquals(actualProfileName, expectedProfileName);	
	
}
@Test
public void verifyInvalidUserLogin() {
loginPage=new LoginPage(driver);
String a=GeneralUtility.getRandomFullname();
	loginPage.login(a,"kkkk");
	boolean expected=loginPage.getErrorMessageAlert();
	Assert.assertTrue(expected);
	
}
@Test
public void verifyLogoText() {
	loginPage=new LoginPage(driver);
String actualLogo=loginPage.logoText();
String expectedLogo="7rmart supermarket";
Assert.assertEquals(actualLogo, expectedLogo);
}
@Test
public void verifyUseridText() {
	loginPage=new LoginPage(driver);
String actualText=loginPage.useridText();
String expectedText="Username";
Assert.assertEquals(actualText, expectedText);
}
@Test
public void verifyRemembermeText() {
	loginPage=new LoginPage(driver);
String actualText=loginPage.remembermeText();
String expectedText="Remember Me";
Assert.assertEquals(actualText, expectedText);
}
@Test
public void verifyRemembermeCheckboxEnabled() {
	loginPage=new LoginPage(driver);
	boolean check=loginPage.checkboxIsEnabled();
	Assert.assertTrue(check);
}
@Test(dataProvider = "Newlogin",dataProviderClass = DataProviders.class)
public void verifyLoginDataProvider(String user,String password) {
loginPage=new LoginPage(driver);
homePage = new HomePage(driver);
	loginPage.login(user,password);
	String actualProfileName = homePage.getProfilename();
	String expectedProfileName = user;
	Assert.assertEquals(actualProfileName, expectedProfileName);;
}
}


