Feature: Testing Home Page
  As a user of movie page
  i should able to see the all headings of each section
  and i should able to see play button
  and i should able to see all the movies in movies section
  and i should able to see contact us section
  so that i can login when it need

  Scenario: Home page Testing
    Given I am on Home page
    Then I should see the headings of each section
    And I should see the play button
    And I should see the movies in movies section
    And I should see the contact us section