Feature: Testing Header Section
  As a user of movie website
  i should able to see the website logo
  and all the navbar elements
  and i should able to navigation to all the corresponded pages
  so that i can login when it need

  Scenario: Testing WebSite Logo
    Given I am on the login page
    When I enter valid username
    And I enter valid password
    And I click on login button
    Then I should see the website logo
    And I should see all the navbar elements

  Scenario: Testing Home Page Navigation
    Given I am on Home Page
    When I click on Home navbar Element
    Then I should navigate to Home Page

  Scenario: Testing Popular Page Navigation
    Given I am on Home Page
    When I click on Popular navbar Element
    Then I should navigate to Popular Page

  Scenario: Testing Account Page Navigation
    Given I am on Home Page
    When I click on Account Element
    Then I should navigate to Account Page



