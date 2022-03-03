package com.inetbanking.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiq {

	Properties prop;
	
	public ReadConfiq()
	{
		File src=new File("./Confiquration/confiq.properties"); 
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=prop.getProperty("baseURL");
		return url;		
	}
	
	public String getUserName()
	{
		String username=prop.getProperty("userName");
		return username;		
	}
	
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;		
	}
	
	public String getChromepath()
	{
		String chromePath=prop.getProperty("Chromepath");
		return chromePath;		
	}
	
	public String getFirefoxpath()
	{
		String firefoxPath=prop.getProperty("Firefoxpath");
		return firefoxPath;		
	}
}
