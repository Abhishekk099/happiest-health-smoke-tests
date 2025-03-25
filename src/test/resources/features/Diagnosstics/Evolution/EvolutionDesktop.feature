@Evolution @regression
Feature: Evolution Desktop View

  @PrimaryNavBar @smoke
  Scenario: Verify the primary navigation bar
    Given User has launched HHEvolution URL in Desktop view
    Then User validate primary navigation bar items is displayed with items in Desktop view
      | Knowledge | Diagnostics | Ask an Expert | Magazine | Careers |


  @SecondaryNavBar @smoke
  Scenario: Verify the secondary navigation bar
    Given User has launched HHEvolution URL in Desktop view
    Then User validate secondary nav bar items is displayed with items in Desktop view
      | What's New | Categories | Videos | Podcasts | Health Champions | How To... |  Doc Tales | Healthzine | Summits | Programmes |


  @Carousal
  Scenario: Verify Homepage Carousal placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Carousal" displayed to the "left" direction of "Editor's Picks" title
    Then User verify "Carousal" displayed to the "above" direction of "Magazine" title
    Then User verify "Carousal" displayed to the "below" direction of webelement with xpath "(//nav)[2]"


  @Editor'sPick
  Scenario: Verify Editor's pick placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Editor's Picks" displayed to the "right" direction of webelement with xpath "//article/div[@class='slick-slider slick-initialized']"
    Then User verify "Editor's Picks" displayed to the "above" direction of "Ask an Expert" title
    Then User verify "Editor's Picks" displayed to the "below" direction of webelement with xpath "(//nav)[2]"


  @WebStories
  Scenario: Verify Web Stories placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Web Stories" displayed to the "below" direction of "Magazine" title
    Then User verify "Web Stories" displayed to the "above" direction of "Corporate Wellness" title
    Then User verify "Web Stories" displayed to the "above" direction of "Health Summits" title


  @WellnessProgrammes @smoke
  Scenario: Verify Wellness Programmes placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Corporate Wellness" displayed to the "left" direction of "Health Summits" title
    Then User verify "Corporate Wellness" displayed to the "below" direction of "Web Stories" title
    Then User verify "Corporate Wellness" displayed to the "above" direction of "Podcasts" title


  @Podcasts @smoke
  Scenario: Verify Podcasts placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Podcasts" displayed to the "left" direction of "Videos" title
    Then User verify "Podcasts" displayed to the "below" direction of "Corporate Wellness" title


  @Summits
  Scenario: Verify Summits placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Summits" displayed to the "right" direction of "Corporate Wellness" title
    Then User verify "Summits" displayed to the "below" direction of "Web Stories" title
    Then User verify "Summits" displayed to the "above" direction of "Videos" title


  @Videos @smoke
  Scenario: Verify Videos placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Videos" displayed to the "right" direction of "Podcasts" title
    Then User verify "Videos" displayed to the "below" direction of "Health Summits" title


  @smoke
  Scenario Outline: Validate, the search results page with the title, content type, short description and the thumbnail images.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify search icon is displayed
    When User click on search icon
    Then User validate search input box is displayed
    When User enters "<searchKeyword>" keyword in the search bar and press enter
    Then User verify search results for "<searchKeyword>" is displayed and are valid
    Then User validate "<searchKeyword>" is displayed in title
    Then User verify content titles is displayed
    Then User verify content short descriptions is displayed
    Then User verify content thumbnail images is displayed

    @qa
    Examples:
      | searchKeyword |
      | Articles      |


  Scenario Outline: Validate, user can enter characters, numbers, and special characters in the search field.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify search icon is displayed
    When User click on search icon
    Then User validate search input box is displayed
    When User enters "<searchKeywordWithCharacters>" keyword in the search bar
    Then User verify search input box text matches "<searchKeywordWithCharacters>"
    And User clear value of "search-input-field" input
    When User enters "<searchKeywordWithNumbers>" keyword in the search bar
    Then User verify search input box text matches "<searchKeywordWithNumbers>"
    And User clear value of "search-input-field" input
    When User enters "<searchKeywordWithSpecialCharacters>" keyword in the search bar
    Then User verify search input box text matches "<searchKeywordWithSpecialCharacters>"


    @qa
    Examples:
      | searchKeywordWithCharacters | searchKeywordWithNumbers | searchKeywordWithSpecialCharacters |
      | Articles                    | Articles1 | Articles@123                                      |


