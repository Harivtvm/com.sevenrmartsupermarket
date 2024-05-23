package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ScreenShotCapture;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homePage;
	
	@Test
public void verify_GraphicElements() {
		//ScreenShotCapture screenShotCapture=new ScreenShotCapture();
	loginpage=new LoginPage(driver);
	loginpage.login();
	homePage=new HomePage(driver);
	int actualsize=homePage.graphicElementsSize();
	int expectedsize=8;
	Assert.assertEquals(actualsize,expectedsize);
	//screenShotCapture.takeScreenshot(driver, "hari");
}
}
