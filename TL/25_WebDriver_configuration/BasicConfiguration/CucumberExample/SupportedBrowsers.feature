Feature: Browser navigation

  Scenario: Check compatible browsers
    Given User is on Home page
    When User navigates to "Browsers"
    Then Supported Browsers list is displayed