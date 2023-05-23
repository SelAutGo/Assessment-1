package stepDefinition;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import Hooks.appHooks;
import Pages.LoginPage;
import Utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionality {
	
	WebDriver driver;
    LoginPage loginPage;
    public  LoginFunctionality() throws Throwable {
    	  loginPage = new LoginPage(driver);
    	driver=Hooks.appHooks.driver();	
	}
   
	@Given("I am in NewTours Home Page")
	public void i_am_in_new_tours_home_page() throws InvalidFormatException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		String URL=ConfigReader.getLoginPage();
		driver.get(URL);
		loginPage.verifyTitle();
	    
	}
	@When("I enter username")
	public void i_enter_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("password")
	public void password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("click on Submit")
	public void click_on_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I validate that I am successfully logged in")
	public void i_validate_that_i_am_successfully_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	
}
