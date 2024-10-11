Feature: Testing Popular Page
  As a user of movie page
  when i am on popular page
  i should see the movies
  so that i can login when it need

  Scenario: Popular Page Testing
    Given I am on Home page for account
    When I click on Popular Navbar Element
    Then I should navigate to Popular page
    And I Should see the movies