Feature: Search Result Page Validations

  Scenario: User can see Duco keyword in all search results
    Given I am on the homepage
    When I type "Duco" into the search field
    And I click the Google Search button
    And I see the "Duco" page search results
    Then I should see "Duco" keyword in all the links on search result page
