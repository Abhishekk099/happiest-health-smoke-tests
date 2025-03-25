@EvolutionMobile
Feature: Mobile View

  Scenario: Verify the primary navigation bar should display on the bottom with Knowledge, Diagnostics, Ask an Expert, Magazine, and Summits[Mobile]
    Given User has launched HHEvolution URL in mobile view
    Then User validate primary navigation bar items is displayed with items in mobile view
      | Knowledge | Diagnostics | Ask an Expert | Magazine | Careers |


  Scenario: Verify the user should be able to see all options from the secondary navigation bar by scrolling to the right[Mobile_View]
    Given User has launched HHEvolution URL in mobile view
    Then User validate secondary nav bar items by scrolling in secondary nav bar
      | What's New | Categories | Videos | Podcasts | Health Champions | How To... |  Doc Tales | Healthzine | Summits | Programmes |


  Scenario: Verify the "knowledge", "diagnostics", "ask an expert", "Magazine" and "summit" options will be sticky navigation bar below in the mobile view[Mobile View]
    Given User has launched HHEvolution URL in mobile view
    Then User validate primary navigation bar items is displayed with items in mobile view
      | Knowledge | Diagnostics | Ask an Expert | Magazine | Careers |
    Then User verify primary nav bar is sticky in bottom of screen
    Then User verify Knowledge section highlighted by default


  Scenario: Verify web stories are displayed by scrolling in Web Stories section
    Given User has launched HHEvolution URL in mobile view
    When User scroll to "Web Stories" text
    Then User verify Web Stories section is displayed
    Then User validate Web Stories by scrolling in Web Stories section


  Scenario: Verify the latest 3 editors' picks Card should be displayed in the "Editors pick" section
    Given User has launched HHEvolution URL in mobile view
    Then User verify Editor's Picks section is displayed
    Then User verify max 3 contents under the editor's pick section.


  Scenario: Verify the Editor picks Title should displayed with maximum 2 lines
    Given User has launched HHEvolution URL in mobile view
    Then User verify Editor's Picks section is displayed
    Then User verify max 3 contents under the editor's pick section.
    Then User verify Title for each content in the editors pick section in mobile view.
    Then User verify Title for each content in the editors pick section is displayed in max 2 lines

  Scenario: Verify the "view all"option should be displayed in the editors pick section.
    Given User has launched HHEvolution URL in mobile view
    Then User verify Editor's Picks section is displayed
    Then User verify View All button in the header of the "Editor's Pick" section.






