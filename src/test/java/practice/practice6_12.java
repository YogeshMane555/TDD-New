package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice6_12 {

	public WebDriver rm;
	
	@BeforeMethod
	public void seyUp()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("Incognito");
		
		co.addArguments("start-maximized");
		
		rm=new ChromeDriver(co);
				
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		WebElement radio2= rm.findElement(By.xpath("//*[contains(@value,'radio2')]"));
		
	    radio2.click();
		
		Thread.sleep(5000);
		
		Boolean b=radio2.isSelected();
		
		System.out.println("Is Radio button value 2 Selected ? :" +b);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//RadioButtonScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tc2()
	{
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		rm.quit();
	}
	
	
	
}
