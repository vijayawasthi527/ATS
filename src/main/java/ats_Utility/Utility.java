package ats_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.Base;
import io.reactivex.rxjava3.functions.Action;

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
	
	
	
	
}
