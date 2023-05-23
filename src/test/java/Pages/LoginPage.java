package Pages;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigReader;
import Utilities.ElementUtils;
import constants.Constants;

public class LoginPage {
	WebDriver driver;
	private final static String propertyFilePath="src/test/resources/config.properties";
	private static Properties properties;
	
	static ElementUtils elementUtil = new ElementUtils();
	String Excelpath = ConfigReader.getexcelfilepath("Login");
	static WebElement output;
	
	//String URL=ConfigReader.getLoginPage();
	
	
	public LoginPage(WebDriver driver) throws Throwable
	{
		this.driver=Hooks.appHooks.driver();
		PageFactory.initElements(driver,this);
		ConfigReader.loadConfig();
		//driver.get(URL);
		
	}
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(name="submit")
	WebElement submit;
	
	@FindBy(xpath="//*[contains(text(),'REGISTER')]")
	WebElement register;
	
	public void enterUserName()
	{
		Constants.userName=properties.getProperty("username");
		
		userName.sendKeys(Constants.userName);
	}
	public void enterPassword()
	{
		Constants.password=properties.getProperty("password");
		userName.sendKeys(Constants.password);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	public void clickRegisterCTA()
	{
		register.click();
	}
	
	public void verifyTitle() throws InvalidFormatException, IOException
	{
		String expectedRes=getExpectedResult("Login",1,"Title of Login Page");
		String actualRes=driver.getTitle();
		Assert.assertEquals(expectedRes,actualRes,"Home page did not open correctly.");
	}
	public static String getExpectedResult(String sheetName, Integer rowNumber,String res) throws InvalidFormatException, IOException {
		String expectedResult = elementUtil.getResultfromExcel(sheetName, rowNumber,res);
		return expectedResult;
		}
	public static String getActualResult() {
		elementUtil.WaitForElement(output);
		return output.getText();
		}
	
	
	
	
	
	

}
