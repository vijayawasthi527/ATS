package ats_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company_Create
{
	@FindBy(xpath = "//*[@href='https://ats.aistechnolabs.pro/companies/create']")private WebElement createCompany;
	@FindBy(id = "compavalny_name")private WebElement companyName;
	@FindBy(id = "email")private WebElement companyEmail;
	@FindBy(id = "phone")private WebElement companyPhone;
	@FindBy(id = "website")private WebElement companyWebsite;
	@FindBy(xpath = "(//*[@class='select2-selection select2-selection--single'])[1]")private WebElement default_Timezone;
	@FindBy(xpath = "(//*[@class='select2-search__field'])[1]")private WebElement timezone_Suggestion;
	@FindBy(id = "select2-locale_language-container")private WebElement changeLanguageDropdown;
	@FindBy(xpath = "(//*[@class='select2-search__field'])[1]")private WebElement changeLanguageSuggestion;
	@FindBy(id = "select2-currency_id-container")private WebElement currencyDropdown;
	@FindBy(xpath = "(//*[@class='select2-search__field'])[1]")private WebElement currencySuggestion;
	@FindBy(id = "default_setup")private WebElement defaultSetupButton;
	@FindBy(xpath = "//*[@class='note-editable card-block']")private WebElement companyAddress;
	@FindBy(id = "latitude")private WebElement latitude;
	@FindBy(id = "longitude")private WebElement longitude;
	@FindBy(id = "logo")private WebElement logo;
	@FindBy(id = "favicon")private WebElement favicon;
	@FindBy(id = "password")private WebElement password;
	@FindBy(id = "confirm_password")private WebElement confirmPasssword;
	@FindBy(xpath = "//*[@class='btn btn-primary btn-lg mr-1']")private WebElement submitButton;
	@FindBy(xpath = "(//*[@href='https://ats.aistechnolabs.pro/companies'])[1]")private WebElement allCompanieslist;
	@FindBy(xpath = "//*[@id='companiesDataTable']/tbody/tr/td[3]")private WebElement listFirstCompany;
	public String firstcompanyName;
	public Company_Create(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enter_CompanyName(String cName)
	{
		companyName.sendKeys(cName);
	}
	
	public void enter_CompanyEmail(String cEmail)
	{
		companyEmail.sendKeys(cEmail);
	}
	
	public void enter_CompanyPhone(String cPhone)
	{
		companyPhone.sendKeys(cPhone);
	}
	
	public void enter_CompanyWebsite(String cWebsite)
	{
		companyWebsite.sendKeys(cWebsite);
	}
	public void click_DefaultTimeZone()
	{
		default_Timezone.click();
	}
	
	public void select_Timezone(WebDriver driver)
	{
		timezone_Suggestion.sendKeys("Asia/Kolkata");
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void click_ChangeLanguage()
	{
		changeLanguageDropdown.click();
	}
	
	public void select_language(WebDriver driver)
	{
		changeLanguageSuggestion.sendKeys("English");
		Actions act2=new Actions(driver);
		act2.keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void click_Currencyselect()
	{
		currencyDropdown.click();
	}
	public void select_Currency(WebDriver driver)
	{
		currencySuggestion.sendKeys("INR");
		Actions act3=new Actions(driver);
		act3.keyDown(Keys.ENTER).release().build().perform();
	}
	
	public void click_Default()
	{
		if(!(defaultSetupButton.isSelected()))
		{
		defaultSetupButton.click();
		}
	}
	
	public void enter_CompanyAddress(String cAddress)
	{
		companyAddress.sendKeys(cAddress);
	}
	public void enter_Latitude()
	{
		latitude.sendKeys("23.00972000");
	}
	public void enter_Longitude()
	{
		longitude.sendKeys("72.50231000");
	}
	
	public void click_Logo(String Logo)
	{
		logo.sendKeys(Logo);
	}
	public void click_favicon(String Favicon)
	{
		favicon.sendKeys(Favicon);
	}
	
	public void enter_password(String passwd)
	{
		password.sendKeys(passwd);
	}
	
	public void confirm_Passwd(String rePasswd)
	{
		confirmPasssword.sendKeys(rePasswd);
	}
	public void click_Submit()
	{
		submitButton.click();
	}
	public void allcomapanies()
	{
		allCompanieslist.click();
	}
	public String firstCompanyInList()
	{
		 firstcompanyName=listFirstCompany.getText();
		return firstcompanyName;
	}
}
