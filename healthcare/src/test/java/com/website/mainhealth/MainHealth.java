package com.website.mainhealth;

import java.io.IOException;

import com.website.pages.AppointmentHealthPage;

public class MainHealth
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		AppointmentHealthPage  page = new AppointmentHealthPage();
		Thread.sleep(3000);
		page.takescreenshot("index");
		Thread.sleep(2000);
		page.indexpage();
		page.takescreenshot("login");
		Thread.sleep(2000);
		page.login();
		page.takescreenshot("appointment_page");
		Thread.sleep(2000);
		page.appointment();
		page.takescreenshot("summary");
		Thread.sleep(2000);
		page.logoutHealth();
		page.close();
	}

}
