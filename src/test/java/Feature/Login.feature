Feature: Test Login Feature
  I want to test the login feature

  @Login
  Scenario: Testing Login Feature
    Given I am in NewTours Home Page
    When I enter username
    And password
    And click on Submit
    Then I validate that I am successfully logged in
  