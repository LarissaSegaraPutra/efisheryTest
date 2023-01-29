package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.Library;
import objects.MusicPlayer;

public class GuestSteps {
	
	public WebDriver driver;
	public MusicPlayer playMusic;
	public Library library;

	@Before("@browser")
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		playMusic = new MusicPlayer(driver);
		library = new Library(driver);
	}
	
	@Given("Guest user open YouTube Music")
	public void guest_user_open_you_tube_music() {
		driver.get("https://music.youtube.com/");
	}

	@When("User click the play icon from the song")
	public void user_user_click_the_play_icon_from_the_song() {
		playMusic.clickPlay();
	}

	@Then("the music is played")
	public void the_music_is_played() {
		if (playMusic.isPlayed()) {
			System.out.println("Music is playing!");
		} else {
			System.out.println("Music is not playing!");
			driver.quit();
		}		
	}

	@Then("the music player page is displayed")
	public void the_music_player_page_is_displayed() {
		if (playMusic.isMusicPlayer()) {
			System.out.println("Music Player is displayed!");
		} else {
			System.out.println("Music Player is not displayed!");
			driver.quit();
		}		
	}
	
	@When("User go to Library menu")
	public void user_go_to_library_menu() {
		library.clickLibrary();
	}

	@Then("direct to Sign In with google page")
	public void direct_to_sign_in_with_google_page() {
		if (library.emailField()) {
			System.out.println("This is Sign In Page");
		} else {
			System.out.println("This is not Sign In Page");
			driver.quit();
		}	
	}
}
