package ats_POM;

import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import ats_Utility.Utility;
//import base.Base;




public class DashBoard_Page 
{
	
	@FindBy (xpath = "//*[@data-toggle='sidebar']") private WebElement menuOpen;
	@FindBy (xpath = "//*[@class='sidebar-menu']/li[11]") private WebElement TaskAndMeetings;
	@FindBy (xpath = "//*[@href='https://ats.aistechnolabs.pro/meetings' and @class='nav-link']") private WebElement meetings;
	@FindBy (xpath = "(//*[@class='nicescroll-cursors'])[1]")private WebElement leftSlider;
	@FindBy (xpath = "//span[normalize-space()='Task & Meetings']")private WebElement Taskm;
	@FindBy (xpath = "//*[@href='https://ats.aistechnolabs.pro/clients']")private WebElement clientClick;
	@FindBy(xpath = "//*[@href='https://ats.aistechnolabs.pro/companies']")private WebElement companies;
	
	
	
	
	public DashBoard_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickMenuOption()
	{
		menuOpen.click();
	}
	public void click_Companies()
	{
		companies.click();
	}
	
	public void clickTaskMeetings()
	{
		TaskAndMeetings.click();
	}
	
	public void left_slider(WebDriver driver)
	{
		leftSlider.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Taskm);
		
		//Actions act=new Actions(driver);
		//act.moveToElement(Taskm).build().perform();
		
	}
	
	
	public void clickMeetings()
	{
		meetings.click();
	}
	
	public void clickOnClient()
	{
		clientClick.click();
	}
	
	
	
	
}
