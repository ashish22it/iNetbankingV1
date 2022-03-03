package com.inetbanking.testcases;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfiq;

public class BaseClass {

	ReadConfiq readconfiq=new ReadConfiq();
	public String baseURL=readconfiq.getApplicationUrl();
	public String userName=readconfiq.getUserName();
	public String password=readconfiq.getPassword();
	public static WebDriver driver;
	public static Logger logger;
			
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfiq.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfiq.getFirefoxpath());
			driver=new FirefoxDriver();	
		}
		driver.get(baseURL);
				
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void takesScreeshot(WebDriver driver, String tname) throws IOException {
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File destination=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");	
		}
		}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
}


// if any class (Test case classes) inherit this base class then beforeclass annotated method will run before execution of 
// all their Test cases.
