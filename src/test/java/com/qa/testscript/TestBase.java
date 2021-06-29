package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.YouTubePage;


public class TestBase {
	 WebDriver driver;
	 YouTubePage yt;
	 @Parameters({"Browser","url"})
	 @BeforeClass
	 public void setUp(String Browser,String url)
		{   
			
			if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		 if(url.contains("youtube"))
		 {
		    yt= new YouTubePage(driver);
			driver.get(url);
			driver.manage().window().maximize();
		 }

}
	    public void takeScreenShot(WebDriver driver, String name) throws IOException
	    {
	    	TakesScreenshot screenShot = (TakesScreenshot) driver;
	    	File Source = screenShot.getScreenshotAs(OutputType.FILE);
	    	String dest = System.getProperty("user.dir")+"/Screenshots/"+name+".png";
	    	FileUtils.copyFile(Source,new File(dest));
	    	
	    }
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}

	 }
