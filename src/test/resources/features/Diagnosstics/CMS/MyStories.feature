@cms @MyStories
Feature: My Stories Validation

  @myStoriesEndToEndValidation
  Scenario Outline: Verify user is able Create and Publish MyStory with Category
    Given User has launched CMS URL
    When  User enters email value as "<username>"
    And User enters password value as "<password>"
#    And User click on "wp-submit" button using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Testimonials>" Link is displayed
    And User clicks on "<Testimonials>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on AddNewPost link
    And User Verify "Add new Testimonial" text is displayed
    Then User enters "<Title>" into Add Title
    Then User enters "<Content>" into Body
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User enters "<Author>" in "Author Name" input field
    And User clicks on "Add Image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    Then User enters "<Short Testimonial>" in "Short Testimonial" textarea field
    And User enters "<Disease Details>" in "Disease Details" input field
    Then User enters "<Excerpt>" in Expert Text field
    And User publishes the Article
    And User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User click on "/testimonials" link using href attribute
    Then User Verify "<Title>" Link is displayed
    Then User validate img src of image with "<Title>" title
    When User clicks on "<Title>" Link using linkName
    Then User validate "<categoryMyStoryBreadcrumb>" breadcrumb with "<Category>" category and "<Title>" title
    Then User Verify "<Title>" text is displayed
    Then User Verify "<Content>" text is displayed
    Then User Verify "<Excerpt>" text is displayed
    Then User validate date
    Then User validate "<Author>" author
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Testimonials>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed


    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | Categories | Articles | categoryMyStoryBreadcrumb | Testimonials        | Author | Short Testimonial | Disease Details |
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Testimonials> | Testimonials | Peter | I am truly blessed to have Swasthya as our health caretakers who at all given times have helped me and my family too feel physically, emotionally good  and well holistically.  Homoeopathy is a Journey and it needed a lot of patience from my side as well as trust. | Lung Infection |

    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |


