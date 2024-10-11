Feature: Login Functionality
  As a user of movie website
  I want to be able to login to my account
  So that I can view my details


  Scenario: All UI Elements Display
    Given I am on the login page for account
    Then I should see the Website logo image
    And the Heading Text Should be 'Login'
    And the username label text Should Be 'USERNAME'
    And the password label text Should Be 'PASSWORD'
    And I should see the login button



  Scenario: Login with empty input fields

    Given I am on the login page for account
    When I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty Username field

    Given I am on the login page for account
    When I enter a valid password
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty password field

    Given I am on the login page for account
    When I enter a valid username
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with invalid inputs

    Given I am on the login page for account
    When I enter a valid username
    And I enter an invalid password
    And I click on the login button
    Then an error message '*username and password didn't match' should be visible

  Scenario: Successful Login

    Given I am on the login page for account
    When I enter a valid username
    And I enter a valid password
    And I click on the login button
    Then I should be redirected to the homepage