Feature: Make some changes on website?
  User Table Page test

  Scenario: User Table Page test
    Given I open website
    And title equals Home Page
    When I login as user Roman Iovlev
    And username is displayed and equals
    Then I open Different Elements Page
    And I select checkboxes Water and Wind
    And I select radiobutton Selen
    And select dropdown Yellow
    And logs are displayed

