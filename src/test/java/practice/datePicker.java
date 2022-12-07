package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class datePicker {
	
	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("Incognito");
		
		co.addArguments("start-maximized");
		
		rm=new ChromeDriver(co);
				
		rm.get("https://jqueryui.com/datepicker/");
		
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		Thread.sleep(4000);
		
		JavascriptExecutor js=(JavascriptExecutor)rm;
		
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(4000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\Yogesh\\eclipse-workspace\\TDD\\Screenshot//JavaScriptExecutor.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		rm.quit();
	}
	

}
