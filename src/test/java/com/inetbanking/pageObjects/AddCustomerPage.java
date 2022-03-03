package com.inetbanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.LINK_TEXT, using= "New Customer")
	@CacheLookup
	WebElement linkAddCustomer;
	
	@FindBy(how=How.NAME, using= "name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how=How.NAME, using= "rad1")
	@CacheLookup
	WebElement txtGender;
	
	@FindBy(how=How.NAME, using= "dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement City;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using= "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtMnumber;
	
	@FindBy(how=How.NAME, using= "emailid")
	@CacheLookup
	WebElement emailID;
	
	@FindBy(how=How.NAME, using= "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement btnSubmit;
	
		
	public void clickAddNewCustomer()
	{
		linkAddCustomer.click();
	}

	public void customerName(String cname)
	{
		CustomerName.sendKeys(cname);
	}
	
	public void cGender(String cgender)
	{
		txtGender.sendKeys(cgender);
	}
	
	public void cDob(String mm,String dd,String yyyy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yyyy);
	}
	
	public void cAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void custCity(String city)
	{
		City.sendKeys(city);
	}
	
	public void custState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void custPin(String pin)
	{
		txtPin.sendKeys(pin);
	}
	
	public void custMnumber(String number)
	{
		txtMnumber.sendKeys(number);
	}
	
	public void custEmailID(String email)
	{
		emailID.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click(); 
	}
}
