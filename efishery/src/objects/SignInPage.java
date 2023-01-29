package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class SignInPage {
	public WebDriver driver;
	
	public SignInPage(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"right-content\"]/a")
	WebElement btnSignIn;
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement btnNextEmail;
	
	@FindBy(xpath="//*[@id=\"passwordNext\"]/div/button/div[3]")
	WebElement btnNextPassword;
	
	@FindBy(xpath="//*[@id=\"headingText\"]/span")
	WebElement title;
			
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		btnSignIn.click();
	}
	
	public void clickNextEmail() { 
		btnNextEmail.click();
	}
	
	public void clickNextPassword() { 
		btnNextPassword.click();
	}
	
	public String checkSignInCondition() {
		return title.getText();
	}
}
