Feature: Account Page Testing
  As a user of movie website
  when i click on Account button
  i should redirect to Account Page
  and i should see all UI elements present and visible
  and i want to be able logout from my account
  So that i can login again when it need


  Scenario:  Visible UI Elements
    Given I am on the Homepage
    When I click on account button
    Then I should be redirect to account page
    And I should see all UI elements present and visible in account page

  Scenario: Successful Logout
    Given I am on Account page
    When I click on Logout button
    Then I should redirect to Login page





