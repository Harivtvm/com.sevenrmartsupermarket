package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ManageOrdersPage manageOrdersPage;
	
@Test
	public void verifyOrderSearch() {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homePage=new HomePage(driver);
		homePage.clickOnManageOrder();
manageOrdersPage=new ManageOrdersPage(driver);
String exp="102";
manageOrdersPage.searchFunction(exp);
String act=manageOrdersPage.getTextOfSearch();
Assert.assertEquals(act,exp);
}
@Test
public void verifyOrderStatusUpdate() {
	loginPage=new LoginPage(driver);
	loginPage.login();
	homePage=new HomePage(driver);
	homePage.clickOnManageOrder();
manageOrdersPage=new ManageOrdersPage(driver);
String orderNumber="101";
manageOrdersPage.searchFunction(orderNumber);
String status="Out For Delivery";
String statusExpected=status.toUpperCase();
manageOrdersPage.changeStatus(status);
String statusActual=manageOrdersPage.changeStatusCheck();
System.out.println(statusActual);
Assert.assertEquals(statusActual, statusExpected);


}

}