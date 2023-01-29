package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.SignInPage;

public class MemberStep {
	
	public WebDriver driver;
	public SignInPage signInPage;
	 
	@Before("@browserMember")
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver.exe");
		
//		ChromeOptions options = new ChromeOptions(); 
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});    
		
		driver = new ChromeDriver();
		signInPage = new SignInPage(driver);
	}
	
	@Given("User open the URL Youtube Music")
	public void user_open_the_url() {
		driver.get("https://music.youtube.com/");
	}

	@Given("User click Sign In Button")
	public void user_click_sign_in_button() {
		signInPage.clickSignIn();
	}

	@When("User enters email {string} and User click Next button")
	public void user_enters_email_and_user_click_next_button(String email) {
		signInPage.setEmail(email);
		signInPage.clickNextEmail();
		
		String title = signInPage.checkSignInCondition();
		if (title.equals("Sign in")) {
			/*blocker by browser. Couldn't sign in. */
			System.out.println("Couldn't Sign in Google");
		}
	}

	/*
	@When("User enters password {string} and User click Next button")
	public void user_enters_password_and_user_click_next_button(String password) {
	    signInPage.setPassword(password);
	    signInPage.clickNextPassword();
	}

	@Then("the logged in home page of YouTube Music is displayed")
	public void the_logged_in_home_page_of_you_tube_music_is_displayed() {
	  if(driver.getPageSource().contains("Couldn’t sign you in")) {
		  System.out.println("Gagal login");
		  driver.quit();
	  } else { 
		  System.out.println("Gagal login");
	  }
	}*/
	
}
