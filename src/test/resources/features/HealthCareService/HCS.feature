@HCSUI
Feature: Validate HCS in HappiestHealth page

  @hcsDoctorHome
  Scenario: Validate user is able to navigate to Health Care Service from HappiestHealth home page
    Given User has launched Evolution URL
    When  I clicked on "Healthcare" from the primary menu
    Then Verify "Services" section is available
    Then Verify "Doctors" section is available
    Then Verify "Clinic Name" section is available
    Then Verify "Testimonials" section is available
    Then Verify Why Choose Us section is available
    Then Verify "HCS FAQ" section is available

  @hcsDoctor
  Scenario: Validate user is able to see Doctor section from Healthcare service
    Given User has launched Evolution URL
    When  user clicked on Healthcare from the primary menu
    Then  user verify Doctor section below services
    Then  user verify "Doctor" Image
    Then  user verify "Doctor" Name
    Then  user verify "Doctor" Qualification
    Then  user verify "Doctor" Speciality
    Then  user verify "Doctor" Location
    Then  user verify Book an Appointment button
    And   user remembers the current doctors name
    When  user clicked on Carousel
    Then  user verify next three Doctor cards are displayed
    When  user clicked on view all link for doctors section
    Then  Verify Doctors listing section is available
    When  user clicked on any one Doctor card in the listing page
    Then  Verify Doctors Details section is available



  @hcsBAP
  Scenario: Verify that the non-logged in user is able to click and validate "Book an Appointment" under "Doctor" section
    Given User has launched Evolution URL
    When user clicked on Healthcare from the primary menu
    When user clicked on Book an Appointment button for the selected doctor card
    Then I see Book an Appointment form is displayed with patient first name
    Then I see patient first name field is empty by default for non-logged In user
    Then I see Book an Appointment form is displayed with patient last name
    Then I see patient last name  is empty by default for non-logged In user
    Then I see Book an Appointment form is displayed with Mobile number field
    Then I see Mobile Number field is empty by default for non-logged In user in BAA
    Then I see back button in BAP
    Then I see Privacy policy & Terms of use check box
    Then I see I want to receive the updates through WhatsApp checkbox
    Then I see proceed button is disabled by default in BAA
    When I click on Back button in BAP form
    Then user click on Back button again
    Then user is navigated back to healthcare service page
#    When I click on the Book an Appointment button second time
#    When I enter the valid first name in the patient first name Field
#    When I enter the valid last name  in the patient last name Field
#    When I enter the valid mobile number in the Mobile Number Field in BAA
#    Then I see no error message is displayed in BAA
#    Then I see Proceed button will be enabled in BAA
#    When I uncheck the  Privacy policy & Terms of use check box in BAA
#    When I uncheck the  whatsapp check box in BAA
#    Then I see proceed button is disabled in BAA
#    When I check the both checkboxes from the Book an Appointment page
#    When I click on Proceed button in BAA
#    Then I see back button in BAA
#    Then I see  Book an Appointment form is displayed with OTP field
#    Then I see cancel and submit button displayed in BAA
#    When I click on Back button in BAP form
#    Then I see previous Book an Appointment form is displayed

  @hcsDoctorListing
  Scenario: Verify user is able to see the doctor listing page
    Given User has launched Evolution URL
    When  user clicked on Healthcare from the primary menu
    When  user clicked on view all link for doctors section
    Then  Verify Doctors listing section is available
    Then  I see breadcrumbs
    Then  I see hero banner section
    Then  I see Tittle for hero banner section
    Then  I see Description for the hero banner section
    Then  I see 4 cards displayed for the hero banner section
    Then  I see FAQ section

  @hcsLoggedInUser @Mytest1
  Scenario:Verify that the logged in user is able to click and validate "Book an Appointment" under "Doctor" section
    Given User has launched Evolution URL
    When User clicks on profile section
    Then user clicked on Accept Checkbox
    Given User requests an OTP for "8147161211"
    When User retrieves Mobile OTP
    And User logs in with OTP
    When user clicked on Healthcare from the primary menu
    When user clicked on Book an Appointment button for the selected doctor card
    Then I see Book an Appointment form is displayed with patient first name
    Then I see Book an Appointment form is displayed with patient last name
    Then I see Book an Appointment form is displayed with Mobile number field
    Then I see back button in BAP
    Then I see Privacy policy & Terms of use check box
    Then I see I want to receive the updates through WhatsApp checkbox
    When I click on Proceed button in BAA
    Then I see successful message pop up is displayed



  @hcsServices
  Scenario Outline: Validate user is able to see Service section from Healthcare service
    Given User has launched Evolution URL
    When  user clicked on Healthcare from the primary menu
    Then  user verify Services section
    Then  user verify Services Name
    Then  user verify next three Services cards are displayed
    When  user clicked on view all link for services section
    Then  Verify List Of Services listing section is available
    When  user clicks on view details of any one Services card in the listing page
    Then  user verify details landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Healthcare services contrast bath|


  @hcsServicesBAA
  Scenario Outline: Validate user is able to book an appointment through Services section
    Given User has launched Evolution URL
    When user clicked on Healthcare from the primary menu
    Then user verify Services section
    Then user verify Services Name
    Then user verify next three Services cards are displayed
    When user clicked on view all link for services section
    Then Verify List Of Services listing section is available
    When user clicks on view details of any one Services card in the listing page
    Then user verify details landing page with "<breadcrumb>" breadcrumb
    Then user verify Symptoms section
    Then user verify Treatment section
    Then user verify Doctors section
    Then user verify Disclaimer section
    Then user clicked on Book an Appointment button for the selected doctor card
    Then I see Book an Appointment form is displayed with patient first name
    Then I see patient first name field is empty by default for non-logged In user
    Then I see Book an Appointment form is displayed with patient last name
    Then I see patient last name  is empty by default for non-logged In user
    Then I see Book an Appointment form is displayed with Mobile number field
    Then I see Mobile Number field is empty by default for non-logged In user in BAA
    Then I see back button in BAP
    Then I see Privacy policy & Terms of use check box
    Then I see I want to receive the updates through WhatsApp checkbox
    Then I see proceed button is disabled by default in BAA
    When I click on Back button in BAP form
    Then user is navigated back to healthcare service page


    @qa
    Examples:
      | breadcrumb |
      | Healthcare services contrast bath|


  @Testimonials
  Scenario: Verify user can able to see Testimonials section from Healthcare page
    Given User has launched Evolution URL
    When user clicked on Healthcare from the primary menu
    Then user verify Testimonials section
    Then user verify Testimonials cards are displayed
    Then user verify the first card in Testimonial section
    Then user clicks on forward button
    Then user verify Testimonials cards are displayed
    Then user clicks on backward button


  @WCU
  Scenario: Verify user can able to see Why Choose Us section from Healthcare page
    Given User has launched Evolution URL
    When user clicked on Healthcare from the primary menu
    Then user verify Why Choose Us section
    Then user verify Why Choose Us cards are displayed
    Then user verify the each card in Why Choose Us section

