@Evolution @regression @stg3 @qa
Feature: Evolution

  @EvolutionBasicCheck
  Scenario: Verify user is able to see the primary menu as visitor
    Given User has launched Evolution URL
    Then Verify "Knowledge" is present in main menu
    Then Verify "Diagnostics" is present in main menu
    Then Verify "Ask an Expert" is present in main menu
    Then Verify "Magazine" is present in main menu
    Then Verify "Health Summits" is present in main menu

  @EvolutionAdsValidation
  Scenario: Verify ads are shown in evolution page
    Given User has launched Evolution URL
    Then Verify ads are shown in evolution page

  @EvolutionLogoCheck
  Scenario: Validate, the “Happiest Health” logo is present on the top left corner.
    Given User has launched Evolution URL
    Then  I see the "Happiest Health" logo on the top left corner in the header section.

  @EvolutionLogoCheck @smoke
  Scenario: Validate, user should be redirected to the landing/home page, when they click on “Happiest Health” logo.
    Given User has launched Evolution URL
    Then  I see the "Happiest Health" logo on the top left corner in the header section.
    When I clicked on "Categories" from the secondary menu
   # Then I navigated to the category listing page
    When I clicked on “Happiest Health” logo in the header section
    Then I redirected back to the home page

  @EvolutionWellnessProgrammes
  Scenario: Verify the "wellness programmes" section  and its default count is 3 and on clicking redirecting to program page
    Given User has launched Evolution URL
    Then I see the "Corporate Wellness" section
    Then I see the 3 card displayed in the "Corporate Wellness" section
    When I click on the "wellness programmes" card
    Then I see user should be redirected to the specific programme details screen


  @EvolutionWellnessProgrammes @smoke
  Scenario: Verify the "wellness programmes" section view all click navigates user to all wellness programmes
    Given User has launched Evolution URL
    Then I verify title thumbnail image with programme name and button
    And I verify card title should display with 3 dots at the end of the title
    When I click on the  view all in in wellness programmes section
    Then I see user should be redirected to the specific programme details screen


  @EvolutionSearchIconAndLanguageSelection @smoke
  Scenario: Verify the Presence of search Icon and Language Selection
    Given User has launched Evolution URL
    Then I Validate the search icon is present before the profile icon
    And I Validate the language option is present before the search option
    And I select Hindi languages in LanguageDropdown
    Then I see user should be redirected to Hindi Language Landing Page


  # @EvolutionNotificationIcon
  # Scenario: Validate presence of notification Icon and it's functionality
  # Given User has launched Evolution URL
  # Then I Validate the notification is present icon before the profile option
  # Then I click on notification icon

  @EvolutionProfileIcon
  Scenario: Validate presence of Profile Icon and it's functionality
    Given User has launched Evolution URL
    Then I Validate profile icon is present



  @EvolutionPodcast
  Scenario: Verify the Podcasts section  and its default count is 3 and on clicking redirecting to Podcasts page
    Given User has launched Evolution URL
    Then I see the "Podcasts" section
    Then I see the 3 card displayed in the podcast section
    When I click on the podcast card
    Then I see user should be redirected to the specific podcast details screen

  @EvolutionPodcast @smoke
  Scenario: Verify the Podcasts section view all click navigates user to all Podcasts listing page
    Given User has launched Evolution URL
    # Then I verify title thumbnail image with podcast name and button
    # And I verify podcast card title should display with 3 dots at the end of the title
    When I click on the  view all in in podcast section
    Then I see user should be redirected to the specific podcast details screen

  @EvolutionVideo @smoke
  Scenario: Verify the Videos section  and its default count is 3 and on clicking redirecting to videos page
    Given User has launched Evolution URL
    Then I see the "Videos" section
    Then I see the 3 card displayed in the videos section
    When I click on the videos card
    Then I see user should be redirected to the specific videos details screen

  @EvolutionVideo @smoke
  Scenario: Verify the Videos section view all click navigates user to all Videos listing page
    Given User has launched Evolution URL
    Then I verify title thumbnail image with videos name and button
    And I verify videos card title should display with 3 dots at the end of the title
    When I click on the  view all in videos section
    Then I see user should be redirected to the specific videos details screen


  @EvolutionSummit @smoke
  Scenario: Verify the Summits should be display with "Upcoming summits" and "Past Summits" section
    Given User has launched Evolution URL
    Then Verify the latest summit section should display below the web stories section
    Then Verify the summit section has 'Upcoming Summits' tab
    And Verify the summit section has 'Past Summits' tab

  @EvolutionSummit
  Scenario: Verify the summit should display with below under past summits thumbnail image title of the summit and the action button of photo gallery related to that specific summit
    Given User has launched Evolution URL
    Then I click on 'Past Summits' tab
    Then I see the Past summit displayed with summits thumbnail image
    Then I see the title of the summit
    Then I see the photo gallery related to specific summit

  @EvolutionSummit
  Scenario: Verify the page should be redirect to the summits home page when user click on the photo gallery on a specific summit
    Given User has launched Evolution URL
    Then I click on 'Past Summits' tab
    When I click on the photo gallery on a specific summit
    Then I see summit card redirected to the summits home page

  @EvolutionSummit
  Scenario: Verify the "Upcoming summits" should be highlight under Summits section
    Given User has launched Evolution URL
    Then Verify the latest summit section should display below the web stories section
    Then Verify the summit section has 'Upcoming Summits' tab
    Then I see the Upcoming Summits tab is highlighted by default

  @EvolutionSummit
  Scenario: Verify the one latest next summit should be display with below data under the upcoming summit section summit title within two lines short description about the summit date and time of the summit location of the summit
    Given User has launched Evolution URL
    Then Verify the latest summit section should display below the web stories section
    Then Verify the summit section has 'Upcoming Summits' tab
    Then I see the short description for the summit
    Then I see the date displayed in the Month date format with Date label
    Then I see the Time in the time "Onwards" with "Time(IST)" format
    Then I see the location of the Summit displayed  with "Location" label

  @EvolutionSummit
  Scenario: Verify the page should be redirect to the particular summit details screen when the user click on the title of the summit
    Given User has launched Evolution URL
    Then Verify the latest summit section should display below the web stories section
    Then Verify the summit section has 'Upcoming Summits' tab
    When I click on the Summit under Upcoming summits section
    Then I see summit card redirected to the upcoming summits home page

  @Magazine @smoke
  Scenario:  Verify the Magazine section
    Given User has launched Evolution URL
    Then Verify the Magazine section should display below the Carousel section

  @HealthChampions @smoke
  Scenario:  Verify the Health Champions view all click navigates user to all listing page
    Given User has launched Evolution URL
    Then Verify the Health Champions section should display below the Quiz section
    Then I verify title thumbnail image with button for Health Champions present with Category and name
    Then I verify Health Champion card title should display with 3 dots at the end of the title
    When I click on the  view all in Health Champions section
    Then I see user should be redirected to the Health Champions listing page

  @HealthChampions @smoke
  Scenario:  Verify the Health Champions section and its default count is 4 and on clicking redirecting to videos page
    Given User has launched Evolution URL
    Then Verify the Health Champions section should display below the Quiz section
    When I see the 4 card displayed in the Health Champions section
    Then I click on the Health Champions card
    Then I see user should be redirected to the Health Champions page

  @AskAnExpert @smoke
  Scenario:  Verify the Health Champions section
    Given User has launched Evolution URL
    Then Verify the Ask an Expert section should be displayed below the editors’ pick section and next to the Magazine section


  @ShareYourStory @smoke
  Scenario:  Verify the Health Champions section
    Given User has launched Evolution URL
    Then Verify the Share your story button should  display next to the Are You a Health Champion? text
    And user Clicks on share your story button
    Then Verify share your story form is displayed

  @AskAnExpert
  Scenario: Verify the doctor response should load with doctors name, profile pic, specialty, and the different responses
    Given User has launched Evolution URL
    Then I see the "Ask an Expert" queries card
    Then I see the response with doctors name
    Then I see the response with doctors profile pic
    Then I see the response with specialty

  @WebStories
  Scenario: Verify the user should be able to redirect to the specific web story details screen in a new tab when clicking on a particular web story.
    Given User has launched Evolution URL
    When I clicked on any web story
    Then I redirected to the specific web story details screen in a new tab

  @AskAnExpert1
  Scenario:  Verify the page should redirect to the specific card details when the user clicks on the specific card
    Given User has launched Evolution URL
    Then Verify the Ask an Expert section should be displayed below the editors’ pick section and next to the Magazine section
    Then Verify  the Ask an Expert section should be displayed with 2 cards
    When I click on the Particular Ask An Expert First Card
    Then I see user should be redirected to the Ask An Expert response page
    When I navigate back to the home page
    When I click on the Particular Ask An Expert second Card
    Then I see user should be redirected to the Ask An Expert response page


  @AskAnExpert
  Scenario:  Verify the Ask an Expert  view all click navigates user to all listing page
    Given User has launched Evolution URL
    Then Verify the Ask an Expert section should be displayed below the editors’ pick section and next to the Magazine section
    When I click on the View All option
    Then I see user should be redirected to the health queries answered by doctors

  @PodcastDeafultLoad
  Scenario:  Verify the 6 podcast are loaded on clicking link in sub menu
    Given User has launched Evolution URL
    When I click on the Podcast link in sub menu
    Then I verify 6 podcast are loaded

  @PodcastDeafultLoad  @MyTest
  Scenario:  Verify the 12 podcast are loaded on scrolling down the page
    Given User has launched Evolution URL
    When I click on the Podcast link in sub menu
    #When User scroll down
    Then I verify 6 podcast are loaded


