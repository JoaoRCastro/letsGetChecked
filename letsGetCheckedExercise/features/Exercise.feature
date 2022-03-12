@All
Feature: Search for Dublin in Google Maps website

  Scenario: Open Google Maps website
    Given I visit "https://www.google.com/maps"
    Then The page "https://www.google.com/maps" must be the current page

  Scenario: Search for Dublin
    When Search "Dublin" in the search element
    Then The left panel headline text must be "Dublin"

  Scenario: Get directions to Dublin
    When Click the directions icon
    Then Destination must be "Dublin"