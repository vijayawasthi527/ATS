package ats_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_Companies_page 
{
	@FindBy(xpath = "//*[@href='https://ats.aistechnolabs.pro/companies/create']")private WebElement createCompany;
	@FindBy(xpath = "//tbody/tr[1]/td[9]/a[1]/i[1]")private WebElement companyInfoButton;
	@FindBy(xpath = "//tbody/tr[1]/td[9]/a[2]/i[1]")private WebElement companyEditButton;
	@FindBy(xpath = "//tbody/tr[1]/td[9]/button/i")private WebElement companyDeleteButton;
	@FindBy(id = "companiesDataTable_info")private WebElement showingEntriesLink;
	@FindBy(xpath = "//*[@id='companiesDataTable_previous']/a")private WebElement previousButton;
	@FindBy(xpath = "//*[@id='companiesDataTable_next']/a")private WebElement nextButton;
	@FindBy(xpath = "//*[@type='search']")private WebElement searchBox;
	@FindBy(xpath = "//*[@data-toggle='sidebar']")private WebElement menuButton;
	public Manage_Companies_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void click_CreateCompany()
	{
		createCompany.click();
	}
	
	public void company_info()
	{
		companyInfoButton.click();
	}
	
	public void company_edit()
	{
		companyEditButton.click();
	}
	
	public void company_delete()
	{
		companyDeleteButton.click();
	}
}
