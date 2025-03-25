@cms @How-ToGuides
Feature: How-To Guides Validation

  @How-ToGuidesEndToEndValidation @SelfHostedVideo
  Scenario Outline: Verify user is able Create and Publish HowToGuides with Self Hosted Video
    Given User has launched CMS URL
    And User enter "<username>" value in "log" input field
    And User enter "<password>" value in "pwd" input field
    And User click on "wp-submit" using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Infographic Cards>" Link is displayed
    And User clicks on "<Infographic Cards>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on "<Infographic Cards>" Add New Post
    Then User enters "<Title>" into Add Title
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User clicks on radio button with "Yes" text using "Show on Homepage" label
    And User clicks on "Add to gallery" link with "Gallery" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    And User clicks on "Add to gallery" link with "Premium Image" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    Then User validate "Show Video instead of image" text displayed on webPage
    And User clicks on checkbox with "Show Video instead of image" text using "Show Video instead of image" label
    Then User validate "Self Hosted" text displayed on webPage
    Then User validate "Youtube Video" text displayed on webPage
    Then User validate "Youtube Shorts" text displayed on webPage
    And User clicks on radio button with "Self Hosted" text using "Select the Video Option" label
    And User clicks on radio button with "Horizontal" text using "Select Video Dimention" label
    And User enters "<Self Hosted Video url>" in "Self Hosted Video URL" input field
    And User clicks on "Add Image" link with "Add Video Thumbnail" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for Video thumbnail pic
    And User clicks on "Select" button
    And User publishes the Article
    And User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User clicks on "How To…" Link using linkName
    Then User validate img src of first image
    And User click on first image
    Then User validate play button is enabled
    And User click on play button
    Then User validate video src with "<Self Hosted Video url>"
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Infographic Cards>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed


    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | How To | Articles | How-ToBreadcrumb | Infographic Cards | Author | Short Testimonial | Disease Details | Self Hosted Video url|
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | How To… | ARTICLES | Home>How to..> | Infographic Cards | Peter | I am truly blessed to have Swasthya as our health caretakers who at all given times have helped me and my family too feel physically, emotionally good  and well holistically.  Homoeopathy is a Journey and it needed a lot of patience from my side as well as trust. | Lung Infection | https://qa.staging.happiesthealth.com/wp-content/uploads/2024/04/WhatsApp-Video-2024-04-29-at-18.36.28.mp4 |

    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |


  @How-ToGuidesEndToEndValidation @YouTubeVideos
  Scenario Outline: Verify user is able Create and Publish HowToGuides with YouTube Video
    Given User has launched CMS URL
    And User enter "<username>" value in "log" input field
    And User enter "<password>" value in "pwd" input field
    And User click on "wp-submit" using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Infographic Cards>" Link is displayed
    And User clicks on "<Infographic Cards>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on "<Infographic Cards>" Add New Post
    And User Verify "Add new Infographic Card" text is displayed
    Then User enters "<Title>" into Add Title
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User clicks on radio button with "Yes" text using "Show on Homepage" label
    And User clicks on "Add to gallery" link with "Gallery" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    And User clicks on "Add to gallery" link with "Premium Image" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    Then User validate "Show Video instead of image" text displayed on webPage
    And User clicks on checkbox with "Show Video instead of image" text using "Show Video instead of image" label
    Then User validate "Self Hosted" text displayed on webPage
    Then User validate "Youtube Video" text displayed on webPage
    Then User validate "Youtube Shorts" text displayed on webPage
    And User clicks on radio button with "Youtube Video" text using "Select the Video Option" label
    And User enters "<YouTube Video Url>" in "Youtube Video URL" input field
    And User clicks on "Add Image" link with "Add Video Thumbnail" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for Video thumbnail pic
    And User clicks on "Select" button
    And User publishes the Article
    And User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User clicks on "<How To>" Link using linkName
    Then User validate img src of first image
    And User click on first image
    Then User validate play button is enabled
    And User click on play button
    Then User validate video is Youtube video
