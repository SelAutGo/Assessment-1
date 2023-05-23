package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver initializeDrivers(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome"))
		{
		  LoggerLoad.info("Testing on Chrome");
		 // WebDriverManager.chromedriver().setup();
		  

		//WebDriverManager.chromedriver().clearDriverCache();
		//WebDriverManager.chromedriver().clearResolutionCache();
		WebDriverManager.chromedriver().browserVersion("113.0.5672.127").setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.setAcceptInsecureCerts(true);
		chromeOptions.setScriptTimeout(Duration.ofSeconds(30));
		chromeOptions.setPageLoadTimeout(Duration.ofMillis(30000));
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(20));
		chromeOptions.addArguments("--remote-allow-origins=*");	 
		driver =new ChromeDriver(chromeOptions);

driver.manage().deleteAllCookies();
driver.get("chrome://settings/clearBrowserData");
driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		  
		
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
		  LoggerLoad.info("Testing on Firefox");
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("Edge"))
		{
		  LoggerLoad.info("Testing on Edge");
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

}
