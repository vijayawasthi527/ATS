package ats_POM;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	
	@FindBy (id = "email") private WebElement emailField;
	@FindBy (id = "password") private WebElement passwordfield;
	@FindBy (xpath = "//*[contains(text(),'Sign in')]") private WebElement signInButton;
	@FindBy (name = "remember") private WebElement rememberCheckBox;
	@FindBy (xpath = "//*[contains(text(),'Forgot Your Password?')]") private WebElement forgetPassword;
	@FindBy (id = "client") private WebElement clientButton;
	@FindBy (id = "candidate") private WebElement candidateButton;
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickSigninButton()
	{
		signInButton.click();
	}
	
	public void clickForgetPassword()
	{
		forgetPassword.click();
	}
	
	public void clickOnClientButton()
	{
		clientButton.click();
	}
	
	public void clickOnCandidateButton()
	{
		candidateButton.click();
	}
	
	public void enterEmail(String emailid)
	{
		emailField.sendKeys(emailid);
	}
	
	public void enterpassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	
	

}
