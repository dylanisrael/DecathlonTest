@MajorAbnormalities
@severity=critical
Feature: Anomalies Majeures

  @Bug885
    Scenario: Bug 885 Page not available or link outdated
      Given user goes to carte cadeau page
      When Click on Discover under The Personalized Gift Card
      Then The page is available

  @Bug886
    Scenario: Bug 886 Content not displayed
      Given user goes to carte cadeau page
      When Click on Discover e-carte cadeau
      And Click on our privacy policy
      Then text description is visible

  @Bug894
    Scenario: Bug 894 Clicking on an enhanced product opens another product page.
      Given user go to decathlon avis
      When Click on Mp3 Etanche
      Then the products presented are MP3

  @Bug917
    Scenario: Bug 917 Bad redirection
      Given user is on Atelier page
      When user click on sport d'eau
      Then the presentation page of the quechua isothermal boxes and bottles should be displayed

  @Bug949
  Scenario: Bug 949 Image not loaded
    Given user is login
    When user go to preferences -> my sports
    Then all page images are loaded










