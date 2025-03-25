@AAE
Feature: Ask An Expert


  Scenario Outline:A Verify visitor can publish a query.
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User navigates to "https://qa.staging.happiesthealth.com/evolution"
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

    @qa
    Examples:
      | email | password | query |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update |


  Scenario Outline:B Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<email>" value in "Email or Username" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed



    @qa
    Examples:
      | email | password | query | moderator |
      |ramatulasi.gottipati@happiestminds.com|Pes@2024| This is a test query to be used in automation test execution do not update | Automation User1 |


  Scenario Outline:C Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<email>" value in "Email or Username" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on "Submit for Review" button
    And User clicks on "Submit for review" button
    And User Verify Success message is displayed


    @qa
    Examples:
      | email | password | query | expert |
      |abhishek.kumar10@happiestminds.com|Abhi@652| This is a test query to be used in automation test execution do not update |Dr. Akash Dadore|


  Scenario Outline:B Verify Editor can approve response added by to Moderator
    Given User has launched Admin URL
    And User enter "<email>" value in "Email or Username" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on "Publish Response" button
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | moderator |
      |ramatulasi.gottipati@happiestminds.com|Pes@2024| This is a test query to be used in automation test execution do not update | Automation User1 |

#  Given launch Happiestmhealth Admin URL
#  When User login with valid credentials
#  And See the AAE tab
#  And See visitor's profiles
#  And see the expert's profile
#  And see the manage tab
#
#
#  AAE Admin:
#  Given Visitor posted a query
#  When Super admin able to see the visitor posted query
#  And Super admin can assign the query to Moderator or Editor
#  And Super admin/editor/moderator can reject the query if the query is invalid
#  And Moderator Can select the Experts list in add response page(Related to particular query speciality)
#  And moderator can select the Experts list in add another response (Can select any speciality)
#  And After add the response can save or send it for review
#  When Editor can see the under review tab
#  And Editor can re assign it to moderator if requires or can pblish the respnse.

#  https://qa.staging.happiesthealth.com/community/admin
#
#  Super Admin: ghanashyam.n@happiestminds.com/Pes@2023
#  Editor: ramatulasi.gottipati@happiestminds.com/Pes@2024
#  Moderator: ramadevi.p@happiestminds.com/Pes@2024