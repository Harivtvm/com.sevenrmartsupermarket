package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageCategoryPage;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageCategoryTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	ManageCategoryPage manageCategoryPage;
	
	@Test
	public void verifyCategoryCreation() throws Exception {
		loginPage=new LoginPage(driver);
		loginPage.login();
		homePage = new HomePage(driver);
		homePage.clickOnCategorySelection();
		 manageCategoryPage=new  ManageCategoryPage(driver);
		 String category="Vehicle";
		 manageCategoryPage.formFill(category);
		 homePage.clickOnCategorySelection();
		 String actual=manageCategoryPage.getTextCategoryTop();
		 Assert.assertEquals(actual, category);
	}
	
	
	
	
}
