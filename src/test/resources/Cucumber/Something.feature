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


  Scenario: Get Categorys
    Given There are categorys available
    When The categorys are requested
    Then All available categorys should be returned

  Scenario: Get Films
    Given There are films available
    When The films are requested
    Then All available films should be returned

  Scenario: Get actors
    Given There are actors available
    When The actors are requested
    Then All available actors should be returned

  Scenario: Get Languages
    Given There are languages available
    When The languages are requested
    Then All available languages should be returned


  Scenario: Get specific Film
    Given There are films available to select from
    When The user requests a specific film
    Then The specified film will be returned

  Scenario: Delete a film category
    Given There are categorys to select from
    When A category is selected for deletion
    Then The category should be deleted
