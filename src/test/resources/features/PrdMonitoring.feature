@ProdMonitoring
Feature: Happiest Health Prod monitoring scripts

  Scenario: Verify user is able to see the primary menu as visitor
    Given User has launched Evolution URL
    Then I see the "Happiest Health" logo on the top left corner in the header section.
    Then Verify "Knowledge" is present in main menu
    Then Verify "Diagnostics" is present in main menu
    Then Verify "Ask an Expert" is present in main menu
    Then Verify "Magazine" is present in main menu
    Then Verify "Health Summits" is present in main menu
    Then User verify Editor's Picks section is displayed
    Then User validate following footer links are displayed
      |About Us| Contact Us| Privacy Policy| Editorial Policy| Cancellation and Refund Policy| Careers| Shipping Policy| Magazine Feedback| Corporate Wellness| FAQs| Terms of Use| Advertising Policy | Investors | Unsubscribe | Feedback |

  Scenario: Verify user is able to navigates to all different language pages
    Given User has launched Evolution URL
    And I select Hindi languages in LanguageDropdown
    Then I see user should be redirected to Hindi Language Landing Page
    Then Verify "कैटेगॉरीज़" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Bengali languages in LanguageDropdown
    Then I see user should be redirected to Bengali Language Landing Page
    Then Verify "ক্যাটাগরি" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Kannada languages in LanguageDropdown
    Then I see user should be redirected to Kannada Language Landing Page
    Then Verify "ವಿಭಾಗಗಳು" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Telugu languages in LanguageDropdown
    Then I see user should be redirected to Telugu Language Landing Page
    Then Verify "కేటగిరీలు" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Malayalam languages in LanguageDropdown
    Then I see user should be redirected to Malayalam Language Landing Page
    Then Verify "കാറ്റഗറി" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Gujarati languages in LanguageDropdown
    Then I see user should be redirected to Gujarati Language Landing Page
    Then Verify "કેટેગરી" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Marathi languages in LanguageDropdown
    Then I see user should be redirected to Marathi Language Landing Page
    Then Verify "कॅटेगिरी" is present in main menu in legacy UI
    Then Verify carrousel is available
    Given User has launched Evolution URL again
    And I select Tamil languages in LanguageDropdown
    Then I see user should be redirected to Tamil Language Landing Page
    Then Verify "வகைகள்" is present in main menu in legacy UI
    Then Verify carrousel is available

  Scenario: Verify user is able to navigates all tabs in primary menu
    Given User has launched Evolution URL
    Then Verify "Diagnostics" is present in main menu
    When User clicks on "Diagnostics" in primary menu
    Then I see user should be redirected to diagnostics Landing Page
    Then I see Tests section

    When User clicks on "Ask an Expert" in primary menu
    Then I see user should be redirected to askanexpert Landing Page
    And Clicks on Post a Query button

    When User clicks on "Magazine" in primary menu
    Then I see user should be redirected to Magazine Landing Page
    And Verify magazine slides are displayed

    When User clicks on "Health Summits" in primary menu
    Then I see user should be redirected to Health Summits Landing Page
    And Verify Health Summit Breadcrumb is displayed

