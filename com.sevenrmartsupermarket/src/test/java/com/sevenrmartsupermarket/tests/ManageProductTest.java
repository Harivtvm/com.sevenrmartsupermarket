package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	ManageProductPage manageProductPage;
	
	@Test
	public void verifyProductNumbers() {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homePage=new HomePage(driver);
		homePage.clickOnManageProduct();
		manageProductPage=new ManageProductPage(driver);
		String expected=(manageProductPage.getTextOfListHeader());
		int act=manageProductPage.getAllProductCount();
		String actual=String.valueOf(act);
		boolean result=expected.contains(actual);
		System.out.println(result);
		Assert.assertTrue(result);
		
	}
	

}
