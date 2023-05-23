package Pages;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigReader;
import Utilities.ElementUtils;

public class LoginSuccessfulPage {
	
	WebDriver driver;
	 ElementUtils elementUtil = new ElementUtils();
	String Excelpath = ConfigReader.getexcelfilepath("Login");

	public LoginSuccessfulPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h3")
	WebElement SuccessMessage;
	
	public void verifySuccessfulLogin() throws InvalidFormatException, IOException
	{ 
	
		String actualMessage = getActualResult(SuccessMessage);
		String expectedMessage=getExpectedResult("Login",1,"Result");
		
		Assert.assertEquals(actualMessage,expectedMessage,"Login Unsucessful");
	}
	public String getExpectedResult(String sheetName, Integer rowNumber,String res) throws InvalidFormatException, IOException {
		String expectedResult = elementUtil.getResultfromExcel(sheetName, rowNumber,res);
		return expectedResult;
		}
	public  String getActualResult(WebElement output) {
		elementUtil.WaitForElement(output);
		return output.getText();
		}

}
