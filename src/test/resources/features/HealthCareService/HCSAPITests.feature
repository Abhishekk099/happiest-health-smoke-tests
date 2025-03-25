@HCSAPI
Feature: Validate Health Care Services API Endpoints

  Scenario: Validate HCS-Testimonials API
    Given the API endpoint for testimonials is available
    When I send a GET request with valid authentication
    Then the response status should be 200
    And the response should contain the expected data for testimonials


  Scenario: Validate FAQ API
    Given the API endpoint for FAQ is available
    When I send a GET request
    Then the response status should be 200
    And the response should contain the expected data for FAQ items

  Scenario: Validate service API
    Given the API endpoint for service is available
    When I send a GET request for service API
    Then the response status should be 200
    And the response should contain the expected data for service API

  Scenario: Validate doctors API
    Given the API endpoint for doctors is available
    When I send a GET request for doctors API
    Then the response status should be 200
    And the response should contain the expected data for doctors API

  Scenario: Validate clinics API
    Given the API endpoint for clinics is available
    When I send a GET request for service API
    Then the response status should be 200
    And the response should contain the expected data for clinics API

  Scenario: Validate service details by name API
    Given the API endpoint for service details by name is available
    When I send a GET request for service details by name  API with name "Contrast Bath"
    Then the response status should be 200
    And the response should contain the expected data for service details by name API

  Scenario: Validate service details of clinics by name API
    Given the API endpoint for service details by name is available
    When I send a GET request for service details of clinics by name API with name "Contrast Bath"
    Then the response status should be 200
    And the response should contain the expected data for service details of clinics by name API

  Scenario: Validate service details of doctors by name API
    Given the API endpoint for service details by name is available
    When I send a GET request for service details of doctors by name API with name "Contrast Bath"
    Then the response status should be 200
    And the response should contain the expected data for service details of doctors by name API


