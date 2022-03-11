Feature: Search for Dublin in Google Maps website

  Scenario: Open Google Maps website
    Given I open Google Chrome
    When I visit "https://www.google.com/maps"
    Then The page "https://www.google.com/maps" must be the current page

  Scenario: Search for Dublin
    When Type "Dublin" in the search element
    Then Select the first element in the suggestions
    And The left panel headline text must be "Dublin"

  Scenario: Get directions to Dublin
    When Click the directions icon
    Then Destination must be "Dublin"
    And I close browser