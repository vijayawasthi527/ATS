package ats_Test;

import base.Base;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ats_Utility.*;
import ats_POM.DashBoard_Page;

import ats_POM.*;


public class ATS_TestClass extends Base
{
	Home_page homepage;
	Login_Page loginpage;
	DashBoard_Page dashBoard;
	Meeting_Page meetingPage;
	Create_Meeting_Page createJob;
	
	@BeforeClass()
	
	public void launchBrowser() throws InterruptedException
	{
		launchATS();
		homepage=new Home_page(driver);
		loginpage=new Login_Page(driver);
		dashBoard=new DashBoard_Page(driver);
		meetingPage=new Meeting_Page(driver);
		createJob=new Create_Meeting_Page(driver);
	}

	@BeforeMethod
	public void process() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Utility.scrolling(0,400);
		Thread.sleep(2000);
		homepage.clickOnClientLogin();
		
		loginpage.enterEmail(Utility.readingDataFromExcel(1,0));
		loginpage.enterpassword(Utility.readingDataFromExcel(1,1));
		loginpage.clickSigninButton();
		
		Thread.sleep(5000);
		dashBoard.clickMenuOption();
		
		
		Thread.sleep(2000);
		dashBoard.left_slider(driver);
		Utility.scrolling(0,200);
		dashBoard.clickTaskMeetings();
		
		Thread.sleep(3000);
		dashBoard.clickMeetings();
		
		meetingPage.create_Meeting();
		
		createJob.createJob_Title(Utility.readingDataFromExcel(4,0));
		
		createJob.meeting_type();
		
		createJob.meeting_url(Utility.readingDataFromExcel(5,0));
		
		Utility.scrolling(0,400);
		
		createJob.meeting_end();
		
		createJob.meeting_endDate();
		
		createJob.end_Hours();
		
		createJob.end_minutes();
		
		createJob.apply_Button2();
		
		createJob.meeting_start();
		
		createJob.meeting_startDate();
		
		createJob.start_hours();
		
		createJob.start_minutes();
		
		createJob.apply_Button1();
		
		createJob.related_to();
		
		createJob.collaborator_click(driver);
		
		createJob.meeting_Attandees();
		
		createJob.description();
		
		createJob.submit();
		
		
		
		

	}
	
	
	@Test
	public void validate_actions() throws InterruptedException
	{
		
	}
	
}
