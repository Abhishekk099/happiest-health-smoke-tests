@cms @HealthTip
Feature: CMS HealthTip  Validation



  @HealthTipEndToEndValidation
  Scenario Outline: Verify user can crete and publish HealthTip from CMS
    Given User has launched CMS URL
    When  User enters email value as "<username>"
    And User enters password value as "<password>"
    Then User Verify "<Health Tip>" Link is displayed
    And User clicks on "<Health Tip>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on AddNewPost link
    And User Verifies "Add new Health Tip" is displayed
    Then User enters "<Title>" into Add Title
    Then User enters "<Content>" into Body
    Then User add Hyperlink "https://www.happiesthealth.com/" in content
    And User clicks on "Set featured image for this Health Tip" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic for "Set featured image for this Health Tip"
    And User clicks on "Set featured image for this Health Tip" button
    And User publishes the Article
    And User clicks on view post link
    Then User Verify "<Title>" Link is displayed
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Health Tip>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed



    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | Categories | Articles | categoryDocTalesBreadcrumb | Health Tip | Speakers | videoLink | time |
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation1] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Testimonials> | Health Tip | akshay.sharma2@happiestminds.com | https://www.youtube.com/watch?v=Ea5KbgVDdWQ | 60 |
    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation1] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |

