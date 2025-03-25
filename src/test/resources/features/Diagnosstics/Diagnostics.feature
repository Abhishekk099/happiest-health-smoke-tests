@Diagnostics @regression @stg3 @qa
Feature: Diagnostics

  @Diagnosticspages
  Scenario:Verify that the user is able to see and click on Diagnostics tab in the HH home page with all the components like Hero section, Search bar, Home Collection, Tests, Checkups,
      Disease and Organ specific and FAQ
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Tests section
     Then  User see the diagnostic page Title
     Then I see title of the hero section
     Then I see description of the hero section
     Then I see Hero image
      Then I see Search Tests and Checkups
      Then I see Explore Lab Tests
      Then I see Explore Checkups
      Then I see Explore GMB
      Then I see DiseaseSpecificPackages
     Then I see Body Organ Checkups
     Then I see FAQ sections
  @Diagnosticspages
  Scenario:Verify that the non-logged in user is able to click and validate "Request Call Back" under "Book Home Collection" section
    Given User has launched Evolution URL
   When  I clicked on Diagnostics from the primary menu
    Then I see Tests section
     Then  User see the diagnostic page Title
     Then I see the Book Home collection label
    Then I see the Book Home collection images
     Then I see the Request a Callback button
     When I click on the Request Call Back button
    Then I see Request Call Back form is displayed with Mobile number field
    Then I see Mobile Number field is empty by default for non-logged In user
    Then I see back button
    Then I see Privacy policy & Terms of use check box is checked by defaults
    Then I see I would like to create an account for me check box is checked by default
    Then I see proceed button is disabled by default
    When I click on Back button
    Then user is navigated back to Diagnostics home page
    When I click on the Request Call Back button secondtime
    When I enter the valid mobile number in the Mobile Number Field
    Then I see no error message is displayed
    Then I see error message not dsiplayed for thr number starting from the six to nine
      | 6745678923 |
    Then I see Proceed button will be enabled
    When I uncheck the  Privacy policy & Terms of use check box
    When I uncheck  I would like to create an account  checkbox
    Then I see proceed button is disabled
    When I check the both checkboxes from the Request a Call Back page
    When I click on Proceed button
    Then I see back button
    Then I see Request Call Back form is displayed with OTP field
    Then I see cancel and submit button displayed
    Then I see Resend button clickable
    When I click on the Resend button
    Then I see the Please wait before requesting another OTP text
    When I click on Back button
    Then I see Request Call Back form is displayed with Mobile number field

  @Diagnosticspages
  Scenario:Verify that the "Test" listing page is displayed in the same window with all the components like Hero section, Search, list of cards when clicked on "Tests"
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see Tests section
    When I click on Tests sections
   Then I see breadcrumb is displayed
    Then I see hero section is displayed with description
    Then I see Search bar is displayed with the text Search by tests or checkup nameg and search icon
    #When I click on Search bar
    #When I enter at least one character to search any tests
    #Then I see search results displayed the tests which are available in the platform
    #Then I see "Filter" option is displayed
    #Then I see 3 test cards are displayed horizontaly in the first line
    #Then I see total 6 test cards are displyed in the page
    #Then I see "View More" button is dispalyed
    #When I click on "View More" button
    #Then I see remaining tests are displayed along with "View less" buttona

  @Diagnosticspages
  Scenario:Verify that user can see the test title, description, report available time, actual price, discounted price, with a view details, add to cart, buy now action buttons in the Test listing page
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see Tests section
    When I click on Tests sections
    Then I see the list of Tests with the test title
    Then I see description with the test included
   # Then I see report available time
    #Then I see actual price, discounted price, with a View Details link
    #Then I see add to cart, buy now action buttons

  @Diagnosticspages
  Scenario:Verify that user is redirected to the Test specific detail screen when clicked on "View Details"
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see Tests section
    When I click on Tests sections
    Then I see the View Detail option in the cards
    When I click on the View Detail option
    Then I see page redirected to the specific detail screen



  Scenario: Verify that the Disease Specific packages are displayed in the Diagnostic landing page are clickable
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see Disease Specific package below the Explore section
    Then I see 8 disease cards are displayed
    When I click on View More Option of Disease Specific Packages
    Then I see remaining disease icon cards
    When I click on "Arthritis" disease or body organ icon card
    Then I see "Arthritis" Specific Tests and Packages when clicked on particular disease icon
    Then I see title on the top of the detail page like "Arthritis" specific Test and Checkups
    #Then I see Filter option
    Then I see Header description
    Then I see brief description
    Then I see Price
    #Then I see TAT
    Then I see Add to cart button
    Then I see Buy Now button
    Then I see breadcrumb in the detail page
    When I click on Diagnostics in the breadcrumb
    Then I see user is navigated to the "Diagnostics" home page


  Scenario: Verify that the Organ specific cards are displayed below the Disease specific packages are clickable
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see specific organs are displayed below the Disease specific Packages
    Then I see 8 Body Organ cards are displayed
    When I click on View More Option of Body Organ Checkup Packages
    Then I see remaining body organ icon cards
    When I click on "Brain" disease or body organ icon card
    Then I see title on the top of the detail page like "Brain" specific Test and Checkups
    Then I see title on the top of the detail page like "Brain" specific Test and Checkups
    #Then I see Filter option
    Then I see Header description
    Then I see brief description
    Then I see Price
    #Then I see TAT
    Then I see Add to cart button
    Then I see Buy Now button
    Then I see breadcrumb in the detail page
    When I click on Diagnostics in the breadcrumb
    Then I see user is navigated to the "Diagnostics" home page


  Scenario:Verify that Search bar is displayed in Diagnostics Home page
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
    When I click on Search bar to search bar
    When User enters the test and checkup name as "cbc"
    Then I see suggestions as per the search text "cbc"
    When I click on back button in the search bar
    Then I see user is navigated to the "Diagnostics" home page

  Scenario: verify that error message is displayed when invalid input is entered in the search
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
    When I click on Search bar to search bar
    When User enters the test and checkup name as "cbcasdasc"
    Then I see error message "0 Results Found"


  Scenario: Verify that results should have the the title heading of the test/checkup, a brief description,the number of tests included, discounted price, actual price, and discount percentage, TAT and ‘view details’ CTA button.
      Given User has launched Evolution URL
      When  I clicked on Diagnostics from the primary menu
      Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
      When I click on Search bar to search bar
      When User enters the test and checkup name as "cbc"
      Then I see Title heading of the test checkups
      Then I see brief description
      Then I see the number of tests included
      Then I see discounted price
