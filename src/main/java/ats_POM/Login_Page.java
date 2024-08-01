package ats_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	
	@FindBy(xpath = "//*[@id='email']")private WebElement emailid;
	@FindBy(xpath = "//*[@id='password']")private WebElement password;
	@FindBy(xpath = "//*[@class='btn btn-primary w-100']")private WebElement signinButton;
	
	
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmail(String emailID)
	{
		emailid.sendKeys(emailID);
	}
	public void enterpassword(String enterpassword)
	{
		password.sendKeys(enterpassword);
	}
	
	public void clickSigninButton()
	{
		signinButton.click();
	}

}
