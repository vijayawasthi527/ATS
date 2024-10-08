package ats_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Meeting_Page {
	
	@FindBy(xpath = "//*[@href='https://ats.aistechnolabs.pro/meetings/create']") private WebElement createMeetingButton;
	
	public Meeting_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void create_Meeting()
	{
		createMeetingButton.click();
	}

}
