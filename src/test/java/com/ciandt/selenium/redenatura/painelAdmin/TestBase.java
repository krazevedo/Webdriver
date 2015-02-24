package com.ciandt.selenium.redenatura.painelAdmin;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ciandt.selenium.redenatura.helpers.ScreenshotRule;

public class TestBase {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@Rule
	public ScreenshotRule screenshotRule = new ScreenshotRule();
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.ie.driver", "C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Drive\\chromedriver.exe");
		//driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getFirefoxDriver() {
        return driver;
    }
}
