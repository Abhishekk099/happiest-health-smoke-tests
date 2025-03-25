@cms @Webinars
Feature: Webinars Validation

  @RecordedWebinarsEndToEndValidation
  Scenario Outline: Verify user is able Create and Publish Recorded Webinar
    Given User has launched CMS URL
    When  User enters email value as "<username>"
    And User enters password value as "<password>"
#    And User click on "wp-submit" button using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Recorded Webinars>" Link is displayed
    And User clicks on "<Recorded Webinars>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on AddNewPost link
    And User Verify "Add new Recorded Webinar" text is displayed
    Then User enters "<Title>" into Add Title
    Then User enters "<Content>" into Body
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User checks if image warning comes then again select another image
    And User clicks on "Add Image" link of "Speaker Photo" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    And User clicks on "Starting Date and Time" input field
    And User selects date month year in "d" "MMM" "YYYY" format and time value "12 pm" from date picker
    And User stores data of "Starting Date and Time" input field
    And User clicks on "Done" button
    And User clicks on "Webinar Ending Time" input field
    And User selects date month year in "d" "mmm" "yyyy" format and time value "1 pm" from date picker
    And User stores data of "Webinar Ending Time" input field
    And User clicks on "Done" button
    And User enters "<videoLink>" in "Video URL" input field
    And User enters "<time>" in "Time Required" input field
    And User enters values in "Speakers" input field
      | akshay.sharma2@happiestminds.com |
    And User enters values in "Webinar Speakers" input field
      | Dr Amrish Mithal |
      | Dr Anoop Misra |
    Then User enters "<Excerpt>" in Expert Text field
    And User publishes the Article
    And User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User clicks on "Webinars" Link using linkName
    And User click on "RECORDED" text
    Then User Verify "<Title>" Link is displayed
    Then User validate img src of image with "<Title>" title for webinar and video
    When User clicks on "<Title>" Link using linkName
    Then User validate "<categoryDocTalesBreadcrumb>" breadcrumb with "<Category>" category and "<Title>" title
    Then User Verify "<Title>" text is displayed
#    Then User Verify "<Content>" text is displayed
    Then User Verify "<Excerpt>" text is displayed
    Then User validate date
#    Then User validate "<Author>" author
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Recorded Webinars>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed

    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | Categories | Articles | categoryDocTalesBreadcrumb | Recorded Webinars | Speakers | videoLink | time |
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Webinars>Recorded> | Recorded Webinars | akshay.sharma2@happiestminds.com | https://www.youtube.com/watch?v=Ea5KbgVDdWQ | 60 |
    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |

