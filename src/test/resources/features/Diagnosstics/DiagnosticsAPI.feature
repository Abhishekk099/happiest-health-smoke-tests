@Diagnostics @regression
Feature: API test for diagnostics module

  Scenario: Verify user is able to get Popular Tests and checkups List Response
    Given Popular Tests And Checkups Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the SEARCH bar
    Then  User validate the popular tests and checkups

  Scenario: Verify user is able to get Popular Tests and checkups List Response by searching name of the test and checkup
    Given  Popular Tests and checkups List Response by searching "cbc" of the test and checkup Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    When  User clicks on the SEARCH bar
    And  User enters the test and checkup name as "cbc"
    Then user validate the searched test and checkup result


  Scenario: Verify user is able to get Test List Response
    Given Tests  List  Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Test Icon
    And User validate all tests are available in UI


  Scenario: Verify user is able to get Test landing page results List Response
    Given Tests  List  search Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Test Icon
    When  User clicks on the SEARCH bar
    And User validate all popular tests are available in UI


  Scenario: Verify user is able to get Search criteria api on tests landing page
    Given Search criteria api on tests landing page Sufalam Api Post call is triggered with serach text as "cbc"
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Test Icon
    When  User clicks on the SEARCH bar
    And  User enters the test and checkup name as "cbc"
    Then user validate the searched test and checkup result

  Scenario: Verify user is able to get Checkup List Response
    Given Checkups  List  Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Checkup Icon
    And User validate all Checkups are available in UI


  Scenario: Verify user is able to get Checkup landing page results List Response
    Given Checkups  List  Search Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Checkup Icon
    When  User clicks on the SEARCH bar
    And User validate  all Popular Checkups are available in UI

  Scenario: Verify user is able to get Search criteria API on checkup landing page
    Given Search criteria api on Checkups landing page Sufalam Api Post call is triggered with serach text as "Basic"
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    When  User clicks on the Checkup Icon
    When  User clicks on the SEARCH bar
    And  User enters the test and checkup name as "Basic"
    Then user validate the searched test and checkup result


  Scenario: Verify user is able to get disease specific packages List Response
    Given Disease List Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    Then User validate  all Disease from API are available in UI

  @DiagnosticsAPI
  Scenario: Verify user is able to get body organ specific List Response
    Given Body Organ List Sufalam Api Post call is triggered
    Given User has launched Evolution URL
    When  I clicked on "Diagnostics" from the primary menu
    Then  User see the diagnostic landing page
    Then User validate  all Body Organ from API are available in UI