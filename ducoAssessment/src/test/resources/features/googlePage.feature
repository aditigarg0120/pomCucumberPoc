Feature: Google Homepage Search

Scenario: User can see the title
  Given I am on the homepage
  Then I should see the title of the page

Scenario: User can search with Google Search
  Given I am on the homepage
  When I type "Duco" into the search field
  And I click the Google Search button
  Then I should see the "Duco" page search results

Scenario: User can search with Im Feeling Lucky
  Given I am on the homepage
  When I type "duco" into the search field
  And I click the I’m Feeling Lucky button
  Then I should see a duco website home page
  
  Scenario: User can click on Terms Link
	Given I am on the homepage
	When I click on "Terms" link
	Then I should see the Privacy & Terms Page
	
	
	Scenario: User can click on Gmail Link
	Given I am on the homepage
	When I click on "Gmail" link
	Then I should see the Gmail website
	
	Scenario: User can click on Google Apps Link
	Given I am on the homepage
	When I click on "Google Apps" link
	And I click on "You Tube" link
	Then I should see the You tube page
	

  

  