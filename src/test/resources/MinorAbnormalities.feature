@MinorAbnormalities
@severity=minor
Feature: Annomalies mineures

  @Bug882
  Scenario: Bug 882 Non-functional links
    Given user is on mode de livraison page
    When user Clicks on the different links in the table
    Then user is on a new page

  @Bug888
  Scenario: Bug 888 Page not available
    Given user is on moyen de paiement page
    When user clicks on carte illicado
    And user clicks on en savoir +
    Then more informations about the illicado card are displayed

  @Bug916
  Scenario: Bug 916 Link to an error page
    Given user is on camping bivouac, boire et manger
    When user clicks on isothermals quechua boxes and bottles
    Then A boxes and bottles related page is displayed

  @Bug920
  Scenario: Bug 920 Link to an error page
    Given user select material club in table tennis sport
    When user clicks on the cleanser
    Then A page with cleanser is displayed

  @Bug934
  Scenario: Bug 934 Bad redirection
    Given user is on bike lock page
    When user clicks on see more link
    And user clicks on decathlon.ch link
    Then A decathlon.ch related page is displayed

  @Bug936
  Scenario:  Bug 936 No page or obsolete link
    Given user is on bike stem page
    When user clicks on see more link
    And user clicks on ireland link
    Then An ireland related page is displayed

  @Bug938
  Scenario: Bug 938 No page or obsolete link
    Given user select trout fishing in sport page -> canned fishing
    When user clicks on fake cane
    And user clicks on the bombshell
    Then A bombshell related page is displayed

  @Bug941
  Scenario:  Bug 941 No page or obsolete link
    Given user select material club in table tennis sport
    When user clicks on a ball
    Then A ball related page is displayed

  @Bug955
    Scenario: Bug 955 Unorganized page
      Given user is on coolers and food boxes and clicks on "5 to 11 hours"
      Then A structured page with well positioned elements is displayed

















