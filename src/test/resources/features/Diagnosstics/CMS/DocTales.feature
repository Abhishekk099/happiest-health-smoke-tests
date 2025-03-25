@cms @DocTales
Feature: Doc Tales Validation

  @docTalesEndToEndValidation
  Scenario Outline: Verify user is able Create and Publish DocTales with Category
    Given User has launched CMS URL
    When  User enters email value as "<username>"
    And User enters password value as "<password>"
#    And User click on "wp-submit" button using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Discussions>" Link is displayed
    And User clicks on "<Discussions>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on AddNewPost link
    And User Verifies "Add new Discussion" is displayed
    Then User enters "<Title>" into Add Title
    Then User enters "<Content>" into Body
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User enters "<Author>" in "Authored By" input field
    And User enters "<Author Subtitle>" in "Author Subtitle" input field
    Then User enters "<DoctorName>" in "Doctor Name" input field
    Then User enters "<DoctorSpeciality>" in "Doctor Specialization" input field
    Then User enters "<Excerpt>" in Expert Text field
    And User publishes the Article
    Then User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User click on "/discussions" link using href attribute
    Then User Verify "<Title>" Link is displayed
    Then User validate img src of image with "<Title>" title
    Then User validate author name "<Author>" with "<Title>" in list screen
    Then User validate author subtitle "<Author Subtitle>" with "<Title>" in list screen
    When User clicks on "<Title>" Link using linkName
    Then User validate "<categoryDocTalesBreadcrumb>" breadcrumb with "<Category>" category and "<Title>" title
    Then User Verify "<Title>" text is displayed
#    Then User Verify "<Content>" text is displayed
    Then User Verify "<Excerpt>" text is displayed
    Then User validate date
    Then User validate "<Author>" author
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Discussions>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed


    @qa
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryDocTalesBreadcrumb | Discussions        | Author | Author Subtitle |
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Dr Amit | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Doc Tales> | Discussions | Akshay | Heart Specialist |
    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Discussions        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Discussions |


