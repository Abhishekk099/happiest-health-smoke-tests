@UMAPI
Feature: Validate User Management API

  Scenario: Validate Sign up with OTP API
    Given API endpoint for signup is available
    Given the user Triggers sign up OTP for "AutoUser"
    Then the response status should be 200
    When User retrieves Sign UP OTP
    Given API endpoint for Verify OTP is available
    When the user Triggers Verify with OTP for "AutoUser"
    Then the response status should be 200
    Given API endpoint for Register user is available
    Then the User triggers Register user API
    And the response should contain the expected data for Login with OTP

  Scenario: Validate Sign In with OTP API
    Given API endpoint for send OTP is available
    Given the user Triggers send OTP for "+918147161211"
    Then the response status should be 200
    When User retrieves OTP
    Given API endpoint for Login with OTP is available
    When the user Triggers Login with OTP for "+918147161211"
    Then the response status should be 200
    And the response should contain the expected data for Login with OTP
