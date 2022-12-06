package practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
	public void tc2() throws InterruptedException
	{
		rm.findElement(By.xpath("//*[contains(@id,'autocomplete')]")).sendKeys("bi");
		
		Thread.sleep(4000);
		
		List<WebElement> auto=rm.findElements(By.xpath("//*[contains(@class,'ui-menu-item')]"));
		
		int sizeOfAuto=auto.size();
		
		System.out.println("Total Number of List is :" +sizeOfAuto);
		
		for(WebElement sug:auto)
		{
			String SuggestionList=sug.getText();
			
			System.out.println("AutoSuggestion Text are :" +SuggestionList);
			
		}
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//AutoSuggestionList.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc3() throws InterruptedException
	{
		WebElement drpdwn= rm.findElement(By.xpath("//*[contains(@id,'dropdown-class-example')]"));
		
		Select s=new Select(drpdwn);
		
		s.selectByVisibleText("Option2");
		
		Thread.sleep(4000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
		
		File src=tk.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//DropDownScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void tc4() throws InterruptedException
	{
		WebElement check= rm.findElement(By.xpath("//*[contains(@id,'checkBoxOption2')]"));
		
		check.click();
		
		boolean b2=check.isSelected();
		
		System.out.println("Is Checkbox value 2 Selected ? :"+ b2);
		
		Thread.sleep(4000);
		
		TakesScreenshot tk=(TakesScreenshot)rm;
	
		File src=tk.getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(src, new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//CheckBoxScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tc5() throws InterruptedException
	{
		List<WebElement> list=rm.findElements(By.tagName("a"));
		
		int totalNumber=list.size();
		
		System.err.println("Total Number of Links :" +totalNumber);
		
		Thread.sleep(3000);
		
		for(WebElement link:list)
		{
			String Text=link.getText();
			
			System.out.println("Link text are as follows :" +Text);
		}
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		rm.quit();
	}
	
	
	
}
