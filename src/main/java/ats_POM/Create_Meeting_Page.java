package ats_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ats_Utility.Utility;

public class Create_Meeting_Page 
{
	@FindBy (id = "title") private WebElement createJobTitle;
	@FindBy (id = "meeting_type") private WebElement meetingType;
	@FindBy (id = "meeting_url")private WebElement meetingURL;
	@FindBy (id = "end_date_time")private WebElement meetingEndDateAndTime;
	@FindBy (xpath = "//*[@data-title='r4c6' and contains(text(),'31')]") private WebElement endDate;
	@FindBy (xpath = "(//*[@class='hourselect'])[1]")private WebElement endhours;
	@FindBy (xpath = "(//*[@class='minuteselect'])[1]")private WebElement endminutes;
	@FindBy (xpath = "(//*[@class='applyBtn btn btn-sm btn-primary'])[2]")private WebElement applyButton2;
	@FindBy (xpath = "//input[@id='start_date_time']") private WebElement startDateAndTime;
	@FindBy (xpath = "//*[@data-title='r4c6' and contains(text(),'31')]") private WebElement startDate;
	@FindBy (xpath = "(//*[@class='hourselect'])[1]")private WebElement startHours;
	@FindBy (xpath = "(//*[@class='minuteselect'])[1]")private WebElement startMinutes;
	@FindBy (xpath = "(//*[@class='applyBtn btn btn-sm btn-primary'])[1]") private WebElement applyButton1;
	@FindBy (id = "related_module") private WebElement relatedTo;
	@FindBy (id = "select2-related_module_id-container")private WebElement collaborater;
	@FindBy (xpath = "//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")private WebElement collaboratorSearchBox;
	@FindBy (xpath = "//span[@id='select2-related_module_id-container' and @role='textbox' and @aria-readonly='true']")private WebElement collabNeha;
	@FindBy (xpath = "//*[@class='select2-search__field']")private WebElement attandees;
	
	//span[@id='select2-related_module_id-container']
	
	
	public Create_Meeting_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createJob_Title(String title)
	{
		createJobTitle.sendKeys(title);
	}
	
	public void meeting_type()
	{
		meetingType.click();
		Select s=new Select(meetingType);
		s.selectByValue("Online");
	}
	
	public void meeting_url(String url)
	{
		meetingURL.sendKeys(url);
	}
	
	public void meeting_end()
	{
		meetingEndDateAndTime.click();
	}
	
	public void meeting_endDate()
	{
		endDate.click();
	}
	
	public void end_Hours()
	{
		endhours.click();
		Select s1=new Select(endhours);
		s1.selectByValue("14");
	}
	public void end_minutes()
	{
		endminutes.click();
		Select s2=new Select(endminutes);
		s2.selectByValue("45");
	}
	
	public void apply_Button2()
	{
		applyButton2.click();
	}
	
	public void meeting_start()
	{
		startDateAndTime.click();
	}
	
	public void meeting_startDate()
	{
		startDate.click();
	}
	public void start_hours()
	{
		startHours.click();
		Select s3=new Select(startHours);
		s3.selectByValue("14");
	}
	public void start_minutes()
	{
		startMinutes.click();
		Select s4=new Select(startMinutes);
		s4.selectByValue("15");
	}
	
	public void apply_Button1()
	{
		applyButton1.click();
	}
	
	public void related_to()
	{
		relatedTo.click();
		Select s5=new Select(relatedTo);
		s5.selectByValue("2");
	}
	
	public void collaborator_click() throws InterruptedException
	{
		collaborater.click();
		collaboratorSearchBox.sendKeys("n");
		Utility.wait(5000);
		collabNeha.click();
	}
	
	

}
