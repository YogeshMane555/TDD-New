package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practice15_12 {
	
	public WebDriver rm;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver//chromedriver.exe");
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("Incognito");
		
		co.addArguments("start-maximixed");
		
		rm=new ChromeDriver(co);
		
		rm.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Test
	public void tc1()
	{
		
		WebElement r1=rm.findElement(By.xpath("//*[contains(@value,'radio1')]"));
		
		r1.click();
		
		boolean b=r1.isSelected();
		
		System.out.println("Is Radio button 1 Selected ?:" +b);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDonw()
	{
		rm.quit();
	}

}
