package com.website.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class LoginHealth extends IndexHealthPage
{
	protected WebElement testUsername;
	protected WebElement testPassword;
	protected WebElement testLoginBtn;
	
	public void login() throws IOException, InterruptedException
	{
		
			inputstream = new FileInputStream("C:\\Users\\Tania\\Desktop\\Souvik_Data\\healthcare\\src\\test\\resources\\website\\files\\website.properties");
			p = new Properties();
			p.load(inputstream);
			String sqlPass = p.getProperty("sqlPass");
			String sqlQuery = p.getProperty("sqlQuery");
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root",sqlPass);  
			
			System.out.println("connect to db");  
	
			String sql = sqlQuery;		
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{	
				testUsername= driver.findElement(By.id("txt-username"));
				testUsername.sendKeys(rs.getString(1));
				
				Thread.sleep(2000);
				
				testPassword = driver.findElement(By.name("password"));
				testPassword.sendKeys(rs.getString(2));
				
				testLoginBtn= driver.findElement(By.id("btn-login"));
				testLoginBtn.submit();
				
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				if (rs.getString(1).contentEquals("John Doe") && rs.getString(2).contentEquals("ThisIsNotAPassword")) 
				{
					break;
				}
				else
				{
					try 
					{
						testUsername.clear();					
						Thread.sleep(2000);
						testPassword.clear();
					}
					catch(StaleElementReferenceException e)
					{
						testUsername= driver.findElement(By.id("txt-username"));
						testUsername.clear();
						
						testPassword = driver.findElement(By.name("password"));
						testPassword.clear();
						
					}				
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	
	}
}
