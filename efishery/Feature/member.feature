@browserMember
Feature: Member

Scenario: Successful log in to Youtube Music
	Given User open the URL Youtube Music
	And User click Sign In Button
	When User enters email "alodoktertiga@gmail.com" and User click Next button
	And User enters password "password" and User click Next button
	Then the logged in home page of YouTube Music is displayed