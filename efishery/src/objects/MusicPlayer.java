package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusicPlayer {
	public WebDriver driver;

	public MusicPlayer(WebDriver webDriver) {
		driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(xpath = "//*[@id=\"play-button\"]/div/yt-icon")
	WebElement btnPlay;

	public void clickPlay() {
		btnPlay.click();
	}

	public boolean isPlayed() {
		boolean played = driver.findElement(By.xpath("//*[@id=\"icon\"]")).isDisplayed();
		return played;
	}
	
	public boolean isMusicPlayer() {
		boolean musicPlayer = driver.findElement(By.xpath("//*[@id=\"player\"]/div[4]")).isDisplayed();
		return musicPlayer;
	}
}
