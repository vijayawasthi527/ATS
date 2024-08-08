package ats_POM;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Client_Page 
{
	@FindBy(xpath = "//*[@href='https://ats.aistechnolabs.pro/clients/create']")private WebElement createClient;
	@FindBy(id = "name")private WebElement client_Name;
	@FindBy(id = "number")private WebElement client_MoblieNumber;
	@FindBy(id = "fax")private WebElement client_Fax;
	@FindBy(id = "website")private WebElement client_Website;
	@FindBy(xpath = "(//*[@class='select2-selection select2-selection--single' and @role='combobox'])[1]")private WebElement client_IndustrySelect;
	@FindBy(xpath = "//*[@class='select2-search__field']")private WebElement client_Industry_suggestions;
	@FindBy(xpath = "(//*[@class='select2-selection select2-selection--single'])[2]")private WebElement client_Source_DropDown;
	@FindBy(xpath = "//*[@class='select2-search__field']")private WebElement sourceSuggestion;
	@FindBy(xpath = "//*[@class='note-editable card-block']")private WebElement aboutClient;
	@FindBy(id = "billing_street")private WebElement billingStreet;
	@FindBy(id = "billing_city")private WebElement billingCity;
	@FindBy(id = "billing_state")private WebElement billingState;
	@FindBy(id = "billing_code")private WebElement billingCode;
	@FindBy(id = "select2-billing_country_id-container")private WebElement countryDropdown;
	@FindBy(xpath = "//*[@class='select2-search__field']")private WebElement countrySuggestion;
	@FindBy(xpath = "//*[@id='same_as_billing_address']")private WebElement sameAddressCheckBox;
	@FindBy(xpath = "(//*[@class='col-12 col-md-6 col-lg-6'])[19]/div/input[@id='attached_contract']")private WebElement attachContract;
	@FindBy(xpath = "(//*[@class='col-12 col-md-6 col-lg-6'])[20]/div/input[@class='form-control-file']")private WebElement attachOther;
	@FindBy(xpath = "//*[@class='btn btn-primary btn-lg mr-1']/i")private WebElement submitButton;
	@FindBy(xpath = "(//*[@href='https://ats.aistechnolabs.pro/clients'])[2]")private WebElement AllClients;
	@FindBy(xpath = "//*[@id='clientsDataTable']/thead/following-sibling::tbody/tr/td/following-sibling::td")private WebElement firstClientInList;
	
	
	public Client_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickCreateNew()
	{
		createClient.click();
	}
	
	public void enterName(String name)
	{
		client_Name.sendKeys(name);
	}
	
	public void enterNumber(String number)
	{
		client_MoblieNumber.sendKeys(number);
	}
	
	public void enterFax(String fax)
	{
		client_Fax.sendKeys(fax);
	}
	
	public void enterWebsite(String website)
	{
		client_Website.sendKeys(website);
	}
	
	public void industrySelect()
	{
		client_IndustrySelect.click();
	}
	
	public void industrySuggetion(WebDriver driver)
	{
		Actions act1=new Actions(driver);
		
		act1.moveToElement(client_Industry_suggestions).sendKeys("IT").sendKeys(Keys.ENTER).build().perform();
	}
	
	public void sourceSelect()
	{
		client_Source_DropDown.click();
	}
	
	public void sourceSuggestion(WebDriver driver)
	{
		Actions act2=new Actions(driver);
		act2.moveToElement(sourceSuggestion).sendKeys("client-s").sendKeys(Keys.ENTER).build().perform();
	}
	
	public void about(String clientinfo)
	{
		aboutClient.sendKeys(clientinfo);
	}
	
	public void street(String billing_Street)
	{
		billingStreet.sendKeys(billing_Street);
	}
	
	public void city(String billing_city)
	{
		billingCity.sendKeys(billing_city);
	}
	
	public void state(String billing_state)
	{
		billingState.sendKeys(billing_state);
	}
	
	public void code(String billing_code)
	{
		billingCode.sendKeys(billing_code);
	}
	
	public void country()
	{
		countryDropdown.click();
	}
	
	public void countrySugest(WebDriver driver)
	{
		Actions act3=new Actions(driver);
		act3.moveToElement(countrySuggestion).sendKeys("india").sendKeys(Keys.ENTER).build().perform();
	}
	
	public void sameAddress()
	{
		sameAddressCheckBox.click();
	}
	
	public void upload1(String contract)
	{
		attachContract.sendKeys(contract);
	}
	
	public void upload2(String other)
	{
		attachOther.sendKeys(other);
	}
	
	public void submitaction()
	{
		submitButton.click();
	}
	
	public void allClient()
	{
		AllClients.click();
	}
	
	public String firstClient()
	{
		String fclient=firstClientInList.getText();
		return fclient;
	}
	
}
