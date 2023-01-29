@browser
Feature: Guest

@play
Scenario: User can play the music
	Given Guest user open YouTube Music 
	When User click the play icon from the song
	Then the music is played 
	And the music player page is displayed
	
#makesure user is guest user
@library
Scenario: Guest user cannot access Library
	Given Guest user open YouTube Music 
	When User go to Library menu
	Then direct to Sign In with google page