package ats_POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page 
{
	WebDriver driver;
	
	@FindBy (xpath = "//*[contains(text(),'Employer Login') and @href='https://ats.aistechnolabs.pro/client/login']") private WebElement clientLogin;
	
	@FindBy (xpath = "//*[contains(text(),'Candidate Login')]") private WebElement candidateLogin;
	
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public String validateTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public void clickOnClientLogin() throws InterruptedException
	{
		
		Thread.sleep(1000);
		clientLogin.click();
	}
	
	
	

	

}
