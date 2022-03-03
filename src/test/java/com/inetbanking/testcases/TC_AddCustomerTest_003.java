package com.inetbanking.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(userName);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		logger.info("Providing customer details...");
		addcust.clickAddNewCustomer();
		Thread.sleep(5000);
		addcust.customerName("Ashish");
		addcust.cGender("Male");
		addcust.cDob("20", "11", "1990");
		addcust.cAddress("Sector 9");
		addcust.custCity("Noida");
		addcust.custState("Uttar Pradesh");
		addcust.custPin("201301");
		addcust.custMnumber("1234567890");
		
		String email=randomString()+"@gmail.com";
		addcust.custEmailID(email);
		
		addcust.setPassword("pass@pwd");
		Thread.sleep(2000);
		addcust.clickSubmit();
		
		Thread.sleep(2000);
		logger.info("Validation started...");
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			logger.info("Test case is passed...");
		}
		else
		{
			logger.info("Test case is failed...");
			takesScreeshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
