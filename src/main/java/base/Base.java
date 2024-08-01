package base;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class Base {
	
	static protected WebDriver driver;
	
	public void launchATS() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching the Chrome Browser");
		driver.get("https://ats.aistechnolabs.pro/");
		Thread.sleep(2000);
	}
	
	public void closeBrowser() throws InterruptedException
	{
		Reporter.log("Closing the browser");
		Thread.sleep(1000);
		driver.close();
	}
	
	

}
