Feature: Testing Search Page
  As a user of movie page
  when i enter valid movie name
  and search
  then i should able to see related movies
  when i enter invalid movie name
  and search
  then i should able to see error image and text
  so that i can login when it need

  Scenario: Search Page Navigation
    Given I am on home page of account
    When I click on search bar
    Then I Should navigate to Search page

    Scenario: Search with valid movie name
      Given I am on Search Page
      When I enter valid movie name
      And I click on search button
      Then I should see the movies related to movie name

  Scenario: Search with Invalid movie name
    Given I am on Search Page
    When I enter invalid movie name
    And I click on search button
    Then I should see the error image and text