@cms @Articles
Feature: Article Page Validation

  @articleEndToEndValidation
  Scenario Outline: Verify user is able Create and Publish Article with category
    Given User has launched CMS URL
    When  User enters email value as "<username>"
    And User enters password value as "<password>"
    Then User Verify dashboard field is displayed
    Then User Verify Article Link is displayed
    And User clicks on article link
    Then User Verifies AddNewPost button is clickable
    And User clicks on AddNewPost link
    And User Verifies "Add new Article" is displayed
    Then User enters "<Title>" into Add Title
    Then User enters "<Content>" into Body
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    Then User enters "<Author>" in "Article By" input field
	Then User enters "<Contributor>" in "Contributor Name" input field
    And User verifies "Hide Contributor Information" checkbox is selectable
   # Then User selects "<RelatedPost>" in Select Related Posts field
    Then User enters "Automation Summit Form Title" in "Summit Form Title" input field
    Then User enters "Automation Button Name" in "Summit Form Button Name" input field
    Then User enters "Automation Article Wellness Registration Form Title" in "Article Wellness Registration Form Title" input field
    Then User enters "Automation Wellness Submit Button Text" in "Wellness Submit Button Text" input field
    Then User enters Add Image link for "Wellness Registration Banner Image"
    And User stores and clicks the img url of first image in Media Library for select image
    And User clicks on "Select" button
    And User selects "Show this on Category Hero Section" checkbox in CMS page
    Then User enters "<Excerpt>" in Expert Text field
    And User publishes the Article
    Then User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
#    And User accepts coookies pop up box
    And User clicks on "Categories" title from secondaryNavBar
#    And User clicks on "<Categories>" Link using linkName
    And User click on "<Category>" text
    And User click on "Articles" text
#    And User clicks on "<Articles>" Link using linkName
    Then User Verify article with article name "<Title>" is displayed
#    Then User validate author name "<Author>" with "<Title>" in list screen
#    Then User validate img src of image with "<Title>" title
    When User clicks on article with article name "<Title>"
    Then User validate "<categoryArticleBreadcrumb>" breadcrumb with "<Category>" category and "<Title>" title
    Then User Verify Article "<Title>" title is displayed
    Then User Verify Article "<Content>" content is displayed
    Then User Verify Article "<Excerpt>" excerpt is displayed
    Then User validate date
    Then User validate "<Author>" author
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on article link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed

    @qa
    Examples:
      | username | password | Title | Content | Author | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb |
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> |

#    @dev
#    Examples:
#      | username  | password | Title | Content | Author | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb |
#      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day (see 5 A Day) base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | CATEGORIES | ARTICLES | Home>Articles> |




