Feature: Happiest Health Landing Page validation


  Scenario: Verify user is able to launch Happiest Health URL
    Given User has launched URL
    When User maximizes the window
    Then User verify login button is visible
