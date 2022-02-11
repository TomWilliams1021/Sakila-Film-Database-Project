Feature: There's an entry to add
  Scenario: Add a language
    Given We have a language entry to add
    When We add the language entry
    Then The language should be added and we should return that the new language was saved

  Scenario: Add an Actor
    Given We have a new Actor to add
    When We add the new Actor
    Then The new Actor should be added and a saved conformation returned

  Scenario: Add a Category
    Given We have a new Category to add
    When We add the new Category
    Then The new Category should be added and a saved conformation returned

  Scenario: Add a Film
    Given We have a new Film to add
    When We add the new Film
    Then The new Film should be added and a saved conformation returned