#  Scenario: Verify the  user should be able to see the latest 5 My stories card by swiping to the right side
#    Given User has launched HHEvolution URL in Desktop view
#    Then User validate "My Story" text displayed on webPage
#    Then User validate MyStory section has 5 cards
#    Then User verify swipe functionality in MyStories

  @smoke
  Scenario: Verify  the footer should be displayed at the bottom of the home/landing page
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    Then User validate following footer links are displayed
      | About Us | Contact Us | Privacy Policy | Editorial Policy | Careers | Corporate Wellness | FAQ’s | Leadership | Investors | Advertising Policy | Magazine Feedback | Cancellation and Refund Policy | Terms Of Use | Shipping Policy | Unsubscribe | Feedback |

  @smoke
  Scenario Outline: Verify the page should be redirected to the category landing page with the secondary top navigation bar when the user clicks on the Categories section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Categories" title from secondaryNavBar
    Then User verify Categories landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Categories |


  Scenario: Verify the page should be redirected to the new promotional page and the user is able to click on any available links when the user clicks on the "What’s new" section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "What's New" title from secondaryNavBar


  @smoke
  Scenario Outline: Verify the page should be redirected to the landing page of the "Summit" when the user clicks on the "Summit" section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Health Summits" view all
    Then User verify "Corporate Wellness" landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Home>Health Summits |

  @smoke
  Scenario: Verify the page should be redirected to the landing page of the "Ask an expert" when the user clicks on the "Ask an expert" section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Ask an Expert" view all
    Then User verify "Ask An Expert" landing page

  @smoke
  Scenario Outline: Verify the page should be redirected to the landing page of the "magazine" when the user clicks on the "Magazine" section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Magazine" view all
    Then User verify Magazine landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Home>Magazine |

  @smoke
  Scenario: Verify the page should be redirected to the home page when the user clicks on the "Knowledge" section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Knowledge" title from primaryNavBar
    Then User should be redirected to home page

  @smoke
  Scenario: Verify the "knowledge" section should be highlighted by default when the user lands on the Home Page as a Logg-in user
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Knowledge" section is highlighted by default


#  Scenario: Verify the "My story" description should be displayed with 7 lines and "Read More" option  if the description is more than lines
#    Given User has launched HHEvolution URL in Desktop view
#    Then User verify MyStory description shows Read More option when it has more than 7 lines

  @smoke
  Scenario: Verify the My story card display with below objects title image Description
    Given User has launched HHEvolution URL in Desktop view
    Then Verify MyStory title, image and Description

  @smoke
  Scenario: Verify My Story placement
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "My Story" displayed to the "right" direction of "Health Champion" title
    Then User verify "My Story" displayed to the "below" direction of "Quiz" title
    Then User verify "My Story" displayed to the "above" direction of "Polls" title


  Scenario: Validate, all the web stories are listed below the “Web Stories” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User validate all the web stories are listed below the “Web Stories” section.

  @smoke
  Scenario Outline: Verify the "knowledge" section should be highlighted by default when the user lands on the Home Page as a Logg-in user
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button


