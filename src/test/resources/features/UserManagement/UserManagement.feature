@UMUI
Feature: User Management

  Scenario: Registered User logs in using OTP
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "9951173332"
    Then user clicked on Accept Checkbox
    When User retrieves Mobile OTP
    And User logs in with OTP
    Then Verify user profile icon is displayed

  Scenario: After login user clicks on Categories menu and verifying still as same user
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "9951173332"
    Then user clicked on Accept Checkbox
    When User retrieves Mobile OTP
    And User logs in with OTP
    Then Verify user profile icon is displayed
    When I clicked on "Categories" from the secondary menu
    Then Verify user profile icon is displayed
    Then user clicks on profile button
    Then verify User name in the profile section

  Scenario: User logs in using OTP and validating Ask an Expert
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "9951173332"
    Then user clicked on Accept Checkbox
    When User retrieves Mobile OTP
    And User logs in with OTP
    When I click on the  view all in in podcast section
    Then I see user should be redirected to the specific podcast details screen

  Scenario: Non registered user - new user login
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "9113899573"
    Then user clicked on Accept Checkbox
    When User retrieves the Mobile OTP for SIGNUP
    And User logs in with OTP
    Then Verify user registration page should display

  Scenario: Verifying Invalid Mobile number
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "2345566789"
    Then Verify user can see the message as "Invalid mobile number.Outside India?"

  Scenario: User SignUP in using OTP using Email
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "2345566789"
    Then Verify user can see the message as "Invalid mobile number.Outside India?"
    Then user clicks on proceed to Email Button
    Then Verify user can see Email text field
    When user enters email id "dmoni0709"
    When User retrieves Email OTP

  Scenario: User logs in using OTP
    Given User has launched Evolution URL
    When User clicks on profile section
    Given User requests an OTP for "9951173332"
    When User retrieves Mobile OTP
    And User can see the message "We have sent to OTP 9951173332"
    Then User can see the change number link
