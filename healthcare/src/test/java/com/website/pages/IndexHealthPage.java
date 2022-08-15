package com.website.pages;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.website.utils.BaseUtils;

public class IndexHealthPage extends BaseUtils
{
	protected WebElement loginMenu;
	protected WebElement testLogin;	
	public void indexpage() 
	{
		try 
		{
			inputstream = new FileInputStream("C:\\Users\\Tania\\Desktop\\Souvik_Data\\healthcare\\src\\test\\resources\\website\\files\\website.properties");
			p = new Properties();
			p.load(inputstream);
			String url = p.getProperty("url");
			driver.get(url);		
			driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
			
			loginMenu = driver.findElement(By.id("menu-toggle"));
			loginMenu.click();
			
			testLogin = driver.findElement(By.linkText("Login"));
			testLogin.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
