@SomkeTest
Feature: input feature
		 Verify input feature of restapiio documentation application
		 
Background: user access screen of restapiio documentation application
			When user open "chrome" browser
			And user enter url "https://ratesapi.io/documentation/"
			And user wait "15" second to load login page
			Then user is on login screen of restapiio documentation application

@SmokeTest
Scenario: verify that user able to access restapiio documentation application by using valid creditional	
		 Given Rates API for Latest Foreign  Exchange rates
		 When The API is available
		 And An automated test suite should run which will assert the success status of the response
		 Then An automated test suite should run which will assert the response
		 When An incorrect or incomplete url is provided
		 Then Test case should assert the correct response supplied by the call
		 Given Rates API for Specific date Foreign Exchange rates
		 When The API is available
		 And An automated test suite should run which will assert the success status of the response
		 Then An automated test suite should run which will assert the response
		 When A future date is provided in the url
		 Then An automated test suite should run which will validate that the response matches for the current date
