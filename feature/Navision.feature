Feature: Login to the Navision application and enter 5 rows into Navision from a datasheet

  Background: 
    Given launch an application URL

  Scenario: Enter 5 rows into Navision from a datasheet.
    Given I should see Home Page
    And I validate current tab UK
    Then I navigate to navision page
    And I validate navision page
    Then I click link Activity Card
    And I enter data into navision page
