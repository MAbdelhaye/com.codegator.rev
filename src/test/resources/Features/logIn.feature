#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login with a valid credentils

  @Somketest
  Scenario Outline: 
    Given I open chrome browser
    And I visit the url
    And I enter a "<username>" valid username
    And I enter a "<password>" valid password
    When I click on login
    Then I should see the dashboard
    And I click on "Accounts" tab
    And I click on "New" button
    Then I should see the bellow values in the "acc9" field
      | --None-- |
      | Hot      |
      | Warm     |
      | Cold     |

    Examples: 
      | username                 | password |
      | batch07@codegator.com.qa | Welcome1 |
