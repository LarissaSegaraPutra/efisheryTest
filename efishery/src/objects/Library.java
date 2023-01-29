package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Library {
	
	public WebDriver driver;

	public Library(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"layout\"]/ytmusic-nav-bar/div[2]/ytmusic-pivot-bar-renderer/ytmusic-pivot-bar-item-renderer[3]/yt-formatted-string")
	WebElement btnLibrary;
	
	public void clickLibrary() {
		btnLibrary.click();
	}
	
	public boolean emailField() {
		boolean email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).isDisplayed();
		return email;
	}
}
