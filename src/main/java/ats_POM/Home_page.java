package ats_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page 
{
	@FindBy (xpath = "//*[@href='https://ats.aistechnolabs.pro/client/login' and @class='btn btn-primary mx-2']") private WebElement employer_Login;

	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnClientLogin()
	{
		employer_Login.click();
	}
}


