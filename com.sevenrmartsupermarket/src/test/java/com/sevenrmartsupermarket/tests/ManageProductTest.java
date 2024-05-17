package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	ManageProductPage manageProductpage;
	
	@Test
	public void verifyProductNumbers() throws InterruptedException {
		loginpage=new LoginPage(driver);
		loginpage.login();
		homepage=new HomePage(driver);
		homepage.clickOnManageProduct();
		manageProductpage=new ManageProductPage(driver);
		String expected=(manageProductpage.getTextOfListHeader());
		int act=manageProductpage.getAllProductCount();
		String actual=String.valueOf(act);
		boolean result=expected.contains(actual);
		System.out.println(result);
		Assert.assertTrue(result);
		
	}
	

}
