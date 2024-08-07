package ats_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.io.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.util.Date;
import java.util.Properties;
import base.Base;


public class Utility extends Base
{
	public static String readingDataFromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Reading data from excelsheet",true);
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ATS_LoginDetails.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static void scrolling(int x,int y) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
	
	public static void wait(int k) throws InterruptedException
	{
		Thread.sleep(k);
	}
	
	public static void takeScreenShot(WebDriver driver,String TCID) throws IOException
	{
		Reporter.log("Taking ScreenShot",true);
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\vijay\\Desktop\\Class Notes\\Practice Work\\ATS"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved ScreenShot at"+dest,true);
		FileHandler.copy(src, dest);
		
	}
	
	public static String propertyFileData(String key) throws InterruptedException, IOException
	{
		Properties prop=new Properties();
		Thread.sleep(1000);
		
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\ATSData.Properties");
		prop.load(myFile);
		Thread.sleep(1000);
		
		String value=prop.getProperty(key);
		return value;
	}
	
	
	
	
}
