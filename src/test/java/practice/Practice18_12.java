package practice;

import java.awt.Dimension;
import java.awt.Point;
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

public class Practice18_12 {

	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("incognito");
		
		co.addArguments("start-maximized");
		
		rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test
	public void tc1() throws InterruptedException
	{
		
		WebElement radio=rm.findElement(By.xpath("//*[contains(@value,'radio1')]"));
	
		radio.click();
		
		Thread.sleep(4000);
		
		org.openqa.selenium.Point p=radio.getLocation();
		
		int toptobottom=p.getX();
	
		int lefttoright=p.getY();
		
		System.out.println("Top to bottom :" +toptobottom);
		
		System.out.println("Left to Right :" +lefttoright);
		
		Thread.sleep(4000);
		
		boolean b=radio.isSelected();
		
		System.out.println("Is Radio button 1 selected :" +b);	
		
		Thread.sleep(4000);
		
		String Text=radio.getText();
		
		System.out.println("Value of Radio button 1 :" +Text);
		
		org.openqa.selenium.Dimension d=radio.getSize();
		
		int height=d.height;
		
		int width=d.width;
		
		System.out.println("Heigh of WebElement :"+height);
		
		System.out.println("Width of WebElement :"+width);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//P18_12Radio.png"));
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