#    Then I see the login profile changed with logged-in icon
#    Then I see the Primary main menu in the home page
#    Then I see the Knowledge section in the Primary main menu
#    Then I see "Knowledge" section highlighted by default

    @qa
    Examples:
      | email | password |
      | hunkbeast789@gmail.com | Hunk@351 |


  Scenario: Verify the pop-up details should contain "Email ID", "WhatsApp number", "privacy terms and conditions", and "opt-in button" when the user clicks on the "Health Zine" option
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    Then User validate "Enter your email" inputBox displayed on webPage
    Then User validate "privacy-policy-checkbox" checkbox displayed on webPage
    Then User validate "Opt-in Now" button displayed on webPage

  @Evolution @smoke
  Scenario: Verify the email ID should be mandatory in the "opt-in" newsletter
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    And User enter "abc" value in "email-input" input field
    And User click on I accept checkbox
    When User click on "email-input" Input field using "id"
    And User clicks on "Opt-in Now" button
    Then User validate error message is displayed


  Scenario Outline: Verify the page should be redirected to the "privacy policy page and the terms of use" page when the user clicks on the "Privacy and terms of use" link in the "opt-in" popup
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    Then User validate "privacy-policy-checkbox" checkbox displayed on webPage
    When User click on "privacy-policy" using "id"
    Then User verify "Privacy Policy" landing page with "<breadcrumbPrivacyPolicy>" breadcrumb
    When User navigates back to the page
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    When User click on "terms-of-use" using "id"
    Then User verify "Terms Of Use" landing page with "<breadcrumbTermsOfUse>" breadcrumb


    @qa
    Examples:
      | breadcrumbPrivacyPolicy | breadcrumbTermsOfUse |
      | Home>Privacy Policy     | Home>Terms Of Use    |


  Scenario Outline: Verify the "opt-in" button should be active when the user updates the "Email ID" and "privacy & terms conditions"
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    When User enter "<email>" value in "Enter your email" input field
    And User click on "privacy-policy-checkbox" Input field using "id"
    Then User validate "Opt-in Now" web button is enabled

    @qa
    Examples:
      | email |
      | hunkbeast789@gmail.com |

  @smoke
  Scenario: Verify page should be redirected to today’s newsletter screen/page when the user clicks on the "read today’s newsletter section"
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "Healthzine" displayed in secondary nav bar
    When I click on the "Healthzine" option in secondary nav bar
    Then User validate "Healthzine for free" text displayed on webPage
    Then User validate "Read Today’s Healthzine Now" text displayed on webPage
    When User clicks on Read Today’s Healthzine Now
    Then User should be redirected to today’s newsletter screen


  Scenario Outline: Verify the categories should be displayed in alphabetical order when the user clicks on the Categories section
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on "Categories" title from secondaryNavBar
    And User accepts coookies pop up box
    Then User verify Categories landing page with "<breadcrumb>" breadcrumb
    Then User verify categories are displayed in alphabetical order

    @qa
    Examples:
      | breadcrumb |
      | Home>All Categories |


  Scenario: Verify the page should be redirected to the respective platform page when the user clicks on the social media icon from the footer
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    Then User validate following social media links
    | Instagram | Linkedin | Youtube | X |



  Scenario: Verify the page  should be redirected to the respective details screen when the user clicks on the below options from the footer
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    Then User validate following footer links are displayed
      | About Us | Contact Us | Privacy Policy | Editorial Policy | Careers | Corporate Wellness | FAQ’s | Leadership | Investors | Advertising Policy | Magazine Feedback | Cancellation and Refund Policy | Terms Of Use | Shipping Policy | Unsubscribe | Feedback |
    Then User validate all footer links landing page


  Scenario: Verify page should be redirected to the "newsletter" unsubscribe page when the user clicks on the "newsletter unsubscribe" screen
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    And User click on "Unsubscribe" from footer links
    Then User validate "UnSubscribe Page" text displayed on webPage


  Scenario: Verify the feedback popup should display with "fill name", "Email ID" and "message" mandatory fields when the user clicks on the "feedback" option from the footer
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    And User click on "Feedback" from footer links
    Then User validate "Name" text displayed on webPage
    Then User validate "Email" text displayed on webPage
    Then User validate "Message" text displayed on webPage
    Then User validate "Please Enter Your Name" inputBox displayed on webPage
    Then User validate "Please Enter Your Email" inputBox displayed on webPage
    Then User validate "Please Enter Your Message" inputBox displayed on webPage

  @smoke
  Scenario Outline: Verify the page should be redirected to the "Magazine Feedback" page and the user can fill the records when the user clicks on the "magazine feedback" option
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to bottom of page
    And User click on "Magazine Feedback" from footer links
    And User accepts coookies pop up box
    Then User verify "Magazine Feedback" landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Home>Magazine Feedback |


  Scenario: Validate, user can switch to any other language.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify language switch icon is displayed
    Then User click on language switch icon
    Then User validate "Switch to your preferred language site" text displayed on webPage
    Then User verify following languages is displayed
    | ENGLISH | हिन्दी | বাংলা | ಕನ್ನಡ | తెలుగు | മലയാളം | ગુજરાતી | मराठी | தமிழ் |

  @smoke
  Scenario: Verify the chat box should open with a prefilled suggestion related to enquiry when the user clicks on the "chatbot" icon
    Given User has launched HHEvolution URL in Desktop view
    Then User verify chatbot icon is displayed
    And User click on chatbot icon
    Then User validate "Type your query here" inputBox displayed on webPage


  Scenario: Validate, a pop-up should be shown to the users for login/signup section, when user clicks on profile icon.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify profile icon is displayed
    When User clicks on profile section
    Then User verify Login Signup page


  Scenario Outline: Verify the page should be redirected to the details screen of that particular my story when user click on the image in "My Story" card
    Given User has launched HHEvolution URL in Desktop view
    When User stores image src, title and  description of My Story card
    When User clicks on the image in My Story card
    Then User verify My Story Detail page with "<breadcrumb>"

    @qa
    Examples:
      | breadcrumb |
      | Testimonials |
  @smoke
  Scenario Outline: Validate, user is redirected to the “My Story” landing page when clicked on View All button in the header section.
    Given User has launched HHEvolution URL in Desktop view
    Then User validate "My Story" text displayed on webPage
    When User scroll to "My Story" text
    And User clicks on "My Story" view all
    Then User verify "Testimonials" landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Testimonials |

  @smoke
  Scenario: Validate, title is displayed in the header of the “Poll” section.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User validate "Polls" text displayed on webPage
    Then User verify Poll title in the header of the Poll section.

  @smoke
  Scenario: Validate, in the home page “Polls” section is present.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Poll Section is displayed

  @smoke
  Scenario Outline: Validate, user is redirected to the “Quiz” landing page when clicked on View All button in the header section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Quiz section is displayed
    When User clicks on "Quiz" view all
    Then User verify quiz landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Home>Quiz> |

  @smoke
  Scenario: Validate, “View All” button is displayed in the header of the “Quiz” section.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Quiz" text
    Then User verify Quiz section is displayed
    Then User verify Quiz title in the header of the Quiz section.
    Then User verify View All button in the header of the "Quiz" section.

  @smoke
  Scenario Outline: Validate, user is redirected to the “Web Stories” landing page when clicked on View All button in the header section.
    Given User has launched HHEvolution URL in Desktop view
    Then User validate all the web stories are listed below the “Web Stories” section.
    Then User verify Web Stories section is displayed
    Then User verify View All button in the header of the "Web Stories" section.
    When User clicks on "Web Stories" view all
    Then User verify "Web Stories" landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Webstories |

  @smoke
  Scenario: Validate, “View All” button is displayed in the header of the “Web Stories” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify “Web Stories” title in the header of the “Web Stories” section.
    Then User verify View All button in the header of the "Web Stories" section.

  @smoke
  Scenario: Validate, title is displayed in the header of the “Web Stories” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify “Web Stories” title in the header of the “Web Stories” section.

  @smoke
  Scenario: Validate, in the home page “Web Stories” section is present.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed

  @smoke
  Scenario Outline: Validate, user is redirected to the “Editor’s pick” landing page when clicked on View All button in the header section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify View All button in the header of the "Editor's Pick" section.
    When User clicks on "Editor's Pick" view all
    Then User verify editor peak landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Home>Editor’s Pick |

  @smoke
  Scenario: Validate, “View All” button is displayed in the header of the “Editor’s pick” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify View All button in the header of the "Editor's Pick" section.

  @smoke
  Scenario: Validate, title is displayed in the header of the “Editor’s pick” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify Editor’s pick title in the header of the Editor’s pick section.

  @smoke
  Scenario: Validate, in the home page “Editor’s pick” section is present.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed


  Scenario: Verify the web stories should be displayed with the icon representing slides in the "web stories" detailed page
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify Web Stories are displayed
    When User click on first web story
    Then User verify Web Story opened in new tab


  Scenario: Verify the "Web Stories" Title should be displayed in the “Web Stories” section.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify Web Story with Title is displayed

  @smoke
  Scenario Outline: Verify the page should be redirected to the Editors pick listing page when the user clicks on the " View All" option
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify 4 editors picks displayed under editors pick section
    Then User verify View All button in the header of the "Editor's Pick" section.
    When User clicks on "Editor's Pick" view all
    Then User verify editor peak landing page with "<breadcrumb>" breadcrumb

    @qa
    Examples:
      | breadcrumb |
      | Pick |

  Scenario: Verify the card should be redirected to the respective detail page when the user clicks on the "Editors pick" card
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify 4 editors picks displayed under editors pick section
    When User click on first editors pick
    Then I see user should be redirected to the 1st link

  Scenario: Verify the latest 4 editors' picks Card should be displayed in the "Editors pick" section
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify 4 editors picks displayed under editors pick section


  Scenario: Verify each "editors pick " card should be displayed with the " title" in the "Editor pick" section
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify 4 editors picks displayed under editors pick section
    Then User verify Title for each content in the editors pick section.

  Scenario: Verify each "editors pick " card should be displayed with the "symbol of content type" on the thumbnail image under the "Editor pick" section
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Editor's Picks section is displayed
    Then User verify 4 editors picks displayed under editors pick section
    Then User verify the tags with symbol of the content type, on the thumbnail images.


  Scenario: Verify the users should be able to see the cover pic of the magazine and description with action button in the defined layout
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    Then User verify Magazine title is displayed
    Then User verify Magazine dot which is beside title is displayed
    Then User verify Magazine date is displayed
    Then User verify Magazine date displayed right to title

  @smoke
  Scenario: Verify the page should be redirected to the login/signup screen to complete the profile registration processt if the logged in user click on the "Buy print" option
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User clicks on "Buy Print" Link using linkName
    Then User verify checkout page is displayed


  Scenario Outline: Verify the page should be redirected to the cart screen to proceed for the payment if the logged in user click on the "Buy print" option
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User navigates to "https://qa.staging.happiesthealth.com/evolution"
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User stores Magazine name
    When User clicks on "Buy Print" Link using linkName
    Then User verify Magazine added to cart message is displayed
    Then User verify "Latest Print Magazine" is displayed in checkout page
    Then User verify View Cart is displayed
    Then User validate "View cart" link displayed on webPage


    @qa
    Examples:
      | email | password |
      | hunkbeast789@gmail.com | Hunk@351 |

  @smoke
  Scenario: Verify the page should be redirected to the login/signup screen to complete the profile registration process if the logged in user click on the "Buy E-mag" option
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User clicks on "Buy E-Mag" Link using linkName
    Then User verify Login Signup page

  @Evolution
  Scenario Outline: Verify the page should be redirected to the cart screen to proceed for the payment if the logged in user click on the "Buy E-mag" option
    Given User has launched HHEvolution URL in Desktop view
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User navigates to "https://qa.staging.happiesthealth.com/evolution"
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User stores Magazine name
    When User clicks on "Buy E-Mag" Link using linkName
    Then User verify Magazine added to cart message is displayed
    Then User verify magazine name in checkout page
    Then User verify View Cart is displayed
    Then User validate "View cart" link displayed on webPage

    @qa
    Examples:
      | email | password |
      | hunkbeast789@gmail.com | Hunk@351 |


  Scenario: Verify the page should be redirected to the magazine landing page where users can find the list of all magazines when user click on the view all button
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User clicks on "Magazine" view all
    Then User verify "Magazine" landing page
    Then User validate "ALL MAGAZINES" text displayed on webPage


  Scenario: Verify the magazine cover pic should be redirected to the preview page of that particular magazine if the user click on the magazine cover pic
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Magazine" displayed to the "below" direction of webelement with xpath "(//article)[1]"
    Then User verify Magazine image is displayed
    When User stores Magazine name
    When User stores the Magazine image
    When User click on Magazine image
    Then User verify magazine is opened

  @smoke
  Scenario: Verify "voting percentage" should be displayed after completion of voting
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    When User scroll to "Polls" text
    Then User verify Poll question is displayed
    Then User verify Poll options are displayed
    Then User verify Poll option radioButtons are displayed
    Then User verify Poll Vote button is disabled by default
    When User click on first option in Poll
    Then User verify Poll Vote button is enabled
    When User clicks on "Vote" button
    Then User verify Poll Options Progress bars is displayed
    Then User verify Poll Options Percent is displayed


  Scenario: Verify vote button should be enable only once the user selects a particular option.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify Poll question is displayed
    Then User verify Poll options are displayed
    Then User verify Poll Vote button is disabled by default
    When User click on first option in Poll
    Then User verify Poll Vote button is enabled


  Scenario: Verify, “Vote” button is present in the poll section.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify Poll question is displayed
    Then User verify Poll Vote button is displayed


  Scenario: Verify, Users should be able to select only one option for the poll.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify Poll question is displayed
    When User click on first option in Poll
    Then User verify first option is selected
    When User click on second option in Poll
    Then User verify second option is selected
    Then User verify first option is deselected


  Scenario: Verify "Questions" with options and "vote" button should be displayed in the poll section
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify Poll question is displayed
    Then User verify Poll options are displayed
    Then User verify Poll Options are displayed below the question
    Then User verify Poll Vote button is disabled by default


  Scenario: Verify poll section should be displayed with the image and question for the poll.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify Poll question is displayed
    Then User verify Poll Question with image is displayed

  @smoke
  Scenario: Verify the poll section should be displayed below the health champion and my story section.
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Polls" text
    Then User verify "Polls" displayed to the "below" direction of "Health Champion" title
    Then User verify "Polls" displayed to the "below" direction of "My Story" title


  Scenario: Verify the Users should be able to scroll right and left to view all 6 web stories displayed under the “Web Stories” section on the home page.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify 6 WebStories are displayed at first view
    When User scroll on WebStory from right to left
    Then User verify the 6th webStory


  Scenario: Verify the maximum 6 latest web stories should be displayed under the “Web Stories” section on the home page.
    Given User has launched HHEvolution URL in Desktop view
    Then User verify Web Stories section is displayed
    Then User verify maximum 6 WebStories are there

  @smoke
  Scenario Outline: Verify the user should be able to register the summit by clicking on the register now button
    Given User has launched HHEvolution URL in Desktop view
    When User scroll to "Summits" text
    Then User verify "Summits" displayed to the "below" direction of "Web Stories" title
    Then User verify "Summits" displayed to the "right" direction of "Corporate Wellness" title
    Then User validate "Upcoming Summits" button displayed on webPage
    Then User verify Summit under Upcoming Summits is displayed
    When User store the Upcoming summit name
    And User clicks on "Register Now" Link using linkName
    Then User verify the name of summit
    Then User validate "Registration Now" text displayed on webPage
    When User click on "Registration Now" text
    Then User validate "First Name" text displayed on webPage
    Then User validate "Last Name" text displayed on webPage
    Then User validate "Email" text displayed on webPage
    Then User validate "Phone" text displayed on webPage
    Then User validate "Quantity" text displayed on webPage
    When User enter "<firstName>" value in "form-field-name" input field
    When User enter "<lastName>" value in "form-field-lastname" input field
    When User enter "<email>" value in "form-field-emailRegister" input field
    When User enter "<phone>" value in "form-field-field_415e4b6" input field
    Then User validate "Register" text displayed on webPage
    When User click on "Register" text
    Then User verify View cart link is displayed


    Examples:
    | firstName | lastName | email | phone |
    | Akshay    | Sharma   | hunkbeast789@gmail.com | 8319139310 |

    







