package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="firstName")
	WebElement firstName;
	

	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(name="phone")
	WebElement phone;
	

	@FindBy(name ="userName")
	WebElement email;
	

	@FindBy(name="address1")
	WebElement address;
	

	@FindBy(name="city")
	WebElement city;
	

	@FindBy(name="state")
	WebElement state;
	

	@FindBy(name="postalCode")
	WebElement postalCode;
	

	@FindBy(name="country")
	WebElement country;
	

	@FindBy(id="email")
	WebElement userName;
	

	@FindBy(name="password")
	WebElement password;
	

	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	

	@FindBy(name="submit")
	WebElement submit;
	
	
}
