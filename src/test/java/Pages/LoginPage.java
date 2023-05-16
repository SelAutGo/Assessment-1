package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(name="submit")
	WebElement submit;
	
	@FindBy(xpath="//*[contains(text(),'REGISTER')]")
	WebElement register;
	
	public void enterUserName(String username)
	{
		userName.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		userName.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	public void clickRegisterCTA()
	{
		register.click();
	}
	
	
	
	
	
	
	
	
	

}
