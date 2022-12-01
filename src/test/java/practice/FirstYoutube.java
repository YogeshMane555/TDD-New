package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstYoutube {

	public WebDriver rm;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C://Users//chromedriver//chromedriver.exe");

		ChromeOptions co = new ChromeOptions();

		co.addArguments("incognito");

		co.addArguments("start-maximized");

		// co.addArguments("--headless");

		rm = new ChromeDriver(co);

		rm.get("https://www.youtube.com/");

	}

	@Test
	public void tc1() throws InterruptedException {
		
		Thread.sleep(4000);

		System.out.println("Current URL is :" + rm.getCurrentUrl());

		System.out.println("This is Current Title of WebPage :" + rm.getTitle());
		
		rm.findElement(By.xpath("//*[contains(@name,'search_query')]")).sendKeys("BigBoss" + Keys.ENTER);

		TakesScreenshot tk = (TakesScreenshot) rm;

		File src = tk.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src,
					new File("C://Users//Yogesh//eclipse-workspace//TDD//Screenshot//YouTubeScreenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(4000);

	}

	@AfterMethod
	public void tearDown() {
		rm.quit();
	}

}
