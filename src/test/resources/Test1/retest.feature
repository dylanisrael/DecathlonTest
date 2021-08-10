#Feature: retest automation
#
##  @non-reg @auth
##  Scenario: Error 404
##    Given I navigate to home page
##    When  I click on login button
##    Then Im on login page
##
##  @Test
##  Scenario: Fait le logging avec de mauvais credentials
##
##    Given I navigate to home page
##    When  I click on login button
##    And I login with "mailto@provider.tld" and with random password
##    Then I should be able to see an error Message