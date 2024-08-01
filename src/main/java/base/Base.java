package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base 
{
	static protected WebDriver driver;
	//open browser
	
	public void launchATS() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching Browser",true);
		driver.get("https://ats.aistechnolabs.pro/");
		Thread.sleep(2000);
	}
	
	//now closing the browser
	
	public void closeATS() throws InterruptedException
	{
		Reporter.log("Closing the browser",true);
		Thread.sleep(1000);
		driver.close();
	}

}