#    Then User validate video src with "<YouTube Video Url>"
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Infographic Cards>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed

    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | How To | Articles | How-ToBreadcrumb | Infographic Cards | Author | Short Testimonial | Disease Details | YouTube Video Url|
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | How To… | ARTICLES | Home>How to..> | Infographic Cards | Peter | I am truly blessed to have Swasthya as our health caretakers who at all given times have helped me and my family too feel physically, emotionally good  and well holistically.  Homoeopathy is a Journey and it needed a lot of patience from my side as well as trust. | Lung Infection | https://www.youtube.com/watch?v=OpRMRhr0Ycc |

    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |


  @How-ToGuidesEndToEndValidation @YouTubeShorts
  Scenario Outline: Verify user is able Create and Publish HowToGuides with YouTube Shorts
    Given User has launched CMS URL
    And User enter "<username>" value in "log" input field
    And User enter "<password>" value in "pwd" input field
    And User click on "wp-submit" using "id"
    Then User Verify "Dashboard" text is displayed
    Then User Verify "<Infographic Cards>" Link is displayed
    And User clicks on "<Infographic Cards>" link
    Then User Verifies AddNewPost button is clickable
    And User clicks on "<Infographic Cards>" Add New Post
    And User Verify "Add new Infographic Card" text is displayed
    Then User enters "<Title>" into Add Title
    Then User selects "<Category>" checkbox
    And User clicks on "Set featured image" Link using linkName
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for featured image
    And User clicks on "Set featured image" button
    And User clicks on radio button with "Yes" text using "Show on Homepage" label
    And User clicks on "Add to gallery" link with "Gallery" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    And User clicks on "Add to gallery" link with "Premium Image" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for author pic
    And User clicks on "Select" button
    Then User validate "Show Video instead of image" text displayed on webPage
    And User clicks on checkbox with "Show Video instead of image" text using "Show Video instead of image" label
    Then User validate "Self Hosted" text displayed on webPage
    Then User validate "Youtube Video" text displayed on webPage
    Then User validate "Youtube Shorts" text displayed on webPage
    And User clicks on radio button with "Youtube Shorts" text using "Select the Video Option" label
    And User enters "<YouTube Shorts Url>" in "Youtube Shorts Video URL" input field
    And User clicks on "Add Image" link with "Add Video Thumbnail" label
    And User clicks on "Media Library" button
    And User stores and clicks the img url of first image in Media Library for Video thumbnail pic
    And User clicks on "Select" button
    And User publishes the Article
    And User Verify "Post published." text is displayed
    Then User has launched HH URL in new tab
    And User accepts coookies pop up box
    And User clicks on "<How To>" Link using linkName
    Then User validate img src of first image
    And User click on first image
    Then User validate play button is enabled
    And User click on play button
    Then User validate video is YoutubeShorts video
#    Then User validate video src with "<YouTube Shorts Url>"
    And User has launched CMS url in new tab
    When User enters email value as "<username>"
    And User enters password value as "<password>"
    And User clicks on "<Infographic Cards>" link
    And User click on "<Title>" trash button
    Then User Verify "1 post moved to the Trash." text is displayed


    @qa
    Examples:
      | username | password | Title | Content | Excerpt | frameXpath | Category | How To | Articles | How-ToBreadcrumb | Infographic Cards | Author | Short Testimonial | Disease Details | YouTube Shorts Url|
      | abhishek.kumar | o#nsBeXF0xCJmsAU | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | How To… | ARTICLES | Home>How to..> | Infographic Cards | Peter | I am truly blessed to have Swasthya as our health caretakers who at all given times have helped me and my family too feel physically, emotionally good  and well holistically.  Homoeopathy is a Journey and it needed a lot of patience from my side as well as trust. | Lung Infection | https://www.youtube.com/shorts/hvfL_GWMdK0 |

    @dev
    Examples:
      | username | password | Title | Content | DoctorName | DoctorSpeciality | Excerpt | frameXpath | Category | Categories | Articles | categoryArticleBreadcrumb | Testimonials        |
      | abhishek.kumar | jWe1oY6HhuhjZp!Pm@IeHu7y | [Automation] Best Practices in Diet Control | eat at least 5 portions of a variety of fruit and vegetables every day base meals on higher fibre starchy foods like potatoes, bread, rice or pasta. have some dairy or dairy alternatives (such as soya drinks) eat some beans, pulses, fish, eggs, meat and other protein. | Akshay | Heart | A diet is the combination of foods typically eaten by a specific group of people or other organisms. Human diets are determined by nutritional needs, the types of food available in a particular region, and cultural beliefs | (//iframe[contains(@id,'content_ifr')])[1] | Ageing | Categories | ARTICLES | Home>Articles> | Testimonials |


