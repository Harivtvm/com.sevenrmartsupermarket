package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;



public class LoginTest extends Base{
	LoginPage loginPage;
	HomePage homepage;
@Test
public void verifyLogin() {
 loginPage=new LoginPage(driver);

	loginPage.login();
}
@Test
public void verifyValidUserLogin() {
	
	loginPage = new LoginPage(driver);		
	homepage = new HomePage(driver);
	loginPage.login();
	String expectedProfileName = "Admin";
	String actualProfileName = homepage.getProfilename();
	Assert.assertEquals(actualProfileName, expectedProfileName);	
	
}
@Test
public void verifyInvalidUserLogin() {
loginPage=new LoginPage(driver);
System.out.println(GeneralUtility.getRandomFullname());

	loginPage.login("hhh","kkkk");
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
}