#      Then I see actual price
#    Then I see discount percentage
#    Then I see discount percentage is calculated based on actual price and discount price
#    Then I see TAT
    Then I see View Details
    Then I see Buy Now button
    Then I see Add to cart button


  Scenario: Verify that the details page is displayed when clicked on test/checkup results from the list
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
    When I click on Search bar to search bar
    When User enters the test and checkup name as "cbc"
    When I click on any test checkup results
#    Then I see detail page is displayed
#    Then I see title heading of the test/checkup
#    Then I see a brief description
#    Then I see Number of tests included
#    Then I see Discounted price
#    Then I see Actual price
#    Then I see Discount percentage
#    Then I see Samples required
#    Then I see Preparation needed
#    Then I see Complete details about the test/checkup
#    Then I see Tests included


  Scenario: Verify that the payment page is displayed when clicked on Buy Now
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
    When I click on Search bar to search bar
    When User enters the test and checkup name as "cbc"
    When I click on Buy Now button
    Then I see user is navigated to the payment page


  Scenario: Verify that item is added to cart when clicked on Add to cart button
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see Search Bar with search text "Search by tests or checkup name" and icon in the home page
    When I click on Search bar to search bar
    When User enters the test and checkup name as "cbc"
    When I click on Add to Cart button
    And I see "Remove" button is displayed
    And I click on back button in the search bar
    Then I see item is added to cart

  @test
  Scenario: Verify that FAQ section is displayed below Body Organ Checkup
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I see FAQ section below Body Organ Checkups
    Then I see "Diagnostics - FAQ" as a title
    Then I see FAQ's are displayed in listing format


  Scenario: Verify user is able to see and click on the cart icon in the diagnostics landing page at the top right side
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then I navigate to the cart page
    Then I see breadcrumb in the detail page
    When I click on Diagnostics in the breadcrumb
    Then I see user is navigated to the "Diagnostics" home page

  @test
  Scenario: Verify that the error messages are displayed when invalid input is given in the mobile number field
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    When I click on the Request Call Back button
    Then I see Mobile Number field is empty by default for non-logged In user
    Then I see proceed button is disabled by default
    When I enter less than 10 digit mobile number as "122321"
    Then I see error message "Please enter a valid 10-digit mobile number" below the field
    When I enter more than 10 digit mobile number as "1223213434"
    Then I see error message "Please enter a valid 10-digit mobile number" below the field
    #When I enter non numeric characters as "ABCDefghij"
    Then I see error message "Please enter a valid 10-digit mobile number"
    #When I enter first digit number other than 6-9
    #Then I see error message

  @Diagnosticspages
  Scenario:Verify that "Add to Cart" button is clickable and should add that specific test to the cart
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    Then I see Tests section
    When I click on Tests sections
    When user clicks on Add to Cart button
    Then Remove button is displayed in place of Add to cart buttons
    Then user sees the specific test is added to the cart
    When I click on Remove button
    Then I see card is removed from the tests listing screen
   # And user can add multiple tests to the cart simultaneously

  @Diagnosticspages
  Scenario:Verify that the checkup listing page is displayed in the same window when clicked on "Checkups"
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    When I click on Checkups section
    Then I see Checkups breadcrumb is displayed
    Then I see Hero image is displayed with title and description
    Then I see search bar is dispalyed with the text Search by tests or checkup name and search icon
    #When I click on Search bar
    #When I enter at least one character to search any checkup
    #Then I see search results displayed the checkups which are available in the platform
   # Then I see 3 checkup cards are displayed horizontaly in the first line
    #Then I see total 6 checkups cards are displayed with "View More" button
    #When I click on View More button
    #Then I see remaining checkups are displayed along with "View less" button

  @Diagnosticspages1
  Scenario:Verify that the checkup listing page is displayed in the same window when clicked on "Checkups"
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    When I click on Checkups section
    Then I see the list of Checkups  with the test title
    Then I see description with the checkups included
    Then I see report available time
    Then I see actual price, discounted price, with a View Details link
    Then I see add to cart, buy now action buttons


  @Diagnosticspages
  Scenario:Verify that user is redirected to the Checkup specific detail screen when clicked on "View Details"
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    When I click on Checkups section
    Then I see the list of Checkups  with the test title
    Then I verified the Checkup Details screen

  @Diagnosticspages1
  Scenario: Verify that "Add to Cart" button is clickable and should add that specific Checkup to the cart
    Given User has launched Evolution URL
    When  I clicked on Diagnostics from the primary menu
    Then  User see the diagnostic page Title
    When I click on Checkups section
    Then I see the list of Checkups  with the test title
    When I clicks on Add to Cart button
    Then Remove button is displayed in place of Add to cart buttons in checkups
    Then user sees the specific test is added to the cart
    When I click on Remove button
    Then I see card is removed from the tests listing screen
