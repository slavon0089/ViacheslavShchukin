Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given today is Sunday
    When  I ask whether it's Friday yet
    And Some text
    Then I should be told Nope
