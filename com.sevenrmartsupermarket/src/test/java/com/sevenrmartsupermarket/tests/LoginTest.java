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
public void verifyValidUserLogin() {
	
	loginPage = new LoginPage(driver);		
	homePage = new HomePage(driver);
	loginPage.login();
	String expectedProfileName = "Admin";
	String actualProfileName = homePage.getProfilename();
	Assert.assertEquals(actualProfileName, expectedProfileName);	
	
}
@Test(groups="smoke")
public void verifyInvalidUserLogin() {
loginPage=new LoginPage(driver);
String name=GeneralUtility.getRandomFullname();
	loginPage.login(name,"kkkk");
	boolean expected=loginPage.isErrorMessageDisplayed();
	Assert.assertTrue(expected);
	
}
@Test(groups="smoke")
public void verifyLogoText() {
	loginPage=new LoginPage(driver);
String actualLogo=loginPage.logoText();
String expectedLogo="7rmart supermarket";
Assert.assertEquals(actualLogo, expectedLogo);
}
@Test(groups="sanity",retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
public void verifyUseridText() {
	loginPage=new LoginPage(driver);
String actualText=loginPage.useridText();
String expectedText="Username";
Assert.assertEquals(actualText, expectedText);
}
@Test(groups={"sanity","smoke"},retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)//retry if fails
public void verifyRemembermeText() {
	loginPage=new LoginPage(driver);
String actualText=loginPage.remembermeText();
String expectedText="Remember Me";
Assert.assertEquals(actualText, expectedText);
}
@Test(groups={"sanity","smoke"})
public void verifyRemembermeCheckboxEnabled() {
	loginPage=new LoginPage(driver);
	boolean check=loginPage.checkboxIsEnabled();
	Assert.assertTrue(check);
}
@Test(dataProvider = "Newlogin",dataProviderClass = DataProviders.class,groups="sanity")
public void verifyLoginDataProvider(String user,String password) {
loginPage=new LoginPage(driver);
homePage = new HomePage(driver);
	loginPage.login(user,password);
	String actualProfileName = homePage.getProfilename();
	String expectedProfileName = user;
	Assert.assertEquals(actualProfileName, expectedProfileName);;
}
}


