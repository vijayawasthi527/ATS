package ats_Test;

import base.Base;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.model.Report;
import com.mongodb.gridfs.CLI;

import ats_Utility.*;
import ats_POM.*;

@Listeners(listners.Listner_ATS.class)
public class ATS_TestClass extends Base
{
	public static Logger logger;
	Home_page homepage;
	Login_Page loginpage;
	DashBoard_Page dashBoard;
	Meeting_Page meetingPage;
	Create_Meeting_Page createJob;
	Client_Page createclient;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		logger=logger.getLogger("ATS_Project");
		PropertyConfigurator.configure("C:\\Users\\vijay\\eclipse-workspace123\\ATS_Project\\src\\test\\resources\\log4j.properties");
		
	}

	@BeforeMethod
	public void process() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		launchATS();
		homepage=new Home_page(driver);
		loginpage=new Login_Page(driver);
		dashBoard=new DashBoard_Page(driver);
		meetingPage=new Meeting_Page(driver);
		createJob=new Create_Meeting_Page(driver);
		createclient=new Client_Page(driver);
		Utility.wait(1500);
		Utility.scrolling(0,400);
		Utility.wait(2000);
		homepage.clickOnClientLogin();
		
		loginpage.enterEmail(Utility.readingDataFromExcel(1,0));
		loginpage.enterpassword(Utility.readingDataFromExcel(1,1));
		loginpage.clickSigninButton();
		
		Utility.wait(4000);
		dashBoard.clickMenuOption();
		
	}
	
	
	@Test()
	public void validate_MeetingCreation() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(2000);
		dashBoard.left_slider(driver);
		Utility.scrolling(0,200);
		dashBoard.clickTaskMeetings();
		
		Utility.wait(3000);
		dashBoard.clickMeetings();
		
		meetingPage.create_Meeting();
		
		createJob.createJob_Title(Utility.readingDataFromExcel(4,0));
		Reporter.log("Reading job title from Sheet",true);
		
		createJob.meeting_type();
		
		createJob.meeting_url(Utility.readingDataFromExcel(5,0));
		Reporter.log("Entering the Meeting URL",true);
		
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
		logger.info("Test case 1 completed");
		
	}
	
	@Test(priority = 1)
	public void validate_ClientCreation() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(1500);
//		dashBoard.left_slider(driver);
		//Utility.scrolling(0,200);
		Utility.wait(1000);
		dashBoard.clickOnClient();
		Utility.wait(1000);
		createclient.clickCreateNew();
		Utility.wait(1500);
		createclient.enterName(Utility.readingDataFromExcel(8,0));
		Utility.wait(1000);
		createclient.enterNumber(Utility.readingDataFromExcel(8,1));
		Utility.wait(1000);
		createclient.enterFax(Utility.readingDataFromExcel(8,2));
		Utility.wait(1000);
		createclient.enterWebsite(Utility.readingDataFromExcel(8,3));
		Utility.wait(1000);
		createclient.industrySelect();
		Utility.wait(1000);
		createclient.industrySuggetion(driver);
		Utility.wait(1000);
		createclient.sourceSelect();
		Utility.wait(1000);
		createclient.sourceSuggestion(driver);
		Utility.wait(1000);
		createclient.about(Utility.readingDataFromExcel(8,4));
		Utility.wait(1000);
		createclient.street(Utility.readingDataFromExcel(12,0));
		Utility.wait(1000);
		createclient.city(Utility.readingDataFromExcel(12,1));
		Utility.wait(1000);
		createclient.state(Utility.readingDataFromExcel(12,2));
		Utility.wait(1000);
		createclient.code(Utility.readingDataFromExcel(12,3));
		Utility.wait(1000);
		createclient.country();
		createclient.countrySugest(driver);
		createclient.sameAddress();
		Utility.wait(1000);
		Utility.scrolling(0,200);
		createclient.upload1(Utility.readingDataFromExcel(15,0));
		Utility.wait(1000);
		createclient.upload2(Utility.readingDataFromExcel(15,1));
		Utility.wait(1000);
		createclient.submitaction();
		Utility.wait(1000);
		
		createclient.allClient();
		Utility.wait(1500);
		String result=createclient.firstClient();
		String expected=Utility.readingDataFromExcel(8,0);
		
		Assert.assertEquals(result,expected,"Result's are not matched, TC Failed!!!!");
		
		
	}
	
}
