package com.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AppointmentHealthPage extends LoginHealth
{
	WebElement testFacility;
	WebElement checkbox;
	WebElement testHealthProgram;
	WebElement testVistDate;
	WebElement testComment;
	WebElement bookAppointmentbtn ;
	WebElement gotoHomePage;
	WebElement logoutMenu;
	WebElement testLogout;
	
	public void appointment()
	{
		testFacility = driver.findElement(By.id("combo_facility"));
		Select selectFacility = new Select(testFacility);
		selectFacility.selectByIndex(2);
		
		checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
		checkbox.click();
		
		testHealthProgram = driver.findElement(By.id("radio_program_medicaid"));
		testHealthProgram.click();
		
		testVistDate = driver.findElement(By.xpath("//*[@id='txt_visit_date']"));
		testVistDate.click();
		
		while(true)
		{
			String text = driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
			
			if(text.equals("September 2022"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[3]")).click();
			}
		}
		
		driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[contains(text(),'20')]")).click();
		
		Actions removeCalender = new Actions(driver);
		removeCalender.click().perform();
		
		testComment= driver.findElement(By.xpath("//*[@id=\"txt_comment\"]"));
		testComment.sendKeys("I want to make an Appointment");
		
		bookAppointmentbtn = driver.findElement(By.xpath("//*[@id='btn-book-appointment']"));
		bookAppointmentbtn.submit();
					
	}
	
	public void logoutHealth()
	{
		gotoHomePage = driver.findElement(By.xpath("//*[@id='summary']/div/div/div[7]/p/a"));
		gotoHomePage.click();
		
		logoutMenu = driver.findElement(By.id("menu-toggle"));
		logoutMenu.click();
		
		testLogout = driver.findElement(By.linkText("Logout"));
		testLogout.click();
		
		driver.findElement(By.xpath("//*[@id='btn-make-appointment']")).click();
	}
}
