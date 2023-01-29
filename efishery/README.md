# eFishery Skill Task (Youtube Music)
Script Automation ini menggunakan Selenium Java Cucumber, dibagi menjadi 2 feature yaitu guest user dan member user.

- Dependencies
- Cara Install
- Cara menjalankan Test Case
- Hasil report

## Dependencies
```
junit
selenium-java
cucumber-junit
cucumber-java
gherkin
```

## Cara Install

Install Eclipse IDE, lalu klik Help > Install New Software > Add
Input pada Location dan beri nama Cucumber
```
https://cucumber.github.io/cucumber-eclipse-update-site-snapshot
```

Kemudian check di ‘Cucumber Eclipse Plugin’ dan klik Next > Finish

Cucumber Eclipse Plugin sedang diinstall. Jika muncul warning message, klik OK.

Restart Eclipse > Yes

---
Note :
- Setelah membuat Project pada Eclipse, download https://chromedriver.chromium.org/ dan masukkan chromedriver.exe pada folder Driver. Pada project ini, menggunakan chromedriver 108.

- Download .jar files (cucumber-junit, cucumber-java, junit, gherkin, selenium-java) lalu klik kanan di project name, Build Path > Configure Build Path > Add External JARs.

## Cara menjalankan Test Case
Buat file member.feature yang berisi Skenario untuk tipe user member.
```
@browserMember
Feature: Member
Scenario: Successful log in to Youtube Music
	Given User open the URL Youtube Music
	And User click Sign In Button
	When User enters email "alodoktertiga@gmail.com" and User click Next button
	And User enters password "password" and User click Next button
	Then the logged in home page of YouTube Music is displayed
```

dan file guest.feature yang berisi Skenario untuk tipe guest user.
```
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
```

Buat object files yang berisi element dan apa yang bisa dilakukan pada object tersebut : 
- SignInPage.java
- Library.java
- MusicPlayer.java

Buat stepDefinition files yang menjelaskan langkah-langkah sesuai skenario file.
- GuestSteps.java
- MemberStep.java

Buat testRun file yang berisi : 
- TestRunGuest.java
- TestRunMember.java

---
Cara menjalankan testcase : 
Buka file feature, misalnya guest.feature lalu klik kanan > Run As Cucumber Feature

## Reporting Result

Result of guest.feature
```
Jan 29, 2023 9:45:22 AM cucumber.api.cli.Main run
WARNING: You are using deprecated Main class. Please use io.cucumber.core.cli.Main

@browser @play
Scenario: User can play the music             # Feature/guest.feature:5
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Starting ChromeDriver 108.0.5359.71 (1e0e3868ee06e91ad636a874420e3ca3ae3756ac-refs/branch-heads/5359@{#1016}) on port 1333
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
  Given Guest user open YouTube Music         # stepDefinition.GuestSteps.guest_user_open_you_tube_music()
  When User click the play icon from the song # stepDefinition.GuestSteps.user_user_click_the_play_icon_from_the_song()
Music is playing!
  Then the music is played                    # stepDefinition.GuestSteps.the_music_is_played()
Music Player is displayed!
  And the music player page is displayed      # stepDefinition.GuestSteps.the_music_player_page_is_displayed()

@browser @library
Scenario: Guest user cannot access Library # Feature/guest.feature:13
Starting ChromeDriver 108.0.5359.71 (1e0e3868ee06e91ad636a874420e3ca3ae3756ac-refs/branch-heads/5359@{#1016}) on port 3576
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
  Given Guest user open YouTube Music      # stepDefinition.GuestSteps.guest_user_open_you_tube_music()
  When User go to Library menu             # stepDefinition.GuestSteps.user_go_to_library_menu()
This is Sign In Page
  Then direct to Sign In with google page  # stepDefinition.GuestSteps.direct_to_sign_in_with_google_page()

2 Scenarios (2 passed)
7 Steps (7 passed)
0m11.610s

```
---

Result of member.feature
```
Jan 29, 2023 10:58:40 AM cucumber.api.cli.Main run
WARNING: You are using deprecated Main class. Please use io.cucumber.core.cli.Main

@browserMember
Scenario: Successful log in to Youtube Music                                  # Feature/member.feature:4
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Starting ChromeDriver 108.0.5359.71 (1e0e3868ee06e91ad636a874420e3ca3ae3756ac-refs/branch-heads/5359@{#1016}) on port 24558
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
  Given User open the URL Youtube Music                                       # stepDefinition.MemberStep.user_open_the_url()
  And User click Sign In Button                                               # stepDefinition.MemberStep.user_click_sign_in_button()
Couldn't Sign in Google
  When User enters email "alodoktertiga@gmail.com" and User click Next button # stepDefinition.MemberStep.user_enters_email_and_user_click_next_button(java.lang.String)
  And User enters password "password" and User click Next button
  Then the logged in home page of YouTube Music is displayed

Undefined scenarios:
file:///C:/Users/Alo-Larissa-Segara/eclipse-workspace/efishery/Feature/member.feature:4 # Successful log in to Youtube Music

1 Scenarios (1 undefined)
5 Steps (1 skipped, 1 undefined, 3 passed)
0m8.515s

```

