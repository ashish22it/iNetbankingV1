package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass 
{
	
	@Test(dataProvider="getData")
	public void loginDDT(String uname, String pwd) throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(uname);
		logger.info("User name provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			takesScreeshot(driver, "loginDDT");	
			logger.warn("login failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("login passed");
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();  // close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="getData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1"); 
		int colCount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);   // String array [i-1,j]<---Table data[i,j]
			}
		}
		return loginData;		
	}		
	}
	

