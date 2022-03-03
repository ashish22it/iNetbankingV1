package com.inetbanking.testcases;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		logger.info("URL is openned");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(userName);
	    logger.info("Entered Username");
	   	lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		 assertTrue(true);	
		 logger.info("Login Test passed");
		}
		else
		{
		 takesScreeshot(driver, "LoginTest");	
		 assertTrue(false);	
		 logger.info("Login Test failed");
		}	
	}
}
