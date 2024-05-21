package com.sevenrmartsupermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ExcelReader excelReader=new ExcelReader();
	
	
	@DataProvider(name="LoginCredential")
	public Object[][] LoginCredential()
	{
		return new Object [][] {{"Hari5","hari5"},{"Admin","admin"},{"robo","admin"}};
	}
	
	
	@DataProvider(name="Newlogin")       //using excel
	public Object[][] Newlogin()
	{
		excelReader.setExcelFile("LoginData","DataProviderSheet");
		return excelReader.getMultidimentionalData(3, 2);
	}
}
