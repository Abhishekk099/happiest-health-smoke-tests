@AAT @Editor @regression
Feature: Ask An Expert

  @smoke
  Scenario Outline:Verify visitor can publish a query through global login
                    then Editor can Assign the query to Moderator
                    then Moderator can add response for the query
                    then Editor can approve response added by to Moderator and publish it
                    then Verify answered query is available visitors my query section

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup
    And User Verify Success message is displayed

    # Verify answered query is available visitors my query section
    Given User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And User clicks on MyQueries tab
    And User verify "<query>" with answer is available

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

#    @stg3
#    Examples:
#      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
#      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|

  Scenario Outline:  Verify visitor able to post a query post login
  then editor can view posted query from open queries tab
  then editor can select assignee  name is self from the open queries list view tab
  when editor can click on assignee link  from the open queries list view tab
  then verify Ediotor can see the query will move to assigned queries tab and able to see assigned name for that query

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

    #then editor can view posted query from open queries tab
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User clicks on Select Assignee for given "<query>"
    And User selects "<editor>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | Moderatoremail | Moderatorpassword |  expert | editor |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline: Verify Editor can add reponse and save draft and Verify filter drafted responses from open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then Verify user is able to see drafted "<query>"


    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Editor can delete drafted response from open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on delete option and able to view delete popup window
    Then User click on  delete option in delete popup window
    Then verify editor able to see response deleted successfully toast message and query remains open query tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Editor can reassign to moderator for drafted response from  open queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    And Verify user gets reassign to moderator poup window
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Edior can add reponse ( without save draft) and submit for review from open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Editor can submit for review drafted responses from  the open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|



  Scenario Outline:Verify Editor can able to add anther expert response from open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can reject query from open queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on Reject Query for the given "<query>"
    Then Verify user can view reject query popup window
    When User select any one reason form Reason dropdown
    When User click on reject query button from reject query popup window
    Then Verify user is able to view query rejected successfully toast message
    And User click on "Rejected Queries" tab from Secondary Menu
    And Verify "<query>" is present in Rejected Queries tab
    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri| Dr. Ananya Puttaraju |



  Scenario Outline:Verify Editor can add reponse and save draft. Verify filter drafted responses from assigned queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then Verify user is able to see drafted "<query>"


    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | Editor | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Tulasi G | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | Editor | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|

  Scenario Outline:Verify Editor can delete drafted response from  assigned queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on delete option and able to view delete popup window
    Then User click on  delete option in delete popup window
    Then verify editor able to see response deleted successfully toast message and query remains open query tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | Editor | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Tulasi G | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | Editor | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|



  Scenario Outline:Verify Editor can reassign to moderator for drafted response from  assigned queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    And Verify user gets reassign to moderator poup window
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G|

  Scenario Outline:Verify Editor can add response (without save draft) and submit for review from the assigned queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G|


  Scenario Outline:Verify Editor can submit for review drafted response from assigned queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G|


  Scenario Outline:Verify Editor can able to add onther expert response from assigned queries
    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    #When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed


    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can reject query from assigned queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on Reject Query for the given "<query>"
    Then Verify user can view reject query popup window
    When User select any one reason form Reason dropdown
    When User click on reject query button from reject query popup window
    Then Verify user is able to view query rejected successfully toast message
    And User click on "Rejected Queries" tab from Secondary Menu
    And Verify "<query>" is present in Rejected Queries tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Ediotor can reassign to onther moderator for reassigned response


    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed


    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    And Verify user gets reassign to moderator poup window
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message
    Then User click on add response for the given "<query>"
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator2>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    When Verify This response has already been reassigned to one moderator warning message in reassign to moderator poup window
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can delete reassigned response from assigned queries
    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed


    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<Editor>" and click on Assign button for "<query>"
    And User click on "Assigned Queries" tab from Secondary Menu
    Then User click on add response for the given "<query>"
    Then User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message
    Then User click on filter in assigned tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on add response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    And Verify user gets reassign to moderator poup window
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message
    Then User click on add response for the given "<query>"
    Then User click on delete option and able to view delete popup window
    Then User selects the Reason value as "Duplicate response"
    Then User Clicks on Proceed Button in delete response confirmation popup
    Then User click on  delete option in delete popup window
    Then verify editor able to see response deleted successfully toast message and query remains open query tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can view under review queries  and publish under review queries

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup
    And User Verify Success message is displayed

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline: Verify Editor can add reponse and save draft. Verify filter drafted responses from under review queries tab
    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    When User clicks on "Save Draft" button
    Then Verify user can see response drafted successfully toast message

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter
    And Select status as drafted
    When User clicks on "APPLY" button
    Then Verify user is able to see drafted "<query>"


    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can delete under review response from  under review queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on delete option and able to view delete popup window
    Then User selects the Reason value as "Duplicate response"
    Then User Clicks on Proceed Button in delete response confirmation popup
    Then User click on  delete option in delete popup window
    Then verify editor able to see response deleted successfully toast message and query remains open query tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Editor can reassign to moderator for drafted response from  under review queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator2>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Edior can view published queries
    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup
    And User Verify Success message is displayed
    And User click on view details for the given "<query>" in published query tab
    And User Verify Query log history is present

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|


  Scenario Outline:Verify Editor can add reponse and save draft and Verify filter drafted responses from published queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

    #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup

    And User Verify Success message is displayed
    When User click on edit repose button in published query tab for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    When User clicks on "Save Draft" button
    Then User click on Back to Published Queries

  # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in published tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then Verify user is able to see drafted "<query>" in published tab

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can delete drafted response from  published queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

    #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup

    And User Verify Success message is displayed
    When User click on edit repose button in published query tab for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    When User clicks on "Save Draft" button
    Then User click on Back to Published Queries

    # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in published tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on edit repose button in published query tab for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on delete option and able to view delete popup window
    Then User click on  delete option in delete popup window
    Then verify editor able to see response deleted successfully toast message and query remains open query tab


    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |


  Scenario Outline:Verify Editor can reassign to moderator for drafted response from published queries tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

    #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User clicks on Select Assignee for given "<query>"
    And User selects "<moderator>" and click on Assign button for "<query>"
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Moderator can add response for the query
    Given User has launched Admin URL
    And User enter "<Moderatoremail>" value in "Email or Username" input field
    And User enter "<Moderatorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on add response for the given "<query>"
    And User clicks on Response textbox And Add Response
    And User clicks on Select "<expert>" in Expert dropdown
    And User clicks on Submit for Review button
    And User clicks on Submit for review button in confirmation popup
    And User Verify Success message is displayed
    And User Logout of the admin portal

  # Verify Editor can approve response added by to Moderator and publish it
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    And User click on "Under Review" tab from Secondary Menu
    And User click on review response for the given "<query>"
    And User clicks on "Publish Response" button
    And User clicks on Publish Response button in confirmation popup

    And User Verify Success message is displayed
    When User click on edit repose button in published query tab for the given "<query>"
    Then verify editor able to view 2nd response list and able add  successfully .
    Then User clicks on 2nd Response textbox And Add Response
    And User clicks on Select "<expert2>" in second Expert dropdown
    When User clicks on "Save Draft" button
    Then User click on Back to Published Queries

    # Verify Editor able to filter drafted queries from open queries list
    Then User click on filter in published tab
    And Select status as drafted
    When User clicks on "APPLY" button
    Then User click on edit repose button in published query tab for the given "<query>"
    Then Verify user can view reassign to moderator and delete options in add response page
    Then User click on reassign to moderator option
    And  User is able to view reassign to moderator popup window
    Then User select  "<moderator2>" name and reasons  in reassign to modeartor popup window
    When User click on proceed button
    When User click on reassign button
    Then Verify editor able to see response reassign to moderator  successfully toast message

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | moderator2 name | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore|Tulasi G| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | moderator2 | Moderatoremail | Moderatorpassword |  expert | Editor | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | Rama Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri|Tulasi G| Dr. Ananya Puttaraju |

  Scenario Outline:Verify Editor can view rejected queries and revert from rejected querires tab

    #Verify visitor can publish a query
    Given User has launched Evolution URL
    When User clicks on profile section
    Then User validate "Sign In" text displayed on webPage
    When User clicks on radio button with "email" name
    And User enter "<email>" value in "Email" input field
    And User enter "<password>" value in "password" input field
    And User clicks on "Sign In" button
    When User has launched Evolution URL
    When Click on Ask An Expert from the primary menu
    And Clicks on Post a Query button
    And User selects speciality in Choose a Specialty dropdown
    And User Enters "<query>" in textbox
    And User clicks on Submit Query button
    And Verify post success popup is displayed

  #Verify Editor can Assign the query to Moderator
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    And User click on Ask an Expert tab
    Then User click on Reject Query for the given "<query>"
    Then Verify user can view reject query popup window
    When User select any one reason form Reason dropdown
    When User click on reject query button from reject query popup window
    Then Verify user is able to view query rejected successfully toast message
    And User click on "Rejected Queries" tab from Secondary Menu
    And Verify "<query>" is present in Rejected Queries tab
    When User click on revert button for rejected "<query>"
    Then Verify editor can view query reverts successfully toast message and query will move to open queries

    @qa
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |abhishek.kumar10@happiestminds.com|Test@123| This is a test query to be used in automation test execution do not update | sunita.ganiger@happiestminds.com | Suni@769| Automation User1 | abhishek.kumar10@happiestminds.com|Abhi@652|Dr. Akash Dadore| Dr. A Neeru B |

    @stg3
    Examples:
      | email | password | query | Editoremail | Editorpassword | moderator | Moderatoremail | Moderatorpassword |  expert | expert2 |
      |yetine2336@visignal.com|Pes@2023| This is a test query to be used in automation test execution do not update | ramatulasi.gottipati@happiestminds.com|Pes@2023| Ramadevi Pujari | ramadevi.p@happiestminds.com|Pes@2023|Dr. D Gowri| Dr. Ananya Puttaraju |

  @ExpertProfile
  Scenario Outline:Verify Editor is able to save the expert profile
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    When User click on Expert Profiles tab
    Then verify user is navigating to expert profile list view
    When User clicks on ADD EXPERT PROFILE button
    Then User able to see add expert profile page
    And User select title as Dr.
    Then User enter full name and email or mobile number
    And User clicks on "SAVE" button
    Then Verify user is able to view expert details saved Successfully toast message

    @qa
    Examples:
      | Editoremail | Editorpassword |
      | sunita.ganiger@happiestminds.com | Suni@769|
    @stg3
    Examples:
      | Editoremail | Editorpassword |
      | ramatulasi.gottipati@happiestminds.com|Pes@2023|

  @ExpertProfile
  Scenario Outline:Verify Editor is able to edit  the expert profile
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    When User click on Expert Profiles tab
    Then verify user is navigating to expert profile list view
    When User clicks on ADD EXPERT PROFILE button
    Then User able to see add expert profile page
    And User select title as Dr.
    Then User enter full name and email or mobile number
    And User Enters About data
    And User enters Location data
    Then User Adds Registration Number and Council
    Then User enters Hospital data
    Then User selects speciality in Choose a Specialty dropdown
    And User Adds Start Date and End Date value
    And User Adds Document Type and Name
    And User Upload file supporting Affiliation Details
    And User adds description and click on add button
    And User clicks on "SUBMIT" button
    When User click on Expert Profiles tab
    When User click on action button for saved user
    And User clicks on Edit Profile
    And User verify edit expert profile page is loaded

    @qa
    Examples:
      | Editoremail | Editorpassword |
      | sunita.ganiger@happiestminds.com | Suni@769|
    @stg3
    Examples:
      | Editoremail | Editorpassword |
      | ramatulasi.gottipati@happiestminds.com|Pes@2023|

  @ExpertProfile
  Scenario Outline:Verify Editor is able to submit  the expert profile
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    When User click on Expert Profiles tab
    Then verify user is navigating to expert profile list view
    When User clicks on ADD EXPERT PROFILE button
    Then User able to see add expert profile page
    And User select title as Dr.
    Then User enter full name and email or mobile number
    And User Enters About data
    And User enters Location data
    Then User Adds Registration Number and Council
    Then User enters Hospital data
    Then User selects speciality in Choose a Specialty dropdown
    And User Adds Start Date and End Date value
    And User Adds Document Type and Name
    And User Upload file supporting Affiliation Details
    And User adds description and click on add button
    And User clicks on "SUBMIT" button

    @qa
    Examples:
      | Editoremail | Editorpassword |
      | sunita.ganiger@happiestminds.com | Suni@769|
    @stg3
    Examples:
      | Editoremail | Editorpassword |
      | ramatulasi.gottipati@happiestminds.com|Pes@2023|

  @ExpertProfile
  Scenario Outline:Verify Editor is able to view  the expert profile
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    When User click on Expert Profiles tab
    Then verify user is navigating to expert profile list view
    When User clicks on ADD EXPERT PROFILE button
    Then User able to see add expert profile page
    And User select title as Dr.
    Then User enter full name and email or mobile number
    And User Enters About data
    And User enters Location data
    Then User Adds Registration Number and Council
    Then User enters Hospital data
    Then User selects speciality in Choose a Specialty dropdown
    And User Adds Start Date and End Date value
    And User Adds Document Type and Name
    And User Upload file supporting Affiliation Details
    And User adds description and click on add button
    And User clicks on "SUBMIT" button
    When User click on Expert Profiles tab
    When User click on action button for saved user
    And User clicks on View Profile
    And User verify Profile detail page is displayed

    @qa
    Examples:
      | Editoremail | Editorpassword |
      | sunita.ganiger@happiestminds.com | Suni@769|
    @stg3
    Examples:
      | Editoremail | Editorpassword |
      | ramatulasi.gottipati@happiestminds.com|Pes@2023|

  @ExpertProfile
  Scenario Outline:Verify Editor can able to deactivate the expert profile
    Given User has launched Admin URL
    And User enter "<Editoremail>" value in "Email or Username" input field
    And User enter "<Editorpassword>" value in "password" input field
    And User clicks on "Login" button
    When User click on Expert Profiles tab
    Then verify user is navigating to expert profile list view
    When User clicks on ADD EXPERT PROFILE button
    Then User able to see add expert profile page
    And User select title as Dr.
    Then User enter full name and email or mobile number
    And User Enters About data
    And User enters Location data
    Then User Adds Registration Number and Council
    Then User enters Hospital data
    Then User selects speciality in Choose a Specialty dropdown
    And User Adds Start Date and End Date value
    And User Adds Document Type and Name
    And User Upload file supporting Affiliation Details
    And User adds description and click on add button
    And User clicks on "SUBMIT" button
    When User click on Expert Profiles tab
    When User click on action button for saved user
    And User clicks on Deactivate Profile
    And Verify user is able to view expert profile deactivated Successfully toast message

    @qa
    Examples:
      | Editoremail | Editorpassword |
      | sunita.ganiger@happiestminds.com | Suni@769|
    @stg3
    Examples:
      | Editoremail | Editorpassword |
      | ramatulasi.gottipati@happiestminds.com|Pes@2023|