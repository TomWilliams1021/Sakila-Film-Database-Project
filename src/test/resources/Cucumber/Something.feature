Feature: There's an entry to add
  Scenario: Add a language
    Given We have a language entry to add
    When We add the language entry
    Then The language should be added and we should return that the new language was saved