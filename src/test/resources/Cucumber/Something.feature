Feature: Is the language Spanish?
  People want to know if it's Spanish
  Scenario: Language is not Spanish
    Given I have chosen a film
    When I ask if language is "Spanish"
    Then I should be told "No"

