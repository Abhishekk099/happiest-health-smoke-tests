# new feature
# Tags: optional
@Videos
Feature: Video page validation
Background: User has launched the Videopage
  Given User has launched Evolution URL
  When I clicked on "Videos" from the secondary menu

  Scenario: Verify Video page components
    Then Verify user can see "Videos" Breadcrumb is visible
    And Verify user can see "Home" Breadcrumb is visible

  Scenario: Verify Default no of tiles loaded in the screen
    Then Verify user can see 6 article by default

  Scenario Outline: Verify all required fields are present inside the tiles
    Then Verify user can see All article has "<TimerIcon>"
    And Verify user can see All article has "<ReadTime>"
    And Verify user can see All article has "<EditPenIcon>"
    And Verify user can see All article has "<BookReadIcon>"
    And Verify user can see All article has "<Date>"
    And Verify user can see All article has "<ThumbImage>"
    And Verify user can see All article has "<Titles>"

    Examples:
    | TimerIcon | ReadTime | EditPenIcon | BookReadIcon | Date | ThumbImage | Titles | tilesNo |
    | //div[contains(@class,'timer-icon ')] | //p[contains(@class,' read-time ')]| //div[contains(@class,'edit-pen-icon')] | //div[contains(@class,'book-read-icon')]  | //p[contains(@class,'date')] | //button[contains(@class,' thumb-image ')] | //div[contains(@class,'title ')] | 6 |

  Scenario: Verify user is able to navigate to video detail page by clicking on title in the listing page
    When user clicked on title of the video
    Then Verify the breadcrumb is displayed
    And Verify the video play button is displayed
    Then Verify like share comment strip is displayed
    And Verify the speaker section is displayed with name image
  @video
  Scenario: Verify user can post comment in video detail page
    When user clicked on title of the video
    Then User can see share your experience section
    And User is able to enter details in response field
    And User is able to enter details in enter name field as "Abhi"
    And User is able to enter the details in email field
    And User is able to click on post comment
    And Verify posted comment is shown with name "Abhi"