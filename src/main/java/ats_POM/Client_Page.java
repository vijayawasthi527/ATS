package ats_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	@FindBy(xpath = "//*[@id='same_as_billing_address")private WebElement sameAddressCheckBox;
	@FindBy(xpath = "(//*[@class='col-12 col-md-6 col-lg-6'])[19]/div/input[@id='attached_contract']")private WebElement attachContract;
	@FindBy(xpath = "(//*[@class='col-12 col-md-6 col-lg-6'])[20]/div/input[@class='form-control-file']")private WebElement attachOther;
	@FindBy(xpath = "//*[@class='btn btn-primary btn-lg mr-1']/i")private WebElement submitButton;
	@FindBy(xpath = "(//*[@href='https://ats.aistechnolabs.pro/clients'])[2]")private WebElement AllClients;
	@FindBy(xpath = "//*[@id='clientsDataTable']/thead/following-sibling::tbody/tr/td/following-sibling::td")private WebElement firstClientInList;
	
	
	
}
