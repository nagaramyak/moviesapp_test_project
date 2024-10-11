Feature: Testing Movie Details Page
  As a user of movie page
  when i click on any movie in home page
  then i should able to see all the UI elements present in it
  when i click on any movie in popular page
  then i should able to see all the UI elements present in it
  so i can login again when it need

  Scenario: Movie UI elements in Home Page
    Given I am on Home Page of movie website
    When I click on any movie in Home page
    Then I should see the all UI elements present in it

  Scenario: Movie UI elements in Popular Page
    Given I am on Popular Page of movie website
    When I click on any movie in Popular Page
    Then I should see the all UI elements present in it

