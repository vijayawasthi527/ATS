package ats_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company_Details_page 
{
	@FindBy(id = "company-users-tab")private WebElement usersTab;
	@FindBy(id = "orders-tab")private WebElement ordersTab;
	@FindBy(xpath = "(//*[@href='https://ats.aistechnolabs.pro/companies'])[2]")private WebElement allCompaniesButton;
	@FindBy(xpath = "(//*[@href='https://ats.aistechnolabs.pro/companies'])[2]/following-sibling::a")private WebElement editButton;
	@FindBy(xpath = "//*[@name='DataTables_Table_0_length']")private WebElement showEntriesDropdown;
	@FindBy(xpath = "(//*[@type='search'])[1]")private WebElement searchBox;
	@FindBy(xpath = "//*[@id='DataTables_Table_0_info']")private WebElement totalEntriesText;
	@FindBy(xpath = "//*[@id='DataTables_Table_0_previous']")private WebElement previousButton;
	@FindBy(xpath = "//*[@id='DataTables_Table_0_next']")private WebElement nextButton;
	@FindBy(id = "details-tab")private WebElement detailsTab;
	@FindBy (xpath = "//*[@data-toggle='sidebar']") private WebElement menuOpen;
	
	public Company_Details_page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void click_userTab()
	{
		usersTab.click();
	}
	
	public void click_ordersTab()
	{
		ordersTab.click();
	}
	
	public void click_allCompanies()
	{
		allCompaniesButton.click();
	}
}
