package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base{
	PushNotificationPage pushnotificationpage;
	LoginPage loginPage;
	HomePage homepage;
	ExcelReader excelread=new ExcelReader();
	
	@Test
	public void verifySendNotification() {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.clickOnPushNotification();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.sendNotification("its a title", "its a description");
		boolean displayed=pushnotificationpage.alert_PushCloseButtonDisplayed();
		Assert.assertTrue(displayed);
	}
	@Test
	public void verifyReset() {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homepage=new HomePage(driver);
		homepage.clickOnPushNotification();
		pushnotificationpage=new PushNotificationPage(driver);
		excelread.setExcelFile("PushNotificationData", "Notifications"); //workbookname, sheetName
		String title = excelread.getCellData(1, 0);
		String description = excelread.getCellData(1, 1);
		pushnotificationpage.sendNotification(title, description);
		//boolean a=pushnotificationpage.resetAlertMessage("hai", "hello");
		//Assert.assertFalse(a);
	}
}
