package ats_Test;

import base.Base;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
//
//import com.aventstack.extentreports.model.Report;
//import com.github.javafaker.Faker;
//import com.mongodb.gridfs.CLI;

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
	Manage_Companies_page manageCompanies;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		logger=Logger.getLogger("ATS_Project");
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
		manageCompanies=new Manage_Companies_page(driver);
		
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
	
	
	@Test(enabled = false)
	public void validate_MeetingCreation() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(2000);
		dashBoard.left_slider(driver);
		Utility.scrolling(0,200);
		dashBoard.clickTaskMeetings();
		Utility.wait(3000);
		dashBoard.clickMeetings();
		
		meetingPage.create_Meeting();
		
		createJob.createJob_Title(Utility.jobTitle());
		Reporter.log("Entered Job Title",true);
		
		createJob.meeting_type();
		
		createJob.meeting_url(Utility.readingDataFromExcel(5,0));
		Reporter.log("Entered the Meeting URL",true);
		
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
	public void validate_ClientCreation() throws InterruptedException, EncryptedDocumentException, IOException, FileNotFoundException
	{
		Utility.wait(1500);
//		dashBoard.left_slider(driver);
		//Utility.scrolling(0,200);
		Utility.wait(1000);
		dashBoard.clickOnClient();
		Reporter.log("Clicked on Client",true);
		Utility.wait(1000);
		createclient.clickCreateNew();
		Reporter.log("Clicked on Create Client",true);
		Utility.wait(1500);
		createclient.enterName(Utility.companyName());
		Reporter.log("Entered the Company Name",true);
		Utility.wait(1000);
		createclient.enterNumber(Utility.phone());
		Reporter.log("Entered Mobile Number",true);
		Utility.wait(1000);
		createclient.enterFax(Utility.phone());
		Reporter.log("Entered Fax Number",true);
		Utility.wait(1000);
		createclient.enterWebsite(Utility.companyURl());
		Reporter.log("Entered Company Website",true);
		Utility.wait(1000);
		createclient.industrySelect();
		Utility.wait(1000);
		createclient.industrySuggetion(driver);
		Reporter.log("Industry Selected",true);
		Utility.wait(1000);
		createclient.sourceSelect();
		Utility.wait(1000);
		createclient.sourceSuggestion(driver);
		Reporter.log("Source Selected",true);
		Utility.wait(1000);
		createclient.about(Utility.aboutCompany());
		Reporter.log("About Company Entered",true);
		Utility.wait(5000);
		createclient.street(Utility.streetName());
		Reporter.log("Entered Street Name",true);
		Utility.wait(1000);
		createclient.city(Utility.cityName());
		Reporter.log("Entered City Name",true);
		Utility.wait(1000);
		createclient.state(Utility.stateName());
		Reporter.log("Entered State Name",true);
		Utility.wait(1000);
		createclient.code(Utility.zipCode());
		Reporter.log("Entered Zip Code",true);
		Utility.wait(2000);
		createclient.country();
		createclient.countrySugest(driver);
		Reporter.log("Country Selected",true);
		createclient.sameAddress();
		Utility.wait(1000);
		Utility.scrolling(0,200);
		createclient.upload1(Utility.readingDataFromExcel(15,0));
		Reporter.log("Contract Uploaded",true);
		Utility.wait(1000);
		createclient.upload2(Utility.readingDataFromExcel(15,1));
		Reporter.log("Attached Other uploaded",true);
		Utility.wait(1000);
		createclient.submitaction();
		Reporter.log("Clicked on Submit Button",true);
		Utility.wait(1000);
		
		createclient.allClient();
		Utility.wait(1500);
		String result=createclient.firstClient();
		String expected=Utility.cName;
		System.out.println(expected+" "+" "+result);
		
		Assert.assertEquals(result,expected,"Result's are not matched, TC Failed!!!!");
		Reporter.log("Company Creation Varification Success!!!! Test Case Passed",true);
		logger.info("Test case 2 completed");
		
	}
	
}
