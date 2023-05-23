package Utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {
	
	public static String browserType=null;
	private static final String propertyFilePath="src/test/resources/config.properties";
	static Properties properties;
	static String excelfilelpath =null;
	
	public static void setBrowserType(String browser)
	{
		browserType = browser;
	}

	public static String getBrowserType() throws Throwable
	{
		String browser = properties.getProperty("browser");
		LoggerLoad.info("Get property BrowserType");
		if (browser != null)
		return browser;
		else
		throw new RuntimeException("Browser not specified in the Configuration.properties file.");
		}
	

	public static void loadConfig() {
		try
		{FileInputStream stream = new FileInputStream(propertyFilePath);
		properties = new Properties();
		try {
		properties.load(stream);
		stream.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		
	}
	public static String getexcelfilepath(String area) {
		loadConfig();
		if(area.equalsIgnoreCase("Login")) {
			excelfilelpath = properties.getProperty("excelfilepathforLogin");
			System.out.println(excelfilelpath);
			return excelfilelpath;
		}
	else 
	{
				throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
		}
	}
	public static String getLoginPage() {
		
		String loginURL = properties.getProperty("loginpage");
		if(loginURL!= null)
		{
			return loginURL;
		}
		else {
			throw new RuntimeException("URL not found in configurations file.");
		}
		
		
	}

}
