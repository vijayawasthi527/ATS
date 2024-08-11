package ats_Test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ats_POM.Client_Page;
import ats_POM.Company_Create;
import ats_POM.Company_Details_page;
import ats_POM.Create_Meeting_Page;
import ats_POM.DashBoard_Page;
import ats_POM.Home_page;
import ats_POM.Login_Page;
import ats_POM.Manage_Companies_page;
import ats_POM.Meeting_Page;
import ats_Utility.Utility;
import base.Base;


public class ATS_Super_Admin extends Base
{
	public static Logger logger;
	Home_page homepage;
	Login_Page loginpage;
	DashBoard_Page dashBoard;
	Meeting_Page meetingPage;
	Create_Meeting_Page createJob;
	Client_Page createclient;
	Company_Create createCompany;
	Manage_Companies_page manageCompanies;
	Company_Details_page companyDetails;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		logger=Logger.getLogger("ATS_Project");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
				
	}
	
	@BeforeMethod
	public void startupProcess() throws InterruptedException, EncryptedDocumentException, IOException
	{
		launchATS();
		homepage=new Home_page(driver);
		loginpage=new Login_Page(driver);
		dashBoard=new DashBoard_Page(driver);
		meetingPage=new Meeting_Page(driver);
		createJob=new Create_Meeting_Page(driver);
		createclient=new Client_Page(driver);
		createCompany=new Company_Create(driver);
		manageCompanies=new Manage_Companies_page(driver);
		companyDetails=new Company_Details_page(driver);
		
		Utility.wait(1500);
		Utility.scrolling(0,400);
		Utility.wait(2000);
		homepage.clickOnClientLogin();
		
		loginpage.enterEmail(Utility.readingDataFromExcel(2,0));
		loginpage.enterpassword(Utility.readingDataFromExcel(2,1));
		loginpage.clickSigninButton();
		
		Utility.wait(4000);
		dashBoard.clickMenuOption();
	}
	
	@Test
	public void superAdmin_CompanyCreation() throws InterruptedException
	{
		Utility.wait(1500);
		dashBoard.click_Companies();
		Reporter.log("Clicked on Comapnies",true);
		Utility.wait(1500);
		manageCompanies.click_CreateCompany();
		Reporter.log("Clicked on Create Company",true);
		Utility.wait(1500);
		createCompany.enter_CompanyName(Utility.companyName());
		Reporter.log("Entered Company Name",true);
		Utility.wait(1500);
		createCompany.enter_CompanyEmail(Utility.emailAddress());
		Reporter.log("Entered Company Email ID",true);
		Utility.wait(1500);
		createCompany.enter_CompanyPhone(Utility.phone());
		Reporter.log("Entered Company's Phone Number",true);
		Utility.wait(1500);
		createCompany.enter_CompanyWebsite(Utility.companyURl());
		Reporter.log("Entered Company's Website",true);
		Utility.wait(1500);
		createCompany.click_DefaultTimeZone();
		createCompany.select_Timezone(driver);
		Reporter.log("Selected Company's TimeZone",true);
		Utility.wait(1500);
		createCompany.click_ChangeLanguage();
		createCompany.select_language(driver);
		Reporter.log("Selected Company's Language",true);
		Utility.scrolling(0,300);
		Utility.wait(1500);
		createCompany.click_Currencyselect();
		createCompany.select_Currency(driver);
		Reporter.log("Selected Company's Currency",true);
		Utility.wait(1500);
		createCompany.click_Default();
		Reporter.log("Clicked on Default CheckBox",true);
		Utility.wait(1500);
		createCompany.enter_CompanyAddress(Utility.company_Address());
		Reporter.log("Entered Company's Address",true);
		Utility.wait(1500);
		createCompany.enter_Latitude();
		Reporter.log("Entered Company's Latitude",true);
		Utility.wait(1500);
		createCompany.enter_Longitude();
		Reporter.log("Entered Company's Longitude",true);
		Utility.wait(1500);
		Utility.scrolling(0,300);
		Utility.wait(1500);
	//	createCompany.click_Logo(System.getProperty("user.dir")+"\\src\\test\\resources\\logonew.jpg");
	//	Reporter.log("Attaching Company's Logo",true);
		Utility.wait(1500);
	//	createCompany.click_favicon(System.getProperty("user.dir")+"\\src\\test\\resources\\NewFavicon.png");
	//	Reporter.log("Attaching Company's Favicon",true);
		Utility.wait(1500);
		createCompany.enter_password(Utility.password());
		Reporter.log("Entered Password",true);
		Utility.wait(1500);
		createCompany.confirm_Passwd(Utility.confirm_Password());
		Reporter.log("Entered Confirmed Password",true);
		Utility.wait(1500);
		Utility.scrolling(0,200);
		createCompany.click_Submit();
		Reporter.log("Clicked on Submit Button",true);
		Thread.sleep(15000);
		createCompany.allcomapanies();
		Reporter.log("Clicked on All Companies Button",true);
		Utility.wait(5000);
		String expectedresult=createCompany.firstCompanyInList();
		String actualresult=Utility.cName;
//		SoftAssert s=new SoftAssert();
//		s.assertEquals(actualresult,expectedresult,"Test case Failed!!!!");
		Assert.assertEquals(expectedresult,actualresult,"TC Failed");
		
		Utility.wait(5500);
		driver.close();
		
	
	}
	
	@Test
	public void superAdmin_viewEditDeleteCompany() throws InterruptedException
	{
		Utility.wait(1500);
		dashBoard.click_Companies();
		Reporter.log("Clicked on Comapnies",true);
		Utility.wait(1500);
		manageCompanies.company_info();
		Reporter.log("Clicked on View Company Info");
		Utility.wait(1500);
		Utility.scrolling(0,200);
		Utility.wait(4000);
		Utility.scrolling(0,200);
		Utility.wait(4000);
		Utility.scrolling(0,-500);
		Utility.wait(1500);
		companyDetails.click_userTab();
		Utility.scrolling(0,400);
		Utility.wait(1500);
		companyDetails.click_ordersTab();
		Utility.wait(1500);
		Utility.scrolling(0,400);
		Utility.wait(1500);
		companyDetails.click_allCompanies();
		Utility.wait(1500);
	}

}
