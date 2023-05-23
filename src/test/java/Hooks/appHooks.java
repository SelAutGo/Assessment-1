package Hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import Utilities.ConfigReader;
import Utilities.DriverFactory;
import Utilities.LoggerLoad;
import io.cucumber.java.BeforeAll;

public class appHooks {
	
	static DriverFactory driverfactory=null;
	public static WebDriver driver=null;
	
	
	public static WebDriver driver() throws Throwable
	{
		LoggerLoad.info("Loading config file");
		ConfigReader.loadConfig();
		String browser = ConfigReader.getBrowserType();
		
		driverfactory=new DriverFactory();
		driver=driverfactory.initializeDrivers(browser);
		LoggerLoad.info("Initialize driver for : "+ browser);
		return driver;
	}
	
@AfterTest
	
	public void  closeAllDrivers()
	{
		driver.quit();
	}


}
